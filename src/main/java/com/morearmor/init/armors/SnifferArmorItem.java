package com.morearmor.init.armors;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;

public class SnifferArmorItem extends ArmorItem {
    
    public SnifferArmorItem(ArmorMaterial material, Type type, Properties properties) {
        super(material, type, properties);
    }
    
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
        // Only layer 1 (helmet, chestplate, boots) is animated
        // Layer 2 (leggings) is static
        if (slot == EquipmentSlot.LEGS) {
            // Static texture for leggings (layer 2)
            return "morearmor:textures/models/averagetateman/armors/sniffer/layer_2.png";
        } else {
            // Animated texture for other pieces (layer 1)
            // Animation sequence: 0(100),2(3),0(3),2(3),0(100),1(3),0(3),1(3)
            int totalTicks = entity.tickCount % 218; // 100+3+3+3+100+3+3+3 = 218 total
            
            int frame;
            if (totalTicks < 100) frame = 0;
            else if (totalTicks < 103) frame = 2;
            else if (totalTicks < 106) frame = 0;
            else if (totalTicks < 109) frame = 2;
            else if (totalTicks < 209) frame = 0;
            else if (totalTicks < 212) frame = 1;
            else if (totalTicks < 215) frame = 0;
            else frame = 1; // totalTicks < 218
            
            return String.format("morearmor:textures/models/averagetateman/armors/sniffer/layer_1_frame%d.png", frame);
        }
    }
} 