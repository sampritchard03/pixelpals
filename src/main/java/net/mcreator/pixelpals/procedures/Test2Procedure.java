package net.mcreator.pixelpals.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.mcreator.pixelpals.entity.PokemonEntity;

import java.util.Comparator;

public class Test2Procedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		{
			final Vec3 _center = new Vec3(x, y, z);
			for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(1000 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
				if ((entity instanceof PokemonEntity _datEntI ? _datEntI.getEntityData().get(PokemonEntity.DATA_ID) : 0) == (entityiterator instanceof PokemonEntity _datEntI ? _datEntI.getEntityData().get(PokemonEntity.DATA_ID) : 0)
						&& !(entityiterator == entity)) {
					if (!entity.level().isClientSide())
						entity.discard();
				}
			}
		}
	}
}