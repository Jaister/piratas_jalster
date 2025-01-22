package com.jalster.pirates_jalster.item;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ModTiers {
    public static final ForgeTier Mugiwara = new ForgeTier(3, 1000, 10.0F, 6.0F, 10, BlockTags.NEEDS_IRON_TOOL,
            () -> Ingredient.of(ModItems.OceanShard.get()));
}
