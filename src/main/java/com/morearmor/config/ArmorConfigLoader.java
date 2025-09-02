package com.morearmor.config;

import com.morearmor.MoreArmor;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.fml.loading.FMLPaths;
import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.annotation.Nonnull;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class ArmorConfigLoader {
    private static final Logger LOGGER = LogManager.getLogger();
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
            LOGGER.info("Successfully loaded armor configuration from {}", configPath);
        } catch (Throwable t) {
            // Leave tomlConfig null; we'll fall back to defaults
            tomlConfig = null;
            LOGGER.warn("Failed to load armor configuration from TOML file, using defaults. Error: {}", t.getMessage());
            LOGGER.debug("Full error details:", t);
        }
    }

    private static int tomlInt(String section, String key, int def) {
        ensureTomlLoaded();
        if (tomlConfig == null) return def;
        String path = section + "." + key;
        try {
            Object value = tomlConfig.getOrElse(path, def);
            if (value instanceof Number) {
                int result = ((Number) value).intValue();
                // Validate reasonable bounds for armor stats
                if (result < 0) {
                    LOGGER.warn("Invalid negative value for {}: {}, using default: {}", path, result, def);
                    return def;
                }
                if (result > 10000) {
                    LOGGER.warn("Unreasonably high value for {}: {}, using default: {}", path, result, def);
                    return def;
                }
                return result;
            } else if (value != null) {
                LOGGER.warn("Invalid value type for {}: expected number, got {}, using default: {}", path, value.getClass().getSimpleName(), def);
            }
        } catch (Exception e) {
            LOGGER.warn("Error reading config value for {}: {}, using default: {}", path, e.getMessage(), def);
        }
        return def;
    }

    private static double tomlDouble(String section, String key, double def) {
        ensureTomlLoaded();
        if (tomlConfig == null) return def;
        String path = section + "." + key;
        try {
            Object value = tomlConfig.getOrElse(path, def);
            if (value instanceof Number) {
                double result = ((Number) value).doubleValue();
                // Validate reasonable bounds for armor stats
                if (result < 0.0) {
                    LOGGER.warn("Invalid negative value for {}: {}, using default: {}", path, result, def);
                    return def;
                }
                if (result > 10.0) {
                    LOGGER.warn("Unreasonably high value for {}: {}, using default: {}", path, result, def);
                    return def;
                }
                return result;
            } else if (value != null) {
                LOGGER.warn("Invalid value type for {}: expected number, got {}, using default: {}", path, value.getClass().getSimpleName(), def);
            }
        } catch (Exception e) {
            LOGGER.warn("Error reading config value for {}: {}, using default: {}", path, e.getMessage(), def);
        }
        return def;
    }

    public static void loadMaterials() {
        // No-op. Materials are created on-demand.
    }

    /**
     * Validates the configuration file structure and logs any issues found.
     * This method can be called during mod initialization to provide helpful feedback.
     */
    public static void validateConfig() {
        ensureTomlLoaded();
        if (tomlConfig == null) {
            LOGGER.warn("Configuration file could not be loaded, all armor will use default values.");
            return;
        }

        // List of expected armor types
        String[] expectedArmorTypes = {
            "amethyst", "ancient_debris", "bedrock", "bee", "bone", "cactus", "coal", "copper",
            "crafting", "dripstone", "emerald", "ender_dragon", "galaxy", "gilded", "glass",
            "guardian", "lapis", "machine", "magma", "music", "obsidian", "pot", "power_suit",
            "quartz", "red_dragon", "redstone", "reinforced_deepslate", "rgb", "ruby", "sculk",
            "shulker", "skeleton", "sniffer", "tnt", "totem", "wither_skeleton"
        };

        // List of expected properties for each armor type
        String[] expectedProperties = {
            "helmet_durability", "chestplate_durability", "leggings_durability", "boots_durability",
            "helmet_protection", "chestplate_protection", "leggings_protection", "boots_protection",
            "enchantment", "toughness", "knockback_resistance"
        };

        boolean hasIssues = false;

        for (String armorType : expectedArmorTypes) {
            String section = armorType + "_armor";
            if (!tomlConfig.contains(section)) {
                LOGGER.warn("Missing armor section: [{}] - this armor type will use default values", section);
                hasIssues = true;
                continue;
            }

            for (String property : expectedProperties) {
                String path = section + "." + property;
                if (!tomlConfig.contains(path)) {
                    LOGGER.warn("Missing property {} in section [{}] - using default value", property, section);
                    hasIssues = true;
                }
            }
        }

        if (!hasIssues) {
            LOGGER.info("Armor configuration validation completed successfully - all expected sections and properties found.");
        } else {
            LOGGER.warn("Armor configuration validation completed with issues. Check the log above for details.");
            LOGGER.info("You can delete the config file to regenerate it with default values, or add missing sections/properties manually.");
        }
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
                return getDefaultEquipSound(name);
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

    // Defaults from centralized ArmorDefaults class
    private static int getDefaultDurability(String name, ArmorItem.Type type) {
        ArmorDefaults.ArmorStats stats = ArmorDefaults.getStats(name);
        return stats != null ? stats.getDurability(type) : 100;
    }

    private static int getDefaultProtection(String name, ArmorItem.Type type) {
        ArmorDefaults.ArmorStats stats = ArmorDefaults.getStats(name);
        return stats != null ? stats.getProtection(type) : 1;
    }

    private static int getDefaultEnchantment(String name) {
        ArmorDefaults.ArmorStats stats = ArmorDefaults.getStats(name);
        return stats != null ? stats.enchantment : 10;
    }

    private static float getDefaultToughness(String name) {
        ArmorDefaults.ArmorStats stats = ArmorDefaults.getStats(name);
        return stats != null ? stats.toughness : 0.0f;
    }

    private static float getDefaultKnockbackResistance(String name) {
        ArmorDefaults.ArmorStats stats = ArmorDefaults.getStats(name);
        return stats != null ? stats.knockbackResistance : 0.0f;
    }

    private static Item getRepairItem(String name) {
        ArmorDefaults.ArmorStats stats = ArmorDefaults.getStats(name);
        return stats != null ? stats.repairItem : Items.IRON_INGOT;
    }

    private static SoundEvent getDefaultEquipSound(String name) {
        return ArmorDefaults.getEquipSound(name);
    }
}
