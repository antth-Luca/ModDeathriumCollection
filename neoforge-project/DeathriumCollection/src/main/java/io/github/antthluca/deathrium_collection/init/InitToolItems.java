package io.github.antthluca.deathrium_collection.init;

import io.github.antthluca.deathrium_collection.DeathriumCollection;
import io.github.antthluca.deathrium_collection.items.tool.ShreddingStaff;
import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class InitToolItems {
    public static final DeferredRegister.Items TOOL_ITEMS = DeferredRegister.createItems(DeathriumCollection.MODID);

    // Tools
    public static final DeferredHolder<Item, Item> SHREDDING_STAFF = TOOL_ITEMS.register(
        "shredding_staff", () -> new ShreddingStaff(new Item.Properties()
            .stacksTo(1)
            .durability(250)));
}
