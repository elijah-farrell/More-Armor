package com.vanillaplus.client;

import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.client.renderer.entity.ArmorStandRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "vanillaplus", value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientSetup {
    @SubscribeEvent
    public static void onEntityRendererSetup(EntityRenderersEvent.AddLayers event) {
        // Add to all player renderers
        for (String skinType : event.getSkins()) {
            PlayerRenderer renderer = event.getSkin(skinType);
            renderer.addLayer(new CustomElytraLayer<>(renderer));
        }
        // Add to armor stand renderer
        if (event.getRenderer(EntityType.ARMOR_STAND) instanceof ArmorStandRenderer armorStandRenderer) {
            armorStandRenderer.addLayer(new CustomElytraLayer<>(armorStandRenderer));
        }
    }
} 