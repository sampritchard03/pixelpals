package net.mcreator.pixelpals.block;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;

public class SlateBlock extends Block {
	public SlateBlock(BlockBehaviour.Properties properties) {
		super(properties.strength(2f, 10f));
	}

	@Override
	public int getLightBlock(BlockState state) {
		return 15;
	}
}