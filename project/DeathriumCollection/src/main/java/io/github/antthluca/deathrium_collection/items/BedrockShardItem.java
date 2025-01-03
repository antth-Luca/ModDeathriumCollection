package io.github.antthluca.deathrium_collection.items;

import java.util.List;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class BedrockShardItem extends Item {
    public BedrockShardItem(Item.Properties prop) {
        super(prop);
    }

    @SuppressWarnings("null")
    @Override
    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, TooltipContext tooltipCtx, List<Component> tooltip, TooltipFlag flagIn) {
        super.appendHoverText(stack, tooltipCtx, tooltip, flagIn);
        tooltip.add(Component.translatable("item.deathrium_collection.bedrock_shard.tooltip").withStyle(ChatFormatting.GRAY));
    }
}
