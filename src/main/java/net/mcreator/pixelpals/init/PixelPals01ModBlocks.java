/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.pixelpals.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredBlock;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;

import net.mcreator.pixelpals.block.SoilBlock;
import net.mcreator.pixelpals.block.SlateBlock;
import net.mcreator.pixelpals.block.PineTreeBlock;
import net.mcreator.pixelpals.block.HazyHollowsPortalBlock;
import net.mcreator.pixelpals.block.ForestFloorBlock;
import net.mcreator.pixelpals.block.BeachPebblesBlock;
import net.mcreator.pixelpals.PixelPals01Mod;

import java.util.function.Function;

public class PixelPals01ModBlocks {
	public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(PixelPals01Mod.MODID);
	public static final DeferredBlock<Block> PINE_TREE = register("pine_tree", PineTreeBlock::new);
	public static final DeferredBlock<Block> SLATE = register("slate", SlateBlock::new);
	public static final DeferredBlock<Block> SOIL = register("soil", SoilBlock::new);
	public static final DeferredBlock<Block> FOREST_FLOOR = register("forest_floor", ForestFloorBlock::new);
	public static final DeferredBlock<Block> BEACH_PEBBLES = register("beach_pebbles", BeachPebblesBlock::new);
	public static final DeferredBlock<Block> HAZY_HOLLOWS_PORTAL = register("hazy_hollows_portal", HazyHollowsPortalBlock::new);

	// Start of user code block custom blocks
	// End of user code block custom blocks
	private static <B extends Block> DeferredBlock<B> register(String name, Function<BlockBehaviour.Properties, ? extends B> supplier) {
		return REGISTRY.registerBlock(name, supplier, BlockBehaviour.Properties.of());
	}
}