package io.github.antthluca.deathrium_collection.integration.curios.items.custom;

import io.github.antthluca.deathrium_collection.integration.curios.rarities.DCRarities;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

public class RelicItem extends Item implements ICurioItem {
    private final DCRarities dcRarity;

    public RelicItem(Properties prop, DCRarities dcRarity) {
        super(prop.stacksTo(1).fireResistant());
        this.dcRarity = dcRarity;
    }

    @Override
    public Component getName(ItemStack stack) {
        return super.getName(stack).copy().withStyle(dcRarity.getStyleModifier());
    }
}
