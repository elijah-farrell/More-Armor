package com.morearmor.init.animations;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;

public class ObsidianArmorItem extends ArmorItem {
    
    public ObsidianArmorItem(ArmorMaterial material, Type type, Properties properties) {
        super(material, type, properties);
    }
    
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
        // Only layer 1 (helmet, chestplate, boots) is animated
        // Layer 2 (leggings) is static
        if (slot == EquipmentSlot.LEGS) {
            // Static texture for leggings (layer 2)
            return "morearmor:textures/models/averagetateman/armors/obsidian/layer_2.png";
        } else {
            // Animated texture for other pieces (layer 1) - ping-pong: 0,1,2,3,4,3,2,1,0
            int totalTicks = entity.tickCount % 24; // 8 frames * 3 ticks = 24 total
            int framePosition = totalTicks / 3;
            
            int frame;
            if (framePosition < 5) {
                // Forward: 0,1,2,3,4
                frame = framePosition;
            } else {
                // Backward: 3,2,1,0 (from position 5,6,7)
                frame = 7 - framePosition;
            }
            
            return String.format("morearmor:textures/models/averagetateman/armors/obsidian/layer_1_frame%d.png", frame);
        }
    }
} 