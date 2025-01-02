package io.github.antthluca.deathrium_collection.init;

import io.github.antthluca.deathrium_collection.DeathriumCollection;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class InitBlockItems {
    public static final DeferredRegister<Item> BLOCK_ITEMS = DeferredRegister.create(
        ForgeRegistries.ITEMS, DeathriumCollection.MODID
    );

    // Block Items
    public static final RegistryObject<Item> CRYST_SOUL_SAND = BLOCK_ITEMS.register(
        "crystallized_soul_sand_item", () -> new BlockItem(
            InitBlocks.CRYST_SOUL_SAND.get(),
            new Item.Properties()));
}
