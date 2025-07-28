/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.pixelpals.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;

import net.mcreator.pixelpals.entity.PokemonEntity;
import net.mcreator.pixelpals.entity.PokeballProjectileEntity;
import net.mcreator.pixelpals.entity.PokeballOccupiedProjectileEntity;
import net.mcreator.pixelpals.entity.Lvl1LandPokeGeneratorEntity;
import net.mcreator.pixelpals.entity.ChestEntityEntity;
import net.mcreator.pixelpals.PixelPals01Mod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class PixelPals01ModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(Registries.ENTITY_TYPE, PixelPals01Mod.MODID);
	public static final DeferredHolder<EntityType<?>, EntityType<PokemonEntity>> POKEMON = register("pokemon",
			EntityType.Builder.<PokemonEntity>of(PokemonEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.ridingOffset(-0.6f).sized(0.7f, 2f));
	public static final DeferredHolder<EntityType<?>, EntityType<PokeballProjectileEntity>> POKEBALL_PROJECTILE = register("pokeball_projectile",
			EntityType.Builder.<PokeballProjectileEntity>of(PokeballProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<Lvl1LandPokeGeneratorEntity>> LVL_1_LAND_POKE_GENERATOR = register("lvl_1_land_poke_generator",
			EntityType.Builder.<Lvl1LandPokeGeneratorEntity>of(Lvl1LandPokeGeneratorEntity::new, MobCategory.AMBIENT).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.ridingOffset(-0.6f).sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<PokeballOccupiedProjectileEntity>> POKEBALL_OCCUPIED_PROJECTILE = register("pokeball_occupied_projectile",
			EntityType.Builder.<PokeballOccupiedProjectileEntity>of(PokeballOccupiedProjectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<ChestEntityEntity>> CHEST_ENTITY = register("chest_entity",
			EntityType.Builder.<ChestEntityEntity>of(ChestEntityEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.ridingOffset(-0.6f).sized(1.8f, 1.8f));

	// Start of user code block custom entities
	// End of user code block custom entities
	private static <T extends Entity> DeferredHolder<EntityType<?>, EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(ResourceKey.create(Registries.ENTITY_TYPE, ResourceLocation.fromNamespaceAndPath(PixelPals01Mod.MODID, registryname))));
	}

	@SubscribeEvent
	public static void init(RegisterSpawnPlacementsEvent event) {
		PokemonEntity.init(event);
		Lvl1LandPokeGeneratorEntity.init(event);
		ChestEntityEntity.init(event);
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(POKEMON.get(), PokemonEntity.createAttributes().build());
		event.put(LVL_1_LAND_POKE_GENERATOR.get(), Lvl1LandPokeGeneratorEntity.createAttributes().build());
		event.put(CHEST_ENTITY.get(), ChestEntityEntity.createAttributes().build());
	}
}