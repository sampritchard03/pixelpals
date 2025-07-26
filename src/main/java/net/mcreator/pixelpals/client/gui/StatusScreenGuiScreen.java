package net.mcreator.pixelpals.client.gui;

public class StatusScreenGuiScreen extends AbstractContainerScreen<StatusScreenGuiMenu> implements PixelPals01ModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	Button button_view_slot_1;
	Button button_view_slot_2;
	Button button_view_slot_3;
	Button button_select_slot_2;
	Button button_select_slot_4;
	Button button_select_slot_6;

	public StatusScreenGuiScreen(StatusScreenGuiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 370;
		this.imageHeight = 200;
	}

	@Override
	public void updateMenuState(int elementType, String name, Object elementState) {
		menuStateUpdateActive = true;
		menuStateUpdateActive = false;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("pixel_pals_01:textures/screens/status_screen_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		if (StatusScreenGetSelectedEntityModelProcedure.execute(world, entity) instanceof LivingEntity livingEntity) {
			PixelPals01ModScreens.renderEntityInInventoryFollowsAngle(guiGraphics, this.leftPos + 181, this.topPos + 58, 100, 0f + (float) Math.atan((this.leftPos + 181 - mouseX) / 40.0), (float) Math.atan((this.topPos + 9 - mouseY) / 40.0),
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
	}

	@Override
	public void init() {
		super.init();
		button_view_slot_1 = Button.builder(Component.translatable("gui.pixel_pals_01.status_screen_gui.button_view_slot_1"), e -> {
			int x = StatusScreenGuiScreen.this.x;
			int y = StatusScreenGuiScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new StatusScreenGuiButtonMessage(0, x, y, z));
				StatusScreenGuiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 10, this.topPos + 46, 82, 20).build();
		this.addRenderableWidget(button_view_slot_1);
		button_view_slot_2 = Button.builder(Component.translatable("gui.pixel_pals_01.status_screen_gui.button_view_slot_2"), e -> {
			int x = StatusScreenGuiScreen.this.x;
			int y = StatusScreenGuiScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new StatusScreenGuiButtonMessage(1, x, y, z));
				StatusScreenGuiButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 10, this.topPos + 105, 82, 20).build();
		this.addRenderableWidget(button_view_slot_2);
		button_view_slot_3 = Button.builder(Component.translatable("gui.pixel_pals_01.status_screen_gui.button_view_slot_3"), e -> {
			int x = StatusScreenGuiScreen.this.x;
			int y = StatusScreenGuiScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new StatusScreenGuiButtonMessage(2, x, y, z));
				StatusScreenGuiButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}).bounds(this.leftPos + 11, this.topPos + 161, 82, 20).build();
		this.addRenderableWidget(button_view_slot_3);
		button_select_slot_2 = Button.builder(Component.translatable("gui.pixel_pals_01.status_screen_gui.button_select_slot_2"), e -> {
			int x = StatusScreenGuiScreen.this.x;
			int y = StatusScreenGuiScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new StatusScreenGuiButtonMessage(3, x, y, z));
				StatusScreenGuiButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}).bounds(this.leftPos + 269, this.topPos + 46, 92, 20).build();
		this.addRenderableWidget(button_select_slot_2);
		button_select_slot_4 = Button.builder(Component.translatable("gui.pixel_pals_01.status_screen_gui.button_select_slot_4"), e -> {
			int x = StatusScreenGuiScreen.this.x;
			int y = StatusScreenGuiScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new StatusScreenGuiButtonMessage(4, x, y, z));
				StatusScreenGuiButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		}).bounds(this.leftPos + 269, this.topPos + 105, 92, 20).build();
		this.addRenderableWidget(button_select_slot_4);
		button_select_slot_6 = Button.builder(Component.translatable("gui.pixel_pals_01.status_screen_gui.button_select_slot_6"), e -> {
			int x = StatusScreenGuiScreen.this.x;
			int y = StatusScreenGuiScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new StatusScreenGuiButtonMessage(5, x, y, z));
				StatusScreenGuiButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		}).bounds(this.leftPos + 269, this.topPos + 162, 92, 20).build();
		this.addRenderableWidget(button_select_slot_6);
	}
}