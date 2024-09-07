package org.axolotlagatsuma.axosarmors;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItems {
    public static Item register(Item item, String id) {
        // Create identifier for the item
        Identifier itemID = Identifier.of(axosarmors.MOD_ID, id);

        // Register the item
        Item registeredItem = Registry.register(Registries.ITEM, itemID, item);

        // Return the registered item
        return registeredItem;
    }

    public static final Item Poopoo = register(
      new Item(new Item.Settings()),
      "poopoo");

    public static final Item AxolotlFins = register(
      new Item(new Item.Settings()),
      "axolotl_fins"
    );

    public static final Item AxolotlSkin = register(
            new Item(new Item.Settings()),
            "axolotl_skin"
    );

    public static final Item AxolotlFlesh = register(
            new Item(new Item.Settings()),
            "axolotl_flesh"
    );

    public static final Item AxolotlInfusedNetheriteAxe = register(
            new AxeItem(axolotlInfusedTools.INSTANCE, 3.0F, -3.0F, new Item.Settings()),
            "axolotl_infused_axe");

    public static final Item AxolotlInfusedNetheriteHelmet = register(new ArmorItem(ModArmorMaterials.AXOLOTL_INFUSED, ArmorItem.Type.HELMET, new Item.Settings().maxDamage(ArmorItem.Type.HELMET.getMaxDamage(ModArmorMaterials.AXOLOTL_INFUSED_ARMOR_DURABILITY))), "axolotl_infused_helmet");

    public static void initialize() {
        // Add the Axolotl Fin Item to the Ingredients Item Group aka. Creative Tab
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS)
                .register((itemGroup) -> itemGroup.add(ModItems.AxolotlFins));
        // Add the Axolotl Skin Item to the Ingredients Item Group aka. Creative Tab
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS)
                .register((itemGroup) -> itemGroup.add(ModItems.AxolotlSkin));
        // Add the Poopoo Item to the Ingredients Item Group aka. Creative Tab
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS)
                .register((itemGroup) -> itemGroup.add(ModItems.Poopoo));
        // Add the Axolotl Flesh Item to the Food and Drink Item Group aka. Creative Tab
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK)
                .register((itemGroup) -> itemGroup.add(ModItems.AxolotlFlesh));
        // Add the Axolotl Infused Axe Item to the Tools Item Group aka. Creative Tab
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS)
                .register((itemGroup) -> itemGroup.add(ModItems.AxolotlInfusedNetheriteAxe));
        // Make Poopoo a fuel
        FuelRegistry.INSTANCE.add(ModItems.Poopoo, 30 * 20);
    }

    public static final FoodComponent REGEN_FOOD_COMPONENT = new FoodComponent.Builder()
            .hunger(4)
            .saturationModifier(0.5f)
            .alwaysEdible()
            .snack()
            // The duration is in ticks, 20 ticks = 1 second
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 6 * 20, 1), 1.0f)
            .build();

//     @Override
//    public void appendTooltip(ItemStack stack, TooltipContext context, List<test> tooltip, TooltipType type) {
//        tooltip.add(Text.translatable("itemTooltip.first.axolotl_fins").formatted(Formatting.GRAY));
//    }
}


