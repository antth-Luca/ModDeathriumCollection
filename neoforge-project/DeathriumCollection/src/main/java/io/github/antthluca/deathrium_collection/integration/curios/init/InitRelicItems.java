package io.github.antthluca.deathrium_collection.integration.curios.init;

import io.github.antthluca.deathrium_collection.DeathriumCollection;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class InitRelicItems {
    public static final DeferredRegister.Items RELIC_ITEMS = DeferredRegister.createItems(DeathriumCollection.MODID);

    // Relic Items
    public static final DeferredHolder<Item, Item> BLACK_HEART = RELIC_ITEMS.register(
        "black_heart", () -> new Item(new Item.Properties()));

    public static final DeferredHolder<Item, Item> LAMENTATION_CROWN = RELIC_ITEMS.register(
        "lamentation_crown", () -> new Item(new Item.Properties()));
}
