package io.github.antthluca.deathrium_collection.items.custom;

import net.minecraft.core.Holder;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class DeathriumArmor extends ArmorItem {
    public DeathriumArmor(Holder<ArmorMaterial> material, Type type, Item.Properties prop) {
        super(material, type, prop);
    }

    @Override
    public boolean isBookEnchantable(ItemStack stack, ItemStack book) {
        return true;
    }

    @Override
    public boolean isEnchantable(ItemStack stack) {
        return true;
    }
}
