package net.mcreator.pixelpals.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.pixelpals.init.PixelPals01ModItems;
import net.mcreator.pixelpals.entity.PokemonEntity;

import java.util.Comparator;

public class PokemonOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		entity.setCustomName(Component.literal("Lvl " + entity.getEntityData().get(PokemonEntity.DATA_Level)));
		refreshSpecies(entity, world, false);
		//
		//
		//
		if (world instanceof Level _level && Math.random() < 0.001 && entity.getEntityData().get(PokemonEntity.DATA_Species) != "") {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("pixel_pals_01:" + entity.getEntityData().get(PokemonEntity.DATA_Species))), SoundSource.NEUTRAL, 1, 1);
			} else {
				_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("pixel_pals_01:" + entity.getEntityData().get(PokemonEntity.DATA_Species))), SoundSource.NEUTRAL, 1, 1, false);
			}
		}
		if (entity.getEntityData().get(PokemonEntity.DATA_SadTimer) > 0) {
			entity.getEntityData().set(PokemonEntity.DATA_SadTimer, entity.getEntityData().get(PokemonEntity.DATA_SadTimer) - 1);
			Entity _ent = entity;
			_ent.setXRot(45);
		}
		if (findEntityInWorldRange(world, ServerPlayer.class, x, y, z, 64) == null) {
			if (!entity.level().isClientSide())
				entity.discard();
		}
	}

	private static Entity findEntityInWorldRange(LevelAccessor world, Class<? extends Entity> clazz, double x, double y, double z, double range) {
		return (Entity) world.getEntitiesOfClass(clazz, AABB.ofSize(new Vec3(x, y, z), range, range, range), e -> true).stream().sorted(Comparator.comparingDouble(e -> e.distanceToSqr(x, y, z))).findFirst().orElse(null);
	}

	public static Entity refreshSpecies(Entity entity, LevelAccessor world, boolean isModel) {
		Entity _entity = entity;
		if (_entity instanceof LivingEntity _living) {
			switch (entity.getEntityData().get(PokemonEntity.DATA_Species)) {
				default :
					if (world instanceof ServerLevel level)
						entity.discard();
					break;
				case "bulbasaur" :
					if (entity.getEntityData().get(PokemonEntity.DATA_Shiny) == 1)
						_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(PixelPals01ModItems.BULBASAUR_S_MASK.get()));
					else
						_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(PixelPals01ModItems.BULBASAUR_MASK.get()));
					entity.getEntityData().set(PokemonEntity.DATA_Scale, 35);
					break;
				case "ivysaur" :
					if (entity.getEntityData().get(PokemonEntity.DATA_Shiny) == 1)
						_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(PixelPals01ModItems.IVYSAUR_S_MASK.get()));
					else
						_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(PixelPals01ModItems.IVYSAUR_MASK.get()));
					entity.getEntityData().set(PokemonEntity.DATA_Scale, 55);
					break;
				case "venusaur" :
					if (entity.getEntityData().get(PokemonEntity.DATA_Shiny) == 1)
						_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(PixelPals01ModItems.VENUSAUR_S_MASK.get()));
					else
						_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(PixelPals01ModItems.VENUSAUR_MASK.get()));
					entity.getEntityData().set(PokemonEntity.DATA_Scale, 90);
					break;
				case "charmander" :
					if (entity.getEntityData().get(PokemonEntity.DATA_Shiny) == 1)
						_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(PixelPals01ModItems.CHARMANDER_S_MASK.get()));
					else
						_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(PixelPals01ModItems.CHARMANDER_MASK.get()));
					entity.getEntityData().set(PokemonEntity.DATA_Scale, 35);
					break;
				case "charmeleon" :
					if (entity.getEntityData().get(PokemonEntity.DATA_Shiny) == 1)
						_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(PixelPals01ModItems.CHARMELEON_S_MASK.get()));
					else
						_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(PixelPals01ModItems.CHARMELEON_MASK.get()));
					entity.getEntityData().set(PokemonEntity.DATA_Scale, 55);
					break;
				case "charizard" :
					if (entity.getEntityData().get(PokemonEntity.DATA_Shiny) == 1)
						_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(PixelPals01ModItems.CHARIZARD_S_MASK.get()));
					else
						_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(PixelPals01ModItems.CHARIZARD_MASK.get()));
					entity.getEntityData().set(PokemonEntity.DATA_Scale, 90);
					break;
				case "squirtle" :
					if (entity.getEntityData().get(PokemonEntity.DATA_Shiny) == 1)
						_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(PixelPals01ModItems.SQUIRTLE_S_MASK.get()));
					else
						_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(PixelPals01ModItems.SQUIRTLE_MASK.get()));
					entity.getEntityData().set(PokemonEntity.DATA_Scale, 35);
					break;
				case "wartortle" :
					if (entity.getEntityData().get(PokemonEntity.DATA_Shiny) == 1)
						_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(PixelPals01ModItems.WARTORTLE_S_MASK.get()));
					else
						_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(PixelPals01ModItems.WARTORTLE_MASK.get()));
					entity.getEntityData().set(PokemonEntity.DATA_Scale, 55);
					break;					
				case "blastoise" :
					if (entity.getEntityData().get(PokemonEntity.DATA_Shiny) == 1)
						_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(PixelPals01ModItems.BLASTOISE_S_MASK.get()));
					else
						_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(PixelPals01ModItems.BLASTOISE_MASK.get()));
					entity.getEntityData().set(PokemonEntity.DATA_Scale, 90);
					break;
				case "caterpie" :
					if (entity.getEntityData().get(PokemonEntity.DATA_Shiny) == 1)
						_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(PixelPals01ModItems.CATERPIE_S_MASK.get()));
					else
						_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(PixelPals01ModItems.CATERPIE_MASK.get()));
					entity.getEntityData().set(PokemonEntity.DATA_Scale, 20);
					break;
				case "metapod" :
					if (entity.getEntityData().get(PokemonEntity.DATA_Shiny) == 1)
						_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(PixelPals01ModItems.METAPOD_S_MASK.get()));
					else
						_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(PixelPals01ModItems.METAPOD_MASK.get()));
					entity.getEntityData().set(PokemonEntity.DATA_Scale, 40);
					break;
				case "butterfree" :
					if (entity.getEntityData().get(PokemonEntity.DATA_Shiny) == 1)
						_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(PixelPals01ModItems.BUTTERFREE_S_MASK.get()));
					else
						_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(PixelPals01ModItems.BUTTERFREE_MASK.get()));
					entity.getEntityData().set(PokemonEntity.DATA_Scale, 55);
					break;
				case "weedle" :
					if (entity.getEntityData().get(PokemonEntity.DATA_Shiny) == 1)
						_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(PixelPals01ModItems.WEEDLE_S_MASK.get()));
					else
						_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(PixelPals01ModItems.WEEDLE_MASK.get()));
					entity.getEntityData().set(PokemonEntity.DATA_Scale, 20);
					break;
				case "kakuna" :
					if (entity.getEntityData().get(PokemonEntity.DATA_Shiny) == 1)
						_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(PixelPals01ModItems.KAKUNA_S_MASK.get()));
					else
						_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(PixelPals01ModItems.KAKUNA_MASK.get()));
					entity.getEntityData().set(PokemonEntity.DATA_Scale, 40);
					break;
				case "beedrill" :
					if (entity.getEntityData().get(PokemonEntity.DATA_Shiny) == 1)
						_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(PixelPals01ModItems.BEEDRILL_S_MASK.get()));
					else
						_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(PixelPals01ModItems.BEEDRILL_MASK.get()));
					entity.getEntityData().set(PokemonEntity.DATA_Scale, 65);
					break;
				case "pidgey" :
					if (entity.getEntityData().get(PokemonEntity.DATA_Shiny) == 1)
						_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(PixelPals01ModItems.PIDGEY_S_MASK.get()));
					else
						_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(PixelPals01ModItems.PIDGEY_MASK.get()));
					entity.getEntityData().set(PokemonEntity.DATA_Scale, 30);
					break;
				case "rattata" :
					if (entity.getEntityData().get(PokemonEntity.DATA_Shiny) == 1)
						_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(PixelPals01ModItems.RATTATA_S_MASK.get()));
					else
						_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(PixelPals01ModItems.RATTATA_MASK.get()));
					entity.getEntityData().set(PokemonEntity.DATA_Scale, 30);
					break;
				case "machamp" :
					if (entity.getEntityData().get(PokemonEntity.DATA_Shiny) == 1)
						_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(PixelPals01ModItems.MACHAMP_S_MASK.get()));
					else
						_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(PixelPals01ModItems.MACHAMP_MASK.get()));
					entity.getEntityData().set(PokemonEntity.DATA_Scale, 80);
					break;
				case "krabby" :
					if (entity.getEntityData().get(PokemonEntity.DATA_Shiny) == 1)
						_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(PixelPals01ModItems.KRABBY_S_MASK.get()));
					else
						_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(PixelPals01ModItems.KRABBY_MASK.get()));
					entity.getEntityData().set(PokemonEntity.DATA_Scale, 30);
					break;
				case "mrmime" :
					if (entity.getEntityData().get(PokemonEntity.DATA_Shiny) == 1)
						_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(PixelPals01ModItems.MR_MIME_S_MASK.get()));
					else
						_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(PixelPals01ModItems.MR_MIME_MASK.get()));
					entity.getEntityData().set(PokemonEntity.DATA_Scale, 65);
					break;
				case "snorlax" :
					if (entity.getEntityData().get(PokemonEntity.DATA_Shiny) == 1)
						_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(PixelPals01ModItems.SNORLAX_S_MASK.get()));
					else
						_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(PixelPals01ModItems.SNORLAX_MASK.get()));
					entity.getEntityData().set(PokemonEntity.DATA_Scale, 130);
					break;
				case "armaldo" :
					if (entity.getEntityData().get(PokemonEntity.DATA_Shiny) == 1)
						_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(PixelPals01ModItems.ARMALDO_S_MASK.get()));
					else
						_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(PixelPals01ModItems.ARMALDO_MASK.get()));
					entity.getEntityData().set(PokemonEntity.DATA_Scale, 110);
					break;
				case "darkrai" :
					if (entity.getEntityData().get(PokemonEntity.DATA_Shiny) == 1)
						_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(PixelPals01ModItems.DARKRAI_S_MASK.get()));
					else
						_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(PixelPals01ModItems.DARKRAI_MASK.get()));
					entity.getEntityData().set(PokemonEntity.DATA_Scale, 110);
					break;
			}
		}
		if (isModel) {
			entity.getEntityData().set(PokemonEntity.DATA_Scale, 20);
			entity.getEntityData().set(PokemonEntity.DATA_Level, 10);
		}
		return entity;
	}
}