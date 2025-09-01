package com.morearmor.config;

import com.morearmor.MoreArmor;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.fml.loading.FMLPaths;
import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import javax.annotation.Nonnull;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class ArmorConfigLoader {
    private static final Map<String, ArmorMaterial> MATERIALS = new HashMap<>();

    // NightConfig TOML loader for direct reads without Forge timing restrictions
    private static CommentedFileConfig tomlConfig;

    private static synchronized void ensureTomlLoaded() {
        if (tomlConfig != null) return;
        try {
            Path configPath = FMLPaths.CONFIGDIR.get().resolve("morearmor-common.toml");
            CommentedFileConfig cfg = CommentedFileConfig.builder(configPath).autoreload().autosave().sync().build();
            cfg.load();
            tomlConfig = cfg;
        } catch (Throwable t) {
            // Leave tomlConfig null; we'll fall back to defaults
            tomlConfig = null;
        }
    }

    private static int tomlInt(String section, String key, int def) {
        ensureTomlLoaded();
        if (tomlConfig == null) return def;
        String path = section + "." + key;
        Object value = tomlConfig.getOrElse(path, def);
        if (value instanceof Number) return ((Number) value).intValue();
        return def;
    }

    private static double tomlDouble(String section, String key, double def) {
        ensureTomlLoaded();
        if (tomlConfig == null) return def;
        String path = section + "." + key;
        Object value = tomlConfig.getOrElse(path, def);
        if (value instanceof Number) return ((Number) value).doubleValue();
        return def;
    }

    public static void loadMaterials() {
        // No-op. Materials are created on-demand.
    }

    public static ArmorMaterial getMaterial(String name) {
        return MATERIALS.computeIfAbsent(name, ArmorConfigLoader::createMaterial);
    }

    private static ArmorMaterial createMaterial(String name) {
        return new ArmorMaterial() {
            @Override
            public int getDurabilityForType(@Nonnull ArmorItem.Type type) {
                String section = name + "_armor";
                String key = durabilityKey(type);
                return tomlInt(section, key, getDefaultDurability(name, type));
            }

            @Override
            public int getDefenseForType(@Nonnull ArmorItem.Type type) {
                String section = name + "_armor";
                String key = protectionKey(type);
                return tomlInt(section, key, getDefaultProtection(name, type));
            }

            @Override
            public int getEnchantmentValue() {
                String section = name + "_armor";
                return tomlInt(section, "enchantment", getDefaultEnchantment(name));
            }

            @Override
            public SoundEvent getEquipSound() {
                return SoundEvents.ARMOR_EQUIP_GENERIC;
            }

            @Override
            public Ingredient getRepairIngredient() {
                return Ingredient.of(getRepairItem(name));
            }

            @Override
            public String getName() {
                return MoreArmor.MOD_ID + ":" + name;
            }

            @Override
            public float getToughness() {
                String section = name + "_armor";
                return (float) tomlDouble(section, "toughness", getDefaultToughness(name));
            }

            @Override
            public float getKnockbackResistance() {
                String section = name + "_armor";
                return (float) tomlDouble(section, "knockback_resistance", getDefaultKnockbackResistance(name));
            }
        };
    }

    private static String durabilityKey(ArmorItem.Type type) {
        switch (type) {
            case HELMET: return "helmet_durability";
            case CHESTPLATE: return "chestplate_durability";
            case LEGGINGS: return "leggings_durability";
            case BOOTS: return "boots_durability";
        }
        return "helmet_durability";
    }

    private static String protectionKey(ArmorItem.Type type) {
        switch (type) {
            case HELMET: return "helmet_protection";
            case CHESTPLATE: return "chestplate_protection";
            case LEGGINGS: return "leggings_protection";
            case BOOTS: return "boots_protection";
        }
        return "helmet_protection";
    }

    // Defaults (kept as fallbacks)
    private static int getDefaultDurability(String name, ArmorItem.Type type) {
        switch (name) {
            case "galaxy": return type == ArmorItem.Type.HELMET ? 610 : type == ArmorItem.Type.CHESTPLATE ? 888 : type == ArmorItem.Type.LEGGINGS ? 832 : 721;
            case "amethyst": return type == ArmorItem.Type.HELMET ? 193 : type == ArmorItem.Type.CHESTPLATE ? 280 : type == ArmorItem.Type.LEGGINGS ? 263 : 228;
            case "ancient_debris": return type == ArmorItem.Type.HELMET ? 407 : type == ArmorItem.Type.CHESTPLATE ? 592 : type == ArmorItem.Type.LEGGINGS ? 555 : 481;
            case "bedrock": return type == ArmorItem.Type.HELMET ? 1000 : type == ArmorItem.Type.CHESTPLATE ? 1000 : type == ArmorItem.Type.LEGGINGS ? 1000 : 1000;
            case "bee": return type == ArmorItem.Type.HELMET ? 165 : type == ArmorItem.Type.CHESTPLATE ? 240 : type == ArmorItem.Type.LEGGINGS ? 225 : 195;
            case "bone": return type == ArmorItem.Type.HELMET ? 132 : type == ArmorItem.Type.CHESTPLATE ? 192 : type == ArmorItem.Type.LEGGINGS ? 180 : 156;
            case "cactus": return type == ArmorItem.Type.HELMET ? 99 : type == ArmorItem.Type.CHESTPLATE ? 144 : type == ArmorItem.Type.LEGGINGS ? 135 : 117;
            case "coal": return type == ArmorItem.Type.HELMET ? 132 : type == ArmorItem.Type.CHESTPLATE ? 192 : type == ArmorItem.Type.LEGGINGS ? 180 : 156;
            case "copper": return type == ArmorItem.Type.HELMET ? 165 : type == ArmorItem.Type.CHESTPLATE ? 240 : type == ArmorItem.Type.LEGGINGS ? 225 : 195;
            case "crafting": return type == ArmorItem.Type.HELMET ? 66 : type == ArmorItem.Type.CHESTPLATE ? 96 : type == ArmorItem.Type.LEGGINGS ? 90 : 78;
            case "dripstone": return type == ArmorItem.Type.HELMET ? 165 : type == ArmorItem.Type.CHESTPLATE ? 240 : type == ArmorItem.Type.LEGGINGS ? 225 : 195;
            case "emerald": return type == ArmorItem.Type.HELMET ? 528 : type == ArmorItem.Type.CHESTPLATE ? 768 : type == ArmorItem.Type.LEGGINGS ? 720 : 624;
            case "ender_dragon": return type == ArmorItem.Type.HELMET ? 1000 : type == ArmorItem.Type.CHESTPLATE ? 1000 : type == ArmorItem.Type.LEGGINGS ? 1000 : 1000;
            case "gilded": return type == ArmorItem.Type.HELMET ? 132 : type == ArmorItem.Type.CHESTPLATE ? 192 : type == ArmorItem.Type.LEGGINGS ? 180 : 156;
            case "glass": return type == ArmorItem.Type.HELMET ? 33 : type == ArmorItem.Type.CHESTPLATE ? 48 : type == ArmorItem.Type.LEGGINGS ? 45 : 39;
            case "guardian": return type == ArmorItem.Type.HELMET ? 1000 : type == ArmorItem.Type.CHESTPLATE ? 1000 : type == ArmorItem.Type.LEGGINGS ? 1000 : 1000;
            case "lapis": return type == ArmorItem.Type.HELMET ? 132 : type == ArmorItem.Type.CHESTPLATE ? 192 : type == ArmorItem.Type.LEGGINGS ? 180 : 156;
            case "machine": return type == ArmorItem.Type.HELMET ? 1000 : type == ArmorItem.Type.CHESTPLATE ? 1000 : type == ArmorItem.Type.LEGGINGS ? 1000 : 1000;
            case "magma": return type == ArmorItem.Type.HELMET ? 1000 : type == ArmorItem.Type.CHESTPLATE ? 1000 : type == ArmorItem.Type.LEGGINGS ? 1000 : 1000;
            case "music": return type == ArmorItem.Type.HELMET ? 1000 : type == ArmorItem.Type.CHESTPLATE ? 1000 : type == ArmorItem.Type.LEGGINGS ? 1000 : 1000;
            case "obsidian": return type == ArmorItem.Type.HELMET ? 1000 : type == ArmorItem.Type.CHESTPLATE ? 1000 : type == ArmorItem.Type.LEGGINGS ? 1000 : 1000;
            case "pot": return type == ArmorItem.Type.HELMET ? 1000 : type == ArmorItem.Type.CHESTPLATE ? 1000 : type == ArmorItem.Type.LEGGINGS ? 1000 : 1000;
            case "power_suit": return type == ArmorItem.Type.HELMET ? 1000 : type == ArmorItem.Type.CHESTPLATE ? 1000 : type == ArmorItem.Type.LEGGINGS ? 1000 : 1000;
            case "quartz": return type == ArmorItem.Type.HELMET ? 132 : type == ArmorItem.Type.CHESTPLATE ? 192 : type == ArmorItem.Type.LEGGINGS ? 180 : 156;
            case "red_dragon": return type == ArmorItem.Type.HELMET ? 1000 : type == ArmorItem.Type.CHESTPLATE ? 1000 : type == ArmorItem.Type.LEGGINGS ? 1000 : 1000;
            case "redstone": return type == ArmorItem.Type.HELMET ? 132 : type == ArmorItem.Type.CHESTPLATE ? 192 : type == ArmorItem.Type.LEGGINGS ? 180 : 156;
            case "reinforced_deepslate": return type == ArmorItem.Type.HELMET ? 1000 : type == ArmorItem.Type.CHESTPLATE ? 1000 : type == ArmorItem.Type.LEGGINGS ? 1000 : 1000;
            case "ruby": return type == ArmorItem.Type.HELMET ? 1000 : type == ArmorItem.Type.CHESTPLATE ? 1000 : type == ArmorItem.Type.LEGGINGS ? 1000 : 1000;
            case "shulker": return type == ArmorItem.Type.HELMET ? 1000 : type == ArmorItem.Type.CHESTPLATE ? 1000 : type == ArmorItem.Type.LEGGINGS ? 1000 : 1000;
            case "skeleton": return type == ArmorItem.Type.HELMET ? 1000 : type == ArmorItem.Type.CHESTPLATE ? 1000 : type == ArmorItem.Type.LEGGINGS ? 1000 : 1000;
            case "totem": return type == ArmorItem.Type.HELMET ? 1000 : type == ArmorItem.Type.CHESTPLATE ? 1000 : type == ArmorItem.Type.LEGGINGS ? 1000 : 1000;
            case "wither_skeleton": return type == ArmorItem.Type.HELMET ? 1000 : type == ArmorItem.Type.CHESTPLATE ? 1000 : type == ArmorItem.Type.LEGGINGS ? 1000 : 1000;
            default: return 100;
        }
    }

    private static int getDefaultProtection(String name, ArmorItem.Type type) {
        switch (name) {
            case "galaxy": return type == ArmorItem.Type.HELMET ? 4 : type == ArmorItem.Type.CHESTPLATE ? 8 : type == ArmorItem.Type.LEGGINGS ? 6 : 4;
            case "amethyst": return type == ArmorItem.Type.HELMET ? 2 : type == ArmorItem.Type.CHESTPLATE ? 5 : type == ArmorItem.Type.LEGGINGS ? 4 : 1;
            case "ancient_debris": return type == ArmorItem.Type.HELMET ? 3 : type == ArmorItem.Type.CHESTPLATE ? 7 : type == ArmorItem.Type.LEGGINGS ? 5 : 3;
            case "bedrock": return type == ArmorItem.Type.HELMET ? 5 : type == ArmorItem.Type.CHESTPLATE ? 10 : type == ArmorItem.Type.LEGGINGS ? 8 : 5;
            case "bee": return type == ArmorItem.Type.HELMET ? 1 : type == ArmorItem.Type.CHESTPLATE ? 3 : type == ArmorItem.Type.LEGGINGS ? 2 : 1;
            case "bone": return type == ArmorItem.Type.HELMET ? 1 : type == ArmorItem.Type.CHESTPLATE ? 3 : type == ArmorItem.Type.LEGGINGS ? 2 : 1;
            case "cactus": return type == ArmorItem.Type.HELMET ? 1 : type == ArmorItem.Type.CHESTPLATE ? 2 : type == ArmorItem.Type.LEGGINGS ? 2 : 1;
            case "coal": return type == ArmorItem.Type.HELMET ? 1 : type == ArmorItem.Type.CHESTPLATE ? 3 : type == ArmorItem.Type.LEGGINGS ? 2 : 1;
            case "copper": return type == ArmorItem.Type.HELMET ? 1 : type == ArmorItem.Type.CHESTPLATE ? 3 : type == ArmorItem.Type.LEGGINGS ? 2 : 1;
            case "crafting": return type == ArmorItem.Type.HELMET ? 0 : type == ArmorItem.Type.CHESTPLATE ? 1 : type == ArmorItem.Type.LEGGINGS ? 1 : 0;
            case "dripstone": return type == ArmorItem.Type.HELMET ? 1 : type == ArmorItem.Type.CHESTPLATE ? 3 : type == ArmorItem.Type.LEGGINGS ? 2 : 1;
            case "emerald": return type == ArmorItem.Type.HELMET ? 3 : type == ArmorItem.Type.CHESTPLATE ? 7 : type == ArmorItem.Type.LEGGINGS ? 5 : 3;
            case "ender_dragon": return type == ArmorItem.Type.HELMET ? 5 : type == ArmorItem.Type.CHESTPLATE ? 10 : type == ArmorItem.Type.LEGGINGS ? 8 : 5;
            case "gilded": return type == ArmorItem.Type.HELMET ? 3 : type == ArmorItem.Type.CHESTPLATE ? 6 : type == ArmorItem.Type.LEGGINGS ? 5 : 3;
            case "glass": return type == ArmorItem.Type.HELMET ? 0 : type == ArmorItem.Type.CHESTPLATE ? 1 : type == ArmorItem.Type.LEGGINGS ? 1 : 0;
            case "guardian": return type == ArmorItem.Type.HELMET ? 5 : type == ArmorItem.Type.CHESTPLATE ? 10 : type == ArmorItem.Type.LEGGINGS ? 8 : 5;
            case "lapis": return type == ArmorItem.Type.HELMET ? 1 : type == ArmorItem.Type.CHESTPLATE ? 3 : type == ArmorItem.Type.LEGGINGS ? 2 : 1;
            case "machine": return type == ArmorItem.Type.HELMET ? 5 : type == ArmorItem.Type.CHESTPLATE ? 10 : type == ArmorItem.Type.LEGGINGS ? 8 : 5;
            case "magma": return type == ArmorItem.Type.HELMET ? 5 : type == ArmorItem.Type.CHESTPLATE ? 10 : type == ArmorItem.Type.LEGGINGS ? 8 : 5;
            case "music": return type == ArmorItem.Type.HELMET ? 5 : type == ArmorItem.Type.CHESTPLATE ? 10 : type == ArmorItem.Type.LEGGINGS ? 8 : 5;
            case "obsidian": return type == ArmorItem.Type.HELMET ? 5 : type == ArmorItem.Type.CHESTPLATE ? 10 : type == ArmorItem.Type.LEGGINGS ? 8 : 5;
            case "pot": return type == ArmorItem.Type.HELMET ? 5 : type == ArmorItem.Type.CHESTPLATE ? 10 : type == ArmorItem.Type.LEGGINGS ? 8 : 5;
            case "power_suit": return type == ArmorItem.Type.HELMET ? 3 : type == ArmorItem.Type.CHESTPLATE ? 8 : type == ArmorItem.Type.LEGGINGS ? 6 : 3;
            case "quartz": return type == ArmorItem.Type.HELMET ? 2 : type == ArmorItem.Type.CHESTPLATE ? 2 : type == ArmorItem.Type.LEGGINGS ? 2 : 2;
            case "red_dragon": return type == ArmorItem.Type.HELMET ? 5 : type == ArmorItem.Type.CHESTPLATE ? 10 : type == ArmorItem.Type.LEGGINGS ? 8 : 5;
            case "redstone": return type == ArmorItem.Type.HELMET ? 1 : type == ArmorItem.Type.CHESTPLATE ? 4 : type == ArmorItem.Type.LEGGINGS ? 3 : 1;
            case "reinforced_deepslate": return type == ArmorItem.Type.HELMET ? 1 : type == ArmorItem.Type.CHESTPLATE ? 4 : type == ArmorItem.Type.LEGGINGS ? 3 : 1;
            case "ruby": return type == ArmorItem.Type.HELMET ? 3 : type == ArmorItem.Type.CHESTPLATE ? 5 : type == ArmorItem.Type.LEGGINGS ? 6 : 3;
            case "shulker": return type == ArmorItem.Type.HELMET ? 3 : type == ArmorItem.Type.CHESTPLATE ? 6 : type == ArmorItem.Type.LEGGINGS ? 5 : 3;
            case "skeleton": return type == ArmorItem.Type.HELMET ? 2 : type == ArmorItem.Type.CHESTPLATE ? 6 : type == ArmorItem.Type.LEGGINGS ? 5 : 2;
            case "totem": return type == ArmorItem.Type.HELMET ? 3 : type == ArmorItem.Type.CHESTPLATE ? 8 : type == ArmorItem.Type.LEGGINGS ? 6 : 3;
            case "wither_skeleton": return type == ArmorItem.Type.HELMET ? 2 : type == ArmorItem.Type.CHESTPLATE ? 7 : type == ArmorItem.Type.LEGGINGS ? 5 : 2;
            default: return 1;
        }
    }

    private static int getDefaultEnchantment(String name) {
        switch (name) {
            case "galaxy": return 19;
            case "amethyst": return 15;
            case "ancient_debris": return 19;
            case "bedrock": return 20;
            case "bee": return 10;
            case "bone": return 11;
            case "cactus": return 10;
            case "coal": return 10;
            case "copper": return 8;
            case "crafting": return 12;
            case "dripstone": return 13;
            case "emerald": return 17;
            case "ender_dragon": return 25;
            case "gilded": return 15;
            case "glass": return 6;
            case "guardian": return 25;
            case "lapis": return 18;
            case "machine": return 25;
            case "magma": return 25;
            case "music": return 25;
            case "obsidian": return 25;
            case "pot": return 25;
            case "power_suit": return 19;
            case "quartz": return 13;
            case "red_dragon": return 25;
            case "redstone": return 12;
            case "reinforced_deepslate": return 18;
            case "ruby": return 19;
            case "shulker": return 17;
            case "skeleton": return 11;
            case "totem": return 18;
            case "wither_skeleton": return 16;
            default: return 10;
        }
    }

    private static float getDefaultToughness(String name) {
        switch (name) {
            case "galaxy": return 3.0f;
            case "amethyst": return 0.5f;
            case "ancient_debris": return 3.0f;
            case "bedrock": return 0.0f;
            case "bee": return 0.0f;
            case "bone": return 0.6f;
            case "cactus": return 0.0f;
            case "coal": return 0.0f;
            case "copper": return 0.0f;
            case "crafting": return 0.0f;
            case "dripstone": return 0.0f;
            case "emerald": return 0.0f;
            case "ender_dragon": return 5.0f;
            case "gilded": return 0.0f;
            case "glass": return 0.0f;
            case "guardian": return 5.0f;
            case "lapis": return 0.0f;
            case "machine": return 5.0f;
            case "magma": return 5.0f;
            case "music": return 5.0f;
            case "obsidian": return 5.0f;
            case "pot": return 5.0f;
            case "power_suit": return 3.0f;
            case "quartz": return 0.0f;
            case "red_dragon": return 5.0f;
            case "redstone": return 0.0f;
            case "reinforced_deepslate": return 0.5f;
            case "ruby": return 2.0f;
            case "shulker": return 1.0f;
            case "skeleton": return 0.6f;
            case "totem": return 0.0f;
            case "wither_skeleton": return 0.5f;
            default: return 0.0f;
        }
    }

    private static float getDefaultKnockbackResistance(String name) {
        switch (name) {
            case "galaxy": return 0.1f;
            case "amethyst": return 0.0f;
            case "ancient_debris": return 0.1f;
            case "bedrock": return 0.2f;
            case "bee": return 0.0f;
            case "bone": return 0.0f;
            case "cactus": return 0.0f;
            case "coal": return 0.0f;
            case "copper": return 0.0f;
            case "crafting": return 0.0f;
            case "dripstone": return 0.0f;
            case "emerald": return 0.0f;
            case "ender_dragon": return 0.2f;
            case "gilded": return 0.0f;
            case "glass": return 0.0f;
            case "guardian": return 0.2f;
            case "lapis": return 0.0f;
            case "machine": return 0.2f;
            case "magma": return 0.2f;
            case "music": return 0.2f;
            case "obsidian": return 0.2f;
            case "pot": return 0.2f;
            case "power_suit": return 0.1f;
            case "quartz": return 0.0f;
            case "red_dragon": return 0.2f;
            case "redstone": return 0.0f;
            case "reinforced_deepslate": return 0.1f;
            case "ruby": return 0.0f;
            case "shulker": return 0.0f;
            case "skeleton": return 0.0f;
            case "totem": return 0.0f;
            case "wither_skeleton": return 0.0f;
            default: return 0.0f;
        }
    }

    private static Item getRepairItem(String name) {
        switch (name) {
            case "galaxy": return Items.NETHERITE_INGOT;
            case "amethyst": return Items.AMETHYST_SHARD;
            case "ancient_debris": return Items.ANCIENT_DEBRIS;
            case "bedrock": return Items.BEDROCK;
            case "bee": return Items.HONEYCOMB;
            case "bone": return Items.BONE;
            case "cactus": return Items.CACTUS;
            case "coal": return Items.COAL;
            case "copper": return Items.COPPER_INGOT;
            case "crafting": return Items.CRAFTING_TABLE;
            case "dripstone": return Items.DRIPSTONE_BLOCK;
            case "emerald": return Items.EMERALD;
            case "ender_dragon": return Items.DRAGON_EGG;
            case "gilded": return Items.GOLD_INGOT;
            case "glass": return Items.GLASS;
            case "guardian": return Items.PRISMARINE_SHARD;
            case "lapis": return Items.LAPIS_LAZULI;
            case "machine": return Items.REDSTONE;
            case "magma": return Items.MAGMA_BLOCK;
            case "music": return Items.NOTE_BLOCK;
            case "obsidian": return Items.OBSIDIAN;
            case "pot": return Items.FLOWER_POT;
            case "power_suit": return Items.REDSTONE;
            case "quartz": return Items.QUARTZ;
            case "red_dragon": return Items.DRAGON_EGG;
            case "redstone": return Items.REDSTONE;
            case "reinforced_deepslate": return Items.DEEPSLATE;
            case "ruby": return Items.REDSTONE;
            case "shulker": return Items.SHULKER_SHELL;
            case "skeleton": return Items.BONE;
            case "totem": return Items.TOTEM_OF_UNDYING;
            case "wither_skeleton": return Items.WITHER_SKELETON_SKULL;
            default: return Items.IRON_INGOT;
        }
    }
}
