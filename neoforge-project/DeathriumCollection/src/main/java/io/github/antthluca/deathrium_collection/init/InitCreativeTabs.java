package io.github.antthluca.deathrium_collection.init;

import io.github.antthluca.deathrium_collection.DeathriumCollection;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class InitCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(
        Registries.CREATIVE_MODE_TAB, DeathriumCollection.MODID
    );

    // Tabs
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> MAIN = TABS.register(
        "main", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.deathrium_collection"))
            .icon(() -> new ItemStack(InitItems.DEATHRIUM_INGOT.get()))
            .displayItems((displayParams, output) -> {
                InitItems.ITEMS.getEntries().forEach(item -> output.accept(item.get()));
                InitBlockItems.BLOCK_ITEMS.getEntries().forEach(item -> output.accept(item.get()));
                InitArmorItems.ARMOR_ITEMS.getEntries().forEach(item -> output.accept(item.get()));
            }).build()
    );
}
