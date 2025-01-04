package io.github.antthluca.deathrium_collection.recipes;

import io.github.antthluca.deathrium_collection.init.InitRecipeSerializers;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.NonNullList;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CraftingBookCategory;
import net.minecraft.world.item.crafting.CraftingInput;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.ShapelessRecipe;

public class CraftingShapelessReturnDurability extends ShapelessRecipe {
    private final ItemStack result;
    private final Ingredient durabilityReturnItem;

    public CraftingShapelessReturnDurability(String group, ItemStack result, NonNullList<Ingredient> inputs, Ingredient durabilityReturnItem) {
        super(group, CraftingBookCategory.MISC, result, inputs);
        this.result = result;
        this.durabilityReturnItem = durabilityReturnItem;
    }

    @Override
    public NonNullList<ItemStack> getRemainingItems(@SuppressWarnings("null") CraftingInput inv) {
        var remaining = super.getRemainingItems(inv);

        for (int i = 0; i < inv.size(); i++) {
            var stack = inv.getItem(i);

            if (this.durabilityReturnItem.test(stack)) {
                var returnItem = stack.copy();

                if (returnItem.isDamageableItem()) {
                    var damage = returnItem.getDamageValue() + 1;
                    returnItem.setDamageValue(damage);
                    if (damage < returnItem.getMaxDamage()) {
                        remaining.set(i, returnItem);
                    }
                } else {
                    remaining.set(i, returnItem);
                }
            }
        }

        return remaining;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return InitRecipeSerializers.CRAFTING_SHAPELESS_RETURN_DURABILITY.get();
    }

    public static class Serializer implements RecipeSerializer<CraftingShapelessReturnDurability> {
        public static final MapCodec<CraftingShapelessReturnDurability> CODEC = RecordCodecBuilder.mapCodec(builder ->
            builder.group(
                Codec.STRING.optionalFieldOf("group", "").forGetter(ShapelessRecipe::getGroup),
                ItemStack.STRICT_CODEC.fieldOf("result").forGetter(recipe -> recipe.result),
                Ingredient.CODEC_NONEMPTY
                    .listOf()
                    .fieldOf("ingredients")
                    .flatXmap(
                        field -> {
                            Ingredient[] ingredients = field.toArray(new Ingredient[0]);
                            if (ingredients.length == 0) {
                                return DataResult.error(() -> "No ingredients for shapeless recipe");
                            } else {
                                return ingredients.length > 9
                                        ? DataResult.error(() -> "Too many ingredients for shapeless recipe.")
                                        : DataResult.success(NonNullList.of(Ingredient.EMPTY, ingredients));
                            }
                        },
                        DataResult::success
                    ).forGetter(ShapelessRecipe::getIngredients),
                Ingredient.CODEC_NONEMPTY.fieldOf("durability_return").forGetter(recipe -> recipe.durabilityReturnItem)
            ).apply(builder, CraftingShapelessReturnDurability::new)
        );
        public static final StreamCodec<RegistryFriendlyByteBuf, CraftingShapelessReturnDurability> STREAM_CODEC = StreamCodec.of(
                CraftingShapelessReturnDurability.Serializer::toNetwork, CraftingShapelessReturnDurability.Serializer::fromNetwork
        );

        @Override
        public MapCodec<CraftingShapelessReturnDurability> codec() {
            return CODEC;
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, CraftingShapelessReturnDurability> streamCodec() {
            return STREAM_CODEC;
        }

        private static CraftingShapelessReturnDurability fromNetwork(RegistryFriendlyByteBuf buffer) {
            var group = buffer.readUtf(32767);
            int size = buffer.readVarInt();
            var inputs = NonNullList.withSize(size, Ingredient.EMPTY);

            for (int i = 0; i < size; i++) {
                inputs.set(i, Ingredient.CONTENTS_STREAM_CODEC.decode(buffer));
            }

            var result = ItemStack.STREAM_CODEC.decode(buffer);
            var durabilityReturnItem = Ingredient.CONTENTS_STREAM_CODEC.decode(buffer);

            return new CraftingShapelessReturnDurability(group, result, inputs, durabilityReturnItem);
        }

        private static void toNetwork(RegistryFriendlyByteBuf buffer, CraftingShapelessReturnDurability recipe) {
            buffer.writeUtf(recipe.getGroup());
            buffer.writeVarInt(recipe.getIngredients().size());

            for (var ingredient : recipe.getIngredients()) {
                Ingredient.CONTENTS_STREAM_CODEC.encode(buffer, ingredient);
            }

            ItemStack.STREAM_CODEC.encode(buffer, recipe.result);
            Ingredient.CONTENTS_STREAM_CODEC.encode(buffer, recipe.durabilityReturnItem);
        }
    }
}
