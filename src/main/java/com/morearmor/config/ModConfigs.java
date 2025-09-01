package com.morearmor.config;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.common.Mod;
import com.morearmor.MoreArmor;
import org.apache.commons.lang3.tuple.Pair;

@Mod.EventBusSubscriber(modid = MoreArmor.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModConfigs {
    public static final ForgeConfigSpec SERVER_SPEC;
    public static final Server SERVER;

    static {
        final Pair<Server, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(Server::new);
        SERVER_SPEC = specPair.getRight();
        SERVER = specPair.getLeft();
    }

    public static void register() {
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, SERVER_SPEC);
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
            amethystHelmetDurability = builder.comment("Durability for Amethyst Helmet").defineInRange("helmet_durability", 193, 1, 10000);
            amethystChestplateDurability = builder.comment("Durability for Amethyst Chestplate").defineInRange("chestplate_durability", 280, 1, 10000);
            amethystLeggingsDurability = builder.comment("Durability for Amethyst Leggings").defineInRange("leggings_durability", 263, 1, 10000);
            amethystBootsDurability = builder.comment("Durability for Amethyst Boots").defineInRange("boots_durability", 228, 1, 10000);
            amethystHelmetProtection = builder.comment("Protection for Amethyst Helmet").defineInRange("helmet_protection", 2, 0, 20);
            amethystChestplateProtection = builder.comment("Protection for Amethyst Chestplate").defineInRange("chestplate_protection", 5, 0, 20);
            amethystLeggingsProtection = builder.comment("Protection for Amethyst Leggings").defineInRange("leggings_protection", 4, 0, 20);
            amethystBootsProtection = builder.comment("Protection for Amethyst Boots").defineInRange("boots_protection", 1, 0, 20);
            amethystEnchantment = builder.comment("Enchantment value for Amethyst Armor").defineInRange("enchantment", 15, 0, 30);
            amethystToughness = builder.comment("Toughness for Amethyst Armor").defineInRange("toughness", 0.5, 0.0, 10.0);
            amethystKnockbackResistance = builder.comment("Knockback resistance for Amethyst Armor").defineInRange("knockback_resistance", 0.0, 0.0, 1.0);
            builder.pop();

            // Ancient Debris Armor
            builder.push("ancient_debris_armor");
            ancientDebrisHelmetDurability = builder.comment("Durability for Ancient Debris Helmet").defineInRange("helmet_durability", 448, 1, 10000);
            ancientDebrisChestplateDurability = builder.comment("Durability for Ancient Debris Chestplate").defineInRange("chestplate_durability", 651, 1, 10000);
            ancientDebrisLeggingsDurability = builder.comment("Durability for Ancient Debris Leggings").defineInRange("leggings_durability", 610, 1, 10000);
            ancientDebrisBootsDurability = builder.comment("Durability for Ancient Debris Boots").defineInRange("boots_durability", 529, 1, 10000);
            ancientDebrisHelmetProtection = builder.comment("Protection for Ancient Debris Helmet").defineInRange("helmet_protection", 3, 0, 20);
            ancientDebrisChestplateProtection = builder.comment("Protection for Ancient Debris Chestplate").defineInRange("chestplate_protection", 8, 0, 20);
            ancientDebrisLeggingsProtection = builder.comment("Protection for Ancient Debris Leggings").defineInRange("leggings_protection", 6, 0, 20);
            ancientDebrisBootsProtection = builder.comment("Protection for Ancient Debris Boots").defineInRange("boots_protection", 3, 0, 20);
            ancientDebrisEnchantment = builder.comment("Enchantment value for Ancient Debris Armor").defineInRange("enchantment", 19, 0, 30);
            ancientDebrisToughness = builder.comment("Toughness for Ancient Debris Armor").defineInRange("toughness", 3.0, 0.0, 10.0);
            ancientDebrisKnockbackResistance = builder.comment("Knockback resistance for Ancient Debris Armor").defineInRange("knockback_resistance", 0.1, 0.0, 1.0);
            builder.pop();

            // Bedrock Armor
            builder.push("bedrock_armor");
            bedrockHelmetDurability = builder.comment("Durability for Bedrock Helmet").defineInRange("helmet_durability", 1100, 1, 10000);
            bedrockChestplateDurability = builder.comment("Durability for Bedrock Chestplate").defineInRange("chestplate_durability", 1600, 1, 10000);
            bedrockLeggingsDurability = builder.comment("Durability for Bedrock Leggings").defineInRange("leggings_durability", 1500, 1, 10000);
            bedrockBootsDurability = builder.comment("Durability for Bedrock Boots").defineInRange("boots_durability", 1300, 1, 10000);
            bedrockHelmetProtection = builder.comment("Protection for Bedrock Helmet").defineInRange("helmet_protection", 2, 0, 20);
            bedrockChestplateProtection = builder.comment("Protection for Bedrock Chestplate").defineInRange("chestplate_protection", 6, 0, 20);
            bedrockLeggingsProtection = builder.comment("Protection for Bedrock Leggings").defineInRange("leggings_protection", 5, 0, 20);
            bedrockBootsProtection = builder.comment("Protection for Bedrock Boots").defineInRange("boots_protection", 2, 0, 20);
            bedrockEnchantment = builder.comment("Enchantment value for Bedrock Armor").defineInRange("enchantment", 20, 0, 30);
            bedrockToughness = builder.comment("Toughness for Bedrock Armor").defineInRange("toughness", 0.0, 0.0, 10.0);
            bedrockKnockbackResistance = builder.comment("Knockback resistance for Bedrock Armor").defineInRange("knockback_resistance", 0.2, 0.0, 1.0);
            builder.pop();

            // Bee Armor
            builder.push("bee_armor");
            beeHelmetDurability = builder.comment("Durability for Bee Helmet").defineInRange("helmet_durability", 77, 1, 10000);
            beeChestplateDurability = builder.comment("Durability for Bee Chestplate").defineInRange("chestplate_durability", 112, 1, 10000);
            beeLeggingsDurability = builder.comment("Durability for Bee Leggings").defineInRange("leggings_durability", 105, 1, 10000);
            beeBootsDurability = builder.comment("Durability for Bee Boots").defineInRange("boots_durability", 91, 1, 10000);
            beeHelmetProtection = builder.comment("Protection for Bee Helmet").defineInRange("helmet_protection", 1, 0, 20);
            beeChestplateProtection = builder.comment("Protection for Bee Chestplate").defineInRange("chestplate_protection", 3, 0, 20);
            beeLeggingsProtection = builder.comment("Protection for Bee Leggings").defineInRange("leggings_protection", 2, 0, 20);
            beeBootsProtection = builder.comment("Protection for Bee Boots").defineInRange("boots_protection", 1, 0, 20);
            beeEnchantment = builder.comment("Enchantment value for Bee Armor").defineInRange("enchantment", 10, 0, 30);
            beeToughness = builder.comment("Toughness for Bee Armor").defineInRange("toughness", 0.0, 0.0, 10.0);
            beeKnockbackResistance = builder.comment("Knockback resistance for Bee Armor").defineInRange("knockback_resistance", 0.0, 0.0, 1.0);
            builder.pop();

            // Bone Armor
            builder.push("bone_armor");
            boneHelmetDurability = builder.comment("Durability for Bone Helmet").defineInRange("helmet_durability", 132, 1, 10000);
            boneChestplateDurability = builder.comment("Durability for Bone Chestplate").defineInRange("chestplate_durability", 192, 1, 10000);
            boneLeggingsDurability = builder.comment("Durability for Bone Leggings").defineInRange("leggings_durability", 180, 1, 10000);
            boneBootsDurability = builder.comment("Durability for Bone Boots").defineInRange("boots_durability", 156, 1, 10000);
            boneHelmetProtection = builder.comment("Protection for Bone Helmet").defineInRange("helmet_protection", 2, 0, 20);
            boneChestplateProtection = builder.comment("Protection for Bone Chestplate").defineInRange("chestplate_protection", 4, 0, 20);
            boneLeggingsProtection = builder.comment("Protection for Bone Leggings").defineInRange("leggings_protection", 3, 0, 20);
            boneBootsProtection = builder.comment("Protection for Bone Boots").defineInRange("boots_protection", 2, 0, 20);
            boneEnchantment = builder.comment("Enchantment value for Bone Armor").defineInRange("enchantment", 11, 0, 30);
            boneToughness = builder.comment("Toughness for Bone Armor").defineInRange("toughness", 0.6, 0.0, 10.0);
            boneKnockbackResistance = builder.comment("Knockback resistance for Bone Armor").defineInRange("knockback_resistance", 0.0, 0.0, 1.0);
            builder.pop();

            // Cactus Armor
            builder.push("cactus_armor");
            cactusHelmetDurability = builder.comment("Durability for Cactus Helmet").defineInRange("helmet_durability", 55, 1, 10000);
            cactusChestplateDurability = builder.comment("Durability for Cactus Chestplate").defineInRange("chestplate_durability", 80, 1, 10000);
            cactusLeggingsDurability = builder.comment("Durability for Cactus Leggings").defineInRange("leggings_durability", 75, 1, 10000);
            cactusBootsDurability = builder.comment("Durability for Cactus Boots").defineInRange("boots_durability", 65, 1, 10000);
            cactusHelmetProtection = builder.comment("Protection for Cactus Helmet").defineInRange("helmet_protection", 1, 0, 20);
            cactusChestplateProtection = builder.comment("Protection for Cactus Chestplate").defineInRange("chestplate_protection", 2, 0, 20);
            cactusLeggingsProtection = builder.comment("Protection for Cactus Leggings").defineInRange("leggings_protection", 2, 0, 20);
            cactusBootsProtection = builder.comment("Protection for Cactus Boots").defineInRange("boots_protection", 1, 0, 20);
            cactusEnchantment = builder.comment("Enchantment value for Cactus Armor").defineInRange("enchantment", 10, 0, 30);
            cactusToughness = builder.comment("Toughness for Cactus Armor").defineInRange("toughness", 0.0, 0.0, 10.0);
            cactusKnockbackResistance = builder.comment("Knockback resistance for Cactus Armor").defineInRange("knockback_resistance", 0.0, 0.0, 1.0);
            builder.pop();

            // Coal Armor
            builder.push("coal_armor");
            coalHelmetDurability = builder.comment("Durability for Coal Helmet").defineInRange("helmet_durability", 99, 1, 10000);
            coalChestplateDurability = builder.comment("Durability for Coal Chestplate").defineInRange("chestplate_durability", 144, 1, 10000);
            coalLeggingsDurability = builder.comment("Durability for Coal Leggings").defineInRange("leggings_durability", 135, 1, 10000);
            coalBootsDurability = builder.comment("Durability for Coal Boots").defineInRange("boots_durability", 117, 1, 10000);
            coalHelmetProtection = builder.comment("Protection for Coal Helmet").defineInRange("helmet_protection", 1, 0, 20);
            coalChestplateProtection = builder.comment("Protection for Coal Chestplate").defineInRange("chestplate_protection", 2, 0, 20);
            coalLeggingsProtection = builder.comment("Protection for Coal Leggings").defineInRange("leggings_protection", 2, 0, 20);
            coalBootsProtection = builder.comment("Protection for Coal Boots").defineInRange("boots_protection", 1, 0, 20);
            coalEnchantment = builder.comment("Enchantment value for Coal Armor").defineInRange("enchantment", 10, 0, 30);
            coalToughness = builder.comment("Toughness for Coal Armor").defineInRange("toughness", 0.0, 0.0, 10.0);
            coalKnockbackResistance = builder.comment("Knockback resistance for Coal Armor").defineInRange("knockback_resistance", 0.0, 0.0, 1.0);
            builder.pop();

            // Copper Armor
            builder.push("copper_armor");
            copperHelmetDurability = builder.comment("Durability for Copper Helmet").defineInRange("helmet_durability", 121, 1, 10000);
            copperChestplateDurability = builder.comment("Durability for Copper Chestplate").defineInRange("chestplate_durability", 176, 1, 10000);
            copperLeggingsDurability = builder.comment("Durability for Copper Leggings").defineInRange("leggings_durability", 165, 1, 10000);
            copperBootsDurability = builder.comment("Durability for Copper Boots").defineInRange("boots_durability", 143, 1, 10000);
            copperHelmetProtection = builder.comment("Protection for Copper Helmet").defineInRange("helmet_protection", 2, 0, 20);
            copperChestplateProtection = builder.comment("Protection for Copper Chestplate").defineInRange("chestplate_protection", 4, 0, 20);
            copperLeggingsProtection = builder.comment("Protection for Copper Leggings").defineInRange("leggings_protection", 3, 0, 20);
            copperBootsProtection = builder.comment("Protection for Copper Boots").defineInRange("boots_protection", 1, 0, 20);
            copperEnchantment = builder.comment("Enchantment value for Copper Armor").defineInRange("enchantment", 8, 0, 30);
            copperToughness = builder.comment("Toughness for Copper Armor").defineInRange("toughness", 0.0, 0.0, 10.0);
            copperKnockbackResistance = builder.comment("Knockback resistance for Copper Armor").defineInRange("knockback_resistance", 0.0, 0.0, 1.0);
            builder.pop();

            // Crafting Armor
            builder.push("crafting_armor");
            craftingHelmetDurability = builder.comment("Durability for Crafting Helmet").defineInRange("helmet_durability", 55, 1, 10000);
            craftingChestplateDurability = builder.comment("Durability for Crafting Chestplate").defineInRange("chestplate_durability", 80, 1, 10000);
            craftingLeggingsDurability = builder.comment("Durability for Crafting Leggings").defineInRange("leggings_durability", 75, 1, 10000);
            craftingBootsDurability = builder.comment("Durability for Crafting Boots").defineInRange("boots_durability", 65, 1, 10000);
            craftingHelmetProtection = builder.comment("Protection for Crafting Helmet").defineInRange("helmet_protection", 1, 0, 20);
            craftingChestplateProtection = builder.comment("Protection for Crafting Chestplate").defineInRange("chestplate_protection", 2, 0, 20);
            craftingLeggingsProtection = builder.comment("Protection for Crafting Leggings").defineInRange("leggings_protection", 2, 0, 20);
            craftingBootsProtection = builder.comment("Protection for Crafting Boots").defineInRange("boots_protection", 1, 0, 20);
            craftingEnchantment = builder.comment("Enchantment value for Crafting Armor").defineInRange("enchantment", 12, 0, 30);
            craftingToughness = builder.comment("Toughness for Crafting Armor").defineInRange("toughness", 0.0, 0.0, 10.0);
            craftingKnockbackResistance = builder.comment("Knockback resistance for Crafting Armor").defineInRange("knockback_resistance", 0.0, 0.0, 1.0);
            builder.pop();

            // Dripstone Armor
            builder.push("dripstone_armor");
            dripstoneHelmetDurability = builder.comment("Durability for Dripstone Helmet").defineInRange("helmet_durability", 33, 1, 10000);
            dripstoneChestplateDurability = builder.comment("Durability for Dripstone Chestplate").defineInRange("chestplate_durability", 48, 1, 10000);
            dripstoneLeggingsDurability = builder.comment("Durability for Dripstone Leggings").defineInRange("leggings_durability", 45, 1, 10000);
            dripstoneBootsDurability = builder.comment("Durability for Dripstone Boots").defineInRange("boots_durability", 39, 1, 10000);
            dripstoneHelmetProtection = builder.comment("Protection for Dripstone Helmet").defineInRange("helmet_protection", 1, 0, 20);
            dripstoneChestplateProtection = builder.comment("Protection for Dripstone Chestplate").defineInRange("chestplate_protection", 1, 0, 20);
            dripstoneLeggingsProtection = builder.comment("Protection for Dripstone Leggings").defineInRange("leggings_protection", 1, 0, 20);
            dripstoneBootsProtection = builder.comment("Protection for Dripstone Boots").defineInRange("boots_protection", 1, 0, 20);
            dripstoneEnchantment = builder.comment("Enchantment value for Dripstone Armor").defineInRange("enchantment", 13, 0, 30);
            dripstoneToughness = builder.comment("Toughness for Dripstone Armor").defineInRange("toughness", 0.0, 0.0, 10.0);
            dripstoneKnockbackResistance = builder.comment("Knockback resistance for Dripstone Armor").defineInRange("knockback_resistance", 0.0, 0.0, 1.0);
            builder.pop();

            // Emerald Armor
            builder.push("emerald_armor");
            emeraldHelmetDurability = builder.comment("Durability for Emerald Helmet").defineInRange("helmet_durability", 255, 1, 10000);
            emeraldChestplateDurability = builder.comment("Durability for Emerald Chestplate").defineInRange("chestplate_durability", 372, 1, 10000);
            emeraldLeggingsDurability = builder.comment("Durability for Emerald Leggings").defineInRange("leggings_durability", 318, 1, 10000);
            emeraldBootsDurability = builder.comment("Durability for Emerald Boots").defineInRange("boots_durability", 302, 1, 10000);
            emeraldHelmetProtection = builder.comment("Protection for Emerald Helmet").defineInRange("helmet_protection", 2, 0, 20);
            emeraldChestplateProtection = builder.comment("Protection for Emerald Chestplate").defineInRange("chestplate_protection", 8, 0, 20);
            emeraldLeggingsProtection = builder.comment("Protection for Emerald Leggings").defineInRange("leggings_protection", 3, 0, 20);
            emeraldBootsProtection = builder.comment("Protection for Emerald Boots").defineInRange("boots_protection", 2, 0, 20);
            emeraldEnchantment = builder.comment("Enchantment value for Emerald Armor").defineInRange("enchantment", 17, 0, 30);
            emeraldToughness = builder.comment("Toughness for Emerald Armor").defineInRange("toughness", 0.0, 0.0, 10.0);
            emeraldKnockbackResistance = builder.comment("Knockback resistance for Emerald Armor").defineInRange("knockback_resistance", 0.0, 0.0, 1.0);
            builder.pop();

            // Ender Dragon Armor
            builder.push("ender_dragon_armor");
            enderDragonHelmetDurability = builder.comment("Durability for Ender Dragon Helmet").defineInRange("helmet_durability", 580, 1, 10000);
            enderDragonChestplateDurability = builder.comment("Durability for Ender Dragon Chestplate").defineInRange("chestplate_durability", 850, 1, 10000);
            enderDragonLeggingsDurability = builder.comment("Durability for Ender Dragon Leggings").defineInRange("leggings_durability", 800, 1, 10000);
            enderDragonBootsDurability = builder.comment("Durability for Ender Dragon Boots").defineInRange("boots_durability", 690, 1, 10000);
            enderDragonHelmetProtection = builder.comment("Protection for Ender Dragon Helmet").defineInRange("helmet_protection", 4, 0, 20);
            enderDragonChestplateProtection = builder.comment("Protection for Ender Dragon Chestplate").defineInRange("chestplate_protection", 8, 0, 20);
            enderDragonLeggingsProtection = builder.comment("Protection for Ender Dragon Leggings").defineInRange("leggings_protection", 6, 0, 20);
            enderDragonBootsProtection = builder.comment("Protection for Ender Dragon Boots").defineInRange("boots_protection", 3, 0, 20);
            enderDragonEnchantment = builder.comment("Enchantment value for Ender Dragon Armor").defineInRange("enchantment", 20, 0, 30);
            enderDragonToughness = builder.comment("Toughness for Ender Dragon Armor").defineInRange("toughness", 3.0, 0.0, 10.0);
            enderDragonKnockbackResistance = builder.comment("Knockback resistance for Ender Dragon Armor").defineInRange("knockback_resistance", 0.1, 0.0, 1.0);
            builder.pop();

            // Galaxy Armor
            builder.push("galaxy_armor");
            galaxyHelmetDurability = builder.comment("Durability for Galaxy Helmet").defineInRange("helmet_durability", 610, 1, 10000);
            galaxyChestplateDurability = builder.comment("Durability for Galaxy Chestplate").defineInRange("chestplate_durability", 888, 1, 10000);
            galaxyLeggingsDurability = builder.comment("Durability for Galaxy Leggings").defineInRange("leggings_durability", 832, 1, 10000);
            galaxyBootsDurability = builder.comment("Durability for Galaxy Boots").defineInRange("boots_durability", 721, 1, 10000);
            galaxyHelmetProtection = builder.comment("Protection for Galaxy Helmet").defineInRange("helmet_protection", 4, 0, 20);
            galaxyChestplateProtection = builder.comment("Protection for Galaxy Chestplate").defineInRange("chestplate_protection", 8, 0, 20);
            galaxyLeggingsProtection = builder.comment("Protection for Galaxy Leggings").defineInRange("leggings_protection", 6, 0, 20);
            galaxyBootsProtection = builder.comment("Protection for Galaxy Boots").defineInRange("boots_protection", 4, 0, 20);
            galaxyEnchantment = builder.comment("Enchantment value for Galaxy Armor").defineInRange("enchantment", 19, 0, 30);
            galaxyToughness = builder.comment("Toughness for Galaxy Armor").defineInRange("toughness", 3.0, 0.0, 10.0);
            galaxyKnockbackResistance = builder.comment("Knockback resistance for Galaxy Armor").defineInRange("knockback_resistance", 0.1, 0.0, 1.0);
            builder.pop();

            // Gilded Armor
            builder.push("gilded_armor");
            gildedHelmetDurability = builder.comment("Durability for Gilded Helmet").defineInRange("helmet_durability", 260, 1, 10000);
            gildedChestplateDurability = builder.comment("Durability for Gilded Chestplate").defineInRange("chestplate_durability", 336, 1, 10000);
            gildedLeggingsDurability = builder.comment("Durability for Gilded Leggings").defineInRange("leggings_durability", 315, 1, 10000);
            gildedBootsDurability = builder.comment("Durability for Gilded Boots").defineInRange("boots_durability", 273, 1, 10000);
            gildedHelmetProtection = builder.comment("Protection for Gilded Helmet").defineInRange("helmet_protection", 3, 0, 20);
            gildedChestplateProtection = builder.comment("Protection for Gilded Chestplate").defineInRange("chestplate_protection", 6, 0, 20);
            gildedLeggingsProtection = builder.comment("Protection for Gilded Leggings").defineInRange("leggings_protection", 5, 0, 20);
            gildedBootsProtection = builder.comment("Protection for Gilded Boots").defineInRange("boots_protection", 3, 0, 20);
            gildedEnchantment = builder.comment("Enchantment value for Gilded Armor").defineInRange("enchantment", 15, 0, 30);
            gildedToughness = builder.comment("Toughness for Gilded Armor").defineInRange("toughness", 0.0, 0.0, 10.0);
            gildedKnockbackResistance = builder.comment("Knockback resistance for Gilded Armor").defineInRange("knockback_resistance", 0.0, 0.0, 1.0);
            builder.pop();

            // Glass Armor
            builder.push("glass_armor");
            glassHelmetDurability = builder.comment("Durability for Glass Helmet").defineInRange("helmet_durability", 27, 1, 10000);
            glassChestplateDurability = builder.comment("Durability for Glass Chestplate").defineInRange("chestplate_durability", 40, 1, 10000);
            glassLeggingsDurability = builder.comment("Durability for Glass Leggings").defineInRange("leggings_durability", 37, 1, 10000);
            glassBootsDurability = builder.comment("Durability for Glass Boots").defineInRange("boots_durability", 32, 1, 10000);
            glassHelmetProtection = builder.comment("Protection for Glass Helmet").defineInRange("helmet_protection", 0, 0, 20);
            glassChestplateProtection = builder.comment("Protection for Glass Chestplate").defineInRange("chestplate_protection", 0, 0, 20);
            glassLeggingsProtection = builder.comment("Protection for Glass Leggings").defineInRange("leggings_protection", 0, 0, 20);
            glassBootsProtection = builder.comment("Protection for Glass Boots").defineInRange("boots_protection", 0, 0, 20);
            glassEnchantment = builder.comment("Enchantment value for Glass Armor").defineInRange("enchantment", 6, 0, 30);
            glassToughness = builder.comment("Toughness for Glass Armor").defineInRange("toughness", 0.0, 0.0, 10.0);
            glassKnockbackResistance = builder.comment("Knockback resistance for Glass Armor").defineInRange("knockback_resistance", 0.0, 0.0, 1.0);
            builder.pop();

            // Guardian Armor
            builder.push("guardian_armor");
            guardianHelmetDurability = builder.comment("Durability for Guardian Helmet").defineInRange("helmet_durability", 247, 1, 10000);
            guardianChestplateDurability = builder.comment("Durability for Guardian Chestplate").defineInRange("chestplate_durability", 320, 1, 10000);
            guardianLeggingsDurability = builder.comment("Durability for Guardian Leggings").defineInRange("leggings_durability", 300, 1, 10000);
            guardianBootsDurability = builder.comment("Durability for Guardian Boots").defineInRange("boots_durability", 260, 1, 10000);
            guardianHelmetProtection = builder.comment("Protection for Guardian Helmet").defineInRange("helmet_protection", 3, 0, 20);
            guardianChestplateProtection = builder.comment("Protection for Guardian Chestplate").defineInRange("chestplate_protection", 6, 0, 20);
            guardianLeggingsProtection = builder.comment("Protection for Guardian Leggings").defineInRange("leggings_protection", 5, 0, 20);
            guardianBootsProtection = builder.comment("Protection for Guardian Boots").defineInRange("boots_protection", 3, 0, 20);
            guardianEnchantment = builder.comment("Enchantment value for Guardian Armor").defineInRange("enchantment", 15, 0, 30);
            guardianToughness = builder.comment("Toughness for Guardian Armor").defineInRange("toughness", 0.0, 0.0, 10.0);
            guardianKnockbackResistance = builder.comment("Knockback resistance for Guardian Armor").defineInRange("knockback_resistance", 0.0, 0.0, 1.0);
            builder.pop();

            // Lapis Armor
            builder.push("lapis_armor");
            lapisHelmetDurability = builder.comment("Durability for Lapis Helmet").defineInRange("helmet_durability", 165, 1, 10000);
            lapisChestplateDurability = builder.comment("Durability for Lapis Chestplate").defineInRange("chestplate_durability", 240, 1, 10000);
            lapisLeggingsDurability = builder.comment("Durability for Lapis Leggings").defineInRange("leggings_durability", 225, 1, 10000);
            lapisBootsDurability = builder.comment("Durability for Lapis Boots").defineInRange("boots_durability", 195, 1, 10000);
            lapisHelmetProtection = builder.comment("Protection for Lapis Helmet").defineInRange("helmet_protection", 1, 0, 20);
            lapisChestplateProtection = builder.comment("Protection for Lapis Chestplate").defineInRange("chestplate_protection", 3, 0, 20);
            lapisLeggingsProtection = builder.comment("Protection for Lapis Leggings").defineInRange("leggings_protection", 3, 0, 20);
            lapisBootsProtection = builder.comment("Protection for Lapis Boots").defineInRange("boots_protection", 1, 0, 20);
            lapisEnchantment = builder.comment("Enchantment value for Lapis Armor").defineInRange("enchantment", 18, 0, 30);
            lapisToughness = builder.comment("Toughness for Lapis Armor").defineInRange("toughness", 0.0, 0.0, 10.0);
            lapisKnockbackResistance = builder.comment("Knockback resistance for Lapis Armor").defineInRange("knockback_resistance", 0.0, 0.0, 1.0);
            builder.pop();

            // Machine Armor
            builder.push("machine_armor");
            machineHelmetDurability = builder.comment("Durability for Machine Helmet").defineInRange("helmet_durability", 176, 1, 10000);
            machineChestplateDurability = builder.comment("Durability for Machine Chestplate").defineInRange("chestplate_durability", 256, 1, 10000);
            machineLeggingsDurability = builder.comment("Durability for Machine Leggings").defineInRange("leggings_durability", 240, 1, 10000);
            machineBootsDurability = builder.comment("Durability for Machine Boots").defineInRange("boots_durability", 208, 1, 10000);
            machineHelmetProtection = builder.comment("Protection for Machine Helmet").defineInRange("helmet_protection", 2, 0, 20);
            machineChestplateProtection = builder.comment("Protection for Machine Chestplate").defineInRange("chestplate_protection", 6, 0, 20);
            machineLeggingsProtection = builder.comment("Protection for Machine Leggings").defineInRange("leggings_protection", 5, 0, 20);
            machineBootsProtection = builder.comment("Protection for Machine Boots").defineInRange("boots_protection", 2, 0, 20);
            machineEnchantment = builder.comment("Enchantment value for Machine Armor").defineInRange("enchantment", 19, 0, 30);
            machineToughness = builder.comment("Toughness for Machine Armor").defineInRange("toughness", 0.0, 0.0, 10.0);
            machineKnockbackResistance = builder.comment("Knockback resistance for Machine Armor").defineInRange("knockback_resistance", 0.1, 0.0, 1.0);
            builder.pop();

            // Magma Armor
            builder.push("magma_armor");
            magmaHelmetDurability = builder.comment("Durability for Magma Helmet").defineInRange("helmet_durability", 165, 1, 10000);
            magmaChestplateDurability = builder.comment("Durability for Magma Chestplate").defineInRange("chestplate_durability", 240, 1, 10000);
            magmaLeggingsDurability = builder.comment("Durability for Magma Leggings").defineInRange("leggings_durability", 225, 1, 10000);
            magmaBootsDurability = builder.comment("Durability for Magma Boots").defineInRange("boots_durability", 195, 1, 10000);
            magmaHelmetProtection = builder.comment("Protection for Magma Helmet").defineInRange("helmet_protection", 2, 0, 20);
            magmaChestplateProtection = builder.comment("Protection for Magma Chestplate").defineInRange("chestplate_protection", 5, 0, 20);
            magmaLeggingsProtection = builder.comment("Protection for Magma Leggings").defineInRange("leggings_protection", 4, 0, 20);
            magmaBootsProtection = builder.comment("Protection for Magma Boots").defineInRange("boots_protection", 1, 0, 20);
            magmaEnchantment = builder.comment("Enchantment value for Magma Armor").defineInRange("enchantment", 14, 0, 30);
            magmaToughness = builder.comment("Toughness for Magma Armor").defineInRange("toughness", 0.0, 0.0, 10.0);
            magmaKnockbackResistance = builder.comment("Knockback resistance for Magma Armor").defineInRange("knockback_resistance", 0.0, 0.0, 1.0);
            builder.pop();

            // Music Armor
            builder.push("music_armor");
            musicHelmetDurability = builder.comment("Durability for Music Helmet").defineInRange("helmet_durability", 55, 1, 10000);
            musicChestplateDurability = builder.comment("Durability for Music Chestplate").defineInRange("chestplate_durability", 80, 1, 10000);
            musicLeggingsDurability = builder.comment("Durability for Music Leggings").defineInRange("leggings_durability", 75, 1, 10000);
            musicBootsDurability = builder.comment("Durability for Music Boots").defineInRange("boots_durability", 65, 1, 10000);
            musicHelmetProtection = builder.comment("Protection for Music Helmet").defineInRange("helmet_protection", 1, 0, 20);
            musicChestplateProtection = builder.comment("Protection for Music Chestplate").defineInRange("chestplate_protection", 3, 0, 20);
            musicLeggingsProtection = builder.comment("Protection for Music Leggings").defineInRange("leggings_protection", 3, 0, 20);
            musicBootsProtection = builder.comment("Protection for Music Boots").defineInRange("boots_protection", 1, 0, 20);
            musicEnchantment = builder.comment("Enchantment value for Music Armor").defineInRange("enchantment", 12, 0, 30);
            musicToughness = builder.comment("Toughness for Music Armor").defineInRange("toughness", 0.0, 0.0, 10.0);
            musicKnockbackResistance = builder.comment("Knockback resistance for Music Armor").defineInRange("knockback_resistance", 0.0, 0.0, 1.0);
            builder.pop();

            // Obsidian Armor
            builder.push("obsidian_armor");
            obsidianHelmetDurability = builder.comment("Durability for Obsidian Helmet").defineInRange("helmet_durability", 363, 1, 10000);
            obsidianChestplateDurability = builder.comment("Durability for Obsidian Chestplate").defineInRange("chestplate_durability", 528, 1, 10000);
            obsidianLeggingsDurability = builder.comment("Durability for Obsidian Leggings").defineInRange("leggings_durability", 495, 1, 10000);
            obsidianBootsDurability = builder.comment("Durability for Obsidian Boots").defineInRange("boots_durability", 429, 1, 10000);
            obsidianHelmetProtection = builder.comment("Protection for Obsidian Helmet").defineInRange("helmet_protection", 3, 0, 20);
            obsidianChestplateProtection = builder.comment("Protection for Obsidian Chestplate").defineInRange("chestplate_protection", 7, 0, 20);
            obsidianLeggingsProtection = builder.comment("Protection for Obsidian Leggings").defineInRange("leggings_protection", 6, 0, 20);
            obsidianBootsProtection = builder.comment("Protection for Obsidian Boots").defineInRange("boots_protection", 2, 0, 20);
            obsidianEnchantment = builder.comment("Enchantment value for Obsidian Armor").defineInRange("enchantment", 18, 0, 30);
            obsidianToughness = builder.comment("Toughness for Obsidian Armor").defineInRange("toughness", 1.0, 0.0, 10.0);
            obsidianKnockbackResistance = builder.comment("Knockback resistance for Obsidian Armor").defineInRange("knockback_resistance", 0.0, 0.0, 1.0);
            builder.pop();

            // Pot Armor
            builder.push("pot_armor");
            potHelmetDurability = builder.comment("Durability for Pot Helmet").defineInRange("helmet_durability", 55, 1, 10000);
            potChestplateDurability = builder.comment("Durability for Pot Chestplate").defineInRange("chestplate_durability", 80, 1, 10000);
            potLeggingsDurability = builder.comment("Durability for Pot Leggings").defineInRange("leggings_durability", 75, 1, 10000);
            potBootsDurability = builder.comment("Durability for Pot Boots").defineInRange("boots_durability", 65, 1, 10000);
            potHelmetProtection = builder.comment("Protection for Pot Helmet").defineInRange("helmet_protection", 1, 0, 20);
            potChestplateProtection = builder.comment("Protection for Pot Chestplate").defineInRange("chestplate_protection", 3, 0, 20);
            potLeggingsProtection = builder.comment("Protection for Pot Leggings").defineInRange("leggings_protection", 3, 0, 20);
            potBootsProtection = builder.comment("Protection for Pot Boots").defineInRange("boots_protection", 1, 0, 20);
            potEnchantment = builder.comment("Enchantment value for Pot Armor").defineInRange("enchantment", 12, 0, 30);
            potToughness = builder.comment("Toughness for Pot Armor").defineInRange("toughness", 0.0, 0.0, 10.0);
            potKnockbackResistance = builder.comment("Knockback resistance for Pot Armor").defineInRange("knockback_resistance", 0.0, 0.0, 1.0);
            builder.pop();

            // Power Suit Armor
            builder.push("power_suit_armor");
            powerSuitHelmetDurability = builder.comment("Durability for Power Suit Helmet").defineInRange("helmet_durability", 508, 1, 10000);
            powerSuitChestplateDurability = builder.comment("Durability for Power Suit Chestplate").defineInRange("chestplate_durability", 740, 1, 10000);
            powerSuitLeggingsDurability = builder.comment("Durability for Power Suit Leggings").defineInRange("leggings_durability", 693, 1, 10000);
            powerSuitBootsDurability = builder.comment("Durability for Power Suit Boots").defineInRange("boots_durability", 601, 1, 10000);
            powerSuitHelmetProtection = builder.comment("Protection for Power Suit Helmet").defineInRange("helmet_protection", 3, 0, 20);
            powerSuitChestplateProtection = builder.comment("Protection for Power Suit Chestplate").defineInRange("chestplate_protection", 8, 0, 20);
            powerSuitLeggingsProtection = builder.comment("Protection for Power Suit Leggings").defineInRange("leggings_protection", 6, 0, 20);
            powerSuitBootsProtection = builder.comment("Protection for Power Suit Boots").defineInRange("boots_protection", 3, 0, 20);
            powerSuitEnchantment = builder.comment("Enchantment value for Power Suit Armor").defineInRange("enchantment", 19, 0, 30);
            powerSuitToughness = builder.comment("Toughness for Power Suit Armor").defineInRange("toughness", 3.0, 0.0, 10.0);
            powerSuitKnockbackResistance = builder.comment("Knockback resistance for Power Suit Armor").defineInRange("knockback_resistance", 0.1, 0.0, 1.0);
            builder.pop();

            // Quartz Armor
            builder.push("quartz_armor");
            quartzHelmetDurability = builder.comment("Durability for Quartz Helmet").defineInRange("helmet_durability", 165, 1, 10000);
            quartzChestplateDurability = builder.comment("Durability for Quartz Chestplate").defineInRange("chestplate_durability", 240, 1, 10000);
            quartzLeggingsDurability = builder.comment("Durability for Quartz Leggings").defineInRange("leggings_durability", 225, 1, 10000);
            quartzBootsDurability = builder.comment("Durability for Quartz Boots").defineInRange("boots_durability", 195, 1, 10000);
            quartzHelmetProtection = builder.comment("Protection for Quartz Helmet").defineInRange("helmet_protection", 2, 0, 20);
            quartzChestplateProtection = builder.comment("Protection for Quartz Chestplate").defineInRange("chestplate_protection", 2, 0, 20);
            quartzLeggingsProtection = builder.comment("Protection for Quartz Leggings").defineInRange("leggings_protection", 2, 0, 20);
            quartzBootsProtection = builder.comment("Protection for Quartz Boots").defineInRange("boots_protection", 2, 0, 20);
            quartzEnchantment = builder.comment("Enchantment value for Quartz Armor").defineInRange("enchantment", 13, 0, 30);
            quartzToughness = builder.comment("Toughness for Quartz Armor").defineInRange("toughness", 0.0, 0.0, 10.0);
            quartzKnockbackResistance = builder.comment("Knockback resistance for Quartz Armor").defineInRange("knockback_resistance", 0.0, 0.0, 1.0);
            builder.pop();

            // Red Dragon Armor
            builder.push("red_dragon_armor");
            redDragonHelmetDurability = builder.comment("Durability for Red Dragon Helmet").defineInRange("helmet_durability", 291, 1, 10000);
            redDragonChestplateDurability = builder.comment("Durability for Red Dragon Chestplate").defineInRange("chestplate_durability", 424, 1, 10000);
            redDragonLeggingsDurability = builder.comment("Durability for Red Dragon Leggings").defineInRange("leggings_durability", 397, 1, 10000);
            redDragonBootsDurability = builder.comment("Durability for Red Dragon Boots").defineInRange("boots_durability", 344, 1, 10000);
            redDragonHelmetProtection = builder.comment("Protection for Red Dragon Helmet").defineInRange("helmet_protection", 2, 0, 20);
            redDragonChestplateProtection = builder.comment("Protection for Red Dragon Chestplate").defineInRange("chestplate_protection", 7, 0, 20);
            redDragonLeggingsProtection = builder.comment("Protection for Red Dragon Leggings").defineInRange("leggings_protection", 5, 0, 20);
            redDragonBootsProtection = builder.comment("Protection for Red Dragon Boots").defineInRange("boots_protection", 2, 0, 20);
            redDragonEnchantment = builder.comment("Enchantment value for Red Dragon Armor").defineInRange("enchantment", 19, 0, 30);
            redDragonToughness = builder.comment("Toughness for Red Dragon Armor").defineInRange("toughness", 0.0, 0.0, 10.0);
            redDragonKnockbackResistance = builder.comment("Knockback resistance for Red Dragon Armor").defineInRange("knockback_resistance", 0.0, 0.0, 1.0);
            builder.pop();

            // Redstone Armor
            builder.push("redstone_armor");
            redstoneHelmetDurability = builder.comment("Durability for Redstone Helmet").defineInRange("helmet_durability", 165, 1, 10000);
            redstoneChestplateDurability = builder.comment("Durability for Redstone Chestplate").defineInRange("chestplate_durability", 240, 1, 10000);
            redstoneLeggingsDurability = builder.comment("Durability for Redstone Leggings").defineInRange("leggings_durability", 225, 1, 10000);
            redstoneBootsDurability = builder.comment("Durability for Redstone Boots").defineInRange("boots_durability", 195, 1, 10000);
            redstoneHelmetProtection = builder.comment("Protection for Redstone Helmet").defineInRange("helmet_protection", 1, 0, 20);
            redstoneChestplateProtection = builder.comment("Protection for Redstone Chestplate").defineInRange("chestplate_protection", 4, 0, 20);
            redstoneLeggingsProtection = builder.comment("Protection for Redstone Leggings").defineInRange("leggings_protection", 3, 0, 20);
            redstoneBootsProtection = builder.comment("Protection for Redstone Boots").defineInRange("boots_protection", 1, 0, 20);
            redstoneEnchantment = builder.comment("Enchantment value for Redstone Armor").defineInRange("enchantment", 12, 0, 30);
            redstoneToughness = builder.comment("Toughness for Redstone Armor").defineInRange("toughness", 0.0, 0.0, 10.0);
            redstoneKnockbackResistance = builder.comment("Knockback resistance for Redstone Armor").defineInRange("knockback_resistance", 0.0, 0.0, 1.0);
            builder.pop();

            // Reinforced Deepslate Armor
            builder.push("reinforced_deepslate_armor");
            reinforcedDeepslateHelmetDurability = builder.comment("Durability for Reinforced Deepslate Helmet").defineInRange("helmet_durability", 338, 1, 10000);
            reinforcedDeepslateChestplateDurability = builder.comment("Durability for Reinforced Deepslate Chestplate").defineInRange("chestplate_durability", 432, 1, 10000);
            reinforcedDeepslateLeggingsDurability = builder.comment("Durability for Reinforced Deepslate Leggings").defineInRange("leggings_durability", 405, 1, 10000);
            reinforcedDeepslateBootsDurability = builder.comment("Durability for Reinforced Deepslate Boots").defineInRange("boots_durability", 351, 1, 10000);
            reinforcedDeepslateHelmetProtection = builder.comment("Protection for Reinforced Deepslate Helmet").defineInRange("helmet_protection", 1, 0, 20);
            reinforcedDeepslateChestplateProtection = builder.comment("Protection for Reinforced Deepslate Chestplate").defineInRange("chestplate_protection", 4, 0, 20);
            reinforcedDeepslateLeggingsProtection = builder.comment("Protection for Reinforced Deepslate Leggings").defineInRange("leggings_protection", 3, 0, 20);
            reinforcedDeepslateBootsProtection = builder.comment("Protection for Reinforced Deepslate Boots").defineInRange("boots_protection", 1, 0, 20);
            reinforcedDeepslateEnchantment = builder.comment("Enchantment value for Reinforced Deepslate Armor").defineInRange("enchantment", 18, 0, 30);
            reinforcedDeepslateToughness = builder.comment("Toughness for Reinforced Deepslate Armor").defineInRange("toughness", 0.5, 0.0, 10.0);
            reinforcedDeepslateKnockbackResistance = builder.comment("Knockback resistance for Reinforced Deepslate Armor").defineInRange("knockback_resistance", 0.1, 0.0, 1.0);
            builder.pop();

            // RGB Armor
            builder.push("rgb_armor");
            rgbHelmetDurability = builder.comment("Durability for RGB Helmet").defineInRange("helmet_durability", 27, 1, 10000);
            rgbChestplateDurability = builder.comment("Durability for RGB Chestplate").defineInRange("chestplate_durability", 40, 1, 10000);
            rgbLeggingsDurability = builder.comment("Durability for RGB Leggings").defineInRange("leggings_durability", 37, 1, 10000);
            rgbBootsDurability = builder.comment("Durability for RGB Boots").defineInRange("boots_durability", 32, 1, 10000);
            rgbHelmetProtection = builder.comment("Protection for RGB Helmet").defineInRange("helmet_protection", 1, 0, 20);
            rgbChestplateProtection = builder.comment("Protection for RGB Chestplate").defineInRange("chestplate_protection", 1, 0, 20);
            rgbLeggingsProtection = builder.comment("Protection for RGB Leggings").defineInRange("leggings_protection", 1, 0, 20);
            rgbBootsProtection = builder.comment("Protection for RGB Boots").defineInRange("boots_protection", 1, 0, 20);
            rgbEnchantment = builder.comment("Enchantment value for RGB Armor").defineInRange("enchantment", 16, 0, 30);
            rgbToughness = builder.comment("Toughness for RGB Armor").defineInRange("toughness", 0.0, 0.0, 10.0);
            rgbKnockbackResistance = builder.comment("Knockback resistance for RGB Armor").defineInRange("knockback_resistance", 0.0, 0.0, 1.0);
            builder.pop();

            // Ruby Armor
            builder.push("ruby_armor");
            rubyHelmetDurability = builder.comment("Durability for Ruby Helmet").defineInRange("helmet_durability", 255, 1, 10000);
            rubyChestplateDurability = builder.comment("Durability for Ruby Chestplate").defineInRange("chestplate_durability", 372, 1, 10000);
            rubyLeggingsDurability = builder.comment("Durability for Ruby Leggings").defineInRange("leggings_durability", 318, 1, 10000);
            rubyBootsDurability = builder.comment("Durability for Ruby Boots").defineInRange("boots_durability", 302, 1, 10000);
            rubyHelmetProtection = builder.comment("Protection for Ruby Helmet").defineInRange("helmet_protection", 3, 0, 20);
            rubyChestplateProtection = builder.comment("Protection for Ruby Chestplate").defineInRange("chestplate_protection", 5, 0, 20);
            rubyLeggingsProtection = builder.comment("Protection for Ruby Leggings").defineInRange("leggings_protection", 6, 0, 20);
            rubyBootsProtection = builder.comment("Protection for Ruby Boots").defineInRange("boots_protection", 3, 0, 20);
            rubyEnchantment = builder.comment("Enchantment value for Ruby Armor").defineInRange("enchantment", 19, 0, 30);
            rubyToughness = builder.comment("Toughness for Ruby Armor").defineInRange("toughness", 2.0, 0.0, 10.0);
            rubyKnockbackResistance = builder.comment("Knockback resistance for Ruby Armor").defineInRange("knockback_resistance", 0.0, 0.0, 1.0);
            builder.pop();

            // Sculk Armor
            builder.push("sculk_armor");
            sculkHelmetDurability = builder.comment("Durability for Sculk Helmet").defineInRange("helmet_durability", 110, 1, 10000);
            sculkChestplateDurability = builder.comment("Durability for Sculk Chestplate").defineInRange("chestplate_durability", 160, 1, 10000);
            sculkLeggingsDurability = builder.comment("Durability for Sculk Leggings").defineInRange("leggings_durability", 150, 1, 10000);
            sculkBootsDurability = builder.comment("Durability for Sculk Boots").defineInRange("boots_durability", 130, 1, 10000);
            sculkHelmetProtection = builder.comment("Protection for Sculk Helmet").defineInRange("helmet_protection", 2, 0, 20);
            sculkChestplateProtection = builder.comment("Protection for Sculk Chestplate").defineInRange("chestplate_protection", 5, 0, 20);
            sculkLeggingsProtection = builder.comment("Protection for Sculk Leggings").defineInRange("leggings_protection", 4, 0, 20);
            sculkBootsProtection = builder.comment("Protection for Sculk Boots").defineInRange("boots_protection", 2, 0, 20);
            sculkEnchantment = builder.comment("Enchantment value for Sculk Armor").defineInRange("enchantment", 16, 0, 30);
            sculkToughness = builder.comment("Toughness for Sculk Armor").defineInRange("toughness", 0.0, 0.0, 10.0);
            sculkKnockbackResistance = builder.comment("Knockback resistance for Sculk Armor").defineInRange("knockback_resistance", 0.0, 0.0, 1.0);
            builder.pop();

            // Shulker Armor
            builder.push("shulker_armor");
            shulkerHelmetDurability = builder.comment("Durability for Shulker Helmet").defineInRange("helmet_durability", 327, 1, 10000);
            shulkerChestplateDurability = builder.comment("Durability for Shulker Chestplate").defineInRange("chestplate_durability", 476, 1, 10000);
            shulkerLeggingsDurability = builder.comment("Durability for Shulker Leggings").defineInRange("leggings_durability", 446, 1, 10000);
            shulkerBootsDurability = builder.comment("Durability for Shulker Boots").defineInRange("boots_durability", 386, 1, 10000);
            shulkerHelmetProtection = builder.comment("Protection for Shulker Helmet").defineInRange("helmet_protection", 3, 0, 20);
            shulkerChestplateProtection = builder.comment("Protection for Shulker Chestplate").defineInRange("chestplate_protection", 6, 0, 20);
            shulkerLeggingsProtection = builder.comment("Protection for Shulker Leggings").defineInRange("leggings_protection", 5, 0, 20);
            shulkerBootsProtection = builder.comment("Protection for Shulker Boots").defineInRange("boots_protection", 3, 0, 20);
            shulkerEnchantment = builder.comment("Enchantment value for Shulker Armor").defineInRange("enchantment", 17, 0, 30);
            shulkerToughness = builder.comment("Toughness for Shulker Armor").defineInRange("toughness", 1.0, 0.0, 10.0);
            shulkerKnockbackResistance = builder.comment("Knockback resistance for Shulker Armor").defineInRange("knockback_resistance", 0.0, 0.0, 1.0);
            builder.pop();

            // Skeleton Armor
            builder.push("skeleton_armor");
            skeletonHelmetDurability = builder.comment("Durability for Skeleton Helmet").defineInRange("helmet_durability", 193, 1, 10000);
            skeletonChestplateDurability = builder.comment("Durability for Skeleton Chestplate").defineInRange("chestplate_durability", 280, 1, 10000);
            skeletonLeggingsDurability = builder.comment("Durability for Skeleton Leggings").defineInRange("leggings_durability", 263, 1, 10000);
            skeletonBootsDurability = builder.comment("Durability for Skeleton Boots").defineInRange("boots_durability", 228, 1, 10000);
            skeletonHelmetProtection = builder.comment("Protection for Skeleton Helmet").defineInRange("helmet_protection", 2, 0, 20);
            skeletonChestplateProtection = builder.comment("Protection for Skeleton Chestplate").defineInRange("chestplate_protection", 6, 0, 20);
            skeletonLeggingsProtection = builder.comment("Protection for Skeleton Leggings").defineInRange("leggings_protection", 5, 0, 20);
            skeletonBootsProtection = builder.comment("Protection for Skeleton Boots").defineInRange("boots_protection", 2, 0, 20);
            skeletonEnchantment = builder.comment("Enchantment value for Skeleton Armor").defineInRange("enchantment", 11, 0, 30);
            skeletonToughness = builder.comment("Toughness for Skeleton Armor").defineInRange("toughness", 0.6, 0.0, 10.0);
            skeletonKnockbackResistance = builder.comment("Knockback resistance for Skeleton Armor").defineInRange("knockback_resistance", 0.0, 0.0, 1.0);
            builder.pop();

            
            // Sniffer Armor
            builder.push("sniffer_armor");
            snifferHelmetDurability = builder.comment("Durability for Sniffer Helmet").defineInRange("helmet_durability", 99, 1, 10000);
            snifferChestplateDurability = builder.comment("Durability for Sniffer Chestplate").defineInRange("chestplate_durability", 144, 1, 10000);
            snifferLeggingsDurability = builder.comment("Durability for Sniffer Leggings").defineInRange("leggings_durability", 135, 1, 10000);
            snifferBootsDurability = builder.comment("Durability for Sniffer Boots").defineInRange("boots_durability", 117, 1, 10000);
            snifferHelmetProtection = builder.comment("Protection for Sniffer Helmet").defineInRange("helmet_protection", 1, 0, 20);
            snifferChestplateProtection = builder.comment("Protection for Sniffer Chestplate").defineInRange("chestplate_protection", 3, 0, 20);
            snifferLeggingsProtection = builder.comment("Protection for Sniffer Leggings").defineInRange("leggings_protection", 2, 0, 20);
            snifferBootsProtection = builder.comment("Protection for Sniffer Boots").defineInRange("boots_protection", 1, 0, 20);
            snifferEnchantment = builder.comment("Enchantment value for Sniffer Armor").defineInRange("enchantment", 14, 0, 30);
            snifferToughness = builder.comment("Toughness for Sniffer Armor").defineInRange("toughness", 0.0, 0.0, 10.0);
            snifferKnockbackResistance = builder.comment("Knockback resistance for Sniffer Armor").defineInRange("knockback_resistance", 0.0, 0.0, 1.0);
            builder.pop();

            // TNT Armor
            builder.push("tnt_armor");
            tntHelmetDurability = builder.comment("Durability for TNT Helmet").defineInRange("helmet_durability", 55, 1, 10000);
            tntChestplateDurability = builder.comment("Durability for TNT Chestplate").defineInRange("chestplate_durability", 80, 1, 10000);
            tntLeggingsDurability = builder.comment("Durability for TNT Leggings").defineInRange("leggings_durability", 75, 1, 10000);
            tntBootsDurability = builder.comment("Durability for TNT Boots").defineInRange("boots_durability", 65, 1, 10000);
            tntHelmetProtection = builder.comment("Protection for TNT Helmet").defineInRange("helmet_protection", 1, 0, 20);
            tntChestplateProtection = builder.comment("Protection for TNT Chestplate").defineInRange("chestplate_protection", 2, 0, 20);
            tntLeggingsProtection = builder.comment("Protection for TNT Leggings").defineInRange("leggings_protection", 1, 0, 20);
            tntBootsProtection = builder.comment("Protection for TNT Boots").defineInRange("boots_protection", 1, 0, 20);
            tntEnchantment = builder.comment("Enchantment value for TNT Armor").defineInRange("enchantment", 10, 0, 30);
            tntToughness = builder.comment("Toughness for TNT Armor").defineInRange("toughness", 0.0, 0.0, 10.0);
            tntKnockbackResistance = builder.comment("Knockback resistance for TNT Armor").defineInRange("knockback_resistance", 0.0, 0.0, 1.0);
            builder.pop();

            // Totem Armor
            builder.push("totem_armor");
            totemHelmetDurability = builder.comment("Durability for Totem Helmet").defineInRange("helmet_durability", 181, 1, 10000);
            totemChestplateDurability = builder.comment("Durability for Totem Chestplate").defineInRange("chestplate_durability", 264, 1, 10000);
            totemLeggingsDurability = builder.comment("Durability for Totem Leggings").defineInRange("leggings_durability", 247, 1, 10000);
            totemBootsDurability = builder.comment("Durability for Totem Boots").defineInRange("boots_durability", 214, 1, 10000);
            totemHelmetProtection = builder.comment("Protection for Totem Helmet").defineInRange("helmet_protection", 3, 0, 20);
            totemChestplateProtection = builder.comment("Protection for Totem Chestplate").defineInRange("chestplate_protection", 8, 0, 20);
            totemLeggingsProtection = builder.comment("Protection for Totem Leggings").defineInRange("leggings_protection", 6, 0, 20);
            totemBootsProtection = builder.comment("Protection for Totem Boots").defineInRange("boots_protection", 3, 0, 20);
            totemEnchantment = builder.comment("Enchantment value for Totem Armor").defineInRange("enchantment", 18, 0, 30);
            totemToughness = builder.comment("Toughness for Totem Armor").defineInRange("toughness", 0.0, 0.0, 10.0);
            totemKnockbackResistance = builder.comment("Knockback resistance for Totem Armor").defineInRange("knockback_resistance", 0.0, 0.0, 1.0);
            builder.pop();

            // Wither Skeleton Armor
            builder.push("wither_skeleton_armor");
            witherSkeletonHelmetDurability = builder.comment("Durability for Wither Skeleton Helmet").defineInRange("helmet_durability", 291, 1, 10000);
            witherSkeletonChestplateDurability = builder.comment("Durability for Wither Skeleton Chestplate").defineInRange("chestplate_durability", 424, 1, 10000);
            witherSkeletonLeggingsDurability = builder.comment("Durability for Wither Skeleton Leggings").defineInRange("leggings_durability", 397, 1, 10000);
            witherSkeletonBootsDurability = builder.comment("Durability for Wither Skeleton Boots").defineInRange("boots_durability", 344, 1, 10000);
            witherSkeletonHelmetProtection = builder.comment("Protection for Wither Skeleton Helmet").defineInRange("helmet_protection", 2, 0, 20);
            witherSkeletonChestplateProtection = builder.comment("Protection for Wither Skeleton Chestplate").defineInRange("chestplate_protection", 7, 0, 20);
            witherSkeletonLeggingsProtection = builder.comment("Protection for Wither Skeleton Leggings").defineInRange("leggings_protection", 5, 0, 20);
            witherSkeletonBootsProtection = builder.comment("Protection for Wither Skeleton Boots").defineInRange("boots_protection", 2, 0, 20);
            witherSkeletonEnchantment = builder.comment("Enchantment value for Wither Skeleton Armor").defineInRange("enchantment", 16, 0, 30);
            witherSkeletonToughness = builder.comment("Toughness for Wither Skeleton Armor").defineInRange("toughness", 0.5, 0.0, 10.0);
            witherSkeletonKnockbackResistance = builder.comment("Knockback resistance for Wither Skeleton Armor").defineInRange("knockback_resistance", 0.0, 0.0, 1.0);
            builder.pop();

        }
    }
}
