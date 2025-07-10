package com.vanillaplus.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.vanillaplus.VanillaPlus;
import net.minecraft.client.model.ElytraModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.client.Minecraft;
import java.util.HashMap;
import java.util.Map;

public class CustomElytraLayer<T extends LivingEntity, M extends net.minecraft.client.model.EntityModel<T>> extends RenderLayer<T, M> {
    private static final Map<Item, ResourceLocation> ELYTRA_TEXTURES = new HashMap<>();
    static {
        for (var regObj : com.vanillaplus.init.ModItems.ALL_ELYTRAS) {
            var item = regObj.get();
            var id = net.minecraftforge.registries.ForgeRegistries.ITEMS.getKey(item);
            if (id != null && id.getNamespace().equals(VanillaPlus.MOD_ID)) {
                String path = id.getPath();
                boolean broken = path.startsWith("broken_");
                String base = broken ? path.substring("broken_".length(), path.length() - "_elytra".length()) : path.substring(0, path.length() - "_elytra".length());
                String tex = "textures/models/averagetateman/elytras/" + base + "/" + (broken ? "broken_" : "") + base + "_elytra.png";
                ELYTRA_TEXTURES.put(item, new ResourceLocation(VanillaPlus.MOD_ID, tex));
            }
        }
    }
    private final ElytraModel<T> elytraModel;

    public CustomElytraLayer(LivingEntityRenderer<T, M> renderer) {
        super(renderer);
        this.elytraModel = new ElytraModel<>(Minecraft.getInstance().getEntityModels().bakeLayer(ModelLayers.ELYTRA));
    }

    @Override
    public void render(PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, T entity,
                       float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        ItemStack chestItem = entity.getItemBySlot(EquipmentSlot.CHEST);
        ResourceLocation texture = ELYTRA_TEXTURES.get(chestItem.getItem());
        if (texture != null) {
            poseStack.pushPose();
            poseStack.translate(0.0D, 0.0D, 0.125D);
            getParentModel().copyPropertiesTo(this.elytraModel);
            this.elytraModel.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
            var vertexConsumer = bufferSource.getBuffer(RenderType.entityCutoutNoCull(texture));
            this.elytraModel.renderToBuffer(poseStack, vertexConsumer, packedLight, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
            poseStack.popPose();
        }
    }
} 