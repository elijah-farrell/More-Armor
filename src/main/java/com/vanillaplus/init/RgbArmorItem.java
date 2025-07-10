package com.vanillaplus.init;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;

public class RgbArmorItem extends ArmorItem {
    
    public RgbArmorItem(ArmorMaterial material, Type type, Properties properties) {
        super(material, type, properties);
    }
    
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
        // Both layer 1 and layer 2 are animated for RGB armor
        // Layer 1: helmet, chestplate, boots
        // Layer 2: leggings
        
        // Simple frame cycling animation for both layers
        int totalTicks = entity.tickCount % 180; // 9 second cycle (180 ticks)
        int frame = (totalTicks / 5) % 18; // 5 ticks per frame, 18 frames
        
        String layer = (slot == EquipmentSlot.LEGS) ? "layer_2" : "layer_1";
        return String.format("vanillaplus:textures/models/averagetateman/armors/rgb/%s_frame%d.png", layer, frame);
    }
} 