package net.hexcede.update_suppression.mixin;

import net.hexcede.update_suppression.UpdateSuppression;
import net.hexcede.update_suppression.UpdateSuppressionError;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.world.ServerWorld;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.function.BooleanSupplier;

@Mixin(MinecraftServer.class)
public class MinecraftServerMixin {
    @Redirect(
            method= "tick(Ljava/util/function/BooleanSupplier;)V",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/server/MinecraftServer;tickWorlds(Ljava/util/function/BooleanSupplier;)V"
            )
    )
    private void tickChunks(MinecraftServer minecraftServer, BooleanSupplier shouldKeepTicking) throws Throwable {
        try {
            // Invoke tickWorlds
            minecraftServer.tickWorlds(shouldKeepTicking);
        }
        catch (Throwable throwable) {
            UpdateSuppressionError.suppressCrashes(throwable);
        }
    }
}
