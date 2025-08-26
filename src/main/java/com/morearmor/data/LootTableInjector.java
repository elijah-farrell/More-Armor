package com.morearmor.data;

import com.morearmor.MoreArmor;
import com.morearmor.init.ModItems;
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
                .add(LootItem.lootTableItem(ModItems.ENDER_DRAGON_HELMET.get()).setWeight(1))
                .add(LootItem.lootTableItem(ModItems.ENDER_DRAGON_CHESTPLATE.get()).setWeight(1))
                .add(LootItem.lootTableItem(ModItems.ENDER_DRAGON_LEGGINGS.get()).setWeight(1))
                .add(LootItem.lootTableItem(ModItems.ENDER_DRAGON_BOOTS.get()).setWeight(1));
            
            event.getTable().addPool(poolBuilder.build());
        }
        
        // End City Ship Item Frame - Elytra removed from mod
        // if (tableName.equals(new ResourceLocation("minecraft", "entities/end_city_treasure"))) {
        //     // Elytra loot removed - mod no longer includes elytra items
        // }
        
        // Stronghold Library - Bedrock Armor
        if (tableName.equals(new ResourceLocation("minecraft", "chests/stronghold_library"))) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1))
                .add(LootItem.lootTableItem(ModItems.BEDROCK_HELMET.get()).setWeight(1))
                .add(LootItem.lootTableItem(ModItems.BEDROCK_CHESTPLATE.get()).setWeight(1))
                .add(LootItem.lootTableItem(ModItems.BEDROCK_LEGGINGS.get()).setWeight(1))
                .add(LootItem.lootTableItem(ModItems.BEDROCK_BOOTS.get()).setWeight(1));
            
            event.getTable().addPool(poolBuilder.build());
        }
        
        // Nether Bridge - Red Dragon Armor
        if (tableName.equals(new ResourceLocation("minecraft", "chests/nether_bridge"))) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1))
                .add(LootItem.lootTableItem(ModItems.RED_DRAGON_HELMET.get()).setWeight(1))
                .add(LootItem.lootTableItem(ModItems.RED_DRAGON_CHESTPLATE.get()).setWeight(1))
                .add(LootItem.lootTableItem(ModItems.RED_DRAGON_LEGGINGS.get()).setWeight(1))
                .add(LootItem.lootTableItem(ModItems.RED_DRAGON_BOOTS.get()).setWeight(1));
            
            event.getTable().addPool(poolBuilder.build());
        }
        
        // Village Armorer - Emerald Armor
        if (tableName.equals(new ResourceLocation("minecraft", "chests/village/village_armorer"))) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1))
                .add(LootItem.lootTableItem(ModItems.EMERALD_HELMET.get()).setWeight(1))
                .add(LootItem.lootTableItem(ModItems.EMERALD_CHESTPLATE.get()).setWeight(1))
                .add(LootItem.lootTableItem(ModItems.EMERALD_LEGGINGS.get()).setWeight(1))
                .add(LootItem.lootTableItem(ModItems.EMERALD_BOOTS.get()).setWeight(1));
            
            event.getTable().addPool(poolBuilder.build());
        }
        
        // Village Weaponsmith - Emerald Armor
        if (tableName.equals(new ResourceLocation("minecraft", "chests/village/village_weaponsmith"))) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1))
                .add(LootItem.lootTableItem(ModItems.EMERALD_HELMET.get()).setWeight(1))
                .add(LootItem.lootTableItem(ModItems.EMERALD_CHESTPLATE.get()).setWeight(1))
                .add(LootItem.lootTableItem(ModItems.EMERALD_LEGGINGS.get()).setWeight(1))
                .add(LootItem.lootTableItem(ModItems.EMERALD_BOOTS.get()).setWeight(1));
            
            event.getTable().addPool(poolBuilder.build());
        }
        
        // Wandering Trader - Ruby Armor
        if (tableName.equals(new ResourceLocation("minecraft", "entities/wandering_trader"))) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1))
                .add(LootItem.lootTableItem(ModItems.RUBY_HELMET.get()).setWeight(1))
                .add(LootItem.lootTableItem(ModItems.RUBY_CHESTPLATE.get()).setWeight(1))
                .add(LootItem.lootTableItem(ModItems.RUBY_LEGGINGS.get()).setWeight(1))
                .add(LootItem.lootTableItem(ModItems.RUBY_BOOTS.get()).setWeight(1));
            
            event.getTable().addPool(poolBuilder.build());
        }
        
        // Broken Nether Portal - Obsidian Armor
        if (tableName.equals(new ResourceLocation("minecraft", "chests/ruined_portal"))) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1))
                .add(LootItem.lootTableItem(ModItems.OBSIDIAN_HELMET.get()).setWeight(1))
                .add(LootItem.lootTableItem(ModItems.OBSIDIAN_CHESTPLATE.get()).setWeight(1))
                .add(LootItem.lootTableItem(ModItems.OBSIDIAN_LEGGINGS.get()).setWeight(1))
                .add(LootItem.lootTableItem(ModItems.OBSIDIAN_BOOTS.get()).setWeight(1));
            
            event.getTable().addPool(poolBuilder.build());
        }
        
        // Woodland Mansion - Totem Armor
        if (tableName.equals(new ResourceLocation("minecraft", "chests/woodland_mansion"))) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1))
                .add(LootItem.lootTableItem(ModItems.TOTEM_HELMET.get()).setWeight(1))
                .add(LootItem.lootTableItem(ModItems.TOTEM_CHESTPLATE.get()).setWeight(1))
                .add(LootItem.lootTableItem(ModItems.TOTEM_LEGGINGS.get()).setWeight(1))
                .add(LootItem.lootTableItem(ModItems.TOTEM_BOOTS.get()).setWeight(1));
            
            event.getTable().addPool(poolBuilder.build());
        }
        
        // Ancient City - Sculk Armor
        if (tableName.equals(new ResourceLocation("minecraft", "chests/ancient_city"))) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1))
                .add(LootItem.lootTableItem(ModItems.SCULK_HELMET.get()).setWeight(1))
                .add(LootItem.lootTableItem(ModItems.SCULK_CHESTPLATE.get()).setWeight(1))
                .add(LootItem.lootTableItem(ModItems.SCULK_LEGGINGS.get()).setWeight(1))
                .add(LootItem.lootTableItem(ModItems.SCULK_BOOTS.get()).setWeight(1));
            
            event.getTable().addPool(poolBuilder.build());
        }
        
        // Bastion Treasure - Ancient Debris Armor
        if (tableName.equals(new ResourceLocation("minecraft", "chests/bastion_treasure"))) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1))
                .add(LootItem.lootTableItem(ModItems.ANCIENT_DEBRIS_HELMET.get()).setWeight(1))
                .add(LootItem.lootTableItem(ModItems.ANCIENT_DEBRIS_CHESTPLATE.get()).setWeight(1))
                .add(LootItem.lootTableItem(ModItems.ANCIENT_DEBRIS_LEGGINGS.get()).setWeight(1))
                .add(LootItem.lootTableItem(ModItems.ANCIENT_DEBRIS_BOOTS.get()).setWeight(1));
            
            event.getTable().addPool(poolBuilder.build());
        }
        
        // Bastion Bridge - Gilded Armor
        if (tableName.equals(new ResourceLocation("minecraft", "chests/bastion_bridge"))) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1))
                .add(LootItem.lootTableItem(ModItems.GILDED_HELMET.get()).setWeight(1))
                .add(LootItem.lootTableItem(ModItems.GILDED_CHESTPLATE.get()).setWeight(1))
                .add(LootItem.lootTableItem(ModItems.GILDED_LEGGINGS.get()).setWeight(1))
                .add(LootItem.lootTableItem(ModItems.GILDED_BOOTS.get()).setWeight(1));
            
            event.getTable().addPool(poolBuilder.build());
        }
        
        // Bastion Hoglin Stable - Gilded Armor
        if (tableName.equals(new ResourceLocation("minecraft", "chests/bastion_hoglin_stable"))) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1))
                .add(LootItem.lootTableItem(ModItems.GILDED_HELMET.get()).setWeight(1))
                .add(LootItem.lootTableItem(ModItems.GILDED_CHESTPLATE.get()).setWeight(1))
                .add(LootItem.lootTableItem(ModItems.GILDED_LEGGINGS.get()).setWeight(1))
                .add(LootItem.lootTableItem(ModItems.GILDED_BOOTS.get()).setWeight(1));
            
            event.getTable().addPool(poolBuilder.build());
        }
        
        // Bastion Other - Gilded Armor
        if (tableName.equals(new ResourceLocation("minecraft", "chests/bastion_other"))) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1))
                .add(LootItem.lootTableItem(ModItems.GILDED_HELMET.get()).setWeight(1))
                .add(LootItem.lootTableItem(ModItems.GILDED_CHESTPLATE.get()).setWeight(1))
                .add(LootItem.lootTableItem(ModItems.GILDED_LEGGINGS.get()).setWeight(1))
                .add(LootItem.lootTableItem(ModItems.GILDED_BOOTS.get()).setWeight(1));
            
            event.getTable().addPool(poolBuilder.build());
        }
        
        // Dungeon (Mob Spawner Room) - Skeleton Armor
        if (tableName.equals(new ResourceLocation("minecraft", "chests/simple_dungeon"))) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1))
                .add(LootItem.lootTableItem(ModItems.SKELETON_HELMET.get()).setWeight(1))
                .add(LootItem.lootTableItem(ModItems.SKELETON_CHESTPLATE.get()).setWeight(1))
                .add(LootItem.lootTableItem(ModItems.SKELETON_LEGGINGS.get()).setWeight(1))
                .add(LootItem.lootTableItem(ModItems.SKELETON_BOOTS.get()).setWeight(1));
            
            event.getTable().addPool(poolBuilder.build());
        }
        
        // Shipwreck Treasure - Guardian Armor
        if (tableName.equals(new ResourceLocation("minecraft", "chests/shipwreck_treasure"))) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1))
                .add(LootItem.lootTableItem(ModItems.GUARDIAN_HELMET.get()).setWeight(1))
                .add(LootItem.lootTableItem(ModItems.GUARDIAN_CHESTPLATE.get()).setWeight(1))
                .add(LootItem.lootTableItem(ModItems.GUARDIAN_LEGGINGS.get()).setWeight(1))
                .add(LootItem.lootTableItem(ModItems.GUARDIAN_BOOTS.get()).setWeight(1));
            
            event.getTable().addPool(poolBuilder.build());
        }
        
        // Underwater Ruin Big - Sniffer Armor
        if (tableName.equals(new ResourceLocation("minecraft", "chests/underwater_ruin_big"))) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1))
                .add(LootItem.lootTableItem(ModItems.SNIFFER_HELMET.get()).setWeight(3))
                .add(LootItem.lootTableItem(ModItems.SNIFFER_CHESTPLATE.get()).setWeight(3))
                .add(LootItem.lootTableItem(ModItems.SNIFFER_LEGGINGS.get()).setWeight(3))
                .add(LootItem.lootTableItem(ModItems.SNIFFER_BOOTS.get()).setWeight(3));
            
            event.getTable().addPool(poolBuilder.build());
        }
        
        // Underwater Ruin Small - Sniffer Armor
        if (tableName.equals(new ResourceLocation("minecraft", "chests/underwater_ruin_small"))) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1))
                .add(LootItem.lootTableItem(ModItems.SNIFFER_HELMET.get()).setWeight(2))
                .add(LootItem.lootTableItem(ModItems.SNIFFER_CHESTPLATE.get()).setWeight(2))
                .add(LootItem.lootTableItem(ModItems.SNIFFER_LEGGINGS.get()).setWeight(2))
                .add(LootItem.lootTableItem(ModItems.SNIFFER_BOOTS.get()).setWeight(2));
            
            event.getTable().addPool(poolBuilder.build());
        }
        
        // Desert Pyramid - Cactus Armor
        if (tableName.equals(new ResourceLocation("minecraft", "chests/desert_pyramid"))) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1))
                .add(LootItem.lootTableItem(ModItems.CACTUS_HELMET.get()).setWeight(3))
                .add(LootItem.lootTableItem(ModItems.CACTUS_CHESTPLATE.get()).setWeight(3))
                .add(LootItem.lootTableItem(ModItems.CACTUS_LEGGINGS.get()).setWeight(3))
                .add(LootItem.lootTableItem(ModItems.CACTUS_BOOTS.get()).setWeight(3));
            
            event.getTable().addPool(poolBuilder.build());
        }
        
        // Jungle Temple - RGB 
        if (tableName.equals(new ResourceLocation("minecraft", "chests/jungle_pyramid"))) {
            LootPool.Builder poolBuilder = LootPool.lootPool()
                .setRolls(ConstantValue.exactly(1))
                .add(LootItem.lootTableItem(ModItems.RGB_HELMET.get()).setWeight(2))
                .add(LootItem.lootTableItem(ModItems.RGB_CHESTPLATE.get()).setWeight(2))
                .add(LootItem.lootTableItem(ModItems.RGB_LEGGINGS.get()).setWeight(2))
                .add(LootItem.lootTableItem(ModItems.RGB_BOOTS.get()).setWeight(2));
            
            event.getTable().addPool(poolBuilder.build());
        }
        

    }
} 