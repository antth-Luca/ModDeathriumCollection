package io.github.antthluca.deathrium_collection.init;

import com.mojang.serialization.Codec;

import io.github.antthluca.deathrium_collection.DeathriumCollection;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.codec.ByteBufCodecs;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class InitDataComponentType {
    public static final DeferredRegister<DataComponentType<?>> DATA_COMPONENTS = DeferredRegister.create(
        Registries.DATA_COMPONENT_TYPE, DeathriumCollection.MODID
    );

    // Data Components
    public static final DeferredHolder<DataComponentType<?>, DataComponentType<Integer>> SOUL_COUNT = DATA_COMPONENTS.register(
        "soul_count", () -> DataComponentType.<Integer>builder().persistent(Codec.INT).networkSynchronized(ByteBufCodecs.INT).build()
    );
}
