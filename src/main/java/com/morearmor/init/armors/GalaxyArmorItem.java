package com.morearmor.init.armors;

import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;

public class GalaxyArmorItem extends DefaultArmorItem {
    public GalaxyArmorItem(String materialName, Type type, Item.Properties properties) {
        super(materialName, type, properties);
    }

    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
        // Animation: frame 0 for 100 ticks, frames 1-23 for 3 ticks each, then loop
        int totalTicks = entity.tickCount % 169; // 100 + (23*3) = 169
        int frame;
        if (totalTicks < 100) {
            frame = 0;
        } else {
            frame = 1 + ((totalTicks - 100) / 3);
        }
        String layer = (slot == EquipmentSlot.LEGS) ? "layer_2" : "layer_1";
        return String.format("morearmor:textures/models/averagetateman/armors/galaxy/%s_frame%d.png", layer, frame);
    }
} 