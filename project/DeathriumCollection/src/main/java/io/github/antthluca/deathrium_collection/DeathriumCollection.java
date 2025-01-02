package io.github.antthluca.deathrium_collection;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;
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

        bus.addListener(this::setup);
    }

    private void setup(final FMLCommonSetupEvent event) {
        LOGGER.info("HELLO FROM SETUP");
    }
}
