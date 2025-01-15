package com.jalster.pirates_jalster.item.custom;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class EnergySteroidItem extends Item {

    public static final FoodProperties ENERGY_STEROID_FOOD = new FoodProperties.Builder()
            .nutrition(0) // Amount of hunger restored
            .saturationMod(0f) // Saturation modifier
            .alwaysEat() // Makes the item always edible
            .effect(() -> new net.minecraft.world.effect.MobEffectInstance(
                    net.minecraft.world.effect.MobEffects.MOVEMENT_SPEED, 1200, 3), 1.0f) // Effect with 100% chance
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST,1200,3), 1f)
            .build();

    public EnergySteroidItem(Properties properties) {
        super(properties.food(ENERGY_STEROID_FOOD)); // Add the food properties to the item
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
        if (!level.isClientSide && entity instanceof ServerPlayer player) {
            // Deal 7 hearts (14 damage) of magic damage to the player
            if (player.getHealth() < 6F){
                player.die(DamageSource.MAGIC);
            }
            else {
                player.setHealth(6F);
                player.hurt(DamageSource.MAGIC, 2.0F); // Using DamageSource.MAGIC instead of damageSources()
            }
        }
        return super.finishUsingItem(stack, level, entity);
    }

}
