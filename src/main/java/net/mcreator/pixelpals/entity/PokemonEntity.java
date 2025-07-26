package net.mcreator.pixelpals.entity;

import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.neoforged.neoforge.event.EventHooks;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtTargetGoal;
import net.minecraft.world.entity.ai.goal.target.OwnerHurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.FollowOwnerGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.component.DataComponents;

import net.mcreator.pixelpals.procedures.PokemonSadForgiveConditionProcedure;
import net.mcreator.pixelpals.procedures.PokemonRightClickedOnEntityProcedure;
import net.mcreator.pixelpals.procedures.PokemonOnEntityTickUpdateProcedure;
import net.mcreator.pixelpals.procedures.PokemonOnEntityHurtProcedure;
import net.mcreator.pixelpals.procedures.PokemonModelVisualScaleProcedure;
import net.mcreator.pixelpals.procedures.PokemonEntityDiesProcedure;
import net.mcreator.pixelpals.init.PixelPals01ModItems;
import net.mcreator.pixelpals.init.PixelPals01ModEntities;

public class PokemonEntity extends TamableAnimal {
	public static final EntityDataAccessor<Integer> DATA_Level = SynchedEntityData.defineId(PokemonEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_Scale = SynchedEntityData.defineId(PokemonEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<String> DATA_Species = SynchedEntityData.defineId(PokemonEntity.class, EntityDataSerializers.STRING);
	public static final EntityDataAccessor<Integer> DATA_SadTimer = SynchedEntityData.defineId(PokemonEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_Shiny = SynchedEntityData.defineId(PokemonEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_ID = SynchedEntityData.defineId(PokemonEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_Initialized = SynchedEntityData.defineId(PokemonEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<String> DATA_Owner = SynchedEntityData.defineId(PokemonEntity.class, EntityDataSerializers.STRING);

	public PokemonEntity(EntityType<PokemonEntity> type, Level world) {
		super(type, world);
		xpReward = 0;
		setNoAi(false);
		setPersistenceRequired();
		this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(PixelPals01ModItems.PIDGEY_MASK.get()));
	}

	@Override
	protected void defineSynchedData(SynchedEntityData.Builder builder) {
		super.defineSynchedData(builder);
		builder.define(DATA_Level, 1);
		builder.define(DATA_Scale, 2);
		builder.define(DATA_Species, "");
		builder.define(DATA_SadTimer, 0);
		builder.define(DATA_Shiny, 0);
		builder.define(DATA_ID, 0);
		builder.define(DATA_Initialized, 0);
		builder.define(DATA_Owner, "");
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.2, false) {
			@Override
			protected boolean canPerformAttack(LivingEntity entity) {
				return this.isTimeToAttack() && this.mob.distanceToSqr(entity) < (this.mob.getBbWidth() * this.mob.getBbWidth() + entity.getBbWidth()) && this.mob.getSensing().hasLineOfSight(entity);
			}

			@Override
			public boolean canUse() {
				double x = PokemonEntity.this.getX();
				double y = PokemonEntity.this.getY();
				double z = PokemonEntity.this.getZ();
				Entity entity = PokemonEntity.this;
				Level world = PokemonEntity.this.level();
				return super.canUse() && PokemonSadForgiveConditionProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = PokemonEntity.this.getX();
				double y = PokemonEntity.this.getY();
				double z = PokemonEntity.this.getZ();
				Entity entity = PokemonEntity.this;
				Level world = PokemonEntity.this.level();
				return super.canContinueToUse() && PokemonSadForgiveConditionProcedure.execute(entity);
			}

		});
		this.goalSelector.addGoal(2, new RandomStrollGoal(this, 1));
		this.targetSelector.addGoal(3, new HurtByTargetGoal(this) {
			@Override
			public boolean canUse() {
				double x = PokemonEntity.this.getX();
				double y = PokemonEntity.this.getY();
				double z = PokemonEntity.this.getZ();
				Entity entity = PokemonEntity.this;
				Level world = PokemonEntity.this.level();
				return super.canUse() && PokemonSadForgiveConditionProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = PokemonEntity.this.getX();
				double y = PokemonEntity.this.getY();
				double z = PokemonEntity.this.getZ();
				Entity entity = PokemonEntity.this;
				Level world = PokemonEntity.this.level();
				return super.canContinueToUse() && PokemonSadForgiveConditionProcedure.execute(entity);
			}
		});
		this.goalSelector.addGoal(4, new LookAtPlayerGoal(this, PokemonEntity.class, (float) 6));
		this.goalSelector.addGoal(5, new LookAtPlayerGoal(this, Player.class, (float) 6));
		this.goalSelector.addGoal(6, new FollowOwnerGoal(this, 1, (float) 5, (float) 2));
		this.targetSelector.addGoal(7, new OwnerHurtTargetGoal(this) {
			@Override
			public boolean canUse() {
				double x = PokemonEntity.this.getX();
				double y = PokemonEntity.this.getY();
				double z = PokemonEntity.this.getZ();
				Entity entity = PokemonEntity.this;
				Level world = PokemonEntity.this.level();
				return super.canUse() && PokemonSadForgiveConditionProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = PokemonEntity.this.getX();
				double y = PokemonEntity.this.getY();
				double z = PokemonEntity.this.getZ();
				Entity entity = PokemonEntity.this;
				Level world = PokemonEntity.this.level();
				return super.canContinueToUse() && PokemonSadForgiveConditionProcedure.execute(entity);
			}
		});
		this.goalSelector.addGoal(8, new OwnerHurtByTargetGoal(this) {
			@Override
			public boolean canUse() {
				double x = PokemonEntity.this.getX();
				double y = PokemonEntity.this.getY();
				double z = PokemonEntity.this.getZ();
				Entity entity = PokemonEntity.this;
				Level world = PokemonEntity.this.level();
				return super.canUse() && PokemonSadForgiveConditionProcedure.execute(entity);
			}

			@Override
			public boolean canContinueToUse() {
				double x = PokemonEntity.this.getX();
				double y = PokemonEntity.this.getY();
				double z = PokemonEntity.this.getZ();
				Entity entity = PokemonEntity.this;
				Level world = PokemonEntity.this.level();
				return super.canContinueToUse() && PokemonSadForgiveConditionProcedure.execute(entity);
			}
		});
		this.goalSelector.addGoal(9, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(10, new FloatGoal(this));
	}

	@Override
	public boolean removeWhenFarAway(double distanceToClosestPlayer) {
		return false;
	}

	@Override
	public Vec3 getPassengerRidingPosition(Entity entity) {
		return super.getPassengerRidingPosition(entity).add(0, -0.35F, 0);
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("pixel_pals_01:blank"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("pixel_pals_01:blank"));
	}

	@Override
	public boolean hurtServer(ServerLevel level, DamageSource damagesource, float amount) {
		double x = this.getX();
		double y = this.getY();
		double z = this.getZ();
		Level world = this.level();
		Entity entity = this;
		Entity sourceentity = damagesource.getEntity();
		Entity immediatesourceentity = damagesource.getDirectEntity();

		PokemonOnEntityHurtProcedure.execute(world, x, y, z, entity, sourceentity);
		return super.hurtServer(level, damagesource, amount);
	}

	@Override
	public void die(DamageSource source) {
		super.die(source);
		PokemonEntityDiesProcedure.execute(this);
	}

	@Override
	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putInt("DataLevel", this.entityData.get(DATA_Level));
		compound.putInt("DataScale", this.entityData.get(DATA_Scale));
		compound.putString("DataSpecies", this.entityData.get(DATA_Species));
		compound.putInt("DataSadTimer", this.entityData.get(DATA_SadTimer));
		compound.putInt("DataShiny", this.entityData.get(DATA_Shiny));
		compound.putInt("DataID", this.entityData.get(DATA_ID));
		compound.putInt("DataInitialized", this.entityData.get(DATA_Initialized));
		compound.putString("DataOwner", this.entityData.get(DATA_Owner));
	}

	@Override
	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		if (compound.contains("DataLevel"))
			this.entityData.set(DATA_Level, compound.getInt("DataLevel"));
		if (compound.contains("DataScale"))
			this.entityData.set(DATA_Scale, compound.getInt("DataScale"));
		if (compound.contains("DataSpecies"))
			this.entityData.set(DATA_Species, compound.getString("DataSpecies"));
		if (compound.contains("DataSadTimer"))
			this.entityData.set(DATA_SadTimer, compound.getInt("DataSadTimer"));
		if (compound.contains("DataShiny"))
			this.entityData.set(DATA_Shiny, compound.getInt("DataShiny"));
		if (compound.contains("DataID"))
			this.entityData.set(DATA_ID, compound.getInt("DataID"));
		if (compound.contains("DataInitialized"))
			this.entityData.set(DATA_Initialized, compound.getInt("DataInitialized"));
		if (compound.contains("DataOwner"))
			this.entityData.set(DATA_Owner, compound.getString("DataOwner"));
	}

	@Override
	public InteractionResult mobInteract(Player sourceentity, InteractionHand hand) {
		ItemStack itemstack = sourceentity.getItemInHand(hand);
		InteractionResult retval = InteractionResult.SUCCESS;
		Item item = itemstack.getItem();
		if (itemstack.getItem() instanceof SpawnEggItem) {
			retval = super.mobInteract(sourceentity, hand);
		} else if (this.level().isClientSide()) {
			retval = (this.isTame() && this.isOwnedBy(sourceentity) || this.isFood(itemstack)) ? InteractionResult.SUCCESS : InteractionResult.PASS;
		} else {
			if (this.isTame()) {
				if (this.isOwnedBy(sourceentity)) {
					if (this.isFood(itemstack) && this.getHealth() < this.getMaxHealth()) {
						this.usePlayerItem(sourceentity, hand, itemstack);
						FoodProperties foodproperties = itemstack.get(DataComponents.FOOD);
						float nutrition = foodproperties != null ? (float) foodproperties.nutrition() : 1;
						this.heal(nutrition);
						retval = InteractionResult.SUCCESS;
					} else if (this.isFood(itemstack) && this.getHealth() < this.getMaxHealth()) {
						this.usePlayerItem(sourceentity, hand, itemstack);
						this.heal(4);
						retval = InteractionResult.SUCCESS;
					} else {
						retval = super.mobInteract(sourceentity, hand);
					}
				}
			} else if (this.isFood(itemstack)) {
				this.usePlayerItem(sourceentity, hand, itemstack);
				if (this.random.nextInt(3) == 0 && !EventHooks.onAnimalTame(this, sourceentity)) {
					this.tame(sourceentity);
					this.level().broadcastEntityEvent(this, (byte) 7);
				} else {
					this.level().broadcastEntityEvent(this, (byte) 6);
				}
				this.setPersistenceRequired();
				retval = InteractionResult.SUCCESS;
			} else {
				retval = super.mobInteract(sourceentity, hand);
				if (retval == InteractionResult.SUCCESS || retval == InteractionResult.CONSUME)
					this.setPersistenceRequired();
			}
		}
		double x = this.getX();
		double y = this.getY();
		double z = this.getZ();
		Entity entity = this;
		Level world = this.level();

		PokemonRightClickedOnEntityProcedure.execute(world, x, y, z, entity, sourceentity);
		return retval;
	}

	@Override
	public void baseTick() {
		super.baseTick();
		PokemonOnEntityTickUpdateProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
		this.refreshDimensions();
	}

	@Override
	public AgeableMob getBreedOffspring(ServerLevel serverWorld, AgeableMob ageable) {
		PokemonEntity retval = PixelPals01ModEntities.POKEMON.get().create(serverWorld, EntitySpawnReason.BREEDING);
		retval.finalizeSpawn(serverWorld, serverWorld.getCurrentDifficultyAt(retval.blockPosition()), EntitySpawnReason.BREEDING, null);
		return retval;
	}

	@Override
	public boolean isFood(ItemStack stack) {
		return Ingredient.of(Blocks.DIAMOND_BLOCK.asItem()).test(stack);
	}

	@Override
	public EntityDimensions getDefaultDimensions(Pose pose) {
		Entity entity = this;
		Level world = this.level();
		double x = this.getX();
		double y = this.getY();
		double z = this.getZ();
		return super.getDefaultDimensions(pose).scale((float) PokemonModelVisualScaleProcedure.execute(entity));
	}

	public static void init(RegisterSpawnPlacementsEvent event) {
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
		builder = builder.add(Attributes.MAX_HEALTH, 10);
		builder = builder.add(Attributes.ARMOR, 0);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 3);
		builder = builder.add(Attributes.FOLLOW_RANGE, 16);
		builder = builder.add(Attributes.STEP_HEIGHT, 0.6);
		return builder;
	}
}