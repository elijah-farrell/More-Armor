package com.vanillaplus.init;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;

public class TntArmorItem extends ArmorItem {
    
    public TntArmorItem(ArmorMaterial material, Type type, Properties properties) {
        super(material, type, properties);
    }
    
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
        // Both layer 1 and layer 2 are animated for TNT armor with the same sequence
        // Layer 1: helmet, chestplate, boots
        // Layer 2: leggings
        
        // Animation sequence: 0(100),1(5),0(5),1(5),0(5),1(5),2(2),3(2),4(2),5(2),6(2),7(2),8(2),9(2),10(2),11(50)
        int totalTicks = entity.tickCount % 200; // 100+5+5+5+5+5+2+2+2+2+2+2+2+2+2+50 = 200 total
        
        int frame;
        if (totalTicks < 100) frame = 0;
        else if (totalTicks < 105) frame = 1;
        else if (totalTicks < 110) frame = 0;
        else if (totalTicks < 115) frame = 1;
        else if (totalTicks < 120) frame = 0;
        else if (totalTicks < 125) frame = 1;
        else if (totalTicks < 127) frame = 2;
        else if (totalTicks < 129) frame = 3;
        else if (totalTicks < 131) frame = 4;
        else if (totalTicks < 133) frame = 5;
        else if (totalTicks < 135) frame = 6;
        else if (totalTicks < 137) frame = 7;
        else if (totalTicks < 139) frame = 8;
        else if (totalTicks < 141) frame = 9;
        else if (totalTicks < 143) frame = 10;
        else frame = 11; // totalTicks < 200
        
        String layer = (slot == EquipmentSlot.LEGS) ? "layer_2" : "layer_1";
        return String.format("vanillaplus:textures/models/averagetateman/armor/tnt/%s_frame%d.png", layer, frame);
    }
} 