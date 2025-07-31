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
			() -> CreativeModeTab.builder().title(Component.translatable("item_group.pixel_pals_01.pixel_pals_tab")).icon(() -> new ItemStack(PixelPals01ModItems.POKEBALL.get())).displayItems((parameters, tabData) -> {
				tabData.accept(PixelPals01ModItems.POKEBALL.get());
				tabData.accept(PixelPals01ModItems.PKHEX.get());
				tabData.accept(PixelPals01ModBlocks.PINE_TREE.get().asItem());
				tabData.accept(PixelPals01ModBlocks.SLATE.get().asItem());
				tabData.accept(PixelPals01ModBlocks.SOIL.get().asItem());
				tabData.accept(PixelPals01ModBlocks.FOREST_FLOOR.get().asItem());
				tabData.accept(PixelPals01ModBlocks.BEACH_PEBBLES.get().asItem());
				tabData.accept(PixelPals01ModBlocks.DRY_SOIL.get().asItem());
				tabData.accept(PixelPals01ModBlocks.DARK_BROWN_STRIPE.get().asItem());
				tabData.accept(PixelPals01ModBlocks.LIGHT_BROWN_STRIPE.get().asItem());
			}).build());

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		if (tabData.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
			tabData.accept(PixelPals01ModItems.POKEMON_SPAWN_EGG.get());
			tabData.accept(PixelPals01ModItems.LVL_1_LAND_POKE_GENERATOR_SPAWN_EGG.get());
			tabData.accept(PixelPals01ModItems.CHEST_ENTITY_SPAWN_EGG.get());
		} else if (tabData.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
			tabData.accept(PixelPals01ModBlocks.PINE_TREE.get().asItem());
		}
	}
}