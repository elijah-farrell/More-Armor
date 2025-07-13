package com.vanillaplus;



import com.vanillaplus.init.ModItems;
import com.vanillaplus.init.ModItems.CustomElytraItem;

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
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraft.world.entity.EquipmentSlot;

import net.minecraft.world.item.crafting.RecipeSerializer;



@Mod(VanillaPlus.MOD_ID)
public class VanillaPlus {
    public static final String MOD_ID = "vanillaplus";

    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MOD_ID);
    public static final DeferredRegister<RecipeSerializer<?>> RECIPE_SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, MOD_ID);

    

    
    public static final RegistryObject<CreativeModeTab> VANILLAPLUS_TAB = CREATIVE_TABS.register("vanillaplus_tab",
        () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(ForgeRegistries.ITEMS.getValue(new ResourceLocation("vanillaplus", "icon"))))
            .title(Component.translatable("itemGroup.vanillaplus"))
            .displayItems((parameters, output) -> {
                // Ancient Debris Armor Set
                output.accept(ModItems.ANCIENT_DEBRIS_HELMET.get());
                output.accept(ModItems.ANCIENT_DEBRIS_CHESTPLATE.get());
                output.accept(ModItems.ANCIENT_DEBRIS_LEGGINGS.get());
                output.accept(ModItems.ANCIENT_DEBRIS_BOOTS.get());
                
                // Amethyst Armor Set
                output.accept(ModItems.AMETHYST_HELMET.get());
                output.accept(ModItems.AMETHYST_CHESTPLATE.get());
                output.accept(ModItems.AMETHYST_LEGGINGS.get());
                output.accept(ModItems.AMETHYST_BOOTS.get());
                
                // Bedrock Armor Set
                output.accept(ModItems.BEDROCK_HELMET.get());
                output.accept(ModItems.BEDROCK_CHESTPLATE.get());
                output.accept(ModItems.BEDROCK_LEGGINGS.get());
                output.accept(ModItems.BEDROCK_BOOTS.get());
                
                // Bee Armor Set
                output.accept(ModItems.BEE_HELMET.get());
                output.accept(ModItems.BEE_CHESTPLATE.get());
                output.accept(ModItems.BEE_LEGGINGS.get());
                output.accept(ModItems.BEE_BOOTS.get());
                
                // Bone Armor Set
                output.accept(ModItems.BONE_HELMET.get());
                output.accept(ModItems.BONE_CHESTPLATE.get());
                output.accept(ModItems.BONE_LEGGINGS.get());
                output.accept(ModItems.BONE_BOOTS.get());
                
                // Cactus Armor Set
                output.accept(ModItems.CACTUS_HELMET.get());
                output.accept(ModItems.CACTUS_CHESTPLATE.get());
                output.accept(ModItems.CACTUS_LEGGINGS.get());
                output.accept(ModItems.CACTUS_BOOTS.get());
                
                // Coal Armor Set
                output.accept(ModItems.COAL_HELMET.get());
                output.accept(ModItems.COAL_CHESTPLATE.get());
                output.accept(ModItems.COAL_LEGGINGS.get());
                output.accept(ModItems.COAL_BOOTS.get());
                
                // Copper Armor Set
                output.accept(ModItems.COPPER_HELMET.get());
                output.accept(ModItems.COPPER_CHESTPLATE.get());
                output.accept(ModItems.COPPER_LEGGINGS.get());
                output.accept(ModItems.COPPER_BOOTS.get());
                
                // Crafting Armor Set
                output.accept(ModItems.CRAFTING_HELMET.get());
                output.accept(ModItems.CRAFTING_CHESTPLATE.get());
                output.accept(ModItems.CRAFTING_LEGGINGS.get());
                output.accept(ModItems.CRAFTING_BOOTS.get());
                
                // Dripstone Armor Set
                output.accept(ModItems.DRIPSTONE_HELMET.get());
                output.accept(ModItems.DRIPSTONE_CHESTPLATE.get());
                output.accept(ModItems.DRIPSTONE_LEGGINGS.get());
                output.accept(ModItems.DRIPSTONE_BOOTS.get());
                
                // Emerald Armor Set
                output.accept(ModItems.EMERALD_HELMET.get());
                output.accept(ModItems.EMERALD_CHESTPLATE.get());
                output.accept(ModItems.EMERALD_LEGGINGS.get());
                output.accept(ModItems.EMERALD_BOOTS.get());
                
                // Ender Dragon Armor Set
                output.accept(ModItems.ENDER_DRAGON_HELMET.get());
                output.accept(ModItems.ENDER_DRAGON_CHESTPLATE.get());
                output.accept(ModItems.ENDER_DRAGON_LEGGINGS.get());
                output.accept(ModItems.ENDER_DRAGON_BOOTS.get());
                
                // Galaxy Armor Set
                output.accept(ModItems.GALAXY_HELMET.get());
                output.accept(ModItems.GALAXY_CHESTPLATE.get());
                output.accept(ModItems.GALAXY_LEGGINGS.get());
                output.accept(ModItems.GALAXY_BOOTS.get());
                
                // Gilded Armor Set
                output.accept(ModItems.GILDED_HELMET.get());
                output.accept(ModItems.GILDED_CHESTPLATE.get());
                output.accept(ModItems.GILDED_LEGGINGS.get());
                output.accept(ModItems.GILDED_BOOTS.get());
                
                // Glass Armor Set
                output.accept(ModItems.GLASS_HELMET.get());
                output.accept(ModItems.GLASS_CHESTPLATE.get());
                output.accept(ModItems.GLASS_LEGGINGS.get());
                output.accept(ModItems.GLASS_BOOTS.get());
                
                // Guardian Armor Set
                output.accept(ModItems.GUARDIAN_HELMET.get());
                output.accept(ModItems.GUARDIAN_CHESTPLATE.get());
                output.accept(ModItems.GUARDIAN_LEGGINGS.get());
                output.accept(ModItems.GUARDIAN_BOOTS.get());
                
                // Lapis Armor Set
                output.accept(ModItems.LAPIS_HELMET.get());
                output.accept(ModItems.LAPIS_CHESTPLATE.get());
                output.accept(ModItems.LAPIS_LEGGINGS.get());
                output.accept(ModItems.LAPIS_BOOTS.get());
                
                // Machine Armor Set
                output.accept(ModItems.MACHINE_HELMET.get());
                output.accept(ModItems.MACHINE_CHESTPLATE.get());
                output.accept(ModItems.MACHINE_LEGGINGS.get());
                output.accept(ModItems.MACHINE_BOOTS.get());
                
                // Magma Armor Set
                output.accept(ModItems.MAGMA_HELMET.get());
                output.accept(ModItems.MAGMA_CHESTPLATE.get());
                output.accept(ModItems.MAGMA_LEGGINGS.get());
                output.accept(ModItems.MAGMA_BOOTS.get());
                
                // Music Armor Set
                output.accept(ModItems.MUSIC_HELMET.get());
                output.accept(ModItems.MUSIC_CHESTPLATE.get());
                output.accept(ModItems.MUSIC_LEGGINGS.get());
                output.accept(ModItems.MUSIC_BOOTS.get());
                
                // Obsidian Armor Set
                output.accept(ModItems.OBSIDIAN_HELMET.get());
                output.accept(ModItems.OBSIDIAN_CHESTPLATE.get());
                output.accept(ModItems.OBSIDIAN_LEGGINGS.get());
                output.accept(ModItems.OBSIDIAN_BOOTS.get());
                
                // Pot Armor Set
                output.accept(ModItems.POT_HELMET.get());
                output.accept(ModItems.POT_CHESTPLATE.get());
                output.accept(ModItems.POT_LEGGINGS.get());
                output.accept(ModItems.POT_BOOTS.get());
                
                // Power Suit Armor Set
                output.accept(ModItems.POWER_SUIT_HELMET.get());
                output.accept(ModItems.POWER_SUIT_CHESTPLATE.get());
                output.accept(ModItems.POWER_SUIT_LEGGINGS.get());
                output.accept(ModItems.POWER_SUIT_BOOTS.get());
                
                // Quartz Armor Set
                output.accept(ModItems.QUARTZ_HELMET.get());
                output.accept(ModItems.QUARTZ_CHESTPLATE.get());
                output.accept(ModItems.QUARTZ_LEGGINGS.get());
                output.accept(ModItems.QUARTZ_BOOTS.get());
                
                // Red Dragon Armor Set
                output.accept(ModItems.RED_DRAGON_HELMET.get());
                output.accept(ModItems.RED_DRAGON_CHESTPLATE.get());
                output.accept(ModItems.RED_DRAGON_LEGGINGS.get());
                output.accept(ModItems.RED_DRAGON_BOOTS.get());
                
                // Redstone Armor Set
                output.accept(ModItems.REDSTONE_HELMET.get());
                output.accept(ModItems.REDSTONE_CHESTPLATE.get());
                output.accept(ModItems.REDSTONE_LEGGINGS.get());
                output.accept(ModItems.REDSTONE_BOOTS.get());
                
                // Reinforced Deepslate Armor Set
                output.accept(ModItems.REINFORCED_DEEPSLATE_HELMET.get());
                output.accept(ModItems.REINFORCED_DEEPSLATE_CHESTPLATE.get());
                output.accept(ModItems.REINFORCED_DEEPSLATE_LEGGINGS.get());
                output.accept(ModItems.REINFORCED_DEEPSLATE_BOOTS.get());
                
                // RGB Armor Set
                output.accept(ModItems.RGB_HELMET.get());
                output.accept(ModItems.RGB_CHESTPLATE.get());
                output.accept(ModItems.RGB_LEGGINGS.get());
                output.accept(ModItems.RGB_BOOTS.get());
                
                // Ruby Armor Set
                output.accept(ModItems.RUBY_HELMET.get());
                output.accept(ModItems.RUBY_CHESTPLATE.get());
                output.accept(ModItems.RUBY_LEGGINGS.get());
                output.accept(ModItems.RUBY_BOOTS.get());
                
                // Sculk Armor Set
                output.accept(ModItems.SCULK_HELMET.get());
                output.accept(ModItems.SCULK_CHESTPLATE.get());
                output.accept(ModItems.SCULK_LEGGINGS.get());
                output.accept(ModItems.SCULK_BOOTS.get());
                
                // Shulker Armor Set
                output.accept(ModItems.SHULKER_HELMET.get());
                output.accept(ModItems.SHULKER_CHESTPLATE.get());
                output.accept(ModItems.SHULKER_LEGGINGS.get());
                output.accept(ModItems.SHULKER_BOOTS.get());
                
                // Skeleton Armor Set
                output.accept(ModItems.SKELETON_HELMET.get());
                output.accept(ModItems.SKELETON_CHESTPLATE.get());
                output.accept(ModItems.SKELETON_LEGGINGS.get());
                output.accept(ModItems.SKELETON_BOOTS.get());
                
                // Sniffer Armor Set
                output.accept(ModItems.SNIFFER_HELMET.get());
                output.accept(ModItems.SNIFFER_CHESTPLATE.get());
                output.accept(ModItems.SNIFFER_LEGGINGS.get());
                output.accept(ModItems.SNIFFER_BOOTS.get());
                
                // TNT Armor Set
                output.accept(ModItems.TNT_HELMET.get());
                output.accept(ModItems.TNT_CHESTPLATE.get());
                output.accept(ModItems.TNT_LEGGINGS.get());
                output.accept(ModItems.TNT_BOOTS.get());
                
                // Totem Armor Set
                output.accept(ModItems.TOTEM_HELMET.get());
                output.accept(ModItems.TOTEM_CHESTPLATE.get());
                output.accept(ModItems.TOTEM_LEGGINGS.get());
                output.accept(ModItems.TOTEM_BOOTS.get());
                
                // Wither Skeleton Armor Set
                output.accept(ModItems.WITHER_SKELETON_HELMET.get());
                output.accept(ModItems.WITHER_SKELETON_CHESTPLATE.get());
                output.accept(ModItems.WITHER_SKELETON_LEGGINGS.get());
                output.accept(ModItems.WITHER_SKELETON_BOOTS.get());
                
                // Elytra Items (only normal variants, broken variants are obtained through damage)
                output.accept(ModItems.BOOK_ELYTRA.get());
                output.accept(ModItems.CHICKEN_ELYTRA.get());
                output.accept(ModItems.END_PORTAL_ELYTRA.get());
                output.accept(ModItems.FAIRY_ELYTRA.get());
                output.accept(ModItems.FIRE_ELYTRA.get());
                output.accept(ModItems.FIRST_FLIGHT_ELYTRA.get());
                output.accept(ModItems.ICE_ELYTRA.get());
                output.accept(ModItems.LEAF_ELYTRA.get());
                output.accept(ModItems.MELON_ELYTRA.get());
                output.accept(ModItems.NETHER_PORTAL_ELYTRA.get());
                output.accept(ModItems.OCTOPUS_ELYTRA.get());
                output.accept(ModItems.PARROT_ELYTRA.get());
                output.accept(ModItems.PUMPKIN_ELYTRA.get());
                output.accept(ModItems.RGB_ELYTRA.get());
                output.accept(ModItems.SHIELD_ELYTRA.get());
                output.accept(ModItems.SOUL_FIRE_ELYTRA.get());
                output.accept(ModItems.SPIDER_ELYTRA.get());
                output.accept(ModItems.TARGET_ELYTRA.get());
                output.accept(ModItems.WIFI_ELYTRA.get());
            })
            .build());

    public VanillaPlus() {        
        // Register items
        ModItems.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        
        // Register creative tabs
        CREATIVE_TABS.register(FMLJavaModLoadingContext.get().getModEventBus());
        
        // Register recipe serializers
        RECIPE_SERIALIZERS.register(FMLJavaModLoadingContext.get().getModEventBus());
        

        
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onLivingTick(LivingEvent.LivingTickEvent event) {
        var entity = event.getEntity();
        ItemStack chest = entity.getItemBySlot(EquipmentSlot.CHEST);
        if (!chest.isEmpty() && chest.getItem() instanceof CustomElytraItem) {
            if (chest.getDamageValue() >= chest.getMaxDamage() - 1 && chest.getMaxDamage() > 1) {
                // Find the broken variant
                String id = ForgeRegistries.ITEMS.getKey(chest.getItem()).getPath();
                if (!id.startsWith("broken_")) {
                    String brokenId = "broken_" + id;
                    var brokenItem = ForgeRegistries.ITEMS.getValue(new net.minecraft.resources.ResourceLocation(VanillaPlus.MOD_ID, brokenId));
                    if (brokenItem != null) {
                        ItemStack brokenStack = new ItemStack(brokenItem);
                        // Set the broken elytra to maximum damage (broken state)
                        brokenStack.setDamageValue(brokenStack.getMaxDamage() - 1);
                        entity.setItemSlot(EquipmentSlot.CHEST, brokenStack);
                    }
                }
            }
        }
    }
    

    

} 