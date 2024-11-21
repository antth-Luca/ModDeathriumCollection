
package net.mcreator.deathriumcollection.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;

public class PinkFurnaceCoreItem extends Item {
	public PinkFurnaceCoreItem() {
		super(new Item.Properties().tab(CreativeModeTab.TAB_MISC).stacksTo(1).fireResistant().rarity(Rarity.UNCOMMON));
	}
}
