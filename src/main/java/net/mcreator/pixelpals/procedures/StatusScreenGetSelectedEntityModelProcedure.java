package net.mcreator.pixelpals.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.component.DataComponents;

import net.mcreator.pixelpals.network.PixelPals01ModVariables;
import net.mcreator.pixelpals.init.PixelPals01ModEntities;
import net.mcreator.pixelpals.entity.PokemonEntity;

public class StatusScreenGetSelectedEntityModelProcedure {
	public static Entity execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return null;
		Entity model = null;
		String species = "";
		int shiny = 0;
		model = world instanceof Level _level ? PixelPals01ModEntities.POKEMON.get().create(_level, EntitySpawnReason.EVENT) : null;
		species = entity.getData(PixelPals01ModVariables.PLAYER_VARIABLES).pselected.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("Species");
		shiny = (int) entity.getData(PixelPals01ModVariables.PLAYER_VARIABLES).pselected.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("Shiny");

		if (model instanceof PokemonEntity _datEntSetS) {
			_datEntSetS.getEntityData().set(PokemonEntity.DATA_Species, species);
			_datEntSetS.getEntityData().set(PokemonEntity.DATA_Shiny, shiny);

		}
			
		return PokemonOnEntityTickUpdateProcedure.refreshSpecies(model, null, true);
	}
}