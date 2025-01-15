package com.jalster.pirates_jalster.events;

import com.jalster.pirates_jalster.item.ModItems;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "pirates_jalster", bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModEventHandler {

    @SubscribeEvent
    public static void onArmorEquipped(LivingEquipmentChangeEvent event) {
        if (event.getEntity() instanceof Player player) {
            ItemStack newArmor = event.getTo();
            ItemStack oldArmor = event.getFrom();

            // Check if the new armor is your custom item
            if (newArmor.getItem() == ModItems.StrawHat.get()) {
                player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, Integer.MAX_VALUE, 0, false, false));
            }

            // Remove effect when unequipping
            if (oldArmor.getItem() == ModItems.StrawHat.get()) {
                player.removeEffect(MobEffects.MOVEMENT_SPEED);
            }
        }
    }
}
