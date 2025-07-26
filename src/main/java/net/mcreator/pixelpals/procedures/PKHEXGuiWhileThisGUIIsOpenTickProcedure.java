package net.mcreator.pixelpals.procedures;

import org.checkerframework.checker.units.qual.s;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.pixelpals.init.PixelPals01ModMenus;
import net.mcreator.pixelpals.entity.PokemonEntity;

import java.util.Comparator;

public class PKHEXGuiWhileThisGUIIsOpenTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		Entity pokemon = PKHEXRightclickedProcedure.pokemon;
		if (pokemon instanceof PokemonEntity _datEntSetS)
			_datEntSetS.getEntityData().set(PokemonEntity.DATA_Species, ((entity instanceof Player _entity && _entity.containerMenu instanceof PixelPals01ModMenus.MenuAccessor _menu1) ? _menu1.getMenuState(0, "Species", "") : ""));
		if (pokemon instanceof PokemonEntity _datEntSetI)
			_datEntSetI.getEntityData().set(PokemonEntity.DATA_Level, (int) new Object() {
				double convert(String s) {
					try {
						return Double.parseDouble(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert((entity instanceof Player _entity && _entity.containerMenu instanceof PixelPals01ModMenus.MenuAccessor _menu3) ? _menu3.getMenuState(0, "Level", "") : ""));
		if (pokemon instanceof PokemonEntity _datEntSetI)
			_datEntSetI.getEntityData().set(PokemonEntity.DATA_Shiny, (int) new Object() {
				double convert(String s) {
					try {
						return Double.parseDouble(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert((entity instanceof Player _entity && _entity.containerMenu instanceof PixelPals01ModMenus.MenuAccessor _menu5) ? _menu5.getMenuState(0, "Shiny", "") : ""));
		if (pokemon instanceof LivingEntity _entity)
			_entity.setHealth(pokemon instanceof LivingEntity _livEnt ? _livEnt.getMaxHealth() : -1);
		pokemon.makeStuckInBlock(Blocks.AIR.defaultBlockState(), new Vec3(0.25, 0.05, 0.25));
	}

	private static Entity findEntityInWorldRange(LevelAccessor world, Class<? extends Entity> clazz, double x, double y, double z, double range) {
		return (Entity) world.getEntitiesOfClass(clazz, AABB.ofSize(new Vec3(x, y, z), range, range, range), e -> true).stream().sorted(Comparator.comparingDouble(e -> e.distanceToSqr(x, y, z))).findFirst().orElse(null);
	}
}