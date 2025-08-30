package com.morearmor.init.armors;

import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;

public class GuardianArmorItem extends ArmorItem {
    public GuardianArmorItem(ArmorMaterial material, Type type, Item.Properties properties) {
        super(material, type, properties);
    }

    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
        if (slot == EquipmentSlot.LEGS) {
            // Layer 2 (leggings) - static, no animation
            return "morearmor:textures/models/averagetateman/armors/guardian/layer_2.png";
        } else {
            // Layer 1 (helmet, chestplate, boots) - animated
            // Guardian armor animation timing - based on OptiFine CIT config
            // Frame sequence: [0, 1, 2, 3, 4, 5, 6, 7, 8, 9] with special timing
            int[] frameSequence = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}; // 10-frame sequence
            
            // Calculate frame with special timing for frames 0 and 5 (100 ticks each)
            int totalTicks = entity.tickCount;
            int frameIndex = 0;
            
            // Frame 0 gets 100 ticks, frames 1-4 get 1 tick each
            if (totalTicks < 100) {
                frameIndex = 0;
            } else if (totalTicks < 104) {
                frameIndex = totalTicks - 99; // Frames 1-4
            } else if (totalTicks < 204) {
                frameIndex = 5; // Frame 5 gets 100 ticks
            } else if (totalTicks < 214) {
                frameIndex = totalTicks - 203; // Frames 6-9
            } else {
                // Reset cycle
                frameIndex = (totalTicks - 214) % 10;
            }
            
            int frame = frameSequence[frameIndex % frameSequence.length];
            return String.format("morearmor:textures/models/averagetateman/armors/guardian/layer_1_frame%d.png", frame);
        }
    }
} 