package io.github.antthluca.deathrium_collection.init;

import io.github.antthluca.deathrium_collection.DeathriumCollection;
import io.github.antthluca.deathrium_collection.items.BedrockShardItem;
import io.github.antthluca.deathrium_collection.items.HeavyAgglomerate;
import io.github.antthluca.deathrium_collection.items.InsigniaOfDeath;
import io.github.antthluca.deathrium_collection.items.PinkFurnaceCore;
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

    public static final RegistryObject<Item> PINKIRON_NUGGET = ITEMS.register(
    "pinkiron_nugget", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> COATED_BONE = ITEMS.register(
        "coated_bone", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> PINK_FURNACE_CORE = ITEMS.register(
        "pink_furnace_core", () -> new PinkFurnaceCore(new Item.Properties()
            .stacksTo(1)
            .durability(100)));

    public static final RegistryObject<Item> NETHER_ALLOY = ITEMS.register(
        "nether_alloy", () -> new Item(new Item.Properties()
            .fireResistant()));

    public static final RegistryObject<Item> SOUL_GLASS = ITEMS.register(
        "soul_glass", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> BEDROCK_SHARD = ITEMS.register(
        "bedrock_shard", () -> new BedrockShardItem(new Item.Properties()
            .fireResistant()));

    public static final RegistryObject<Item> OBSIDIAN_ALLOY = ITEMS.register(
        "obsidian_alloy", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> HEAVY_AGGLOMERATE = ITEMS.register(
        "heavy_agglomerate", () -> new HeavyAgglomerate(new Item.Properties().fireResistant()));

    public static final RegistryObject<Item> INSIGNIA_OF_DEATH = ITEMS.register(
        "insignia_of_death", () -> new InsigniaOfDeath(new Item.Properties().fireResistant()));
}
