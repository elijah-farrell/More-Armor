package com.morearmor.init.armors;

import com.morearmor.MoreArmor;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;

public class DefaultArmorItem extends ArmorItem {
    public DefaultArmorItem(ArmorMaterial material, Type type, Properties properties) {
        super(material, type, properties);
    }
    
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
        // Get the material name and convert to the correct path
        String materialName = this.getMaterial().getName().replace(MoreArmor.MOD_ID + ":", "");
        return "morearmor:textures/models/averagetateman/armors/" + materialName + "/layer_" + 
               (slot == EquipmentSlot.LEGS ? "2" : "1") + ".png";
    }
}
