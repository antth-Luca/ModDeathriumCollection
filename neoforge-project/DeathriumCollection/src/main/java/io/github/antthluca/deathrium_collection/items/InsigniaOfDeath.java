package io.github.antthluca.deathrium_collection.items;

import java.util.List;

import io.github.antthluca.deathrium_collection.utils.SoulCountUtils;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

public class InsigniaOfDeath extends Item {
    public InsigniaOfDeath(Properties prop) {
        super(prop);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, TooltipContext tooltipCtx, List<Component> tooltip, TooltipFlag flagIn) {
        super.appendHoverText(stack, tooltipCtx, tooltip, flagIn);
        tooltip.add(
            Component.translatable("item.deathrium_collection.insignia_of_death.kill")
            .append(": ")
            .append(Component.literal(SoulCountUtils.getSouls(stack) + "/" + SoulCountUtils.MAX_SOULS_INSIGNIA))
        );
        if (Screen.hasShiftDown()) {
            tooltip.add(Component.translatable("item.deathrium_collection.insignia_of_death.tooltip").withStyle(ChatFormatting.GRAY));
        } else {
            tooltip.add(Component.translatable("item.deathrium_collection.common_tooltip").withStyle(ChatFormatting.GRAY));
        }
    }
}
