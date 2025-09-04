package com.morearmor.init.armors;

import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;

public class ObsidianArmorItem extends DefaultArmorItem {
    public ObsidianArmorItem(ArmorMaterial material, Type type, Item.Properties properties) {
        super(material, type, properties);
    }

    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
        if (slot == EquipmentSlot.LEGS) {
            // Layer 2 (leggings) - static, no animation
            return "morearmor:textures/models/averagetateman/armors/obsidian/layer_2.png";
        } else {
            // Layer 1 (helmet, chestplate, boots) - animated with 4 frames, 20 ticks each
            int frameCount = 4; // 4 frames for obsidian animation
            int frame = (entity.tickCount / 20) % frameCount; // Change every 20 ticks for slow, steady animation
            return String.format("morearmor:textures/models/averagetateman/armors/obsidian/layer_1_frame%d.png", frame);
        }
    }
} 