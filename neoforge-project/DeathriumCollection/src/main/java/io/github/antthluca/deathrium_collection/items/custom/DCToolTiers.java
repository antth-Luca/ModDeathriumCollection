package io.github.antthluca.deathrium_collection.items.custom;

import io.github.antthluca.deathrium_collection.init.InitItems;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;

public class DCToolTiers {
    public static final Tier DEATHRIUM = new SimpleTier(
        // Blocos incorretos para quebrar
        BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
        // Durabilidade
        6093,
        // Velocidade de mineração
        27f,
        // Dano bônus
        12f,
        // Encantabilidade
        45,
        // Ingrediente para restauração
        () -> Ingredient.of(InitItems.DEATHRIUM_INGOT.get())
    );
}
