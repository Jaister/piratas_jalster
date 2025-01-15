package com.jalster.pirates_jalster.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeTab {
    public static final CreativeModeTab PIRATES_TAB = new CreativeModeTab("piratestab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.StrawHat.get());
        }
    };
}
