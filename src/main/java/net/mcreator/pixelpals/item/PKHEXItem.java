package net.mcreator.pixelpals.item;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.LivingEntity;

import net.mcreator.pixelpals.procedures.PKHEXRightclickedProcedure;

public class PKHEXItem extends Item {
	public PKHEXItem(Item.Properties properties) {
		super(properties.stacksTo(1));
	}

	@Override
	public boolean hurtEnemy(ItemStack itemstack, LivingEntity entity, LivingEntity sourceentity) {
		boolean retval = super.hurtEnemy(itemstack, entity, sourceentity);
		PKHEXRightclickedProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ(), entity, sourceentity);
		return retval;
	}
}