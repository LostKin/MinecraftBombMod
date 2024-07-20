package com.lostkin.bombmod.events;

import com.lostkin.bombmod.BombMod;
import com.lostkin.bombmod.entities.BombEntity_1;
import com.lostkin.bombmod.init.EntityInit;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
@Mod.EventBusSubscriber(modid= BombMod.MOD_ID, bus=Bus.MOD)
public class CommonModEvents {

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(EntityInit.BOMB_1.get(), BombEntity_1.createLivingAttributes().build());
    }

}
