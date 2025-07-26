/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.pixelpals.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredBlock;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.Block;

import net.mcreator.pixelpals.block.YellowTreeBlock;
import net.mcreator.pixelpals.block.WildWoodPortalBlock;
import net.mcreator.pixelpals.block.WhiteShroomBricksBlock;
import net.mcreator.pixelpals.block.ToadHouseWallBlock;
import net.mcreator.pixelpals.block.ToadHouseDoorwayBlock;
import net.mcreator.pixelpals.block.ToadHouseDoorOpenBlock;
import net.mcreator.pixelpals.block.ToadHouseDoorBlock;
import net.mcreator.pixelpals.block.TallGrassBlock;
import net.mcreator.pixelpals.block.SoilBlock;
import net.mcreator.pixelpals.block.SlateBlock;
import net.mcreator.pixelpals.block.ShroomCementBlock;
import net.mcreator.pixelpals.block.RedToadHouseBlock;
import net.mcreator.pixelpals.block.RedShroomBlockBlock;
import net.mcreator.pixelpals.block.PixelStoneBlock;
import net.mcreator.pixelpals.block.PixelSandBlock;
import net.mcreator.pixelpals.block.PixelGrassBlock;
import net.mcreator.pixelpals.block.PixelDirtBlock;
import net.mcreator.pixelpals.block.PineTreeBlock;
import net.mcreator.pixelpals.block.PeacefulPlainsPortalBlock;
import net.mcreator.pixelpals.block.OrangeTreeBlock;
import net.mcreator.pixelpals.block.ForestFloorBlock;
import net.mcreator.pixelpals.block.FallenLeavesBlock;
import net.mcreator.pixelpals.block.BrownShroomBricksBlock;
import net.mcreator.pixelpals.block.BlobbyTreeBlock;
import net.mcreator.pixelpals.block.BlobbyLogBlock;
import net.mcreator.pixelpals.PixelPals01Mod;

import java.util.function.Function;

public class PixelPals01ModBlocks {
	public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(PixelPals01Mod.MODID);
	public static final DeferredBlock<Block> PEACEFUL_PLAINS_PORTAL = register("peaceful_plains_portal", PeacefulPlainsPortalBlock::new);
	public static final DeferredBlock<Block> PIXEL_GRASS = register("pixel_grass", PixelGrassBlock::new);
	public static final DeferredBlock<Block> PIXEL_DIRT = register("pixel_dirt", PixelDirtBlock::new);
	public static final DeferredBlock<Block> PIXEL_STONE = register("pixel_stone", PixelStoneBlock::new);
	public static final DeferredBlock<Block> PIXEL_SAND = register("pixel_sand", PixelSandBlock::new);
	public static final DeferredBlock<Block> BLOBBY_LOG = register("blobby_log", BlobbyLogBlock::new);
	public static final DeferredBlock<Block> BLOBBY_TREE = register("blobby_tree", BlobbyTreeBlock::new);
	public static final DeferredBlock<Block> TALL_GRASS = register("tall_grass", TallGrassBlock::new);
	public static final DeferredBlock<Block> FALLEN_LEAVES = register("fallen_leaves", FallenLeavesBlock::new);
	public static final DeferredBlock<Block> YELLOW_TREE = register("yellow_tree", YellowTreeBlock::new);
	public static final DeferredBlock<Block> ORANGE_TREE = register("orange_tree", OrangeTreeBlock::new);
	public static final DeferredBlock<Block> TOAD_HOUSE_WALL = register("toad_house_wall", ToadHouseWallBlock::new);
	public static final DeferredBlock<Block> SHROOM_CEMENT = register("shroom_cement", ShroomCementBlock::new);
	public static final DeferredBlock<Block> BROWN_SHROOM_BRICKS = register("brown_shroom_bricks", BrownShroomBricksBlock::new);
	public static final DeferredBlock<Block> WHITE_SHROOM_BRICKS = register("white_shroom_bricks", WhiteShroomBricksBlock::new);
	public static final DeferredBlock<Block> TOAD_HOUSE_DOORWAY = register("toad_house_doorway", ToadHouseDoorwayBlock::new);
	public static final DeferredBlock<Block> RED_SHROOM_BLOCK = register("red_shroom_block", RedShroomBlockBlock::new);
	public static final DeferredBlock<Block> RED_TOAD_HOUSE = register("red_toad_house", RedToadHouseBlock::new);
	public static final DeferredBlock<Block> TOAD_HOUSE_DOOR = register("toad_house_door", ToadHouseDoorBlock::new);
	public static final DeferredBlock<Block> TOAD_HOUSE_DOOR_OPEN = register("toad_house_door_open", ToadHouseDoorOpenBlock::new);
	public static final DeferredBlock<Block> PINE_TREE = register("pine_tree", PineTreeBlock::new);
	public static final DeferredBlock<Block> SLATE = register("slate", SlateBlock::new);
	public static final DeferredBlock<Block> WILD_WOOD_PORTAL = register("wild_wood_portal", WildWoodPortalBlock::new);
	public static final DeferredBlock<Block> SOIL = register("soil", SoilBlock::new);
	public static final DeferredBlock<Block> FOREST_FLOOR = register("forest_floor", ForestFloorBlock::new);

	// Start of user code block custom blocks
	// End of user code block custom blocks
	private static <B extends Block> DeferredBlock<B> register(String name, Function<BlockBehaviour.Properties, ? extends B> supplier) {
		return REGISTRY.registerBlock(name, supplier, BlockBehaviour.Properties.of());
	}
}