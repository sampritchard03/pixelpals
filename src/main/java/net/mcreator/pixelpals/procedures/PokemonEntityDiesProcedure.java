package net.mcreator.pixelpals.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.pixelpals.entity.PokemonEntity;
import net.minecraft.world.entity.TamableAnimal;

public class PokemonEntityDiesProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof TamableAnimal tamable && tamable.isTame()) {
			if (entity instanceof LivingEntity _entity)
				_entity.setHealth(entity instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
			entity.getEntityData().set(PokemonEntity.DATA_SadTimer, 2000);
		}
	}
}