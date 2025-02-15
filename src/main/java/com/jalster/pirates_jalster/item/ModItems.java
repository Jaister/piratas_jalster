package com.jalster.pirates_jalster.item;

import com.jalster.pirates_jalster.PiratesJalster;
import com.jalster.pirates_jalster.item.custom.EnergySteroidItem;
import com.jalster.pirates_jalster.item.custom.LuffyArmorItem;
import com.jalster.pirates_jalster.item.custom.ZoroSwordItem;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SwordItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, PiratesJalster.MOD_ID);

    //ITEMS LIST
    public static final RegistryObject<Item> StrawHat = ITEMS.register("strawhat",
            () -> new LuffyArmorItem(ModArmorMaterials.MUGIWARA, EquipmentSlot.HEAD,new Item.Properties().tab(ModCreativeTab.PIRATES_TAB)));
    public static final RegistryObject<Item> OceanShard = ITEMS.register("ocean_shard",
            () -> new Item( new Item.Properties().tab(ModCreativeTab.PIRATES_TAB)));
    public static final RegistryObject<Item> EnergySteroid = ITEMS.register("energy_steroid",
            () -> new EnergySteroidItem( new Item.Properties().tab(ModCreativeTab.PIRATES_TAB)));

    public static final RegistryObject<Item> ZoroSword = ITEMS.register("zoro_sword",
            () -> new ZoroSwordItem(ModTiers.Mugiwara, 3, 2.4F, new Item.Properties().tab(ModCreativeTab.PIRATES_TAB)));
    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
