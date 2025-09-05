package com.morearmor;

import com.morearmor.init.MoreArmorItems;
import com.morearmor.config.ModConfigs;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

@Mod(MoreArmor.MOD_ID)
public class MoreArmor {
    public static final String MOD_ID = "morearmor";

    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MOD_ID);

    
    public static final RegistryObject<CreativeModeTab> MOREARMOR_TAB = CREATIVE_TABS.register("morearmor_tab",
        () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("morearmor", "galaxy_chestplate"))))
            .title(Component.translatable("itemGroup.morearmor"))
            .displayItems((parameters, output) -> {
                // Ancient Debris Armor Set
                output.accept(MoreArmorItems.ANCIENT_DEBRIS_HELMET.get());
                output.accept(MoreArmorItems.ANCIENT_DEBRIS_CHESTPLATE.get());
                output.accept(MoreArmorItems.ANCIENT_DEBRIS_LEGGINGS.get());
                output.accept(MoreArmorItems.ANCIENT_DEBRIS_BOOTS.get());
                
                // Amethyst Armor Set
                output.accept(MoreArmorItems.AMETHYST_HELMET.get());
                output.accept(MoreArmorItems.AMETHYST_CHESTPLATE.get());
                output.accept(MoreArmorItems.AMETHYST_LEGGINGS.get());
                output.accept(MoreArmorItems.AMETHYST_BOOTS.get());
                
                // Bedrock Armor Set
                output.accept(MoreArmorItems.BEDROCK_HELMET.get());
                output.accept(MoreArmorItems.BEDROCK_CHESTPLATE.get());
                output.accept(MoreArmorItems.BEDROCK_LEGGINGS.get());
                output.accept(MoreArmorItems.BEDROCK_BOOTS.get());
                
                // Bee Armor Set
                output.accept(MoreArmorItems.BEE_HELMET.get());
                output.accept(MoreArmorItems.BEE_CHESTPLATE.get());
                output.accept(MoreArmorItems.BEE_LEGGINGS.get());
                output.accept(MoreArmorItems.BEE_BOOTS.get());
                
                // Bone Armor Set
                output.accept(MoreArmorItems.BONE_HELMET.get());
                output.accept(MoreArmorItems.BONE_CHESTPLATE.get());
                output.accept(MoreArmorItems.BONE_LEGGINGS.get());
                output.accept(MoreArmorItems.BONE_BOOTS.get());
                
                // Cactus Armor Set
                output.accept(MoreArmorItems.CACTUS_HELMET.get());
                output.accept(MoreArmorItems.CACTUS_CHESTPLATE.get());
                output.accept(MoreArmorItems.CACTUS_LEGGINGS.get());
                output.accept(MoreArmorItems.CACTUS_BOOTS.get());
                
                // Coal Armor Set
                output.accept(MoreArmorItems.COAL_HELMET.get());
                output.accept(MoreArmorItems.COAL_CHESTPLATE.get());
                output.accept(MoreArmorItems.COAL_LEGGINGS.get());
                output.accept(MoreArmorItems.COAL_BOOTS.get());
                
                // Copper Armor Set
                output.accept(MoreArmorItems.COPPER_HELMET.get());
                output.accept(MoreArmorItems.COPPER_CHESTPLATE.get());
                output.accept(MoreArmorItems.COPPER_LEGGINGS.get());
                output.accept(MoreArmorItems.COPPER_BOOTS.get());
                
                // Crafting Armor Set
                output.accept(MoreArmorItems.CRAFTING_HELMET.get());
                output.accept(MoreArmorItems.CRAFTING_CHESTPLATE.get());
                output.accept(MoreArmorItems.CRAFTING_LEGGINGS.get());
                output.accept(MoreArmorItems.CRAFTING_BOOTS.get());
                
                // Dripstone Armor Set
                output.accept(MoreArmorItems.DRIPSTONE_HELMET.get());
                output.accept(MoreArmorItems.DRIPSTONE_CHESTPLATE.get());
                output.accept(MoreArmorItems.DRIPSTONE_LEGGINGS.get());
                output.accept(MoreArmorItems.DRIPSTONE_BOOTS.get());
                
                // Emerald Armor Set
                output.accept(MoreArmorItems.EMERALD_HELMET.get());
                output.accept(MoreArmorItems.EMERALD_CHESTPLATE.get());
                output.accept(MoreArmorItems.EMERALD_LEGGINGS.get());
                output.accept(MoreArmorItems.EMERALD_BOOTS.get());
                
                // Ender Dragon Armor Set
                output.accept(MoreArmorItems.ENDER_DRAGON_HELMET.get());
                output.accept(MoreArmorItems.ENDER_DRAGON_CHESTPLATE.get());
                output.accept(MoreArmorItems.ENDER_DRAGON_LEGGINGS.get());
                output.accept(MoreArmorItems.ENDER_DRAGON_BOOTS.get());
                
                // Galaxy Armor Set
                output.accept(MoreArmorItems.GALAXY_HELMET.get());
                output.accept(MoreArmorItems.GALAXY_CHESTPLATE.get());
                output.accept(MoreArmorItems.GALAXY_LEGGINGS.get());
                output.accept(MoreArmorItems.GALAXY_BOOTS.get());
                
                // Gilded Armor Set
                output.accept(MoreArmorItems.GILDED_HELMET.get());
                output.accept(MoreArmorItems.GILDED_CHESTPLATE.get());
                output.accept(MoreArmorItems.GILDED_LEGGINGS.get());
                output.accept(MoreArmorItems.GILDED_BOOTS.get());
                
                // Glass Armor Set
                output.accept(MoreArmorItems.GLASS_HELMET.get());
                output.accept(MoreArmorItems.GLASS_CHESTPLATE.get());
                output.accept(MoreArmorItems.GLASS_LEGGINGS.get());
                output.accept(MoreArmorItems.GLASS_BOOTS.get());
                
                // Guardian Armor Set
                output.accept(MoreArmorItems.GUARDIAN_HELMET.get());
                output.accept(MoreArmorItems.GUARDIAN_CHESTPLATE.get());
                output.accept(MoreArmorItems.GUARDIAN_LEGGINGS.get());
                output.accept(MoreArmorItems.GUARDIAN_BOOTS.get());
                
                // Lapis Armor Set
                output.accept(MoreArmorItems.LAPIS_HELMET.get());
                output.accept(MoreArmorItems.LAPIS_CHESTPLATE.get());
                output.accept(MoreArmorItems.LAPIS_LEGGINGS.get());
                output.accept(MoreArmorItems.LAPIS_BOOTS.get());
                
                // Machine Armor Set
                output.accept(MoreArmorItems.MACHINE_HELMET.get());
                output.accept(MoreArmorItems.MACHINE_CHESTPLATE.get());
                output.accept(MoreArmorItems.MACHINE_LEGGINGS.get());
                output.accept(MoreArmorItems.MACHINE_BOOTS.get());
                
                // Magma Armor Set
                output.accept(MoreArmorItems.MAGMA_HELMET.get());
                output.accept(MoreArmorItems.MAGMA_CHESTPLATE.get());
                output.accept(MoreArmorItems.MAGMA_LEGGINGS.get());
                output.accept(MoreArmorItems.MAGMA_BOOTS.get());
                
                // Music Armor Set
                output.accept(MoreArmorItems.MUSIC_HELMET.get());
                output.accept(MoreArmorItems.MUSIC_CHESTPLATE.get());
                output.accept(MoreArmorItems.MUSIC_LEGGINGS.get());
                output.accept(MoreArmorItems.MUSIC_BOOTS.get());
                
                // Obsidian Armor Set
                output.accept(MoreArmorItems.OBSIDIAN_HELMET.get());
                output.accept(MoreArmorItems.OBSIDIAN_CHESTPLATE.get());
                output.accept(MoreArmorItems.OBSIDIAN_LEGGINGS.get());
                output.accept(MoreArmorItems.OBSIDIAN_BOOTS.get());
                
                // Pot Armor Set
                output.accept(MoreArmorItems.POT_HELMET.get());
                output.accept(MoreArmorItems.POT_CHESTPLATE.get());
                output.accept(MoreArmorItems.POT_LEGGINGS.get());
                output.accept(MoreArmorItems.POT_BOOTS.get());
                
                // Power Suit Armor Set
                output.accept(MoreArmorItems.POWER_SUIT_HELMET.get());
                output.accept(MoreArmorItems.POWER_SUIT_CHESTPLATE.get());
                output.accept(MoreArmorItems.POWER_SUIT_LEGGINGS.get());
                output.accept(MoreArmorItems.POWER_SUIT_BOOTS.get());
                
                // Quartz Armor Set
                output.accept(MoreArmorItems.QUARTZ_HELMET.get());
                output.accept(MoreArmorItems.QUARTZ_CHESTPLATE.get());
                output.accept(MoreArmorItems.QUARTZ_LEGGINGS.get());
                output.accept(MoreArmorItems.QUARTZ_BOOTS.get());
                
                // Red Dragon Armor Set
                output.accept(MoreArmorItems.RED_DRAGON_HELMET.get());
                output.accept(MoreArmorItems.RED_DRAGON_CHESTPLATE.get());
                output.accept(MoreArmorItems.RED_DRAGON_LEGGINGS.get());
                output.accept(MoreArmorItems.RED_DRAGON_BOOTS.get());
                
                // Redstone Armor Set
                output.accept(MoreArmorItems.REDSTONE_HELMET.get());
                output.accept(MoreArmorItems.REDSTONE_CHESTPLATE.get());
                output.accept(MoreArmorItems.REDSTONE_LEGGINGS.get());
                output.accept(MoreArmorItems.REDSTONE_BOOTS.get());
                
                // Reinforced Deepslate Armor Set
                output.accept(MoreArmorItems.REINFORCED_DEEPSLATE_HELMET.get());
                output.accept(MoreArmorItems.REINFORCED_DEEPSLATE_CHESTPLATE.get());
                output.accept(MoreArmorItems.REINFORCED_DEEPSLATE_LEGGINGS.get());
                output.accept(MoreArmorItems.REINFORCED_DEEPSLATE_BOOTS.get());
                
                // RGB Armor Set
                output.accept(MoreArmorItems.RGB_HELMET.get());
                output.accept(MoreArmorItems.RGB_CHESTPLATE.get());
                output.accept(MoreArmorItems.RGB_LEGGINGS.get());
                output.accept(MoreArmorItems.RGB_BOOTS.get());
                
                // Ruby Armor Set
                output.accept(MoreArmorItems.RUBY_HELMET.get());
                output.accept(MoreArmorItems.RUBY_CHESTPLATE.get());
                output.accept(MoreArmorItems.RUBY_LEGGINGS.get());
                output.accept(MoreArmorItems.RUBY_BOOTS.get());
                
                // Sculk Armor Set
                output.accept(MoreArmorItems.SCULK_HELMET.get());
                output.accept(MoreArmorItems.SCULK_CHESTPLATE.get());
                output.accept(MoreArmorItems.SCULK_LEGGINGS.get());
                output.accept(MoreArmorItems.SCULK_BOOTS.get());
                
                // Shulker Armor Set
                output.accept(MoreArmorItems.SHULKER_HELMET.get());
                output.accept(MoreArmorItems.SHULKER_CHESTPLATE.get());
                output.accept(MoreArmorItems.SHULKER_LEGGINGS.get());
                output.accept(MoreArmorItems.SHULKER_BOOTS.get());
                
                // Skeleton Armor Set
                output.accept(MoreArmorItems.SKELETON_HELMET.get());
                output.accept(MoreArmorItems.SKELETON_CHESTPLATE.get());
                output.accept(MoreArmorItems.SKELETON_LEGGINGS.get());
                output.accept(MoreArmorItems.SKELETON_BOOTS.get());
                
                // Sniffer Armor Set
                output.accept(MoreArmorItems.SNIFFER_HELMET.get());
                output.accept(MoreArmorItems.SNIFFER_CHESTPLATE.get());
                output.accept(MoreArmorItems.SNIFFER_LEGGINGS.get());
                output.accept(MoreArmorItems.SNIFFER_BOOTS.get());
                
                // TNT Armor Set
                output.accept(MoreArmorItems.TNT_HELMET.get());
                output.accept(MoreArmorItems.TNT_CHESTPLATE.get());
                output.accept(MoreArmorItems.TNT_LEGGINGS.get());
                output.accept(MoreArmorItems.TNT_BOOTS.get());
                
                // Totem Armor Set
                output.accept(MoreArmorItems.TOTEM_HELMET.get());
                output.accept(MoreArmorItems.TOTEM_CHESTPLATE.get());
                output.accept(MoreArmorItems.TOTEM_LEGGINGS.get());
                output.accept(MoreArmorItems.TOTEM_BOOTS.get());
                
                // Wither Skeleton Armor Set
                output.accept(MoreArmorItems.WITHER_SKELETON_HELMET.get());
                output.accept(MoreArmorItems.WITHER_SKELETON_CHESTPLATE.get());
                output.accept(MoreArmorItems.WITHER_SKELETON_LEGGINGS.get());
                output.accept(MoreArmorItems.WITHER_SKELETON_BOOTS.get());
                

            })
            .build());

    public MoreArmor() {        
        // Register ForgeConfigSpec first
        ModConfigs.register();
        
        // Register items
        MoreArmorItems.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        
        // Register creative tabs
        CREATIVE_TABS.register(FMLJavaModLoadingContext.get().getModEventBus());
        
        
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }
    

    



    

    

    

} 