package net.mcreator.pixelpals.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.BlockPos;

import net.mcreator.pixelpals.network.PixelPals01ModVariables;
import net.mcreator.pixelpals.init.PixelPals01ModEntities;
import net.mcreator.pixelpals.entity.PokemonEntity;

public class PokeballOccupiedProjectileProjectileHitsBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		Entity pokemon = null;
		ItemStack data = ItemStack.EMPTY;
		pokemon = world instanceof ServerLevel _level0 ? PixelPals01ModEntities.POKEMON.get().spawn(_level0, BlockPos.containing(x, y + 1, z), EntitySpawnReason.MOB_SUMMONED) : null;
		if (entity.getData(PixelPals01ModVariables.PLAYER_VARIABLES).pselected == 1) {
			data = entity.getData(PixelPals01ModVariables.PLAYER_VARIABLES).p1.copy();
			if (pokemon instanceof PokemonEntity _datEntSetI)
				_datEntSetI.getEntityData().set(PokemonEntity.DATA_Slot, 1);
		}
		if (entity.getData(PixelPals01ModVariables.PLAYER_VARIABLES).pselected == 2) {
			data = entity.getData(PixelPals01ModVariables.PLAYER_VARIABLES).p2.copy();
			if (pokemon instanceof PokemonEntity _datEntSetI)
				_datEntSetI.getEntityData().set(PokemonEntity.DATA_Slot, 2);
		}
		if (entity.getData(PixelPals01ModVariables.PLAYER_VARIABLES).pselected == 3) {
			data = entity.getData(PixelPals01ModVariables.PLAYER_VARIABLES).p3.copy();
			if (pokemon instanceof PokemonEntity _datEntSetI)
				_datEntSetI.getEntityData().set(PokemonEntity.DATA_Slot, 3);
		}
		if (entity.getData(PixelPals01ModVariables.PLAYER_VARIABLES).pselected == 4) {
			data = entity.getData(PixelPals01ModVariables.PLAYER_VARIABLES).p4.copy();
			if (pokemon instanceof PokemonEntity _datEntSetI)
				_datEntSetI.getEntityData().set(PokemonEntity.DATA_Slot, 4);
		}
		if (entity.getData(PixelPals01ModVariables.PLAYER_VARIABLES).pselected == 5) {
			data = entity.getData(PixelPals01ModVariables.PLAYER_VARIABLES).p5.copy();
			if (pokemon instanceof PokemonEntity _datEntSetI)
				_datEntSetI.getEntityData().set(PokemonEntity.DATA_Slot, 5);
		}
		if (entity.getData(PixelPals01ModVariables.PLAYER_VARIABLES).pselected == 6) {
			data = entity.getData(PixelPals01ModVariables.PLAYER_VARIABLES).p6.copy();
			if (pokemon instanceof PokemonEntity _datEntSetI)
				_datEntSetI.getEntityData().set(PokemonEntity.DATA_Slot, 6);
		}
		if (pokemon instanceof TamableAnimal _toTame && entity instanceof Player _owner)
			_toTame.tame(_owner);
		if (pokemon instanceof PokemonEntity _datEntSetS)
			_datEntSetS.getEntityData().set(PokemonEntity.DATA_Species, (data.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("Species")));
		if (pokemon instanceof PokemonEntity _datEntSetI)
			_datEntSetI.getEntityData().set(PokemonEntity.DATA_Level, (int) data.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("Level"));
		if (pokemon instanceof PokemonEntity _datEntSetI)
			_datEntSetI.getEntityData().set(PokemonEntity.DATA_Shiny, (int) data.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("Shiny"));
		if (pokemon instanceof PokemonEntity _datEntSetI)
			_datEntSetI.getEntityData().set(PokemonEntity.DATA_ID, (int) data.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("ID"));
	}
}