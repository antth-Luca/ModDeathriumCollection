package io.github.antthluca.deathrium_collection.init;

import io.github.antthluca.deathrium_collection.DeathriumCollection;
import io.github.antthluca.deathrium_collection.items.BedrockShardItem;
import io.github.antthluca.deathrium_collection.items.DeathriumIngot;
import io.github.antthluca.deathrium_collection.items.HeavyAgglomerate;
import io.github.antthluca.deathrium_collection.items.InsigniaOfDeath;
import io.github.antthluca.deathrium_collection.items.PinkFurnaceCore;
import io.github.antthluca.deathrium_collection.items.SignatureOfDeath;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class InitItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(DeathriumCollection.MODID);

    // Items
    public static final DeferredHolder<Item, Item> OXIDIZED_ALLOY = ITEMS.register(
        "oxidized_alloy", () -> new Item(new Item.Properties()));

    public static final DeferredHolder<Item, Item> PINKIRON_INGOT = ITEMS.register(
        "pinkiron_ingot", () -> new Item(new Item.Properties()));

    public static final DeferredHolder<Item, Item> PINKIRON_NUGGET = ITEMS.register(
        "pinkiron_nugget", () -> new Item(new Item.Properties()));

    public static final DeferredHolder<Item, Item> COATED_BONE = ITEMS.register(
        "coated_bone", () -> new Item(new Item.Properties()));

    public static final DeferredHolder<Item, Item> PINK_FURNACE_CORE = ITEMS.register(
        "pink_furnace_core", () -> new PinkFurnaceCore(new Item.Properties()
            .stacksTo(1)
            .durability(100)));

    public static final DeferredHolder<Item, Item> NETHER_ALLOY = ITEMS.register(
        "nether_alloy", () -> new Item(new Item.Properties()
            .fireResistant()));

    public static final DeferredHolder<Item, Item> SOUL_GLASS = ITEMS.register(
        "soul_glass", () -> new Item(new Item.Properties()));

    public static final DeferredHolder<Item, Item> BEDROCK_SHARD = ITEMS.register(
        "bedrock_shard", () -> new BedrockShardItem(new Item.Properties()
            .rarity(Rarity.UNCOMMON)
            .fireResistant()));

    public static final DeferredHolder<Item, Item> OBSIDIAN_ALLOY = ITEMS.register(
        "obsidian_alloy", () -> new Item(new Item.Properties()));

    public static final DeferredHolder<Item, Item> HEAVY_AGGLOMERATE = ITEMS.register(
        "heavy_agglomerate", () -> new HeavyAgglomerate(new Item.Properties()
            .rarity(Rarity.UNCOMMON)
            .fireResistant()));

    public static final DeferredHolder<Item, Item> INSIGNIA_OF_DEATH = ITEMS.register(
        "insignia_of_death", () -> new InsigniaOfDeath(new Item.Properties()
            .rarity(Rarity.RARE)
            .fireResistant()
            .stacksTo(1)));

    public static final DeferredHolder<Item, Item> SIGNATURE_OF_DEATH = ITEMS.register(
        "signature_of_death", () -> new SignatureOfDeath(new Item.Properties()
            .rarity(Rarity.RARE)
            .fireResistant()
            .stacksTo(1)));

    public static final DeferredHolder<Item, Item> DEATHRIUM_INGOT = ITEMS.register(
        "deathrium_ingot", () -> new DeathriumIngot(new Item.Properties()
            .rarity(Rarity.EPIC)
            .fireResistant()));
}
