package net.hexcede.update_suppression;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.hexcede.update_suppression.block.RedstoneInterfaceBlock;
import net.hexcede.update_suppression.block.UpdateSuppressorBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UpdateSuppression implements ModInitializer {
    public static final Logger LOGGER = LogManager.getLogger("UpdateSuppression");

    // Settings
    private static final FabricBlockSettings defaultBlockSettings = FabricBlockSettings.of(Material.STONE).strength(-1.0f);

    // Identifiers
    public static final Identifier UPDATE_SUPPRESSOR_ID = new Identifier("update_suppression", "update_suppressor");
    public static final Identifier REDSTONE_INTERFACE_ID = new Identifier("update_suppression", "redstone_interface");

    // Blocks
    public static final Block UPDATE_SUPPRESSOR_BLOCK = new UpdateSuppressorBlock(defaultBlockSettings);
    public static final Block REDSTONE_INTERFACE_BLOCK = new RedstoneInterfaceBlock(defaultBlockSettings);

    // Item group
    public static final ItemGroup MAIN_GROUP = FabricItemGroupBuilder.create(
            new Identifier("update_suppression", "main"))
            .icon(() -> new ItemStack(Registry.ITEM.get(UPDATE_SUPPRESSOR_ID)))
            .build();

    private static void registerBlock(Identifier identifier, Block block) {
        Registry.register(Registry.BLOCK, identifier, block);
        Registry.register(Registry.ITEM, identifier, new BlockItem(block, new FabricItemSettings().group(MAIN_GROUP)));
    }

    @Override
    public void onInitialize() {
        registerBlock(UPDATE_SUPPRESSOR_ID, UPDATE_SUPPRESSOR_BLOCK);
//        registerBlock(REDSTONE_INTERFACE_ID, REDSTONE_INTERFACE_BLOCK);
    }
}
