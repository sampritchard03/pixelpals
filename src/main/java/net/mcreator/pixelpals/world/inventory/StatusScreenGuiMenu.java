package net.mcreator.pixelpals.world.inventory;

import net.mcreator.pixelpals.PixelPals01Mod;

@EventBusSubscriber
public class StatusScreenGuiMenu extends AbstractContainerMenu implements PixelPals01ModMenus.MenuAccessor {
	public final Map<String, Object> menuState = new HashMap<>() {
		@Override
		public Object put(String key, Object value) {
			if (!this.containsKey(key) && this.size() >= 13)
				return null;
			return super.put(key, value);
		}
	};
	public final Level world;
	public final Player entity;
	public int x, y, z;
	private ContainerLevelAccess access = ContainerLevelAccess.NULL;
	private IItemHandler internal;
	private final Map<Integer, Slot> customSlots = new HashMap<>();
	private boolean bound = false;
	private Supplier<Boolean> boundItemMatcher = null;
	private Entity boundEntity = null;
	private BlockEntity boundBlockEntity = null;

	public StatusScreenGuiMenu(int id, Inventory inv, FriendlyByteBuf extraData) {
		super(PixelPals01ModMenus.STATUS_SCREEN_GUI.get(), id);
		this.entity = inv.player;
		this.world = inv.player.level();
		this.internal = new ItemStackHandler(6);
		BlockPos pos = null;
		if (extraData != null) {
			pos = extraData.readBlockPos();
			this.x = pos.getX();
			this.y = pos.getY();
			this.z = pos.getZ();
			access = ContainerLevelAccess.create(world, pos);
		}
		if (pos != null) {
			if (extraData.readableBytes() == 1) { // bound to item
				byte hand = extraData.readByte();
				ItemStack itemstack = hand == 0 ? this.entity.getMainHandItem() : this.entity.getOffhandItem();
				this.boundItemMatcher = () -> itemstack == (hand == 0 ? this.entity.getMainHandItem() : this.entity.getOffhandItem());
				IItemHandler cap = itemstack.getCapability(Capabilities.ItemHandler.ITEM);
				if (cap != null) {
					this.internal = cap;
					this.bound = true;
				}
			} else if (extraData.readableBytes() > 1) { // bound to entity
				extraData.readByte(); // drop padding
				boundEntity = world.getEntity(extraData.readVarInt());
				if (boundEntity != null) {
					IItemHandler cap = boundEntity.getCapability(Capabilities.ItemHandler.ENTITY);
					if (cap != null) {
						this.internal = cap;
						this.bound = true;
					}
				}
			} else { // might be bound to block
				boundBlockEntity = this.world.getBlockEntity(pos);
				if (boundBlockEntity instanceof BaseContainerBlockEntity baseContainerBlockEntity) {
					this.internal = new InvWrapper(baseContainerBlockEntity);
					this.bound = true;
				}
			}
		}
		this.customSlots.put(0, this.addSlot(new SlotItemHandler(internal, 0, 45, 136) {
			private final int slot = 0;
			private int x = StatusScreenGuiMenu.this.x;
			private int y = StatusScreenGuiMenu.this.y;

			@Override
			public boolean mayPickup(Player entity) {
				return !StatusScreenSlotChange5Procedure.execute(entity);
			}

			@Override
			public boolean mayPlace(ItemStack stack) {
				return PixelPals01ModItems.POKEBALL_OCCUPIED.get() == stack.getItem();
			}
		}));
		this.customSlots.put(1, this.addSlot(new SlotItemHandler(internal, 1, 45, 79) {
			private final int slot = 1;
			private int x = StatusScreenGuiMenu.this.x;
			private int y = StatusScreenGuiMenu.this.y;

			@Override
			public boolean mayPickup(Player entity) {
				return !StatusScreenSlotChange3Procedure.execute(entity);
			}

			@Override
			public boolean mayPlace(ItemStack stack) {
				return PixelPals01ModItems.POKEBALL_OCCUPIED.get() == stack.getItem();
			}
		}));
		this.customSlots.put(2, this.addSlot(new SlotItemHandler(internal, 2, 45, 21) {
			private final int slot = 2;
			private int x = StatusScreenGuiMenu.this.x;
			private int y = StatusScreenGuiMenu.this.y;

			@Override
			public boolean mayPickup(Player entity) {
				return !StatusScreenSlotChange0Procedure.execute(entity);
			}

			@Override
			public boolean mayPlace(ItemStack stack) {
				return PixelPals01ModItems.POKEBALL_OCCUPIED.get() == stack.getItem();
			}
		}));
		this.customSlots.put(3, this.addSlot(new SlotItemHandler(internal, 3, 309, 136) {
			private final int slot = 3;
			private int x = StatusScreenGuiMenu.this.x;
			private int y = StatusScreenGuiMenu.this.y;

			@Override
			public boolean mayPickup(Player entity) {
				return !StatusScreenSlotChange6Procedure.execute(entity);
			}

			@Override
			public boolean mayPlace(ItemStack stack) {
				return PixelPals01ModItems.POKEBALL_OCCUPIED.get() == stack.getItem();
			}
		}));
		this.customSlots.put(4, this.addSlot(new SlotItemHandler(internal, 4, 309, 79) {
			private final int slot = 4;
			private int x = StatusScreenGuiMenu.this.x;
			private int y = StatusScreenGuiMenu.this.y;

			@Override
			public boolean mayPickup(Player entity) {
				return !StatusScreenSlotChange4Procedure.execute(entity);
			}

			@Override
			public boolean mayPlace(ItemStack stack) {
				return PixelPals01ModItems.POKEBALL_OCCUPIED.get() == stack.getItem();
			}
		}));
		this.customSlots.put(5, this.addSlot(new SlotItemHandler(internal, 5, 309, 21) {
			private final int slot = 5;
			private int x = StatusScreenGuiMenu.this.x;
			private int y = StatusScreenGuiMenu.this.y;

			@Override
			public boolean mayPickup(Player entity) {
				return !StatusScreenSlotChange2Procedure.execute(entity);
			}

			@Override
			public boolean mayPlace(ItemStack stack) {
				return PixelPals01ModItems.POKEBALL_OCCUPIED.get() == stack.getItem();
			}
		}));
		for (int si = 0; si < 3; ++si)
			for (int sj = 0; sj < 9; ++sj)
				this.addSlot(new Slot(inv, sj + (si + 1) * 9, 93 + 8 + sj * 18, 31 + 84 + si * 18));
		for (int si = 0; si < 9; ++si)
			this.addSlot(new Slot(inv, si, 93 + 8 + si * 18, 31 + 142));
	}

