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
            30, // durability multiplier
            new int[]{4, 7, 9, 4}, // protection values
            20, // enchantment value
            SoundEvents.ARMOR_EQUIP_NETHERITE,
            4.0f, // toughness
            0.2f, // knockback resistance
            () -> Ingredient.of(Items.BEDROCK)
    );
    
    public static final ArmorMaterial BEE = new ModArmorMaterial(
            "bee",
            15, // durability multiplier
            new int[]{2, 4, 6, 2}, // protection values
            10, // enchantment value
            SoundEvents.ARMOR_EQUIP_IRON,
            1.0f, // toughness
            0.0f, // knockback resistance
            () -> Ingredient.of(Items.HONEYCOMB)
    );
    
    public static final ArmorMaterial BONE = new ModArmorMaterial(
            "bone",
            15, // durability multiplier
            new int[]{2, 4, 6, 2}, // protection values
            10, // enchantment value
            SoundEvents.ARMOR_EQUIP_IRON,
            1.0f, // toughness
            0.0f, // knockback resistance
            () -> Ingredient.of(Items.BONE)
    );
    
    public static final ArmorMaterial CACTUS = new ModArmorMaterial(
            "cactus",
            10, // durability multiplier
            new int[]{1, 3, 5, 1}, // protection values
            8, // enchantment value
            SoundEvents.ARMOR_EQUIP_LEATHER,
            0.5f, // toughness
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
            28, // durability multiplier
            new int[]{4, 7, 9, 4}, // protection values
            18, // enchantment value
            SoundEvents.ARMOR_EQUIP_NETHERITE,
            3.5f, // toughness
            0.15f, // knockback resistance
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
            5, // durability multiplier
            new int[]{1, 2, 3, 1}, // protection values
            3, // enchantment value
            SoundEvents.ARMOR_EQUIP_LEATHER,
            0.1f, // toughness
            0.0f, // knockback resistance
            () -> Ingredient.of(Items.GLASS)
    );
    
    public static final ArmorMaterial GUARDIAN = new ModArmorMaterial(
            "guardian",
            20, // durability multiplier
            new int[]{3, 6, 8, 3}, // protection values
            12, // enchantment value
            SoundEvents.ARMOR_EQUIP_IRON,
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
            SoundEvents.ARMOR_EQUIP_IRON,
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
            30, // durability multiplier
            new int[]{4, 7, 9, 4}, // protection values
            20, // enchantment value
            SoundEvents.ARMOR_EQUIP_NETHERITE,
            4.0f, // toughness
            0.2f, // knockback resistance
            () -> Ingredient.of(Items.OBSIDIAN)
    );
    
    public static final ArmorMaterial POT = new ModArmorMaterial(
            "pot",
            8, // durability multiplier
            new int[]{1, 2, 4, 1}, // protection values
            5, // enchantment value
            SoundEvents.ARMOR_EQUIP_LEATHER,
            0.3f, // toughness
            0.0f, // knockback resistance
            () -> Ingredient.of(Items.FLOWER_POT)
    );
    
    public static final ArmorMaterial POWER_SUIT = new ModArmorMaterial(
            "power_suit",
            30, // durability multiplier
            new int[]{4, 7, 9, 4}, // protection values
            20, // enchantment value
            SoundEvents.ARMOR_EQUIP_NETHERITE,
            4.0f, // toughness
            0.2f, // knockback resistance
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
            28, // durability multiplier
            new int[]{4, 7, 9, 4}, // protection values
            18, // enchantment value
            SoundEvents.ARMOR_EQUIP_NETHERITE,
            3.5f, // toughness
            0.15f, // knockback resistance
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
            SoundEvents.ARMOR_EQUIP_IRON,
            2.0f, // toughness
            0.0f, // knockback resistance
            () -> Ingredient.of(Items.SCULK)
    );
    
    public static final ArmorMaterial SHULKER = new ModArmorMaterial(
            "shulker",
            22, // durability multiplier
            new int[]{3, 6, 8, 3}, // protection values
            13, // enchantment value
            SoundEvents.ARMOR_EQUIP_IRON,
            2.2f, // toughness
            0.0f, // knockback resistance
            () -> Ingredient.of(Items.SHULKER_SHELL)
    );
    
    public static final ArmorMaterial SKELETON = new ModArmorMaterial(
            "skeleton",
            15, // durability multiplier
            new int[]{2, 4, 6, 2}, // protection values
            10, // enchantment value
            SoundEvents.ARMOR_EQUIP_IRON,
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
            10, // durability multiplier
            new int[]{1, 3, 5, 1}, // protection values
            6, // enchantment value
            SoundEvents.ARMOR_EQUIP_LEATHER,
            0.5f, // toughness
            0.0f, // knockback resistance
            () -> Ingredient.of(Items.TNT)
    );
    
    public static final ArmorMaterial TOTEM = new ModArmorMaterial(
            "totem",
            25, // durability multiplier
            new int[]{3, 6, 8, 3}, // protection values
            15, // enchantment value
            SoundEvents.ARMOR_EQUIP_DIAMOND,
            2.5f, // toughness
            0.1f, // knockback resistance
            () -> Ingredient.of(Items.TOTEM_OF_UNDYING)
    );
    
    public static final ArmorMaterial WITHER_SKELETON = new ModArmorMaterial(
            "wither_skeleton",
            20, // durability multiplier
            new int[]{3, 6, 8, 3}, // protection values
            12, // enchantment value
            SoundEvents.ARMOR_EQUIP_IRON,
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