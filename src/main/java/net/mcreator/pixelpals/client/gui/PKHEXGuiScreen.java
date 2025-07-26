package net.mcreator.pixelpals.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.Minecraft;

import net.mcreator.pixelpals.world.inventory.PKHEXGuiMenu;
import net.mcreator.pixelpals.init.PixelPals01ModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class PKHEXGuiScreen extends AbstractContainerScreen<PKHEXGuiMenu> implements PixelPals01ModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	EditBox Species;
	EditBox Level;
	EditBox Shiny;

	public PKHEXGuiScreen(PKHEXGuiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	@Override
	public void updateMenuState(int elementType, String name, Object elementState) {
		menuStateUpdateActive = true;
		if (elementType == 0 && elementState instanceof String stringState) {
			if (name.equals("Species"))
				Species.setValue(stringState);
			else if (name.equals("Level"))
				Level.setValue(stringState);
			else if (name.equals("Shiny"))
				Shiny.setValue(stringState);
		}
		menuStateUpdateActive = false;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("pixel_pals_01:textures/screens/pkhex_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		Species.render(guiGraphics, mouseX, mouseY, partialTicks);
		Level.render(guiGraphics, mouseX, mouseY, partialTicks);
		Shiny.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(RenderType::guiTextured, texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		if (Species.isFocused())
			return Species.keyPressed(key, b, c);
		if (Level.isFocused())
			return Level.keyPressed(key, b, c);
		if (Shiny.isFocused())
			return Shiny.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void resize(Minecraft minecraft, int width, int height) {
		String SpeciesValue = Species.getValue();
		String LevelValue = Level.getValue();
		String ShinyValue = Shiny.getValue();
		super.resize(minecraft, width, height);
		Species.setValue(SpeciesValue);
		Level.setValue(LevelValue);
		Shiny.setValue(ShinyValue);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.pixel_pals_01.pkhex_gui.label_species_format_species"), 20, 18, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.pixel_pals_01.pkhex_gui.label_level_format_integer"), 31, 66, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.pixel_pals_01.pkhex_gui.label_isshiny"), 68, 112, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		Species = new EditBox(this.font, this.leftPos + 28, this.topPos + 35, 118, 18, Component.translatable("gui.pixel_pals_01.pkhex_gui.Species"));
		Species.setMaxLength(8192);
		Species.setResponder(content -> {
			if (!menuStateUpdateActive)
				menu.sendMenuStateUpdate(entity, 0, "Species", content, false);
		});
		Species.setHint(Component.translatable("gui.pixel_pals_01.pkhex_gui.Species"));
		this.addWidget(this.Species);
		Level = new EditBox(this.font, this.leftPos + 30, this.topPos + 79, 118, 18, Component.translatable("gui.pixel_pals_01.pkhex_gui.Level"));
		Level.setMaxLength(8192);
		Level.setResponder(content -> {
			if (!menuStateUpdateActive)
				menu.sendMenuStateUpdate(entity, 0, "Level", content, false);
		});
		Level.setHint(Component.translatable("gui.pixel_pals_01.pkhex_gui.Level"));
		this.addWidget(this.Level);
		Shiny = new EditBox(this.font, this.leftPos + 29, this.topPos + 129, 118, 18, Component.translatable("gui.pixel_pals_01.pkhex_gui.Shiny"));
		Shiny.setMaxLength(8192);
		Shiny.setResponder(content -> {
			if (!menuStateUpdateActive)
				menu.sendMenuStateUpdate(entity, 0, "Shiny", content, false);
		});
		this.addWidget(this.Shiny);
	}
}