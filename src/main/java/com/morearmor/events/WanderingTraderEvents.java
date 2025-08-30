package com.morearmor.events;

import com.morearmor.init.Items;
import net.minecraft.world.entity.npc.WanderingTrader;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import com.morearmor.MoreArmor;

import java.util.Random;

@Mod.EventBusSubscriber(modid = MoreArmor.MOD_ID)
public class WanderingTraderEvents {
    
    @SubscribeEvent
    public static void onWanderingTraderSpawn(EntityJoinLevelEvent event) {
        if (event.getEntity() instanceof WanderingTrader trader) {
            // Add ruby armor trades to the wandering trader
            addRubyArmorTrades(trader);
        }
    }
    
    private static void addRubyArmorTrades(WanderingTrader trader) {
        Random rand = new Random();
        
        // Ruby Helmet - 80% chance for enchantments, 20% chance for no enchantments
        ItemStack helmet = new ItemStack(Items.RUBY_HELMET.get());
        if (rand.nextFloat() < 0.8f) {
            if (rand.nextFloat() < 0.7f) { // 70% chance for Protection
                helmet.enchant(net.minecraft.world.item.enchantment.Enchantments.ALL_DAMAGE_PROTECTION, rand.nextInt(3) + 1);
            }
            if (rand.nextFloat() < 0.6f) { // 60% chance for Unbreaking
                helmet.enchant(net.minecraft.world.item.enchantment.Enchantments.UNBREAKING, rand.nextInt(2) + 1);
            }
            if (rand.nextFloat() < 0.4f) { // 40% chance for Respiration
                helmet.enchant(net.minecraft.world.item.enchantment.Enchantments.RESPIRATION, rand.nextInt(2) + 1);
            }
            if (rand.nextFloat() < 0.3f) { // 30% chance for Aqua Affinity
                helmet.enchant(net.minecraft.world.item.enchantment.Enchantments.AQUA_AFFINITY, 1);
            }
        }
        
        // Ruby Chestplate - 80% chance for enchantments, 20% chance for no enchantments
        ItemStack chestplate = new ItemStack(Items.RUBY_CHESTPLATE.get());
        if (rand.nextFloat() < 0.8f) {
            if (rand.nextFloat() < 0.7f) { // 70% chance for Protection
                chestplate.enchant(net.minecraft.world.item.enchantment.Enchantments.ALL_DAMAGE_PROTECTION, rand.nextInt(3) + 1);
            }
            if (rand.nextFloat() < 0.6f) { // 60% chance for Unbreaking
                chestplate.enchant(net.minecraft.world.item.enchantment.Enchantments.UNBREAKING, rand.nextInt(2) + 1);
            }
            if (rand.nextFloat() < 0.5f) { // 50% chance for Thorns
                chestplate.enchant(net.minecraft.world.item.enchantment.Enchantments.THORNS, rand.nextInt(2) + 1);
            }
        }
        
        // Ruby Leggings - 80% chance for enchantments, 20% chance for no enchantments
        ItemStack leggings = new ItemStack(Items.RUBY_LEGGINGS.get());
        if (rand.nextFloat() < 0.8f) {
            if (rand.nextFloat() < 0.7f) { // 70% chance for Protection
                leggings.enchant(net.minecraft.world.item.enchantment.Enchantments.ALL_DAMAGE_PROTECTION, rand.nextInt(3) + 1);
            }
            if (rand.nextFloat() < 0.6f) { // 60% chance for Unbreaking
                leggings.enchant(net.minecraft.world.item.enchantment.Enchantments.UNBREAKING, rand.nextInt(2) + 1);
            }
            if (rand.nextFloat() < 0.4f) { // 40% chance for Fire Protection
                leggings.enchant(net.minecraft.world.item.enchantment.Enchantments.FIRE_PROTECTION, rand.nextInt(3) + 1);
            }
        }
        
        // Ruby Boots - 80% chance for enchantments, 20% chance for no enchantments
        ItemStack boots = new ItemStack(Items.RUBY_BOOTS.get());
        if (rand.nextFloat() < 0.8f) {
            if (rand.nextFloat() < 0.7f) { // 70% chance for Protection
                boots.enchant(net.minecraft.world.item.enchantment.Enchantments.ALL_DAMAGE_PROTECTION, rand.nextInt(3) + 1);
            }
            if (rand.nextFloat() < 0.6f) { // 60% chance for Unbreaking
                boots.enchant(net.minecraft.world.item.enchantment.Enchantments.UNBREAKING, rand.nextInt(2) + 1);
            }
            if (rand.nextFloat() < 0.5f) { // 50% chance for Feather Falling
                boots.enchant(net.minecraft.world.item.enchantment.Enchantments.FALL_PROTECTION, rand.nextInt(3) + 1);
            }
            if (rand.nextFloat() < 0.4f) { // 40% chance for Depth Strider
                boots.enchant(net.minecraft.world.item.enchantment.Enchantments.DEPTH_STRIDER, rand.nextInt(2) + 1);
            }
        }
        
        // Add all trades to the wandering trader
        trader.getOffers().add(new MerchantOffer(
            new ItemStack(net.minecraft.world.item.Items.EMERALD, 12),
            helmet,
            8, 2, 0.05F
        ));
        
        trader.getOffers().add(new MerchantOffer(
            new ItemStack(net.minecraft.world.item.Items.EMERALD, 16),
            chestplate,
            8, 2, 0.05F
        ));
        
        trader.getOffers().add(new MerchantOffer(
            new ItemStack(net.minecraft.world.item.Items.EMERALD, 14),
            leggings,
            8, 2, 0.05F
        ));
        
        trader.getOffers().add(new MerchantOffer(
            new ItemStack(net.minecraft.world.item.Items.EMERALD, 10),
            boots,
            8, 2, 0.05F
        ));
    }
}
