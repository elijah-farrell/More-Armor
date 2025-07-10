package com.vanillaplus.init;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;

public class PotArmorItem extends ArmorItem {
    
    public PotArmorItem(ArmorMaterial material, Type type, Properties properties) {
        super(material, type, properties);
    }
    
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
        // Only layer 1 (helmet, chestplate, boots) is animated
        // Layer 2 (leggings) is static
        if (slot == EquipmentSlot.LEGS) {
            // Static texture for leggings (layer 2)
            return "vanillaplus:textures/models/averagetateman/armor/pot/layer_2.png";
        } else {
            // Animated texture for other pieces (layer 1)
            // Animation sequence: 0(100),0(50),1(100),0(100),0(50),2(100),0(100),0(50),3(100),0(100),0(50),4(100),0(100),0(50),5(100)
            int totalTicks = entity.tickCount % 1200; // Total cycle: 100+50+100+100+50+100+100+50+100+100+50+100+100+50+100 = 1200
            
            int frame;
            if (totalTicks < 100) frame = 0;
            else if (totalTicks < 150) frame = 0;
            else if (totalTicks < 250) frame = 1;
            else if (totalTicks < 350) frame = 0;
            else if (totalTicks < 400) frame = 0;
            else if (totalTicks < 500) frame = 2;
            else if (totalTicks < 600) frame = 0;
            else if (totalTicks < 650) frame = 0;
            else if (totalTicks < 750) frame = 3;
            else if (totalTicks < 850) frame = 0;
            else if (totalTicks < 900) frame = 0;
            else if (totalTicks < 1000) frame = 4;
            else if (totalTicks < 1100) frame = 0;
            else if (totalTicks < 1150) frame = 0;
            else frame = 5;
            
            return String.format("vanillaplus:textures/models/averagetateman/armor/pot/layer_1_frame%d.png", frame);
        }
    }
} 