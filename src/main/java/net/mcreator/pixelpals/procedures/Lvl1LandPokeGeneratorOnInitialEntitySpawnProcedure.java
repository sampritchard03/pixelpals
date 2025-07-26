package net.mcreator.pixelpals.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.pixelpals.init.PixelPals01ModEntities;
import net.mcreator.pixelpals.entity.PokemonEntity;
import net.mcreator.pixelpals.PixelPals01Mod;

public class Lvl1LandPokeGeneratorOnInitialEntitySpawnProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world instanceof ServerLevel level) {
			Entity poke = PixelPals01ModEntities.POKEMON.get().spawn(level, BlockPos.containing(x, y, z), EntitySpawnReason.MOB_SUMMONED);
			if (poke instanceof PokemonEntity _datEntSetS)
				initializePokemon(_datEntSetS);
			entity.discard();
		}
	}

	public static void initializePokemon(PokemonEntity pokemon) {
		String[] allSpecies = {"bulbasaur", "ivysaur","venusaur","charmander", "charmeleon", "charizard", "blastoise", "caterpie", "metapod", "butterfree", "weedle", "kakuna", "beedrill", "pidgey", "rattata", "machamp", "krabby", "mrmime", "snorlax", "armaldo", "darkrai"};
		String species = allSpecies[(int) Math.floor(allSpecies.length * Math.random())];
		int level = (int) Math.floor(100 * Math.random()) + 1;
		pokemon.getEntityData().set(PokemonEntity.DATA_Species, species);
		pokemon.getEntityData().set(PokemonEntity.DATA_Level, level);
		//0.00012207
		if (Math.random() < 0.1) pokemon.getEntityData().set(PokemonEntity.DATA_Shiny, 1);
	}
}