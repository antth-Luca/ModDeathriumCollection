package io.github.antthluca.deathrium_collection.items.armor;

import io.github.antthluca.deathrium_collection.items.custom.DeathriumArmor;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class DeathriumHelmet extends DeathriumArmor {
    public DeathriumHelmet(Holder<ArmorMaterial> material, Type type, Item.Properties prop) {
        super(material, type, prop);
    }

    @Override
    public boolean isEnderMask(ItemStack stack, Player player, EnderMan endermanEntity) {
        return true;
    }
}
