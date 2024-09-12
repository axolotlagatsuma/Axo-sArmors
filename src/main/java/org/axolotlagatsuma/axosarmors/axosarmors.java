package org.axolotlagatsuma.axosarmors;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class axosarmors implements ModInitializer {

    public static final String MOD_ID = "axosarmors";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("Axo's Armors mod is initializing!");
        //ModArmorMaterials.initialize();
        ModItems.initialize();
        ModBlocks.initialize();
    }
}
