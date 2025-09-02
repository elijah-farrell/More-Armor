package com.morearmor.config;

import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;

/**
 * Centralized default values for all armor types.
 * This is the single source of truth for armor statistics.
 * Both ModConfigs and ArmorConfigLoader should reference these values.
 */
public class ArmorDefaults {
    
    /**
     * Armor statistics for a specific armor type
     */
    public static class ArmorStats {
        public final int helmetDurability, chestplateDurability, leggingsDurability, bootsDurability;
        public final int helmetProtection, chestplateProtection, leggingsProtection, bootsProtection;
        public final int enchantment;
        public final float toughness, knockbackResistance;
        public final Item repairItem;
        public final SoundEvent equipSound;
        
        public ArmorStats(int helmetDurability, int chestplateDurability, int leggingsDurability, int bootsDurability,
                         int helmetProtection, int chestplateProtection, int leggingsProtection, int bootsProtection,
                         int enchantment, float toughness, float knockbackResistance, Item repairItem, SoundEvent equipSound) {
            this.helmetDurability = helmetDurability;
            this.chestplateDurability = chestplateDurability;
            this.leggingsDurability = leggingsDurability;
            this.bootsDurability = bootsDurability;
            this.helmetProtection = helmetProtection;
            this.chestplateProtection = chestplateProtection;
            this.leggingsProtection = leggingsProtection;
            this.bootsProtection = bootsProtection;
            this.enchantment = enchantment;
            this.toughness = toughness;
            this.knockbackResistance = knockbackResistance;
            this.repairItem = repairItem;
            this.equipSound = equipSound;
        }
        
        public int getDurability(ArmorItem.Type type) {
            return switch (type) {
                case HELMET -> helmetDurability;
                case CHESTPLATE -> chestplateDurability;
                case LEGGINGS -> leggingsDurability;
                case BOOTS -> bootsDurability;
            };
        }
        
        public int getProtection(ArmorItem.Type type) {
            return switch (type) {
                case HELMET -> helmetProtection;
                case CHESTPLATE -> chestplateProtection;
                case LEGGINGS -> leggingsProtection;
                case BOOTS -> bootsProtection;
            };
        }
    }
    
    // Amethyst Armor
    public static final ArmorStats AMETHYST = new ArmorStats(
        193, 280, 263, 228,  // durability
        2, 5, 4, 1,          // protection
        15,                  // enchantment
        0.5f, 0.0f,          // toughness, knockback resistance
        Items.AMETHYST_SHARD, // repair item
        SoundEvents.ARMOR_EQUIP_GENERIC // equip sound
    );
    
    // Ancient Debris Armor
    public static final ArmorStats ANCIENT_DEBRIS = new ArmorStats(
        448, 651, 610, 529,  // durability
        3, 8, 6, 3,          // protection
        19,                  // enchantment
        3.0f, 0.1f,          // toughness, knockback resistance
        Items.ANCIENT_DEBRIS, // repair item
        SoundEvents.ARMOR_EQUIP_NETHERITE // equip sound
    );
    
    // Bedrock Armor
    public static final ArmorStats BEDROCK = new ArmorStats(
        1100, 1600, 1500, 1300, // durability
        2, 6, 5, 2,              // protection
        20,                      // enchantment
        0.0f, 0.2f,              // toughness, knockback resistance
        Items.BEDROCK,            // repair item
        SoundEvents.ARMOR_EQUIP_GENERIC // equip sound
    );
    
    // Bee Armor
    public static final ArmorStats BEE = new ArmorStats(
        77, 112, 105, 91,    // durability
        1, 3, 2, 1,          // protection
        10,                  // enchantment
        0.0f, 0.0f,          // toughness, knockback resistance
        Items.HONEYCOMB,      // repair item
        SoundEvents.ARMOR_EQUIP_GENERIC // equip sound
    );
    
    // Bone Armor
    public static final ArmorStats BONE = new ArmorStats(
        132, 192, 180, 156,  // durability
        2, 4, 3, 2,          // protection
        11,                  // enchantment
        0.6f, 0.0f,          // toughness, knockback resistance
        Items.BONE,           // repair item
        SoundEvents.ARMOR_EQUIP_GENERIC // equip sound
    );
    
