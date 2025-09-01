package com.morearmor;

import com.morearmor.init.Items;
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
import net.minecraft.world.item.crafting.RecipeSerializer;

@Mod(MoreArmor.MOD_ID)
public class MoreArmor {
    public static final String MOD_ID = "morearmor";

    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MOD_ID);
    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, MOD_ID);

    
    public static final RegistryObject<CreativeModeTab> MOREARMOR_TAB = CREATIVE_TABS.register("morearmor_tab",
        () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("morearmor", "galaxy_chestplate"))))
            .title(Component.translatable("itemGroup.morearmor"))
            .displayItems((parameters, output) -> {
                // Ancient Debris Armor Set
                output.accept(Items.ANCIENT_DEBRIS_HELMET.get());
                output.accept(Items.ANCIENT_DEBRIS_CHESTPLATE.get());
                output.accept(Items.ANCIENT_DEBRIS_LEGGINGS.get());
                output.accept(Items.ANCIENT_DEBRIS_BOOTS.get());
                
                // Amethyst Armor Set
                output.accept(Items.AMETHYST_HELMET.get());
                output.accept(Items.AMETHYST_CHESTPLATE.get());
                output.accept(Items.AMETHYST_LEGGINGS.get());
                output.accept(Items.AMETHYST_BOOTS.get());
                
                // Bedrock Armor Set
                output.accept(Items.BEDROCK_HELMET.get());
                output.accept(Items.BEDROCK_CHESTPLATE.get());
                output.accept(Items.BEDROCK_LEGGINGS.get());
                output.accept(Items.BEDROCK_BOOTS.get());
                
                // Bee Armor Set
                output.accept(Items.BEE_HELMET.get());
                output.accept(Items.BEE_CHESTPLATE.get());
                output.accept(Items.BEE_LEGGINGS.get());
                output.accept(Items.BEE_BOOTS.get());
                
                // Bone Armor Set
                output.accept(Items.BONE_HELMET.get());
                output.accept(Items.BONE_CHESTPLATE.get());
                output.accept(Items.BONE_LEGGINGS.get());
                output.accept(Items.BONE_BOOTS.get());
                
                // Cactus Armor Set
                output.accept(Items.CACTUS_HELMET.get());
                output.accept(Items.CACTUS_CHESTPLATE.get());
                output.accept(Items.CACTUS_LEGGINGS.get());
                output.accept(Items.CACTUS_BOOTS.get());
                
                // Coal Armor Set
                output.accept(Items.COAL_HELMET.get());
                output.accept(Items.COAL_CHESTPLATE.get());
                output.accept(Items.COAL_LEGGINGS.get());
                output.accept(Items.COAL_BOOTS.get());
                
                // Copper Armor Set
                output.accept(Items.COPPER_HELMET.get());
                output.accept(Items.COPPER_CHESTPLATE.get());
                output.accept(Items.COPPER_LEGGINGS.get());
                output.accept(Items.COPPER_BOOTS.get());
                
                // Crafting Armor Set
                output.accept(Items.CRAFTING_HELMET.get());
                output.accept(Items.CRAFTING_CHESTPLATE.get());
                output.accept(Items.CRAFTING_LEGGINGS.get());
                output.accept(Items.CRAFTING_BOOTS.get());
                
                // Dripstone Armor Set
                output.accept(Items.DRIPSTONE_HELMET.get());
                output.accept(Items.DRIPSTONE_CHESTPLATE.get());
                output.accept(Items.DRIPSTONE_LEGGINGS.get());
                output.accept(Items.DRIPSTONE_BOOTS.get());
                
                // Emerald Armor Set
                output.accept(Items.EMERALD_HELMET.get());
                output.accept(Items.EMERALD_CHESTPLATE.get());
                output.accept(Items.EMERALD_LEGGINGS.get());
                output.accept(Items.EMERALD_BOOTS.get());
                
                // Ender Dragon Armor Set
                output.accept(Items.ENDER_DRAGON_HELMET.get());
                output.accept(Items.ENDER_DRAGON_CHESTPLATE.get());
                output.accept(Items.ENDER_DRAGON_LEGGINGS.get());
                output.accept(Items.ENDER_DRAGON_BOOTS.get());
                
                // Galaxy Armor Set
                output.accept(Items.GALAXY_HELMET.get());
                output.accept(Items.GALAXY_CHESTPLATE.get());
                output.accept(Items.GALAXY_LEGGINGS.get());
                output.accept(Items.GALAXY_BOOTS.get());
                
                // Gilded Armor Set
                output.accept(Items.GILDED_HELMET.get());
                output.accept(Items.GILDED_CHESTPLATE.get());
                output.accept(Items.GILDED_LEGGINGS.get());
                output.accept(Items.GILDED_BOOTS.get());
                
                // Glass Armor Set
                output.accept(Items.GLASS_HELMET.get());
                output.accept(Items.GLASS_CHESTPLATE.get());
                output.accept(Items.GLASS_LEGGINGS.get());
                output.accept(Items.GLASS_BOOTS.get());
                
                // Guardian Armor Set
                output.accept(Items.GUARDIAN_HELMET.get());
                output.accept(Items.GUARDIAN_CHESTPLATE.get());
                output.accept(Items.GUARDIAN_LEGGINGS.get());
                output.accept(Items.GUARDIAN_BOOTS.get());
                
                // Lapis Armor Set
                output.accept(Items.LAPIS_HELMET.get());
                output.accept(Items.LAPIS_CHESTPLATE.get());
                output.accept(Items.LAPIS_LEGGINGS.get());
                output.accept(Items.LAPIS_BOOTS.get());
                
                // Machine Armor Set
                output.accept(Items.MACHINE_HELMET.get());
                output.accept(Items.MACHINE_CHESTPLATE.get());
                output.accept(Items.MACHINE_LEGGINGS.get());
                output.accept(Items.MACHINE_BOOTS.get());
                
                // Magma Armor Set
                output.accept(Items.MAGMA_HELMET.get());
                output.accept(Items.MAGMA_CHESTPLATE.get());
                output.accept(Items.MAGMA_LEGGINGS.get());
                output.accept(Items.MAGMA_BOOTS.get());
                
                // Music Armor Set
                output.accept(Items.MUSIC_HELMET.get());
                output.accept(Items.MUSIC_CHESTPLATE.get());
                output.accept(Items.MUSIC_LEGGINGS.get());
                output.accept(Items.MUSIC_BOOTS.get());
                
                // Obsidian Armor Set
                output.accept(Items.OBSIDIAN_HELMET.get());
                output.accept(Items.OBSIDIAN_CHESTPLATE.get());
                output.accept(Items.OBSIDIAN_LEGGINGS.get());
                output.accept(Items.OBSIDIAN_BOOTS.get());
                
                // Pot Armor Set
                output.accept(Items.POT_HELMET.get());
                output.accept(Items.POT_CHESTPLATE.get());
                output.accept(Items.POT_LEGGINGS.get());
                output.accept(Items.POT_BOOTS.get());
                
                // Power Suit Armor Set
                output.accept(Items.POWER_SUIT_HELMET.get());
                output.accept(Items.POWER_SUIT_CHESTPLATE.get());
                output.accept(Items.POWER_SUIT_LEGGINGS.get());
                output.accept(Items.POWER_SUIT_BOOTS.get());
                
                // Quartz Armor Set
                output.accept(Items.QUARTZ_HELMET.get());
                output.accept(Items.QUARTZ_CHESTPLATE.get());
                output.accept(Items.QUARTZ_LEGGINGS.get());
                output.accept(Items.QUARTZ_BOOTS.get());
                
                // Red Dragon Armor Set
                output.accept(Items.RED_DRAGON_HELMET.get());
                output.accept(Items.RED_DRAGON_CHESTPLATE.get());
                output.accept(Items.RED_DRAGON_LEGGINGS.get());
                output.accept(Items.RED_DRAGON_BOOTS.get());
                
                // Redstone Armor Set
                output.accept(Items.REDSTONE_HELMET.get());
                output.accept(Items.REDSTONE_CHESTPLATE.get());
                output.accept(Items.REDSTONE_LEGGINGS.get());
                output.accept(Items.REDSTONE_BOOTS.get());
                
                // Reinforced Deepslate Armor Set
                output.accept(Items.REINFORCED_DEEPSLATE_HELMET.get());
                output.accept(Items.REINFORCED_DEEPSLATE_CHESTPLATE.get());
                output.accept(Items.REINFORCED_DEEPSLATE_LEGGINGS.get());
                output.accept(Items.REINFORCED_DEEPSLATE_BOOTS.get());
                
                // RGB Armor Set
                output.accept(Items.RGB_HELMET.get());
                output.accept(Items.RGB_CHESTPLATE.get());
                output.accept(Items.RGB_LEGGINGS.get());
                output.accept(Items.RGB_BOOTS.get());
                
                // Ruby Armor Set
                output.accept(Items.RUBY_HELMET.get());
                output.accept(Items.RUBY_CHESTPLATE.get());
                output.accept(Items.RUBY_LEGGINGS.get());
                output.accept(Items.RUBY_BOOTS.get());
                
                // Sculk Armor Set
                output.accept(Items.SCULK_HELMET.get());
                output.accept(Items.SCULK_CHESTPLATE.get());
                output.accept(Items.SCULK_LEGGINGS.get());
                output.accept(Items.SCULK_BOOTS.get());
                
                // Shulker Armor Set
                output.accept(Items.SHULKER_HELMET.get());
                output.accept(Items.SHULKER_CHESTPLATE.get());
                output.accept(Items.SHULKER_LEGGINGS.get());
                output.accept(Items.SHULKER_BOOTS.get());
                
                // Skeleton Armor Set
                output.accept(Items.SKELETON_HELMET.get());
                output.accept(Items.SKELETON_CHESTPLATE.get());
                output.accept(Items.SKELETON_LEGGINGS.get());
                output.accept(Items.SKELETON_BOOTS.get());
                
                // Sniffer Armor Set
                output.accept(Items.SNIFFER_HELMET.get());
                output.accept(Items.SNIFFER_CHESTPLATE.get());
                output.accept(Items.SNIFFER_LEGGINGS.get());
                output.accept(Items.SNIFFER_BOOTS.get());
                
                // TNT Armor Set
                output.accept(Items.TNT_HELMET.get());
                output.accept(Items.TNT_CHESTPLATE.get());
                output.accept(Items.TNT_LEGGINGS.get());
                output.accept(Items.TNT_BOOTS.get());
                
                // Totem Armor Set
                output.accept(Items.TOTEM_HELMET.get());
                output.accept(Items.TOTEM_CHESTPLATE.get());
                output.accept(Items.TOTEM_LEGGINGS.get());
                output.accept(Items.TOTEM_BOOTS.get());
                
                // Wither Skeleton Armor Set
                output.accept(Items.WITHER_SKELETON_HELMET.get());
                output.accept(Items.WITHER_SKELETON_CHESTPLATE.get());
                output.accept(Items.WITHER_SKELETON_LEGGINGS.get());
                output.accept(Items.WITHER_SKELETON_BOOTS.get());
                

            })
            .build());

    public MoreArmor() {        
        // Register ForgeConfigSpec first
        ModConfigs.register();
        
        // Register items
        Items.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        
        // Register creative tabs
        CREATIVE_TABS.register(FMLJavaModLoadingContext.get().getModEventBus());
        
        // Register recipe serializers
        RECIPE_SERIALIZERS.register(FMLJavaModLoadingContext.get().getModEventBus());
        
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }
    

    



    

    

    

} 