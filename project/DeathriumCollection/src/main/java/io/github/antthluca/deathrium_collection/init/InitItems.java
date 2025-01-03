package io.github.antthluca.deathrium_collection.init;

import io.github.antthluca.deathrium_collection.DeathriumCollection;
import io.github.antthluca.deathrium_collection.items.custom.ShreddingStaff;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class InitItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(
        ForgeRegistries.ITEMS, DeathriumCollection.MODID
    );

    // Items
    public static final RegistryObject<Item> OXIDIZED_ALLOY = ITEMS.register(
        "oxidized_alloy", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> PINKIRON_INGOT = ITEMS.register(
        "pinkiron_ingot", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> COATED_BONE = ITEMS.register(
        "coated_bone", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> SOUL_GLASS = ITEMS.register(
        "soul_glass", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> BEDROCK_SHARD = ITEMS.register(
        "bedrock_shard", () -> new Item(new Item.Properties()));

    // Tools
    public static final RegistryObject<Item> SHREDDING_STAFF = ITEMS.register(
        "shredding_staff", () -> new ShreddingStaff(new Item.Properties()
            .stacksTo(1)
            .durability(250)));
}
