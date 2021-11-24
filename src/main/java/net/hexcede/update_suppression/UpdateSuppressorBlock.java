package net.hexcede.update_suppression;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class UpdateSuppressorBlock extends Block {
    public UpdateSuppressorBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void neighborUpdate(BlockState state, World world, BlockPos pos, Block block, BlockPos fromPos, boolean notify) {
        throw new UpdateSuppressionError();
    }
}
