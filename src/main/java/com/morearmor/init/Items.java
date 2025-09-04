package com.morearmor.init;

import com.morearmor.MoreArmor;
import com.morearmor.init.armors.DefaultArmorItem;
import com.morearmor.init.armors.BeeArmorItem;
import com.morearmor.init.armors.MachineArmorItem;
import com.morearmor.init.armors.ObsidianArmorItem;
import com.morearmor.init.armors.EnderDragonArmorItem;
import com.morearmor.init.armors.GalaxyArmorItem;
import com.morearmor.init.armors.GuardianArmorItem;
import com.morearmor.init.armors.MagmaArmorItem;
import com.morearmor.init.armors.MusicArmorItem;
import com.morearmor.init.armors.PotArmorItem;
import com.morearmor.init.armors.RedDragonArmorItem;
import com.morearmor.init.armors.RgbArmorItem;
import com.morearmor.init.armors.SculkArmorItem;
import com.morearmor.init.armors.SnifferArmorItem;
import com.morearmor.init.armors.TntArmorItem;
import com.morearmor.config.ModConfigs;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Items {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MoreArmor.MOD_ID);
    
    // Ancient Debris Armor Set
    public static final RegistryObject<Item> ANCIENT_DEBRIS_HELMET = ITEMS.register("ancient_debris_helmet",
            () -> new DefaultArmorItem(ModConfigs.createArmorMaterial("ancient_debris"), ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> ANCIENT_DEBRIS_CHESTPLATE = ITEMS.register("ancient_debris_chestplate",
            () -> new DefaultArmorItem(ModConfigs.createArmorMaterial("ancient_debris"), ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> ANCIENT_DEBRIS_LEGGINGS = ITEMS.register("ancient_debris_leggings",
            () -> new DefaultArmorItem(ModConfigs.createArmorMaterial("ancient_debris"), ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> ANCIENT_DEBRIS_BOOTS = ITEMS.register("ancient_debris_boots",
            () -> new DefaultArmorItem(ModConfigs.createArmorMaterial("ancient_debris"), ArmorItem.Type.BOOTS, new Item.Properties()));

    // Amethyst Armor Set
    public static final RegistryObject<Item> AMETHYST_HELMET = ITEMS.register("amethyst_helmet",
            () -> new DefaultArmorItem(ModConfigs.createArmorMaterial("amethyst"), ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> AMETHYST_CHESTPLATE = ITEMS.register("amethyst_chestplate",
            () -> new DefaultArmorItem(ModConfigs.createArmorMaterial("amethyst"), ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> AMETHYST_LEGGINGS = ITEMS.register("amethyst_leggings",
            () -> new DefaultArmorItem(ModConfigs.createArmorMaterial("amethyst"), ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> AMETHYST_BOOTS = ITEMS.register("amethyst_boots",
            () -> new DefaultArmorItem(ModConfigs.createArmorMaterial("amethyst"), ArmorItem.Type.BOOTS, new Item.Properties()));

    // Bedrock Armor Set
    public static final RegistryObject<Item> BEDROCK_HELMET = ITEMS.register("bedrock_helmet",
            () -> new DefaultArmorItem(ModConfigs.createArmorMaterial("bedrock"), ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> BEDROCK_CHESTPLATE = ITEMS.register("bedrock_chestplate",
            () -> new DefaultArmorItem(ModConfigs.createArmorMaterial("bedrock"), ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> BEDROCK_LEGGINGS = ITEMS.register("bedrock_leggings",
            () -> new DefaultArmorItem(ModConfigs.createArmorMaterial("bedrock"), ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> BEDROCK_BOOTS = ITEMS.register("bedrock_boots",
            () -> new DefaultArmorItem(ModConfigs.createArmorMaterial("bedrock"), ArmorItem.Type.BOOTS, new Item.Properties()));

    // Bee Armor Set
    public static final RegistryObject<Item> BEE_HELMET = ITEMS.register("bee_helmet",
            () -> new BeeArmorItem(ModConfigs.createArmorMaterial("bee"), ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> BEE_CHESTPLATE = ITEMS.register("bee_chestplate",
            () -> new BeeArmorItem(ModConfigs.createArmorMaterial("bee"), ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> BEE_LEGGINGS = ITEMS.register("bee_leggings",
            () -> new BeeArmorItem(ModConfigs.createArmorMaterial("bee"), ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> BEE_BOOTS = ITEMS.register("bee_boots",
            () -> new BeeArmorItem(ModConfigs.createArmorMaterial("bee"), ArmorItem.Type.BOOTS, new Item.Properties()));

    // Bone Armor Set
    public static final RegistryObject<Item> BONE_HELMET = ITEMS.register("bone_helmet",
            () -> new DefaultArmorItem(ModConfigs.createArmorMaterial("bone"), ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> BONE_CHESTPLATE = ITEMS.register("bone_chestplate",
            () -> new DefaultArmorItem(ModConfigs.createArmorMaterial("bone"), ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> BONE_LEGGINGS = ITEMS.register("bone_leggings",
            () -> new DefaultArmorItem(ModConfigs.createArmorMaterial("bone"), ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> BONE_BOOTS = ITEMS.register("bone_boots",
            () -> new DefaultArmorItem(ModConfigs.createArmorMaterial("bone"), ArmorItem.Type.BOOTS, new Item.Properties()));

    // Cactus Armor Set
    public static final RegistryObject<Item> CACTUS_HELMET = ITEMS.register("cactus_helmet",
            () -> new DefaultArmorItem(ModConfigs.createArmorMaterial("cactus"), ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> CACTUS_CHESTPLATE = ITEMS.register("cactus_chestplate",
            () -> new DefaultArmorItem(ModConfigs.createArmorMaterial("cactus"), ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> CACTUS_LEGGINGS = ITEMS.register("cactus_leggings",
            () -> new DefaultArmorItem(ModConfigs.createArmorMaterial("cactus"), ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> CACTUS_BOOTS = ITEMS.register("cactus_boots",
            () -> new DefaultArmorItem(ModConfigs.createArmorMaterial("cactus"), ArmorItem.Type.BOOTS, new Item.Properties()));

    // Coal Armor Set
    public static final RegistryObject<Item> COAL_HELMET = ITEMS.register("coal_helmet",
            () -> new DefaultArmorItem(ModConfigs.createArmorMaterial("coal"), ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> COAL_CHESTPLATE = ITEMS.register("coal_chestplate",
            () -> new DefaultArmorItem(ModConfigs.createArmorMaterial("coal"), ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> COAL_LEGGINGS = ITEMS.register("coal_leggings",
            () -> new DefaultArmorItem(ModConfigs.createArmorMaterial("coal"), ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> COAL_BOOTS = ITEMS.register("coal_boots",
            () -> new DefaultArmorItem(ModConfigs.createArmorMaterial("coal"), ArmorItem.Type.BOOTS, new Item.Properties()));

    // Copper Armor Set
    public static final RegistryObject<Item> COPPER_HELMET = ITEMS.register("copper_helmet",
            () -> new DefaultArmorItem(ModConfigs.createArmorMaterial("copper"), ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> COPPER_CHESTPLATE = ITEMS.register("copper_chestplate",
            () -> new DefaultArmorItem(ModConfigs.createArmorMaterial("copper"), ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> COPPER_LEGGINGS = ITEMS.register("copper_leggings",
            () -> new DefaultArmorItem(ModConfigs.createArmorMaterial("copper"), ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> COPPER_BOOTS = ITEMS.register("copper_boots",
            () -> new DefaultArmorItem(ModConfigs.createArmorMaterial("copper"), ArmorItem.Type.BOOTS, new Item.Properties()));

    // Crafting Armor Set
    public static final RegistryObject<Item> CRAFTING_HELMET = ITEMS.register("crafting_helmet",
            () -> new DefaultArmorItem(ModConfigs.createArmorMaterial("crafting"), ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> CRAFTING_CHESTPLATE = ITEMS.register("crafting_chestplate",
            () -> new DefaultArmorItem(ModConfigs.createArmorMaterial("crafting"), ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> CRAFTING_LEGGINGS = ITEMS.register("crafting_leggings",
            () -> new DefaultArmorItem(ModConfigs.createArmorMaterial("crafting"), ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> CRAFTING_BOOTS = ITEMS.register("crafting_boots",
            () -> new DefaultArmorItem(ModConfigs.createArmorMaterial("crafting"), ArmorItem.Type.BOOTS, new Item.Properties()));

    // Dripstone Armor Set
    public static final RegistryObject<Item> DRIPSTONE_HELMET = ITEMS.register("dripstone_helmet",
            () -> new DefaultArmorItem(ModConfigs.createArmorMaterial("dripstone"), ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> DRIPSTONE_CHESTPLATE = ITEMS.register("dripstone_chestplate",
            () -> new DefaultArmorItem(ModConfigs.createArmorMaterial("dripstone"), ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> DRIPSTONE_LEGGINGS = ITEMS.register("dripstone_leggings",
            () -> new DefaultArmorItem(ModConfigs.createArmorMaterial("dripstone"), ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> DRIPSTONE_BOOTS = ITEMS.register("dripstone_boots",
            () -> new DefaultArmorItem(ModConfigs.createArmorMaterial("dripstone"), ArmorItem.Type.BOOTS, new Item.Properties()));

    // Emerald Armor Set
    public static final RegistryObject<Item> EMERALD_HELMET = ITEMS.register("emerald_helmet",
            () -> new DefaultArmorItem(ModConfigs.createArmorMaterial("emerald"), ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> EMERALD_CHESTPLATE = ITEMS.register("emerald_chestplate",
            () -> new DefaultArmorItem(ModConfigs.createArmorMaterial("emerald"), ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> EMERALD_LEGGINGS = ITEMS.register("emerald_leggings",
            () -> new DefaultArmorItem(ModConfigs.createArmorMaterial("emerald"), ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> EMERALD_BOOTS = ITEMS.register("emerald_boots",
            () -> new DefaultArmorItem(ModConfigs.createArmorMaterial("emerald"), ArmorItem.Type.BOOTS, new Item.Properties()));

    // Ender Dragon Armor Set
    public static final RegistryObject<Item> ENDER_DRAGON_HELMET = ITEMS.register("ender_dragon_helmet",
            () -> new EnderDragonArmorItem(ModConfigs.createArmorMaterial("ender_dragon"), ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> ENDER_DRAGON_CHESTPLATE = ITEMS.register("ender_dragon_chestplate",
            () -> new EnderDragonArmorItem(ModConfigs.createArmorMaterial("ender_dragon"), ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> ENDER_DRAGON_LEGGINGS = ITEMS.register("ender_dragon_leggings",
            () -> new EnderDragonArmorItem(ModConfigs.createArmorMaterial("ender_dragon"), ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> ENDER_DRAGON_BOOTS = ITEMS.register("ender_dragon_boots",
            () -> new EnderDragonArmorItem(ModConfigs.createArmorMaterial("ender_dragon"), ArmorItem.Type.BOOTS, new Item.Properties()));

    // Galaxy Armor Set
    public static final RegistryObject<Item> GALAXY_HELMET = ITEMS.register("galaxy_helmet",
            () -> new GalaxyArmorItem(ModConfigs.createArmorMaterial("galaxy"), ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> GALAXY_CHESTPLATE = ITEMS.register("galaxy_chestplate",
            () -> new GalaxyArmorItem(ModConfigs.createArmorMaterial("galaxy"), ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> GALAXY_LEGGINGS = ITEMS.register("galaxy_leggings",
            () -> new GalaxyArmorItem(ModConfigs.createArmorMaterial("galaxy"), ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> GALAXY_BOOTS = ITEMS.register("galaxy_boots",
            () -> new GalaxyArmorItem(ModConfigs.createArmorMaterial("galaxy"), ArmorItem.Type.BOOTS, new Item.Properties()));

    // Gilded Armor Set
    public static final RegistryObject<Item> GILDED_HELMET = ITEMS.register("gilded_helmet",
            () -> new DefaultArmorItem(ModConfigs.createArmorMaterial("gilded"), ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> GILDED_CHESTPLATE = ITEMS.register("gilded_chestplate",
            () -> new DefaultArmorItem(ModConfigs.createArmorMaterial("gilded"), ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> GILDED_LEGGINGS = ITEMS.register("gilded_leggings",
            () -> new DefaultArmorItem(ModConfigs.createArmorMaterial("gilded"), ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> GILDED_BOOTS = ITEMS.register("gilded_boots",
            () -> new DefaultArmorItem(ModConfigs.createArmorMaterial("gilded"), ArmorItem.Type.BOOTS, new Item.Properties()));

    // Glass Armor Set
    public static final RegistryObject<Item> GLASS_HELMET = ITEMS.register("glass_helmet",
            () -> new DefaultArmorItem(ModConfigs.createArmorMaterial("glass"), ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> GLASS_CHESTPLATE = ITEMS.register("glass_chestplate",
            () -> new DefaultArmorItem(ModConfigs.createArmorMaterial("glass"), ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> GLASS_LEGGINGS = ITEMS.register("glass_leggings",
            () -> new DefaultArmorItem(ModConfigs.createArmorMaterial("glass"), ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> GLASS_BOOTS = ITEMS.register("glass_boots",
            () -> new DefaultArmorItem(ModConfigs.createArmorMaterial("glass"), ArmorItem.Type.BOOTS, new Item.Properties()));

    // Guardian Armor Set
    public static final RegistryObject<Item> GUARDIAN_HELMET = ITEMS.register("guardian_helmet",
            () -> new GuardianArmorItem(ModConfigs.createArmorMaterial("guardian"), ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> GUARDIAN_CHESTPLATE = ITEMS.register("guardian_chestplate",
            () -> new GuardianArmorItem(ModConfigs.createArmorMaterial("guardian"), ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> GUARDIAN_LEGGINGS = ITEMS.register("guardian_leggings",
            () -> new GuardianArmorItem(ModConfigs.createArmorMaterial("guardian"), ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> GUARDIAN_BOOTS = ITEMS.register("guardian_boots",
            () -> new GuardianArmorItem(ModConfigs.createArmorMaterial("guardian"), ArmorItem.Type.BOOTS, new Item.Properties()));

    // Lapis Armor Set
    public static final RegistryObject<Item> LAPIS_HELMET = ITEMS.register("lapis_helmet",
            () -> new DefaultArmorItem(ModConfigs.createArmorMaterial("lapis"), ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> LAPIS_CHESTPLATE = ITEMS.register("lapis_chestplate",
            () -> new DefaultArmorItem(ModConfigs.createArmorMaterial("lapis"), ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> LAPIS_LEGGINGS = ITEMS.register("lapis_leggings",
            () -> new DefaultArmorItem(ModConfigs.createArmorMaterial("lapis"), ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> LAPIS_BOOTS = ITEMS.register("lapis_boots",
            () -> new DefaultArmorItem(ModConfigs.createArmorMaterial("lapis"), ArmorItem.Type.BOOTS, new Item.Properties()));

    // Machine Armor Set
    public static final RegistryObject<Item> MACHINE_HELMET = ITEMS.register("machine_helmet",
            () -> new MachineArmorItem(ModConfigs.createArmorMaterial("machine"), ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> MACHINE_CHESTPLATE = ITEMS.register("machine_chestplate",
            () -> new MachineArmorItem(ModConfigs.createArmorMaterial("machine"), ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> MACHINE_LEGGINGS = ITEMS.register("machine_leggings",
            () -> new MachineArmorItem(ModConfigs.createArmorMaterial("machine"), ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> MACHINE_BOOTS = ITEMS.register("machine_boots",
            () -> new MachineArmorItem(ModConfigs.createArmorMaterial("machine"), ArmorItem.Type.BOOTS, new Item.Properties()));

    // Magma Armor Set
    public static final RegistryObject<Item> MAGMA_HELMET = ITEMS.register("magma_helmet",
            () -> new MagmaArmorItem(ModConfigs.createArmorMaterial("magma"), ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> MAGMA_CHESTPLATE = ITEMS.register("magma_chestplate",
            () -> new MagmaArmorItem(ModConfigs.createArmorMaterial("magma"), ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> MAGMA_LEGGINGS = ITEMS.register("magma_leggings",
            () -> new MagmaArmorItem(ModConfigs.createArmorMaterial("magma"), ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> MAGMA_BOOTS = ITEMS.register("magma_boots",
            () -> new MagmaArmorItem(ModConfigs.createArmorMaterial("magma"), ArmorItem.Type.BOOTS, new Item.Properties()));

    // Music Armor Set
    public static final RegistryObject<Item> MUSIC_HELMET = ITEMS.register("music_helmet",
            () -> new MusicArmorItem(ModConfigs.createArmorMaterial("music"), ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> MUSIC_CHESTPLATE = ITEMS.register("music_chestplate",
            () -> new MusicArmorItem(ModConfigs.createArmorMaterial("music"), ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> MUSIC_LEGGINGS = ITEMS.register("music_leggings",
            () -> new MusicArmorItem(ModConfigs.createArmorMaterial("music"), ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> MUSIC_BOOTS = ITEMS.register("music_boots",
            () -> new MusicArmorItem(ModConfigs.createArmorMaterial("music"), ArmorItem.Type.BOOTS, new Item.Properties()));

    // Obsidian Armor Set (Animated)
    public static final RegistryObject<Item> OBSIDIAN_HELMET = ITEMS.register("obsidian_helmet",
            () -> new ObsidianArmorItem(ModConfigs.createArmorMaterial("obsidian"), ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> OBSIDIAN_CHESTPLATE = ITEMS.register("obsidian_chestplate",
            () -> new ObsidianArmorItem(ModConfigs.createArmorMaterial("obsidian"), ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> OBSIDIAN_LEGGINGS = ITEMS.register("obsidian_leggings",
            () -> new ObsidianArmorItem(ModConfigs.createArmorMaterial("obsidian"), ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> OBSIDIAN_BOOTS = ITEMS.register("obsidian_boots",
            () -> new ObsidianArmorItem(ModConfigs.createArmorMaterial("obsidian"), ArmorItem.Type.BOOTS, new Item.Properties()));

    // Pot Armor Set
    public static final RegistryObject<Item> POT_HELMET = ITEMS.register("pot_helmet",
            () -> new PotArmorItem(ModConfigs.createArmorMaterial("pot"), ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> POT_CHESTPLATE = ITEMS.register("pot_chestplate",
            () -> new PotArmorItem(ModConfigs.createArmorMaterial("pot"), ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> POT_LEGGINGS = ITEMS.register("pot_leggings",
            () -> new PotArmorItem(ModConfigs.createArmorMaterial("pot"), ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> POT_BOOTS = ITEMS.register("pot_boots",
            () -> new PotArmorItem(ModConfigs.createArmorMaterial("pot"), ArmorItem.Type.BOOTS, new Item.Properties()));

    // Power Suit Armor Set
    public static final RegistryObject<Item> POWER_SUIT_HELMET = ITEMS.register("power_suit_helmet",
            () -> new DefaultArmorItem(ModConfigs.createArmorMaterial("power_suit"), ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> POWER_SUIT_CHESTPLATE = ITEMS.register("power_suit_chestplate",
            () -> new DefaultArmorItem(ModConfigs.createArmorMaterial("power_suit"), ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> POWER_SUIT_LEGGINGS = ITEMS.register("power_suit_leggings",
            () -> new DefaultArmorItem(ModConfigs.createArmorMaterial("power_suit"), ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> POWER_SUIT_BOOTS = ITEMS.register("power_suit_boots",
            () -> new DefaultArmorItem(ModConfigs.createArmorMaterial("power_suit"), ArmorItem.Type.BOOTS, new Item.Properties()));

    // Quartz Armor Set
    public static final RegistryObject<Item> QUARTZ_HELMET = ITEMS.register("quartz_helmet",
            () -> new DefaultArmorItem(ModConfigs.createArmorMaterial("quartz"), ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> QUARTZ_CHESTPLATE = ITEMS.register("quartz_chestplate",
            () -> new DefaultArmorItem(ModConfigs.createArmorMaterial("quartz"), ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> QUARTZ_LEGGINGS = ITEMS.register("quartz_leggings",
            () -> new DefaultArmorItem(ModConfigs.createArmorMaterial("quartz"), ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> QUARTZ_BOOTS = ITEMS.register("quartz_boots",
            () -> new DefaultArmorItem(ModConfigs.createArmorMaterial("quartz"), ArmorItem.Type.BOOTS, new Item.Properties()));

    // Red Dragon Armor Set
    public static final RegistryObject<Item> RED_DRAGON_HELMET = ITEMS.register("red_dragon_helmet",
            () -> new RedDragonArmorItem(ModConfigs.createArmorMaterial("red_dragon"), ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> RED_DRAGON_CHESTPLATE = ITEMS.register("red_dragon_chestplate",
            () -> new RedDragonArmorItem(ModConfigs.createArmorMaterial("red_dragon"), ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> RED_DRAGON_LEGGINGS = ITEMS.register("red_dragon_leggings",
            () -> new RedDragonArmorItem(ModConfigs.createArmorMaterial("red_dragon"), ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> RED_DRAGON_BOOTS = ITEMS.register("red_dragon_boots",
            () -> new RedDragonArmorItem(ModConfigs.createArmorMaterial("red_dragon"), ArmorItem.Type.BOOTS, new Item.Properties()));

    // Redstone Armor Set
    public static final RegistryObject<Item> REDSTONE_HELMET = ITEMS.register("redstone_helmet",
            () -> new DefaultArmorItem(ModConfigs.createArmorMaterial("redstone"), ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> REDSTONE_CHESTPLATE = ITEMS.register("redstone_chestplate",
            () -> new DefaultArmorItem(ModConfigs.createArmorMaterial("redstone"), ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> REDSTONE_LEGGINGS = ITEMS.register("redstone_leggings",
            () -> new DefaultArmorItem(ModConfigs.createArmorMaterial("redstone"), ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> REDSTONE_BOOTS = ITEMS.register("redstone_boots",
            () -> new DefaultArmorItem(ModConfigs.createArmorMaterial("redstone"), ArmorItem.Type.BOOTS, new Item.Properties()));

    // Reinforced Deepslate Armor Set
    public static final RegistryObject<Item> REINFORCED_DEEPSLATE_HELMET = ITEMS.register("reinforced_deepslate_helmet",
            () -> new DefaultArmorItem(ModConfigs.createArmorMaterial("reinforced_deepslate"), ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> REINFORCED_DEEPSLATE_CHESTPLATE = ITEMS.register("reinforced_deepslate_chestplate",
            () -> new DefaultArmorItem(ModConfigs.createArmorMaterial("reinforced_deepslate"), ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> REINFORCED_DEEPSLATE_LEGGINGS = ITEMS.register("reinforced_deepslate_leggings",
            () -> new DefaultArmorItem(ModConfigs.createArmorMaterial("reinforced_deepslate"), ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> REINFORCED_DEEPSLATE_BOOTS = ITEMS.register("reinforced_deepslate_boots",
            () -> new DefaultArmorItem(ModConfigs.createArmorMaterial("reinforced_deepslate"), ArmorItem.Type.BOOTS, new Item.Properties()));

    // RGB Armor Set
    public static final RegistryObject<Item> RGB_HELMET = ITEMS.register("rgb_helmet",
            () -> new RgbArmorItem(ModConfigs.createArmorMaterial("rgb"), ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> RGB_CHESTPLATE = ITEMS.register("rgb_chestplate",
            () -> new RgbArmorItem(ModConfigs.createArmorMaterial("rgb"), ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> RGB_LEGGINGS = ITEMS.register("rgb_leggings",
            () -> new RgbArmorItem(ModConfigs.createArmorMaterial("rgb"), ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> RGB_BOOTS = ITEMS.register("rgb_boots",
            () -> new RgbArmorItem(ModConfigs.createArmorMaterial("rgb"), ArmorItem.Type.BOOTS, new Item.Properties()));

    // Ruby Armor Set
    public static final RegistryObject<Item> RUBY_HELMET = ITEMS.register("ruby_helmet",
            () -> new DefaultArmorItem(ModConfigs.createArmorMaterial("ruby"), ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> RUBY_CHESTPLATE = ITEMS.register("ruby_chestplate",
            () -> new DefaultArmorItem(ModConfigs.createArmorMaterial("ruby"), ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> RUBY_LEGGINGS = ITEMS.register("ruby_leggings",
            () -> new DefaultArmorItem(ModConfigs.createArmorMaterial("ruby"), ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> RUBY_BOOTS = ITEMS.register("ruby_boots",
            () -> new DefaultArmorItem(ModConfigs.createArmorMaterial("ruby"), ArmorItem.Type.BOOTS, new Item.Properties()));

    // Sculk Armor Set
    public static final RegistryObject<Item> SCULK_HELMET = ITEMS.register("sculk_helmet",
            () -> new SculkArmorItem(ModConfigs.createArmorMaterial("sculk"), ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> SCULK_CHESTPLATE = ITEMS.register("sculk_chestplate",
            () -> new SculkArmorItem(ModConfigs.createArmorMaterial("sculk"), ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> SCULK_LEGGINGS = ITEMS.register("sculk_leggings",
            () -> new SculkArmorItem(ModConfigs.createArmorMaterial("sculk"), ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> SCULK_BOOTS = ITEMS.register("sculk_boots",
            () -> new SculkArmorItem(ModConfigs.createArmorMaterial("sculk"), ArmorItem.Type.BOOTS, new Item.Properties()));

    // Shulker Armor Set
    public static final RegistryObject<Item> SHULKER_HELMET = ITEMS.register("shulker_helmet",
            () -> new DefaultArmorItem(ModConfigs.createArmorMaterial("shulker"), ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> SHULKER_CHESTPLATE = ITEMS.register("shulker_chestplate",
            () -> new DefaultArmorItem(ModConfigs.createArmorMaterial("shulker"), ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> SHULKER_LEGGINGS = ITEMS.register("shulker_leggings",
            () -> new DefaultArmorItem(ModConfigs.createArmorMaterial("shulker"), ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> SHULKER_BOOTS = ITEMS.register("shulker_boots",
            () -> new DefaultArmorItem(ModConfigs.createArmorMaterial("shulker"), ArmorItem.Type.BOOTS, new Item.Properties()));

    // Skeleton Armor Set
    public static final RegistryObject<Item> SKELETON_HELMET = ITEMS.register("skeleton_helmet",
            () -> new DefaultArmorItem(ModConfigs.createArmorMaterial("skeleton"), ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> SKELETON_CHESTPLATE = ITEMS.register("skeleton_chestplate",
            () -> new DefaultArmorItem(ModConfigs.createArmorMaterial("skeleton"), ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> SKELETON_LEGGINGS = ITEMS.register("skeleton_leggings",
            () -> new DefaultArmorItem(ModConfigs.createArmorMaterial("skeleton"), ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> SKELETON_BOOTS = ITEMS.register("skeleton_boots",
            () -> new DefaultArmorItem(ModConfigs.createArmorMaterial("skeleton"), ArmorItem.Type.BOOTS, new Item.Properties()));

    // Sniffer Armor Set
    public static final RegistryObject<Item> SNIFFER_HELMET = ITEMS.register("sniffer_helmet",
            () -> new SnifferArmorItem(ModConfigs.createArmorMaterial("sniffer"), ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> SNIFFER_CHESTPLATE = ITEMS.register("sniffer_chestplate",
            () -> new SnifferArmorItem(ModConfigs.createArmorMaterial("sniffer"), ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> SNIFFER_LEGGINGS = ITEMS.register("sniffer_leggings",
            () -> new SnifferArmorItem(ModConfigs.createArmorMaterial("sniffer"), ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> SNIFFER_BOOTS = ITEMS.register("sniffer_boots",
            () -> new SnifferArmorItem(ModConfigs.createArmorMaterial("sniffer"), ArmorItem.Type.BOOTS, new Item.Properties()));

    // TNT Armor Set
    public static final RegistryObject<Item> TNT_HELMET = ITEMS.register("tnt_helmet",
            () -> new TntArmorItem(ModConfigs.createArmorMaterial("tnt"), ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> TNT_CHESTPLATE = ITEMS.register("tnt_chestplate",
            () -> new TntArmorItem(ModConfigs.createArmorMaterial("tnt"), ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> TNT_LEGGINGS = ITEMS.register("tnt_leggings",
            () -> new TntArmorItem(ModConfigs.createArmorMaterial("tnt"), ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> TNT_BOOTS = ITEMS.register("tnt_boots",
            () -> new TntArmorItem(ModConfigs.createArmorMaterial("tnt"), ArmorItem.Type.BOOTS, new Item.Properties()));

    // Totem Armor Set
    public static final RegistryObject<Item> TOTEM_HELMET = ITEMS.register("totem_helmet",
            () -> new DefaultArmorItem(ModConfigs.createArmorMaterial("totem"), ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> TOTEM_CHESTPLATE = ITEMS.register("totem_chestplate",
            () -> new DefaultArmorItem(ModConfigs.createArmorMaterial("totem"), ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> TOTEM_LEGGINGS = ITEMS.register("totem_leggings",
            () -> new DefaultArmorItem(ModConfigs.createArmorMaterial("totem"), ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> TOTEM_BOOTS = ITEMS.register("totem_boots",
            () -> new DefaultArmorItem(ModConfigs.createArmorMaterial("totem"), ArmorItem.Type.BOOTS, new Item.Properties()));

    // Wither Skeleton Armor Set
    public static final RegistryObject<Item> WITHER_SKELETON_HELMET = ITEMS.register("wither_skeleton_helmet",
            () -> new DefaultArmorItem(ModConfigs.createArmorMaterial("wither_skeleton"), ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> WITHER_SKELETON_CHESTPLATE = ITEMS.register("wither_skeleton_chestplate",
            () -> new DefaultArmorItem(ModConfigs.createArmorMaterial("wither_skeleton"), ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> WITHER_SKELETON_LEGGINGS = ITEMS.register("wither_skeleton_leggings",
            () -> new DefaultArmorItem(ModConfigs.createArmorMaterial("wither_skeleton"), ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> WITHER_SKELETON_BOOTS = ITEMS.register("wither_skeleton_boots",
            () -> new DefaultArmorItem(ModConfigs.createArmorMaterial("wither_skeleton"), ArmorItem.Type.BOOTS, new Item.Properties()));

} 