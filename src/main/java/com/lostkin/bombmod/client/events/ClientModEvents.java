package com.lostkin.bombmod.client.events;


import com.lostkin.bombmod.BombMod;
import com.lostkin.bombmod.client.renderer.BombEntity_1_Renderer;
import com.lostkin.bombmod.client.renderer.models.BombEntity_1_Model;
import com.lostkin.bombmod.init.EntityInit;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid= BombMod.MOD_ID, bus= Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientModEvents {

    @SubscribeEvent
    public static void clientSetup(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(BombEntity_1_Model.LAYER_LOCATION, BombEntity_1_Model::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(EntityInit.BOMB_1.get(), BombEntity_1_Renderer::new);
    }

}
