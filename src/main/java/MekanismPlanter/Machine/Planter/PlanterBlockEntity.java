package MekanismPlanter.Machine.Planter;

import mekanism.api.providers.IBlockProvider;
import mekanism.api.recipes.cache.CachedRecipe;
import mekanism.common.recipe.IMekanismRecipeTypeProvider;
import mekanism.common.tile.prefab.TileEntityProgressMachine;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class PlanterBlockEntity extends TileEntityProgressMachine<PlanterRecipe> {
    protected PlanterBlockEntity(IBlockProvider blockProvider, BlockPos pos, BlockState state, List<CachedRecipe.OperationTracker.RecipeError> errorTypes, int baseTicksRequired) {
        super(blockProvider, pos, state, errorTypes, baseTicksRequired);
    }

    @Override
    public @NotNull IMekanismRecipeTypeProvider<?, PlanterRecipe, ?> getRecipeType() {
        return null;
    }

    @Override
    public @Nullable PlanterRecipe getRecipe(int cacheIndex) {
        return null;
    }

    @Override
    public @NotNull CachedRecipe<PlanterRecipe> createNewCachedRecipe(@NotNull PlanterRecipe recipe, int cacheIndex) {
        return null;
    }
}
