package net.hexcede.update_suppression;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UpdateSuppression implements ModInitializer {
    public static final Logger LOGGER = LogManager.getLogger("UpdateSuppression");
    public static final Block UPDATE_SUPPRESSOR = new UpdateSuppressorBlock(FabricBlockSettings.of(Material.METAL).strength(-1.0f));

    @Override
    public void onInitialize() {
        Registry.register(Registry.BLOCK, new Identifier("update_suppression", "update_suppressor"), UPDATE_SUPPRESSOR);
        Registry.register(Registry.ITEM, new Identifier("update_suppression", "update_suppressor"), new BlockItem(UPDATE_SUPPRESSOR, new FabricItemSettings().group(ItemGroup.REDSTONE)));
    }
}
