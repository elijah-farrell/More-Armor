package com.vanillaplus.init;

import com.vanillaplus.VanillaPlus;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, VanillaPlus.MOD_ID);
    
    // Galaxy Armor Set
    public static final RegistryObject<Item> GALAXY_HELMET = ITEMS.register("galaxy_helmet",
            () -> new ArmorItem(ModArmorMaterials.GALAXY, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> GALAXY_CHESTPLATE = ITEMS.register("galaxy_chestplate",
            () -> new ArmorItem(ModArmorMaterials.GALAXY, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> GALAXY_LEGGINGS = ITEMS.register("galaxy_leggings",
            () -> new ArmorItem(ModArmorMaterials.GALAXY, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> GALAXY_BOOTS = ITEMS.register("galaxy_boots",
            () -> new ArmorItem(ModArmorMaterials.GALAXY, ArmorItem.Type.BOOTS, new Item.Properties()));
} 