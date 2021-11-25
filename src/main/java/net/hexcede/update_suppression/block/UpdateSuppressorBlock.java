package net.hexcede.update_suppression.block;

import net.hexcede.update_suppression.UpdateSuppressionError;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class UpdateSuppressorBlock extends Block {
//    public static final BooleanProperty ENABLED = BooleanProperty.of("enabled");

    public UpdateSuppressorBlock(Settings settings) {
        super(settings);
//        this.setDefaultState((BlockState)this.getDefaultState().with(ENABLED, true));
    }

    @Override
    @Nullable
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return (BlockState)this.getDefaultState();
    }

    @Override
    public void neighborUpdate(BlockState state, World world, BlockPos pos, Block block, BlockPos fromPos, boolean notify) {
        // TODO: Check if Block is RedstoneInterfaceBlock
//        if () {
//            BlockState fromState = world.getBlockState(fromPos);
//            world.setBlockState(pos, (BlockState) state.with(ENABLED, !fromState.get(RedstoneInterfaceBlock.POWERED).booleanValue()), Block.NOTIFY_LISTENERS);
//            return;
//        }
        throw new UpdateSuppressionError();
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
//        builder.add(ENABLED);
    }
}
