package net.mcreator.pixelpals.procedures;

import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.component.DataComponents;

import net.mcreator.pixelpals.network.PixelPals01ModVariables;
import net.mcreator.pixelpals.entity.PokemonEntity;

public class UpdateSlotProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof PokemonEntity _datEntI ? _datEntI.getEntityData().get(PokemonEntity.DATA_Slot) : 0) != 0) {
			if ((entity instanceof PokemonEntity _datEntI ? _datEntI.getEntityData().get(PokemonEntity.DATA_Slot) : 0) == 1) {
				if ((entity instanceof PokemonEntity _datEntI
						? _datEntI.getEntityData().get(PokemonEntity.DATA_ID)
						: 0) != (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getData(PixelPals01ModVariables.PLAYER_VARIABLES).p1.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag()
								.getDouble("ID")) {
					if (!entity.level().isClientSide())
						entity.discard();
				} else {
					{
						final String _tagName = "Species";
						final String _tagValue = (entity instanceof PokemonEntity _datEntS ? _datEntS.getEntityData().get(PokemonEntity.DATA_Species) : "");
						CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getData(PixelPals01ModVariables.PLAYER_VARIABLES).p1, tag -> tag.putString(_tagName, _tagValue));
					}
					{
						final String _tagName = "Level";
						final double _tagValue = (entity instanceof PokemonEntity _datEntI ? _datEntI.getEntityData().get(PokemonEntity.DATA_Level) : 0);
						CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getData(PixelPals01ModVariables.PLAYER_VARIABLES).p1, tag -> tag.putDouble(_tagName, _tagValue));
					}
					{
						final String _tagName = "Shiny";
						final double _tagValue = (entity instanceof PokemonEntity _datEntI ? _datEntI.getEntityData().get(PokemonEntity.DATA_Shiny) : 0);
						CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getData(PixelPals01ModVariables.PLAYER_VARIABLES).p1, tag -> tag.putDouble(_tagName, _tagValue));
					}
				}
			} else if ((entity instanceof PokemonEntity _datEntI ? _datEntI.getEntityData().get(PokemonEntity.DATA_Slot) : 0) == 2) {
				if ((entity instanceof PokemonEntity _datEntI
						? _datEntI.getEntityData().get(PokemonEntity.DATA_ID)
						: 0) != (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getData(PixelPals01ModVariables.PLAYER_VARIABLES).p2.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag()
								.getDouble("ID")) {
					if (!entity.level().isClientSide())
						entity.discard();
				} else {
					{
						final String _tagName = "Species";
						final String _tagValue = (entity instanceof PokemonEntity _datEntS ? _datEntS.getEntityData().get(PokemonEntity.DATA_Species) : "");
						CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getData(PixelPals01ModVariables.PLAYER_VARIABLES).p2, tag -> tag.putString(_tagName, _tagValue));
					}
					{
						final String _tagName = "Level";
						final double _tagValue = (entity instanceof PokemonEntity _datEntI ? _datEntI.getEntityData().get(PokemonEntity.DATA_Level) : 0);
						CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getData(PixelPals01ModVariables.PLAYER_VARIABLES).p2, tag -> tag.putDouble(_tagName, _tagValue));
					}
					{
						final String _tagName = "Shiny";
						final double _tagValue = (entity instanceof PokemonEntity _datEntI ? _datEntI.getEntityData().get(PokemonEntity.DATA_Shiny) : 0);
						CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getData(PixelPals01ModVariables.PLAYER_VARIABLES).p2, tag -> tag.putDouble(_tagName, _tagValue));
					}
				}
			} else if ((entity instanceof PokemonEntity _datEntI ? _datEntI.getEntityData().get(PokemonEntity.DATA_Slot) : 0) == 3) {
				if ((entity instanceof PokemonEntity _datEntI
						? _datEntI.getEntityData().get(PokemonEntity.DATA_ID)
						: 0) != (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getData(PixelPals01ModVariables.PLAYER_VARIABLES).p3.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag()
								.getDouble("ID")) {
					if (!entity.level().isClientSide())
						entity.discard();
				} else {
					{
						final String _tagName = "Species";
						final String _tagValue = (entity instanceof PokemonEntity _datEntS ? _datEntS.getEntityData().get(PokemonEntity.DATA_Species) : "");
						CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getData(PixelPals01ModVariables.PLAYER_VARIABLES).p3, tag -> tag.putString(_tagName, _tagValue));
					}
					{
						final String _tagName = "Level";
						final double _tagValue = (entity instanceof PokemonEntity _datEntI ? _datEntI.getEntityData().get(PokemonEntity.DATA_Level) : 0);
						CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getData(PixelPals01ModVariables.PLAYER_VARIABLES).p3, tag -> tag.putDouble(_tagName, _tagValue));
					}
					{
						final String _tagName = "Shiny";
						final double _tagValue = (entity instanceof PokemonEntity _datEntI ? _datEntI.getEntityData().get(PokemonEntity.DATA_Shiny) : 0);
						CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getData(PixelPals01ModVariables.PLAYER_VARIABLES).p3, tag -> tag.putDouble(_tagName, _tagValue));
					}
				}
			} else if ((entity instanceof PokemonEntity _datEntI ? _datEntI.getEntityData().get(PokemonEntity.DATA_Slot) : 0) == 4) {
				if ((entity instanceof PokemonEntity _datEntI
						? _datEntI.getEntityData().get(PokemonEntity.DATA_ID)
						: 0) != (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getData(PixelPals01ModVariables.PLAYER_VARIABLES).p4.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag()
								.getDouble("ID")) {
					if (!entity.level().isClientSide())
						entity.discard();
				} else {
					{
						final String _tagName = "Species";
						final String _tagValue = (entity instanceof PokemonEntity _datEntS ? _datEntS.getEntityData().get(PokemonEntity.DATA_Species) : "");
						CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getData(PixelPals01ModVariables.PLAYER_VARIABLES).p4, tag -> tag.putString(_tagName, _tagValue));
					}
					{
						final String _tagName = "Level";
						final double _tagValue = (entity instanceof PokemonEntity _datEntI ? _datEntI.getEntityData().get(PokemonEntity.DATA_Level) : 0);
						CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getData(PixelPals01ModVariables.PLAYER_VARIABLES).p4, tag -> tag.putDouble(_tagName, _tagValue));
					}
					{
						final String _tagName = "Shiny";
						final double _tagValue = (entity instanceof PokemonEntity _datEntI ? _datEntI.getEntityData().get(PokemonEntity.DATA_Shiny) : 0);
						CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getData(PixelPals01ModVariables.PLAYER_VARIABLES).p4, tag -> tag.putDouble(_tagName, _tagValue));
					}
				}
			} else if ((entity instanceof PokemonEntity _datEntI ? _datEntI.getEntityData().get(PokemonEntity.DATA_Slot) : 0) == 5) {
				if ((entity instanceof PokemonEntity _datEntI
						? _datEntI.getEntityData().get(PokemonEntity.DATA_ID)
						: 0) != (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getData(PixelPals01ModVariables.PLAYER_VARIABLES).p5.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag()
								.getDouble("ID")) {
					if (!entity.level().isClientSide())
						entity.discard();
				} else {
					{
						final String _tagName = "Species";
						final String _tagValue = (entity instanceof PokemonEntity _datEntS ? _datEntS.getEntityData().get(PokemonEntity.DATA_Species) : "");
						CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getData(PixelPals01ModVariables.PLAYER_VARIABLES).p5, tag -> tag.putString(_tagName, _tagValue));
					}
					{
						final String _tagName = "Level";
						final double _tagValue = (entity instanceof PokemonEntity _datEntI ? _datEntI.getEntityData().get(PokemonEntity.DATA_Level) : 0);
						CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getData(PixelPals01ModVariables.PLAYER_VARIABLES).p5, tag -> tag.putDouble(_tagName, _tagValue));
					}
					{
						final String _tagName = "Shiny";
						final double _tagValue = (entity instanceof PokemonEntity _datEntI ? _datEntI.getEntityData().get(PokemonEntity.DATA_Shiny) : 0);
						CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getData(PixelPals01ModVariables.PLAYER_VARIABLES).p5, tag -> tag.putDouble(_tagName, _tagValue));
					}
				}
			} else if ((entity instanceof PokemonEntity _datEntI ? _datEntI.getEntityData().get(PokemonEntity.DATA_Slot) : 0) == 6) {
				if ((entity instanceof PokemonEntity _datEntI
						? _datEntI.getEntityData().get(PokemonEntity.DATA_ID)
						: 0) != (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getData(PixelPals01ModVariables.PLAYER_VARIABLES).p6.getOrDefault(DataComponents.CUSTOM_DATA, CustomData.EMPTY).copyTag()
								.getDouble("ID")) {
					if (!entity.level().isClientSide())
						entity.discard();
				} else {
					{
						final String _tagName = "Species";
						final String _tagValue = (entity instanceof PokemonEntity _datEntS ? _datEntS.getEntityData().get(PokemonEntity.DATA_Species) : "");
						CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getData(PixelPals01ModVariables.PLAYER_VARIABLES).p6, tag -> tag.putString(_tagName, _tagValue));
					}
					{
						final String _tagName = "Level";
						final double _tagValue = (entity instanceof PokemonEntity _datEntI ? _datEntI.getEntityData().get(PokemonEntity.DATA_Level) : 0);
						CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getData(PixelPals01ModVariables.PLAYER_VARIABLES).p6, tag -> tag.putDouble(_tagName, _tagValue));
					}
					{
						final String _tagName = "Shiny";
						final double _tagValue = (entity instanceof PokemonEntity _datEntI ? _datEntI.getEntityData().get(PokemonEntity.DATA_Shiny) : 0);
						CustomData.update(DataComponents.CUSTOM_DATA, (entity instanceof TamableAnimal _tamEnt ? (Entity) _tamEnt.getOwner() : null).getData(PixelPals01ModVariables.PLAYER_VARIABLES).p6, tag -> tag.putDouble(_tagName, _tagValue));
					}
				}
			}
		}
	}
}