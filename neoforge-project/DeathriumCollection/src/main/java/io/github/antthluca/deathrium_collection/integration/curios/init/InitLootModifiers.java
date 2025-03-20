package io.github.antthluca.deathrium_collection.integration.curios.init;

import java.util.function.Supplier;

import com.mojang.serialization.MapCodec;

import io.github.antthluca.deathrium_collection.DeathriumCollection;
import io.github.antthluca.deathrium_collection.integration.curios.loot.AddItemModifier;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class InitLootModifiers {
    public static final DeferredRegister<MapCodec<? extends IGlobalLootModifier>> LOOT_MODIFIERS = DeferredRegister.create(
        NeoForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, DeathriumCollection.MODID
    );

    // Loot modifiers
    public static final Supplier<MapCodec<? extends IGlobalLootModifier>> ADD_ITEM = LOOT_MODIFIERS.register(
        "add_item", () -> AddItemModifier.CODEC);
}
