package net.mcreator.pixelpals.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
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
		ItemStack poke = null;
		if (entity.getData(PixelPals01ModVariables.PLAYER_VARIABLES).pselected == 1)
			poke = entity.getData(PixelPals01ModVariables.PLAYER_VARIABLES).p1;
		else if (entity.getData(PixelPals01ModVariables.PLAYER_VARIABLES).pselected == 2)
			poke = entity.getData(PixelPals01ModVariables.PLAYER_VARIABLES).p2;
		else if (entity.getData(PixelPals01ModVariables.PLAYER_VARIABLES).pselected == 3)
			poke = entity.getData(PixelPals01ModVariables.PLAYER_VARIABLES).p3;
		else if (entity.getData(PixelPals01ModVariables.PLAYER_VARIABLES).pselected == 4)
			poke = entity.getData(PixelPals01ModVariables.PLAYER_VARIABLES).p4;
		else if (entity.getData(PixelPals01ModVariables.PLAYER_VARIABLES).pselected == 5)
			poke = entity.getData(PixelPals01ModVariables.PLAYER_VARIABLES).p5;
		else if (entity.getData(PixelPals01ModVariables.PLAYER_VARIABLES).pselected == 6)
			poke = entity.getData(PixelPals01ModVariables.PLAYER_VARIABLES).p6;
		if (poke == null)
			return null;
		species = poke.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getString("Species");
		shiny = (int) poke.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag().getDouble("Shiny");
		if (model instanceof PokemonEntity _datEntSetS) {
			_datEntSetS.getEntityData().set(PokemonEntity.DATA_Species, species);
			_datEntSetS.getEntityData().set(PokemonEntity.DATA_Shiny, shiny);
		}
		if (model instanceof LivingEntity _livingEntity0 && _livingEntity0.getAttributes().hasAttribute(Attributes.SCALE))
			_livingEntity0.getAttribute(Attributes.SCALE).setBaseValue(0.2);
		return PokemonOnEntityTickUpdateProcedure.refreshSpecies(model, null);
	}
}