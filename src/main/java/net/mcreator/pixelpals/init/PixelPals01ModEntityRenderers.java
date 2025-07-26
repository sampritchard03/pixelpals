/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.pixelpals.init;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.client.renderer.entity.ThrownItemRenderer;

import net.mcreator.pixelpals.client.renderer.PokemonRenderer;
import net.mcreator.pixelpals.client.renderer.Lvl1LandPokeGeneratorRenderer;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class PixelPals01ModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(PixelPals01ModEntities.POKEMON.get(), PokemonRenderer::new);
		event.registerEntityRenderer(PixelPals01ModEntities.POKEBALL_PROJECTILE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(PixelPals01ModEntities.LVL_1_LAND_POKE_GENERATOR.get(), Lvl1LandPokeGeneratorRenderer::new);
		event.registerEntityRenderer(PixelPals01ModEntities.POKEBALL_OCCUPIED_PROJECTILE.get(), ThrownItemRenderer::new);
	}
}