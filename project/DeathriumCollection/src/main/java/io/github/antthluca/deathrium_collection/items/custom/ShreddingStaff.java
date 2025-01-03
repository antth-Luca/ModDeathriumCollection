package io.github.antthluca.deathrium_collection.items.custom;

import io.github.antthluca.deathrium_collection.init.InitItems;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class ShreddingStaff extends Item {
    public ShreddingStaff(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResult useOn(@SuppressWarnings("null") UseOnContext context) {
        Level level = context.getLevel();
        Player player = context.getPlayer();
        BlockPos pos = context.getClickedPos();
        BlockState blockState = level.getBlockState(pos);

        if (!level.isClientSide() && player != null && blockState.getBlock() == Blocks.BEDROCK) {
            if (player.getCooldowns().isOnCooldown(this)) return InteractionResult.FAIL;  // Verifica se o item está em cooldown

            if (level instanceof ServerLevel serverLevel) {
                serverLevel.getServer().execute(() -> {
                    ItemStack stack = context.getItemInHand();

                    // Gera o item ao interagir com o bloco
                    ItemStack generatedItem = new ItemStack(InitItems.BEDROCK_SHARD.get(), 1); // Substitua pelo item desejado
                    player.addItem(generatedItem);

                    // Diminui a durabilidade do cajado
                    stack.hurtAndBreak(1, player, EquipmentSlot.MAINHAND);

                    // Adiciona cooldown ao item
                    player.getCooldowns().addCooldown(this, 100); // 100 ticks = 5 segundos
                });
            }
            return InteractionResult.SUCCESS;
        }

        return InteractionResult.PASS;
    }
}
