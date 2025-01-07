package io.github.antthluca.deathrium_collection;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import io.github.antthluca.deathrium_collection.init.InitArmorItems;
import io.github.antthluca.deathrium_collection.init.InitArmorMaterials;
import io.github.antthluca.deathrium_collection.init.InitBlockItems;
import io.github.antthluca.deathrium_collection.init.InitBlocks;
import io.github.antthluca.deathrium_collection.init.InitCreativeTabs;
import io.github.antthluca.deathrium_collection.init.InitItems;
import io.github.antthluca.deathrium_collection.init.InitRecipeSerializers;
import io.github.antthluca.deathrium_collection.init.InitToolItems;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod(DeathriumCollection.MODID)
public class DeathriumCollection {
    // Define mod id in a common place for everything to reference
    public static final String MODID = "deathrium_collection";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public DeathriumCollection(IEventBus bus, ModContainer container) {
        // Init
        InitItems.ITEMS.register(bus);
        InitToolItems.TOOL_ITEMS.register(bus);

        InitBlocks.BLOCKS.register(bus);
        InitBlockItems.BLOCK_ITEMS.register(bus);

        InitArmorMaterials.ARMOR_MATERIALS.register(bus);
        InitArmorItems.ARMOR_ITEMS.register(bus);

        InitCreativeTabs.TABS.register(bus);
        InitRecipeSerializers.RECIPE_SERIALIZERS.register(bus);

        // Common setup
        bus.addListener(this::commonSetup);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        LOGGER.info("HELLO FROM COMMON SETUP");
    }
}
