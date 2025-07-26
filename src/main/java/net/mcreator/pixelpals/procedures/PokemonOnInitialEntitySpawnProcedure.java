package net.mcreator.pixelpals.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.pixelpals.entity.PokemonEntity;

public class PokemonOnInitialEntitySpawnProcedure {
	public static void spawn(Entity entity, String species, int level) {
		entity.getEntityData().set(PokemonEntity.DATA_Species, species);
		entity.getEntityData().set(PokemonEntity.DATA_Level, level);
	};

	public static void execute(Entity entity) {
		if (entity == null)
			return;
		String[] allSpecies = {"none", "venusaur", "charmeleon", "blastoise", "pidgey", "rattata", "machamp", "krabby", "mrmime", "snorlax", "armaldo", "darkrai"};
		String species = allSpecies[(int) Math.floor(allSpecies.length * Math.random())];
		int level = (int) Math.floor(100 * Math.random()) + 1;

		entity.getEntityData().set(PokemonEntity.DATA_Species, species);
		entity.getEntityData().set(PokemonEntity.DATA_Level, level);
	}
}