package io.github.antthluca.deathrium_collection;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import io.github.antthluca.deathrium_collection.init.InitCreativeTabs;
import io.github.antthluca.deathrium_collection.init.InitItems;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(DeathriumCollection.MODID)
public class DeathriumCollection {
    public static final String MODID = "deathrium_collection";
    private static final Logger LOGGER = LogUtils.getLogger();

    public DeathriumCollection(FMLJavaModLoadingContext ctx) {
        IEventBus bus = ctx.getModEventBus();

        InitItems.ITEMS.register(bus);
        InitCreativeTabs.TABS.register(bus);

        bus.addListener(this::setup);
    }

    private void setup(final FMLCommonSetupEvent event) {
        LOGGER.info("HELLO FROM SETUP");
    }
}
