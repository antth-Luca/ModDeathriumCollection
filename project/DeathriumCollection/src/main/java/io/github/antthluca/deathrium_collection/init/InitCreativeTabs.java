package io.github.antthluca.deathrium_collection.init;

import io.github.antthluca.deathrium_collection.DeathriumCollection;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class InitCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(
        Registries.CREATIVE_MODE_TAB, DeathriumCollection.MODID
    );

    // Tabs
    public static final RegistryObject<CreativeModeTab> MAIN = TABS.register(
        "main", () -> CreativeModeTab.builder()
            .title(Component.translatable("itemGroup.deathrium_collection"))
            .icon(() -> new ItemStack(InitItems.OXIDIZED_ALLOY.get()))
            .displayItems((displayParams, output) -> {
                InitItems.ITEMS.getEntries().forEach(item -> output.accept(item.get()));
            }).build()
    );
}
