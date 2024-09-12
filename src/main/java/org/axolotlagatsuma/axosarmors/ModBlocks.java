package org.axolotlagatsuma.axosarmors;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static Block register(Block block, String name, boolean shouldRegisterItem) {
        // Register the block and its item.
        Identifier id = new Identifier(axosarmors.MOD_ID, name);

        if (shouldRegisterItem) {
            BlockItem blockItem = new BlockItem(block, new Item.Settings());
            Registry.register(Registries.ITEM, id, blockItem);
        }

        return Registry.register(Registries.BLOCK, id, block);

    }

    public static final Block AXOLOTL_INFUSED_NETHERITE_BLOCK = register(
            new Block(
                    AbstractBlock.Settings.create()
                            .sounds(BlockSoundGroup.NETHERITE)
            ), "axolotl_infused_netherite_block", true
    );

    static {
        ItemGroupEvents.modifyEntriesEvent(ModItems.CUSTOM_ITEM_GROUP_KEY).register((itemGroup) -> {
            itemGroup.add(ModBlocks.AXOLOTL_INFUSED_NETHERITE_BLOCK.asItem());
        });
    }

    public static void initialize() {
    }
}
