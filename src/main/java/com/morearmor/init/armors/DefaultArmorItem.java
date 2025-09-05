package com.morearmor.init.armors;

import com.morearmor.MoreArmor;
import com.morearmor.config.ModConfigs;

import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import net.minecraft.world.entity.ai.attributes.Attribute;
import java.util.UUID;
import javax.annotation.Nonnull;

public class DefaultArmorItem extends ArmorItem {
    
    // UUIDs for armor attribute modifiers (one per slot)
    private static final UUID[] MOREARMOR_ARMOR_MODIFIER_UUIDS = new UUID[] {
        UUID.fromString("845DB27C-C624-495F-8C9F-6020A9A58B6B"), // FEET
        UUID.fromString("D8499B04-0E66-4726-AB29-64469D734E0D"), // LEGS  
        UUID.fromString("9F3D476D-C118-4544-8365-64846904B48E"), // CHEST
        UUID.fromString("2AD3F246-FEE1-4E67-B886-69FD380BB150")  // HEAD
    };
    
    private static final UUID[] MOREARMOR_TOUGHNESS_MODIFIER_UUIDS = new UUID[] {
        UUID.fromString("845DB27C-C624-495F-8C9F-6020A9A58B6C"), // FEET
        UUID.fromString("D8499B04-0E66-4726-AB29-64469D734E0E"), // LEGS  
        UUID.fromString("9F3D476D-C118-4544-8365-64846904B48F"), // CHEST
        UUID.fromString("2AD3F246-FEE1-4E67-B886-69FD380BB151")  // HEAD
    };
    
    private static final UUID[] MOREARMOR_KNOCKBACK_MODIFIER_UUIDS = new UUID[] {
        UUID.fromString("845DB27C-C624-495F-8C9F-6020A9A58B6D"), // FEET
        UUID.fromString("D8499B04-0E66-4726-AB29-64469D734E0F"), // LEGS  
        UUID.fromString("9F3D476D-C118-4544-8365-64846904B490"), // CHEST
        UUID.fromString("2AD3F246-FEE1-4E67-B886-69FD380BB152")  // HEAD
    };
    
    public DefaultArmorItem(String materialName, Type type, Properties properties) {
        super(new DynamicArmorMaterial(materialName), type, properties);    }

    @Override
    public int getMaxDamage(ItemStack stack) {
        // Use the material's current durability instead of the cached value
        return this.getMaterial().getDurabilityForType(this.type);
    }
    
    @Override
    public int getDefense() {
        // Use the material's current protection value instead of the cached value
        return ModConfigs.getProtection(this.getMaterial().getName(), this.type);
    }
    
    @Override
    public float getToughness() {
        // Use the material's current toughness value instead of the cached value
        return this.getMaterial().getToughness();
    }
    
    @Override
    public Multimap<Attribute, AttributeModifier> getDefaultAttributeModifiers(@Nonnull EquipmentSlot slot) {
        if (slot == this.getEquipmentSlot()) {
            // Get current config values for protection and toughness
            String materialName = this.getMaterial().getName().replace(MoreArmor.MOD_ID + ":", "");
            int protection = ModConfigs.getProtection(materialName, this.type);
            float toughness = ModConfigs.getToughnessValue(materialName);
            float knockbackResistance = ModConfigs.getKnockbackResistanceValue(materialName);
            
            // Create attribute modifiers with current config values
            ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();
            
            // Add armor protection modifier
            int slotIndex = this.type.getSlot().getIndex();
            UUID armorUuid = MOREARMOR_ARMOR_MODIFIER_UUIDS[slotIndex];
            builder.put(Attributes.ARMOR, new AttributeModifier(armorUuid, "Armor modifier", protection, AttributeModifier.Operation.ADDITION));
            
            // Add armor toughness modifier (only if toughness > 0)
            if (toughness > 0.0F) {
                UUID toughnessUuid = MOREARMOR_TOUGHNESS_MODIFIER_UUIDS[slotIndex];
                builder.put(Attributes.ARMOR_TOUGHNESS, new AttributeModifier(toughnessUuid, "Armor toughness", toughness, AttributeModifier.Operation.ADDITION));
            }
            
            // Add knockback resistance modifier (only if knockbackResistance > 0)
            if (knockbackResistance > 0.0F) {
                UUID knockbackUuid = MOREARMOR_KNOCKBACK_MODIFIER_UUIDS[slotIndex];
                builder.put(Attributes.KNOCKBACK_RESISTANCE, new AttributeModifier(knockbackUuid, "Armor knockback resistance", knockbackResistance, AttributeModifier.Operation.ADDITION));
            }
            
            return builder.build();
        }
        
        return super.getDefaultAttributeModifiers(slot);
    }
    
    @Override
    public String getArmorTexture(ItemStack stack, Entity entity, EquipmentSlot slot, String type) {
        // Get the material name and convert to the correct path
        String materialName = this.getMaterial().getName().replace(MoreArmor.MOD_ID + ":", "");
        return "morearmor:textures/models/averagetateman/armors/" + materialName + "/layer_" + 
               (slot == EquipmentSlot.LEGS ? "2" : "1") + ".png";
    }
}
