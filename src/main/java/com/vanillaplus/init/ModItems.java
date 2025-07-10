package com.vanillaplus.init;

import com.vanillaplus.VanillaPlus;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import java.util.List;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, VanillaPlus.MOD_ID);
    
    // Ancient Debris Armor Set
    public static final RegistryObject<Item> ANCIENT_DEBRIS_HELMET = ITEMS.register("ancient_debris_helmet",
            () -> new CustomArmorItem(ModArmorMaterials.ANCIENT_DEBRIS, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> ANCIENT_DEBRIS_CHESTPLATE = ITEMS.register("ancient_debris_chestplate",
            () -> new CustomArmorItem(ModArmorMaterials.ANCIENT_DEBRIS, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> ANCIENT_DEBRIS_LEGGINGS = ITEMS.register("ancient_debris_leggings",
            () -> new CustomArmorItem(ModArmorMaterials.ANCIENT_DEBRIS, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> ANCIENT_DEBRIS_BOOTS = ITEMS.register("ancient_debris_boots",
            () -> new CustomArmorItem(ModArmorMaterials.ANCIENT_DEBRIS, ArmorItem.Type.BOOTS, new Item.Properties()));

    // Amethyst Armor Set
    public static final RegistryObject<Item> AMETHYST_HELMET = ITEMS.register("amethyst_helmet",
            () -> new CustomArmorItem(ModArmorMaterials.AMETHYST, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> AMETHYST_CHESTPLATE = ITEMS.register("amethyst_chestplate",
            () -> new CustomArmorItem(ModArmorMaterials.AMETHYST, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> AMETHYST_LEGGINGS = ITEMS.register("amethyst_leggings",
            () -> new CustomArmorItem(ModArmorMaterials.AMETHYST, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> AMETHYST_BOOTS = ITEMS.register("amethyst_boots",
            () -> new CustomArmorItem(ModArmorMaterials.AMETHYST, ArmorItem.Type.BOOTS, new Item.Properties()));

    // Bedrock Armor Set
    public static final RegistryObject<Item> BEDROCK_HELMET = ITEMS.register("bedrock_helmet",
            () -> new CustomArmorItem(ModArmorMaterials.BEDROCK, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> BEDROCK_CHESTPLATE = ITEMS.register("bedrock_chestplate",
            () -> new CustomArmorItem(ModArmorMaterials.BEDROCK, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> BEDROCK_LEGGINGS = ITEMS.register("bedrock_leggings",
            () -> new CustomArmorItem(ModArmorMaterials.BEDROCK, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> BEDROCK_BOOTS = ITEMS.register("bedrock_boots",
            () -> new CustomArmorItem(ModArmorMaterials.BEDROCK, ArmorItem.Type.BOOTS, new Item.Properties()));

    // Bee Armor Set
    public static final RegistryObject<Item> BEE_HELMET = ITEMS.register("bee_helmet",
            () -> new BeeArmorItem(ModArmorMaterials.BEE, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> BEE_CHESTPLATE = ITEMS.register("bee_chestplate",
            () -> new BeeArmorItem(ModArmorMaterials.BEE, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> BEE_LEGGINGS = ITEMS.register("bee_leggings",
            () -> new BeeArmorItem(ModArmorMaterials.BEE, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> BEE_BOOTS = ITEMS.register("bee_boots",
            () -> new BeeArmorItem(ModArmorMaterials.BEE, ArmorItem.Type.BOOTS, new Item.Properties()));

    // Bone Armor Set
    public static final RegistryObject<Item> BONE_HELMET = ITEMS.register("bone_helmet",
            () -> new CustomArmorItem(ModArmorMaterials.BONE, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> BONE_CHESTPLATE = ITEMS.register("bone_chestplate",
            () -> new CustomArmorItem(ModArmorMaterials.BONE, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> BONE_LEGGINGS = ITEMS.register("bone_leggings",
            () -> new CustomArmorItem(ModArmorMaterials.BONE, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> BONE_BOOTS = ITEMS.register("bone_boots",
            () -> new CustomArmorItem(ModArmorMaterials.BONE, ArmorItem.Type.BOOTS, new Item.Properties()));

    // Cactus Armor Set
    public static final RegistryObject<Item> CACTUS_HELMET = ITEMS.register("cactus_helmet",
            () -> new CustomArmorItem(ModArmorMaterials.CACTUS, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> CACTUS_CHESTPLATE = ITEMS.register("cactus_chestplate",
            () -> new CustomArmorItem(ModArmorMaterials.CACTUS, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> CACTUS_LEGGINGS = ITEMS.register("cactus_leggings",
            () -> new CustomArmorItem(ModArmorMaterials.CACTUS, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> CACTUS_BOOTS = ITEMS.register("cactus_boots",
            () -> new CustomArmorItem(ModArmorMaterials.CACTUS, ArmorItem.Type.BOOTS, new Item.Properties()));

    // Coal Armor Set
    public static final RegistryObject<Item> COAL_HELMET = ITEMS.register("coal_helmet",
            () -> new CustomArmorItem(ModArmorMaterials.COAL, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> COAL_CHESTPLATE = ITEMS.register("coal_chestplate",
            () -> new CustomArmorItem(ModArmorMaterials.COAL, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> COAL_LEGGINGS = ITEMS.register("coal_leggings",
            () -> new CustomArmorItem(ModArmorMaterials.COAL, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> COAL_BOOTS = ITEMS.register("coal_boots",
            () -> new CustomArmorItem(ModArmorMaterials.COAL, ArmorItem.Type.BOOTS, new Item.Properties()));

    // Copper Armor Set
    public static final RegistryObject<Item> COPPER_HELMET = ITEMS.register("copper_helmet",
            () -> new CustomArmorItem(ModArmorMaterials.COPPER, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> COPPER_CHESTPLATE = ITEMS.register("copper_chestplate",
            () -> new CustomArmorItem(ModArmorMaterials.COPPER, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> COPPER_LEGGINGS = ITEMS.register("copper_leggings",
            () -> new CustomArmorItem(ModArmorMaterials.COPPER, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> COPPER_BOOTS = ITEMS.register("copper_boots",
            () -> new CustomArmorItem(ModArmorMaterials.COPPER, ArmorItem.Type.BOOTS, new Item.Properties()));

    // Crafting Armor Set
    public static final RegistryObject<Item> CRAFTING_HELMET = ITEMS.register("crafting_helmet",
            () -> new CustomArmorItem(ModArmorMaterials.CRAFTING, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> CRAFTING_CHESTPLATE = ITEMS.register("crafting_chestplate",
            () -> new CustomArmorItem(ModArmorMaterials.CRAFTING, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> CRAFTING_LEGGINGS = ITEMS.register("crafting_leggings",
            () -> new CustomArmorItem(ModArmorMaterials.CRAFTING, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> CRAFTING_BOOTS = ITEMS.register("crafting_boots",
            () -> new CustomArmorItem(ModArmorMaterials.CRAFTING, ArmorItem.Type.BOOTS, new Item.Properties()));

    // Dripstone Armor Set
    public static final RegistryObject<Item> DRIPSTONE_HELMET = ITEMS.register("dripstone_helmet",
            () -> new CustomArmorItem(ModArmorMaterials.DRIPSTONE, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> DRIPSTONE_CHESTPLATE = ITEMS.register("dripstone_chestplate",
            () -> new CustomArmorItem(ModArmorMaterials.DRIPSTONE, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> DRIPSTONE_LEGGINGS = ITEMS.register("dripstone_leggings",
            () -> new CustomArmorItem(ModArmorMaterials.DRIPSTONE, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> DRIPSTONE_BOOTS = ITEMS.register("dripstone_boots",
            () -> new CustomArmorItem(ModArmorMaterials.DRIPSTONE, ArmorItem.Type.BOOTS, new Item.Properties()));

    // Emerald Armor Set
    public static final RegistryObject<Item> EMERALD_HELMET = ITEMS.register("emerald_helmet",
            () -> new CustomArmorItem(ModArmorMaterials.EMERALD, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> EMERALD_CHESTPLATE = ITEMS.register("emerald_chestplate",
            () -> new CustomArmorItem(ModArmorMaterials.EMERALD, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> EMERALD_LEGGINGS = ITEMS.register("emerald_leggings",
            () -> new CustomArmorItem(ModArmorMaterials.EMERALD, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> EMERALD_BOOTS = ITEMS.register("emerald_boots",
            () -> new CustomArmorItem(ModArmorMaterials.EMERALD, ArmorItem.Type.BOOTS, new Item.Properties()));

    // Ender Dragon Armor Set
    public static final RegistryObject<Item> ENDER_DRAGON_HELMET = ITEMS.register("ender_dragon_helmet",
            () -> new EnderDragonArmorItem(ModArmorMaterials.ENDER_DRAGON, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> ENDER_DRAGON_CHESTPLATE = ITEMS.register("ender_dragon_chestplate",
            () -> new EnderDragonArmorItem(ModArmorMaterials.ENDER_DRAGON, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> ENDER_DRAGON_LEGGINGS = ITEMS.register("ender_dragon_leggings",
            () -> new EnderDragonArmorItem(ModArmorMaterials.ENDER_DRAGON, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> ENDER_DRAGON_BOOTS = ITEMS.register("ender_dragon_boots",
            () -> new EnderDragonArmorItem(ModArmorMaterials.ENDER_DRAGON, ArmorItem.Type.BOOTS, new Item.Properties()));

    // Galaxy Armor Set
    public static final RegistryObject<Item> GALAXY_HELMET = ITEMS.register("galaxy_helmet",
            () -> new GalaxyArmorItem(ModArmorMaterials.GALAXY, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> GALAXY_CHESTPLATE = ITEMS.register("galaxy_chestplate",
            () -> new GalaxyArmorItem(ModArmorMaterials.GALAXY, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> GALAXY_LEGGINGS = ITEMS.register("galaxy_leggings",
            () -> new GalaxyArmorItem(ModArmorMaterials.GALAXY, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> GALAXY_BOOTS = ITEMS.register("galaxy_boots",
            () -> new GalaxyArmorItem(ModArmorMaterials.GALAXY, ArmorItem.Type.BOOTS, new Item.Properties()));

    // Gilded Armor Set
    public static final RegistryObject<Item> GILDED_HELMET = ITEMS.register("gilded_helmet",
            () -> new CustomArmorItem(ModArmorMaterials.GILDED, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> GILDED_CHESTPLATE = ITEMS.register("gilded_chestplate",
            () -> new CustomArmorItem(ModArmorMaterials.GILDED, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> GILDED_LEGGINGS = ITEMS.register("gilded_leggings",
            () -> new CustomArmorItem(ModArmorMaterials.GILDED, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> GILDED_BOOTS = ITEMS.register("gilded_boots",
            () -> new CustomArmorItem(ModArmorMaterials.GILDED, ArmorItem.Type.BOOTS, new Item.Properties()));

    // Glass Armor Set
    public static final RegistryObject<Item> GLASS_HELMET = ITEMS.register("glass_helmet",
            () -> new CustomArmorItem(ModArmorMaterials.GLASS, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> GLASS_CHESTPLATE = ITEMS.register("glass_chestplate",
            () -> new CustomArmorItem(ModArmorMaterials.GLASS, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> GLASS_LEGGINGS = ITEMS.register("glass_leggings",
            () -> new CustomArmorItem(ModArmorMaterials.GLASS, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> GLASS_BOOTS = ITEMS.register("glass_boots",
            () -> new CustomArmorItem(ModArmorMaterials.GLASS, ArmorItem.Type.BOOTS, new Item.Properties()));

    // Guardian Armor Set
    public static final RegistryObject<Item> GUARDIAN_HELMET = ITEMS.register("guardian_helmet",
            () -> new GuardianArmorItem(ModArmorMaterials.GUARDIAN, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> GUARDIAN_CHESTPLATE = ITEMS.register("guardian_chestplate",
            () -> new GuardianArmorItem(ModArmorMaterials.GUARDIAN, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> GUARDIAN_LEGGINGS = ITEMS.register("guardian_leggings",
            () -> new GuardianArmorItem(ModArmorMaterials.GUARDIAN, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> GUARDIAN_BOOTS = ITEMS.register("guardian_boots",
            () -> new GuardianArmorItem(ModArmorMaterials.GUARDIAN, ArmorItem.Type.BOOTS, new Item.Properties()));

    // Lapis Armor Set
    public static final RegistryObject<Item> LAPIS_HELMET = ITEMS.register("lapis_helmet",
            () -> new CustomArmorItem(ModArmorMaterials.LAPIS, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> LAPIS_CHESTPLATE = ITEMS.register("lapis_chestplate",
            () -> new CustomArmorItem(ModArmorMaterials.LAPIS, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> LAPIS_LEGGINGS = ITEMS.register("lapis_leggings",
            () -> new CustomArmorItem(ModArmorMaterials.LAPIS, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> LAPIS_BOOTS = ITEMS.register("lapis_boots",
            () -> new CustomArmorItem(ModArmorMaterials.LAPIS, ArmorItem.Type.BOOTS, new Item.Properties()));

    // Machine Armor Set
    public static final RegistryObject<Item> MACHINE_HELMET = ITEMS.register("machine_helmet",
            () -> new MachineArmorItem(ModArmorMaterials.MACHINE, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> MACHINE_CHESTPLATE = ITEMS.register("machine_chestplate",
            () -> new MachineArmorItem(ModArmorMaterials.MACHINE, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> MACHINE_LEGGINGS = ITEMS.register("machine_leggings",
            () -> new MachineArmorItem(ModArmorMaterials.MACHINE, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> MACHINE_BOOTS = ITEMS.register("machine_boots",
            () -> new MachineArmorItem(ModArmorMaterials.MACHINE, ArmorItem.Type.BOOTS, new Item.Properties()));

    // Magma Armor Set
    public static final RegistryObject<Item> MAGMA_HELMET = ITEMS.register("magma_helmet",
            () -> new MagmaArmorItem(ModArmorMaterials.MAGMA, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> MAGMA_CHESTPLATE = ITEMS.register("magma_chestplate",
            () -> new MagmaArmorItem(ModArmorMaterials.MAGMA, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> MAGMA_LEGGINGS = ITEMS.register("magma_leggings",
            () -> new MagmaArmorItem(ModArmorMaterials.MAGMA, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> MAGMA_BOOTS = ITEMS.register("magma_boots",
            () -> new MagmaArmorItem(ModArmorMaterials.MAGMA, ArmorItem.Type.BOOTS, new Item.Properties()));

    // Music Armor Set
    public static final RegistryObject<Item> MUSIC_HELMET = ITEMS.register("music_helmet",
            () -> new MusicArmorItem(ModArmorMaterials.MUSIC, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> MUSIC_CHESTPLATE = ITEMS.register("music_chestplate",
            () -> new MusicArmorItem(ModArmorMaterials.MUSIC, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> MUSIC_LEGGINGS = ITEMS.register("music_leggings",
            () -> new MusicArmorItem(ModArmorMaterials.MUSIC, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> MUSIC_BOOTS = ITEMS.register("music_boots",
            () -> new MusicArmorItem(ModArmorMaterials.MUSIC, ArmorItem.Type.BOOTS, new Item.Properties()));

    // Obsidian Armor Set (Animated)
    public static final RegistryObject<Item> OBSIDIAN_HELMET = ITEMS.register("obsidian_helmet",
            () -> new ObsidianArmorItem(ModArmorMaterials.OBSIDIAN, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> OBSIDIAN_CHESTPLATE = ITEMS.register("obsidian_chestplate",
            () -> new ObsidianArmorItem(ModArmorMaterials.OBSIDIAN, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> OBSIDIAN_LEGGINGS = ITEMS.register("obsidian_leggings",
            () -> new ObsidianArmorItem(ModArmorMaterials.OBSIDIAN, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> OBSIDIAN_BOOTS = ITEMS.register("obsidian_boots",
            () -> new ObsidianArmorItem(ModArmorMaterials.OBSIDIAN, ArmorItem.Type.BOOTS, new Item.Properties()));

    // Pot Armor Set
    public static final RegistryObject<Item> POT_HELMET = ITEMS.register("pot_helmet",
            () -> new PotArmorItem(ModArmorMaterials.POT, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> POT_CHESTPLATE = ITEMS.register("pot_chestplate",
            () -> new PotArmorItem(ModArmorMaterials.POT, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> POT_LEGGINGS = ITEMS.register("pot_leggings",
            () -> new PotArmorItem(ModArmorMaterials.POT, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> POT_BOOTS = ITEMS.register("pot_boots",
            () -> new PotArmorItem(ModArmorMaterials.POT, ArmorItem.Type.BOOTS, new Item.Properties()));

    // Power Suit Armor Set
    public static final RegistryObject<Item> POWER_SUIT_HELMET = ITEMS.register("power_suit_helmet",
            () -> new CustomArmorItem(ModArmorMaterials.POWER_SUIT, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> POWER_SUIT_CHESTPLATE = ITEMS.register("power_suit_chestplate",
            () -> new CustomArmorItem(ModArmorMaterials.POWER_SUIT, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> POWER_SUIT_LEGGINGS = ITEMS.register("power_suit_leggings",
            () -> new CustomArmorItem(ModArmorMaterials.POWER_SUIT, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> POWER_SUIT_BOOTS = ITEMS.register("power_suit_boots",
            () -> new CustomArmorItem(ModArmorMaterials.POWER_SUIT, ArmorItem.Type.BOOTS, new Item.Properties()));

    // Quartz Armor Set
    public static final RegistryObject<Item> QUARTZ_HELMET = ITEMS.register("quartz_helmet",
            () -> new CustomArmorItem(ModArmorMaterials.QUARTZ, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> QUARTZ_CHESTPLATE = ITEMS.register("quartz_chestplate",
            () -> new CustomArmorItem(ModArmorMaterials.QUARTZ, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> QUARTZ_LEGGINGS = ITEMS.register("quartz_leggings",
            () -> new CustomArmorItem(ModArmorMaterials.QUARTZ, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> QUARTZ_BOOTS = ITEMS.register("quartz_boots",
            () -> new CustomArmorItem(ModArmorMaterials.QUARTZ, ArmorItem.Type.BOOTS, new Item.Properties()));

    // Red Dragon Armor Set
    public static final RegistryObject<Item> RED_DRAGON_HELMET = ITEMS.register("red_dragon_helmet",
            () -> new RedDragonArmorItem(ModArmorMaterials.RED_DRAGON, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> RED_DRAGON_CHESTPLATE = ITEMS.register("red_dragon_chestplate",
            () -> new RedDragonArmorItem(ModArmorMaterials.RED_DRAGON, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> RED_DRAGON_LEGGINGS = ITEMS.register("red_dragon_leggings",
            () -> new RedDragonArmorItem(ModArmorMaterials.RED_DRAGON, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> RED_DRAGON_BOOTS = ITEMS.register("red_dragon_boots",
            () -> new RedDragonArmorItem(ModArmorMaterials.RED_DRAGON, ArmorItem.Type.BOOTS, new Item.Properties()));

    // Redstone Armor Set
    public static final RegistryObject<Item> REDSTONE_HELMET = ITEMS.register("redstone_helmet",
            () -> new CustomArmorItem(ModArmorMaterials.REDSTONE, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> REDSTONE_CHESTPLATE = ITEMS.register("redstone_chestplate",
            () -> new CustomArmorItem(ModArmorMaterials.REDSTONE, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> REDSTONE_LEGGINGS = ITEMS.register("redstone_leggings",
            () -> new CustomArmorItem(ModArmorMaterials.REDSTONE, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> REDSTONE_BOOTS = ITEMS.register("redstone_boots",
            () -> new CustomArmorItem(ModArmorMaterials.REDSTONE, ArmorItem.Type.BOOTS, new Item.Properties()));

    // Reinforced Deepslate Armor Set
    public static final RegistryObject<Item> REINFORCED_DEEPSLATE_HELMET = ITEMS.register("reinforced_deepslate_helmet",
            () -> new CustomArmorItem(ModArmorMaterials.REINFORCED_DEEPSLATE, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> REINFORCED_DEEPSLATE_CHESTPLATE = ITEMS.register("reinforced_deepslate_chestplate",
            () -> new CustomArmorItem(ModArmorMaterials.REINFORCED_DEEPSLATE, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> REINFORCED_DEEPSLATE_LEGGINGS = ITEMS.register("reinforced_deepslate_leggings",
            () -> new CustomArmorItem(ModArmorMaterials.REINFORCED_DEEPSLATE, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> REINFORCED_DEEPSLATE_BOOTS = ITEMS.register("reinforced_deepslate_boots",
            () -> new CustomArmorItem(ModArmorMaterials.REINFORCED_DEEPSLATE, ArmorItem.Type.BOOTS, new Item.Properties()));

    // RGB Armor Set
    public static final RegistryObject<Item> RGB_HELMET = ITEMS.register("rgb_helmet",
            () -> new RgbArmorItem(ModArmorMaterials.RGB, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> RGB_CHESTPLATE = ITEMS.register("rgb_chestplate",
            () -> new RgbArmorItem(ModArmorMaterials.RGB, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> RGB_LEGGINGS = ITEMS.register("rgb_leggings",
            () -> new RgbArmorItem(ModArmorMaterials.RGB, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> RGB_BOOTS = ITEMS.register("rgb_boots",
            () -> new RgbArmorItem(ModArmorMaterials.RGB, ArmorItem.Type.BOOTS, new Item.Properties()));

    // Ruby Armor Set
    public static final RegistryObject<Item> RUBY_HELMET = ITEMS.register("ruby_helmet",
            () -> new CustomArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> RUBY_CHESTPLATE = ITEMS.register("ruby_chestplate",
            () -> new CustomArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> RUBY_LEGGINGS = ITEMS.register("ruby_leggings",
            () -> new CustomArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> RUBY_BOOTS = ITEMS.register("ruby_boots",
            () -> new CustomArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.BOOTS, new Item.Properties()));

    // Sculk Armor Set
    public static final RegistryObject<Item> SCULK_HELMET = ITEMS.register("sculk_helmet",
            () -> new SculkArmorItem(ModArmorMaterials.SCULK, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> SCULK_CHESTPLATE = ITEMS.register("sculk_chestplate",
            () -> new SculkArmorItem(ModArmorMaterials.SCULK, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> SCULK_LEGGINGS = ITEMS.register("sculk_leggings",
            () -> new SculkArmorItem(ModArmorMaterials.SCULK, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> SCULK_BOOTS = ITEMS.register("sculk_boots",
            () -> new SculkArmorItem(ModArmorMaterials.SCULK, ArmorItem.Type.BOOTS, new Item.Properties()));

    // Shulker Armor Set
    public static final RegistryObject<Item> SHULKER_HELMET = ITEMS.register("shulker_helmet",
            () -> new CustomArmorItem(ModArmorMaterials.SHULKER, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> SHULKER_CHESTPLATE = ITEMS.register("shulker_chestplate",
            () -> new CustomArmorItem(ModArmorMaterials.SHULKER, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> SHULKER_LEGGINGS = ITEMS.register("shulker_leggings",
            () -> new CustomArmorItem(ModArmorMaterials.SHULKER, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> SHULKER_BOOTS = ITEMS.register("shulker_boots",
            () -> new CustomArmorItem(ModArmorMaterials.SHULKER, ArmorItem.Type.BOOTS, new Item.Properties()));

    // Skeleton Armor Set
    public static final RegistryObject<Item> SKELETON_HELMET = ITEMS.register("skeleton_helmet",
            () -> new CustomArmorItem(ModArmorMaterials.SKELETON, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> SKELETON_CHESTPLATE = ITEMS.register("skeleton_chestplate",
            () -> new CustomArmorItem(ModArmorMaterials.SKELETON, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> SKELETON_LEGGINGS = ITEMS.register("skeleton_leggings",
            () -> new CustomArmorItem(ModArmorMaterials.SKELETON, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> SKELETON_BOOTS = ITEMS.register("skeleton_boots",
            () -> new CustomArmorItem(ModArmorMaterials.SKELETON, ArmorItem.Type.BOOTS, new Item.Properties()));

    // Sniffer Armor Set
    public static final RegistryObject<Item> SNIFFER_HELMET = ITEMS.register("sniffer_helmet",
            () -> new SnifferArmorItem(ModArmorMaterials.SNIFFER, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> SNIFFER_CHESTPLATE = ITEMS.register("sniffer_chestplate",
            () -> new SnifferArmorItem(ModArmorMaterials.SNIFFER, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> SNIFFER_LEGGINGS = ITEMS.register("sniffer_leggings",
            () -> new SnifferArmorItem(ModArmorMaterials.SNIFFER, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> SNIFFER_BOOTS = ITEMS.register("sniffer_boots",
            () -> new SnifferArmorItem(ModArmorMaterials.SNIFFER, ArmorItem.Type.BOOTS, new Item.Properties()));

    // TNT Armor Set
    public static final RegistryObject<Item> TNT_HELMET = ITEMS.register("tnt_helmet",
            () -> new TntArmorItem(ModArmorMaterials.TNT, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> TNT_CHESTPLATE = ITEMS.register("tnt_chestplate",
            () -> new TntArmorItem(ModArmorMaterials.TNT, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> TNT_LEGGINGS = ITEMS.register("tnt_leggings",
            () -> new TntArmorItem(ModArmorMaterials.TNT, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> TNT_BOOTS = ITEMS.register("tnt_boots",
            () -> new TntArmorItem(ModArmorMaterials.TNT, ArmorItem.Type.BOOTS, new Item.Properties()));

    // Totem Armor Set
    public static final RegistryObject<Item> TOTEM_HELMET = ITEMS.register("totem_helmet",
            () -> new CustomArmorItem(ModArmorMaterials.TOTEM, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> TOTEM_CHESTPLATE = ITEMS.register("totem_chestplate",
            () -> new CustomArmorItem(ModArmorMaterials.TOTEM, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> TOTEM_LEGGINGS = ITEMS.register("totem_leggings",
            () -> new CustomArmorItem(ModArmorMaterials.TOTEM, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> TOTEM_BOOTS = ITEMS.register("totem_boots",
            () -> new CustomArmorItem(ModArmorMaterials.TOTEM, ArmorItem.Type.BOOTS, new Item.Properties()));

    // Wither Skeleton Armor Set
    public static final RegistryObject<Item> WITHER_SKELETON_HELMET = ITEMS.register("wither_skeleton_helmet",
            () -> new CustomArmorItem(ModArmorMaterials.WITHER_SKELETON, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> WITHER_SKELETON_CHESTPLATE = ITEMS.register("wither_skeleton_chestplate",
            () -> new CustomArmorItem(ModArmorMaterials.WITHER_SKELETON, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> WITHER_SKELETON_LEGGINGS = ITEMS.register("wither_skeleton_leggings",
            () -> new CustomArmorItem(ModArmorMaterials.WITHER_SKELETON, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> WITHER_SKELETON_BOOTS = ITEMS.register("wither_skeleton_boots",
            () -> new CustomArmorItem(ModArmorMaterials.WITHER_SKELETON, ArmorItem.Type.BOOTS, new Item.Properties()));

    // === Elytra Items ===
    public static final RegistryObject<Item> BOOK_ELYTRA = ITEMS.register("book_elytra",
            () -> new CustomElytraItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> BROKEN_BOOK_ELYTRA = ITEMS.register("broken_book_elytra",
            () -> new CustomElytraItem(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> CHICKEN_ELYTRA = ITEMS.register("chicken_elytra",
            () -> new CustomElytraItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> BROKEN_CHICKEN_ELYTRA = ITEMS.register("broken_chicken_elytra",
            () -> new CustomElytraItem(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> END_PORTAL_ELYTRA = ITEMS.register("end_portal_elytra",
            () -> new CustomElytraItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> BROKEN_END_PORTAL_ELYTRA = ITEMS.register("broken_end_portal_elytra",
            () -> new CustomElytraItem(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> FAIRY_ELYTRA = ITEMS.register("fairy_elytra",
            () -> new CustomElytraItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> BROKEN_FAIRY_ELYTRA = ITEMS.register("broken_fairy_elytra",
            () -> new CustomElytraItem(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> FIRE_ELYTRA = ITEMS.register("fire_elytra",
            () -> new CustomElytraItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> BROKEN_FIRE_ELYTRA = ITEMS.register("broken_fire_elytra",
            () -> new CustomElytraItem(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> FIRST_FLIGHT_ELYTRA = ITEMS.register("first_flight_elytra",
            () -> new CustomElytraItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> BROKEN_FIRST_FLIGHT_ELYTRA = ITEMS.register("broken_first_flight_elytra",
            () -> new CustomElytraItem(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> ICE_ELYTRA = ITEMS.register("ice_elytra",
            () -> new CustomElytraItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> BROKEN_ICE_ELYTRA = ITEMS.register("broken_ice_elytra",
            () -> new CustomElytraItem(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> LEAF_ELYTRA = ITEMS.register("leaf_elytra",
            () -> new CustomElytraItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> BROKEN_LEAF_ELYTRA = ITEMS.register("broken_leaf_elytra",
            () -> new CustomElytraItem(new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> MELON_ELYTRA = ITEMS.register("melon_elytra",
            () -> new CustomElytraItem(new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> BROKEN_MELON_ELYTRA = ITEMS.register("broken_melon_elytra",
            () -> new CustomElytraItem(new Item.Properties().stacksTo(1)));

    // List of all elytras for rendering and registration
    public static final List<RegistryObject<Item>> ALL_ELYTRAS = List.of(
        BOOK_ELYTRA, BROKEN_BOOK_ELYTRA,
        CHICKEN_ELYTRA, BROKEN_CHICKEN_ELYTRA,
        END_PORTAL_ELYTRA, BROKEN_END_PORTAL_ELYTRA,
        FAIRY_ELYTRA, BROKEN_FAIRY_ELYTRA,
        FIRE_ELYTRA, BROKEN_FIRE_ELYTRA,
        FIRST_FLIGHT_ELYTRA, BROKEN_FIRST_FLIGHT_ELYTRA,
        ICE_ELYTRA, BROKEN_ICE_ELYTRA,
        LEAF_ELYTRA, BROKEN_LEAF_ELYTRA,
        MELON_ELYTRA, BROKEN_MELON_ELYTRA
    );

    // Dummy item for creative tab icon (not assigned to any creative tab)
    public static final RegistryObject<Item> ICON = ITEMS.register("icon",
        () -> new Item(new Item.Properties()));
    
    // Generic CustomArmorItem class that handles all armor sets
    private static class CustomArmorItem extends ArmorItem {
        public CustomArmorItem(ArmorMaterial material, Type type, Properties properties) {
            super(material, type, properties);
        }
        
        @Override
        public String getArmorTexture(net.minecraft.world.item.ItemStack stack, net.minecraft.world.entity.Entity entity, 
                                    net.minecraft.world.entity.EquipmentSlot slot, String type) {
            // Get the material name and convert to the correct path
            String materialName = this.getMaterial().getName().replace(VanillaPlus.MOD_ID + ":", "");
            return "vanillaplus:textures/models/averagetateman/armors/" + materialName + "/layer_" + 
                   (slot == net.minecraft.world.entity.EquipmentSlot.LEGS ? "2" : "1") + ".png";
        }
    }
    
    // Custom Elytra Item class that handles elytra functionality
    public static class CustomElytraItem extends net.minecraft.world.item.ElytraItem {
        public CustomElytraItem(Properties properties) {
            super(properties);
        }
        
        @Override
        public boolean canElytraFly(net.minecraft.world.item.ItemStack stack, net.minecraft.world.entity.LivingEntity entity) {
            return true;
        }
        
        @Override
        public boolean isValidRepairItem(net.minecraft.world.item.ItemStack toRepair, net.minecraft.world.item.ItemStack repair) {
            return repair.is(net.minecraft.world.item.Items.PHANTOM_MEMBRANE);
        }

        @Override
        public net.minecraft.network.chat.Component getName(net.minecraft.world.item.ItemStack stack) {
            // Use the translated name (no namespace prefix) and apply yellow formatting
            return net.minecraft.world.item.ItemStack.EMPTY.getDescriptionId().equals(stack.getDescriptionId())
                ? super.getName(stack)
                : net.minecraft.network.chat.Component.translatable(this.getDescriptionId()).withStyle(net.minecraft.ChatFormatting.YELLOW);
        }
    }
} 