package net.mcreator.pixelpals.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.ai.attributes.Attributes;
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
		refreshSpecies(entity, world);
		//
		//
		//
		if (entity instanceof LivingEntity _livingEntity0 && _livingEntity0.getAttributes().hasAttribute(Attributes.SCALE))
			_livingEntity0.getAttribute(Attributes.SCALE).setBaseValue((entity.getEntityData().get(PokemonEntity.DATA_Scale) * 0.01) * (Math.pow(entity.getEntityData().get(PokemonEntity.DATA_Level), 0.5) * 0.1 + 0.5));
		if (world instanceof Level _level && Math.random() < 0.001 && entity.getEntityData().get(PokemonEntity.DATA_Species) != "") {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("pixel_pals_01:" + entity.getEntityData().get(PokemonEntity.DATA_Species))), SoundSource.NEUTRAL, 1, 1);
			} else {
				_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("pixel_pals_01:" + entity.getEntityData().get(PokemonEntity.DATA_Species))), SoundSource.NEUTRAL, 1, 1, false);
			}
		}
		if (findEntityInWorldRange(world, ServerPlayer.class, x, y, z, 128) == null) {
			if (!entity.level().isClientSide())
				entity.discard();
		}
		DespawnDuplicatePokemonProcedure.execute(world, x, y, z, entity);
		UpdateSlotProcedure.execute(entity);
	}

	private static Entity findEntityInWorldRange(LevelAccessor world, Class<? extends Entity> clazz, double x, double y, double z, double range) {
		return (Entity) world.getEntitiesOfClass(clazz, AABB.ofSize(new Vec3(x, y, z), range, range, range), e -> true).stream().sorted(Comparator.comparingDouble(e -> e.distanceToSqr(x, y, z))).findFirst().orElse(null);
	}

	public static Entity refreshSpecies(Entity entity, LevelAccessor world) {
		Entity _entity = entity;
		int bHp;
		int bAtk
		int bDef
		int bSpAtk
		int bSpDef
		int bSpe
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
					bHp = 45;
					bAtk = 49;
					bDef = 49;
					bSpAtk = 65;
					bSpDef = 65;
					bSpe = 45;
					break;
				case "ivysaur" :
					if (entity.getEntityData().get(PokemonEntity.DATA_Shiny) == 1)
						_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(PixelPals01ModItems.IVYSAUR_S_MASK.get()));
					else
						_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(PixelPals01ModItems.IVYSAUR_MASK.get()));
					entity.getEntityData().set(PokemonEntity.DATA_Scale, 55);
					bHp = 60;
					bAtk = 62;
					bDef = 63;
					bSpAtk = 80;
					bSpDef = 80;
					bSpe = 60;					
					break;
				case "venusaur" :
					if (entity.getEntityData().get(PokemonEntity.DATA_Shiny) == 1)
						_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(PixelPals01ModItems.VENUSAUR_S_MASK.get()));
					else
						_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(PixelPals01ModItems.VENUSAUR_MASK.get()));
					entity.getEntityData().set(PokemonEntity.DATA_Scale, 90);
					bHp = 80;
					bAtk = 82;
					bDef = 83;
					bSpAtk = 100;
					bSpDef = 100;
					bSpe = 80;	
					break;
				case "charmander" :
					if (entity.getEntityData().get(PokemonEntity.DATA_Shiny) == 1)
						_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(PixelPals01ModItems.CHARMANDER_S_MASK.get()));
					else
						_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(PixelPals01ModItems.CHARMANDER_MASK.get()));
					entity.getEntityData().set(PokemonEntity.DATA_Scale, 35);
					bHp = 39;
					bAtk = 52;
					bDef = 43;
					bSpAtk = 60;
					bSpDef = 50;
					bSpe = 65;	
					break;
				case "charmeleon" :
					if (entity.getEntityData().get(PokemonEntity.DATA_Shiny) == 1)
						_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(PixelPals01ModItems.CHARMELEON_S_MASK.get()));
					else
						_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(PixelPals01ModItems.CHARMELEON_MASK.get()));
					entity.getEntityData().set(PokemonEntity.DATA_Scale, 55);
					bHp = 58;
					bAtk = 64;
					bDef = 58;
					bSpAtk = 80;
					bSpDef = 65;
					bSpe = 80;	
					break;
				case "charizard" :
					if (entity.getEntityData().get(PokemonEntity.DATA_Shiny) == 1)
						_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(PixelPals01ModItems.CHARIZARD_S_MASK.get()));
					else
						_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(PixelPals01ModItems.CHARIZARD_MASK.get()));
					entity.getEntityData().set(PokemonEntity.DATA_Scale, 90);
					bHp = 78;
					bAtk = 84;
					bDef = 78;
					bSpAtk = 109;
					bSpDef = 85;
					bSpe = 100;	
					break;
				case "squirtle" :
					if (entity.getEntityData().get(PokemonEntity.DATA_Shiny) == 1)
						_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(PixelPals01ModItems.SQUIRTLE_S_MASK.get()));
					else
						_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(PixelPals01ModItems.SQUIRTLE_MASK.get()));
					entity.getEntityData().set(PokemonEntity.DATA_Scale, 35);
					bHp = 44;
					bAtk = 48;
					bDef = 65;
					bSpAtk = 50;
					bSpDef = 64;
					bSpe = 43;	
					break;
				case "wartortle" :
					if (entity.getEntityData().get(PokemonEntity.DATA_Shiny) == 1)
						_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(PixelPals01ModItems.WARTORTLE_S_MASK.get()));
					else
						_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(PixelPals01ModItems.WARTORTLE_MASK.get()));
					entity.getEntityData().set(PokemonEntity.DATA_Scale, 55);
					bHp = 59;
					bAtk = 63;
					bDef = 80;
					bSpAtk = 65;
					bSpDef = 80;
					bSpe = 58;	
					break;
				case "blastoise" :
					if (entity.getEntityData().get(PokemonEntity.DATA_Shiny) == 1)
						_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(PixelPals01ModItems.BLASTOISE_S_MASK.get()));
					else
						_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(PixelPals01ModItems.BLASTOISE_MASK.get()));
					entity.getEntityData().set(PokemonEntity.DATA_Scale, 90);
					bHp = 79;
					bAtk = 83;
					bDef = 100;
					bSpAtk = 85;
					bSpDef = 105;
					bSpe = 78;	
					break;
				case "caterpie" :
					if (entity.getEntityData().get(PokemonEntity.DATA_Shiny) == 1)
						_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(PixelPals01ModItems.CATERPIE_S_MASK.get()));
					else
						_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(PixelPals01ModItems.CATERPIE_MASK.get()));
					entity.getEntityData().set(PokemonEntity.DATA_Scale, 20);
					bHp = 45;
					bAtk = 30;
					bDef = 35;
					bSpAtk = 20;
					bSpDef = 20;
					bSpe = 45;	
					break;
				case "metapod" :
					if (entity.getEntityData().get(PokemonEntity.DATA_Shiny) == 1)
						_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(PixelPals01ModItems.METAPOD_S_MASK.get()));
					else
						_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(PixelPals01ModItems.METAPOD_MASK.get()));
					entity.getEntityData().set(PokemonEntity.DATA_Scale, 40);
					bHp = 50;
					bAtk = 20;
					bDef = 55;
					bSpAtk = 25;
					bSpDef = 25;
					bSpe = 30;	
					break;
				case "butterfree" :
					if (entity.getEntityData().get(PokemonEntity.DATA_Shiny) == 1)
						_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(PixelPals01ModItems.BUTTERFREE_S_MASK.get()));
					else
						_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(PixelPals01ModItems.BUTTERFREE_MASK.get()));
					entity.getEntityData().set(PokemonEntity.DATA_Scale, 55);
					bHp = 60;
					bAtk = 45;
					bDef = 50;
					bSpAtk = 80;
					bSpDef = 80;
					bSpe = 70;	
					break;
				case "weedle" :
					if (entity.getEntityData().get(PokemonEntity.DATA_Shiny) == 1)
						_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(PixelPals01ModItems.WEEDLE_S_MASK.get()));
					else
						_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(PixelPals01ModItems.WEEDLE_MASK.get()));
					entity.getEntityData().set(PokemonEntity.DATA_Scale, 20);
					bHp = 40;
					bAtk = 35;
					bDef = 30;
					bSpAtk = 20;
					bSpDef = 20;
					bSpe = 50;	
					break;
				case "kakuna" :
					if (entity.getEntityData().get(PokemonEntity.DATA_Shiny) == 1)
						_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(PixelPals01ModItems.KAKUNA_S_MASK.get()));
					else
						_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(PixelPals01ModItems.KAKUNA_MASK.get()));
					entity.getEntityData().set(PokemonEntity.DATA_Scale, 40);
					bHp = 45;
					bAtk = 25;
					bDef = 50;
					bSpAtk = 25;
					bSpDef = 25;
					bSpe = 35;	
					break;
				case "beedrill" :
					if (entity.getEntityData().get(PokemonEntity.DATA_Shiny) == 1)
						_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(PixelPals01ModItems.BEEDRILL_S_MASK.get()));
					else
						_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(PixelPals01ModItems.BEEDRILL_MASK.get()));
					entity.getEntityData().set(PokemonEntity.DATA_Scale, 65);
					bHp = 65;
					bAtk = 80;
					bDef = 40;
					bSpAtk = 45;
					bSpDef = 80;
					bSpe = 75;	
					break;
				case "pidgey" :
					if (entity.getEntityData().get(PokemonEntity.DATA_Shiny) == 1)
						_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(PixelPals01ModItems.PIDGEY_S_MASK.get()));
					else
						_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(PixelPals01ModItems.PIDGEY_MASK.get()));
					entity.getEntityData().set(PokemonEntity.DATA_Scale, 30);
					bHp = 40;
					bAtk = 45;
					bDef = 40;
					bSpAtk = 35;
					bSpDef = 35;
					bSpe = 56;	
					break;
				case "rattata" :
					if (entity.getEntityData().get(PokemonEntity.DATA_Shiny) == 1)
						_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(PixelPals01ModItems.RATTATA_S_MASK.get()));
					else
						_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(PixelPals01ModItems.RATTATA_MASK.get()));
					entity.getEntityData().set(PokemonEntity.DATA_Scale, 30);
					bHp = 30;
					bAtk = 56;
					bDef = 35;
					bSpAtk = 25;
					bSpDef = 35;
					bSpe = 72;	
					break;
				case "machamp" :
					if (entity.getEntityData().get(PokemonEntity.DATA_Shiny) == 1)
						_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(PixelPals01ModItems.MACHAMP_S_MASK.get()));
					else
						_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(PixelPals01ModItems.MACHAMP_MASK.get()));
					entity.getEntityData().set(PokemonEntity.DATA_Scale, 80);
					bHp = 90;
					bAtk = 130;
					bDef = 80;
					bSpAtk = 65;
					bSpDef = 85;
					bSpe = 55;	
					break;
				case "krabby" :
					if (entity.getEntityData().get(PokemonEntity.DATA_Shiny) == 1)
						_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(PixelPals01ModItems.KRABBY_S_MASK.get()));
					else
						_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(PixelPals01ModItems.KRABBY_MASK.get()));
					entity.getEntityData().set(PokemonEntity.DATA_Scale, 30);
					bHp = 30;
					bAtk = 105;
					bDef = 90;
					bSpAtk = 25;
					bSpDef = 25;
					bSpe = 50;	
					break;
				case "mrmime" :
					if (entity.getEntityData().get(PokemonEntity.DATA_Shiny) == 1)
						_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(PixelPals01ModItems.MR_MIME_S_MASK.get()));
					else
						_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(PixelPals01ModItems.MR_MIME_MASK.get()));
					entity.getEntityData().set(PokemonEntity.DATA_Scale, 65);
					bHp = 40;
					bAtk = 45;
					bDef = 65;
					bSpAtk = 100;
					bSpDef = 120;
					bSpe = 90;	
					break;
				case "snorlax" :
					if (entity.getEntityData().get(PokemonEntity.DATA_Shiny) == 1)
						_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(PixelPals01ModItems.SNORLAX_S_MASK.get()));
					else
						_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(PixelPals01ModItems.SNORLAX_MASK.get()));
					entity.getEntityData().set(PokemonEntity.DATA_Scale, 130);
					bHp = 160;
					bAtk = 110;
					bDef = 65;
					bSpAtk = 65;
					bSpDef = 110;
					bSpe = 30;	
					break;
				case "armaldo" :
					if (entity.getEntityData().get(PokemonEntity.DATA_Shiny) == 1)
						_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(PixelPals01ModItems.ARMALDO_S_MASK.get()));
					else
						_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(PixelPals01ModItems.ARMALDO_MASK.get()));
					entity.getEntityData().set(PokemonEntity.DATA_Scale, 110);
					bHp = 75;
					bAtk = 125;
					bDef = 100;
					bSpAtk = 70;
					bSpDef = 80;
					bSpe = 45;	
					break;
				case "darkrai" :
					if (entity.getEntityData().get(PokemonEntity.DATA_Shiny) == 1)
						_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(PixelPals01ModItems.DARKRAI_S_MASK.get()));
					else
						_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(PixelPals01ModItems.DARKRAI_MASK.get()));
					entity.getEntityData().set(PokemonEntity.DATA_Scale, 110);
					bHp = 70;
					bAtk = 90;
					bDef = 90;
					bSpAtk = 135;
					bSpDef = 90;
					bSpe = 125;	
					break;
			}
		}
		return entity;
	}
}