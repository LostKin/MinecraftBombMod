package com.lostkin.bombmod.init;

import com.google.common.base.Supplier;
import com.lostkin.bombmod.BombMod;
import com.lostkin.bombmod.entities.BombEntity_1;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EntityInit {

    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES,
            BombMod.MOD_ID);

    public static final RegistryObject<EntityType<BombEntity_1>> BOMB_1 = register("bomb_1",
            () -> EntityType.Builder
                    .of(BombEntity_1::new, MobCategory.MISC)
                    .sized(1, 1)
                    .build(
                    new ResourceLocation(BombMod.MOD_ID, "bomb_1").toString()
                    )
            );

    private static<T extends EntityType<?>>RegistryObject register(final String name, final Supplier<T> entity) {
        return ENTITIES.register(name, entity);
    }

}
