package net.mcreator.deathriumcollection.procedures;

import net.minecraftforge.items.ItemHandlerHelper;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.deathriumcollection.init.DeathriumCollectionModItems;

public class InsigniaOfDeathKillIncrementProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (entity instanceof Player _playerHasItem ? _playerHasItem.getInventory().contains(new ItemStack(DeathriumCollectionModItems.INSIGNIA_OF_DEATH.get())) : false) {
			itemstack.getOrCreateTag().putDouble("kills", (itemstack.getOrCreateTag().getDouble("kills") + 1));
			if (itemstack.getOrCreateTag().getDouble("kills") >= 1) {
				if (entity instanceof Player _player) {
					ItemStack _stktoremove = new ItemStack(DeathriumCollectionModItems.INSIGNIA_OF_DEATH.get());
					_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
				}
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(DeathriumCollectionModItems.SIGNATURE_OF_DEATH.get());
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
			}
		}
	}
}
