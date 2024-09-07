package org.axolotlagatsuma.axosarmors;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class axolotlInfusedTools implements ToolMaterial {
    @Override
    public int getDurability() {
        return 2531;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 18.0F;
    }

    @Override
    public float getAttackDamage() {
        return 8.0F;
    }

    @Override
    public int getMiningLevel() {
        return 4;
    }

    @Override
    public int getEnchantability() {
        return 30;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return null;
    }
    public static final axolotlInfusedTools INSTANCE = new axolotlInfusedTools();
}
