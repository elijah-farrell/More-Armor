package com.morearmor.init.armors;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;

public class RedDragonArmorItem extends DefaultArmorItem {
    
    public RedDragonArmorItem(String materialName, Type type, Properties properties) {
        super(materialName, type, properties);
    }
    
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
        // Only layer 1 (helmet, chestplate, boots) is animated
        // Layer 2 (leggings) is static
        if (slot == EquipmentSlot.LEGS) {
            // Static texture for leggings (layer 2)
            return "morearmor:textures/models/averagetateman/armors/red_dragon/layer_2.png";
        } else {
            // Animated texture for other pieces (layer 1)
            // Animation sequence: 0,1,0,2 (4 frames total)
            int totalTicks = entity.tickCount % 16; // 4 frames * 4 ticks = 16 total
            int framePosition = totalTicks / 4; // 4 ticks per frame
            
            int frame;
            if (framePosition == 0) frame = 0;
            else if (framePosition == 1) frame = 1;
            else if (framePosition == 2) frame = 0;
            else frame = 2; // framePosition == 3
            
            return String.format("morearmor:textures/models/averagetateman/armors/red_dragon/layer_1_frame%d.png", frame);
        }
    }
} 