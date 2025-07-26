package net.mcreator.pixelpals.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.pixelpals.network.PixelPals01ModVariables;

public class StatusScreenSelectSlot4Procedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			PixelPals01ModVariables.PlayerVariables _vars = entity.getData(PixelPals01ModVariables.PLAYER_VARIABLES);
			_vars.pselected = 4;
			_vars.syncPlayerVariables(entity);
		}
	}
}