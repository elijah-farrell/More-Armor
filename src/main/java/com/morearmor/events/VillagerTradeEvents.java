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
            
            // Tier 4 (Apprentice) - Emerald Helmet and Boots
            trades.get(4).add((trader, rand) -> new MerchantOffer(
                new ItemStack(net.minecraft.world.item.Items.EMERALD, 7),
                new ItemStack(com.morearmor.init.Items.EMERALD_HELMET.get()),
                12, 2, 0.05F
            ));
            
            trades.get(4).add((trader, rand) -> new MerchantOffer(
                new ItemStack(net.minecraft.world.item.Items.EMERALD, 6),
                new ItemStack(com.morearmor.init.Items.EMERALD_BOOTS.get()),
                12, 2, 0.05F
            ));
            
            // Tier 7 (Journeyman) - Emerald Leggings
            trades.get(7).add((trader, rand) -> new MerchantOffer(
                new ItemStack(net.minecraft.world.item.Items.EMERALD, 10),
                new ItemStack(com.morearmor.init.Items.EMERALD_LEGGINGS.get()),
                12, 2, 0.05F
            ));
            
            // Tier 9 (Master) - Emerald Chestplate
            trades.get(9).add((trader, rand) -> new MerchantOffer(
                new ItemStack(net.minecraft.world.item.Items.EMERALD, 12),
                new ItemStack(com.morearmor.init.Items.EMERALD_CHESTPLATE.get()),
                12, 2, 0.05F
            ));
        }
        
        // Note: Wandering Trader trades are handled by a different system
        // We'll need to implement that separately if needed
    }
}
