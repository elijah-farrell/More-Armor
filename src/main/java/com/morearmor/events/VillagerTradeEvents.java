package com.morearmor.events;

import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import com.morearmor.MoreArmor;
import com.morearmor.init.MoreArmorItems;
import java.util.List;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;

@Mod.EventBusSubscriber(modid = MoreArmor.MOD_ID)
public class VillagerTradeEvents {
    
    @SubscribeEvent
    public static void onVillagerTrades(VillagerTradesEvent event) {
        if (event.getType() == VillagerProfession.ARMORER) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            
            // Tier 4 (Apprentice) - Randomly Enchanted Emerald Helmet and Boots
            if (trades.containsKey(4)) {
                trades.get(4).add((trader, rand) -> {
                    ItemStack helmet = new ItemStack(MoreArmorItems.EMERALD_HELMET.get());
                    // Random enchantments for helmet
                    if (rand.nextFloat() < 0.7f) { // 70% chance for Protection
                        helmet.enchant(net.minecraft.world.item.enchantment.Enchantments.ALL_DAMAGE_PROTECTION, rand.nextInt(3) + 1);
                    }
                    if (rand.nextFloat() < 0.5f) { // 50% chance for Unbreaking
                        helmet.enchant(net.minecraft.world.item.enchantment.Enchantments.UNBREAKING, rand.nextInt(2) + 1);
                    }
                    if (rand.nextFloat() < 0.3f) { // 30% chance for Respiration
                        helmet.enchant(net.minecraft.world.item.enchantment.Enchantments.RESPIRATION, rand.nextInt(2) + 1);
                    }
                    if (rand.nextFloat() < 0.2f) { // 20% chance for Aqua Affinity
                        helmet.enchant(net.minecraft.world.item.enchantment.Enchantments.AQUA_AFFINITY, 1);
                    }
                    return new MerchantOffer(
                        new ItemStack(net.minecraft.world.item.Items.EMERALD, 7),
                        helmet,
                        12, 2, 0.05F
                    );
                });
                
                trades.get(4).add((trader, rand) -> {
                    ItemStack boots = new ItemStack(MoreArmorItems.EMERALD_BOOTS.get());
                    // Random enchantments for boots
                    if (rand.nextFloat() < 0.7f) { // 70% chance for Protection
                        boots.enchant(net.minecraft.world.item.enchantment.Enchantments.ALL_DAMAGE_PROTECTION, rand.nextInt(3) + 1);
                    }
                    if (rand.nextFloat() < 0.5f) { // 50% chance for Unbreaking
                        boots.enchant(net.minecraft.world.item.enchantment.Enchantments.UNBREAKING, rand.nextInt(2) + 1);
                    }
                    if (rand.nextFloat() < 0.4f) { // 40% chance for Feather Falling
                        boots.enchant(net.minecraft.world.item.enchantment.Enchantments.FALL_PROTECTION, rand.nextInt(3) + 1);
                    }
                    if (rand.nextFloat() < 0.3f) { // 30% chance for Depth Strider
                        boots.enchant(net.minecraft.world.item.enchantment.Enchantments.DEPTH_STRIDER, rand.nextInt(2) + 1);
                    }
                    return new MerchantOffer(
                        new ItemStack(net.minecraft.world.item.Items.EMERALD, 6),
                        boots,
                        12, 2, 0.05F
                    );
                });
            }
            
            // Tier 7 (Journeyman) - Randomly Enchanted Emerald Leggings
            if (trades.containsKey(7)) {
                trades.get(7).add((trader, rand) -> {
                    ItemStack leggings = new ItemStack(MoreArmorItems.EMERALD_LEGGINGS.get());
                    // Random enchantments for leggings
                    if (rand.nextFloat() < 0.7f) { // 70% chance for Protection
                        leggings.enchant(net.minecraft.world.item.enchantment.Enchantments.ALL_DAMAGE_PROTECTION, rand.nextInt(3) + 1);
                    }
                    if (rand.nextFloat() < 0.5f) { // 50% chance for Unbreaking
                        leggings.enchant(net.minecraft.world.item.enchantment.Enchantments.UNBREAKING, rand.nextInt(2) + 1);
                    }
                    if (rand.nextFloat() < 0.3f) { // 30% chance for Fire Protection
                        leggings.enchant(net.minecraft.world.item.enchantment.Enchantments.FIRE_PROTECTION, rand.nextInt(3) + 1);
                    }
                    return new MerchantOffer(
                        new ItemStack(net.minecraft.world.item.Items.EMERALD, 10),
                        leggings,
                        12, 2, 0.05F
                    );
                });
            }
            
            // Tier 9 (Master) - Randomly Enchanted Emerald Chestplate
            if (trades.containsKey(9)) {
                trades.get(9).add((trader, rand) -> {
                    ItemStack chestplate = new ItemStack(MoreArmorItems.EMERALD_CHESTPLATE.get());
                    // Random enchantments for chestplate
                    if (rand.nextFloat() < 0.7f) { // 70% chance for Protection
                        chestplate.enchant(net.minecraft.world.item.enchantment.Enchantments.ALL_DAMAGE_PROTECTION, rand.nextInt(3) + 1);
                    }
                    if (rand.nextFloat() < 0.5f) { // 50% chance for Unbreaking
                        chestplate.enchant(net.minecraft.world.item.enchantment.Enchantments.UNBREAKING, rand.nextInt(2) + 1);
                    }
                    if (rand.nextFloat() < 0.4f) { // 40% chance for Thorns
                        chestplate.enchant(net.minecraft.world.item.enchantment.Enchantments.THORNS, rand.nextInt(2) + 1);
                    }
                    return new MerchantOffer(
                        new ItemStack(net.minecraft.world.item.Items.EMERALD, 12),
                        chestplate,
                        12, 2, 0.05F
                    );
                });
            }
        }
        
        // Note: Wandering Trader trades are handled by a different system
        // We'll need to implement that separately if needed
    }
}
