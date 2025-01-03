package io.github.antthluca.deathrium_collection.init;

import io.github.antthluca.deathrium_collection.DeathriumCollection;
import io.github.antthluca.deathrium_collection.items.ShreddingStaff;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class InitToolItems {
    public static final DeferredRegister<Item> TOOL_ITEMS = DeferredRegister.create(
        ForgeRegistries.ITEMS, DeathriumCollection.MODID
    );

    // Tools
    public static final RegistryObject<Item> SHREDDING_STAFF = TOOL_ITEMS.register(
        "shredding_staff", () -> new ShreddingStaff(new Item.Properties()
            .stacksTo(1)
            .durability(250)));
}
