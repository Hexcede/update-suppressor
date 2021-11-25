package net.hexcede.update_suppression.block;

import net.hexcede.update_suppression.UpdateSuppression;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.RedstoneTorchBlock;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class RedstoneInterfaceBlock extends Block {
    public static final BooleanProperty POWERED = BooleanProperty.of("powered");

    public RedstoneInterfaceBlock(Settings settings) {
        super(settings);
        this.setDefaultState((BlockState)this.getDefaultState().with(POWERED, false));
    }

    @Override
    @Nullable
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return (BlockState)this.getDefaultState().with(POWERED, ctx.getWorld().isReceivingRedstonePower(ctx.getBlockPos()));
    }

    @Override
    public void neighborUpdate(BlockState state, World world, BlockPos pos, Block block, BlockPos fromPos, boolean notify) {
        if (world.isClient) {
            return;
        }
        this.updateState(state, world, pos);
    }

    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        this.updateState(state, world, pos);
    }

    private void updateState(BlockState state, World world, BlockPos pos) {
        boolean powered = world.isReceivingRedstonePower(pos);
        if (powered != state.get(POWERED)) {
            if (powered) {
                UpdateSuppression.LOGGER.info("Interface powered.");
            }
            world.setBlockState(pos, (BlockState) state.with(POWERED, powered), Block.NOTIFY_LISTENERS);
        }
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(POWERED);
    }
}
