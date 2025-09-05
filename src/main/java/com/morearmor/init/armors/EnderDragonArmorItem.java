package com.morearmor.init.armors;

import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;

public class EnderDragonArmorItem extends DefaultArmorItem {
    public EnderDragonArmorItem(String materialName, Type type, Item.Properties properties) {
        super(materialName, type, properties);
    }

    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
        if (slot == EquipmentSlot.LEGS) {
            // Layer 2 (leggings) - static, no animation
            return "morearmor:textures/models/averagetateman/armors/ender_dragon/layer_2.png";
        } else {
            // Layer 1 (helmet, chestplate, boots) - animated
            // Ender dragon armor animation timing - based on OptiFine CIT config
            // duration=4, tile sequence: [0, 1, 0, 2]
            int[] frameSequence = {0, 1, 0, 2}; // 4-frame sequence
            int frameIndex = (entity.tickCount / 4) % frameSequence.length; // Change every 4 ticks (matches duration=4)
            int frame = frameSequence[frameIndex];
            
            return String.format("morearmor:textures/models/averagetateman/armors/ender_dragon/layer_1_frame%d.png", frame);
        }
    }
} 