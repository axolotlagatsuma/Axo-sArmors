package org.axolotlagatsuma.axosarmors;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class axolotlInfusedNetheriteToolMaterial implements ToolMaterial {
    public static final axolotlInfusedNetheriteToolMaterial INSTANCE = new axolotlInfusedNetheriteToolMaterial();

    @Override
    public int getDurability() {
        return 2532;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 12.0F;
    }

    @Override
    public float getAttackDamage() {
        return 3.0F;
    }

    @Override
    public int getMiningLevel() {
        return 3;
    }

    @Override
    public int getEnchantability() {
        return 15;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(ModItems.FullyAxolotlInfusedNetherite);
    }
}
