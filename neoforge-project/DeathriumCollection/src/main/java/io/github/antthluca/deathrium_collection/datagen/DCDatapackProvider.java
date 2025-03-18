package io.github.antthluca.deathrium_collection.datagen;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

import io.github.antthluca.deathrium_collection.DeathriumCollection;
import io.github.antthluca.deathrium_collection.worldgen.DCBiomeModifiers;
import io.github.antthluca.deathrium_collection.worldgen.DCConfiguredFeatures;
import io.github.antthluca.deathrium_collection.worldgen.DCPlacedFeatures;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class DCDatapackProvider extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, DCConfiguredFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, DCPlacedFeatures::bootstrap)
            .add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, DCBiomeModifiers::bootstrap);

    public DCDatapackProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, BUILDER, Set.of(DeathriumCollection.MODID));
    }
}
