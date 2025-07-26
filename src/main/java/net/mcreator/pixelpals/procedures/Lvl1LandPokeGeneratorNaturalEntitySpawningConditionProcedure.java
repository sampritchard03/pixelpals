package net.mcreator.pixelpals.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.core.BlockPos;

import net.mcreator.pixelpals.entity.PokemonEntity;

import java.util.Comparator;

public class Lvl1LandPokeGeneratorNaturalEntitySpawningConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		Entity nearestPlayer = null;
		double pokecount = 0;
		double range = 0;
		range = 128;
		pokecount = 0;
		nearestPlayer = findEntityInWorldRange(world, ServerPlayer.class, x, y, z, range);
		if (nearestPlayer == null) {
			return false;
		}
		{
			final Vec3 _center = new Vec3((nearestPlayer.getX()), (nearestPlayer.getY()), (nearestPlayer.getZ()));
			for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(range / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
				if (entityiterator instanceof PokemonEntity) {
					pokecount = pokecount + 1;
				}
			}
		}
		return world.getMaxLocalRawBrightness(BlockPos.containing(x, y, z)) > 1 && pokecount < 16 && !((world.getFluidState(BlockPos.containing(x, y - 2, z)).createLegacyBlock()).getBlock() == Blocks.WATER)
				&& !((world.getBlockState(BlockPos.containing(x, y - 2, z))).getBlock() == Blocks.AIR);
	}

	private static Entity findEntityInWorldRange(LevelAccessor world, Class<? extends Entity> clazz, double x, double y, double z, double range) {
		return (Entity) world.getEntitiesOfClass(clazz, AABB.ofSize(new Vec3(x, y, z), range, range, range), e -> true).stream().sorted(Comparator.comparingDouble(e -> e.distanceToSqr(x, y, z))).findFirst().orElse(null);
	}
}