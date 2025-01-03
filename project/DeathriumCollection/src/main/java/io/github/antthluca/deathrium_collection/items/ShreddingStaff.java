package io.github.antthluca.deathrium_collection.items;

import java.util.List;

import io.github.antthluca.deathrium_collection.init.InitItems;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class ShreddingStaff extends Item {
    public ShreddingStaff(Properties properties) {
        super(properties);
    }

    @SuppressWarnings("null")
    @Override
    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, TooltipContext tooltipCtx, List<Component> tooltip, TooltipFlag flagIn) {
        super.appendHoverText(stack, tooltipCtx, tooltip, flagIn);
        if (Screen.hasShiftDown()) {
            tooltip.add(Component.translatable("item.deathrium_collection.shredding_staff.tooltip").withStyle(ChatFormatting.GRAY));
        } else {
            tooltip.add(Component.translatable("item.deathrium_collection.common_tooltip").withStyle(ChatFormatting.GRAY));
        }
    }

    @SuppressWarnings("null")
    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);

        // Verifica se o item está em cooldown
        if (player.getCooldowns().isOnCooldown(this)) {
            return InteractionResultHolder.fail(stack);
        }

        // Inicia o carregamento
        player.startUsingItem(hand);
        return InteractionResultHolder.consume(stack);
    }

    @SuppressWarnings("null")
    @Override
    public int getUseDuration(ItemStack stack, LivingEntity entity) {
        return 36000; // Define a duração máxima de uso (como o arco)
    }

    @Override
    public UseAnim getUseAnimation(@SuppressWarnings("null") ItemStack stack) {
        return UseAnim.BOW; // Define a animação de carregamento como a do arco
    }

    @SuppressWarnings("null")
    @Override
    public void releaseUsing(ItemStack stack, Level level, LivingEntity entity, int timeLeft) {
        if (entity instanceof Player player && !level.isClientSide()) {
            // Calcula o tempo total de carregamento
            int chargeTime = this.getUseDuration(stack, entity) - timeLeft;
            // Obtém o bloco na posição em que o jogador está olhando
            BlockHitResult rayTraceResult = rayTrace(player);
            BlockPos clickedPos = rayTraceResult.getBlockPos();
            BlockState blockState = level.getBlockState(clickedPos);

            // Carregado por no mínimo 1 segundo e está usando numa Bedrock
            if (chargeTime >= 20 && blockState.getBlock() == Blocks.BEDROCK) {
                // Verifica se o jogador possui o item específico na mão secundária
                ItemStack offhandItem = player.getOffhandItem();
                if (!offhandItem.isEmpty() && offhandItem.getItem() == InitItems.SOUL_GLASS.get()) {
                    // Se o item desejado estiver presente na mão secundária, reduz a quantidade do item
                    offhandItem.shrink(1); // Reduz 1 unidade do item

                    // Gera o item
                    ItemStack generatedItem = new ItemStack(InitItems.BEDROCK_SHARD.get(), 1);
                    player.addItem(generatedItem);

                    // Diminui a durabilidade do cajado
                    stack.hurtAndBreak(1, player, EquipmentSlot.MAINHAND);

                    // Adiciona cooldown ao item
                    player.getCooldowns().addCooldown(this, 100); // 100 ticks = 5 segundos
                } else {
                    player.sendSystemMessage(Component.translatable("item.deathrium_collection.shredding_staff.failed_use"));
                }
            }
        }
    }

    // Método auxiliar para ray tracing
    private BlockHitResult rayTrace(Player player) {
        return (BlockHitResult) player.pick(2.0, 1.0F, false); // Fazendo ray tracing com 2 blocos de distância
    }
}
