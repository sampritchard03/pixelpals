package net.mcreator.pixelpals.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.pixelpals.entity.PokemonEntity;

import java.util.Comparator;

public class PokemonGuiNameProcedureProcedure {
	public static String execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return "";
		return ("you befriended " + ((PokemonRightClickedOnEntityProcedure.pokemon.get(entity.getDisplayName().toString())) instanceof PokemonEntity _datEntS ? _datEntS.getEntityData().get(PokemonEntity.DATA_Species) : "")) + "!";
	}

	private static Entity findEntityInWorldRange(LevelAccessor world, Class<? extends Entity> clazz, double x, double y, double z, double range) {
		return (Entity) world.getEntitiesOfClass(clazz, AABB.ofSize(new Vec3(x, y, z), range, range, range), e -> true).stream().sorted(Comparator.comparingDouble(e -> e.distanceToSqr(x, y, z))).findFirst().orElse(null);
	}
}