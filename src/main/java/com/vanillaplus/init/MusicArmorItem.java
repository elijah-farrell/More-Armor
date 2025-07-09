package com.vanillaplus.init;

import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;

public class MusicArmorItem extends ArmorItem {
    public MusicArmorItem(ArmorMaterial material, Type type, Item.Properties properties) {
        super(material, type, properties);
    }

    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
        if (slot == EquipmentSlot.LEGS) {
            // Layer 2 (leggings) - static, no animation
            return "vanillaplus:textures/models/averagetateman/armor/music/layer_2.png";
        } else {
            // Layer 1 (helmet, chestplate, boots) - animated with custom timing
            // Music armor animation timing - based on OptiFine CIT config
            // Frame sequence: [0, 1, 2, 3, 4, 5] with special timing
            // duration.0=100, duration.3=7, others use default duration=2
            int totalTicks = entity.tickCount;
            int frame = 0;
            
            // Calculate frame with custom timing
            if (totalTicks < 100) {
                frame = 0; // Frame 0 gets 100 ticks
            } else if (totalTicks < 102) {
                frame = 1; // Frame 1 gets 2 ticks
            } else if (totalTicks < 104) {
                frame = 2; // Frame 2 gets 2 ticks
            } else if (totalTicks < 111) {
                frame = 3; // Frame 3 gets 7 ticks
            } else if (totalTicks < 113) {
                frame = 4; // Frame 4 gets 2 ticks
            } else if (totalTicks < 115) {
                frame = 5; // Frame 5 gets 2 ticks
            } else {
                // Reset cycle (total cycle = 115 ticks)
                frame = (totalTicks - 115) % 6;
            }
            
            return String.format("vanillaplus:textures/models/averagetateman/armor/music/layer_1_frame%d.png", frame);
        }
    }
} 