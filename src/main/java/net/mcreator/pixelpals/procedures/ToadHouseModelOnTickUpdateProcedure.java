package net.mcreator.pixelpals.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

public class ToadHouseModelOnTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		Entity chest = null;
		double zoffset = 0;
		double xoffset = 0;
		double chestx = 0;
		double chestz = 0;
		double yawoffset = 0;
		if (Math.random() < 0.0001) {
			ToadHouseModelOnPlaceProcedure.execute(world, x, y, z);
		}
	}
}