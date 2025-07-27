package net.mcreator.pixelpals.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
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
		if (entity.getData(PixelPals01ModVariables.PLAYER_VARIABLES).pselected == 1) {
			data = entity.getData(PixelPals01ModVariables.PLAYER_VARIABLES).p1.copy();
		}
		if (entity.getData(PixelPals01ModVariables.PLAYER_VARIABLES).pselected == 2) {
			data = entity.getData(PixelPals01ModVariables.PLAYER_VARIABLES).p2.copy();
		}
		if (entity.getData(PixelPals01ModVariables.PLAYER_VARIABLES).pselected == 3) {
			data = entity.getData(PixelPals01ModVariables.PLAYER_VARIABLES).p3.copy();
		}
		if (entity.getData(PixelPals01ModVariables.PLAYER_VARIABLES).pselected == 4) {
			data = entity.getData(PixelPals01ModVariables.PLAYER_VARIABLES).p4.copy();
		}
		if (entity.getData(PixelPals01ModVariables.PLAYER_VARIABLES).pselected == 5) {
			data = entity.getData(PixelPals01ModVariables.PLAYER_VARIABLES).p5.copy();
		}
		if (entity.getData(PixelPals01ModVariables.PLAYER_VARIABLES).pselected == 6) {
			data = entity.getData(PixelPals01ModVariables.PLAYER_VARIABLES).p6.copy();
		}
		pokemon = world instanceof ServerLevel _level0 ? PixelPals01ModEntities.POKEMON.get().spawn(_level0, BlockPos.containing(x, y + 1, z), EntitySpawnReason.MOB_SUMMONED) : null;
		if (pokemon instanceof PokemonEntity _datEntSetS)
			_datEntSetS.getEntityData().set(PokemonEntity.DATA_Species, (data.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("Species")));
		if (pokemon instanceof PokemonEntity _datEntSetI)
			_datEntSetI.getEntityData().set(PokemonEntity.DATA_Level, (int) data.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("Level"));
		if (pokemon instanceof PokemonEntity _datEntSetI)
			_datEntSetI.getEntityData().set(PokemonEntity.DATA_Shiny, (int) data.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("Shiny"));
	}
}