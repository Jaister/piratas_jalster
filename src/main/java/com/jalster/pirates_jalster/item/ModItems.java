package com.jalster.pirates_jalster.item;

import com.jalster.pirates_jalster.PiratesJalster;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, PiratesJalster.MOD_ID);

    //ITEMS LIST
    public static final RegistryObject<Item> StrawHat = ITEMS.register("strawhat",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
