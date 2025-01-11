package io.github.antthluca.deathrium_collection.init;

import io.github.antthluca.deathrium_collection.DeathriumCollection;
import io.github.antthluca.deathrium_collection.items.armor.DeathriumBoots;
import io.github.antthluca.deathrium_collection.items.armor.DeathriumChestplate;
import io.github.antthluca.deathrium_collection.items.armor.DeathriumHelmet;
import io.github.antthluca.deathrium_collection.items.armor.DeathriumLeggings;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class InitArmorItems {
    public static final DeferredRegister.Items ARMOR_ITEMS = DeferredRegister.createItems(DeathriumCollection.MODID);

    // Armor items
    public static final DeferredHolder<Item, Item> DEATHRIUM_HELMET = ARMOR_ITEMS.register(
        "deathrium_helmet", () -> new DeathriumHelmet(
            InitArmorMaterials.DEATHRIUM,
            ArmorItem.Type.HELMET,
            new Item.Properties()
                .stacksTo(1)
                .rarity(Rarity.EPIC)
                .fireResistant()));

    public static final DeferredHolder<Item, Item> DEATHRIUM_CHESTPLATE = ARMOR_ITEMS.register(
        "deathrium_chestplate", () -> new DeathriumChestplate(
            InitArmorMaterials.DEATHRIUM,
            ArmorItem.Type.CHESTPLATE,
            new Item.Properties()
                .stacksTo(1)
                .rarity(Rarity.EPIC)
                .fireResistant()));

    public static final DeferredHolder<Item, Item> DEATHRIUM_LEGGINGS = ARMOR_ITEMS.register(
        "deathrium_leggings", () -> new DeathriumLeggings(
            InitArmorMaterials.DEATHRIUM,
            ArmorItem.Type.LEGGINGS,
            new Item.Properties()
                .stacksTo(1)
                .rarity(Rarity.EPIC)
                .fireResistant()));

    public static final DeferredHolder<Item, Item> DEATHRIUM_BOOTS = ARMOR_ITEMS.register(
        "deathrium_boots", () -> new DeathriumBoots(
            InitArmorMaterials.DEATHRIUM,
            ArmorItem.Type.BOOTS,
            new Item.Properties()
                .stacksTo(1)
                .rarity(Rarity.EPIC)
                .fireResistant()));
}
