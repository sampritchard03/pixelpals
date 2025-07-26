/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.pixelpals.init;

import org.joml.Vector3f;
import org.joml.Quaternionf;

import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.pixelpals.client.gui.StatusScreenGuiScreen;
import net.mcreator.pixelpals.client.gui.PokemonTameGuiScreen;
import net.mcreator.pixelpals.client.gui.PokemonTameFailGuiScreen;
import net.mcreator.pixelpals.client.gui.PKHEXGuiScreen;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class PixelPals01ModScreens {
	@SubscribeEvent
	public static void clientLoad(RegisterMenuScreensEvent event) {
		event.register(PixelPals01ModMenus.PKHEX_GUI.get(), PKHEXGuiScreen::new);
		event.register(PixelPals01ModMenus.POKEMON_TAME_GUI.get(), PokemonTameGuiScreen::new);
		event.register(PixelPals01ModMenus.POKEMON_TAME_FAIL_GUI.get(), PokemonTameFailGuiScreen::new);
		event.register(PixelPals01ModMenus.STATUS_SCREEN_GUI.get(), StatusScreenGuiScreen::new);
	}

	public interface ScreenAccessor {
		void updateMenuState(int elementType, String name, Object elementState);
	}

	public static void renderEntityInInventoryFollowsAngle(GuiGraphics guiGraphics, int x, int y, int scale, float angleXComponent, float angleYComponent, LivingEntity entity) {
		Quaternionf pose = new Quaternionf().rotateZ((float) Math.PI);
		Quaternionf cameraOrientation = new Quaternionf().rotateX(angleYComponent * 20 * ((float) Math.PI / 180F));
		pose.mul(cameraOrientation);
		float f2 = entity.yBodyRot;
		float f3 = entity.getYRot();
		float f4 = entity.getXRot();
		float f5 = entity.yHeadRotO;
		float f6 = entity.yHeadRot;
		entity.yBodyRot = 180.0F + angleXComponent * 20.0F;
		entity.setYRot(180.0F + angleXComponent * 40.0F);
		entity.setXRot(-angleYComponent * 20.0F);
		entity.yHeadRot = entity.getYRot();
		entity.yHeadRotO = entity.getYRot();
		InventoryScreen.renderEntityInInventory(guiGraphics, x, y, scale, new Vector3f(0, 0, 0), pose, cameraOrientation, entity);
		entity.yBodyRot = f2;
		entity.setYRot(f3);
		entity.setXRot(f4);
		entity.yHeadRotO = f5;
		entity.yHeadRot = f6;
	}
}