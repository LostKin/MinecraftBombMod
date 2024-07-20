package com.lostkin.bombmod.client.renderer.models;

import com.lostkin.bombmod.BombMod;
import com.lostkin.bombmod.entities.BombEntity_1;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;

public class BombEntity_1_Model<Type extends BombEntity_1> extends EntityModel<Type> {
    // This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(BombMod.MOD_ID, "bomb_entity_1"), "main");
    private final ModelPart group;

    public BombEntity_1_Model(ModelPart group) {
        this.group = group.getChild("group");
    }


    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();

        PartDefinition group = partdefinition.addOrReplaceChild("group", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -2.0F, -6.3977F, 4.0F, 4.0F, 10.0F, new CubeDeformation(0.0F))
                .texOffs(0, 0).addBox(-1.5F, -1.5F, -7.3977F, 3.0F, 3.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(19, 0).addBox(-1.0F, -1.0F, -8.3977F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F))
                .texOffs(24, 5).addBox(-0.5F, -0.5F, -8.8977F, 1.0F, 1.0F, 0.5F, new CubeDeformation(0.0F))
                .texOffs(27, 16).addBox(-0.25F, -0.25F, -9.1477F, 0.5F, 0.5F, 0.25F, new CubeDeformation(0.0F))
                .texOffs(22, 27).addBox(-1.5F, -1.5F, 3.6023F, 3.0F, 3.0F, 2.0F, new CubeDeformation(0.0F))
                .texOffs(24, 23).addBox(-1.0F, -1.0F, 5.3523F, 2.0F, 2.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 18.0F, 0.6477F));

        PartDefinition cube_r1 = group.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 27).addBox(0.0F, -1.0F, 0.0F, 0.0F, 2.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, 2.0F, 4.3523F, 0.0F, 0.0F, 0.7854F));

        PartDefinition cube_r2 = group.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(-3, 26).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, -2.0F, 4.3523F, 0.0F, 0.0F, -0.7854F));

        PartDefinition cube_r3 = group.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(-3, 22).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-2.0F, -2.0F, 4.3523F, 0.0F, 0.0F, 0.7854F));

        PartDefinition cube_r4 = group.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(2, 25).addBox(-1.0F, 0.0F, 0.0F, 2.0F, 0.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.0F, 2.0F, 4.3523F, 0.0F, 0.0F, 0.7854F));

        return LayerDefinition.create(meshdefinition, 32, 32);
    }

    @Override
    public void setupAnim(Type entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

    }

    @Override
    public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
        group.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
    }
}