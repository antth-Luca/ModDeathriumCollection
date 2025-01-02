package io.github.antthluca.deathrium_collection.init;

import io.github.antthluca.deathrium_collection.DeathriumCollection;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class InitBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(
        ForgeRegistries.BLOCKS, DeathriumCollection.MODID
    );

    // Blocks
    public static final RegistryObject<Block> CRYST_SOUL_SAND = BLOCKS.register(
        "crystallized_soul_sand", () -> new Block(
            BlockBehaviour.Properties.ofFullCopy(Blocks.SOUL_SAND)));
}
