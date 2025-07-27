/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.pixelpals.init;

import org.lwjgl.glfw.GLFW;

import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

import net.mcreator.pixelpals.network.SendOutPokemonMessage;
import net.mcreator.pixelpals.network.OpenStatusScreenMessage;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class PixelPals01ModKeyMappings {
	public static final KeyMapping OPEN_STATUS_SCREEN = new KeyMapping("key.pixel_pals_01.open_status_screen", GLFW.GLFW_KEY_P, "key.categories.gameplay") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				PacketDistributor.sendToServer(new OpenStatusScreenMessage(0, 0));
				OpenStatusScreenMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping SEND_OUT_POKEMON = new KeyMapping("key.pixel_pals_01.send_out_pokemon", GLFW.GLFW_KEY_R, "key.categories.gameplay") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				PacketDistributor.sendToServer(new SendOutPokemonMessage(0, 0));
				SendOutPokemonMessage.pressAction(Minecraft.getInstance().player, 0, 0);
			}
			isDownOld = isDown;
		}
	};

	@SubscribeEvent
	public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(OPEN_STATUS_SCREEN);
		event.register(SEND_OUT_POKEMON);
	}

	@EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onClientTick(ClientTickEvent.Post event) {
			if (Minecraft.getInstance().screen == null) {
				OPEN_STATUS_SCREEN.consumeClick();
				SEND_OUT_POKEMON.consumeClick();
			}
		}
	}
}