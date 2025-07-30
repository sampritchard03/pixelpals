/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.pixelpals.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BlockItem;

import net.mcreator.pixelpals.item.WeedleSMaskItem;
import net.mcreator.pixelpals.item.WeedleMaskItem;
import net.mcreator.pixelpals.item.WartortleSMaskItem;
import net.mcreator.pixelpals.item.WartortleMaskItem;
import net.mcreator.pixelpals.item.VenusaurSMaskItem;
import net.mcreator.pixelpals.item.VenusaurMaskItem;
import net.mcreator.pixelpals.item.SquirtleSMaskItem;
import net.mcreator.pixelpals.item.SquirtleMaskItem;
import net.mcreator.pixelpals.item.SnorlaxSMaskItem;
import net.mcreator.pixelpals.item.SnorlaxMaskItem;
import net.mcreator.pixelpals.item.RedChestMaskItem;
import net.mcreator.pixelpals.item.RattataSMaskItem;
import net.mcreator.pixelpals.item.RattataMaskItem;
import net.mcreator.pixelpals.item.PokeballOccupiedItem;
import net.mcreator.pixelpals.item.PokeballItem;
import net.mcreator.pixelpals.item.PidgeySMaskItem;
import net.mcreator.pixelpals.item.PidgeyMaskItem;
import net.mcreator.pixelpals.item.PKHEXItem;
import net.mcreator.pixelpals.item.MrMimeSMaskItem;
import net.mcreator.pixelpals.item.MrMimeMaskItem;
import net.mcreator.pixelpals.item.MetapodSMaskItem;
import net.mcreator.pixelpals.item.MetapodMaskItem;
import net.mcreator.pixelpals.item.MachampSMaskItem;
import net.mcreator.pixelpals.item.MachampMaskItem;
import net.mcreator.pixelpals.item.KrabbySMaskItem;
import net.mcreator.pixelpals.item.KrabbyMaskItem;
import net.mcreator.pixelpals.item.KakunaSMaskItem;
import net.mcreator.pixelpals.item.KakunaMaskItem;
import net.mcreator.pixelpals.item.IvysaurSMaskItem;
import net.mcreator.pixelpals.item.IvysaurMaskItem;
import net.mcreator.pixelpals.item.HazyHollowsItem;
import net.mcreator.pixelpals.item.DarkraiSMaskItem;
import net.mcreator.pixelpals.item.DarkraiMaskItem;
import net.mcreator.pixelpals.item.CharmeleonSMaskItem;
import net.mcreator.pixelpals.item.CharmeleonMaskItem;
import net.mcreator.pixelpals.item.CharmanderSMaskItem;
import net.mcreator.pixelpals.item.CharmanderMaskItem;
import net.mcreator.pixelpals.item.CharizardSMaskItem;
import net.mcreator.pixelpals.item.CharizardMaskItem;
import net.mcreator.pixelpals.item.CaterpieSMaskItem;
import net.mcreator.pixelpals.item.CaterpieMaskItem;
import net.mcreator.pixelpals.item.ButterfreeSMaskItem;
import net.mcreator.pixelpals.item.ButterfreeMaskItem;
import net.mcreator.pixelpals.item.BulbasaurSMaskItem;
import net.mcreator.pixelpals.item.BulbasaurMaskItem;
import net.mcreator.pixelpals.item.BrownChestMaskItem;
import net.mcreator.pixelpals.item.BlastoiseSMaskItem;
import net.mcreator.pixelpals.item.BlastoiseMaskItem;
import net.mcreator.pixelpals.item.BeedrillSMaskItem;
import net.mcreator.pixelpals.item.BeedrillMaskItem;
import net.mcreator.pixelpals.item.ArmaldoSMaskItem;
import net.mcreator.pixelpals.item.ArmaldoMaskItem;
import net.mcreator.pixelpals.PixelPals01Mod;

import java.util.function.Function;

