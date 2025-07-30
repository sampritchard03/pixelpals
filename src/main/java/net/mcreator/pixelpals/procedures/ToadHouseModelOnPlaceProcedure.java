package net.mcreator.pixelpals.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.pixelpals.init.PixelPals01ModEntities;
import net.mcreator.pixelpals.entity.ChestEntityEntity;

import java.util.Comparator;

public class ToadHouseModelOnPlaceProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		Entity chest = null;
		double zoffset = 0;
		double xoffset = 0;
		double chestx = 0;
		double chestz = 0;
		double yawoffset = 0;
		xoffset = 0;
		zoffset = 0.15;
		if ((getBlockDirection(world, BlockPos.containing(x, y, z))) == Direction.NORTH) {
			yawoffset = 0;
			chestx = x + 0.5 + zoffset;
			chestz = (z + 0.5) - xoffset;
		} else if ((getBlockDirection(world, BlockPos.containing(x, y, z))) == Direction.SOUTH) {
			yawoffset = 180;
			chestx = (x + 0.5) - zoffset;
			chestz = z + 0.5 + xoffset;
		} else if ((getBlockDirection(world, BlockPos.containing(x, y, z))) == Direction.EAST) {
			yawoffset = 90;
			chestx = x + 0.5 + xoffset;
			chestz = z + 0.5 + zoffset;
		} else if ((getBlockDirection(world, BlockPos.containing(x, y, z))) == Direction.WEST) {
			yawoffset = 270;
			chestx = (x + 0.5) - xoffset;
			chestz = (z + 0.5) - zoffset;
		}
		if (findEntityInWorldRange(world, ChestEntityEntity.class, chestx, y, chestz, 1) == null) {
			chest = world instanceof ServerLevel _level9 ? PixelPals01ModEntities.CHEST_ENTITY.get().spawn(_level9, BlockPos.containing(x, y, z), EntitySpawnReason.MOB_SUMMONED) : null;
			{
				Entity _ent = chest;
				_ent.teleportTo(chestx, y, chestz);
				if (_ent instanceof ServerPlayer _serverPlayer)
					_serverPlayer.connection.teleport(chestx, y, chestz, _ent.getYRot(), _ent.getXRot());
			}
			{
				Entity _ent = chest;
				_ent.setYRot((float) (90 + yawoffset));
				_ent.setXRot(0);
				_ent.setYBodyRot(_ent.getYRot());
				_ent.setYHeadRot(_ent.getYRot());
				_ent.yRotO = _ent.getYRot();
				_ent.xRotO = _ent.getXRot();
				if (_ent instanceof LivingEntity _entity) {
					_entity.yBodyRotO = _entity.getYRot();
					_entity.yHeadRotO = _entity.getYRot();
				}
			}
		}
	}

	private static Direction getBlockDirection(LevelAccessor world, BlockPos pos) {
		BlockState blockState = world.getBlockState(pos);
		Property<?> property = blockState.getBlock().getStateDefinition().getProperty("facing");
		if (property != null && blockState.getValue(property) instanceof Direction direction)
			return direction;
		else if (blockState.hasProperty(BlockStateProperties.AXIS))
			return Direction.fromAxisAndDirection(blockState.getValue(BlockStateProperties.AXIS), Direction.AxisDirection.POSITIVE);
		else if (blockState.hasProperty(BlockStateProperties.HORIZONTAL_AXIS))
			return Direction.fromAxisAndDirection(blockState.getValue(BlockStateProperties.HORIZONTAL_AXIS), Direction.AxisDirection.POSITIVE);
		return Direction.NORTH;
	}

	private static Entity findEntityInWorldRange(LevelAccessor world, Class<? extends Entity> clazz, double x, double y, double z, double range) {
		return (Entity) world.getEntitiesOfClass(clazz, AABB.ofSize(new Vec3(x, y, z), range, range, range), e -> true).stream().sorted(Comparator.comparingDouble(e -> e.distanceToSqr(x, y, z))).findFirst().orElse(null);
	}
}