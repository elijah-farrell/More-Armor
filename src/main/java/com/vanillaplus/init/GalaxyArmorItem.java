package com.vanillaplus.init;

import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;

public class GalaxyArmorItem extends ArmorItem {
    public GalaxyArmorItem(ArmorMaterial material, Type type, Item.Properties properties) {
        super(material, type, properties);
    }

    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
        int frameCount = 15; // Number of frames in your animation
        int frame = (entity.tickCount / 5) % frameCount; // Change every 5 ticks
        String layer = (slot == EquipmentSlot.LEGS) ? "layer_2" : "layer_1";
        return String.format("vanillaplus:textures/models/armor/galaxy/%s_frame%d.png", layer, frame);
    }
} 