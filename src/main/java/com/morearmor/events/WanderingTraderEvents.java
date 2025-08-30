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
        
        // Only 30% chance that this wandering trader will have ruby armor at all
        if (rand.nextFloat() > 0.3f) {
            return;
        }
        
        // Randomly choose only ONE ruby armor piece to offer
        int pieceChoice = rand.nextInt(4);
        ItemStack rubyArmor;
        
        switch (pieceChoice) {
            case 0: // Helmet
                rubyArmor = new ItemStack(Items.RUBY_HELMET.get());
                break;
            case 1: // Chestplate
                rubyArmor = new ItemStack(Items.RUBY_CHESTPLATE.get());
                break;
            case 2: // Leggings
                rubyArmor = new ItemStack(Items.RUBY_LEGGINGS.get());
                break;
            case 3: // Boots
                rubyArmor = new ItemStack(Items.RUBY_BOOTS.get());
                break;
            default:
                rubyArmor = new ItemStack(Items.RUBY_HELMET.get());
                break;
        }
        
        // 80% chance to get enchantments, 20% chance for no enchantments
        if (rand.nextFloat() < 0.8f) {
            if (rand.nextFloat() < 0.7f) { // 70% chance for Protection
                rubyArmor.enchant(net.minecraft.world.item.enchantment.Enchantments.ALL_DAMAGE_PROTECTION, rand.nextInt(3) + 1);
            }
            if (rand.nextFloat() < 0.6f) { // 60% chance for Unbreaking
                rubyArmor.enchant(net.minecraft.world.item.enchantment.Enchantments.UNBREAKING, rand.nextInt(2) + 1);
            }
            
            // Add piece-specific enchantments
            if (pieceChoice == 0) { // Helmet
                if (rand.nextFloat() < 0.4f) { // 40% chance for Respiration
                    rubyArmor.enchant(net.minecraft.world.item.enchantment.Enchantments.RESPIRATION, rand.nextInt(2) + 1);
                }
                if (rand.nextFloat() < 0.3f) { // 30% chance for Aqua Affinity
                    rubyArmor.enchant(net.minecraft.world.item.enchantment.Enchantments.AQUA_AFFINITY, 1);
                }
            } else if (pieceChoice == 1) { // Chestplate
                if (rand.nextFloat() < 0.5f) { // 50% chance for Thorns
                    rubyArmor.enchant(net.minecraft.world.item.enchantment.Enchantments.THORNS, rand.nextInt(2) + 1);
                }
            } else if (pieceChoice == 2) { // Leggings
                if (rand.nextFloat() < 0.4f) { // 40% chance for Fire Protection
                    rubyArmor.enchant(net.minecraft.world.item.enchantment.Enchantments.FIRE_PROTECTION, rand.nextInt(3) + 1);
                }
            } else if (pieceChoice == 3) { // Boots
                if (rand.nextFloat() < 0.5f) { // 50% chance for Feather Falling
                    rubyArmor.enchant(net.minecraft.world.item.enchantment.Enchantments.FALL_PROTECTION, rand.nextInt(3) + 1);
                }
                if (rand.nextFloat() < 0.4f) { // 40% chance for Depth Strider
                    rubyArmor.enchant(net.minecraft.world.item.enchantment.Enchantments.DEPTH_STRIDER, rand.nextInt(2) + 1);
                }
            }
        }
        
        // Add the single ruby armor piece to the wandering trader
        trader.getOffers().add(new MerchantOffer(
            new ItemStack(net.minecraft.world.item.Items.EMERALD, 10 + rand.nextInt(7)), // Random price 10-16 emeralds
            rubyArmor,
            3, 1, 0.05F // Only 3 uses, 1 max uses, low price multiplier
        ));
    }
}
