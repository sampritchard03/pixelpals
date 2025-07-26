package net.mcreator.pixelpals.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.pixelpals.network.PixelPals01ModVariables;
import net.mcreator.pixelpals.init.PixelPals01ModMenus;

public class StatusScreenGuiThisGUIIsOpenedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PixelPals01ModMenus.MenuAccessor _menu0 ? _menu0.getSlots().get(2).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()) {
			if (entity instanceof Player _player && _player.containerMenu instanceof PixelPals01ModMenus.MenuAccessor _menu) {
				ItemStack _setstack = entity.getData(PixelPals01ModVariables.PLAYER_VARIABLES).p1.copy();
				_setstack.setCount(1);
				_menu.getSlots().get(2).set(_setstack);
				_player.containerMenu.broadcastChanges();
			}
		}
		{
			PixelPals01ModVariables.PlayerVariables _vars = entity.getData(PixelPals01ModVariables.PLAYER_VARIABLES);
			_vars.p1 = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PixelPals01ModMenus.MenuAccessor _menu4 ? _menu4.getSlots().get(2).getItem() : ItemStack.EMPTY).copy();
			_vars.syncPlayerVariables(entity);
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PixelPals01ModMenus.MenuAccessor _menu5 ? _menu5.getSlots().get(5).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()) {
			if (entity instanceof Player _player && _player.containerMenu instanceof PixelPals01ModMenus.MenuAccessor _menu) {
				ItemStack _setstack = entity.getData(PixelPals01ModVariables.PLAYER_VARIABLES).p2.copy();
				_setstack.setCount(1);
				_menu.getSlots().get(5).set(_setstack);
				_player.containerMenu.broadcastChanges();
			}
		}
		{
			PixelPals01ModVariables.PlayerVariables _vars = entity.getData(PixelPals01ModVariables.PLAYER_VARIABLES);
			_vars.p2 = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PixelPals01ModMenus.MenuAccessor _menu9 ? _menu9.getSlots().get(5).getItem() : ItemStack.EMPTY).copy();
			_vars.syncPlayerVariables(entity);
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PixelPals01ModMenus.MenuAccessor _menu10 ? _menu10.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()) {
			if (entity instanceof Player _player && _player.containerMenu instanceof PixelPals01ModMenus.MenuAccessor _menu) {
				ItemStack _setstack = entity.getData(PixelPals01ModVariables.PLAYER_VARIABLES).p3.copy();
				_setstack.setCount(1);
				_menu.getSlots().get(1).set(_setstack);
				_player.containerMenu.broadcastChanges();
			}
		}
		{
			PixelPals01ModVariables.PlayerVariables _vars = entity.getData(PixelPals01ModVariables.PLAYER_VARIABLES);
			_vars.p3 = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PixelPals01ModMenus.MenuAccessor _menu14 ? _menu14.getSlots().get(1).getItem() : ItemStack.EMPTY).copy();
			_vars.syncPlayerVariables(entity);
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PixelPals01ModMenus.MenuAccessor _menu15 ? _menu15.getSlots().get(4).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()) {
			if (entity instanceof Player _player && _player.containerMenu instanceof PixelPals01ModMenus.MenuAccessor _menu) {
				ItemStack _setstack = entity.getData(PixelPals01ModVariables.PLAYER_VARIABLES).p4.copy();
				_setstack.setCount(1);
				_menu.getSlots().get(4).set(_setstack);
				_player.containerMenu.broadcastChanges();
			}
		}
		{
			PixelPals01ModVariables.PlayerVariables _vars = entity.getData(PixelPals01ModVariables.PLAYER_VARIABLES);
			_vars.p4 = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PixelPals01ModMenus.MenuAccessor _menu19 ? _menu19.getSlots().get(4).getItem() : ItemStack.EMPTY).copy();
			_vars.syncPlayerVariables(entity);
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PixelPals01ModMenus.MenuAccessor _menu20 ? _menu20.getSlots().get(0).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()) {
			if (entity instanceof Player _player && _player.containerMenu instanceof PixelPals01ModMenus.MenuAccessor _menu) {
				ItemStack _setstack = entity.getData(PixelPals01ModVariables.PLAYER_VARIABLES).p5.copy();
				_setstack.setCount(1);
				_menu.getSlots().get(0).set(_setstack);
				_player.containerMenu.broadcastChanges();
			}
		}
		{
			PixelPals01ModVariables.PlayerVariables _vars = entity.getData(PixelPals01ModVariables.PLAYER_VARIABLES);
			_vars.p5 = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PixelPals01ModMenus.MenuAccessor _menu24 ? _menu24.getSlots().get(0).getItem() : ItemStack.EMPTY).copy();
			_vars.syncPlayerVariables(entity);
		}
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PixelPals01ModMenus.MenuAccessor _menu25 ? _menu25.getSlots().get(3).getItem() : ItemStack.EMPTY).getItem() == ItemStack.EMPTY.getItem()) {
			if (entity instanceof Player _player && _player.containerMenu instanceof PixelPals01ModMenus.MenuAccessor _menu) {
				ItemStack _setstack = entity.getData(PixelPals01ModVariables.PLAYER_VARIABLES).p6.copy();
				_setstack.setCount(1);
				_menu.getSlots().get(3).set(_setstack);
				_player.containerMenu.broadcastChanges();
			}
		}
		{
			PixelPals01ModVariables.PlayerVariables _vars = entity.getData(PixelPals01ModVariables.PLAYER_VARIABLES);
			_vars.p6 = (entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof PixelPals01ModMenus.MenuAccessor _menu29 ? _menu29.getSlots().get(3).getItem() : ItemStack.EMPTY).copy();
			_vars.syncPlayerVariables(entity);
		}
	}
}