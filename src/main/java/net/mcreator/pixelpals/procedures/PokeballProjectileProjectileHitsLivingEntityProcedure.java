package net.mcreator.pixelpals.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.component.DataComponents;

import net.mcreator.pixelpals.init.PixelPals01ModItems;
import net.mcreator.pixelpals.entity.PokemonEntity;

public class PokeballProjectileProjectileHitsLivingEntityProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		ItemStack itemStack = ItemStack.EMPTY;
		Entity pokemon = null;
		itemStack = new ItemStack(PixelPals01ModItems.POKEBALL_OCCUPIED.get()).copy();
		{
			final String _tagName = "Species";
			final String _tagValue = (entity instanceof PokemonEntity _datEntS ? _datEntS.getEntityData().get(PokemonEntity.DATA_Species) : "");
			CustomData.update(DataComponents.CUSTOM_DATA, itemStack, tag -> tag.putString(_tagName, _tagValue));
		}
		{
			final String _tagName = "Level";
			final double _tagValue = (entity instanceof PokemonEntity _datEntI ? _datEntI.getEntityData().get(PokemonEntity.DATA_Level) : 0);
			CustomData.update(DataComponents.CUSTOM_DATA, itemStack, tag -> tag.putDouble(_tagName, _tagValue));
		}
		{
			final String _tagName = "Shiny";
			final double _tagValue = (entity instanceof PokemonEntity _datEntI ? _datEntI.getEntityData().get(PokemonEntity.DATA_Shiny) : 0);
			CustomData.update(DataComponents.CUSTOM_DATA, itemStack, tag -> tag.putDouble(_tagName, _tagValue));
		}
		{
			final String _tagName = "ID";
			final double _tagValue = (entity instanceof PokemonEntity _datEntI ? _datEntI.getEntityData().get(PokemonEntity.DATA_ID) : 0);
			CustomData.update(DataComponents.CUSTOM_DATA, itemStack, tag -> tag.putDouble(_tagName, _tagValue));
		}
		if (world instanceof ServerLevel _level) {
			ItemEntity entityToSpawn = new ItemEntity(_level, x, y, z, itemStack);
			entityToSpawn.setPickUpDelay(10);
			entityToSpawn.setUnlimitedLifetime();
			_level.addFreshEntity(entityToSpawn);
		}
		if (!entity.level().isClientSide())
			entity.discard();
	}
}