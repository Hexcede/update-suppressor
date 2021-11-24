package net.hexcede.update_suppression.mixin;

import net.minecraft.server.world.ServerChunkManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(ServerChunkManager.class)
public interface ServerChunkManagerInvoker {
    @Invoker("tickChunks")
    public void invokeTickChunks();
}
