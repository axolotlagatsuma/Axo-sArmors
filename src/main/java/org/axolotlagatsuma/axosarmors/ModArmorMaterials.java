package org.axolotlagatsuma.axosarmors;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class ModArmorMaterials {
    public static void initialize() {
    };

    public static final int AXOLOTL_INFUSED_ARMOR_DURABILITY = 15;

    public static RegistryEntry<ArmorMaterial> registerMaterial(String id, Map<ArmorItem.Type, Integer> defensePoints, int enchantability, RegistryEntry<SoundEvent> equipSound, Supplier<Ingredient> repairIngredientSupplier, float toughness, float knockbackResistance, boolean dyeable) {}
        List<ArmorMaterial.Layer> layers = List.of(
        new ArmorMaterial.Layer(Identifier.of(axosarmors.MOD_ID, id), "", dyeable)
        );

    ArmorMaterial material = new ArmorMaterial(defensePoints, enchantability, equipSound, repairIngredientSupplier, toughness, knockbackResistance);

    material = Registry.register(Registries.ARMOR_MATERIAL, Identifier.of(axosarmors.MOD_ID, id), material);

    return RegistryEntry.of(material);

    public static final RegistryEntry<ArmorMaterial> AXOLOTL_INFUSED = registerMaterial("axolotl_infused", Map.of(
        ArmorItem.Type.HELMET, 3
        ArmorItem.Type.CHESTPLATE, 8,
        ArmorItem.Type.LEGGINGS, 6,
        ArmorItem.Type.BOOTS, 3
    ),
    5,
            SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE, // 30, RegistryEntry.of(SoundEvents.ITEM_ARMOR_EQUIP_IRON), () -> Ingredient.ofItems(ModItems.AxolotlSkin), 0.0F, 0.0F, true);
            () -> Ingredient.ofItems(ModItems.AxolotlSkin),
            5.0F,
            5.0F,
            false);
}
