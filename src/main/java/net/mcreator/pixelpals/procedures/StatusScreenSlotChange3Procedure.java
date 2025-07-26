package net.mcreator.pixelpals.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

import net.mcreator.pixelpals.network.PixelPals01ModVariables;

public class StatusScreenSlotChange3Procedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		{
			PixelPals01ModVariables.PlayerVariables _vars = entity.getData(PixelPals01ModVariables.PLAYER_VARIABLES);
			_vars.p3 = ItemStack.EMPTY.copy();
			_vars.syncPlayerVariables(entity);
		}
		return false;
	}
}