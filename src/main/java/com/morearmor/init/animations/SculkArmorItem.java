package com.morearmor.init.animations;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;

public class SculkArmorItem extends ArmorItem {
    
    public SculkArmorItem(ArmorMaterial material, Type type, Properties properties) {
        super(material, type, properties);
    }
    
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
        // Both layer 1 and layer 2 are animated for sculk armor
        // Layer 1: helmet, chestplate, boots
        // Layer 2: leggings
        
        if (slot == EquipmentSlot.LEGS) {
            // Layer 2 animation: 0,1,2,1 (4 frames total)
            int totalTicks = entity.tickCount % 80; // 4 frames * 20 ticks = 80 total
            int framePosition = totalTicks / 20; // 20 ticks per frame
            
            int frame;
            if (framePosition == 0) frame = 0;
            else if (framePosition == 1) frame = 1;
            else if (framePosition == 2) frame = 2;
            else frame = 1; // framePosition == 3
            
            return String.format("morearmor:textures/models/averagetateman/armors/sculk/layer_2_frame%d.png", frame);
        } else {
            // Layer 1 animation: 0,1,2,1,0,1,2,1,0,3,3,4,5,4,3,3 (16 frames total)
            int totalTicks = entity.tickCount % 320; // 16 frames * 20 ticks = 320 total
            int framePosition = totalTicks / 20; // 20 ticks per frame
            
            int frame;
            if (framePosition == 0) frame = 0;
            else if (framePosition == 1) frame = 1;
            else if (framePosition == 2) frame = 2;
            else if (framePosition == 3) frame = 1;
            else if (framePosition == 4) frame = 0;
            else if (framePosition == 5) frame = 1;
            else if (framePosition == 6) frame = 2;
            else if (framePosition == 7) frame = 1;
            else if (framePosition == 8) frame = 0;
            else if (framePosition == 9) frame = 3;
            else if (framePosition == 10) frame = 3;
            else if (framePosition == 11) frame = 4;
            else if (framePosition == 12) frame = 5;
            else if (framePosition == 13) frame = 4;
            else if (framePosition == 14) frame = 3;
            else frame = 3; // framePosition == 15
            
            return String.format("morearmor:textures/models/averagetateman/armors/sculk/layer_1_frame%d.png", frame);
        }
    }
} 