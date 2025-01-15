package com.jalster.pirates_jalster.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.server.level.ServerPlayer;


public class OceanStoneBlock extends Block {
    public OceanStoneBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void stepOn(Level p_152431_, BlockPos p_152432_, BlockState p_152433_, Entity p_152434_) {
        if (!p_152431_.isClientSide && p_152434_ instanceof ServerPlayer player) {
            // Deal 7 hearts (14 damage) of magic damage to the player
            Iterable<ItemStack> armor = player.getArmorSlots();
            for (ItemStack itemStack : armor) {
                if (!itemStack.isEmpty()) { // Check if the armor slot is not empty
                    // Use a custom tag to track if effects have been applied
                    if (!player.getPersistentData().getBoolean("effectsApplied")) {
                        player.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 360, 3));
                        player.addEffect(new MobEffectInstance(MobEffects.CONFUSION, 360, 3));
                        player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 360, 0));
                        player.addEffect(new MobEffectInstance(MobEffects.DIG_SLOWDOWN, 360, 1));

                        // Set the tag to true to indicate effects are applied
                        player.getPersistentData().putBoolean("effectsApplied", true);
                    }
                } else {
                    // If no armor, reset the tag
                    player.getPersistentData().remove("effectsApplied");
                }
            }


        }
        super.stepOn(p_152431_, p_152432_, p_152433_, p_152434_);
    }
}
