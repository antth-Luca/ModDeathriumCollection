package io.github.antthluca.deathrium_collection;

import io.github.antthluca.deathrium_collection.init.InitArmorItems;
import io.github.antthluca.deathrium_collection.init.InitArmorMaterials;
import io.github.antthluca.deathrium_collection.init.InitBlockItems;
import io.github.antthluca.deathrium_collection.init.InitBlocks;
import io.github.antthluca.deathrium_collection.init.InitCreativeTabs;
import io.github.antthluca.deathrium_collection.init.InitDataComponentType;
import io.github.antthluca.deathrium_collection.init.InitItems;
import io.github.antthluca.deathrium_collection.init.InitRecipeSerializers;
import io.github.antthluca.deathrium_collection.init.InitToolItems;
import io.github.antthluca.deathrium_collection.integration.curios.init.InitRelicItems;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;

@Mod(DeathriumCollection.MODID)
public class DeathriumCollection {
    // Define mod id in a common place for everything to reference
    public static final String MODID = "deathrium_collection";

    public DeathriumCollection(IEventBus bus, ModContainer container) {
        // Init
        InitItems.ITEMS.register(bus);
        InitToolItems.TOOL_ITEMS.register(bus);

        InitBlocks.BLOCKS.register(bus);
        InitBlockItems.BLOCK_ITEMS.register(bus);

        InitDataComponentType.DATA_COMPONENTS.register(bus);

        InitArmorMaterials.ARMOR_MATERIALS.register(bus);
        InitArmorItems.ARMOR_ITEMS.register(bus);

        InitRelicItems.RELIC_ITEMS.register(bus);

        InitCreativeTabs.TABS.register(bus);
        InitRecipeSerializers.RECIPE_SERIALIZERS.register(bus);
    }
}