	@Override
	public boolean stillValid(Player player) {
		if (this.bound) {
			if (this.boundItemMatcher != null)
				return this.boundItemMatcher.get();
			else if (this.boundBlockEntity != null)
				return AbstractContainerMenu.stillValid(this.access, player, this.boundBlockEntity.getBlockState().getBlock());
			else if (this.boundEntity != null)
				return this.boundEntity.isAlive();
		}
		return true;
	}

	@Override
	public ItemStack quickMoveStack(Player playerIn, int index) {
		ItemStack itemstack = ItemStack.EMPTY;
		Slot slot = (Slot) this.slots.get(index);
		if (slot != null && slot.hasItem()) {
			ItemStack itemstack1 = slot.getItem();
			itemstack = itemstack1.copy();
			if (index < 6) {
				if (!this.moveItemStackTo(itemstack1, 6, this.slots.size(), true))
					return ItemStack.EMPTY;
				slot.onQuickCraft(itemstack1, itemstack);
			} else if (!this.moveItemStackTo(itemstack1, 0, 6, false)) {
				if (index < 6 + 27) {
					if (!this.moveItemStackTo(itemstack1, 6 + 27, this.slots.size(), true))
						return ItemStack.EMPTY;
				} else {
					if (!this.moveItemStackTo(itemstack1, 6, 6 + 27, false))
						return ItemStack.EMPTY;
				}
				return ItemStack.EMPTY;
			}
			if (itemstack1.isEmpty()) {
				slot.setByPlayer(ItemStack.EMPTY);
			} else {
				slot.setChanged();
			}
			if (itemstack1.getCount() == itemstack.getCount()) {
				return ItemStack.EMPTY;
			}
			slot.onTake(playerIn, itemstack1);
		}
		return itemstack;
	}

	@Override /* failed to load code for net.minecraft.world.inventory.AbstractContainerMenu */
	@Override
	public void removed(Player playerIn) {
		super.removed(playerIn);
		if (!bound && playerIn instanceof ServerPlayer serverPlayer) {
			if (!serverPlayer.isAlive() || serverPlayer.hasDisconnected()) {
				for (int j = 0; j < internal.getSlots(); ++j) {
					if (j == 0)
						continue;
					if (j == 1)
						continue;
					if (j == 2)
						continue;
					if (j == 3)
						continue;
					if (j == 4)
						continue;
					if (j == 5)
						continue;
					playerIn.drop(internal.getStackInSlot(j), false);
					if (internal instanceof IItemHandlerModifiable ihm)
						ihm.setStackInSlot(j, ItemStack.EMPTY);
				}
			} else {
				for (int i = 0; i < internal.getSlots(); ++i) {
					if (i == 0)
						continue;
					if (i == 1)
						continue;
					if (i == 2)
						continue;
					if (i == 3)
						continue;
					if (i == 4)
						continue;
					if (i == 5)
						continue;
					playerIn.getInventory().placeItemBackInInventory(internal.getStackInSlot(i));
					if (internal instanceof IItemHandlerModifiable ihm)
						ihm.setStackInSlot(i, ItemStack.EMPTY);
				}
			}
		}
	}

	@Override
	public Map<Integer, Slot> getSlots() {
		return Collections.unmodifiableMap(customSlots);
	}

	@Override
	public Map<String, Object> getMenuState() {
		return menuState;
	}

	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		Player entity = event.getEntity();
		if (entity.containerMenu instanceof StatusScreenGuiMenu menu) {
			Level world = menu.world;
			double x = menu.x;
			double y = menu.y;
			double z = menu.z;
			StatusScreenGuiThisGUIIsOpenedProcedure.execute(entity);
		}
	}
}