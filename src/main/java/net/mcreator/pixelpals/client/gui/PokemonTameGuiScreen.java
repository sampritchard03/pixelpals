package net.mcreator.pixelpals.client.gui;

public class PokemonTameGuiScreen extends AbstractContainerScreen<PokemonTameGuiMenu> implements PixelPals01ModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;

	public PokemonTameGuiScreen(PokemonTameGuiMenu container, Inventory inventory, Component text) {
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
		menuStateUpdateActive = false;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("pixel_pals_01:textures/screens/pokemon_tame_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		if (PokemonGuiEntityProcedureProcedure.execute(world, x, y, z, entity) instanceof LivingEntity livingEntity) {
			PixelPals01ModScreens.renderEntityInInventoryFollowsAngle(guiGraphics, this.leftPos + 90, this.topPos + 131, 50, 0f + (float) Math.atan((this.leftPos + 90 - mouseX) / 40.0), (float) Math.atan((this.topPos + 82 - mouseY) / 40.0),
					livingEntity);
		}
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int mouseX, int mouseY) {
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
		return super.keyPressed(key, b, c);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, PokemonGuiNameProcedureProcedure.execute(world, x, y, z, entity), 29, 134, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
	}
}