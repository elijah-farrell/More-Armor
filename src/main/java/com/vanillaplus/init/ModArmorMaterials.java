package com.vanillaplus.init;

import com.vanillaplus.VanillaPlus;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.util.Lazy;

import java.util.function.Supplier;

public class ModArmorMaterials {
    
    public static final ArmorMaterial GALAXY = new ModArmorMaterial(
            "galaxy",
            25, // durability multiplier
            new int[]{3, 6, 8, 3}, // protection values: boots, leggings, chestplate, helmet
            15, // enchantment value
            SoundEvents.ARMOR_EQUIP_NETHERITE,
            3.0f, // toughness
            0.1f, // knockback resistance
            () -> Ingredient.of(Items.NETHERITE_INGOT)
    );
    
    private static class ModArmorMaterial implements ArmorMaterial {
        private final String name;
        private final int durabilityMultiplier;
        private final int[] protectionAmounts;
        private final int enchantmentValue;
        private final net.minecraft.sounds.SoundEvent equipSound;
        private final float toughness;
        private final float knockbackResistance;
        private final Lazy<Ingredient> repairIngredient;
        
        ModArmorMaterial(String name, int durabilityMultiplier, int[] protectionAmounts, int enchantmentValue, 
                        net.minecraft.sounds.SoundEvent equipSound, float toughness, float knockbackResistance, 
                        Supplier<Ingredient> repairIngredient) {
            this.name = VanillaPlus.MOD_ID + ":" + name;
            this.durabilityMultiplier = durabilityMultiplier;
            this.protectionAmounts = protectionAmounts;
            this.enchantmentValue = enchantmentValue;
            this.equipSound = equipSound;
            this.toughness = toughness;
            this.knockbackResistance = knockbackResistance;
            this.repairIngredient = Lazy.of(repairIngredient);
        }
        
        @Override
        public int getDurabilityForType(ArmorItem.Type type) {
            return switch (type) {
                case BOOTS -> 13 * durabilityMultiplier;
                case LEGGINGS -> 15 * durabilityMultiplier;
                case CHESTPLATE -> 16 * durabilityMultiplier;
                case HELMET -> 11 * durabilityMultiplier;
            };
        }
        
        @Override
        public int getDefenseForType(ArmorItem.Type type) {
            return protectionAmounts[type.ordinal()];
        }
        
        @Override
        public int getEnchantmentValue() {
            return enchantmentValue;
        }
        
        @Override
        public net.minecraft.sounds.SoundEvent getEquipSound() {
            return equipSound;
        }
        
        @Override
        public Ingredient getRepairIngredient() {
            return repairIngredient.get();
        }
        
        @Override
        public String getName() {
            return name;
        }
        
        @Override
        public float getToughness() {
            return toughness;
        }
        
        @Override
        public float getKnockbackResistance() {
            return knockbackResistance;
        }
    }
} 