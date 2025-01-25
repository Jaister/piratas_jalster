package com.jalster.pirates_jalster.item.util;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;

import static com.jalster.pirates_jalster.PiratesJalster.MOD_ID;


public class ModTags {
    public static class Blocks{
        public static final TagKey<Block> OCEAN_STONE_VALUABLES = tag ("ocean_stone_valuables");

        private static TagKey<Block> tag(String name){
            return BlockTags.create(new ResourceLocation(MOD_ID,name));
        }
        private static TagKey<Block> forgeTag(String name){
            return BlockTags.create(new ResourceLocation("forge",name));
        }
    }
    public static class Items{
        public static final TagKey<Item> POWERUP_ARMOR = tag ("powerup_armor");

        private static TagKey<Item> tag(String name){
            return ItemTags.create(new ResourceLocation(MOD_ID,name));
        }
        private static TagKey<Item> forgeTag(String name){
            return ItemTags.create(new ResourceLocation("forge",name));
        }
    }
    public static boolean isPowerupArmor(ItemStack itemStack) {
        return Registry.ITEM.getResourceKey(itemStack.getItem())
                .flatMap(resourceKey -> Registry.ITEM.getHolder(resourceKey))
                .map(holder -> holder.is(ModTags.Items.POWERUP_ARMOR))
                .orElse(false);
    }
}
