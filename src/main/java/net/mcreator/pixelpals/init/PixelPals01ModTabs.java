/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.pixelpals.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.mcreator.pixelpals.PixelPals01Mod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class PixelPals01ModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, PixelPals01Mod.MODID);
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> PIXEL_PALS_TAB = REGISTRY.register("pixel_pals_tab",
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.pixel_pals_01.pixel_pals_tab")).icon(() -> new ItemStack(PixelPals01ModBlocks.PIXEL_GRASS.get())).displayItems((parameters, tabData) -> {
				tabData.accept(PixelPals01ModBlocks.PIXEL_GRASS.get().asItem());
				tabData.accept(PixelPals01ModBlocks.PIXEL_DIRT.get().asItem());
				tabData.accept(PixelPals01ModBlocks.PIXEL_STONE.get().asItem());
				tabData.accept(PixelPals01ModBlocks.PIXEL_SAND.get().asItem());
				tabData.accept(PixelPals01ModBlocks.BLOBBY_LOG.get().asItem());
				tabData.accept(PixelPals01ModBlocks.BLOBBY_TREE.get().asItem());
				tabData.accept(PixelPals01ModBlocks.TALL_GRASS.get().asItem());
				tabData.accept(PixelPals01ModBlocks.YELLOW_TREE.get().asItem());
				tabData.accept(PixelPals01ModBlocks.ORANGE_TREE.get().asItem());
				tabData.accept(PixelPals01ModItems.POKEBALL.get());
				tabData.accept(PixelPals01ModItems.PKHEX.get());
				tabData.accept(PixelPals01ModBlocks.SHROOM_CEMENT.get().asItem());
				tabData.accept(PixelPals01ModBlocks.BROWN_SHROOM_BRICKS.get().asItem());
				tabData.accept(PixelPals01ModBlocks.WHITE_SHROOM_BRICKS.get().asItem());
				tabData.accept(PixelPals01ModBlocks.RED_SHROOM_BLOCK.get().asItem());
				tabData.accept(PixelPals01ModBlocks.RED_TOAD_HOUSE.get().asItem());
				tabData.accept(PixelPals01ModBlocks.TOAD_HOUSE_DOOR.get().asItem());
				tabData.accept(PixelPals01ModBlocks.TOAD_HOUSE_DOOR_OPEN.get().asItem());
				tabData.accept(PixelPals01ModBlocks.PINE_TREE.get().asItem());
				tabData.accept(PixelPals01ModBlocks.SLATE.get().asItem());
				tabData.accept(PixelPals01ModBlocks.SOIL.get().asItem());
				tabData.accept(PixelPals01ModBlocks.FOREST_FLOOR.get().asItem());
			}).build());

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		if (tabData.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
			tabData.accept(PixelPals01ModItems.PEACEFUL_PLAINS.get());
		} else if (tabData.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
			tabData.accept(PixelPals01ModBlocks.BLOBBY_TREE.get().asItem());
			tabData.accept(PixelPals01ModBlocks.TALL_GRASS.get().asItem());
			tabData.accept(PixelPals01ModBlocks.YELLOW_TREE.get().asItem());
			tabData.accept(PixelPals01ModBlocks.ORANGE_TREE.get().asItem());
			tabData.accept(PixelPals01ModBlocks.PINE_TREE.get().asItem());
		} else if (tabData.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
			tabData.accept(PixelPals01ModItems.POKEMON_SPAWN_EGG.get());
			tabData.accept(PixelPals01ModItems.LVL_1_LAND_POKE_GENERATOR_SPAWN_EGG.get());
		}
	}
}