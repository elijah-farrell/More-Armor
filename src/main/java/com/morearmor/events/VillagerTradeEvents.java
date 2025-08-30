package com.morearmor.events;

import com.morearmor.init.Items;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import com.morearmor.MoreArmor;

import java.util.List;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;

@Mod.EventBusSubscriber(modid = MoreArmor.MOD_ID)
public class VillagerTradeEvents {
    
    @SubscribeEvent
    public static void onVillagerTrades(VillagerTradesEvent event) {
        if (event.getType() == VillagerProfession.ARMORER) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            
            // Tier 4 (Apprentice) - Enchanted Emerald Helmet and Boots
            if (trades.containsKey(4)) {
                trades.get(4).add((trader, rand) -> {
                    ItemStack helmet = new ItemStack(com.morearmor.init.Items.EMERALD_HELMET.get());
                    helmet.enchant(net.minecraft.world.item.enchantment.Enchantments.ALL_DAMAGE_PROTECTION, 3);
                    helmet.enchant(net.minecraft.world.item.enchantment.Enchantments.UNBREAKING, 2);
                    return new MerchantOffer(
                        new ItemStack(net.minecraft.world.item.Items.EMERALD, 7),
                        helmet,
                        12, 2, 0.05F
                    );
                });
                
                trades.get(4).add((trader, rand) -> {
                    ItemStack boots = new ItemStack(com.morearmor.init.Items.EMERALD_BOOTS.get());
                    boots.enchant(net.minecraft.world.item.enchantment.Enchantments.ALL_DAMAGE_PROTECTION, 3);
                    boots.enchant(net.minecraft.world.item.enchantment.Enchantments.UNBREAKING, 2);
                    boots.enchant(net.minecraft.world.item.enchantment.Enchantments.FALL_PROTECTION, 3);
                    return new MerchantOffer(
                        new ItemStack(net.minecraft.world.item.Items.EMERALD, 6),
                        boots,
                        12, 2, 0.05F
                    );
                });
            }
            
            // Tier 7 (Journeyman) - Enchanted Emerald Leggings
            if (trades.containsKey(7)) {
                trades.get(7).add((trader, rand) -> {
                    ItemStack leggings = new ItemStack(com.morearmor.init.Items.EMERALD_LEGGINGS.get());
                    leggings.enchant(net.minecraft.world.item.enchantment.Enchantments.ALL_DAMAGE_PROTECTION, 3);
                    leggings.enchant(net.minecraft.world.item.enchantment.Enchantments.UNBREAKING, 2);
                    return new MerchantOffer(
                        new ItemStack(net.minecraft.world.item.Items.EMERALD, 10),
                        leggings,
                        12, 2, 0.05F
                    );
                });
            }
            
            // Tier 9 (Master) - Enchanted Emerald Chestplate
            if (trades.containsKey(9)) {
                trades.get(9).add((trader, rand) -> {
                    ItemStack chestplate = new ItemStack(com.morearmor.init.Items.EMERALD_CHESTPLATE.get());
                    chestplate.enchant(net.minecraft.world.item.enchantment.Enchantments.ALL_DAMAGE_PROTECTION, 3);
                    chestplate.enchant(net.minecraft.world.item.enchantment.Enchantments.UNBREAKING, 2);
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
