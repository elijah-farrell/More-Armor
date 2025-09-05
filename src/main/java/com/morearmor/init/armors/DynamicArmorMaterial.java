package com.morearmor.init.armors;

import com.morearmor.MoreArmor;
import com.morearmor.config.ModConfigs;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import javax.annotation.Nonnull;

public class DynamicArmorMaterial implements ArmorMaterial {
    private final String name;

    public DynamicArmorMaterial(String name) {
        this.name = name;
    }

    private String getNameClean() {
        // If the name already contains the mod ID prefix, remove it
        if (name.startsWith(MoreArmor.MOD_ID + ":")) {
            return name.replace(MoreArmor.MOD_ID + ":", "");
        }
        // Otherwise, just return the name as is
        return name;
    }

    @Override
    public int getDurabilityForType(@Nonnull ArmorItem.Type type) {
        String cleanName = getNameClean();
        int durability = ModConfigs.getDurability(cleanName, type);
        return durability;
    }

    @Override
    public int getDefenseForType(@Nonnull ArmorItem.Type type) {
        String cleanName = getNameClean();
        int protection = ModConfigs.getProtection(cleanName, type);
        return protection;
    }

    @Override
    public int getEnchantmentValue() {
        return ModConfigs.getEnchantment(getNameClean());
    }

    @Override
    public float getToughness() {
        String cleanName = getNameClean();
        float toughness = ModConfigs.getToughnessValue(cleanName);
        return toughness;
    }

    @Override
    public float getKnockbackResistance() {
        String cleanName = getNameClean();
        float knockbackResistance = ModConfigs.getKnockbackResistanceValue(cleanName);
        return knockbackResistance;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public SoundEvent getEquipSound() {
        return SoundEvents.ARMOR_EQUIP_GENERIC;
    }

    @Override
    public Ingredient getRepairIngredient() {
        // For now, return empty ingredient. This could be made configurable later
        return Ingredient.EMPTY;
    }
}
