package net.mcreator.pixelpals.procedures;

import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.Entity;

import net.mcreator.pixelpals.entity.PokemonEntity;

public class PokemonSadForgiveConditionProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return ((entity instanceof Mob _mobEnt ? (Entity) _mobEnt.getTarget() : null) instanceof PokemonEntity _datEntI ? _datEntI.getEntityData().get(PokemonEntity.DATA_SadTimer) : 0) == 0;
	}
}