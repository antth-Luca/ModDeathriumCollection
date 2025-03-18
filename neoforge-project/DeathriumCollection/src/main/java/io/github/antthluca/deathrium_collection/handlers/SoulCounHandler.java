package io.github.antthluca.deathrium_collection.handlers;

import io.github.antthluca.deathrium_collection.DeathriumCollection;
import io.github.antthluca.deathrium_collection.init.InitItems;
import io.github.antthluca.deathrium_collection.utils.SoulCountUtils;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;

@EventBusSubscriber(modid = DeathriumCollection.MODID)
public class SoulCounHandler {
    @SubscribeEvent
    public static void onLivingDeath(LivingDeathEvent event) {
        var source = event.getSource();

        if (source.getEntity() instanceof Player player) {
            ItemStack offhandItem = player.getOffhandItem();

            if (!offhandItem.isEmpty() && offhandItem.getItem() == InitItems.INSIGNIA_OF_DEATH.get()) {
                SoulCountUtils.addSoulsToInsignia(player, offhandItem, 1);
            }
        }
    }
}
