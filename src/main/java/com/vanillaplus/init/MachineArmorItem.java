package com.vanillaplus.init;

import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;

public class MachineArmorItem extends ArmorItem {
    public MachineArmorItem(ArmorMaterial material, Type type, Item.Properties properties) {
        super(material, type, properties);
    }

    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
        if (slot == EquipmentSlot.LEGS) {
            // Layer 2 (leggings) - animated with 2 frames, 15 ticks each
            int[] layer2Sequence = {0, 1}; // 2-frame sequence
            int layer2FrameIndex = (entity.tickCount / 15) % layer2Sequence.length; // Change every 15 ticks
            int layer2Frame = layer2Sequence[layer2FrameIndex];
            return String.format("vanillaplus:textures/models/averagetateman/armor/machine/layer_2_frame%d.png", layer2Frame);
        } else {
            // Layer 1 (helmet, chestplate, boots) - animated with complex sequence
            // Machine armor animation timing - based on OptiFine CIT config
            // Frame sequence: [0, 1, 2, 1, 0, 3, 4, 5, 4, 3] with 3 ticks each
            int[] layer1Sequence = {0, 1, 2, 1, 0, 3, 4, 5, 4, 3}; // 10-frame sequence
            int layer1FrameIndex = (entity.tickCount / 3) % layer1Sequence.length; // Change every 3 ticks
            int layer1Frame = layer1Sequence[layer1FrameIndex];
            return String.format("vanillaplus:textures/models/averagetateman/armor/machine/layer_1_frame%d.png", layer1Frame);
        }
    }
} 