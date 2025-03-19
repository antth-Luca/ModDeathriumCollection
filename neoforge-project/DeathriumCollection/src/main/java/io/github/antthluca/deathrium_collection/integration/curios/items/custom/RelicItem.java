package io.github.antthluca.deathrium_collection.integration.curios.items.custom;

import net.minecraft.world.item.Item;
import top.theillusivec4.curios.api.type.capability.ICurioItem;

public class RelicItem extends Item implements ICurioItem {
    public RelicItem(Properties prop) {
        super(prop.stacksTo(1).fireResistant());
    }
}
