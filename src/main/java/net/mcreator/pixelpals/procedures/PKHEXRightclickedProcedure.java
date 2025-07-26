package net.mcreator.pixelpals.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.MenuProvider;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.pixelpals.world.inventory.PKHEXGuiMenu;
import net.mcreator.pixelpals.init.PixelPals01ModMenus;
import net.mcreator.pixelpals.entity.PokemonEntity;

import io.netty.buffer.Unpooled;

public class PKHEXRightclickedProcedure {
	public static PokemonEntity pokemon;
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (entity instanceof PokemonEntity pkm)
			pokemon = pkm;
		entity.makeStuckInBlock(Blocks.AIR.defaultBlockState(), new Vec3(0.25, 0.05, 0.25));
		if (sourceentity instanceof ServerPlayer _ent) {
			BlockPos _bpos = BlockPos.containing(x, y, z);
			_ent.openMenu(new MenuProvider() {
				@Override
				public Component getDisplayName() {
					return Component.literal("PKHEXGui");
				}

				@Override
				public boolean shouldTriggerClientSideContainerClosingOnOpen() {
					return false;
				}

				@Override
				public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
					return new PKHEXGuiMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
				}
			}, _bpos);
		}
		if (sourceentity instanceof Player _player && _player.containerMenu instanceof PixelPals01ModMenus.MenuAccessor _menu)
			_menu.sendMenuStateUpdate(_player, 0, "Species", (entity instanceof PokemonEntity _datEntS ? _datEntS.getEntityData().get(PokemonEntity.DATA_Species) : ""), true);
		if (sourceentity instanceof Player _player && _player.containerMenu instanceof PixelPals01ModMenus.MenuAccessor _menu)
			_menu.sendMenuStateUpdate(_player, 0, "Level", ("" + (entity instanceof PokemonEntity _datEntI ? _datEntI.getEntityData().get(PokemonEntity.DATA_Level) : 0)), true);
	}
}