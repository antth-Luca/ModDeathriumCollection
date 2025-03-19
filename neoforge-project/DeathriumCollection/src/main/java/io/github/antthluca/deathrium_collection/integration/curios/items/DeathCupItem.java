package io.github.antthluca.deathrium_collection.integration.curios.items;

import java.util.List;

import io.github.antthluca.deathrium_collection.integration.curios.items.custom.RelicItem;
import io.github.antthluca.deathrium_collection.integration.curios.rarities.DCRarities;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

public class DeathCupItem extends RelicItem {
    public DeathCupItem() {
        super(new Item.Properties(), DCRarities.EPIC);
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltip, TooltipFlag tooltipFlag) {
        super.appendHoverText(stack, context, tooltip, tooltipFlag);
        if (Screen.hasShiftDown()) {
            tooltip.add(Component.translatable("item.deathrium_collection.death_cup.tooltip.passive").withStyle(ChatFormatting.GRAY));
        } else {
            tooltip.add(Component.translatable("item.deathrium_collection.death_cup.tooltip.lore"));
            tooltip.add(Component.translatable("item.deathrium_collection.common_tooltip").withStyle(ChatFormatting.GRAY));
        }
    }
}
