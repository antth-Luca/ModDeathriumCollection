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

    public static final DeferredHolder<Item, Item> PASSAGE_KEY = RELIC_ITEMS.register(
        "passage_key", () -> new Item(new Item.Properties()));

    public static final DeferredHolder<Item, Item> LAST_WORDS_BELL = RELIC_ITEMS.register(
        "last_words_bell", () -> new Item(new Item.Properties()));

    public static final DeferredHolder<Item, Item> REAPER_FEATHER = RELIC_ITEMS.register(
        "reaper_feather", () -> new Item(new Item.Properties()));

    public static final DeferredHolder<Item, Item> DEATH_CUP = RELIC_ITEMS.register(
        "death_cup", () -> new Item(new Item.Properties()));

    public static final DeferredHolder<Item, Item> DEATH_RING = RELIC_ITEMS.register(
        "death_ring", () -> new Item(new Item.Properties()));

    public static final DeferredHolder<Item, Item> LAMENTATION_CROWN = RELIC_ITEMS.register(
        "lamentation_crown", () -> new Item(new Item.Properties()));
}
