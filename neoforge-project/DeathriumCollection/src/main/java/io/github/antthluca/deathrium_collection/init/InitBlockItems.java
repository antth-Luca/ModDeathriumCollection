package io.github.antthluca.deathrium_collection.init;

import io.github.antthluca.deathrium_collection.DeathriumCollection;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class InitBlockItems {
    public static final DeferredRegister.Items BLOCK_ITEMS = DeferredRegister.createItems(DeathriumCollection.MODID);

    // Block Items
    public static final DeferredHolder<Item, Item> CRYSTAL_SOUL_SAND = BLOCK_ITEMS.register(
        "crystallized_soul_sand", () -> new BlockItem(
            InitBlocks.CRYSTAL_SOUL_SAND.get(),
            new Item.Properties()));
}
