package net.mcreator.pixelpals.block;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;

public class BrownShroomBricksBlock extends Block {
	public BrownShroomBricksBlock(BlockBehaviour.Properties properties) {
		super(properties.strength(1f, 10f));
	}

	@Override
	public int getLightBlock(BlockState state) {
		return 15;
	}
}