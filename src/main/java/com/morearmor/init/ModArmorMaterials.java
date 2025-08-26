package com.morearmor.init;

import com.morearmor.MoreArmor;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.util.Lazy;

import javax.annotation.Nonnull;
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
            () -> Ingredient.of(Items.NETHER_STAR)
    );
    
    public static final ArmorMaterial AMETHYST = new ModArmorMaterial(
            "amethyst",
            20, // durability multiplier
            new int[]{2, 5, 7, 2}, // protection values: boots, leggings, chestplate, helmet
            12, // enchantment value
            SoundEvents.ARMOR_EQUIP_DIAMOND,
            2.0f, // toughness
            0.0f, // knockback resistance
            () -> Ingredient.of(Items.AMETHYST_SHARD)
    );
    
    public static final ArmorMaterial ANCIENT_DEBRIS = new ModArmorMaterial(
            "ancient_debris",
            25, // durability multiplier
            new int[]{3, 6, 8, 3}, // protection values
            15, // enchantment value
            SoundEvents.ARMOR_EQUIP_NETHERITE,
            3.0f, // toughness
            0.1f, // knockback resistance
            () -> Ingredient.of(Items.ANCIENT_DEBRIS)
    );
    
    public static final ArmorMaterial BEDROCK = new ModArmorMaterial(
            "bedrock",
            40, // durability multiplier (higher than Netherite's 37)
            new int[]{4, 7, 9, 4}, // protection values (same as Netherite)
            20, // enchantment value (higher than Netherite's 15)
            SoundEvents.ARMOR_EQUIP_NETHERITE,
            4.0f, // toughness (same as Netherite)
            0.2f, // knockback resistance (same as Netherite)
            () -> Ingredient.of(Items.BEDROCK)
    );
    
    public static final ArmorMaterial BEE = new ModArmorMaterial(
            "bee",
            15, // durability multiplier
            new int[]{2, 4, 6, 2}, // protection values
            10, // enchantment value
            SoundEvents.BEE_LOOP,
            1.0f, // toughness
            0.0f, // knockback resistance
            () -> Ingredient.of(Items.HONEYCOMB)
    );
    
    public static final ArmorMaterial BONE = new ModArmorMaterial(
            "bone",
            15, // durability multiplier
            new int[]{2, 4, 6, 2}, // protection values
            10, // enchantment value
            SoundEvents.SKELETON_AMBIENT,
            1.0f, // toughness
            0.0f, // knockback resistance
            () -> Ingredient.of(Items.BONE)
    );
    
    public static final ArmorMaterial CACTUS = new ModArmorMaterial(
            "cactus",
            12, // durability multiplier (increased from 10)
            new int[]{2, 4, 6, 2}, // protection values (increased from 1,3,5,1)
            10, // enchantment value (increased from 8)
            SoundEvents.ARMOR_EQUIP_LEATHER,
            0.8f, // toughness (increased from 0.5)
            0.0f, // knockback resistance
            () -> Ingredient.of(Items.CACTUS)
    );
    
    public static final ArmorMaterial COAL = new ModArmorMaterial(
            "coal",
            12, // durability multiplier
            new int[]{2, 4, 6, 2}, // protection values
            9, // enchantment value
            SoundEvents.ARMOR_EQUIP_IRON,
            0.8f, // toughness
            0.0f, // knockback resistance
            () -> Ingredient.of(Items.COAL)
    );
    
    public static final ArmorMaterial COPPER = new ModArmorMaterial(
            "copper",
            15, // durability multiplier
            new int[]{2, 5, 7, 2}, // protection values
            10, // enchantment value
            SoundEvents.ARMOR_EQUIP_IRON,
            1.0f, // toughness
            0.0f, // knockback resistance
            () -> Ingredient.of(Items.COPPER_INGOT)
    );
    
    public static final ArmorMaterial CRAFTING = new ModArmorMaterial(
            "crafting",
            8, // durability multiplier
            new int[]{1, 2, 4, 1}, // protection values
            5, // enchantment value
            SoundEvents.ARMOR_EQUIP_LEATHER,
            0.3f, // toughness
            0.0f, // knockback resistance
            () -> Ingredient.of(Items.CRAFTING_TABLE)
    );
    
    public static final ArmorMaterial DRIPSTONE = new ModArmorMaterial(
            "dripstone",
            18, // durability multiplier
            new int[]{2, 5, 7, 2}, // protection values
            11, // enchantment value
            SoundEvents.ARMOR_EQUIP_IRON,
            1.2f, // toughness
            0.0f, // knockback resistance
            () -> Ingredient.of(Items.DRIPSTONE_BLOCK)
    );
    
    public static final ArmorMaterial EMERALD = new ModArmorMaterial(
            "emerald",
            22, // durability multiplier
            new int[]{3, 6, 8, 3}, // protection values
            14, // enchantment value
            SoundEvents.ARMOR_EQUIP_DIAMOND,
            2.5f, // toughness
            0.1f, // knockback resistance
            () -> Ingredient.of(Items.EMERALD)
    );
    
    public static final ArmorMaterial ENDER_DRAGON = new ModArmorMaterial(
            "ender_dragon",
            41, // durability multiplier (higher than Netherite's 37)
            new int[]{4, 7, 9, 4}, // protection values (same as Netherite)
            20, // enchantment value (higher than Netherite's 15)
            SoundEvents.ENDER_DRAGON_GROWL,
            4.5f, // toughness (higher than Netherite's 4.0)
            0.25f, // knockback resistance (higher than Netherite's 0.2)
            () -> Ingredient.of(Items.DRAGON_EGG)
    );
    
    public static final ArmorMaterial GILDED = new ModArmorMaterial(
            "gilded",
            20, // durability multiplier
            new int[]{3, 6, 8, 3}, // protection values
            12, // enchantment value
            SoundEvents.ARMOR_EQUIP_GOLD,
            2.0f, // toughness
            0.0f, // knockback resistance
            () -> Ingredient.of(Items.GOLD_INGOT)
    );
    
    public static final ArmorMaterial GLASS = new ModArmorMaterial(
            "glass",
            8, // durability multiplier (increased from 5)
            new int[]{1, 3, 4, 1}, // protection values (increased from 1,2,3,1)
            6, // enchantment value (increased from 3)
            SoundEvents.GLASS_BREAK,
            0.2f, // toughness (increased from 0.1)
            0.0f, // knockback resistance
            () -> Ingredient.of(Items.GLASS)
    );
    
    public static final ArmorMaterial GUARDIAN = new ModArmorMaterial(
            "guardian",
            20, // durability multiplier
            new int[]{3, 6, 8, 3}, // protection values
            12, // enchantment value
            SoundEvents.GUARDIAN_AMBIENT,
            2.0f, // toughness
            0.0f, // knockback resistance
            () -> Ingredient.of(Items.PRISMARINE_SHARD)
    );
    
    public static final ArmorMaterial LAPIS = new ModArmorMaterial(
            "lapis",
            16, // durability multiplier
            new int[]{2, 5, 7, 2}, // protection values
            10, // enchantment value
            SoundEvents.ARMOR_EQUIP_IRON,
            1.0f, // toughness
            0.0f, // knockback resistance
            () -> Ingredient.of(Items.LAPIS_LAZULI)
    );
    
    public static final ArmorMaterial MACHINE = new ModArmorMaterial(
            "machine",
            25, // durability multiplier
            new int[]{3, 6, 8, 3}, // protection values
            15, // enchantment value
            SoundEvents.ARMOR_EQUIP_IRON,
            2.5f, // toughness
            0.1f, // knockback resistance
            () -> Ingredient.of(Items.REDSTONE)
    );
    
    public static final ArmorMaterial MAGMA = new ModArmorMaterial(
            "magma",
            18, // durability multiplier
            new int[]{2, 5, 7, 2}, // protection values
            11, // enchantment value
            SoundEvents.LAVA_AMBIENT,
            1.5f, // toughness
            0.0f, // knockback resistance
            () -> Ingredient.of(Items.MAGMA_CREAM)
    );
    
    public static final ArmorMaterial MUSIC = new ModArmorMaterial(
            "music",
            12, // durability multiplier
            new int[]{2, 4, 6, 2}, // protection values
            8, // enchantment value
            SoundEvents.ARMOR_EQUIP_LEATHER,
            0.8f, // toughness
            0.0f, // knockback resistance
            () -> Ingredient.of(Items.NOTE_BLOCK)
    );
    
    public static final ArmorMaterial OBSIDIAN = new ModArmorMaterial(
            "obsidian",
            38, // durability multiplier (slightly higher than Netherite's 37)
            new int[]{4, 7, 9, 4}, // protection values (same as Netherite)
            18, // enchantment value (higher than Netherite's 15)
            SoundEvents.ARMOR_EQUIP_NETHERITE,
            4.0f, // toughness (same as Netherite)
            0.2f, // knockback resistance (same as Netherite)
            () -> Ingredient.of(Items.OBSIDIAN)
    );
    
    public static final ArmorMaterial POT = new ModArmorMaterial(
            "pot",
            8, // durability multiplier
            new int[]{1, 2, 4, 1}, // protection values
            5, // enchantment value
            SoundEvents.DECORATED_POT_PLACE,
            0.3f, // toughness
            0.0f, // knockback resistance
            () -> Ingredient.of(Items.FLOWER_POT)
    );
    
    public static final ArmorMaterial POWER_SUIT = new ModArmorMaterial(
            "power_suit",
            39, // durability multiplier (higher than Netherite's 37)
            new int[]{4, 7, 9, 4}, // protection values (same as Netherite)
            19, // enchantment value (higher than Netherite's 15)
            SoundEvents.ARMOR_EQUIP_NETHERITE,
            4.0f, // toughness (same as Netherite)
            0.2f, // knockback resistance (same as Netherite)
            () -> Ingredient.of(Items.REDSTONE)
    );
    
    public static final ArmorMaterial QUARTZ = new ModArmorMaterial(
            "quartz",
            18, // durability multiplier
            new int[]{2, 5, 7, 2}, // protection values
            11, // enchantment value
            SoundEvents.ARMOR_EQUIP_IRON,
            1.2f, // toughness
            0.0f, // knockback resistance
            () -> Ingredient.of(Items.QUARTZ)
    );
    
    public static final ArmorMaterial RED_DRAGON = new ModArmorMaterial(
            "red_dragon",
            40, // durability multiplier (higher than Netherite's 37)
            new int[]{4, 7, 9, 4}, // protection values (same as Netherite)
            19, // enchantment value (higher than Netherite's 15)
            SoundEvents.BLAZE_AMBIENT,
            4.2f, // toughness (higher than Netherite's 4.0)
            0.22f, // knockback resistance (higher than Netherite's 0.2)
            () -> Ingredient.of(Items.BLAZE_POWDER)
    );
    
    public static final ArmorMaterial REDSTONE = new ModArmorMaterial(
            "redstone",
            16, // durability multiplier
            new int[]{2, 5, 7, 2}, // protection values
            10, // enchantment value
            SoundEvents.ARMOR_EQUIP_IRON,
            1.0f, // toughness
            0.0f, // knockback resistance
            () -> Ingredient.of(Items.REDSTONE)
    );
    
    public static final ArmorMaterial REINFORCED_DEEPSLATE = new ModArmorMaterial(
            "reinforced_deepslate",
            25, // durability multiplier
            new int[]{3, 6, 8, 3}, // protection values
            15, // enchantment value
            SoundEvents.ARMOR_EQUIP_IRON,
            2.5f, // toughness
            0.1f, // knockback resistance
            () -> Ingredient.of(Items.DEEPSLATE)
    );
    
    public static final ArmorMaterial RGB = new ModArmorMaterial(
            "rgb",
            20, // durability multiplier
            new int[]{3, 6, 8, 3}, // protection values
            12, // enchantment value
            SoundEvents.ARMOR_EQUIP_IRON,
            2.0f, // toughness 
            0.0f, // knockback resistance
            () -> Ingredient.of(Items.WHITE_DYE)
    );
    
    public static final ArmorMaterial RUBY = new ModArmorMaterial(
            "ruby",
            24, // durability multiplier
            new int[]{3, 6, 8, 3}, // protection values
            16, // enchantment value
            SoundEvents.ARMOR_EQUIP_DIAMOND,
            3.0f, // toughness
            0.1f, // knockback resistance
            () -> Ingredient.of(Items.REDSTONE)
    );
    
    public static final ArmorMaterial SCULK = new ModArmorMaterial(
            "sculk",
            20, // durability multiplier
            new int[]{3, 6, 8, 3}, // protection values
            12, // enchantment value
            SoundEvents.SCULK_BLOCK_PLACE,
            2.0f, // toughness
            0.0f, // knockback resistance
            () -> Ingredient.of(Items.SCULK)
    );
    
    public static final ArmorMaterial SHULKER = new ModArmorMaterial(
            "shulker",
            22, // durability multiplier
            new int[]{3, 6, 8, 3}, // protection values
            13, // enchantment value
            SoundEvents.SHULKER_AMBIENT,
            2.2f, // toughness
            0.0f, // knockback resistance
            () -> Ingredient.of(Items.SHULKER_SHELL)
    );
    
    public static final ArmorMaterial SKELETON = new ModArmorMaterial(
            "skeleton",
            15, // durability multiplier
            new int[]{2, 4, 6, 2}, // protection values
            10, // enchantment value
            SoundEvents.SKELETON_AMBIENT,
            1.0f, // toughness
            0.0f, // knockback resistance
            () -> Ingredient.of(Items.BONE)
    );
    
    public static final ArmorMaterial SNIFFER = new ModArmorMaterial(
            "sniffer",
            18, // durability multiplier
            new int[]{2, 5, 7, 2}, // protection values
            11, // enchantment value
            SoundEvents.ARMOR_EQUIP_IRON,
            1.2f, // toughness
            0.0f, // knockback resistance
            () -> Ingredient.of(Items.SNIFFER_EGG)
    );
    
    public static final ArmorMaterial TNT = new ModArmorMaterial(
            "tnt",
            14, // durability multiplier (increased from 10)
            new int[]{2, 4, 6, 2}, // protection values (increased from 1,3,5,1)
            9, // enchantment value (increased from 6)
            SoundEvents.TNT_PRIMED,
            0.7f, // toughness (increased from 0.5)
            0.0f, // knockback resistance
            () -> Ingredient.of(Items.TNT)
    );
    
    public static final ArmorMaterial TOTEM = new ModArmorMaterial(
            "totem",
            25, // durability multiplier
            new int[]{3, 6, 8, 3}, // protection values
            15, // enchantment value
            SoundEvents.TOTEM_USE,
            2.5f, // toughness
            0.1f, // knockback resistance
            () -> Ingredient.of(Items.TOTEM_OF_UNDYING)
    );
    
    public static final ArmorMaterial WITHER_SKELETON = new ModArmorMaterial(
            "wither_skeleton",
            20, // durability multiplier
            new int[]{3, 6, 8, 3}, // protection values
            12, // enchantment value
            SoundEvents.WITHER_SKELETON_AMBIENT,
            2.0f, // toughness
            0.0f, // knockback resistance
            () -> Ingredient.of(Items.WITHER_SKELETON_SKULL)
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
            this.name = MoreArmor.MOD_ID + ":" + name;
            this.durabilityMultiplier = durabilityMultiplier;
            this.protectionAmounts = protectionAmounts;
            this.enchantmentValue = enchantmentValue;
            this.equipSound = equipSound;
            this.toughness = toughness;
            this.knockbackResistance = knockbackResistance;
            this.repairIngredient = Lazy.of(repairIngredient);
        }
        
        @Override
        public int getDurabilityForType(@Nonnull ArmorItem.Type type) {
            return switch (type) {
                case BOOTS -> 13 * durabilityMultiplier;
                case LEGGINGS -> 15 * durabilityMultiplier;
                case CHESTPLATE -> 16 * durabilityMultiplier;
                case HELMET -> 11 * durabilityMultiplier;
            };
        }
        
        @Override
        public int getDefenseForType(@Nonnull ArmorItem.Type type) {
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