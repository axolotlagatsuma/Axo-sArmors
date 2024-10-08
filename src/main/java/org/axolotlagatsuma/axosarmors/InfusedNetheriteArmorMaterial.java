package org.axolotlagatsuma.axosarmors;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

public class InfusedNetheriteArmorMaterial implements ArmorMaterial {

    public static final InfusedNetheriteArmorMaterial INSTANCE = new InfusedNetheriteArmorMaterial();

    @Override
    public int getDurability(ArmorItem.Type type) {
        // Replace this multiplier by a constant value for the durability of the armor.
        // For reference, diamond uses 33 for all armor pieces, whilst leather uses 5.
        int DURABILITY_MULTIPLIER = 40;
        return switch (type) {
            case BOOTS -> 13 * DURABILITY_MULTIPLIER;
            case LEGGINGS -> 15 * DURABILITY_MULTIPLIER;
            case CHESTPLATE -> 16 * DURABILITY_MULTIPLIER;
            case HELMET -> 11 * DURABILITY_MULTIPLIER;
            default -> 0;
        };
    }

    @Override
    public int getProtection(ArmorItem.Type type) {
        // Protection values for all the slots.
        // For reference, diamond uses 3 for boots, 6 for leggings, 8 for chestplate, and 3 for helmet,
        // whilst leather uses 1, 2, 3 and 1 respectively.
        return switch (type) {
            case BOOTS, HELMET -> 4;
            case LEGGINGS -> 7;
            case CHESTPLATE -> 9;
            default -> 0;
        };
    }

    @Override
    public int getEnchantability() {
        return 30;
    }

    @Override
    public SoundEvent getEquipSound() {
        // Example for Iron Armor
        return SoundEvents.ITEM_ARMOR_EQUIP_IRON;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(ModItems.FullyAxolotlInfusedNetherite);
    }

    @Override
    public String getName() {
        return "fully_axolotl_infused_netherite";
    }

    @Override
    public float getToughness() {
        return 5.0F;
    }

    @Override
    public float getKnockbackResistance() {
        return 0.5F;
    }
}
