package net.mcreator.pixelpals.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.pixelpals.init.PixelPals01ModBlocks;

public class BurntLawnGeneratorBlockAddedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (Math.floor(x / 2) % 2 == 0) {
			world.setBlock(BlockPos.containing(x, y, z), PixelPals01ModBlocks.LIGHT_BROWN_STRIPE.get().defaultBlockState(), 3);
		} else {
			world.setBlock(BlockPos.containing(x, y, z), PixelPals01ModBlocks.DARK_BROWN_STRIPE.get().defaultBlockState(), 3);
		}
	}
}