package com.morearmor.data;

import com.morearmor.MoreArmor;
import com.morearmor.init.MoreArmorItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MoreArmor.MOD_ID)
public class LootTableInjector {
    
    @SubscribeEvent
    public static void onLootTableLoad(LootTableLoadEvent event) {
        ResourceLocation tableName = event.getName();
        
        // End City Treasure - Ender Dragon Armor
        if (tableName.equals(new ResourceLocation("minecraft", "chests/end_city_treasure"))) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1))
                .add(LootItem.lootTableItem(MoreArmorItems.ENDER_DRAGON_HELMET.get()).setWeight(1))
                .add(LootItem.lootTableItem(MoreArmorItems.ENDER_DRAGON_CHESTPLATE.get()).setWeight(1))
                .add(LootItem.lootTableItem(MoreArmorItems.ENDER_DRAGON_LEGGINGS.get()).setWeight(1))
                .add(LootItem.lootTableItem(MoreArmorItems.ENDER_DRAGON_BOOTS.get()).setWeight(1));
            
            event.getTable().addPool(poolBuilder.build());
        }
        
        // Stronghold Library - Bedrock Armor
        if (tableName.equals(new ResourceLocation("minecraft", "chests/stronghold_library"))) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1))
                .add(LootItem.lootTableItem(MoreArmorItems.BEDROCK_HELMET.get()).setWeight(1))
                .add(LootItem.lootTableItem(MoreArmorItems.BEDROCK_CHESTPLATE.get()).setWeight(1))
                .add(LootItem.lootTableItem(MoreArmorItems.BEDROCK_LEGGINGS.get()).setWeight(1))
                .add(LootItem.lootTableItem(MoreArmorItems.BEDROCK_BOOTS.get()).setWeight(1));
            
            event.getTable().addPool(poolBuilder.build());
        }
        
        // Nether Bridge - Red Dragon Armor
        if (tableName.equals(new ResourceLocation("minecraft", "chests/nether_bridge"))) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1))
                .add(LootItem.lootTableItem(MoreArmorItems.RED_DRAGON_HELMET.get()).setWeight(1))
                .add(LootItem.lootTableItem(MoreArmorItems.RED_DRAGON_CHESTPLATE.get()).setWeight(1))
                .add(LootItem.lootTableItem(MoreArmorItems.RED_DRAGON_LEGGINGS.get()).setWeight(1))
                .add(LootItem.lootTableItem(MoreArmorItems.RED_DRAGON_BOOTS.get()).setWeight(1));
            
            event.getTable().addPool(poolBuilder.build());
        }
        
        // Village Armorer - Emerald Armor
        if (tableName.equals(new ResourceLocation("minecraft", "chests/village/village_armorer"))) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1))
                .add(LootItem.lootTableItem(MoreArmorItems.EMERALD_HELMET.get()).setWeight(1))
                .add(LootItem.lootTableItem(MoreArmorItems.EMERALD_CHESTPLATE.get()).setWeight(1))
                .add(LootItem.lootTableItem(MoreArmorItems.EMERALD_LEGGINGS.get()).setWeight(1))
                .add(LootItem.lootTableItem(MoreArmorItems.EMERALD_BOOTS.get()).setWeight(1));
            
            event.getTable().addPool(poolBuilder.build());
        }
        
        // Village Weaponsmith - Emerald Armor
        if (tableName.equals(new ResourceLocation("minecraft", "chests/village/village_weaponsmith"))) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1))
                .add(LootItem.lootTableItem(MoreArmorItems.EMERALD_HELMET.get()).setWeight(1))
                .add(LootItem.lootTableItem(MoreArmorItems.EMERALD_CHESTPLATE.get()).setWeight(1))
                .add(LootItem.lootTableItem(MoreArmorItems.EMERALD_LEGGINGS.get()).setWeight(1))
                .add(LootItem.lootTableItem(MoreArmorItems.EMERALD_BOOTS.get()).setWeight(1));
            
            event.getTable().addPool(poolBuilder.build());
        }
        
        // Broken Nether Portal - Obsidian Armor
        if (tableName.equals(new ResourceLocation("minecraft", "chests/ruined_portal"))) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1))
                .add(LootItem.lootTableItem(MoreArmorItems.OBSIDIAN_HELMET.get()).setWeight(1))
                .add(LootItem.lootTableItem(MoreArmorItems.OBSIDIAN_CHESTPLATE.get()).setWeight(1))
                .add(LootItem.lootTableItem(MoreArmorItems.OBSIDIAN_LEGGINGS.get()).setWeight(1))
                .add(LootItem.lootTableItem(MoreArmorItems.OBSIDIAN_BOOTS.get()).setWeight(1));
            
            event.getTable().addPool(poolBuilder.build());
        }
        
        // Woodland Mansion - Totem Armor
        if (tableName.equals(new ResourceLocation("minecraft", "chests/woodland_mansion"))) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1))
                .add(LootItem.lootTableItem(MoreArmorItems.TOTEM_HELMET.get()).setWeight(1))
                .add(LootItem.lootTableItem(MoreArmorItems.TOTEM_CHESTPLATE.get()).setWeight(1))
                .add(LootItem.lootTableItem(MoreArmorItems.TOTEM_LEGGINGS.get()).setWeight(1))
                .add(LootItem.lootTableItem(MoreArmorItems.TOTEM_BOOTS.get()).setWeight(1));
            
            event.getTable().addPool(poolBuilder.build());
        }
        
        // Ancient City - Reinforced Deepslate Armor
        if (tableName.equals(new ResourceLocation("minecraft", "chests/ancient_city"))) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1))
                .add(LootItem.lootTableItem(MoreArmorItems.REINFORCED_DEEPSLATE_HELMET.get()).setWeight(1))
                .add(LootItem.lootTableItem(MoreArmorItems.REINFORCED_DEEPSLATE_CHESTPLATE.get()).setWeight(1))
                .add(LootItem.lootTableItem(MoreArmorItems.REINFORCED_DEEPSLATE_LEGGINGS.get()).setWeight(1))
                .add(LootItem.lootTableItem(MoreArmorItems.REINFORCED_DEEPSLATE_BOOTS.get()).setWeight(1));
            
            event.getTable().addPool(poolBuilder.build());
        }
        
        // Bastion Treasure - Ancient Debris Armor
        if (tableName.equals(new ResourceLocation("minecraft", "chests/bastion_treasure"))) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1))
                .add(LootItem.lootTableItem(MoreArmorItems.ANCIENT_DEBRIS_HELMET.get()).setWeight(1))
                .add(LootItem.lootTableItem(MoreArmorItems.ANCIENT_DEBRIS_CHESTPLATE.get()).setWeight(1))
                .add(LootItem.lootTableItem(MoreArmorItems.ANCIENT_DEBRIS_LEGGINGS.get()).setWeight(1))
                .add(LootItem.lootTableItem(MoreArmorItems.ANCIENT_DEBRIS_BOOTS.get()).setWeight(1));
            
            event.getTable().addPool(poolBuilder.build());
        }
        
        // Bastion Bridge - Gilded Armor
        if (tableName.equals(new ResourceLocation("minecraft", "chests/bastion_bridge"))) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1))
                .add(LootItem.lootTableItem(MoreArmorItems.GILDED_HELMET.get()).setWeight(1))
                .add(LootItem.lootTableItem(MoreArmorItems.GILDED_CHESTPLATE.get()).setWeight(1))
                .add(LootItem.lootTableItem(MoreArmorItems.GILDED_LEGGINGS.get()).setWeight(1))
                .add(LootItem.lootTableItem(MoreArmorItems.GILDED_BOOTS.get()).setWeight(1));
            
            event.getTable().addPool(poolBuilder.build());
        }
        
        // Bastion Hoglin Stable - Gilded Armor
        if (tableName.equals(new ResourceLocation("minecraft", "chests/bastion_hoglin_stable"))) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1))
                .add(LootItem.lootTableItem(MoreArmorItems.GILDED_HELMET.get()).setWeight(1))
                .add(LootItem.lootTableItem(MoreArmorItems.GILDED_CHESTPLATE.get()).setWeight(1))
                .add(LootItem.lootTableItem(MoreArmorItems.GILDED_LEGGINGS.get()).setWeight(1))
                .add(LootItem.lootTableItem(MoreArmorItems.GILDED_BOOTS.get()).setWeight(1));
            
            event.getTable().addPool(poolBuilder.build());
        }
        
        // Bastion Other - Gilded Armor
        if (tableName.equals(new ResourceLocation("minecraft", "chests/bastion_other"))) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1))
                .add(LootItem.lootTableItem(MoreArmorItems.GILDED_HELMET.get()).setWeight(1))
                .add(LootItem.lootTableItem(MoreArmorItems.GILDED_CHESTPLATE.get()).setWeight(1))
                .add(LootItem.lootTableItem(MoreArmorItems.GILDED_LEGGINGS.get()).setWeight(1))
                .add(LootItem.lootTableItem(MoreArmorItems.GILDED_BOOTS.get()).setWeight(1));
            
            event.getTable().addPool(poolBuilder.build());
        }
        
        // Dungeon (Mob Spawner Room) - Skeleton Armor
        if (tableName.equals(new ResourceLocation("minecraft", "chests/simple_dungeon"))) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1))
                .add(LootItem.lootTableItem(MoreArmorItems.SKELETON_HELMET.get()).setWeight(1))
                .add(LootItem.lootTableItem(MoreArmorItems.SKELETON_CHESTPLATE.get()).setWeight(1))
                .add(LootItem.lootTableItem(MoreArmorItems.SKELETON_LEGGINGS.get()).setWeight(1))
                .add(LootItem.lootTableItem(MoreArmorItems.SKELETON_BOOTS.get()).setWeight(1));
            
            event.getTable().addPool(poolBuilder.build());
        }
        
        // Shipwreck Treasure - Guardian Armor
        if (tableName.equals(new ResourceLocation("minecraft", "chests/shipwreck_treasure"))) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1))
                .add(LootItem.lootTableItem(MoreArmorItems.GUARDIAN_HELMET.get()).setWeight(1))
                .add(LootItem.lootTableItem(MoreArmorItems.GUARDIAN_CHESTPLATE.get()).setWeight(1))
                .add(LootItem.lootTableItem(MoreArmorItems.GUARDIAN_LEGGINGS.get()).setWeight(1))
                .add(LootItem.lootTableItem(MoreArmorItems.GUARDIAN_BOOTS.get()).setWeight(1));
            
            event.getTable().addPool(poolBuilder.build());
        }
        
        // Underwater Ruin Big - Sniffer Armor
        if (tableName.equals(new ResourceLocation("minecraft", "chests/underwater_ruin_big"))) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1))
                .add(LootItem.lootTableItem(MoreArmorItems.SNIFFER_HELMET.get()).setWeight(3))
                .add(LootItem.lootTableItem(MoreArmorItems.SNIFFER_CHESTPLATE.get()).setWeight(3))
                .add(LootItem.lootTableItem(MoreArmorItems.SNIFFER_LEGGINGS.get()).setWeight(3))
                .add(LootItem.lootTableItem(MoreArmorItems.SNIFFER_BOOTS.get()).setWeight(3));
            
            event.getTable().addPool(poolBuilder.build());
        }
        
        // Underwater Ruin Small - Sniffer Armor
        if (tableName.equals(new ResourceLocation("minecraft", "chests/underwater_ruin_small"))) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1))
                .add(LootItem.lootTableItem(MoreArmorItems.SNIFFER_HELMET.get()).setWeight(2))
                .add(LootItem.lootTableItem(MoreArmorItems.SNIFFER_CHESTPLATE.get()).setWeight(2))
                .add(LootItem.lootTableItem(MoreArmorItems.SNIFFER_LEGGINGS.get()).setWeight(2))
                .add(LootItem.lootTableItem(MoreArmorItems.SNIFFER_BOOTS.get()).setWeight(2));
            
            event.getTable().addPool(poolBuilder.build());
        }
        
        // Desert Pyramid - Cactus Armor
        if (tableName.equals(new ResourceLocation("minecraft", "chests/desert_pyramid"))) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1))
                .add(LootItem.lootTableItem(MoreArmorItems.CACTUS_HELMET.get()).setWeight(3))
                .add(LootItem.lootTableItem(MoreArmorItems.CACTUS_CHESTPLATE.get()).setWeight(3))
                .add(LootItem.lootTableItem(MoreArmorItems.CACTUS_LEGGINGS.get()).setWeight(3))
                .add(LootItem.lootTableItem(MoreArmorItems.CACTUS_BOOTS.get()).setWeight(3));
            
            event.getTable().addPool(poolBuilder.build());
        }
        
        // Jungle Temple - RGB 
        if (tableName.equals(new ResourceLocation("minecraft", "chests/jungle_pyramid"))) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1))
                .add(LootItem.lootTableItem(MoreArmorItems.RGB_HELMET.get()).setWeight(2))
                .add(LootItem.lootTableItem(MoreArmorItems.RGB_CHESTPLATE.get()).setWeight(2))
                .add(LootItem.lootTableItem(MoreArmorItems.RGB_LEGGINGS.get()).setWeight(2))
                .add(LootItem.lootTableItem(MoreArmorItems.RGB_BOOTS.get()).setWeight(2));
            
            event.getTable().addPool(poolBuilder.build());
        }
        

    }
} 