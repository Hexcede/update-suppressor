package net.hexcede.update_suppression.mixin;

import net.hexcede.update_suppression.UpdateSuppression;
import net.hexcede.update_suppression.UpdateSuppressionError;
import net.minecraft.server.world.ServerChunkManager;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ServerChunkManager.class)
public class ServerChunkManagerMixin {
    @Redirect(
            method= "tick(Ljava/util/function/BooleanSupplier;)V",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/server/world/ServerChunkManager;tickChunks()V"
            )
    )
    private void tickChunks(ServerChunkManager serverChunkManager) throws Throwable {
        try {
            // Invoke tickChunks
            ((ServerChunkManagerInvoker) serverChunkManager).invokeTickChunks();
        }
        catch (Throwable throwable) {
            UpdateSuppressionError.suppressCrashes(throwable);
        }
    }
}
