package io.github.antthluca.deathrium_collection.utils;

import io.github.antthluca.deathrium_collection.init.InitDataComponentType;
import io.github.antthluca.deathrium_collection.init.InitItems;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class SoulCountUtils {
    public static final int MAX_SOULS_INSIGNIA = 20;
    public static final int MAX_SOULS_CUP = 1000;

    public static void addSoulsToInsignia(Player player, ItemStack stack, int amount) {
        int souls = getSouls(stack);

        if (souls >= MAX_SOULS_INSIGNIA) {
            upgradeInsigniaToSignature(player);
        } else {
            int newAmount = Math.min(MAX_SOULS_INSIGNIA, souls + amount);

            if (newAmount >= MAX_SOULS_INSIGNIA) {
                upgradeInsigniaToSignature(player);
            } else {
                stack.set(InitDataComponentType.SOUL_COUNT, newAmount);
            }
        }
    }

    public static void addSoulsToCup(Player player, ItemStack stack, int amount) {
        int souls = getSouls(stack);

        if (souls < MAX_SOULS_CUP) {
            int newAmount = Math.min(MAX_SOULS_CUP, souls + amount);

            if (newAmount > MAX_SOULS_CUP) {
                stack.set(InitDataComponentType.SOUL_COUNT, MAX_SOULS_CUP);
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
