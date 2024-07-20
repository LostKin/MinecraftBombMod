package com.lostkin.bombmod.init;

import com.google.common.base.Function;
import com.google.common.base.Supplier;
import com.lostkin.bombmod.BombMod;
import com.lostkin.bombmod.blocks.BombBlock;
import com.lostkin.bombmod.blocks.ExampleBlock;
import com.lostkin.bombmod.blocks.HardpointBlock;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BlockInit {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, BombMod.MOD_ID);

    public static final DeferredRegister<Item> ITEMS = ItemInit.ITEMS;

    public static final RegistryObject<Block> EXAMPLE_BLOCK = register("example_block",
            () -> new ExampleBlock(BlockBehaviour.Properties
                    .of(Material.METAL, MaterialColor.COLOR_PURPLE)
                    .strength(2)
                    .sound(SoundType.METAL)
                    .requiresCorrectToolForDrops()
            ),
            object -> () -> new BlockItem(object.get(),new Item.Properties().tab(BombMod.BOMBMOD_TAB)));


    public static final RegistryObject<Block> HARDPOINT_BLOCK = register("hardpoint_block",
            () -> new HardpointBlock(BlockBehaviour.Properties
                    .of(Material.METAL)
                    .dynamicShape()
                    .sound(SoundType.METAL)
            ),
            object -> () -> new BlockItem(object.get(), new Item.Properties().tab(BombMod.BOMBMOD_TAB)));

    public static final RegistryObject<Block> BOMB_BLOCK_1 = register("bomb_block_1",
            () -> new BombBlock(BlockBehaviour.Properties
                    .of(Material.METAL)
                    .dynamicShape()
                    .sound(SoundType.METAL)
            ),
            object -> () -> new BlockItem(object.get(), new Item.Properties().tab(BombMod.BOMBMOD_TAB)));


    private static<T extends Block> RegistryObject<T> registerBlock(final String name, final Supplier<? extends T> block) {
        return BLOCKS.register(name, block);
    }

    private static<T extends Block> RegistryObject<T> register(final String name, final Supplier<? extends T> block,
       Function<RegistryObject<T>, Supplier<? extends Item>> item) {
        RegistryObject<T> obj = registerBlock(name, block);
        ITEMS.register(name, item.apply(obj));
        return obj;
    }

}
