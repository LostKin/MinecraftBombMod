package com.lostkin.bombmod.client.renderer;

import com.lostkin.bombmod.BombMod;
import com.lostkin.bombmod.client.renderer.models.BombEntity_1_Model;
import com.lostkin.bombmod.entities.BombEntity_1;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.resources.ResourceLocation;


public class BombEntity_1_Renderer<Type extends BombEntity_1> extends LivingEntityRenderer<Type, BombEntity_1_Model<Type>> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(BombMod.MOD_ID, "textures/entity/bomb_entity_1.png");

    public BombEntity_1_Renderer(EntityRendererProvider.Context context) {
        super(context, new BombEntity_1_Model<>(context.bakeLayer(BombEntity_1_Model.LAYER_LOCATION)), 1f);
    }

    @Override
    public ResourceLocation getTextureLocation(BombEntity_1 bombEntity1) {
        return TEXTURE;
    }
}