    // Cactus Armor
    public static final ArmorStats CACTUS = new ArmorStats(
        55, 80, 75, 65,      // durability
        1, 2, 2, 1,          // protection
        10,                  // enchantment
        0.0f, 0.0f,          // toughness, knockback resistance
        Items.CACTUS,         // repair item
        SoundEvents.ARMOR_EQUIP_GENERIC // equip sound
    );
    
    // Coal Armor
    public static final ArmorStats COAL = new ArmorStats(
        99, 144, 135, 117,   // durability
        1, 2, 2, 1,          // protection
        10,                  // enchantment
        0.0f, 0.0f,          // toughness, knockback resistance
        Items.COAL,           // repair item
        SoundEvents.ARMOR_EQUIP_GENERIC // equip sound
    );
    
    // Copper Armor
    public static final ArmorStats COPPER = new ArmorStats(
        121, 176, 165, 143,  // durability
        2, 4, 3, 1,          // protection
        8,                   // enchantment
        0.0f, 0.0f,          // toughness, knockback resistance
        Items.COPPER_INGOT,   // repair item
        SoundEvents.ARMOR_EQUIP_GENERIC // equip sound
    );
    
    // Crafting Armor
    public static final ArmorStats CRAFTING = new ArmorStats(
        55, 80, 75, 65,      // durability
        1, 2, 2, 1,          // protection
        12,                  // enchantment
        0.0f, 0.0f,          // toughness, knockback resistance
        Items.CRAFTING_TABLE, // repair item
        SoundEvents.ARMOR_EQUIP_GENERIC // equip sound
    );
    
    // Dripstone Armor
    public static final ArmorStats DRIPSTONE = new ArmorStats(
        33, 48, 45, 39,      // durability
        1, 1, 1, 1,          // protection
        13,                  // enchantment
        0.0f, 0.0f,          // toughness, knockback resistance
        Items.DRIPSTONE_BLOCK, // repair item
        SoundEvents.ARMOR_EQUIP_GENERIC // equip sound
    );
    
    // Emerald Armor
    public static final ArmorStats EMERALD = new ArmorStats(
        255, 372, 318, 302,  // durability
        2, 8, 3, 2,          // protection
        17,                  // enchantment
        0.0f, 0.0f,          // toughness, knockback resistance
        Items.EMERALD,        // repair item
        SoundEvents.ARMOR_EQUIP_GENERIC // equip sound
    );
    
    // Ender Dragon Armor
    public static final ArmorStats ENDER_DRAGON = new ArmorStats(
        580, 850, 800, 690,  // durability
        4, 8, 6, 3,          // protection
        20,                  // enchantment
        3.0f, 0.1f,          // toughness, knockback resistance
        Items.DRAGON_EGG,     // repair item
        SoundEvents.ARMOR_EQUIP_GENERIC // equip sound
    );
    
    // Galaxy Armor
    public static final ArmorStats GALAXY = new ArmorStats(
        610, 888, 832, 721,  // durability
        4, 8, 6, 4,          // protection
        19,                  // enchantment
        3.0f, 0.1f,          // toughness, knockback resistance
        Items.NETHERITE_INGOT, // repair item
        SoundEvents.ARMOR_EQUIP_GENERIC // equip sound
    );
    
    // Gilded Armor
    public static final ArmorStats GILDED = new ArmorStats(
        260, 336, 315, 273,  // durability
        3, 6, 5, 3,          // protection
        15,                  // enchantment
        0.0f, 0.0f,          // toughness, knockback resistance
        Items.GOLD_INGOT,     // repair item
        SoundEvents.ARMOR_EQUIP_GOLD // equip sound
    );
    
    // Glass Armor
    public static final ArmorStats GLASS = new ArmorStats(
        27, 40, 37, 32,      // durability
        0, 0, 0, 0,          // protection
        6,                   // enchantment
        0.0f, 0.0f,          // toughness, knockback resistance
        Items.GLASS,          // repair item
        SoundEvents.ARMOR_EQUIP_GENERIC // equip sound
    );
    
    // Guardian Armor
    public static final ArmorStats GUARDIAN = new ArmorStats(
        247, 320, 300, 260,  // durability
        3, 6, 5, 3,          // protection
        15,                  // enchantment
        0.0f, 0.0f,          // toughness, knockback resistance
        Items.PRISMARINE_SHARD, // repair item
        SoundEvents.ARMOR_EQUIP_GENERIC // equip sound
    );
    
