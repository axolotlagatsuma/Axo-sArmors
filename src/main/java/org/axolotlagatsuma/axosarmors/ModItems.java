package org.axolotlagatsuma.axosarmors;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ModItems {
    public static Item register(Item item, String id) {
        // Create identifier for the item
        Identifier itemID = Identifier.of(axosarmors.MOD_ID, id);

        // Register the item
        Item registeredItem = Registry.register(Registries.ITEM, itemID, item);

        // Return the registered item
        return registeredItem;
    }

    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("item.axosarmors.fully_axolotl_infused_netherite.tooltip").formatted(Formatting.DARK_PURPLE));
    }

    public static final RegistryKey<ItemGroup> CUSTOM_ITEM_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), new Identifier(axosarmors.MOD_ID, "item_group"));
    public static final ItemGroup CUSTOM_ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModItems.INFUSED_NETHERITE_CHESTPLATE))
            .displayName(Text.translatable("itemGroup.axosarmors"))
            .build();

    public static final FoodComponent REGEN_FOOD_COMPONENT = new FoodComponent.Builder()
            .hunger(4)
            .saturationModifier(0.5f)
            .alwaysEdible()
            .snack()
            // The duration is in ticks, 20 ticks = 1 second
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 6 * 20, 1), 1.0f)
            .build();

    public static final FoodComponent BAD_FOOD_COMPONENT = new FoodComponent.Builder()
            .hunger(4)
            .saturationModifier(0.5f)
            .alwaysEdible()
            .snack()
            // The duration is in ticks, 20 ticks = 1 second
            .statusEffect(new StatusEffectInstance(StatusEffects.POISON, 6 * 20, 1), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 6 * 20, 1), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 6 * 20, 1), 1.0f)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 6 * 20, 1), 0.02f)
            .build();

    public static final Item FullyAxolotlInfusedNetherite = register(
            new Item(new Item.Settings()),
            "fully_axolotl_infused_netherite"
    );

    public static final Item Poopoo = register(
      new Item(new Item.Settings()),
      "poopoo"
    );

    public static final Item AxolotlFins = register(
      new Item(new Item.Settings()),
      "axolotl_fins"
    );

    public static final Item AxolotlSkin = register(
            new Item(new Item.Settings()),
            "axolotl_skin"
    );

    public static final Item AxolotlFlesh = register(
            new Item(new Item.Settings().food(BAD_FOOD_COMPONENT)),
            "axolotl_flesh"
    );

    public static final Item CookedAxolotlFlesh = register(
            new Item(new Item.Settings().food(REGEN_FOOD_COMPONENT)),
            "cooked_axolotl_flesh"
    );


    public static final Item INFUSED_NETHERITE_HELMET = register(new ArmorItem(InfusedNetheriteArmorMaterial.INSTANCE, ArmorItem.Type.HELMET, new Item.Settings()), "axolotl_infused_netherite_helmet");
    public static final Item INFUSED_NETHERITE_BOOTS = register(new ArmorItem(InfusedNetheriteArmorMaterial.INSTANCE, ArmorItem.Type.BOOTS, new Item.Settings()), "axolotl_infused_netherite_boots");
    public static final Item INFUSED_NETHERITE_LEGGINGS = register(new ArmorItem(InfusedNetheriteArmorMaterial.INSTANCE, ArmorItem.Type.LEGGINGS, new Item.Settings()), "axolotl_infused_netherite_leggings");
    public static final Item INFUSED_NETHERITE_CHESTPLATE = register(new ArmorItem(InfusedNetheriteArmorMaterial.INSTANCE, ArmorItem.Type.CHESTPLATE, new Item.Settings()), "axolotl_infused_netherite_chestplate");


    public static final Item AxolotlInfusedNetheriteAxe = register(
            new AxeItem(axolotlInfusedNetheriteToolMaterial.INSTANCE, 3.0F, -3.0F, new Item.Settings()),
            "axolotl_infused_netherite_axe"
    );


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
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS)
                .register((itemGroup) -> itemGroup.add(ModItems.FullyAxolotlInfusedNetherite));
        // Add the Axolotl Flesh Item to the Food and Drink Item Group aka. Creative Tab
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK)
                .register((itemGroup) -> itemGroup.add(ModItems.AxolotlFlesh));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK)
                .register((itemGroup) -> itemGroup.add(ModItems.CookedAxolotlFlesh));
        // Add the Axolotl Infused Axe Item to the Tools Item Group aka. Creative Tab
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS)
               .register((itemGroup) -> itemGroup.add(ModItems.AxolotlInfusedNetheriteAxe));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT)
                .register((itemGroup) -> {
                    itemGroup.add(ModItems.INFUSED_NETHERITE_HELMET);
                    itemGroup.add(ModItems.INFUSED_NETHERITE_CHESTPLATE);
                    itemGroup.add(ModItems.INFUSED_NETHERITE_LEGGINGS);
                    itemGroup.add(ModItems.INFUSED_NETHERITE_BOOTS);
                });
        // Register the group.
        Registry.register(Registries.ITEM_GROUP, CUSTOM_ITEM_GROUP_KEY, CUSTOM_ITEM_GROUP);

// Register items to the custom item group.
        ItemGroupEvents.modifyEntriesEvent(CUSTOM_ITEM_GROUP_KEY).register(itemGroup -> {
            itemGroup.add(ModItems.FullyAxolotlInfusedNetherite);
            itemGroup.add(ModItems.AxolotlInfusedNetheriteAxe);
            itemGroup.add(ModItems.INFUSED_NETHERITE_HELMET);
            itemGroup.add(ModItems.INFUSED_NETHERITE_CHESTPLATE);
            itemGroup.add(ModItems.INFUSED_NETHERITE_LEGGINGS);
            itemGroup.add(ModItems.INFUSED_NETHERITE_BOOTS);
            itemGroup.add(ModItems.AxolotlFlesh);
            itemGroup.add(ModItems.CookedAxolotlFlesh);
            itemGroup.add(ModItems.AxolotlFins);
            itemGroup.add(ModItems.AxolotlSkin);
            // ...
        });
        // Make Poopoo a fuel
        FuelRegistry.INSTANCE.add(ModItems.Poopoo, 30 * 20);
    }
}


