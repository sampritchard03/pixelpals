package net.mcreator.pixelpals.network;

import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;
import net.neoforged.neoforge.common.util.INBTSerializable;
import net.neoforged.neoforge.attachment.AttachmentType;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.chat.Component;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.HolderLookup;

import net.mcreator.pixelpals.PixelPals01Mod;

import java.util.function.Supplier;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class PixelPals01ModVariables {
	public static final DeferredRegister<AttachmentType<?>> ATTACHMENT_TYPES = DeferredRegister.create(NeoForgeRegistries.Keys.ATTACHMENT_TYPES, PixelPals01Mod.MODID);
	public static final Supplier<AttachmentType<PlayerVariables>> PLAYER_VARIABLES = ATTACHMENT_TYPES.register("player_variables", () -> AttachmentType.serializable(() -> new PlayerVariables()).build());

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		PixelPals01Mod.addNetworkMessage(PlayerVariablesSyncMessage.TYPE, PlayerVariablesSyncMessage.STREAM_CODEC, PlayerVariablesSyncMessage::handleData);
	}

	@EventBusSubscriber
	public static class EventBusVariableHandlers {
		@SubscribeEvent
		public static void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
			if (event.getEntity() instanceof ServerPlayer player)
				player.getData(PLAYER_VARIABLES).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
			if (event.getEntity() instanceof ServerPlayer player)
				player.getData(PLAYER_VARIABLES).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
			if (event.getEntity() instanceof ServerPlayer player)
				player.getData(PLAYER_VARIABLES).syncPlayerVariables(event.getEntity());
		}

		@SubscribeEvent
		public static void clonePlayer(PlayerEvent.Clone event) {
			PlayerVariables original = event.getOriginal().getData(PLAYER_VARIABLES);
			PlayerVariables clone = new PlayerVariables();
			clone.p1_BagStatus = original.p1_BagStatus;
			clone.p1_Level = original.p1_Level;
			clone.p1_SadTimer = original.p1_SadTimer;
			clone.p1_Species = original.p1_Species;
			clone.p2_BagStatus = original.p2_BagStatus;
			clone.p2_Level = original.p2_Level;
			clone.p2_SadTimer = original.p2_SadTimer;
			clone.p2_Species = original.p2_Species;
			clone.p3_BagStatus = original.p3_BagStatus;
			clone.p3_Level = original.p3_Level;
			clone.p3_SadTimer = original.p3_SadTimer;
			clone.p3_Species = original.p3_Species;
			clone.p4_BagStatus = original.p4_BagStatus;
			clone.p4_Level = original.p4_Level;
			clone.p4_SadTimer = original.p4_SadTimer;
			clone.p4_Species = original.p4_Species;
			clone.p5_BagStatus = original.p5_BagStatus;
			clone.p5_Level = original.p5_Level;
			clone.p5_SadTimer = original.p5_SadTimer;
			clone.p5_Species = original.p5_Species;
			clone.p6_Level = original.p6_Level;
			clone.p6_SadTimer = original.p6_SadTimer;
			clone.p6_Species = original.p6_Species;
			clone.p6_BagStatus = original.p6_BagStatus;
			clone.p1 = original.p1;
			clone.p2 = original.p2;
			clone.p3 = original.p3;
			clone.p4 = original.p4;
			clone.p5 = original.p5;
			clone.p6 = original.p6;
			clone.pselected = original.pselected;
			if (!event.isWasDeath()) {
			}
			event.getEntity().setData(PLAYER_VARIABLES, clone);
		}
	}

	public static class PlayerVariables implements INBTSerializable<CompoundTag> {
		public String p1_BagStatus = "\"\"";
		public double p1_Level = 0;
		public double p1_SadTimer = 0;
		public String p1_Species = "\"\"";
		public String p2_BagStatus = "\"\"";
		public double p2_Level = 0;
		public double p2_SadTimer = 0;
		public String p2_Species = "0";
		public String p3_BagStatus = "\"\"";
		public double p3_Level = 0;
		public double p3_SadTimer = 0;
		public String p3_Species = "\"\"";
		public String p4_BagStatus = "\"\"";
		public double p4_Level = 0;
		public double p4_SadTimer = 0;
		public String p4_Species = "\"\"";
		public String p5_BagStatus = "\"\"";
		public double p5_Level = 0;
		public double p5_SadTimer = 0;
		public String p5_Species = "\"\"";
		public double p6_Level = 0;
		public double p6_SadTimer = 0;
		public String p6_Species = "\"\"";
		public String p6_BagStatus = "\"\"";
		public ItemStack p1 = ItemStack.EMPTY;
		public ItemStack p2 = ItemStack.EMPTY;
		public ItemStack p3 = ItemStack.EMPTY;
		public ItemStack p4 = ItemStack.EMPTY;
		public ItemStack p5 = ItemStack.EMPTY;
		public ItemStack p6 = ItemStack.EMPTY;
		public double pselected = 1.0;

		@Override
		public CompoundTag serializeNBT(HolderLookup.Provider lookupProvider) {
			CompoundTag nbt = new CompoundTag();
			nbt.putString("p1_BagStatus", p1_BagStatus);
			nbt.putDouble("p1_Level", p1_Level);
			nbt.putDouble("p1_SadTimer", p1_SadTimer);
			nbt.putString("p1_Species", p1_Species);
			nbt.putString("p2_BagStatus", p2_BagStatus);
			nbt.putDouble("p2_Level", p2_Level);
			nbt.putDouble("p2_SadTimer", p2_SadTimer);
			nbt.putString("p2_Species", p2_Species);
			nbt.putString("p3_BagStatus", p3_BagStatus);
			nbt.putDouble("p3_Level", p3_Level);
			nbt.putDouble("p3_SadTimer", p3_SadTimer);
			nbt.putString("p3_Species", p3_Species);
			nbt.putString("p4_BagStatus", p4_BagStatus);
			nbt.putDouble("p4_Level", p4_Level);
			nbt.putDouble("p4_SadTimer", p4_SadTimer);
			nbt.putString("p4_Species", p4_Species);
			nbt.putString("p5_BagStatus", p5_BagStatus);
			nbt.putDouble("p5_Level", p5_Level);
			nbt.putDouble("p5_SadTimer", p5_SadTimer);
			nbt.putString("p5_Species", p5_Species);
			nbt.putDouble("p6_Level", p6_Level);
			nbt.putDouble("p6_SadTimer", p6_SadTimer);
			nbt.putString("p6_Species", p6_Species);
			nbt.putString("p6_BagStatus", p6_BagStatus);
			nbt.put("p1", p1.saveOptional(lookupProvider));
			nbt.put("p2", p2.saveOptional(lookupProvider));
			nbt.put("p3", p3.saveOptional(lookupProvider));
			nbt.put("p4", p4.saveOptional(lookupProvider));
			nbt.put("p5", p5.saveOptional(lookupProvider));
			nbt.put("p6", p6.saveOptional(lookupProvider));
			nbt.putDouble("pselected", pselected);
			return nbt;
		}

		@Override
		public void deserializeNBT(HolderLookup.Provider lookupProvider, CompoundTag nbt) {
			p1_BagStatus = nbt.getString("p1_BagStatus");
			p1_Level = nbt.getDouble("p1_Level");
			p1_SadTimer = nbt.getDouble("p1_SadTimer");
			p1_Species = nbt.getString("p1_Species");
			p2_BagStatus = nbt.getString("p2_BagStatus");
			p2_Level = nbt.getDouble("p2_Level");
			p2_SadTimer = nbt.getDouble("p2_SadTimer");
			p2_Species = nbt.getString("p2_Species");
			p3_BagStatus = nbt.getString("p3_BagStatus");
			p3_Level = nbt.getDouble("p3_Level");
			p3_SadTimer = nbt.getDouble("p3_SadTimer");
			p3_Species = nbt.getString("p3_Species");
			p4_BagStatus = nbt.getString("p4_BagStatus");
			p4_Level = nbt.getDouble("p4_Level");
			p4_SadTimer = nbt.getDouble("p4_SadTimer");
			p4_Species = nbt.getString("p4_Species");
			p5_BagStatus = nbt.getString("p5_BagStatus");
			p5_Level = nbt.getDouble("p5_Level");
			p5_SadTimer = nbt.getDouble("p5_SadTimer");
			p5_Species = nbt.getString("p5_Species");
			p6_Level = nbt.getDouble("p6_Level");
			p6_SadTimer = nbt.getDouble("p6_SadTimer");
			p6_Species = nbt.getString("p6_Species");
			p6_BagStatus = nbt.getString("p6_BagStatus");
			p1 = ItemStack.parseOptional(lookupProvider, nbt.getCompound("p1"));
			p2 = ItemStack.parseOptional(lookupProvider, nbt.getCompound("p2"));
			p3 = ItemStack.parseOptional(lookupProvider, nbt.getCompound("p3"));
			p4 = ItemStack.parseOptional(lookupProvider, nbt.getCompound("p4"));
			p5 = ItemStack.parseOptional(lookupProvider, nbt.getCompound("p5"));
			p6 = ItemStack.parseOptional(lookupProvider, nbt.getCompound("p6"));
			pselected = nbt.getDouble("pselected");
		}

		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayer serverPlayer)
				PacketDistributor.sendToPlayer(serverPlayer, new PlayerVariablesSyncMessage(this));
		}
	}

	public record PlayerVariablesSyncMessage(PlayerVariables data) implements CustomPacketPayload {
		public static final Type<PlayerVariablesSyncMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(PixelPals01Mod.MODID, "player_variables_sync"));
		public static final StreamCodec<RegistryFriendlyByteBuf, PlayerVariablesSyncMessage> STREAM_CODEC = StreamCodec
				.of((RegistryFriendlyByteBuf buffer, PlayerVariablesSyncMessage message) -> buffer.writeNbt(message.data().serializeNBT(buffer.registryAccess())), (RegistryFriendlyByteBuf buffer) -> {
					PlayerVariablesSyncMessage message = new PlayerVariablesSyncMessage(new PlayerVariables());
					message.data.deserializeNBT(buffer.registryAccess(), buffer.readNbt());
					return message;
				});

		@Override
		public Type<PlayerVariablesSyncMessage> type() {
			return TYPE;
		}

		public static void handleData(final PlayerVariablesSyncMessage message, final IPayloadContext context) {
			if (context.flow() == PacketFlow.CLIENTBOUND && message.data != null) {
				context.enqueueWork(() -> context.player().getData(PLAYER_VARIABLES).deserializeNBT(context.player().registryAccess(), message.data.serializeNBT(context.player().registryAccess()))).exceptionally(e -> {
					context.connection().disconnect(Component.literal(e.getMessage()));
					return null;
				});
			}
		}
	}
}