package com.vanillaplus;

import com.vanillaplus.init.ModItems;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(VanillaPlus.MOD_ID)
public class VanillaPlus {
    public static final String MOD_ID = "vanillaplus";

    public VanillaPlus() {
        // Register items
        ModItems.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }
} 