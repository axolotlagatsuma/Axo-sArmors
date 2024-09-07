package org.axolotlagatsuma.axosarmors;

import net.fabricmc.api.ModInitializer;
import org.axolotlagatsuma.axosarmors.ModItems;
import org.axolotlagatsuma.axosarmors.ModArmorMaterials;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class axosarmors implements ModInitializer {

    public static final String MOD_ID = "axosarmors";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("Axolotl s Mod is initializing!");
        ModItems.initialize();
//        ModItems.appendTooltip();
        ModArmorMaterials.initialize();
    }
}