    // Lapis Armor
    public static final ArmorStats LAPIS = new ArmorStats(
        165, 240, 225, 195,  // durability
        1, 3, 3, 1,          // protection
        18,                  // enchantment
        0.0f, 0.0f,          // toughness, knockback resistance
        Items.LAPIS_LAZULI,   // repair item
        SoundEvents.ARMOR_EQUIP_GENERIC // equip sound
    );
    
    // Machine Armor
    public static final ArmorStats MACHINE = new ArmorStats(
        176, 256, 240, 208,  // durability
        2, 6, 5, 2,          // protection
        19,                  // enchantment
        0.0f, 0.1f,          // toughness, knockback resistance
        Items.REDSTONE,       // repair item
        SoundEvents.ARMOR_EQUIP_IRON // equip sound
    );
    
    // Magma Armor
    public static final ArmorStats MAGMA = new ArmorStats(
        165, 240, 225, 195,  // durability
        2, 5, 4, 1,          // protection
        14,                  // enchantment
        0.0f, 0.0f,          // toughness, knockback resistance
        Items.MAGMA_BLOCK,    // repair item
        SoundEvents.ARMOR_EQUIP_GENERIC // equip sound
    );
    
    // Music Armor
    public static final ArmorStats MUSIC = new ArmorStats(
        55, 80, 75, 65,      // durability
        1, 3, 3, 1,          // protection
        12,                  // enchantment
        0.0f, 0.0f,          // toughness, knockback resistance
        Items.NOTE_BLOCK,     // repair item
        SoundEvents.ARMOR_EQUIP_GENERIC // equip sound
    );
    
    // Obsidian Armor
    public static final ArmorStats OBSIDIAN = new ArmorStats(
        363, 528, 495, 429,  // durability
        3, 7, 6, 2,          // protection
        18,                  // enchantment
        1.0f, 0.0f,          // toughness, knockback resistance
        Items.OBSIDIAN,       // repair item
        SoundEvents.ARMOR_EQUIP_GENERIC // equip sound
    );
    
    // Pot Armor
    public static final ArmorStats POT = new ArmorStats(
        55, 80, 75, 65,      // durability
        1, 3, 3, 1,          // protection
        12,                  // enchantment
        0.0f, 0.0f,          // toughness, knockback resistance
        Items.FLOWER_POT,     // repair item
        SoundEvents.ARMOR_EQUIP_GENERIC // equip sound
    );
    
    // Power Suit Armor
    public static final ArmorStats POWER_SUIT = new ArmorStats(
        508, 740, 693, 601,  // durability
        3, 8, 6, 3,          // protection
        19,                  // enchantment
        3.0f, 0.1f,          // toughness, knockback resistance
        Items.REDSTONE,       // repair item
        SoundEvents.ARMOR_EQUIP_IRON // equip sound
    );
    
    // Quartz Armor
    public static final ArmorStats QUARTZ = new ArmorStats(
        165, 240, 225, 195,  // durability
        2, 2, 2, 2,          // protection
        13,                  // enchantment
        0.0f, 0.0f,          // toughness, knockback resistance
        Items.QUARTZ,         // repair item
        SoundEvents.ARMOR_EQUIP_GENERIC // equip sound
    );
    
    // Red Dragon Armor
    public static final ArmorStats RED_DRAGON = new ArmorStats(
        291, 424, 397, 344,  // durability
        2, 7, 5, 2,          // protection
        19,                  // enchantment
        0.0f, 0.0f,          // toughness, knockback resistance
        Items.DRAGON_EGG,     // repair item
        SoundEvents.ARMOR_EQUIP_GENERIC // equip sound
    );
    
    // Redstone Armor
    public static final ArmorStats REDSTONE = new ArmorStats(
        165, 240, 225, 195,  // durability
        1, 4, 3, 1,          // protection
        12,                  // enchantment
        0.0f, 0.0f,          // toughness, knockback resistance
        Items.REDSTONE,       // repair item
        SoundEvents.ARMOR_EQUIP_GENERIC // equip sound
    );
    
    // Reinforced Deepslate Armor
    public static final ArmorStats REINFORCED_DEEPSLATE = new ArmorStats(
        338, 432, 405, 351,  // durability
        1, 4, 3, 1,          // protection
        18,                  // enchantment
        0.5f, 0.1f,          // toughness, knockback resistance
        Items.DEEPSLATE,      // repair item
        SoundEvents.ARMOR_EQUIP_GENERIC // equip sound
    );
    
