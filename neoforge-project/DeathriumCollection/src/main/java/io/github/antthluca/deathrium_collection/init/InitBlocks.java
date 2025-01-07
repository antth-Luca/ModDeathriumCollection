package io.github.antthluca.deathrium_collection.init;

import io.github.antthluca.deathrium_collection.DeathriumCollection;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class InitBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.createBlocks(DeathriumCollection.MODID);

    // Blocks
    public static final DeferredHolder<Block, Block> CRYSTAL_SOUL_SAND = BLOCKS.register(
        "crystallized_soul_sand", 
        () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.SOUL_SAND))
    );
}
