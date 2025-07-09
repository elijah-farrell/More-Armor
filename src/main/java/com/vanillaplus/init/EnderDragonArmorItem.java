package com.vanillaplus.init;

import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;

public class EnderDragonArmorItem extends ArmorItem {
    public EnderDragonArmorItem(ArmorMaterial material, Type type, Item.Properties properties) {
        super(material, type, properties);
    }

    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
        if (slot == EquipmentSlot.LEGS) {
            // Layer 2 (leggings) - static, no animation
            return "vanillaplus:textures/models/averagetateman/armor/ender_dragon/layer_2.png";
        } else {
            // Layer 1 (helmet, chestplate, boots) - animated
            // Ender dragon armor animation timing - based on OptiFine CIT config
            // duration=4, tile sequence: [0, 1, 0, 2]
            int[] frameSequence = {0, 1, 0, 2}; // 4-frame sequence
            int frameIndex = (entity.tickCount / 4) % frameSequence.length; // Change every 4 ticks (matches duration=4)
            int frame = frameSequence[frameIndex];
            
            return String.format("vanillaplus:textures/models/averagetateman/armor/ender_dragon/layer_1_frame%d.png", frame);
        }
    }
} 