package io.github.antthluca.deathrium_collection.utils;

import io.github.antthluca.deathrium_collection.items.custom.DeathriumArmor;
import net.minecraft.world.entity.player.Player;

public class ArmorVerification {
    public static boolean hasFullArmor(Player player) {
        return player.getInventory().armor.stream()
            .allMatch(item -> item.getItem() instanceof DeathriumArmor);
    }
}
