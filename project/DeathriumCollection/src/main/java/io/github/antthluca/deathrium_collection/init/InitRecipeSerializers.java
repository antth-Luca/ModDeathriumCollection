package io.github.antthluca.deathrium_collection.init;

import io.github.antthluca.deathrium_collection.DeathriumCollection;
import io.github.antthluca.deathrium_collection.recipes.CraftingShapelessReturnDurability;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class InitRecipeSerializers {
    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(
        Registries.RECIPE_SERIALIZER, DeathriumCollection.MODID
    );

    // Serializers
    public static final RegistryObject<RecipeSerializer<?>> CRAFTING_SHAPELESS_RETURN_DURABILITY = RECIPE_SERIALIZERS.register(
        "crafting_shapeless_return_durability", CraftingShapelessReturnDurability.Serializer::new);
}
