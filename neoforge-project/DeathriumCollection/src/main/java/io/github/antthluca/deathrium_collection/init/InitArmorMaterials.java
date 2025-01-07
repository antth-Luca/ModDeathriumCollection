package io.github.antthluca.deathrium_collection.init;

import java.util.EnumMap;
import java.util.List;

import io.github.antthluca.deathrium_collection.DeathriumCollection;
import net.minecraft.Util;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class InitArmorMaterials {
    public static final DeferredRegister<ArmorMaterial> ARMOR_MATERIALS = DeferredRegister.create(
        Registries.ARMOR_MATERIAL, DeathriumCollection.MODID
    );

    // Armor materials
    public static final DeferredHolder<ArmorMaterial, ArmorMaterial> DEATHRIUM = ARMOR_MATERIALS.register(
        "deathrium", () -> new ArmorMaterial(
            // Proteção
            Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 9);
                map.put(ArmorItem.Type.LEGGINGS, 18);
                map.put(ArmorItem.Type.CHESTPLATE, 24);
                map.put(ArmorItem.Type.HELMET, 9);
            }),
            // Encantabilidade
            15,
            // Som
            SoundEvents.ARMOR_EQUIP_NETHERITE,
            // Ingrediente para reparo
            () -> Ingredient.of(InitItems.DEATHRIUM_INGOT.get()),
            // Visual
            List.of(
                new ArmorMaterial.Layer(
                    // Caminho para textura base da armadura
                    ResourceLocation.fromNamespaceAndPath(
                        DeathriumCollection.MODID, "deathrium"
                    ),
                    // Definir variantes
                    "",
                    // É emissivo?
                    false
                )
            ),
            // Resistência à perfuração
            36.0F,
            // Resistência a repulsão
            45.0F
        ));
}