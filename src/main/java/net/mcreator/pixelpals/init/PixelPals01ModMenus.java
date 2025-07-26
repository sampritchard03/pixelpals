/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.pixelpals.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;

import net.minecraft.world.inventory.Slot;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.core.registries.Registries;
import net.minecraft.client.Minecraft;

import net.mcreator.pixelpals.world.inventory.StatusScreenGuiMenu;
import net.mcreator.pixelpals.world.inventory.PokemonTameGuiMenu;
import net.mcreator.pixelpals.world.inventory.PokemonTameFailGuiMenu;
import net.mcreator.pixelpals.world.inventory.PKHEXGuiMenu;
import net.mcreator.pixelpals.network.MenuStateUpdateMessage;
import net.mcreator.pixelpals.PixelPals01Mod;

import java.util.Map;

public class PixelPals01ModMenus {
	public static final DeferredRegister<MenuType<?>> REGISTRY = DeferredRegister.create(Registries.MENU, PixelPals01Mod.MODID);
	public static final DeferredHolder<MenuType<?>, MenuType<PKHEXGuiMenu>> PKHEX_GUI = REGISTRY.register("pkhex_gui", () -> IMenuTypeExtension.create(PKHEXGuiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<PokemonTameGuiMenu>> POKEMON_TAME_GUI = REGISTRY.register("pokemon_tame_gui", () -> IMenuTypeExtension.create(PokemonTameGuiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<PokemonTameFailGuiMenu>> POKEMON_TAME_FAIL_GUI = REGISTRY.register("pokemon_tame_fail_gui", () -> IMenuTypeExtension.create(PokemonTameFailGuiMenu::new));
	public static final DeferredHolder<MenuType<?>, MenuType<StatusScreenGuiMenu>> STATUS_SCREEN_GUI = REGISTRY.register("status_screen_gui", () -> IMenuTypeExtension.create(StatusScreenGuiMenu::new));

	public interface MenuAccessor {
		Map<String, Object> getMenuState();

		Map<Integer, Slot> getSlots();

		default void sendMenuStateUpdate(Player player, int elementType, String name, Object elementState, boolean needClientUpdate) {
			getMenuState().put(elementType + ":" + name, elementState);
			if (player instanceof ServerPlayer serverPlayer) {
				PacketDistributor.sendToPlayer(serverPlayer, new MenuStateUpdateMessage(elementType, name, elementState));
			} else if (player.level().isClientSide) {
				if (Minecraft.getInstance().screen instanceof PixelPals01ModScreens.ScreenAccessor accessor && needClientUpdate)
					accessor.updateMenuState(elementType, name, elementState);
				PacketDistributor.sendToServer(new MenuStateUpdateMessage(elementType, name, elementState));
			}
		}

		default <T> T getMenuState(int elementType, String name, T defaultValue) {
			try {
				return (T) getMenuState().getOrDefault(elementType + ":" + name, defaultValue);
			} catch (ClassCastException e) {
				return defaultValue;
			}
		}
	}
}