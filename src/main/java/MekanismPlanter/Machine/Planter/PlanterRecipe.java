package MekanismPlanter.Machine.Planter;

import mekanism.api.annotations.NothingNullByDefault;
import mekanism.api.recipes.MekanismRecipe;
import mekanism.api.recipes.ingredients.ItemStackIngredient;
import net.minecraft.core.NonNullList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

import java.util.Objects;

@NothingNullByDefault
public class PlanterRecipe extends MekanismRecipe<PlanterRecipeInput> {
    protected final ItemStackIngredient Input;
    protected final ItemStack Output;
    protected final float Duration;

    public PlanterRecipe(ItemStackIngredient input, float duration, ItemStack output) {
        Input = Objects.requireNonNull(input, "Item input cannot be null.");
        Duration = duration;
        Output = Objects.requireNonNull(output, "Item output cannot be null.");
    }

    public ItemStackIngredient getInputSolid() {
        return Input;
    }

    public float getDuration() {
        return Duration;
    }

    public ItemStack getOutputItem() {
        return Output;
    }

    @Override
    public String getGroup() {
        return "planter";
    }

    @Override
    public boolean matches(PlanterRecipeInput planterRecipeInput, Level level) {
        return !isIncomplete() && Input.test(planterRecipeInput.item());
    }

    @Override
    public boolean isIncomplete() {
        return Input.hasNoMatchingInstances();
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return null;
    }

    @Override
    public RecipeType<?> getType() {
        return null;
    }

    public record PlanterRecipeOutput(NonNullList<ItemStack> items) {
        public PlanterRecipeOutput {
            Objects.requireNonNull(items, "Item output cannot be null.");
            if (items.stream().anyMatch(ItemStack::isEmpty)) {
                throw new IllegalArgumentException("At least one output must be present.");
            }
        }
    }
}