    // RGB Armor
    public static final ArmorStats RGB = new ArmorStats(
        27, 40, 37, 32,      // durability
        1, 1, 1, 1,          // protection
        16,                  // enchantment
        0.0f, 0.0f,          // toughness, knockback resistance
        Items.REDSTONE,       // repair item (placeholder)
        SoundEvents.ARMOR_EQUIP_GENERIC // equip sound
    );
    
    // Ruby Armor
    public static final ArmorStats RUBY = new ArmorStats(
        255, 372, 318, 302,  // durability
        3, 5, 6, 3,          // protection
        19,                  // enchantment
        2.0f, 0.0f,          // toughness, knockback resistance
        Items.REDSTONE,       // repair item
        SoundEvents.ARMOR_EQUIP_GENERIC // equip sound
    );
    
    // Sculk Armor
    public static final ArmorStats SCULK = new ArmorStats(
        110, 160, 150, 130,  // durability
        2, 5, 4, 2,          // protection
        16,                  // enchantment
        0.0f, 0.0f,          // toughness, knockback resistance
        Items.SCULK,          // repair item
        SoundEvents.ARMOR_EQUIP_GENERIC // equip sound
    );
    
    // Shulker Armor
    public static final ArmorStats SHULKER = new ArmorStats(
        327, 476, 446, 386,  // durability
        3, 6, 5, 3,          // protection
        17,                  // enchantment
        1.0f, 0.0f,          // toughness, knockback resistance
        Items.SHULKER_SHELL,  // repair item
        SoundEvents.ARMOR_EQUIP_GENERIC // equip sound
    );
    
    // Skeleton Armor
    public static final ArmorStats SKELETON = new ArmorStats(
        193, 280, 263, 228,  // durability
        2, 6, 5, 2,          // protection
        11,                  // enchantment
        0.6f, 0.0f,          // toughness, knockback resistance
        Items.BONE,           // repair item
        SoundEvents.ARMOR_EQUIP_GENERIC // equip sound
    );
    
    // Sniffer Armor
    public static final ArmorStats SNIFFER = new ArmorStats(
        99, 144, 135, 117,   // durability
        1, 3, 2, 1,          // protection
        14,                  // enchantment
        0.0f, 0.0f,          // toughness, knockback resistance
        Items.SNIFFER_EGG,    // repair item
        SoundEvents.ARMOR_EQUIP_GENERIC // equip sound
    );
    
    // TNT Armor
    public static final ArmorStats TNT = new ArmorStats(
        55, 80, 75, 65,      // durability
        1, 2, 1, 1,          // protection
        10,                  // enchantment
        0.0f, 0.0f,          // toughness, knockback resistance
        Items.TNT,            // repair item
        SoundEvents.ARMOR_EQUIP_GENERIC // equip sound
    );
    
    // Totem Armor
    public static final ArmorStats TOTEM = new ArmorStats(
        181, 264, 247, 214,  // durability
        3, 8, 6, 3,          // protection
        18,                  // enchantment
        0.0f, 0.0f,          // toughness, knockback resistance
        Items.TOTEM_OF_UNDYING, // repair item
        SoundEvents.ARMOR_EQUIP_GENERIC // equip sound
    );
    
    // Wither Skeleton Armor
    public static final ArmorStats WITHER_SKELETON = new ArmorStats(
        291, 424, 397, 344,  // durability
        2, 7, 5, 2,          // protection
        16,                  // enchantment
        0.5f, 0.0f,          // toughness, knockback resistance
        Items.WITHER_SKELETON_SKULL, // repair item
        SoundEvents.ARMOR_EQUIP_GENERIC // equip sound
    );
    
