package com.morearmor.util;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.util.Lazy;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nonnull;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ArmorConfigLoader {
    private static final Map<String, ArmorMaterial> MATERIALS = new HashMap<>();
    private static boolean loaded = false;
    
    public static void loadMaterials() {
        if (loaded) return;
        
        try {
            // Load the config file from resources
            InputStream inputStream = ArmorConfigLoader.class.getClassLoader()
                .getResourceAsStream("armor_config.json");
            
            if (inputStream == null) {
                System.err.println("Could not find armor_config.json");
                return;
            }
            
            // Parse JSON
            JsonObject config = JsonParser.parseReader(new InputStreamReader(inputStream)).getAsJsonObject();
            
            // Create materials for each armor type
            for (String materialName : config.keySet()) {
                JsonObject materialData = config.getAsJsonObject(materialName);
                
                // Create protection array from individual protection fields
                int[] protectionAmounts = new int[4];
                protectionAmounts[0] = materialData.get("helmet_protection").getAsInt();
                protectionAmounts[1] = materialData.get("chestplate_protection").getAsInt();
                protectionAmounts[2] = materialData.get("leggings_protection").getAsInt();
                protectionAmounts[3] = materialData.get("boots_protection").getAsInt();
                
                ArmorMaterial material = new ModArmorMaterial(
                    materialName,
                    materialData.get("durability").getAsInt(),
                    protectionAmounts,
                    materialData.get("enchantment").getAsInt(),
                    getSoundEvent(materialData.get("sound").getAsString()),
                    materialData.get("toughness").getAsFloat(),
                    materialData.get("knockback_resistance").getAsFloat(),
                    () -> Ingredient.of(getRepairIngredient(materialData.get("repair_ingredient").getAsString()))
                );
                
                MATERIALS.put(materialName, material);
            }
            
            loaded = true;
            System.out.println("Loaded " + MATERIALS.size() + " armor materials from config");
            
        } catch (Exception e) {
            System.err.println("Failed to load armor config: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    public static ArmorMaterial getMaterial(String name) {
        if (!loaded) {
            loadMaterials();
        }
        return MATERIALS.get(name);
    }
    
    private static SoundEvent getSoundEvent(String soundId) {
        try {
            // Just get the sound directly from the registry using the ID from JSON
            return ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation(soundId));
        } catch (Exception e) {
            System.err.println("Could not find sound: " + soundId + ", using ARMOR_EQUIP_IRON as fallback");
            return SoundEvents.ARMOR_EQUIP_IRON;
        }
    }
    
    private static Item getRepairIngredient(String itemId) {
        try {
            // Just get the item directly from the registry using the ID from JSON
            return ForgeRegistries.ITEMS.getValue(new ResourceLocation(itemId));
        } catch (Exception e) {
            System.err.println("Could not find item: " + itemId + ", using iron_ingot as fallback");
            return Items.IRON_INGOT;
        }
    }
    
    private static class ModArmorMaterial implements ArmorMaterial {
        private final String name;
        private final int durabilityMultiplier;
        private final int[] protectionAmounts;
        private final int enchantmentValue;
        private final SoundEvent equipSound;
        private final float toughness;
        private final float knockbackResistance;
        private final Lazy<Ingredient> repairIngredient;
        
        ModArmorMaterial(String name, int durabilityMultiplier, int[] protectionAmounts, int enchantmentValue, 
                        SoundEvent equipSound, float toughness, float knockbackResistance, 
                        Supplier<Ingredient> repairIngredient) {
            this.name = "morearmor:" + name;
            this.durabilityMultiplier = durabilityMultiplier;
            this.protectionAmounts = protectionAmounts;
            this.enchantmentValue = enchantmentValue;
            this.equipSound = equipSound;
            this.toughness = toughness;
            this.knockbackResistance = knockbackResistance;
            this.repairIngredient = Lazy.of(repairIngredient);
        }
        
        @Override
        public int getDurabilityForType(@Nonnull ArmorItem.Type type) {
            return switch (type) {
                case BOOTS -> 13 * durabilityMultiplier;
                case LEGGINGS -> 15 * durabilityMultiplier;
                case CHESTPLATE -> 16 * durabilityMultiplier;
                case HELMET -> 11 * durabilityMultiplier;
            };
        }
        
        @Override
        public int getDefenseForType(@Nonnull ArmorItem.Type type) {
            return protectionAmounts[type.ordinal()];
        }
        
        @Override
        public int getEnchantmentValue() {
            return enchantmentValue;
        }
        
        @Override
        public SoundEvent getEquipSound() {
            return equipSound;
        }
        
        @Override
        public Ingredient getRepairIngredient() {
            return repairIngredient.get();
        }
        
        @Override
        public String getName() {
            return name;
        }
        
        @Override
        public float getToughness() {
            return toughness;
        }
        
        @Override
        public float getKnockbackResistance() {
            return knockbackResistance;
        }
    }
}
