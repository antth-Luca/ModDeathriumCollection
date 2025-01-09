package io.github.antthluca.deathrium_collection.items.custom;

import java.util.function.Supplier;

import com.google.common.base.Suppliers;

import io.github.antthluca.deathrium_collection.init.InitItems;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;

public enum DCItemTiers implements Tier {
    DEATHRIUM(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 0, 30.0F, 30.0F, 45, () -> Ingredient.of(InitItems.DEATHRIUM_INGOT.get()));

    private final TagKey<Block> incorrectBlocksForDrops;
    private final int maxUses;
    private final float efficiency;
    private final float attackDamage;
    private final int enchantability;
    private final Supplier<Ingredient> repairMaterial;

    DCItemTiers(TagKey<Block> incorrectBlocksForDrops, int maxUses, float efficiency, float attackDamage, int enchantability, Supplier<Ingredient> repairMaterial) {
        this.incorrectBlocksForDrops = incorrectBlocksForDrops;
        this.maxUses = maxUses;
        this.efficiency = efficiency;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairMaterial = Suppliers.memoize(repairMaterial::get);
    }

    @Override
    public TagKey<Block> getIncorrectBlocksForDrops() {
        return this.incorrectBlocksForDrops;
    }

    @Override
    public int getUses() {
        return this.maxUses;
    }

    @Override
    public float getSpeed() {
        return this.efficiency;
    }

    @Override
    public float getAttackDamageBonus() {
        return this.attackDamage;
    }

    @Override
    public int getEnchantmentValue() {
        return this.enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairMaterial.get();
    }
}
