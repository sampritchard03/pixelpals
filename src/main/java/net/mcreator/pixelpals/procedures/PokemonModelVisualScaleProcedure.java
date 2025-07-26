package net.mcreator.pixelpals.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.pixelpals.entity.PokemonEntity;

public class PokemonModelVisualScaleProcedure {
	public static double execute(Entity entity) {
		if (entity == null)
			return 0;
		double val = (entity.getEntityData().get(PokemonEntity.DATA_Scale) * 0.01) * (Math.pow(entity.getEntityData().get(PokemonEntity.DATA_Level), 0.5) * 0.1 + 0.5);
		return val;
	}
}