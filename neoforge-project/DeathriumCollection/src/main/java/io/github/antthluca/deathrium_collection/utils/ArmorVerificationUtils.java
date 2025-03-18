package io.github.antthluca.deathrium_collection.utils;

import io.github.antthluca.deathrium_collection.items.custom.DeathriumArmor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

public class ArmorVerificationUtils {
    public static boolean hasFullArmor(Player player) {
        for (ItemStack stack : player.getArmorSlots()) {
            if (stack.isEmpty() || !(stack.getItem() instanceof DeathriumArmor)) {
                return false;
            }
        }

        return true;
    }
}