    /**
     * Get armor stats by name
     */
    public static ArmorStats getStats(String name) {
        return switch (name) {
            case "amethyst" -> AMETHYST;
            case "ancient_debris" -> ANCIENT_DEBRIS;
            case "bedrock" -> BEDROCK;
            case "bee" -> BEE;
            case "bone" -> BONE;
            case "cactus" -> CACTUS;
            case "coal" -> COAL;
            case "copper" -> COPPER;
            case "crafting" -> CRAFTING;
            case "dripstone" -> DRIPSTONE;
            case "emerald" -> EMERALD;
            case "ender_dragon" -> ENDER_DRAGON;
            case "galaxy" -> GALAXY;
            case "gilded" -> GILDED;
            case "glass" -> GLASS;
            case "guardian" -> GUARDIAN;
            case "lapis" -> LAPIS;
            case "machine" -> MACHINE;
            case "magma" -> MAGMA;
            case "music" -> MUSIC;
            case "obsidian" -> OBSIDIAN;
            case "pot" -> POT;
            case "power_suit" -> POWER_SUIT;
            case "quartz" -> QUARTZ;
            case "red_dragon" -> RED_DRAGON;
            case "redstone" -> REDSTONE;
            case "reinforced_deepslate" -> REINFORCED_DEEPSLATE;
            case "rgb" -> RGB;
            case "ruby" -> RUBY;
            case "sculk" -> SCULK;
            case "shulker" -> SHULKER;
            case "skeleton" -> SKELETON;
            case "sniffer" -> SNIFFER;
            case "tnt" -> TNT;
            case "totem" -> TOTEM;
            case "wither_skeleton" -> WITHER_SKELETON;
            default -> null;
        };
    }

    /**
     * Get equip sound for armor type
     */
    public static SoundEvent getEquipSound(String name) {
        return switch (name) {
            case "amethyst" -> SoundEvents.ARMOR_EQUIP_GENERIC;
            case "ancient_debris" -> SoundEvents.ARMOR_EQUIP_NETHERITE;
            case "bedrock" -> SoundEvents.ARMOR_EQUIP_GENERIC;
            case "bee" -> SoundEvents.ARMOR_EQUIP_GENERIC;
            case "bone" -> SoundEvents.ARMOR_EQUIP_GENERIC;
            case "cactus" -> SoundEvents.ARMOR_EQUIP_GENERIC;
            case "coal" -> SoundEvents.ARMOR_EQUIP_GENERIC;
            case "copper" -> SoundEvents.ARMOR_EQUIP_GENERIC;
            case "crafting" -> SoundEvents.ARMOR_EQUIP_GENERIC;
            case "dripstone" -> SoundEvents.ARMOR_EQUIP_GENERIC;
            case "emerald" -> SoundEvents.ARMOR_EQUIP_GENERIC;
            case "ender_dragon" -> SoundEvents.ARMOR_EQUIP_GENERIC;
            case "galaxy" -> SoundEvents.ARMOR_EQUIP_GENERIC;
            case "gilded" -> SoundEvents.ARMOR_EQUIP_GOLD;
            case "glass" -> SoundEvents.ARMOR_EQUIP_GENERIC;
            case "guardian" -> SoundEvents.ARMOR_EQUIP_GENERIC;
            case "lapis" -> SoundEvents.ARMOR_EQUIP_GENERIC;
            case "machine" -> SoundEvents.ARMOR_EQUIP_IRON;
            case "magma" -> SoundEvents.ARMOR_EQUIP_GENERIC;
            case "music" -> SoundEvents.ARMOR_EQUIP_GENERIC;
            case "obsidian" -> SoundEvents.ARMOR_EQUIP_GENERIC;
            case "pot" -> SoundEvents.ARMOR_EQUIP_GENERIC;
            case "power_suit" -> SoundEvents.ARMOR_EQUIP_IRON;
            case "quartz" -> SoundEvents.ARMOR_EQUIP_GENERIC;
            case "red_dragon" -> SoundEvents.ARMOR_EQUIP_GENERIC;
            case "redstone" -> SoundEvents.ARMOR_EQUIP_GENERIC;
            case "reinforced_deepslate" -> SoundEvents.ARMOR_EQUIP_GENERIC;
            case "rgb" -> SoundEvents.ARMOR_EQUIP_GENERIC;
            case "ruby" -> SoundEvents.ARMOR_EQUIP_GENERIC;
            case "sculk" -> SoundEvents.ARMOR_EQUIP_GENERIC;
            case "shulker" -> SoundEvents.ARMOR_EQUIP_GENERIC;
            case "skeleton" -> SoundEvents.ARMOR_EQUIP_GENERIC;
            case "sniffer" -> SoundEvents.ARMOR_EQUIP_GENERIC;
            case "tnt" -> SoundEvents.ARMOR_EQUIP_GENERIC;
            case "totem" -> SoundEvents.ARMOR_EQUIP_GENERIC;
            case "wither_skeleton" -> SoundEvents.ARMOR_EQUIP_GENERIC;
            default -> SoundEvents.ARMOR_EQUIP_GENERIC;
        };
    }
}
