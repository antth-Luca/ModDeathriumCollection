package io.github.antthluca.deathrium_collection.utils;

import io.github.antthluca.deathrium_collection.init.InitDataComponentType;
import io.github.antthluca.deathrium_collection.init.InitItems;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class SoulCountUtils {
    public static final int MAX_SOULS = 20;

    public static void addSoulsToInsignia(Player player, ItemStack stack, int amount) {
        int souls = getSouls(stack);

        if (souls >= MAX_SOULS) {
            upgradeInsigniaToSignature(player);
        } else {
            int newAmount = Math.min(MAX_SOULS, souls + amount);

            if (newAmount >= MAX_SOULS) {
                upgradeInsigniaToSignature(player);
            } else {
                stack.set(InitDataComponentType.SOUL_COUNT, newAmount);
            }
        }
    }

    public static int getSouls(ItemStack stack) {
        var component = stack.get(InitDataComponentType.SOUL_COUNT);

        if (component != null) {
            return component;
        }

        return 0;
    }

    public static void upgradeInsigniaToSignature(Player player) {
        player.setItemInHand(InteractionHand.OFF_HAND, new ItemStack(InitItems.SIGNATURE_OF_DEATH.get()));
    }
}
