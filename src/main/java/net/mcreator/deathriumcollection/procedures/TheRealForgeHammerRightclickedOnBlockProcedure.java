package net.mcreator.deathriumcollection.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.mcreator.deathriumcollection.init.DeathriumCollectionModItems;

public class TheRealForgeHammerRightclickedOnBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;

		// Verifica se o item usado é o martelo
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == DeathriumCollectionModItems.THE_REAL_FORGE_HAMMER.get()) {
			
			// Verifica se o bloco clicado é Bedrock
			Block blockAtPos = world.getBlockState(new BlockPos(x, y, z)).getBlock();
			if (blockAtPos == Blocks.BEDROCK) {
				
				// Efeito visual ao interagir com Bedrock
				world.levelEvent(2001, new BlockPos(x, y, z), Block.getId(Blocks.BEDROCK.defaultBlockState()));

				// Adiciona o fragmento de Bedrock
				if (world instanceof Level _level && !_level.isClientSide()) {
					ItemEntity entityToSpawn = new ItemEntity(_level, x + 0.5, y + 1, z + 0.5, new ItemStack(DeathriumCollectionModItems.BEDROCK_SHARD.get()));
					entityToSpawn.setPickUpDelay(10);
					_level.addFreshEntity(entityToSpawn);
				}

				// Aumenta o dano no martelo
				((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY))
						.setDamageValue((int) (((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).getDamageValue() + 3));
			}
		}
	}
}
