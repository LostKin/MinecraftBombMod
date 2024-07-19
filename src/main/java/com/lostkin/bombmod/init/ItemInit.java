package com.lostkin.bombmod.init;

import com.google.common.base.Supplier;
import com.lostkin.bombmod.BombMod;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, BombMod.MOD_ID);

    public static final RegistryObject<Item> EXAMPLE_ITEM = register("example_item",
            () -> new Item(new Item.Properties()
                    .tab(BombMod.BOMBMOD_TAB)));

    private static<T extends Item>RegistryObject register(final String name, final Supplier<T> item) {
        return ITEMS.register(name, item);
    }
}
