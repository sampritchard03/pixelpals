package net.mcreator.pixelpals.network;

import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.chat.Component;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.pixelpals.procedures.StatusScreenSelectSlot6Procedure;
import net.mcreator.pixelpals.procedures.StatusScreenSelectSlot5Procedure;
import net.mcreator.pixelpals.procedures.StatusScreenSelectSlot4Procedure;
import net.mcreator.pixelpals.procedures.StatusScreenSelectSlot3Procedure;
import net.mcreator.pixelpals.procedures.StatusScreenSelectSlot2Procedure;
import net.mcreator.pixelpals.procedures.StatusScreenSelectSlot1Procedure;
import net.mcreator.pixelpals.PixelPals01Mod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public record StatusScreenGuiButtonMessage(int buttonID, int x, int y, int z) implements CustomPacketPayload {

	public static final Type<StatusScreenGuiButtonMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(PixelPals01Mod.MODID, "status_screen_gui_buttons"));
	public static final StreamCodec<RegistryFriendlyByteBuf, StatusScreenGuiButtonMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, StatusScreenGuiButtonMessage message) -> {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}, (RegistryFriendlyByteBuf buffer) -> new StatusScreenGuiButtonMessage(buffer.readInt(), buffer.readInt(), buffer.readInt(), buffer.readInt()));
	@Override
	public Type<StatusScreenGuiButtonMessage> type() {
		return TYPE;
	}

	public static void handleData(final StatusScreenGuiButtonMessage message, final IPayloadContext context) {
		if (context.flow() == PacketFlow.SERVERBOUND) {
			context.enqueueWork(() -> handleButtonAction(context.player(), message.buttonID, message.x, message.y, message.z)).exceptionally(e -> {
				context.connection().disconnect(Component.literal(e.getMessage()));
				return null;
			});
		}
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level();
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			StatusScreenSelectSlot1Procedure.execute(entity);
		}
		if (buttonID == 1) {

			StatusScreenSelectSlot3Procedure.execute(entity);
		}
		if (buttonID == 2) {

			StatusScreenSelectSlot5Procedure.execute(entity);
		}
		if (buttonID == 3) {

			StatusScreenSelectSlot2Procedure.execute(entity);
		}
		if (buttonID == 4) {

			StatusScreenSelectSlot4Procedure.execute(entity);
		}
		if (buttonID == 5) {

			StatusScreenSelectSlot6Procedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		PixelPals01Mod.addNetworkMessage(StatusScreenGuiButtonMessage.TYPE, StatusScreenGuiButtonMessage.STREAM_CODEC, StatusScreenGuiButtonMessage::handleData);
	}
}