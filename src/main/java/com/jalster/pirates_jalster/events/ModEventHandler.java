package com.jalster.pirates_jalster.events;

import com.jalster.pirates_jalster.item.ModItems;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = "pirates_jalster", bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModEventHandler {
    @SubscribeEvent
    public static void onArmorEquipped(LivingEquipmentChangeEvent event) {
        if (event.getEntity() instanceof Player player) {
            // Check if the slot is the HEAD slot
            if (event.getSlot() == EquipmentSlot.HEAD) {
                ItemStack newArmor = event.getTo();
                ItemStack oldArmor = event.getFrom();

                // Check if the new item is the StrawHat
                if (newArmor.getItem() == ModItems.StrawHat.get()) {
                    player.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, Integer.MAX_VALUE, 1, false, false));
                    player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, Integer.MAX_VALUE, 1, false, false));
                }

                // Remove effects if the StrawHat is unequipped
                if (oldArmor.getItem() == ModItems.StrawHat.get()) {
                    player.removeEffect(MobEffects.MOVEMENT_SPEED);
                    player.removeEffect(MobEffects.DAMAGE_BOOST);
                }
            }
        }
    }
}