public class PixelPals01ModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(PixelPals01Mod.MODID);
	public static final DeferredItem<Item> PIDGEY_MASK = register("pidgey_mask", PidgeyMaskItem::new);
	public static final DeferredItem<Item> POKEMON_SPAWN_EGG = register("pokemon_spawn_egg", properties -> new SpawnEggItem(PixelPals01ModEntities.POKEMON.get(), properties));
	public static final DeferredItem<Item> ARMALDO_MASK = register("armaldo_mask", ArmaldoMaskItem::new);
	public static final DeferredItem<Item> CHARMELEON_MASK = register("charmeleon_mask", CharmeleonMaskItem::new);
	public static final DeferredItem<Item> MACHAMP_MASK = register("machamp_mask", MachampMaskItem::new);
	public static final DeferredItem<Item> VENUSAUR_MASK = register("venusaur_mask", VenusaurMaskItem::new);
	public static final DeferredItem<Item> MR_MIME_MASK = register("mr_mime_mask", MrMimeMaskItem::new);
	public static final DeferredItem<Item> DARKRAI_MASK = register("darkrai_mask", DarkraiMaskItem::new);
	public static final DeferredItem<Item> SNORLAX_MASK = register("snorlax_mask", SnorlaxMaskItem::new);
	public static final DeferredItem<Item> KRABBY_MASK = register("krabby_mask", KrabbyMaskItem::new);
	public static final DeferredItem<Item> BLASTOISE_MASK = register("blastoise_mask", BlastoiseMaskItem::new);
	public static final DeferredItem<Item> RATTATA_MASK = register("rattata_mask", RattataMaskItem::new);
	public static final DeferredItem<Item> POKEBALL = register("pokeball", PokeballItem::new);
	public static final DeferredItem<Item> PKHEX = register("pkhex", PKHEXItem::new);
	public static final DeferredItem<Item> LVL_1_LAND_POKE_GENERATOR_SPAWN_EGG = register("lvl_1_land_poke_generator_spawn_egg", properties -> new SpawnEggItem(PixelPals01ModEntities.LVL_1_LAND_POKE_GENERATOR.get(), properties));
	public static final DeferredItem<Item> ARMALDO_S_MASK = register("armaldo_s_mask", ArmaldoSMaskItem::new);
	public static final DeferredItem<Item> BLASTOISE_S_MASK = register("blastoise_s_mask", BlastoiseSMaskItem::new);
	public static final DeferredItem<Item> CHARMELEON_S_MASK = register("charmeleon_s_mask", CharmeleonSMaskItem::new);
	public static final DeferredItem<Item> DARKRAI_S_MASK = register("darkrai_s_mask", DarkraiSMaskItem::new);
	public static final DeferredItem<Item> PIDGEY_S_MASK = register("pidgey_s_mask", PidgeySMaskItem::new);
	public static final DeferredItem<Item> KRABBY_S_MASK = register("krabby_s_mask", KrabbySMaskItem::new);
	public static final DeferredItem<Item> MACHAMP_S_MASK = register("machamp_s_mask", MachampSMaskItem::new);
	public static final DeferredItem<Item> MR_MIME_S_MASK = register("mr_mime_s_mask", MrMimeSMaskItem::new);
	public static final DeferredItem<Item> RATTATA_S_MASK = register("rattata_s_mask", RattataSMaskItem::new);
	public static final DeferredItem<Item> SNORLAX_S_MASK = register("snorlax_s_mask", SnorlaxSMaskItem::new);
	public static final DeferredItem<Item> VENUSAUR_S_MASK = register("venusaur_s_mask", VenusaurSMaskItem::new);
	public static final DeferredItem<Item> POKEBALL_OCCUPIED = register("pokeball_occupied", PokeballOccupiedItem::new);
	public static final DeferredItem<Item> BULBASAUR_MASK = register("bulbasaur_mask", BulbasaurMaskItem::new);
	public static final DeferredItem<Item> BULBASAUR_S_MASK = register("bulbasaur_s_mask", BulbasaurSMaskItem::new);
	public static final DeferredItem<Item> IVYSAUR_MASK = register("ivysaur_mask", IvysaurMaskItem::new);
	public static final DeferredItem<Item> IVYSAUR_S_MASK = register("ivysaur_s_mask", IvysaurSMaskItem::new);
	public static final DeferredItem<Item> BEEDRILL_MASK = register("beedrill_mask", BeedrillMaskItem::new);
	public static final DeferredItem<Item> BEEDRILL_S_MASK = register("beedrill_s_mask", BeedrillSMaskItem::new);
	public static final DeferredItem<Item> BUTTERFREE_MASK = register("butterfree_mask", ButterfreeMaskItem::new);
	public static final DeferredItem<Item> BUTTERFREE_S_MASK = register("butterfree_s_mask", ButterfreeSMaskItem::new);
	public static final DeferredItem<Item> WEEDLE_MASK = register("weedle_mask", WeedleMaskItem::new);
	public static final DeferredItem<Item> WEEDLE_S_MASK = register("weedle_s_mask", WeedleSMaskItem::new);
	public static final DeferredItem<Item> CHARMANDER_MASK = register("charmander_mask", CharmanderMaskItem::new);
	public static final DeferredItem<Item> CHARMANDER_S_MASK = register("charmander_s_mask", CharmanderSMaskItem::new);
	public static final DeferredItem<Item> CHARIZARD_MASK = register("charizard_mask", CharizardMaskItem::new);
	public static final DeferredItem<Item> CHARIZARD_S_MASK = register("charizard_s_mask", CharizardSMaskItem::new);
	public static final DeferredItem<Item> CATERPIE_MASK = register("caterpie_mask", CaterpieMaskItem::new);
	public static final DeferredItem<Item> CATERPIE_S_MASK = register("caterpie_s_mask", CaterpieSMaskItem::new);
	public static final DeferredItem<Item> METAPOD_MASK = register("metapod_mask", MetapodMaskItem::new);
	public static final DeferredItem<Item> METAPOD_S_MASK = register("metapod_s_mask", MetapodSMaskItem::new);
	public static final DeferredItem<Item> KAKUNA_MASK = register("kakuna_mask", KakunaMaskItem::new);
	public static final DeferredItem<Item> KAKUNA_S_MASK = register("kakuna_s_mask", KakunaSMaskItem::new);
	public static final DeferredItem<Item> PINE_TREE = block(PixelPals01ModBlocks.PINE_TREE);
	public static final DeferredItem<Item> SLATE = block(PixelPals01ModBlocks.SLATE);
	public static final DeferredItem<Item> SOIL = block(PixelPals01ModBlocks.SOIL, new Item.Properties().stacksTo(99));
	public static final DeferredItem<Item> FOREST_FLOOR = block(PixelPals01ModBlocks.FOREST_FLOOR, new Item.Properties().stacksTo(99));
	public static final DeferredItem<Item> WARTORTLE_MASK = register("wartortle_mask", WartortleMaskItem::new);
	public static final DeferredItem<Item> WARTORTLE_S_MASK = register("wartortle_s_mask", WartortleSMaskItem::new);
	public static final DeferredItem<Item> SQUIRTLE_MASK = register("squirtle_mask", SquirtleMaskItem::new);
	public static final DeferredItem<Item> SQUIRTLE_S_MASK = register("squirtle_s_mask", SquirtleSMaskItem::new);
	public static final DeferredItem<Item> BEACH_PEBBLES = block(PixelPals01ModBlocks.BEACH_PEBBLES, new Item.Properties().stacksTo(99));
	public static final DeferredItem<Item> HAZY_HOLLOWS = register("hazy_hollows", HazyHollowsItem::new);
	public static final DeferredItem<Item> TOAD_HOUSE_MODEL = block(PixelPals01ModBlocks.TOAD_HOUSE_MODEL);
	public static final DeferredItem<Item> RED_CHEST_MASK = register("red_chest_mask", RedChestMaskItem::new);
	public static final DeferredItem<Item> CHEST_ENTITY_SPAWN_EGG = register("chest_entity_spawn_egg", properties -> new SpawnEggItem(PixelPals01ModEntities.CHEST_ENTITY.get(), properties));
	public static final DeferredItem<Item> BROWN_CHEST_MASK = register("brown_chest_mask", BrownChestMaskItem::new);
	public static final DeferredItem<Item> DRY_SOIL = block(PixelPals01ModBlocks.DRY_SOIL, new Item.Properties().stacksTo(99));
	public static final DeferredItem<Item> BURNT_LAWN_GENERATOR = block(PixelPals01ModBlocks.BURNT_LAWN_GENERATOR);
	public static final DeferredItem<Item> DARK_BROWN_STRIPE = block(PixelPals01ModBlocks.DARK_BROWN_STRIPE, new Item.Properties().stacksTo(99));
	public static final DeferredItem<Item> LIGHT_BROWN_STRIPE = block(PixelPals01ModBlocks.LIGHT_BROWN_STRIPE, new Item.Properties().stacksTo(99));

	// Start of user code block custom items
	// End of user code block custom items
	private static <I extends Item> DeferredItem<I> register(String name, Function<Item.Properties, ? extends I> supplier) {
		return REGISTRY.registerItem(name, supplier, new Item.Properties());
	}

	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block) {
		return block(block, new Item.Properties());
	}

	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block, Item.Properties properties) {
		return REGISTRY.registerItem(block.getId().getPath(), prop -> new BlockItem(block.get(), prop), properties);
	}
}