package com.morearmor.config;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.common.Mod;
import com.morearmor.MoreArmor;
import org.apache.commons.lang3.tuple.Pair;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.sounds.SoundEvent;
import javax.annotation.Nonnull;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Map;
import java.util.HashMap;

@Mod.EventBusSubscriber(modid = MoreArmor.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModConfigs {
    private static final Logger LOGGER = LogManager.getLogger();
    public static final ForgeConfigSpec SERVER_SPEC;
    public static final Server SERVER;
    private static final Map<String, ArmorMaterial> MATERIAL_CACHE = new HashMap<>();

    static {
        final Pair<Server, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(Server::new);
        SERVER_SPEC = specPair.getRight();
        SERVER = specPair.getLeft();
    }

    public static void register() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, SERVER_SPEC);
    }

    @net.minecraftforge.eventbus.api.SubscribeEvent
    public static void onConfigLoad(net.minecraftforge.fml.event.config.ModConfigEvent.Loading event) {
        if (event.getConfig().getModId().equals(MoreArmor.MOD_ID)) {
            LOGGER.info("MoreArmor configuration loaded successfully");
            validateConfig();
        }
    }

    /**
     * Validates the configuration and logs any issues found.
     * This method can be called during mod initialization to provide helpful feedback.
     */
    public static void validateConfig() {
        LOGGER.info("Validating MoreArmor configuration...");
        
        // List of expected armor types
        String[] expectedArmorTypes = {
            "amethyst", "ancient_debris", "bedrock", "bee", "bone", "cactus", "coal", "copper",
            "crafting", "dripstone", "emerald", "ender_dragon", "galaxy", "gilded", "glass",
            "guardian", "lapis", "machine", "magma", "music", "obsidian", "pot", "power_suit",
            "quartz", "red_dragon", "redstone", "reinforced_deepslate", "rgb", "ruby", "sculk",
            "shulker", "skeleton", "sniffer", "tnt", "totem", "wither_skeleton"
        };

        boolean hasIssues = false;
        int totalConfigs = 0;
        int validConfigs = 0;

        for (String armorType : expectedArmorTypes) {
            totalConfigs++;
            
            // Test creating an armor material to see if all configs are accessible
            try {
                ArmorMaterial material = createArmorMaterial(armorType);
                if (material != null) {
                    validConfigs++;
                    LOGGER.debug("✓ {} armor configuration loaded successfully", armorType);
                } else {
                    LOGGER.warn("✗ {} armor configuration failed to load", armorType);
                    hasIssues = true;
                }
            } catch (Exception e) {
                LOGGER.warn("✗ {} armor configuration error: {}", armorType, e.getMessage());
                hasIssues = true;
            }
        }

        if (!hasIssues) {
            LOGGER.info("✓ MoreArmor configuration validation completed successfully - {} of {} armor types configured", validConfigs, totalConfigs);
        } else {
            LOGGER.warn("⚠ MoreArmor configuration validation completed with issues. Check the log above for details.");
            LOGGER.info("Armor types with issues will use default values from ArmorDefaults.");
        }
        
    }

    /**
     * Creates an ArmorMaterial using the Forge config values for the specified armor type.
     * This ensures proper synchronization between client and server.
     * Uses caching to avoid recreating materials and handles config loading timing.
     */
    public static ArmorMaterial createArmorMaterial(String name) {
        return MATERIAL_CACHE.computeIfAbsent(name, ModConfigs::createMaterialInternal);
    }
    
    private static ArmorMaterial createMaterialInternal(String name) {
        return new ArmorMaterial() {
            @Override
            public int getDurabilityForType(@Nonnull ArmorItem.Type type) {
                return getDurability(name, type);
            }

            @Override
            public int getDefenseForType(@Nonnull ArmorItem.Type type) {
                return getProtection(name, type);
            }

            @Override
            public int getEnchantmentValue() {
                return getEnchantment(name);
            }

            @Override
            public SoundEvent getEquipSound() {
                return ArmorDefaults.getEquipSound(name);
            }

            @Override
            public Ingredient getRepairIngredient() {
                ArmorDefaults.ArmorStats stats = ArmorDefaults.getStats(name);
                return Ingredient.of(stats != null ? stats.repairItem : Items.IRON_INGOT);
            }

            @Override
            public String getName() {
                return MoreArmor.MOD_ID + ":" + name;
            }

            @Override
            public float getToughness() {
                return getToughnessValue(name);
            }

            @Override
            public float getKnockbackResistance() {
                return getKnockbackResistanceValue(name);
            }
        };
    }

    private static int getDurability(String name, ArmorItem.Type type) {
        try {
            int durability = switch (name) {
                case "amethyst" -> switch (type) {
                    case HELMET -> SERVER.amethystHelmetDurability.get();
                    case CHESTPLATE -> SERVER.amethystChestplateDurability.get();
                    case LEGGINGS -> SERVER.amethystLeggingsDurability.get();
                    case BOOTS -> SERVER.amethystBootsDurability.get();
                };
                case "ancient_debris" -> switch (type) {
                    case HELMET -> SERVER.ancientDebrisHelmetDurability.get();
                    case CHESTPLATE -> SERVER.ancientDebrisChestplateDurability.get();
                    case LEGGINGS -> SERVER.ancientDebrisLeggingsDurability.get();
                    case BOOTS -> SERVER.ancientDebrisBootsDurability.get();
                };
                case "bedrock" -> switch (type) {
                    case HELMET -> SERVER.bedrockHelmetDurability.get();
                    case CHESTPLATE -> SERVER.bedrockChestplateDurability.get();
                    case LEGGINGS -> SERVER.bedrockLeggingsDurability.get();
                    case BOOTS -> SERVER.bedrockBootsDurability.get();
                };
                case "bee" -> switch (type) {
                    case HELMET -> SERVER.beeHelmetDurability.get();
                    case CHESTPLATE -> SERVER.beeChestplateDurability.get();
                    case LEGGINGS -> SERVER.beeLeggingsDurability.get();
                    case BOOTS -> SERVER.beeBootsDurability.get();
                };
                case "bone" -> switch (type) {
                    case HELMET -> SERVER.boneHelmetDurability.get();
                    case CHESTPLATE -> SERVER.boneChestplateDurability.get();
                    case LEGGINGS -> SERVER.boneLeggingsDurability.get();
                    case BOOTS -> SERVER.boneBootsDurability.get();
                };
                case "cactus" -> switch (type) {
                    case HELMET -> SERVER.cactusHelmetDurability.get();
                    case CHESTPLATE -> SERVER.cactusChestplateDurability.get();
                    case LEGGINGS -> SERVER.cactusLeggingsDurability.get();
                    case BOOTS -> SERVER.cactusBootsDurability.get();
                };
                case "coal" -> switch (type) {
                    case HELMET -> SERVER.coalHelmetDurability.get();
                    case CHESTPLATE -> SERVER.coalChestplateDurability.get();
                    case LEGGINGS -> SERVER.coalLeggingsDurability.get();
                    case BOOTS -> SERVER.coalBootsDurability.get();
                };
                case "copper" -> switch (type) {
                    case HELMET -> SERVER.copperHelmetDurability.get();
                    case CHESTPLATE -> SERVER.copperChestplateDurability.get();
                    case LEGGINGS -> SERVER.copperLeggingsDurability.get();
                    case BOOTS -> SERVER.copperBootsDurability.get();
                };
                case "crafting" -> switch (type) {
                    case HELMET -> SERVER.craftingHelmetDurability.get();
                    case CHESTPLATE -> SERVER.craftingChestplateDurability.get();
                    case LEGGINGS -> SERVER.craftingLeggingsDurability.get();
                    case BOOTS -> SERVER.craftingBootsDurability.get();
                };
                case "dripstone" -> switch (type) {
                    case HELMET -> SERVER.dripstoneHelmetDurability.get();
                    case CHESTPLATE -> SERVER.dripstoneChestplateDurability.get();
                    case LEGGINGS -> SERVER.dripstoneLeggingsDurability.get();
                    case BOOTS -> SERVER.dripstoneBootsDurability.get();
                };
                case "emerald" -> switch (type) {
                    case HELMET -> SERVER.emeraldHelmetDurability.get();
                    case CHESTPLATE -> SERVER.emeraldChestplateDurability.get();
                    case LEGGINGS -> SERVER.emeraldLeggingsDurability.get();
                    case BOOTS -> SERVER.emeraldBootsDurability.get();
                };
                case "ender_dragon" -> switch (type) {
                    case HELMET -> SERVER.enderDragonHelmetDurability.get();
                    case CHESTPLATE -> SERVER.enderDragonChestplateDurability.get();
                    case LEGGINGS -> SERVER.enderDragonLeggingsDurability.get();
                    case BOOTS -> SERVER.enderDragonBootsDurability.get();
                };
                case "galaxy" -> switch (type) {
                    case HELMET -> SERVER.galaxyHelmetDurability.get();
                    case CHESTPLATE -> SERVER.galaxyChestplateDurability.get();
                    case LEGGINGS -> SERVER.galaxyLeggingsDurability.get();
                    case BOOTS -> SERVER.galaxyBootsDurability.get();
                };
                case "gilded" -> switch (type) {
                    case HELMET -> SERVER.gildedHelmetDurability.get();
                    case CHESTPLATE -> SERVER.gildedChestplateDurability.get();
                    case LEGGINGS -> SERVER.gildedLeggingsDurability.get();
                    case BOOTS -> SERVER.gildedBootsDurability.get();
                };
                case "glass" -> switch (type) {
                    case HELMET -> SERVER.glassHelmetDurability.get();
                    case CHESTPLATE -> SERVER.glassChestplateDurability.get();
                    case LEGGINGS -> SERVER.glassLeggingsDurability.get();
                    case BOOTS -> SERVER.glassBootsDurability.get();
                };
                case "guardian" -> switch (type) {
                    case HELMET -> SERVER.guardianHelmetDurability.get();
                    case CHESTPLATE -> SERVER.guardianChestplateDurability.get();
                    case LEGGINGS -> SERVER.guardianLeggingsDurability.get();
                    case BOOTS -> SERVER.guardianBootsDurability.get();
                };
                case "lapis" -> switch (type) {
                    case HELMET -> SERVER.lapisHelmetDurability.get();
                    case CHESTPLATE -> SERVER.lapisChestplateDurability.get();
                    case LEGGINGS -> SERVER.lapisLeggingsDurability.get();
                    case BOOTS -> SERVER.lapisBootsDurability.get();
                };
                case "machine" -> switch (type) {
                    case HELMET -> SERVER.machineHelmetDurability.get();
                    case CHESTPLATE -> SERVER.machineChestplateDurability.get();
                    case LEGGINGS -> SERVER.machineLeggingsDurability.get();
                    case BOOTS -> SERVER.machineBootsDurability.get();
                };
                case "magma" -> switch (type) {
                    case HELMET -> SERVER.magmaHelmetDurability.get();
                    case CHESTPLATE -> SERVER.magmaChestplateDurability.get();
                    case LEGGINGS -> SERVER.magmaLeggingsDurability.get();
                    case BOOTS -> SERVER.magmaBootsDurability.get();
                };
                case "music" -> switch (type) {
                    case HELMET -> SERVER.musicHelmetDurability.get();
                    case CHESTPLATE -> SERVER.musicChestplateDurability.get();
                    case LEGGINGS -> SERVER.musicLeggingsDurability.get();
                    case BOOTS -> SERVER.musicBootsDurability.get();
                };
                case "obsidian" -> switch (type) {
                    case HELMET -> SERVER.obsidianHelmetDurability.get();
                    case CHESTPLATE -> SERVER.obsidianChestplateDurability.get();
                    case LEGGINGS -> SERVER.obsidianLeggingsDurability.get();
                    case BOOTS -> SERVER.obsidianBootsDurability.get();
                };
                case "pot" -> switch (type) {
                    case HELMET -> SERVER.potHelmetDurability.get();
                    case CHESTPLATE -> SERVER.potChestplateDurability.get();
                    case LEGGINGS -> SERVER.potLeggingsDurability.get();
                    case BOOTS -> SERVER.potBootsDurability.get();
                };
                case "power_suit" -> switch (type) {
                    case HELMET -> SERVER.powerSuitHelmetDurability.get();
                    case CHESTPLATE -> SERVER.powerSuitChestplateDurability.get();
                    case LEGGINGS -> SERVER.powerSuitLeggingsDurability.get();
                    case BOOTS -> SERVER.powerSuitBootsDurability.get();
                };
                case "quartz" -> switch (type) {
                    case HELMET -> SERVER.quartzHelmetDurability.get();
                    case CHESTPLATE -> SERVER.quartzChestplateDurability.get();
                    case LEGGINGS -> SERVER.quartzLeggingsDurability.get();
                    case BOOTS -> SERVER.quartzBootsDurability.get();
                };
                case "red_dragon" -> switch (type) {
                    case HELMET -> SERVER.redDragonHelmetDurability.get();
                    case CHESTPLATE -> SERVER.redDragonChestplateDurability.get();
                    case LEGGINGS -> SERVER.redDragonLeggingsDurability.get();
                    case BOOTS -> SERVER.redDragonBootsDurability.get();
                };
                case "redstone" -> switch (type) {
                    case HELMET -> SERVER.redstoneHelmetDurability.get();
                    case CHESTPLATE -> SERVER.redstoneChestplateDurability.get();
                    case LEGGINGS -> SERVER.redstoneLeggingsDurability.get();
                    case BOOTS -> SERVER.redstoneBootsDurability.get();
                };
                case "reinforced_deepslate" -> switch (type) {
                    case HELMET -> SERVER.reinforcedDeepslateHelmetDurability.get();
                    case CHESTPLATE -> SERVER.reinforcedDeepslateChestplateDurability.get();
                    case LEGGINGS -> SERVER.reinforcedDeepslateLeggingsDurability.get();
                    case BOOTS -> SERVER.reinforcedDeepslateBootsDurability.get();
                };
                case "rgb" -> switch (type) {
                    case HELMET -> SERVER.rgbHelmetDurability.get();
                    case CHESTPLATE -> SERVER.rgbChestplateDurability.get();
                    case LEGGINGS -> SERVER.rgbLeggingsDurability.get();
                    case BOOTS -> SERVER.rgbBootsDurability.get();
                };
                case "ruby" -> switch (type) {
                    case HELMET -> SERVER.rubyHelmetDurability.get();
                    case CHESTPLATE -> SERVER.rubyChestplateDurability.get();
                    case LEGGINGS -> SERVER.rubyLeggingsDurability.get();
                    case BOOTS -> SERVER.rubyBootsDurability.get();
                };
                case "sculk" -> switch (type) {
                    case HELMET -> SERVER.sculkHelmetDurability.get();
                    case CHESTPLATE -> SERVER.sculkChestplateDurability.get();
                    case LEGGINGS -> SERVER.sculkLeggingsDurability.get();
                    case BOOTS -> SERVER.sculkBootsDurability.get();
                };
                case "shulker" -> switch (type) {
                    case HELMET -> SERVER.shulkerHelmetDurability.get();
                    case CHESTPLATE -> SERVER.shulkerChestplateDurability.get();
                    case LEGGINGS -> SERVER.shulkerLeggingsDurability.get();
                    case BOOTS -> SERVER.shulkerBootsDurability.get();
                };
                case "skeleton" -> switch (type) {
                    case HELMET -> SERVER.skeletonHelmetDurability.get();
                    case CHESTPLATE -> SERVER.skeletonChestplateDurability.get();
                    case LEGGINGS -> SERVER.skeletonLeggingsDurability.get();
                    case BOOTS -> SERVER.skeletonBootsDurability.get();
                };
                case "sniffer" -> switch (type) {
                    case HELMET -> SERVER.snifferHelmetDurability.get();
                    case CHESTPLATE -> SERVER.snifferChestplateDurability.get();
                    case LEGGINGS -> SERVER.snifferLeggingsDurability.get();
                    case BOOTS -> SERVER.snifferBootsDurability.get();
                };
                case "tnt" -> switch (type) {
                    case HELMET -> SERVER.tntHelmetDurability.get();
                    case CHESTPLATE -> SERVER.tntChestplateDurability.get();
                    case LEGGINGS -> SERVER.tntLeggingsDurability.get();
                    case BOOTS -> SERVER.tntBootsDurability.get();
                };
                case "totem" -> switch (type) {
                    case HELMET -> SERVER.totemHelmetDurability.get();
                    case CHESTPLATE -> SERVER.totemChestplateDurability.get();
                    case LEGGINGS -> SERVER.totemLeggingsDurability.get();
                    case BOOTS -> SERVER.totemBootsDurability.get();
                };
                case "wither_skeleton" -> switch (type) {
                    case HELMET -> SERVER.witherSkeletonHelmetDurability.get();
                    case CHESTPLATE -> SERVER.witherSkeletonChestplateDurability.get();
                    case LEGGINGS -> SERVER.witherSkeletonLeggingsDurability.get();
                    case BOOTS -> SERVER.witherSkeletonBootsDurability.get();
                };
                default -> {
                    ArmorDefaults.ArmorStats stats = ArmorDefaults.getStats(name);
                    yield stats != null ? stats.getDurability(type) : 100;
                }
            };
            
            return durability;
        } catch (Exception e) {
            // Config not loaded yet, fall back to defaults
            ArmorDefaults.ArmorStats stats = ArmorDefaults.getStats(name);
            return stats != null ? stats.getDurability(type) : 100;
        }
    }

    private static int getProtection(String name, ArmorItem.Type type) {
        try {
            return switch (name) {
            case "amethyst" -> switch (type) {
                case HELMET -> SERVER.amethystHelmetProtection.get();
                case CHESTPLATE -> SERVER.amethystChestplateProtection.get();
                case LEGGINGS -> SERVER.amethystLeggingsProtection.get();
                case BOOTS -> SERVER.amethystBootsProtection.get();
            };
            case "ancient_debris" -> switch (type) {
                case HELMET -> SERVER.ancientDebrisHelmetProtection.get();
                case CHESTPLATE -> SERVER.ancientDebrisChestplateProtection.get();
                case LEGGINGS -> SERVER.ancientDebrisLeggingsProtection.get();
                case BOOTS -> SERVER.ancientDebrisBootsProtection.get();
            };
            case "bedrock" -> switch (type) {
                case HELMET -> SERVER.bedrockHelmetProtection.get();
                case CHESTPLATE -> SERVER.bedrockChestplateProtection.get();
                case LEGGINGS -> SERVER.bedrockLeggingsProtection.get();
                case BOOTS -> SERVER.bedrockBootsProtection.get();
            };
            case "bee" -> switch (type) {
                case HELMET -> SERVER.beeHelmetProtection.get();
                case CHESTPLATE -> SERVER.beeChestplateProtection.get();
                case LEGGINGS -> SERVER.beeLeggingsProtection.get();
                case BOOTS -> SERVER.beeBootsProtection.get();
            };
            case "bone" -> switch (type) {
                case HELMET -> SERVER.boneHelmetProtection.get();
                case CHESTPLATE -> SERVER.boneChestplateProtection.get();
                case LEGGINGS -> SERVER.boneLeggingsProtection.get();
                case BOOTS -> SERVER.boneBootsProtection.get();
            };
            case "cactus" -> switch (type) {
                case HELMET -> SERVER.cactusHelmetProtection.get();
                case CHESTPLATE -> SERVER.cactusChestplateProtection.get();
                case LEGGINGS -> SERVER.cactusLeggingsProtection.get();
                case BOOTS -> SERVER.cactusBootsProtection.get();
            };
            case "coal" -> switch (type) {
                case HELMET -> SERVER.coalHelmetProtection.get();
                case CHESTPLATE -> SERVER.coalChestplateProtection.get();
                case LEGGINGS -> SERVER.coalLeggingsProtection.get();
                case BOOTS -> SERVER.coalBootsProtection.get();
            };
            case "copper" -> switch (type) {
                case HELMET -> SERVER.copperHelmetProtection.get();
                case CHESTPLATE -> SERVER.copperChestplateProtection.get();
                case LEGGINGS -> SERVER.copperLeggingsProtection.get();
                case BOOTS -> SERVER.copperBootsProtection.get();
            };
            case "crafting" -> switch (type) {
                case HELMET -> SERVER.craftingHelmetProtection.get();
                case CHESTPLATE -> SERVER.craftingChestplateProtection.get();
                case LEGGINGS -> SERVER.craftingLeggingsProtection.get();
                case BOOTS -> SERVER.craftingBootsProtection.get();
            };
            case "dripstone" -> switch (type) {
                case HELMET -> SERVER.dripstoneHelmetProtection.get();
                case CHESTPLATE -> SERVER.dripstoneChestplateProtection.get();
                case LEGGINGS -> SERVER.dripstoneLeggingsProtection.get();
                case BOOTS -> SERVER.dripstoneBootsProtection.get();
            };
            case "emerald" -> switch (type) {
                case HELMET -> SERVER.emeraldHelmetProtection.get();
                case CHESTPLATE -> SERVER.emeraldChestplateProtection.get();
                case LEGGINGS -> SERVER.emeraldLeggingsProtection.get();
                case BOOTS -> SERVER.emeraldBootsProtection.get();
            };
            case "ender_dragon" -> switch (type) {
                case HELMET -> SERVER.enderDragonHelmetProtection.get();
                case CHESTPLATE -> SERVER.enderDragonChestplateProtection.get();
                case LEGGINGS -> SERVER.enderDragonLeggingsProtection.get();
                case BOOTS -> SERVER.enderDragonBootsProtection.get();
            };
            case "galaxy" -> switch (type) {
                case HELMET -> SERVER.galaxyHelmetProtection.get();
                case CHESTPLATE -> SERVER.galaxyChestplateProtection.get();
                case LEGGINGS -> SERVER.galaxyLeggingsProtection.get();
                case BOOTS -> SERVER.galaxyBootsProtection.get();
            };
            case "gilded" -> switch (type) {
                case HELMET -> SERVER.gildedHelmetProtection.get();
                case CHESTPLATE -> SERVER.gildedChestplateProtection.get();
                case LEGGINGS -> SERVER.gildedLeggingsProtection.get();
                case BOOTS -> SERVER.gildedBootsProtection.get();
            };
            case "glass" -> switch (type) {
                case HELMET -> SERVER.glassHelmetProtection.get();
                case CHESTPLATE -> SERVER.glassChestplateProtection.get();
                case LEGGINGS -> SERVER.glassLeggingsProtection.get();
                case BOOTS -> SERVER.glassBootsProtection.get();
            };
            case "guardian" -> switch (type) {
                case HELMET -> SERVER.guardianHelmetProtection.get();
                case CHESTPLATE -> SERVER.guardianChestplateProtection.get();
                case LEGGINGS -> SERVER.guardianLeggingsProtection.get();
                case BOOTS -> SERVER.guardianBootsProtection.get();
            };
            case "lapis" -> switch (type) {
                case HELMET -> SERVER.lapisHelmetProtection.get();
                case CHESTPLATE -> SERVER.lapisChestplateProtection.get();
                case LEGGINGS -> SERVER.lapisLeggingsProtection.get();
                case BOOTS -> SERVER.lapisBootsProtection.get();
            };
            case "machine" -> switch (type) {
                case HELMET -> SERVER.machineHelmetProtection.get();
                case CHESTPLATE -> SERVER.machineChestplateProtection.get();
                case LEGGINGS -> SERVER.machineLeggingsProtection.get();
                case BOOTS -> SERVER.machineBootsProtection.get();
            };
            case "magma" -> switch (type) {
                case HELMET -> SERVER.magmaHelmetProtection.get();
                case CHESTPLATE -> SERVER.magmaChestplateProtection.get();
                case LEGGINGS -> SERVER.magmaLeggingsProtection.get();
                case BOOTS -> SERVER.magmaBootsProtection.get();
            };
            case "music" -> switch (type) {
                case HELMET -> SERVER.musicHelmetProtection.get();
                case CHESTPLATE -> SERVER.musicChestplateProtection.get();
                case LEGGINGS -> SERVER.musicLeggingsProtection.get();
                case BOOTS -> SERVER.musicBootsProtection.get();
            };
            case "obsidian" -> switch (type) {
                case HELMET -> SERVER.obsidianHelmetProtection.get();
                case CHESTPLATE -> SERVER.obsidianChestplateProtection.get();
                case LEGGINGS -> SERVER.obsidianLeggingsProtection.get();
                case BOOTS -> SERVER.obsidianBootsProtection.get();
            };
            case "pot" -> switch (type) {
                case HELMET -> SERVER.potHelmetProtection.get();
                case CHESTPLATE -> SERVER.potChestplateProtection.get();
                case LEGGINGS -> SERVER.potLeggingsProtection.get();
                case BOOTS -> SERVER.potBootsProtection.get();
            };
            case "power_suit" -> switch (type) {
                case HELMET -> SERVER.powerSuitHelmetProtection.get();
                case CHESTPLATE -> SERVER.powerSuitChestplateProtection.get();
                case LEGGINGS -> SERVER.powerSuitLeggingsProtection.get();
                case BOOTS -> SERVER.powerSuitBootsProtection.get();
            };
            case "quartz" -> switch (type) {
                case HELMET -> SERVER.quartzHelmetProtection.get();
                case CHESTPLATE -> SERVER.quartzChestplateProtection.get();
                case LEGGINGS -> SERVER.quartzLeggingsProtection.get();
                case BOOTS -> SERVER.quartzBootsProtection.get();
            };
            case "red_dragon" -> switch (type) {
                case HELMET -> SERVER.redDragonHelmetProtection.get();
                case CHESTPLATE -> SERVER.redDragonChestplateProtection.get();
                case LEGGINGS -> SERVER.redDragonLeggingsProtection.get();
                case BOOTS -> SERVER.redDragonBootsProtection.get();
            };
            case "redstone" -> switch (type) {
                case HELMET -> SERVER.redstoneHelmetProtection.get();
                case CHESTPLATE -> SERVER.redstoneChestplateProtection.get();
                case LEGGINGS -> SERVER.redstoneLeggingsProtection.get();
                case BOOTS -> SERVER.redstoneBootsProtection.get();
            };
            case "reinforced_deepslate" -> switch (type) {
                case HELMET -> SERVER.reinforcedDeepslateHelmetProtection.get();
                case CHESTPLATE -> SERVER.reinforcedDeepslateChestplateProtection.get();
                case LEGGINGS -> SERVER.reinforcedDeepslateLeggingsProtection.get();
                case BOOTS -> SERVER.reinforcedDeepslateBootsProtection.get();
            };
            case "rgb" -> switch (type) {
                case HELMET -> SERVER.rgbHelmetProtection.get();
                case CHESTPLATE -> SERVER.rgbChestplateProtection.get();
                case LEGGINGS -> SERVER.rgbLeggingsProtection.get();
                case BOOTS -> SERVER.rgbBootsProtection.get();
            };
            case "ruby" -> switch (type) {
                case HELMET -> SERVER.rubyHelmetProtection.get();
                case CHESTPLATE -> SERVER.rubyChestplateProtection.get();
                case LEGGINGS -> SERVER.rubyLeggingsProtection.get();
                case BOOTS -> SERVER.rubyBootsProtection.get();
            };
            case "sculk" -> switch (type) {
                case HELMET -> SERVER.sculkHelmetProtection.get();
                case CHESTPLATE -> SERVER.sculkChestplateProtection.get();
                case LEGGINGS -> SERVER.sculkLeggingsProtection.get();
                case BOOTS -> SERVER.sculkBootsProtection.get();
            };
            case "shulker" -> switch (type) {
                case HELMET -> SERVER.shulkerHelmetProtection.get();
                case CHESTPLATE -> SERVER.shulkerChestplateProtection.get();
                case LEGGINGS -> SERVER.shulkerLeggingsProtection.get();
                case BOOTS -> SERVER.shulkerBootsProtection.get();
            };
            case "skeleton" -> switch (type) {
                case HELMET -> SERVER.skeletonHelmetProtection.get();
                case CHESTPLATE -> SERVER.skeletonChestplateProtection.get();
                case LEGGINGS -> SERVER.skeletonLeggingsProtection.get();
                case BOOTS -> SERVER.skeletonBootsProtection.get();
            };
            case "sniffer" -> switch (type) {
                case HELMET -> SERVER.snifferHelmetProtection.get();
                case CHESTPLATE -> SERVER.snifferChestplateProtection.get();
                case LEGGINGS -> SERVER.snifferLeggingsProtection.get();
                case BOOTS -> SERVER.snifferBootsProtection.get();
            };
            case "tnt" -> switch (type) {
                case HELMET -> SERVER.tntHelmetProtection.get();
                case CHESTPLATE -> SERVER.tntChestplateProtection.get();
                case LEGGINGS -> SERVER.tntLeggingsProtection.get();
                case BOOTS -> SERVER.tntBootsProtection.get();
            };
            case "totem" -> switch (type) {
                case HELMET -> SERVER.totemHelmetProtection.get();
                case CHESTPLATE -> SERVER.totemChestplateProtection.get();
                case LEGGINGS -> SERVER.totemLeggingsProtection.get();
                case BOOTS -> SERVER.totemBootsProtection.get();
            };
            case "wither_skeleton" -> switch (type) {
                case HELMET -> SERVER.witherSkeletonHelmetProtection.get();
                case CHESTPLATE -> SERVER.witherSkeletonChestplateProtection.get();
                case LEGGINGS -> SERVER.witherSkeletonLeggingsProtection.get();
                case BOOTS -> SERVER.witherSkeletonBootsProtection.get();
            };
            default -> {
                ArmorDefaults.ArmorStats stats = ArmorDefaults.getStats(name);
                yield stats != null ? stats.getProtection(type) : 1;
            }
        };
        } catch (Exception e) {
            // Config not loaded yet, fall back to defaults
            ArmorDefaults.ArmorStats stats = ArmorDefaults.getStats(name);
            return stats != null ? stats.getProtection(type) : 1;
        }
    }

    private static int getEnchantment(String name) {
        try {
            return switch (name) {
            case "amethyst" -> SERVER.amethystEnchantment.get();
            case "ancient_debris" -> SERVER.ancientDebrisEnchantment.get();
            case "bedrock" -> SERVER.bedrockEnchantment.get();
            case "bee" -> SERVER.beeEnchantment.get();
            case "bone" -> SERVER.boneEnchantment.get();
            case "cactus" -> SERVER.cactusEnchantment.get();
            case "coal" -> SERVER.coalEnchantment.get();
            case "copper" -> SERVER.copperEnchantment.get();
            case "crafting" -> SERVER.craftingEnchantment.get();
            case "dripstone" -> SERVER.dripstoneEnchantment.get();
            case "emerald" -> SERVER.emeraldEnchantment.get();
            case "ender_dragon" -> SERVER.enderDragonEnchantment.get();
            case "galaxy" -> SERVER.galaxyEnchantment.get();
            case "gilded" -> SERVER.gildedEnchantment.get();
            case "glass" -> SERVER.glassEnchantment.get();
            case "guardian" -> SERVER.guardianEnchantment.get();
            case "lapis" -> SERVER.lapisEnchantment.get();
            case "machine" -> SERVER.machineEnchantment.get();
            case "magma" -> SERVER.magmaEnchantment.get();
            case "music" -> SERVER.musicEnchantment.get();
            case "obsidian" -> SERVER.obsidianEnchantment.get();
            case "pot" -> SERVER.potEnchantment.get();
            case "power_suit" -> SERVER.powerSuitEnchantment.get();
            case "quartz" -> SERVER.quartzEnchantment.get();
            case "red_dragon" -> SERVER.redDragonEnchantment.get();
            case "redstone" -> SERVER.redstoneEnchantment.get();
            case "reinforced_deepslate" -> SERVER.reinforcedDeepslateEnchantment.get();
            case "rgb" -> SERVER.rgbEnchantment.get();
            case "ruby" -> SERVER.rubyEnchantment.get();
            case "sculk" -> SERVER.sculkEnchantment.get();
            case "shulker" -> SERVER.shulkerEnchantment.get();
            case "skeleton" -> SERVER.skeletonEnchantment.get();
            case "sniffer" -> SERVER.snifferEnchantment.get();
            case "tnt" -> SERVER.tntEnchantment.get();
            case "totem" -> SERVER.totemEnchantment.get();
            case "wither_skeleton" -> SERVER.witherSkeletonEnchantment.get();
            default -> {
                ArmorDefaults.ArmorStats stats = ArmorDefaults.getStats(name);
                yield stats != null ? stats.enchantment : 10;
            }
        };
        } catch (Exception e) {
            // Config not loaded yet, fall back to defaults
            ArmorDefaults.ArmorStats stats = ArmorDefaults.getStats(name);
            return stats != null ? stats.enchantment : 10;
        }
    }

    private static float getToughnessValue(String name) {
        try {
            return switch (name) {
            case "amethyst" -> SERVER.amethystToughness.get().floatValue();
            case "ancient_debris" -> SERVER.ancientDebrisToughness.get().floatValue();
            case "bedrock" -> SERVER.bedrockToughness.get().floatValue();
            case "bee" -> SERVER.beeToughness.get().floatValue();
            case "bone" -> SERVER.boneToughness.get().floatValue();
            case "cactus" -> SERVER.cactusToughness.get().floatValue();
            case "coal" -> SERVER.coalToughness.get().floatValue();
            case "copper" -> SERVER.copperToughness.get().floatValue();
            case "crafting" -> SERVER.craftingToughness.get().floatValue();
            case "dripstone" -> SERVER.dripstoneToughness.get().floatValue();
            case "emerald" -> SERVER.emeraldToughness.get().floatValue();
            case "ender_dragon" -> SERVER.enderDragonToughness.get().floatValue();
            case "galaxy" -> SERVER.galaxyToughness.get().floatValue();
            case "gilded" -> SERVER.gildedToughness.get().floatValue();
            case "glass" -> SERVER.glassToughness.get().floatValue();
            case "guardian" -> SERVER.guardianToughness.get().floatValue();
            case "lapis" -> SERVER.lapisToughness.get().floatValue();
            case "machine" -> SERVER.machineToughness.get().floatValue();
            case "magma" -> SERVER.magmaToughness.get().floatValue();
            case "music" -> SERVER.musicToughness.get().floatValue();
            case "obsidian" -> SERVER.obsidianToughness.get().floatValue();
            case "pot" -> SERVER.potToughness.get().floatValue();
            case "power_suit" -> SERVER.powerSuitToughness.get().floatValue();
            case "quartz" -> SERVER.quartzToughness.get().floatValue();
            case "red_dragon" -> SERVER.redDragonToughness.get().floatValue();
            case "redstone" -> SERVER.redstoneToughness.get().floatValue();
            case "reinforced_deepslate" -> SERVER.reinforcedDeepslateToughness.get().floatValue();
            case "rgb" -> SERVER.rgbToughness.get().floatValue();
            case "ruby" -> SERVER.rubyToughness.get().floatValue();
            case "sculk" -> SERVER.sculkToughness.get().floatValue();
            case "shulker" -> SERVER.shulkerToughness.get().floatValue();
            case "skeleton" -> SERVER.skeletonToughness.get().floatValue();
            case "sniffer" -> SERVER.snifferToughness.get().floatValue();
            case "tnt" -> SERVER.tntToughness.get().floatValue();
            case "totem" -> SERVER.totemToughness.get().floatValue();
            case "wither_skeleton" -> SERVER.witherSkeletonToughness.get().floatValue();
            default -> {
                ArmorDefaults.ArmorStats stats = ArmorDefaults.getStats(name);
                yield stats != null ? stats.toughness : 0.0f;
            }
        };
        } catch (Exception e) {
            // Config not loaded yet, fall back to defaults
            ArmorDefaults.ArmorStats stats = ArmorDefaults.getStats(name);
            return stats != null ? stats.toughness : 0.0f;
        }
    }

    private static float getKnockbackResistanceValue(String name) {
        try {
            return switch (name) {
            case "amethyst" -> SERVER.amethystKnockbackResistance.get().floatValue();
            case "ancient_debris" -> SERVER.ancientDebrisKnockbackResistance.get().floatValue();
            case "bedrock" -> SERVER.bedrockKnockbackResistance.get().floatValue();
            case "bee" -> SERVER.beeKnockbackResistance.get().floatValue();
            case "bone" -> SERVER.boneKnockbackResistance.get().floatValue();
            case "cactus" -> SERVER.cactusKnockbackResistance.get().floatValue();
            case "coal" -> SERVER.coalKnockbackResistance.get().floatValue();
            case "copper" -> SERVER.copperKnockbackResistance.get().floatValue();
            case "crafting" -> SERVER.craftingKnockbackResistance.get().floatValue();
            case "dripstone" -> SERVER.dripstoneKnockbackResistance.get().floatValue();
            case "emerald" -> SERVER.emeraldKnockbackResistance.get().floatValue();
            case "ender_dragon" -> SERVER.enderDragonKnockbackResistance.get().floatValue();
            case "galaxy" -> SERVER.galaxyKnockbackResistance.get().floatValue();
            case "gilded" -> SERVER.gildedKnockbackResistance.get().floatValue();
            case "glass" -> SERVER.glassKnockbackResistance.get().floatValue();
            case "guardian" -> SERVER.guardianKnockbackResistance.get().floatValue();
            case "lapis" -> SERVER.lapisKnockbackResistance.get().floatValue();
            case "machine" -> SERVER.machineKnockbackResistance.get().floatValue();
            case "magma" -> SERVER.magmaKnockbackResistance.get().floatValue();
            case "music" -> SERVER.musicKnockbackResistance.get().floatValue();
            case "obsidian" -> SERVER.obsidianKnockbackResistance.get().floatValue();
            case "pot" -> SERVER.potKnockbackResistance.get().floatValue();
            case "power_suit" -> SERVER.powerSuitKnockbackResistance.get().floatValue();
            case "quartz" -> SERVER.quartzKnockbackResistance.get().floatValue();
            case "red_dragon" -> SERVER.redDragonKnockbackResistance.get().floatValue();
            case "redstone" -> SERVER.redstoneKnockbackResistance.get().floatValue();
            case "reinforced_deepslate" -> SERVER.reinforcedDeepslateKnockbackResistance.get().floatValue();
            case "rgb" -> SERVER.rgbKnockbackResistance.get().floatValue();
            case "ruby" -> SERVER.rubyKnockbackResistance.get().floatValue();
            case "sculk" -> SERVER.sculkKnockbackResistance.get().floatValue();
            case "shulker" -> SERVER.shulkerKnockbackResistance.get().floatValue();
            case "skeleton" -> SERVER.skeletonKnockbackResistance.get().floatValue();
            case "sniffer" -> SERVER.snifferKnockbackResistance.get().floatValue();
            case "tnt" -> SERVER.tntKnockbackResistance.get().floatValue();
            case "totem" -> SERVER.totemKnockbackResistance.get().floatValue();
            case "wither_skeleton" -> SERVER.witherSkeletonKnockbackResistance.get().floatValue();
            default -> {
                ArmorDefaults.ArmorStats stats = ArmorDefaults.getStats(name);
                yield stats != null ? stats.knockbackResistance : 0.0f;
            }
        };
        } catch (Exception e) {
            // Config not loaded yet, fall back to defaults
            ArmorDefaults.ArmorStats stats = ArmorDefaults.getStats(name);
            return stats != null ? stats.knockbackResistance : 0.0f;
        }
    }

    /**
     * Rounds a float value to 2 decimal places to avoid floating-point precision issues in config files
     */
    private static float roundFloat(float value) {
        return Math.round(value * 100.0f) / 100.0f;
    }

    public static class Server {
        // Amethyst Armor
        public final ForgeConfigSpec.IntValue amethystHelmetDurability, amethystChestplateDurability, amethystLeggingsDurability, amethystBootsDurability;
        public final ForgeConfigSpec.IntValue amethystHelmetProtection, amethystChestplateProtection, amethystLeggingsProtection, amethystBootsProtection;
        public final ForgeConfigSpec.IntValue amethystEnchantment;
        public final ForgeConfigSpec.DoubleValue amethystToughness, amethystKnockbackResistance;

        // Ancient Debris Armor
        public final ForgeConfigSpec.IntValue ancientDebrisHelmetDurability, ancientDebrisChestplateDurability, ancientDebrisLeggingsDurability, ancientDebrisBootsDurability;
        public final ForgeConfigSpec.IntValue ancientDebrisHelmetProtection, ancientDebrisChestplateProtection, ancientDebrisLeggingsProtection, ancientDebrisBootsProtection;
        public final ForgeConfigSpec.IntValue ancientDebrisEnchantment;
        public final ForgeConfigSpec.DoubleValue ancientDebrisToughness, ancientDebrisKnockbackResistance;

        // Bedrock Armor
        public final ForgeConfigSpec.IntValue bedrockHelmetDurability, bedrockChestplateDurability, bedrockLeggingsDurability, bedrockBootsDurability;
        public final ForgeConfigSpec.IntValue bedrockHelmetProtection, bedrockChestplateProtection, bedrockLeggingsProtection, bedrockBootsProtection;
        public final ForgeConfigSpec.IntValue bedrockEnchantment;
        public final ForgeConfigSpec.DoubleValue bedrockToughness, bedrockKnockbackResistance;

        // Bee Armor
        public final ForgeConfigSpec.IntValue beeHelmetDurability, beeChestplateDurability, beeLeggingsDurability, beeBootsDurability;
        public final ForgeConfigSpec.IntValue beeHelmetProtection, beeChestplateProtection, beeLeggingsProtection, beeBootsProtection;
        public final ForgeConfigSpec.IntValue beeEnchantment;
        public final ForgeConfigSpec.DoubleValue beeToughness, beeKnockbackResistance;

        // Bone Armor
        public final ForgeConfigSpec.IntValue boneHelmetDurability, boneChestplateDurability, boneLeggingsDurability, boneBootsDurability;
        public final ForgeConfigSpec.IntValue boneHelmetProtection, boneChestplateProtection, boneLeggingsProtection, boneBootsProtection;
        public final ForgeConfigSpec.IntValue boneEnchantment;
        public final ForgeConfigSpec.DoubleValue boneToughness, boneKnockbackResistance;

        // Cactus Armor
        public final ForgeConfigSpec.IntValue cactusHelmetDurability, cactusChestplateDurability, cactusLeggingsDurability, cactusBootsDurability;
        public final ForgeConfigSpec.IntValue cactusHelmetProtection, cactusChestplateProtection, cactusLeggingsProtection, cactusBootsProtection;
        public final ForgeConfigSpec.IntValue cactusEnchantment;
        public final ForgeConfigSpec.DoubleValue cactusToughness, cactusKnockbackResistance;

        // Coal Armor
        public final ForgeConfigSpec.IntValue coalHelmetDurability, coalChestplateDurability, coalLeggingsDurability, coalBootsDurability;
        public final ForgeConfigSpec.IntValue coalHelmetProtection, coalChestplateProtection, coalLeggingsProtection, coalBootsProtection;
        public final ForgeConfigSpec.IntValue coalEnchantment;
        public final ForgeConfigSpec.DoubleValue coalToughness, coalKnockbackResistance;

        // Copper Armor
        public final ForgeConfigSpec.IntValue copperHelmetDurability, copperChestplateDurability, copperLeggingsDurability, copperBootsDurability;
        public final ForgeConfigSpec.IntValue copperHelmetProtection, copperChestplateProtection, copperLeggingsProtection, copperBootsProtection;
        public final ForgeConfigSpec.IntValue copperEnchantment;
        public final ForgeConfigSpec.DoubleValue copperToughness, copperKnockbackResistance;

        // Crafting Armor
        public final ForgeConfigSpec.IntValue craftingHelmetDurability, craftingChestplateDurability, craftingLeggingsDurability, craftingBootsDurability;
        public final ForgeConfigSpec.IntValue craftingHelmetProtection, craftingChestplateProtection, craftingLeggingsProtection, craftingBootsProtection;
        public final ForgeConfigSpec.IntValue craftingEnchantment;
        public final ForgeConfigSpec.DoubleValue craftingToughness, craftingKnockbackResistance;

        // Dripstone Armor
        public final ForgeConfigSpec.IntValue dripstoneHelmetDurability, dripstoneChestplateDurability, dripstoneLeggingsDurability, dripstoneBootsDurability;
        public final ForgeConfigSpec.IntValue dripstoneHelmetProtection, dripstoneChestplateProtection, dripstoneLeggingsProtection, dripstoneBootsProtection;
        public final ForgeConfigSpec.IntValue dripstoneEnchantment;
        public final ForgeConfigSpec.DoubleValue dripstoneToughness, dripstoneKnockbackResistance;

        // Emerald Armor
        public final ForgeConfigSpec.IntValue emeraldHelmetDurability, emeraldChestplateDurability, emeraldLeggingsDurability, emeraldBootsDurability;
        public final ForgeConfigSpec.IntValue emeraldHelmetProtection, emeraldChestplateProtection, emeraldLeggingsProtection, emeraldBootsProtection;
        public final ForgeConfigSpec.IntValue emeraldEnchantment;
        public final ForgeConfigSpec.DoubleValue emeraldToughness, emeraldKnockbackResistance;

        // Ender Dragon Armor
        public final ForgeConfigSpec.IntValue enderDragonHelmetDurability, enderDragonChestplateDurability, enderDragonLeggingsDurability, enderDragonBootsDurability;
        public final ForgeConfigSpec.IntValue enderDragonHelmetProtection, enderDragonChestplateProtection, enderDragonLeggingsProtection, enderDragonBootsProtection;
        public final ForgeConfigSpec.IntValue enderDragonEnchantment;
        public final ForgeConfigSpec.DoubleValue enderDragonToughness, enderDragonKnockbackResistance;

        // Galaxy Armor
        public final ForgeConfigSpec.IntValue galaxyHelmetDurability, galaxyChestplateDurability, galaxyLeggingsDurability, galaxyBootsDurability;
        public final ForgeConfigSpec.IntValue galaxyHelmetProtection, galaxyChestplateProtection, galaxyLeggingsProtection, galaxyBootsProtection;
        public final ForgeConfigSpec.IntValue galaxyEnchantment;
        public final ForgeConfigSpec.DoubleValue galaxyToughness, galaxyKnockbackResistance;

        // Gilded Armor
        public final ForgeConfigSpec.IntValue gildedHelmetDurability, gildedChestplateDurability, gildedLeggingsDurability, gildedBootsDurability;
        public final ForgeConfigSpec.IntValue gildedHelmetProtection, gildedChestplateProtection, gildedLeggingsProtection, gildedBootsProtection;
        public final ForgeConfigSpec.IntValue gildedEnchantment;
        public final ForgeConfigSpec.DoubleValue gildedToughness, gildedKnockbackResistance;

        // Glass Armor
        public final ForgeConfigSpec.IntValue glassHelmetDurability, glassChestplateDurability, glassLeggingsDurability, glassBootsDurability;
        public final ForgeConfigSpec.IntValue glassHelmetProtection, glassChestplateProtection, glassLeggingsProtection, glassBootsProtection;
        public final ForgeConfigSpec.IntValue glassEnchantment;
        public final ForgeConfigSpec.DoubleValue glassToughness, glassKnockbackResistance;

        // Guardian Armor
        public final ForgeConfigSpec.IntValue guardianHelmetDurability, guardianChestplateDurability, guardianLeggingsDurability, guardianBootsDurability;
        public final ForgeConfigSpec.IntValue guardianHelmetProtection, guardianChestplateProtection, guardianLeggingsProtection, guardianBootsProtection;
        public final ForgeConfigSpec.IntValue guardianEnchantment;
        public final ForgeConfigSpec.DoubleValue guardianToughness, guardianKnockbackResistance;

        // Lapis Armor
        public final ForgeConfigSpec.IntValue lapisHelmetDurability, lapisChestplateDurability, lapisLeggingsDurability, lapisBootsDurability;
        public final ForgeConfigSpec.IntValue lapisHelmetProtection, lapisChestplateProtection, lapisLeggingsProtection, lapisBootsProtection;
        public final ForgeConfigSpec.IntValue lapisEnchantment;
        public final ForgeConfigSpec.DoubleValue lapisToughness, lapisKnockbackResistance;

        // Machine Armor
        public final ForgeConfigSpec.IntValue machineHelmetDurability, machineChestplateDurability, machineLeggingsDurability, machineBootsDurability;
        public final ForgeConfigSpec.IntValue machineHelmetProtection, machineChestplateProtection, machineLeggingsProtection, machineBootsProtection;
        public final ForgeConfigSpec.IntValue machineEnchantment;
        public final ForgeConfigSpec.DoubleValue machineToughness, machineKnockbackResistance;

        // Magma Armor
        public final ForgeConfigSpec.IntValue magmaHelmetDurability, magmaChestplateDurability, magmaLeggingsDurability, magmaBootsDurability;
        public final ForgeConfigSpec.IntValue magmaHelmetProtection, magmaChestplateProtection, magmaLeggingsProtection, magmaBootsProtection;
        public final ForgeConfigSpec.IntValue magmaEnchantment;
        public final ForgeConfigSpec.DoubleValue magmaToughness, magmaKnockbackResistance;

        // Music Armor
        public final ForgeConfigSpec.IntValue musicHelmetDurability, musicChestplateDurability, musicLeggingsDurability, musicBootsDurability;
        public final ForgeConfigSpec.IntValue musicHelmetProtection, musicChestplateProtection, musicLeggingsProtection, musicBootsProtection;
        public final ForgeConfigSpec.IntValue musicEnchantment;
        public final ForgeConfigSpec.DoubleValue musicToughness, musicKnockbackResistance;

        // Obsidian Armor
        public final ForgeConfigSpec.IntValue obsidianHelmetDurability, obsidianChestplateDurability, obsidianLeggingsDurability, obsidianBootsDurability;
        public final ForgeConfigSpec.IntValue obsidianHelmetProtection, obsidianChestplateProtection, obsidianLeggingsProtection, obsidianBootsProtection;
        public final ForgeConfigSpec.IntValue obsidianEnchantment;
        public final ForgeConfigSpec.DoubleValue obsidianToughness, obsidianKnockbackResistance;

        // Pot Armor
        public final ForgeConfigSpec.IntValue potHelmetDurability, potChestplateDurability, potLeggingsDurability, potBootsDurability;
        public final ForgeConfigSpec.IntValue potHelmetProtection, potChestplateProtection, potLeggingsProtection, potBootsProtection;
        public final ForgeConfigSpec.IntValue potEnchantment;
        public final ForgeConfigSpec.DoubleValue potToughness, potKnockbackResistance;

        // Power Suit Armor
        public final ForgeConfigSpec.IntValue powerSuitHelmetDurability, powerSuitChestplateDurability, powerSuitLeggingsDurability, powerSuitBootsDurability;
        public final ForgeConfigSpec.IntValue powerSuitHelmetProtection, powerSuitChestplateProtection, powerSuitLeggingsProtection, powerSuitBootsProtection;
        public final ForgeConfigSpec.IntValue powerSuitEnchantment;
        public final ForgeConfigSpec.DoubleValue powerSuitToughness, powerSuitKnockbackResistance;

        // Quartz Armor
        public final ForgeConfigSpec.IntValue quartzHelmetDurability, quartzChestplateDurability, quartzLeggingsDurability, quartzBootsDurability;
        public final ForgeConfigSpec.IntValue quartzHelmetProtection, quartzChestplateProtection, quartzLeggingsProtection, quartzBootsProtection;
        public final ForgeConfigSpec.IntValue quartzEnchantment;
        public final ForgeConfigSpec.DoubleValue quartzToughness, quartzKnockbackResistance;

        // Red Dragon Armor
        public final ForgeConfigSpec.IntValue redDragonHelmetDurability, redDragonChestplateDurability, redDragonLeggingsDurability, redDragonBootsDurability;
        public final ForgeConfigSpec.IntValue redDragonHelmetProtection, redDragonChestplateProtection, redDragonLeggingsProtection, redDragonBootsProtection;
        public final ForgeConfigSpec.IntValue redDragonEnchantment;
        public final ForgeConfigSpec.DoubleValue redDragonToughness, redDragonKnockbackResistance;

        // Redstone Armor
        public final ForgeConfigSpec.IntValue redstoneHelmetDurability, redstoneChestplateDurability, redstoneLeggingsDurability, redstoneBootsDurability;
        public final ForgeConfigSpec.IntValue redstoneHelmetProtection, redstoneChestplateProtection, redstoneLeggingsProtection, redstoneBootsProtection;
        public final ForgeConfigSpec.IntValue redstoneEnchantment;
        public final ForgeConfigSpec.DoubleValue redstoneToughness, redstoneKnockbackResistance;

        // Reinforced Deepslate Armor
        public final ForgeConfigSpec.IntValue reinforcedDeepslateHelmetDurability, reinforcedDeepslateChestplateDurability, reinforcedDeepslateLeggingsDurability, reinforcedDeepslateBootsDurability;
        public final ForgeConfigSpec.IntValue reinforcedDeepslateHelmetProtection, reinforcedDeepslateChestplateProtection, reinforcedDeepslateLeggingsProtection, reinforcedDeepslateBootsProtection;
        public final ForgeConfigSpec.IntValue reinforcedDeepslateEnchantment;
        public final ForgeConfigSpec.DoubleValue reinforcedDeepslateToughness, reinforcedDeepslateKnockbackResistance;

        // RGB Armor
        public final ForgeConfigSpec.IntValue rgbHelmetDurability, rgbChestplateDurability, rgbLeggingsDurability, rgbBootsDurability;
        public final ForgeConfigSpec.IntValue rgbHelmetProtection, rgbChestplateProtection, rgbLeggingsProtection, rgbBootsProtection;
        public final ForgeConfigSpec.IntValue rgbEnchantment;
        public final ForgeConfigSpec.DoubleValue rgbToughness, rgbKnockbackResistance;

        // Ruby Armor
        public final ForgeConfigSpec.IntValue rubyHelmetDurability, rubyChestplateDurability, rubyLeggingsDurability, rubyBootsDurability;
        public final ForgeConfigSpec.IntValue rubyHelmetProtection, rubyChestplateProtection, rubyLeggingsProtection, rubyBootsProtection;
        public final ForgeConfigSpec.IntValue rubyEnchantment;
        public final ForgeConfigSpec.DoubleValue rubyToughness, rubyKnockbackResistance;

        // Sculk Armor
        public final ForgeConfigSpec.IntValue sculkHelmetDurability, sculkChestplateDurability, sculkLeggingsDurability, sculkBootsDurability;
        public final ForgeConfigSpec.IntValue sculkHelmetProtection, sculkChestplateProtection, sculkLeggingsProtection, sculkBootsProtection;
        public final ForgeConfigSpec.IntValue sculkEnchantment;
        public final ForgeConfigSpec.DoubleValue sculkToughness, sculkKnockbackResistance;

        // Shulker Armor
        public final ForgeConfigSpec.IntValue shulkerHelmetDurability, shulkerChestplateDurability, shulkerLeggingsDurability, shulkerBootsDurability;
        public final ForgeConfigSpec.IntValue shulkerHelmetProtection, shulkerChestplateProtection, shulkerLeggingsProtection, shulkerBootsProtection;
        public final ForgeConfigSpec.IntValue shulkerEnchantment;
        public final ForgeConfigSpec.DoubleValue shulkerToughness, shulkerKnockbackResistance;

        // Skeleton Armor
        public final ForgeConfigSpec.IntValue skeletonHelmetDurability, skeletonChestplateDurability, skeletonLeggingsDurability, skeletonBootsDurability;
        public final ForgeConfigSpec.IntValue skeletonHelmetProtection, skeletonChestplateProtection, skeletonLeggingsProtection, skeletonBootsProtection;
        public final ForgeConfigSpec.IntValue skeletonEnchantment;
        public final ForgeConfigSpec.DoubleValue skeletonToughness, skeletonKnockbackResistance;

        // Sniffer Armor
        public final ForgeConfigSpec.IntValue snifferHelmetDurability, snifferChestplateDurability, snifferLeggingsDurability, snifferBootsDurability;
        public final ForgeConfigSpec.IntValue snifferHelmetProtection, snifferChestplateProtection, snifferLeggingsProtection, snifferBootsProtection;
        public final ForgeConfigSpec.IntValue snifferEnchantment;
        public final ForgeConfigSpec.DoubleValue snifferToughness, snifferKnockbackResistance;

        // TNT Armor
        public final ForgeConfigSpec.IntValue tntHelmetDurability, tntChestplateDurability, tntLeggingsDurability, tntBootsDurability;
        public final ForgeConfigSpec.IntValue tntHelmetProtection, tntChestplateProtection, tntLeggingsProtection, tntBootsProtection;
        public final ForgeConfigSpec.IntValue tntEnchantment;
        public final ForgeConfigSpec.DoubleValue tntToughness, tntKnockbackResistance;

        // Totem Armor
        public final ForgeConfigSpec.IntValue totemHelmetDurability, totemChestplateDurability, totemLeggingsDurability, totemBootsDurability;
        public final ForgeConfigSpec.IntValue totemHelmetProtection, totemChestplateProtection, totemLeggingsProtection, totemBootsProtection;
        public final ForgeConfigSpec.IntValue totemEnchantment;
        public final ForgeConfigSpec.DoubleValue totemToughness, totemKnockbackResistance;

        // Wither Skeleton Armor
        public final ForgeConfigSpec.IntValue witherSkeletonHelmetDurability, witherSkeletonChestplateDurability, witherSkeletonLeggingsDurability, witherSkeletonBootsDurability;
        public final ForgeConfigSpec.IntValue witherSkeletonHelmetProtection, witherSkeletonChestplateProtection, witherSkeletonLeggingsProtection, witherSkeletonBootsProtection;
        public final ForgeConfigSpec.IntValue witherSkeletonEnchantment;
        public final ForgeConfigSpec.DoubleValue witherSkeletonToughness, witherSkeletonKnockbackResistance;

        public Server(ForgeConfigSpec.Builder builder) {
            // Amethyst Armor
            builder.push("amethyst_armor");
            amethystHelmetDurability = builder.comment("Durability for Amethyst Helmet").defineInRange("helmet_durability", ArmorDefaults.AMETHYST.helmetDurability, 1, 10000);
            amethystChestplateDurability = builder.comment("Durability for Amethyst Chestplate").defineInRange("chestplate_durability", ArmorDefaults.AMETHYST.chestplateDurability, 1, 10000);
            amethystLeggingsDurability = builder.comment("Durability for Amethyst Leggings").defineInRange("leggings_durability", ArmorDefaults.AMETHYST.leggingsDurability, 1, 10000);
            amethystBootsDurability = builder.comment("Durability for Amethyst Boots").defineInRange("boots_durability", ArmorDefaults.AMETHYST.bootsDurability, 1, 10000);
            amethystHelmetProtection = builder.comment("Protection for Amethyst Helmet").defineInRange("helmet_protection", ArmorDefaults.AMETHYST.helmetProtection, 0, 20);
            amethystChestplateProtection = builder.comment("Protection for Amethyst Chestplate").defineInRange("chestplate_protection", ArmorDefaults.AMETHYST.chestplateProtection, 0, 20);
            amethystLeggingsProtection = builder.comment("Protection for Amethyst Leggings").defineInRange("leggings_protection", ArmorDefaults.AMETHYST.leggingsProtection, 0, 20);
            amethystBootsProtection = builder.comment("Protection for Amethyst Boots").defineInRange("boots_protection", ArmorDefaults.AMETHYST.bootsProtection, 0, 20);
            amethystEnchantment = builder.comment("Enchantment value for Amethyst Armor").defineInRange("enchantment", ArmorDefaults.AMETHYST.enchantment, 0, 30);
            amethystToughness = builder.comment("Toughness for Amethyst Armor").defineInRange("toughness", ArmorDefaults.AMETHYST.toughness, 0.0, 10.0);
            amethystKnockbackResistance = builder.comment("Knockback resistance for Amethyst Armor").defineInRange("knockback_resistance", ArmorDefaults.AMETHYST.knockbackResistance, 0.0, 1.0);
            builder.pop();

            // Ancient Debris Armor
            builder.push("ancient_debris_armor");
            ancientDebrisHelmetDurability = builder.comment("Durability for Ancient Debris Helmet").defineInRange("helmet_durability", ArmorDefaults.ANCIENT_DEBRIS.helmetDurability, 1, 10000);
            ancientDebrisChestplateDurability = builder.comment("Durability for Ancient Debris Chestplate").defineInRange("chestplate_durability", ArmorDefaults.ANCIENT_DEBRIS.chestplateDurability, 1, 10000);
            ancientDebrisLeggingsDurability = builder.comment("Durability for Ancient Debris Leggings").defineInRange("leggings_durability", ArmorDefaults.ANCIENT_DEBRIS.leggingsDurability, 1, 10000);
            ancientDebrisBootsDurability = builder.comment("Durability for Ancient Debris Boots").defineInRange("boots_durability", ArmorDefaults.ANCIENT_DEBRIS.bootsDurability, 1, 10000);
            ancientDebrisHelmetProtection = builder.comment("Protection for Ancient Debris Helmet").defineInRange("helmet_protection", ArmorDefaults.ANCIENT_DEBRIS.helmetProtection, 0, 20);
            ancientDebrisChestplateProtection = builder.comment("Protection for Ancient Debris Chestplate").defineInRange("chestplate_protection", ArmorDefaults.ANCIENT_DEBRIS.chestplateProtection, 0, 20);
            ancientDebrisLeggingsProtection = builder.comment("Protection for Ancient Debris Leggings").defineInRange("leggings_protection", ArmorDefaults.ANCIENT_DEBRIS.leggingsProtection, 0, 20);
            ancientDebrisBootsProtection = builder.comment("Protection for Ancient Debris Boots").defineInRange("boots_protection", ArmorDefaults.ANCIENT_DEBRIS.bootsProtection, 0, 20);
            ancientDebrisEnchantment = builder.comment("Enchantment value for Ancient Debris Armor").defineInRange("enchantment", ArmorDefaults.ANCIENT_DEBRIS.enchantment, 0, 30);
            ancientDebrisToughness = builder.comment("Toughness for Ancient Debris Armor").defineInRange("toughness", ArmorDefaults.ANCIENT_DEBRIS.toughness, 0.0, 10.0);
            ancientDebrisKnockbackResistance = builder.comment("Knockback resistance for Ancient Debris Armor").defineInRange("knockback_resistance", ArmorDefaults.ANCIENT_DEBRIS.knockbackResistance, 0.0, 1.0);
            builder.pop();

            // Bedrock Armor
            builder.push("bedrock_armor");
            bedrockHelmetDurability = builder.comment("Durability for Bedrock Helmet").defineInRange("helmet_durability", ArmorDefaults.BEDROCK.helmetDurability, 1, 10000);
            bedrockChestplateDurability = builder.comment("Durability for Bedrock Chestplate").defineInRange("chestplate_durability", ArmorDefaults.BEDROCK.chestplateDurability, 1, 10000);
            bedrockLeggingsDurability = builder.comment("Durability for Bedrock Leggings").defineInRange("leggings_durability", ArmorDefaults.BEDROCK.leggingsDurability, 1, 10000);
            bedrockBootsDurability = builder.comment("Durability for Bedrock Boots").defineInRange("boots_durability", ArmorDefaults.BEDROCK.bootsDurability, 1, 10000);
            bedrockHelmetProtection = builder.comment("Protection for Bedrock Helmet").defineInRange("helmet_protection", ArmorDefaults.BEDROCK.helmetProtection, 0, 20);
            bedrockChestplateProtection = builder.comment("Protection for Bedrock Chestplate").defineInRange("chestplate_protection", ArmorDefaults.BEDROCK.chestplateProtection, 0, 20);
            bedrockLeggingsProtection = builder.comment("Protection for Bedrock Leggings").defineInRange("leggings_protection", ArmorDefaults.BEDROCK.leggingsProtection, 0, 20);
            bedrockBootsProtection = builder.comment("Protection for Bedrock Boots").defineInRange("boots_protection", ArmorDefaults.BEDROCK.bootsProtection, 0, 20);
            bedrockEnchantment = builder.comment("Enchantment value for Bedrock Armor").defineInRange("enchantment", ArmorDefaults.BEDROCK.enchantment, 0, 30);
            bedrockToughness = builder.comment("Toughness for Bedrock Armor").defineInRange("toughness", ArmorDefaults.BEDROCK.toughness, 0.0, 10.0);
            bedrockKnockbackResistance = builder.comment("Knockback resistance for Bedrock Armor").defineInRange("knockback_resistance", ArmorDefaults.BEDROCK.knockbackResistance, 0.0, 1.0);
            builder.pop();

            // Bee Armor
            builder.push("bee_armor");
            beeHelmetDurability = builder.comment("Durability for Bee Helmet").defineInRange("helmet_durability", ArmorDefaults.BEE.helmetDurability, 1, 10000);
            beeChestplateDurability = builder.comment("Durability for Bee Chestplate").defineInRange("chestplate_durability", ArmorDefaults.BEE.chestplateDurability, 1, 10000);
            beeLeggingsDurability = builder.comment("Durability for Bee Leggings").defineInRange("leggings_durability", ArmorDefaults.BEE.leggingsDurability, 1, 10000);
            beeBootsDurability = builder.comment("Durability for Bee Boots").defineInRange("boots_durability", ArmorDefaults.BEE.bootsDurability, 1, 10000);
            beeHelmetProtection = builder.comment("Protection for Bee Helmet").defineInRange("helmet_protection", ArmorDefaults.BEE.helmetProtection, 0, 20);
            beeChestplateProtection = builder.comment("Protection for Bee Chestplate").defineInRange("chestplate_protection", ArmorDefaults.BEE.chestplateProtection, 0, 20);
            beeLeggingsProtection = builder.comment("Protection for Bee Leggings").defineInRange("leggings_protection", ArmorDefaults.BEE.leggingsProtection, 0, 20);
            beeBootsProtection = builder.comment("Protection for Bee Boots").defineInRange("boots_protection", ArmorDefaults.BEE.bootsProtection, 0, 20);
            beeEnchantment = builder.comment("Enchantment value for Bee Armor").defineInRange("enchantment", ArmorDefaults.BEE.enchantment, 0, 30);
            beeToughness = builder.comment("Toughness for Bee Armor").defineInRange("toughness", ArmorDefaults.BEE.toughness, 0.0, 10.0);
            beeKnockbackResistance = builder.comment("Knockback resistance for Bee Armor").defineInRange("knockback_resistance", ArmorDefaults.BEE.knockbackResistance, 0.0, 1.0);
            builder.pop();

            // Bone Armor
            builder.push("bone_armor");
            boneHelmetDurability = builder.comment("Durability for Bone Helmet").defineInRange("helmet_durability", ArmorDefaults.BONE.helmetDurability, 1, 10000);
            boneChestplateDurability = builder.comment("Durability for Bone Chestplate").defineInRange("chestplate_durability", ArmorDefaults.BONE.chestplateDurability, 1, 10000);
            boneLeggingsDurability = builder.comment("Durability for Bone Leggings").defineInRange("leggings_durability", ArmorDefaults.BONE.leggingsDurability, 1, 10000);
            boneBootsDurability = builder.comment("Durability for Bone Boots").defineInRange("boots_durability", ArmorDefaults.BONE.bootsDurability, 1, 10000);
            boneHelmetProtection = builder.comment("Protection for Bone Helmet").defineInRange("helmet_protection", ArmorDefaults.BONE.helmetProtection, 0, 20);
            boneChestplateProtection = builder.comment("Protection for Bone Chestplate").defineInRange("chestplate_protection", ArmorDefaults.BONE.chestplateProtection, 0, 20);
            boneLeggingsProtection = builder.comment("Protection for Bone Leggings").defineInRange("leggings_protection", ArmorDefaults.BONE.leggingsProtection, 0, 20);
            boneBootsProtection = builder.comment("Protection for Bone Boots").defineInRange("boots_protection", ArmorDefaults.BONE.bootsProtection, 0, 20);
            boneEnchantment = builder.comment("Enchantment value for Bone Armor").defineInRange("enchantment", ArmorDefaults.BONE.enchantment, 0, 30);
            boneToughness = builder.comment("Toughness for Bone Armor").defineInRange("toughness", ArmorDefaults.BONE.toughness, 0.0, 10.0);
            boneKnockbackResistance = builder.comment("Knockback resistance for Bone Armor").defineInRange("knockback_resistance", ArmorDefaults.BONE.knockbackResistance, 0.0, 1.0);
            builder.pop();

            // Cactus Armor
            builder.push("cactus_armor");
            cactusHelmetDurability = builder.comment("Durability for Cactus Helmet").defineInRange("helmet_durability", ArmorDefaults.CACTUS.helmetDurability, 1, 10000);
            cactusChestplateDurability = builder.comment("Durability for Cactus Chestplate").defineInRange("chestplate_durability", ArmorDefaults.CACTUS.chestplateDurability, 1, 10000);
            cactusLeggingsDurability = builder.comment("Durability for Cactus Leggings").defineInRange("leggings_durability", ArmorDefaults.CACTUS.leggingsDurability, 1, 10000);
            cactusBootsDurability = builder.comment("Durability for Cactus Boots").defineInRange("boots_durability", ArmorDefaults.CACTUS.bootsDurability, 1, 10000);
            cactusHelmetProtection = builder.comment("Protection for Cactus Helmet").defineInRange("helmet_protection", ArmorDefaults.CACTUS.helmetProtection, 0, 20);
            cactusChestplateProtection = builder.comment("Protection for Cactus Chestplate").defineInRange("chestplate_protection", ArmorDefaults.CACTUS.chestplateProtection, 0, 20);
            cactusLeggingsProtection = builder.comment("Protection for Cactus Leggings").defineInRange("leggings_protection", ArmorDefaults.CACTUS.leggingsProtection, 0, 20);
            cactusBootsProtection = builder.comment("Protection for Cactus Boots").defineInRange("boots_protection", ArmorDefaults.CACTUS.bootsProtection, 0, 20);
            cactusEnchantment = builder.comment("Enchantment value for Cactus Armor").defineInRange("enchantment", ArmorDefaults.CACTUS.enchantment, 0, 30);
            cactusToughness = builder.comment("Toughness for Cactus Armor").defineInRange("toughness", ArmorDefaults.CACTUS.toughness, 0.0, 10.0);
            cactusKnockbackResistance = builder.comment("Knockback resistance for Cactus Armor").defineInRange("knockback_resistance", ArmorDefaults.CACTUS.knockbackResistance, 0.0, 1.0);
            builder.pop();

            // Coal Armor
            builder.push("coal_armor");
            coalHelmetDurability = builder.comment("Durability for Coal Helmet").defineInRange("helmet_durability", ArmorDefaults.COAL.helmetDurability, 1, 10000);
            coalChestplateDurability = builder.comment("Durability for Coal Chestplate").defineInRange("chestplate_durability", ArmorDefaults.COAL.chestplateDurability, 1, 10000);
            coalLeggingsDurability = builder.comment("Durability for Coal Leggings").defineInRange("leggings_durability", ArmorDefaults.COAL.leggingsDurability, 1, 10000);
            coalBootsDurability = builder.comment("Durability for Coal Boots").defineInRange("boots_durability", ArmorDefaults.COAL.bootsDurability, 1, 10000);
            coalHelmetProtection = builder.comment("Protection for Coal Helmet").defineInRange("helmet_protection", ArmorDefaults.COAL.helmetProtection, 0, 20);
            coalChestplateProtection = builder.comment("Protection for Coal Chestplate").defineInRange("chestplate_protection", ArmorDefaults.COAL.chestplateProtection, 0, 20);
            coalLeggingsProtection = builder.comment("Protection for Coal Leggings").defineInRange("leggings_protection", ArmorDefaults.COAL.leggingsProtection, 0, 20);
            coalBootsProtection = builder.comment("Protection for Coal Boots").defineInRange("boots_protection", ArmorDefaults.COAL.bootsProtection, 0, 20);
            coalEnchantment = builder.comment("Enchantment value for Coal Armor").defineInRange("enchantment", ArmorDefaults.COAL.enchantment, 0, 30);
            coalToughness = builder.comment("Toughness for Coal Armor").defineInRange("toughness", ArmorDefaults.COAL.toughness, 0.0, 10.0);
            coalKnockbackResistance = builder.comment("Knockback resistance for Coal Armor").defineInRange("knockback_resistance", ArmorDefaults.COAL.knockbackResistance, 0.0, 1.0);
            builder.pop();

            // Copper Armor
            builder.push("copper_armor");
            copperHelmetDurability = builder.comment("Durability for Copper Helmet").defineInRange("helmet_durability", ArmorDefaults.COPPER.helmetDurability, 1, 10000);
            copperChestplateDurability = builder.comment("Durability for Copper Chestplate").defineInRange("chestplate_durability", ArmorDefaults.COPPER.chestplateDurability, 1, 10000);
            copperLeggingsDurability = builder.comment("Durability for Copper Leggings").defineInRange("leggings_durability", ArmorDefaults.COPPER.leggingsDurability, 1, 10000);
            copperBootsDurability = builder.comment("Durability for Copper Boots").defineInRange("boots_durability", ArmorDefaults.COPPER.bootsDurability, 1, 10000);
            copperHelmetProtection = builder.comment("Protection for Copper Helmet").defineInRange("helmet_protection", ArmorDefaults.COPPER.helmetProtection, 0, 20);
            copperChestplateProtection = builder.comment("Protection for Copper Chestplate").defineInRange("chestplate_protection", ArmorDefaults.COPPER.chestplateProtection, 0, 20);
            copperLeggingsProtection = builder.comment("Protection for Copper Leggings").defineInRange("leggings_protection", ArmorDefaults.COPPER.leggingsProtection, 0, 20);
            copperBootsProtection = builder.comment("Protection for Copper Boots").defineInRange("boots_protection", ArmorDefaults.COPPER.bootsProtection, 0, 20);
            copperEnchantment = builder.comment("Enchantment value for Copper Armor").defineInRange("enchantment", ArmorDefaults.COPPER.enchantment, 0, 30);
            copperToughness = builder.comment("Toughness for Copper Armor").defineInRange("toughness", ArmorDefaults.COPPER.toughness, 0.0, 10.0);
            copperKnockbackResistance = builder.comment("Knockback resistance for Copper Armor").defineInRange("knockback_resistance", ArmorDefaults.COPPER.knockbackResistance, 0.0, 1.0);
            builder.pop();

            // Crafting Armor
            builder.push("crafting_armor");
            craftingHelmetDurability = builder.comment("Durability for Crafting Helmet").defineInRange("helmet_durability", ArmorDefaults.CRAFTING.helmetDurability, 1, 10000);
            craftingChestplateDurability = builder.comment("Durability for Crafting Chestplate").defineInRange("chestplate_durability", ArmorDefaults.CRAFTING.chestplateDurability, 1, 10000);
            craftingLeggingsDurability = builder.comment("Durability for Crafting Leggings").defineInRange("leggings_durability", ArmorDefaults.CRAFTING.leggingsDurability, 1, 10000);
            craftingBootsDurability = builder.comment("Durability for Crafting Boots").defineInRange("boots_durability", ArmorDefaults.CRAFTING.bootsDurability, 1, 10000);
            craftingHelmetProtection = builder.comment("Protection for Crafting Helmet").defineInRange("helmet_protection", ArmorDefaults.CRAFTING.helmetProtection, 0, 20);
            craftingChestplateProtection = builder.comment("Protection for Crafting Chestplate").defineInRange("chestplate_protection", ArmorDefaults.CRAFTING.chestplateProtection, 0, 20);
            craftingLeggingsProtection = builder.comment("Protection for Crafting Leggings").defineInRange("leggings_protection", ArmorDefaults.CRAFTING.leggingsProtection, 0, 20);
            craftingBootsProtection = builder.comment("Protection for Crafting Boots").defineInRange("boots_protection", ArmorDefaults.CRAFTING.bootsProtection, 0, 20);
            craftingEnchantment = builder.comment("Enchantment value for Crafting Armor").defineInRange("enchantment", ArmorDefaults.CRAFTING.enchantment, 0, 30);
            craftingToughness = builder.comment("Toughness for Crafting Armor").defineInRange("toughness", ArmorDefaults.CRAFTING.toughness, 0.0, 10.0);
            craftingKnockbackResistance = builder.comment("Knockback resistance for Crafting Armor").defineInRange("knockback_resistance", ArmorDefaults.CRAFTING.knockbackResistance, 0.0, 1.0);
            builder.pop();

            // Dripstone Armor
            builder.push("dripstone_armor");
            dripstoneHelmetDurability = builder.comment("Durability for Dripstone Helmet").defineInRange("helmet_durability", ArmorDefaults.DRIPSTONE.helmetDurability, 1, 10000);
            dripstoneChestplateDurability = builder.comment("Durability for Dripstone Chestplate").defineInRange("chestplate_durability", ArmorDefaults.DRIPSTONE.chestplateDurability, 1, 10000);
            dripstoneLeggingsDurability = builder.comment("Durability for Dripstone Leggings").defineInRange("leggings_durability", ArmorDefaults.DRIPSTONE.leggingsDurability, 1, 10000);
            dripstoneBootsDurability = builder.comment("Durability for Dripstone Boots").defineInRange("boots_durability", ArmorDefaults.DRIPSTONE.bootsDurability, 1, 10000);
            dripstoneHelmetProtection = builder.comment("Protection for Dripstone Helmet").defineInRange("helmet_protection", ArmorDefaults.DRIPSTONE.helmetProtection, 0, 20);
            dripstoneChestplateProtection = builder.comment("Protection for Dripstone Chestplate").defineInRange("chestplate_protection", ArmorDefaults.DRIPSTONE.chestplateProtection, 0, 20);
            dripstoneLeggingsProtection = builder.comment("Protection for Dripstone Leggings").defineInRange("leggings_protection", ArmorDefaults.DRIPSTONE.leggingsProtection, 0, 20);
            dripstoneBootsProtection = builder.comment("Protection for Dripstone Boots").defineInRange("boots_protection", ArmorDefaults.DRIPSTONE.bootsProtection, 0, 20);
            dripstoneEnchantment = builder.comment("Enchantment value for Dripstone Armor").defineInRange("enchantment", ArmorDefaults.DRIPSTONE.enchantment, 0, 30);
            dripstoneToughness = builder.comment("Toughness for Dripstone Armor").defineInRange("toughness", ArmorDefaults.DRIPSTONE.toughness, 0.0, 10.0);
            dripstoneKnockbackResistance = builder.comment("Knockback resistance for Dripstone Armor").defineInRange("knockback_resistance", ArmorDefaults.DRIPSTONE.knockbackResistance, 0.0, 1.0);
            builder.pop();

            // Emerald Armor
            builder.push("emerald_armor");
            emeraldHelmetDurability = builder.comment("Durability for Emerald Helmet").defineInRange("helmet_durability", ArmorDefaults.EMERALD.helmetDurability, 1, 10000);
            emeraldChestplateDurability = builder.comment("Durability for Emerald Chestplate").defineInRange("chestplate_durability", ArmorDefaults.EMERALD.chestplateDurability, 1, 10000);
            emeraldLeggingsDurability = builder.comment("Durability for Emerald Leggings").defineInRange("leggings_durability", ArmorDefaults.EMERALD.leggingsDurability, 1, 10000);
            emeraldBootsDurability = builder.comment("Durability for Emerald Boots").defineInRange("boots_durability", ArmorDefaults.EMERALD.bootsDurability, 1, 10000);
            emeraldHelmetProtection = builder.comment("Protection for Emerald Helmet").defineInRange("helmet_protection", ArmorDefaults.EMERALD.helmetProtection, 0, 20);
            emeraldChestplateProtection = builder.comment("Protection for Emerald Chestplate").defineInRange("chestplate_protection", ArmorDefaults.EMERALD.chestplateProtection, 0, 20);
            emeraldLeggingsProtection = builder.comment("Protection for Emerald Leggings").defineInRange("leggings_protection", ArmorDefaults.EMERALD.leggingsProtection, 0, 20);
            emeraldBootsProtection = builder.comment("Protection for Emerald Boots").defineInRange("boots_protection", ArmorDefaults.EMERALD.bootsProtection, 0, 20);
            emeraldEnchantment = builder.comment("Enchantment value for Emerald Armor").defineInRange("enchantment", ArmorDefaults.EMERALD.enchantment, 0, 30);
            emeraldToughness = builder.comment("Toughness for Emerald Armor").defineInRange("toughness", ArmorDefaults.EMERALD.toughness, 0.0, 10.0);
            emeraldKnockbackResistance = builder.comment("Knockback resistance for Emerald Armor").defineInRange("knockback_resistance", ArmorDefaults.EMERALD.knockbackResistance, 0.0, 1.0);
            builder.pop();

            // Ender Dragon Armor
            builder.push("ender_dragon_armor");
            enderDragonHelmetDurability = builder.comment("Durability for Ender Dragon Helmet").defineInRange("helmet_durability", ArmorDefaults.ENDER_DRAGON.helmetDurability, 1, 10000);
            enderDragonChestplateDurability = builder.comment("Durability for Ender Dragon Chestplate").defineInRange("chestplate_durability", ArmorDefaults.ENDER_DRAGON.chestplateDurability, 1, 10000);
            enderDragonLeggingsDurability = builder.comment("Durability for Ender Dragon Leggings").defineInRange("leggings_durability", ArmorDefaults.ENDER_DRAGON.leggingsDurability, 1, 10000);
            enderDragonBootsDurability = builder.comment("Durability for Ender Dragon Boots").defineInRange("boots_durability", ArmorDefaults.ENDER_DRAGON.bootsDurability, 1, 10000);
            enderDragonHelmetProtection = builder.comment("Protection for Ender Dragon Helmet").defineInRange("helmet_protection", ArmorDefaults.ENDER_DRAGON.helmetProtection, 0, 20);
            enderDragonChestplateProtection = builder.comment("Protection for Ender Dragon Chestplate").defineInRange("chestplate_protection", ArmorDefaults.ENDER_DRAGON.chestplateProtection, 0, 20);
            enderDragonLeggingsProtection = builder.comment("Protection for Ender Dragon Leggings").defineInRange("leggings_protection", ArmorDefaults.ENDER_DRAGON.leggingsProtection, 0, 20);
            enderDragonBootsProtection = builder.comment("Protection for Ender Dragon Boots").defineInRange("boots_protection", ArmorDefaults.ENDER_DRAGON.bootsProtection, 0, 20);
            enderDragonEnchantment = builder.comment("Enchantment value for Ender Dragon Armor").defineInRange("enchantment", ArmorDefaults.ENDER_DRAGON.enchantment, 0, 30);
            enderDragonToughness = builder.comment("Toughness for Ender Dragon Armor").defineInRange("toughness", ArmorDefaults.ENDER_DRAGON.toughness, 0.0, 10.0);
            enderDragonKnockbackResistance = builder.comment("Knockback resistance for Ender Dragon Armor").defineInRange("knockback_resistance", ArmorDefaults.ENDER_DRAGON.knockbackResistance, 0.0, 1.0);
            builder.pop();

            // Galaxy Armor
            builder.push("galaxy_armor");
            galaxyHelmetDurability = builder.comment("Durability for Galaxy Helmet").defineInRange("helmet_durability", ArmorDefaults.GALAXY.helmetDurability, 1, 10000);
            galaxyChestplateDurability = builder.comment("Durability for Galaxy Chestplate").defineInRange("chestplate_durability", ArmorDefaults.GALAXY.chestplateDurability, 1, 10000);
            galaxyLeggingsDurability = builder.comment("Durability for Galaxy Leggings").defineInRange("leggings_durability", ArmorDefaults.GALAXY.leggingsDurability, 1, 10000);
            galaxyBootsDurability = builder.comment("Durability for Galaxy Boots").defineInRange("boots_durability", ArmorDefaults.GALAXY.bootsDurability, 1, 10000);
            galaxyHelmetProtection = builder.comment("Protection for Galaxy Helmet").defineInRange("helmet_protection", ArmorDefaults.GALAXY.helmetProtection, 0, 20);
            galaxyChestplateProtection = builder.comment("Protection for Galaxy Chestplate").defineInRange("chestplate_protection", ArmorDefaults.GALAXY.chestplateProtection, 0, 20);
            galaxyLeggingsProtection = builder.comment("Protection for Galaxy Leggings").defineInRange("leggings_protection", ArmorDefaults.GALAXY.leggingsProtection, 0, 20);
            galaxyBootsProtection = builder.comment("Protection for Galaxy Boots").defineInRange("boots_protection", ArmorDefaults.GALAXY.bootsProtection, 0, 20);
            galaxyEnchantment = builder.comment("Enchantment value for Galaxy Armor").defineInRange("enchantment", ArmorDefaults.GALAXY.enchantment, 0, 30);
            galaxyToughness = builder.comment("Toughness for Galaxy Armor").defineInRange("toughness", ArmorDefaults.GALAXY.toughness, 0.0, 10.0);
            galaxyKnockbackResistance = builder.comment("Knockback resistance for Galaxy Armor").defineInRange("knockback_resistance", ArmorDefaults.GALAXY.knockbackResistance, 0.0, 1.0);
            builder.pop();

            // Gilded Armor
            builder.push("gilded_armor");
            gildedHelmetDurability = builder.comment("Durability for Gilded Helmet").defineInRange("helmet_durability", ArmorDefaults.GILDED.helmetDurability, 1, 10000);
            gildedChestplateDurability = builder.comment("Durability for Gilded Chestplate").defineInRange("chestplate_durability", ArmorDefaults.GILDED.chestplateDurability, 1, 10000);
            gildedLeggingsDurability = builder.comment("Durability for Gilded Leggings").defineInRange("leggings_durability", ArmorDefaults.GILDED.leggingsDurability, 1, 10000);
            gildedBootsDurability = builder.comment("Durability for Gilded Boots").defineInRange("boots_durability", ArmorDefaults.GILDED.bootsDurability, 1, 10000);
            gildedHelmetProtection = builder.comment("Protection for Gilded Helmet").defineInRange("helmet_protection", ArmorDefaults.GILDED.helmetProtection, 0, 20);
            gildedChestplateProtection = builder.comment("Protection for Gilded Chestplate").defineInRange("chestplate_protection", ArmorDefaults.GILDED.chestplateProtection, 0, 20);
            gildedLeggingsProtection = builder.comment("Protection for Gilded Leggings").defineInRange("leggings_protection", ArmorDefaults.GILDED.leggingsProtection, 0, 20);
            gildedBootsProtection = builder.comment("Protection for Gilded Boots").defineInRange("boots_protection", ArmorDefaults.GILDED.bootsProtection, 0, 20);
            gildedEnchantment = builder.comment("Enchantment value for Gilded Armor").defineInRange("enchantment", ArmorDefaults.GILDED.enchantment, 0, 30);
            gildedToughness = builder.comment("Toughness for Gilded Armor").defineInRange("toughness", ArmorDefaults.GILDED.toughness, 0.0, 10.0);
            gildedKnockbackResistance = builder.comment("Knockback resistance for Gilded Armor").defineInRange("knockback_resistance", ArmorDefaults.GILDED.knockbackResistance, 0.0, 1.0);
            builder.pop();

            // Glass Armor
            builder.push("glass_armor");
            glassHelmetDurability = builder.comment("Durability for Glass Helmet").defineInRange("helmet_durability", ArmorDefaults.GLASS.helmetDurability, 1, 10000);
            glassChestplateDurability = builder.comment("Durability for Glass Chestplate").defineInRange("chestplate_durability", ArmorDefaults.GLASS.chestplateDurability, 1, 10000);
            glassLeggingsDurability = builder.comment("Durability for Glass Leggings").defineInRange("leggings_durability", ArmorDefaults.GLASS.leggingsDurability, 1, 10000);
            glassBootsDurability = builder.comment("Durability for Glass Boots").defineInRange("boots_durability", ArmorDefaults.GLASS.bootsDurability, 1, 10000);
            glassHelmetProtection = builder.comment("Protection for Glass Helmet").defineInRange("helmet_protection", ArmorDefaults.GLASS.helmetProtection, 0, 20);
            glassChestplateProtection = builder.comment("Protection for Glass Chestplate").defineInRange("chestplate_protection", ArmorDefaults.GLASS.chestplateProtection, 0, 20);
            glassLeggingsProtection = builder.comment("Protection for Glass Leggings").defineInRange("leggings_protection", ArmorDefaults.GLASS.leggingsProtection, 0, 20);
            glassBootsProtection = builder.comment("Protection for Glass Boots").defineInRange("boots_protection", ArmorDefaults.GLASS.bootsProtection, 0, 20);
            glassEnchantment = builder.comment("Enchantment value for Glass Armor").defineInRange("enchantment", ArmorDefaults.GLASS.enchantment, 0, 30);
            glassToughness = builder.comment("Toughness for Glass Armor").defineInRange("toughness", ArmorDefaults.GLASS.toughness, 0.0, 10.0);
            glassKnockbackResistance = builder.comment("Knockback resistance for Glass Armor").defineInRange("knockback_resistance", ArmorDefaults.GLASS.knockbackResistance, 0.0, 1.0);
            builder.pop();

            // Guardian Armor
            builder.push("guardian_armor");
            guardianHelmetDurability = builder.comment("Durability for Guardian Helmet").defineInRange("helmet_durability", ArmorDefaults.GUARDIAN.helmetDurability, 1, 10000);
            guardianChestplateDurability = builder.comment("Durability for Guardian Chestplate").defineInRange("chestplate_durability", ArmorDefaults.GUARDIAN.chestplateDurability, 1, 10000);
            guardianLeggingsDurability = builder.comment("Durability for Guardian Leggings").defineInRange("leggings_durability", ArmorDefaults.GUARDIAN.leggingsDurability, 1, 10000);
            guardianBootsDurability = builder.comment("Durability for Guardian Boots").defineInRange("boots_durability", ArmorDefaults.GUARDIAN.bootsDurability, 1, 10000);
            guardianHelmetProtection = builder.comment("Protection for Guardian Helmet").defineInRange("helmet_protection", ArmorDefaults.GUARDIAN.helmetProtection, 0, 20);
            guardianChestplateProtection = builder.comment("Protection for Guardian Chestplate").defineInRange("chestplate_protection", ArmorDefaults.GUARDIAN.chestplateProtection, 0, 20);
            guardianLeggingsProtection = builder.comment("Protection for Guardian Leggings").defineInRange("leggings_protection", ArmorDefaults.GUARDIAN.leggingsProtection, 0, 20);
            guardianBootsProtection = builder.comment("Protection for Guardian Boots").defineInRange("boots_protection", ArmorDefaults.GUARDIAN.bootsProtection, 0, 20);
            guardianEnchantment = builder.comment("Enchantment value for Guardian Armor").defineInRange("enchantment", ArmorDefaults.GUARDIAN.enchantment, 0, 30);
            guardianToughness = builder.comment("Toughness for Guardian Armor").defineInRange("toughness", ArmorDefaults.GUARDIAN.toughness, 0.0, 10.0);
            guardianKnockbackResistance = builder.comment("Knockback resistance for Guardian Armor").defineInRange("knockback_resistance", ArmorDefaults.GUARDIAN.knockbackResistance, 0.0, 1.0);
            builder.pop();

            // Lapis Armor
            builder.push("lapis_armor");
            lapisHelmetDurability = builder.comment("Durability for Lapis Helmet").defineInRange("helmet_durability", ArmorDefaults.LAPIS.helmetDurability, 1, 10000);
            lapisChestplateDurability = builder.comment("Durability for Lapis Chestplate").defineInRange("chestplate_durability", ArmorDefaults.LAPIS.chestplateDurability, 1, 10000);
            lapisLeggingsDurability = builder.comment("Durability for Lapis Leggings").defineInRange("leggings_durability", ArmorDefaults.LAPIS.leggingsDurability, 1, 10000);
            lapisBootsDurability = builder.comment("Durability for Lapis Boots").defineInRange("boots_durability", ArmorDefaults.LAPIS.bootsDurability, 1, 10000);
            lapisHelmetProtection = builder.comment("Protection for Lapis Helmet").defineInRange("helmet_protection", ArmorDefaults.LAPIS.helmetProtection, 0, 20);
            lapisChestplateProtection = builder.comment("Protection for Lapis Chestplate").defineInRange("chestplate_protection", ArmorDefaults.LAPIS.chestplateProtection, 0, 20);
            lapisLeggingsProtection = builder.comment("Protection for Lapis Leggings").defineInRange("leggings_protection", ArmorDefaults.LAPIS.leggingsProtection, 0, 20);
            lapisBootsProtection = builder.comment("Protection for Lapis Boots").defineInRange("boots_protection", ArmorDefaults.LAPIS.bootsProtection, 0, 20);
            lapisEnchantment = builder.comment("Enchantment value for Lapis Armor").defineInRange("enchantment", ArmorDefaults.LAPIS.enchantment, 0, 30);
            lapisToughness = builder.comment("Toughness for Lapis Armor").defineInRange("toughness", ArmorDefaults.LAPIS.toughness, 0.0, 10.0);
            lapisKnockbackResistance = builder.comment("Knockback resistance for Lapis Armor").defineInRange("knockback_resistance", ArmorDefaults.LAPIS.knockbackResistance, 0.0, 1.0);
            builder.pop();

            // Machine Armor
            builder.push("machine_armor");
            machineHelmetDurability = builder.comment("Durability for Machine Helmet").defineInRange("helmet_durability", ArmorDefaults.MACHINE.helmetDurability, 1, 10000);
            machineChestplateDurability = builder.comment("Durability for Machine Chestplate").defineInRange("chestplate_durability", ArmorDefaults.MACHINE.chestplateDurability, 1, 10000);
            machineLeggingsDurability = builder.comment("Durability for Machine Leggings").defineInRange("leggings_durability", ArmorDefaults.MACHINE.leggingsDurability, 1, 10000);
            machineBootsDurability = builder.comment("Durability for Machine Boots").defineInRange("boots_durability", ArmorDefaults.MACHINE.bootsDurability, 1, 10000);
            machineHelmetProtection = builder.comment("Protection for Machine Helmet").defineInRange("helmet_protection", ArmorDefaults.MACHINE.helmetProtection, 0, 20);
            machineChestplateProtection = builder.comment("Protection for Machine Chestplate").defineInRange("chestplate_protection", ArmorDefaults.MACHINE.chestplateProtection, 0, 20);
            machineLeggingsProtection = builder.comment("Protection for Machine Leggings").defineInRange("leggings_protection", ArmorDefaults.MACHINE.leggingsProtection, 0, 20);
            machineBootsProtection = builder.comment("Protection for Machine Boots").defineInRange("boots_protection", ArmorDefaults.MACHINE.bootsProtection, 0, 20);
            machineEnchantment = builder.comment("Enchantment value for Machine Armor").defineInRange("enchantment", ArmorDefaults.MACHINE.enchantment, 0, 30);
            machineToughness = builder.comment("Toughness for Machine Armor").defineInRange("toughness", ArmorDefaults.MACHINE.toughness, 0.0, 10.0);
            machineKnockbackResistance = builder.comment("Knockback resistance for Machine Armor").defineInRange("knockback_resistance", ArmorDefaults.MACHINE.knockbackResistance, 0.0, 1.0);
            builder.pop();

            // Magma Armor
            builder.push("magma_armor");
            magmaHelmetDurability = builder.comment("Durability for Magma Helmet").defineInRange("helmet_durability", ArmorDefaults.MAGMA.helmetDurability, 1, 10000);
            magmaChestplateDurability = builder.comment("Durability for Magma Chestplate").defineInRange("chestplate_durability", ArmorDefaults.MAGMA.chestplateDurability, 1, 10000);
            magmaLeggingsDurability = builder.comment("Durability for Magma Leggings").defineInRange("leggings_durability", ArmorDefaults.MAGMA.leggingsDurability, 1, 10000);
            magmaBootsDurability = builder.comment("Durability for Magma Boots").defineInRange("boots_durability", ArmorDefaults.MAGMA.bootsDurability, 1, 10000);
            magmaHelmetProtection = builder.comment("Protection for Magma Helmet").defineInRange("helmet_protection", ArmorDefaults.MAGMA.helmetProtection, 0, 20);
            magmaChestplateProtection = builder.comment("Protection for Magma Chestplate").defineInRange("chestplate_protection", ArmorDefaults.MAGMA.chestplateProtection, 0, 20);
            magmaLeggingsProtection = builder.comment("Protection for Magma Leggings").defineInRange("leggings_protection", ArmorDefaults.MAGMA.leggingsProtection, 0, 20);
            magmaBootsProtection = builder.comment("Protection for Magma Boots").defineInRange("boots_protection", ArmorDefaults.MAGMA.bootsProtection, 0, 20);
            magmaEnchantment = builder.comment("Enchantment value for Magma Armor").defineInRange("enchantment", ArmorDefaults.MAGMA.enchantment, 0, 30);
            magmaToughness = builder.comment("Toughness for Magma Armor").defineInRange("toughness", ArmorDefaults.MAGMA.toughness, 0.0, 10.0);
            magmaKnockbackResistance = builder.comment("Knockback resistance for Magma Armor").defineInRange("knockback_resistance", ArmorDefaults.MAGMA.knockbackResistance, 0.0, 1.0);
            builder.pop();

            // Music Armor
            builder.push("music_armor");
            musicHelmetDurability = builder.comment("Durability for Music Helmet").defineInRange("helmet_durability", ArmorDefaults.MUSIC.helmetDurability, 1, 10000);
            musicChestplateDurability = builder.comment("Durability for Music Chestplate").defineInRange("chestplate_durability", ArmorDefaults.MUSIC.chestplateDurability, 1, 10000);
            musicLeggingsDurability = builder.comment("Durability for Music Leggings").defineInRange("leggings_durability", ArmorDefaults.MUSIC.leggingsDurability, 1, 10000);
            musicBootsDurability = builder.comment("Durability for Music Boots").defineInRange("boots_durability", ArmorDefaults.MUSIC.bootsDurability, 1, 10000);
            musicHelmetProtection = builder.comment("Protection for Music Helmet").defineInRange("helmet_protection", ArmorDefaults.MUSIC.helmetProtection, 0, 20);
            musicChestplateProtection = builder.comment("Protection for Music Chestplate").defineInRange("chestplate_protection", ArmorDefaults.MUSIC.chestplateProtection, 0, 20);
            musicLeggingsProtection = builder.comment("Protection for Music Leggings").defineInRange("leggings_protection", ArmorDefaults.MUSIC.leggingsProtection, 0, 20);
            musicBootsProtection = builder.comment("Protection for Music Boots").defineInRange("boots_protection", ArmorDefaults.MUSIC.bootsProtection, 0, 20);
            musicEnchantment = builder.comment("Enchantment value for Music Armor").defineInRange("enchantment", ArmorDefaults.MUSIC.enchantment, 0, 30);
            musicToughness = builder.comment("Toughness for Music Armor").defineInRange("toughness", ArmorDefaults.MUSIC.toughness, 0.0, 10.0);
            musicKnockbackResistance = builder.comment("Knockback resistance for Music Armor").defineInRange("knockback_resistance", ArmorDefaults.MUSIC.knockbackResistance, 0.0, 1.0);
            builder.pop();

            // Obsidian Armor
            builder.push("obsidian_armor");
            obsidianHelmetDurability = builder.comment("Durability for Obsidian Helmet").defineInRange("helmet_durability", ArmorDefaults.OBSIDIAN.helmetDurability, 1, 10000);
            obsidianChestplateDurability = builder.comment("Durability for Obsidian Chestplate").defineInRange("chestplate_durability", ArmorDefaults.OBSIDIAN.chestplateDurability, 1, 10000);
            obsidianLeggingsDurability = builder.comment("Durability for Obsidian Leggings").defineInRange("leggings_durability", ArmorDefaults.OBSIDIAN.leggingsDurability, 1, 10000);
            obsidianBootsDurability = builder.comment("Durability for Obsidian Boots").defineInRange("boots_durability", ArmorDefaults.OBSIDIAN.bootsDurability, 1, 10000);
            obsidianHelmetProtection = builder.comment("Protection for Obsidian Helmet").defineInRange("helmet_protection", ArmorDefaults.OBSIDIAN.helmetProtection, 0, 20);
            obsidianChestplateProtection = builder.comment("Protection for Obsidian Chestplate").defineInRange("chestplate_protection", ArmorDefaults.OBSIDIAN.chestplateProtection, 0, 20);
            obsidianLeggingsProtection = builder.comment("Protection for Obsidian Leggings").defineInRange("leggings_protection", ArmorDefaults.OBSIDIAN.leggingsProtection, 0, 20);
            obsidianBootsProtection = builder.comment("Protection for Obsidian Boots").defineInRange("boots_protection", ArmorDefaults.OBSIDIAN.bootsProtection, 0, 20);
            obsidianEnchantment = builder.comment("Enchantment value for Obsidian Armor").defineInRange("enchantment", ArmorDefaults.OBSIDIAN.enchantment, 0, 30);
            obsidianToughness = builder.comment("Toughness for Obsidian Armor").defineInRange("toughness", ArmorDefaults.OBSIDIAN.toughness, 0.0, 10.0);
            obsidianKnockbackResistance = builder.comment("Knockback resistance for Obsidian Armor").defineInRange("knockback_resistance", ArmorDefaults.OBSIDIAN.knockbackResistance, 0.0, 1.0);
            builder.pop();

            // Pot Armor
            builder.push("pot_armor");
            potHelmetDurability = builder.comment("Durability for Pot Helmet").defineInRange("helmet_durability", ArmorDefaults.POT.helmetDurability, 1, 10000);
            potChestplateDurability = builder.comment("Durability for Pot Chestplate").defineInRange("chestplate_durability", ArmorDefaults.POT.chestplateDurability, 1, 10000);
            potLeggingsDurability = builder.comment("Durability for Pot Leggings").defineInRange("leggings_durability", ArmorDefaults.POT.leggingsDurability, 1, 10000);
            potBootsDurability = builder.comment("Durability for Pot Boots").defineInRange("boots_durability", ArmorDefaults.POT.bootsDurability, 1, 10000);
            potHelmetProtection = builder.comment("Protection for Pot Helmet").defineInRange("helmet_protection", ArmorDefaults.POT.helmetProtection, 0, 20);
            potChestplateProtection = builder.comment("Protection for Pot Chestplate").defineInRange("chestplate_protection", ArmorDefaults.POT.chestplateProtection, 0, 20);
            potLeggingsProtection = builder.comment("Protection for Pot Leggings").defineInRange("leggings_protection", ArmorDefaults.POT.leggingsProtection, 0, 20);
            potBootsProtection = builder.comment("Protection for Pot Boots").defineInRange("boots_protection", ArmorDefaults.POT.bootsProtection, 0, 20);
            potEnchantment = builder.comment("Enchantment value for Pot Armor").defineInRange("enchantment", ArmorDefaults.POT.enchantment, 0, 30);
            potToughness = builder.comment("Toughness for Pot Armor").defineInRange("toughness", ArmorDefaults.POT.toughness, 0.0, 10.0);
            potKnockbackResistance = builder.comment("Knockback resistance for Pot Armor").defineInRange("knockback_resistance", ArmorDefaults.POT.knockbackResistance, 0.0, 1.0);
            builder.pop();

            // Power Suit Armor
            builder.push("power_suit_armor");
            powerSuitHelmetDurability = builder.comment("Durability for Power Suit Helmet").defineInRange("helmet_durability", ArmorDefaults.POWER_SUIT.helmetDurability, 1, 10000);
            powerSuitChestplateDurability = builder.comment("Durability for Power Suit Chestplate").defineInRange("chestplate_durability", ArmorDefaults.POWER_SUIT.chestplateDurability, 1, 10000);
            powerSuitLeggingsDurability = builder.comment("Durability for Power Suit Leggings").defineInRange("leggings_durability", ArmorDefaults.POWER_SUIT.leggingsDurability, 1, 10000);
            powerSuitBootsDurability = builder.comment("Durability for Power Suit Boots").defineInRange("boots_durability", ArmorDefaults.POWER_SUIT.bootsDurability, 1, 10000);
            powerSuitHelmetProtection = builder.comment("Protection for Power Suit Helmet").defineInRange("helmet_protection", ArmorDefaults.POWER_SUIT.helmetProtection, 0, 20);
            powerSuitChestplateProtection = builder.comment("Protection for Power Suit Chestplate").defineInRange("chestplate_protection", ArmorDefaults.POWER_SUIT.chestplateProtection, 0, 20);
            powerSuitLeggingsProtection = builder.comment("Protection for Power Suit Leggings").defineInRange("leggings_protection", ArmorDefaults.POWER_SUIT.leggingsProtection, 0, 20);
            powerSuitBootsProtection = builder.comment("Protection for Power Suit Boots").defineInRange("boots_protection", ArmorDefaults.POWER_SUIT.bootsProtection, 0, 20);
            powerSuitEnchantment = builder.comment("Enchantment value for Power Suit Armor").defineInRange("enchantment", ArmorDefaults.POWER_SUIT.enchantment, 0, 30);
            powerSuitToughness = builder.comment("Toughness for Power Suit Armor").defineInRange("toughness", ArmorDefaults.POWER_SUIT.toughness, 0.0, 10.0);
            powerSuitKnockbackResistance = builder.comment("Knockback resistance for Power Suit Armor").defineInRange("knockback_resistance", ArmorDefaults.POWER_SUIT.knockbackResistance, 0.0, 1.0);
            builder.pop();

            // Quartz Armor
            builder.push("quartz_armor");
            quartzHelmetDurability = builder.comment("Durability for Quartz Helmet").defineInRange("helmet_durability", ArmorDefaults.QUARTZ.helmetDurability, 1, 10000);
            quartzChestplateDurability = builder.comment("Durability for Quartz Chestplate").defineInRange("chestplate_durability", ArmorDefaults.QUARTZ.chestplateDurability, 1, 10000);
            quartzLeggingsDurability = builder.comment("Durability for Quartz Leggings").defineInRange("leggings_durability", ArmorDefaults.QUARTZ.leggingsDurability, 1, 10000);
            quartzBootsDurability = builder.comment("Durability for Quartz Boots").defineInRange("boots_durability", ArmorDefaults.QUARTZ.bootsDurability, 1, 10000);
            quartzHelmetProtection = builder.comment("Protection for Quartz Helmet").defineInRange("helmet_protection", ArmorDefaults.QUARTZ.helmetProtection, 0, 20);
            quartzChestplateProtection = builder.comment("Protection for Quartz Chestplate").defineInRange("chestplate_protection", ArmorDefaults.QUARTZ.chestplateProtection, 0, 20);
            quartzLeggingsProtection = builder.comment("Protection for Quartz Leggings").defineInRange("leggings_protection", ArmorDefaults.QUARTZ.leggingsProtection, 0, 20);
            quartzBootsProtection = builder.comment("Protection for Quartz Boots").defineInRange("boots_protection", ArmorDefaults.QUARTZ.bootsProtection, 0, 20);
            quartzEnchantment = builder.comment("Enchantment value for Quartz Armor").defineInRange("enchantment", ArmorDefaults.QUARTZ.enchantment, 0, 30);
            quartzToughness = builder.comment("Toughness for Quartz Armor").defineInRange("toughness", ArmorDefaults.QUARTZ.toughness, 0.0, 10.0);
            quartzKnockbackResistance = builder.comment("Knockback resistance for Quartz Armor").defineInRange("knockback_resistance", ArmorDefaults.QUARTZ.knockbackResistance, 0.0, 1.0);
            builder.pop();

            // Red Dragon Armor
            builder.push("red_dragon_armor");
            redDragonHelmetDurability = builder.comment("Durability for Red Dragon Helmet").defineInRange("helmet_durability", ArmorDefaults.RED_DRAGON.helmetDurability, 1, 10000);
            redDragonChestplateDurability = builder.comment("Durability for Red Dragon Chestplate").defineInRange("chestplate_durability", ArmorDefaults.RED_DRAGON.chestplateDurability, 1, 10000);
            redDragonLeggingsDurability = builder.comment("Durability for Red Dragon Leggings").defineInRange("leggings_durability", ArmorDefaults.RED_DRAGON.leggingsDurability, 1, 10000);
            redDragonBootsDurability = builder.comment("Durability for Red Dragon Boots").defineInRange("boots_durability", ArmorDefaults.RED_DRAGON.bootsDurability, 1, 10000);
            redDragonHelmetProtection = builder.comment("Protection for Red Dragon Helmet").defineInRange("helmet_protection", ArmorDefaults.RED_DRAGON.helmetProtection, 0, 20);
            redDragonChestplateProtection = builder.comment("Protection for Red Dragon Chestplate").defineInRange("chestplate_protection", ArmorDefaults.RED_DRAGON.chestplateProtection, 0, 20);
            redDragonLeggingsProtection = builder.comment("Protection for Red Dragon Leggings").defineInRange("leggings_protection", ArmorDefaults.RED_DRAGON.leggingsProtection, 0, 20);
            redDragonBootsProtection = builder.comment("Protection for Red Dragon Boots").defineInRange("boots_protection", ArmorDefaults.RED_DRAGON.bootsProtection, 0, 20);
            redDragonEnchantment = builder.comment("Enchantment value for Red Dragon Armor").defineInRange("enchantment", ArmorDefaults.RED_DRAGON.enchantment, 0, 30);
            redDragonToughness = builder.comment("Toughness for Red Dragon Armor").defineInRange("toughness", ArmorDefaults.RED_DRAGON.toughness, 0.0, 10.0);
            redDragonKnockbackResistance = builder.comment("Knockback resistance for Red Dragon Armor").defineInRange("knockback_resistance", ArmorDefaults.RED_DRAGON.knockbackResistance, 0.0, 1.0);
            builder.pop();

            // Redstone Armor
            builder.push("redstone_armor");
            redstoneHelmetDurability = builder.comment("Durability for Redstone Helmet").defineInRange("helmet_durability", ArmorDefaults.REDSTONE.helmetDurability, 1, 10000);
            redstoneChestplateDurability = builder.comment("Durability for Redstone Chestplate").defineInRange("chestplate_durability", ArmorDefaults.REDSTONE.chestplateDurability, 1, 10000);
            redstoneLeggingsDurability = builder.comment("Durability for Redstone Leggings").defineInRange("leggings_durability", ArmorDefaults.REDSTONE.leggingsDurability, 1, 10000);
            redstoneBootsDurability = builder.comment("Durability for Redstone Boots").defineInRange("boots_durability", ArmorDefaults.REDSTONE.bootsDurability, 1, 10000);
            redstoneHelmetProtection = builder.comment("Protection for Redstone Helmet").defineInRange("helmet_protection", ArmorDefaults.REDSTONE.helmetProtection, 0, 20);
            redstoneChestplateProtection = builder.comment("Protection for Redstone Chestplate").defineInRange("chestplate_protection", ArmorDefaults.REDSTONE.chestplateProtection, 0, 20);
            redstoneLeggingsProtection = builder.comment("Protection for Redstone Leggings").defineInRange("leggings_protection", ArmorDefaults.REDSTONE.leggingsProtection, 0, 20);
            redstoneBootsProtection = builder.comment("Protection for Redstone Boots").defineInRange("boots_protection", ArmorDefaults.REDSTONE.bootsProtection, 0, 20);
            redstoneEnchantment = builder.comment("Enchantment value for Redstone Armor").defineInRange("enchantment", ArmorDefaults.REDSTONE.enchantment, 0, 30);
            redstoneToughness = builder.comment("Toughness for Redstone Armor").defineInRange("toughness", ArmorDefaults.REDSTONE.toughness, 0.0, 10.0);
            redstoneKnockbackResistance = builder.comment("Knockback resistance for Redstone Armor").defineInRange("knockback_resistance", ArmorDefaults.REDSTONE.knockbackResistance, 0.0, 1.0);
            builder.pop();

            // Reinforced Deepslate Armor
            builder.push("reinforced_deepslate_armor");
            reinforcedDeepslateHelmetDurability = builder.comment("Durability for Reinforced Deepslate Helmet").defineInRange("helmet_durability", ArmorDefaults.REINFORCED_DEEPSLATE.helmetDurability, 1, 10000);
            reinforcedDeepslateChestplateDurability = builder.comment("Durability for Reinforced Deepslate Chestplate").defineInRange("chestplate_durability", ArmorDefaults.REINFORCED_DEEPSLATE.chestplateDurability, 1, 10000);
            reinforcedDeepslateLeggingsDurability = builder.comment("Durability for Reinforced Deepslate Leggings").defineInRange("leggings_durability", ArmorDefaults.REINFORCED_DEEPSLATE.leggingsDurability, 1, 10000);
            reinforcedDeepslateBootsDurability = builder.comment("Durability for Reinforced Deepslate Boots").defineInRange("boots_durability", ArmorDefaults.REINFORCED_DEEPSLATE.bootsDurability, 1, 10000);
            reinforcedDeepslateHelmetProtection = builder.comment("Protection for Reinforced Deepslate Helmet").defineInRange("helmet_protection", ArmorDefaults.REINFORCED_DEEPSLATE.helmetProtection, 0, 20);
            reinforcedDeepslateChestplateProtection = builder.comment("Protection for Reinforced Deepslate Chestplate").defineInRange("chestplate_protection", ArmorDefaults.REINFORCED_DEEPSLATE.chestplateProtection, 0, 20);
            reinforcedDeepslateLeggingsProtection = builder.comment("Protection for Reinforced Deepslate Leggings").defineInRange("leggings_protection", ArmorDefaults.REINFORCED_DEEPSLATE.leggingsProtection, 0, 20);
            reinforcedDeepslateBootsProtection = builder.comment("Protection for Reinforced Deepslate Boots").defineInRange("boots_protection", ArmorDefaults.REINFORCED_DEEPSLATE.bootsProtection, 0, 20);
            reinforcedDeepslateEnchantment = builder.comment("Enchantment value for Reinforced Deepslate Armor").defineInRange("enchantment", ArmorDefaults.REINFORCED_DEEPSLATE.enchantment, 0, 30);
            reinforcedDeepslateToughness = builder.comment("Toughness for Reinforced Deepslate Armor").defineInRange("toughness", ArmorDefaults.REINFORCED_DEEPSLATE.toughness, 0.0, 10.0);
            reinforcedDeepslateKnockbackResistance = builder.comment("Knockback resistance for Reinforced Deepslate Armor").defineInRange("knockback_resistance", ArmorDefaults.REINFORCED_DEEPSLATE.knockbackResistance, 0.0, 1.0);
            builder.pop();

            // RGB Armor
            builder.push("rgb_armor");
            rgbHelmetDurability = builder.comment("Durability for RGB Helmet").defineInRange("helmet_durability", ArmorDefaults.RGB.helmetDurability, 1, 10000);
            rgbChestplateDurability = builder.comment("Durability for RGB Chestplate").defineInRange("chestplate_durability", ArmorDefaults.RGB.chestplateDurability, 1, 10000);
            rgbLeggingsDurability = builder.comment("Durability for RGB Leggings").defineInRange("leggings_durability", ArmorDefaults.RGB.leggingsDurability, 1, 10000);
            rgbBootsDurability = builder.comment("Durability for RGB Boots").defineInRange("boots_durability", ArmorDefaults.RGB.bootsDurability, 1, 10000);
            rgbHelmetProtection = builder.comment("Protection for RGB Helmet").defineInRange("helmet_protection", ArmorDefaults.RGB.helmetProtection, 0, 20);
            rgbChestplateProtection = builder.comment("Protection for RGB Chestplate").defineInRange("chestplate_protection", ArmorDefaults.RGB.chestplateProtection, 0, 20);
            rgbLeggingsProtection = builder.comment("Protection for RGB Leggings").defineInRange("leggings_protection", ArmorDefaults.RGB.leggingsProtection, 0, 20);
            rgbBootsProtection = builder.comment("Protection for RGB Boots").defineInRange("boots_protection", ArmorDefaults.RGB.bootsProtection, 0, 20);
            rgbEnchantment = builder.comment("Enchantment value for RGB Armor").defineInRange("enchantment", ArmorDefaults.RGB.enchantment, 0, 30);
            rgbToughness = builder.comment("Toughness for RGB Armor").defineInRange("toughness", ArmorDefaults.RGB.toughness, 0.0, 10.0);
            rgbKnockbackResistance = builder.comment("Knockback resistance for RGB Armor").defineInRange("knockback_resistance", ArmorDefaults.RGB.knockbackResistance, 0.0, 1.0);
            builder.pop();

            // Ruby Armor
            builder.push("ruby_armor");
            rubyHelmetDurability = builder.comment("Durability for Ruby Helmet").defineInRange("helmet_durability", ArmorDefaults.RUBY.helmetDurability, 1, 10000);
            rubyChestplateDurability = builder.comment("Durability for Ruby Chestplate").defineInRange("chestplate_durability", ArmorDefaults.RUBY.chestplateDurability, 1, 10000);
            rubyLeggingsDurability = builder.comment("Durability for Ruby Leggings").defineInRange("leggings_durability", ArmorDefaults.RUBY.leggingsDurability, 1, 10000);
            rubyBootsDurability = builder.comment("Durability for Ruby Boots").defineInRange("boots_durability", ArmorDefaults.RUBY.bootsDurability, 1, 10000);
            rubyHelmetProtection = builder.comment("Protection for Ruby Helmet").defineInRange("helmet_protection", ArmorDefaults.RUBY.helmetProtection, 0, 20);
            rubyChestplateProtection = builder.comment("Protection for Ruby Chestplate").defineInRange("chestplate_protection", ArmorDefaults.RUBY.chestplateProtection, 0, 20);
            rubyLeggingsProtection = builder.comment("Protection for Ruby Leggings").defineInRange("leggings_protection", ArmorDefaults.RUBY.leggingsProtection, 0, 20);
            rubyBootsProtection = builder.comment("Protection for Ruby Boots").defineInRange("boots_protection", ArmorDefaults.RUBY.bootsProtection, 0, 20);
            rubyEnchantment = builder.comment("Enchantment value for Ruby Armor").defineInRange("enchantment", ArmorDefaults.RUBY.enchantment, 0, 30);
            rubyToughness = builder.comment("Toughness for Ruby Armor").defineInRange("toughness", ArmorDefaults.RUBY.toughness, 0.0, 10.0);
            rubyKnockbackResistance = builder.comment("Knockback resistance for Ruby Armor").defineInRange("knockback_resistance", ArmorDefaults.RUBY.knockbackResistance, 0.0, 1.0);
            builder.pop();

            // Sculk Armor
            builder.push("sculk_armor");
            sculkHelmetDurability = builder.comment("Durability for Sculk Helmet").defineInRange("helmet_durability", ArmorDefaults.SCULK.helmetDurability, 1, 10000);
            sculkChestplateDurability = builder.comment("Durability for Sculk Chestplate").defineInRange("chestplate_durability", ArmorDefaults.SCULK.chestplateDurability, 1, 10000);
            sculkLeggingsDurability = builder.comment("Durability for Sculk Leggings").defineInRange("leggings_durability", ArmorDefaults.SCULK.leggingsDurability, 1, 10000);
            sculkBootsDurability = builder.comment("Durability for Sculk Boots").defineInRange("boots_durability", ArmorDefaults.SCULK.bootsDurability, 1, 10000);
            sculkHelmetProtection = builder.comment("Protection for Sculk Helmet").defineInRange("helmet_protection", ArmorDefaults.SCULK.helmetProtection, 0, 20);
            sculkChestplateProtection = builder.comment("Protection for Sculk Chestplate").defineInRange("chestplate_protection", ArmorDefaults.SCULK.chestplateProtection, 0, 20);
            sculkLeggingsProtection = builder.comment("Protection for Sculk Leggings").defineInRange("leggings_protection", ArmorDefaults.SCULK.leggingsProtection, 0, 20);
            sculkBootsProtection = builder.comment("Protection for Sculk Boots").defineInRange("boots_protection", ArmorDefaults.SCULK.bootsProtection, 0, 20);
            sculkEnchantment = builder.comment("Enchantment value for Sculk Armor").defineInRange("enchantment", ArmorDefaults.SCULK.enchantment, 0, 30);
            sculkToughness = builder.comment("Toughness for Sculk Armor").defineInRange("toughness", ArmorDefaults.SCULK.toughness, 0.0, 10.0);
            sculkKnockbackResistance = builder.comment("Knockback resistance for Sculk Armor").defineInRange("knockback_resistance", ArmorDefaults.SCULK.knockbackResistance, 0.0, 1.0);
            builder.pop();

            // Shulker Armor
            builder.push("shulker_armor");
            shulkerHelmetDurability = builder.comment("Durability for Shulker Helmet").defineInRange("helmet_durability", ArmorDefaults.SHULKER.helmetDurability, 1, 10000);
            shulkerChestplateDurability = builder.comment("Durability for Shulker Chestplate").defineInRange("chestplate_durability", ArmorDefaults.SHULKER.chestplateDurability, 1, 10000);
            shulkerLeggingsDurability = builder.comment("Durability for Shulker Leggings").defineInRange("leggings_durability", ArmorDefaults.SHULKER.leggingsDurability, 1, 10000);
            shulkerBootsDurability = builder.comment("Durability for Shulker Boots").defineInRange("boots_durability", ArmorDefaults.SHULKER.bootsDurability, 1, 10000);
            shulkerHelmetProtection = builder.comment("Protection for Shulker Helmet").defineInRange("helmet_protection", ArmorDefaults.SHULKER.helmetProtection, 0, 20);
            shulkerChestplateProtection = builder.comment("Protection for Shulker Chestplate").defineInRange("chestplate_protection", ArmorDefaults.SHULKER.chestplateProtection, 0, 20);
            shulkerLeggingsProtection = builder.comment("Protection for Shulker Leggings").defineInRange("leggings_protection", ArmorDefaults.SHULKER.leggingsProtection, 0, 20);
            shulkerBootsProtection = builder.comment("Protection for Shulker Boots").defineInRange("boots_protection", ArmorDefaults.SHULKER.bootsProtection, 0, 20);
            shulkerEnchantment = builder.comment("Enchantment value for Shulker Armor").defineInRange("enchantment", ArmorDefaults.SHULKER.enchantment, 0, 30);
            shulkerToughness = builder.comment("Toughness for Shulker Armor").defineInRange("toughness", ArmorDefaults.SHULKER.toughness, 0.0, 10.0);
            shulkerKnockbackResistance = builder.comment("Knockback resistance for Shulker Armor").defineInRange("knockback_resistance", ArmorDefaults.SHULKER.knockbackResistance, 0.0, 1.0);
            builder.pop();

            // Skeleton Armor
            builder.push("skeleton_armor");
            skeletonHelmetDurability = builder.comment("Durability for Skeleton Helmet").defineInRange("helmet_durability", ArmorDefaults.SKELETON.helmetDurability, 1, 10000);
            skeletonChestplateDurability = builder.comment("Durability for Skeleton Chestplate").defineInRange("chestplate_durability", ArmorDefaults.SKELETON.chestplateDurability, 1, 10000);
            skeletonLeggingsDurability = builder.comment("Durability for Skeleton Leggings").defineInRange("leggings_durability", ArmorDefaults.SKELETON.leggingsDurability, 1, 10000);
            skeletonBootsDurability = builder.comment("Durability for Skeleton Boots").defineInRange("boots_durability", ArmorDefaults.SKELETON.bootsDurability, 1, 10000);
            skeletonHelmetProtection = builder.comment("Protection for Skeleton Helmet").defineInRange("helmet_protection", ArmorDefaults.SKELETON.helmetProtection, 0, 20);
            skeletonChestplateProtection = builder.comment("Protection for Skeleton Chestplate").defineInRange("chestplate_protection", ArmorDefaults.SKELETON.chestplateProtection, 0, 20);
            skeletonLeggingsProtection = builder.comment("Protection for Skeleton Leggings").defineInRange("leggings_protection", ArmorDefaults.SKELETON.leggingsProtection, 0, 20);
            skeletonBootsProtection = builder.comment("Protection for Skeleton Boots").defineInRange("boots_protection", ArmorDefaults.SKELETON.bootsProtection, 0, 20);
            skeletonEnchantment = builder.comment("Enchantment value for Skeleton Armor").defineInRange("enchantment", ArmorDefaults.SKELETON.enchantment, 0, 30);
            skeletonToughness = builder.comment("Toughness for Skeleton Armor").defineInRange("toughness", ArmorDefaults.SKELETON.toughness, 0.0, 10.0);
            skeletonKnockbackResistance = builder.comment("Knockback resistance for Skeleton Armor").defineInRange("knockback_resistance", ArmorDefaults.SKELETON.knockbackResistance, 0.0, 1.0);
            builder.pop();

            
            // Sniffer Armor
            builder.push("sniffer_armor");
            snifferHelmetDurability = builder.comment("Durability for Sniffer Helmet").defineInRange("helmet_durability", ArmorDefaults.SNIFFER.helmetDurability, 1, 10000);
            snifferChestplateDurability = builder.comment("Durability for Sniffer Chestplate").defineInRange("chestplate_durability", ArmorDefaults.SNIFFER.chestplateDurability, 1, 10000);
            snifferLeggingsDurability = builder.comment("Durability for Sniffer Leggings").defineInRange("leggings_durability", ArmorDefaults.SNIFFER.leggingsDurability, 1, 10000);
            snifferBootsDurability = builder.comment("Durability for Sniffer Boots").defineInRange("boots_durability", ArmorDefaults.SNIFFER.bootsDurability, 1, 10000);
            snifferHelmetProtection = builder.comment("Protection for Sniffer Helmet").defineInRange("helmet_protection", ArmorDefaults.SNIFFER.helmetProtection, 0, 20);
            snifferChestplateProtection = builder.comment("Protection for Sniffer Chestplate").defineInRange("chestplate_protection", ArmorDefaults.SNIFFER.chestplateProtection, 0, 20);
            snifferLeggingsProtection = builder.comment("Protection for Sniffer Leggings").defineInRange("leggings_protection", ArmorDefaults.SNIFFER.leggingsProtection, 0, 20);
            snifferBootsProtection = builder.comment("Protection for Sniffer Boots").defineInRange("boots_protection", ArmorDefaults.SNIFFER.bootsProtection, 0, 20);
            snifferEnchantment = builder.comment("Enchantment value for Sniffer Armor").defineInRange("enchantment", ArmorDefaults.SNIFFER.enchantment, 0, 30);
            snifferToughness = builder.comment("Toughness for Sniffer Armor").defineInRange("toughness", ArmorDefaults.SNIFFER.toughness, 0.0, 10.0);
            snifferKnockbackResistance = builder.comment("Knockback resistance for Sniffer Armor").defineInRange("knockback_resistance", ArmorDefaults.SNIFFER.knockbackResistance, 0.0, 1.0);
            builder.pop();

            // TNT Armor
            builder.push("tnt_armor");
            tntHelmetDurability = builder.comment("Durability for TNT Helmet").defineInRange("helmet_durability", ArmorDefaults.TNT.helmetDurability, 1, 10000);
            tntChestplateDurability = builder.comment("Durability for TNT Chestplate").defineInRange("chestplate_durability", ArmorDefaults.TNT.chestplateDurability, 1, 10000);
            tntLeggingsDurability = builder.comment("Durability for TNT Leggings").defineInRange("leggings_durability", ArmorDefaults.TNT.leggingsDurability, 1, 10000);
            tntBootsDurability = builder.comment("Durability for TNT Boots").defineInRange("boots_durability", ArmorDefaults.TNT.bootsDurability, 1, 10000);
            tntHelmetProtection = builder.comment("Protection for TNT Helmet").defineInRange("helmet_protection", ArmorDefaults.TNT.helmetProtection, 0, 20);
            tntChestplateProtection = builder.comment("Protection for TNT Chestplate").defineInRange("chestplate_protection", ArmorDefaults.TNT.chestplateProtection, 0, 20);
            tntLeggingsProtection = builder.comment("Protection for TNT Leggings").defineInRange("leggings_protection", ArmorDefaults.TNT.leggingsProtection, 0, 20);
            tntBootsProtection = builder.comment("Protection for TNT Boots").defineInRange("boots_protection", ArmorDefaults.TNT.bootsProtection, 0, 20);
            tntEnchantment = builder.comment("Enchantment value for TNT Armor").defineInRange("enchantment", ArmorDefaults.TNT.enchantment, 0, 30);
            tntToughness = builder.comment("Toughness for TNT Armor").defineInRange("toughness", ArmorDefaults.TNT.toughness, 0.0, 10.0);
            tntKnockbackResistance = builder.comment("Knockback resistance for TNT Armor").defineInRange("knockback_resistance", ArmorDefaults.TNT.knockbackResistance, 0.0, 1.0);
            builder.pop();

            // Totem Armor
            builder.push("totem_armor");
            totemHelmetDurability = builder.comment("Durability for Totem Helmet").defineInRange("helmet_durability", ArmorDefaults.TOTEM.helmetDurability, 1, 10000);
            totemChestplateDurability = builder.comment("Durability for Totem Chestplate").defineInRange("chestplate_durability", ArmorDefaults.TOTEM.chestplateDurability, 1, 10000);
            totemLeggingsDurability = builder.comment("Durability for Totem Leggings").defineInRange("leggings_durability", ArmorDefaults.TOTEM.leggingsDurability, 1, 10000);
            totemBootsDurability = builder.comment("Durability for Totem Boots").defineInRange("boots_durability", ArmorDefaults.TOTEM.bootsDurability, 1, 10000);
            totemHelmetProtection = builder.comment("Protection for Totem Helmet").defineInRange("helmet_protection", ArmorDefaults.TOTEM.helmetProtection, 0, 20);
            totemChestplateProtection = builder.comment("Protection for Totem Chestplate").defineInRange("chestplate_protection", ArmorDefaults.TOTEM.chestplateProtection, 0, 20);
            totemLeggingsProtection = builder.comment("Protection for Totem Leggings").defineInRange("leggings_protection", ArmorDefaults.TOTEM.leggingsProtection, 0, 20);
            totemBootsProtection = builder.comment("Protection for Totem Boots").defineInRange("boots_protection", ArmorDefaults.TOTEM.bootsProtection, 0, 20);
            totemEnchantment = builder.comment("Enchantment value for Totem Armor").defineInRange("enchantment", ArmorDefaults.TOTEM.enchantment, 0, 30);
            totemToughness = builder.comment("Toughness for Totem Armor").defineInRange("toughness", ArmorDefaults.TOTEM.toughness, 0.0, 10.0);
            totemKnockbackResistance = builder.comment("Knockback resistance for Totem Armor").defineInRange("knockback_resistance", ArmorDefaults.TOTEM.knockbackResistance, 0.0, 1.0);
            builder.pop();

            // Wither Skeleton Armor
            builder.push("wither_skeleton_armor");
            witherSkeletonHelmetDurability = builder.comment("Durability for Wither Skeleton Helmet").defineInRange("helmet_durability", ArmorDefaults.WITHER_SKELETON.helmetDurability, 1, 10000);
            witherSkeletonChestplateDurability = builder.comment("Durability for Wither Skeleton Chestplate").defineInRange("chestplate_durability", ArmorDefaults.WITHER_SKELETON.chestplateDurability, 1, 10000);
            witherSkeletonLeggingsDurability = builder.comment("Durability for Wither Skeleton Leggings").defineInRange("leggings_durability", ArmorDefaults.WITHER_SKELETON.leggingsDurability, 1, 10000);
            witherSkeletonBootsDurability = builder.comment("Durability for Wither Skeleton Boots").defineInRange("boots_durability", ArmorDefaults.WITHER_SKELETON.bootsDurability, 1, 10000);
            witherSkeletonHelmetProtection = builder.comment("Protection for Wither Skeleton Helmet").defineInRange("helmet_protection", ArmorDefaults.WITHER_SKELETON.helmetProtection, 0, 20);
            witherSkeletonChestplateProtection = builder.comment("Protection for Wither Skeleton Chestplate").defineInRange("chestplate_protection", ArmorDefaults.WITHER_SKELETON.chestplateProtection, 0, 20);
            witherSkeletonLeggingsProtection = builder.comment("Protection for Wither Skeleton Leggings").defineInRange("leggings_protection", ArmorDefaults.WITHER_SKELETON.leggingsProtection, 0, 20);
            witherSkeletonBootsProtection = builder.comment("Protection for Wither Skeleton Boots").defineInRange("boots_protection", ArmorDefaults.WITHER_SKELETON.bootsProtection, 0, 20);
            witherSkeletonEnchantment = builder.comment("Enchantment value for Wither Skeleton Armor").defineInRange("enchantment", ArmorDefaults.WITHER_SKELETON.enchantment, 0, 30);
            witherSkeletonToughness = builder.comment("Toughness for Wither Skeleton Armor").defineInRange("toughness", ArmorDefaults.WITHER_SKELETON.toughness, 0.0, 10.0);
            witherSkeletonKnockbackResistance = builder.comment("Knockback resistance for Wither Skeleton Armor").defineInRange("knockback_resistance", ArmorDefaults.WITHER_SKELETON.knockbackResistance, 0.0, 1.0);
            builder.pop();

        }
    }
}
