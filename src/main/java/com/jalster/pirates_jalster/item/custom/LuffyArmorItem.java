package com.jalster.pirates_jalster.item.custom;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class LuffyArmorItem extends ArmorItem {
    public LuffyArmorItem(ArmorMaterial material, EquipmentSlot slot, Properties properties) {
        super(material, slot, properties);
    }

    @Override
    public void appendHoverText(ItemStack itemStack, @Nullable Level p_41422_, List<Component> componentList, TooltipFlag tooltipFlag) {
        if(Screen.hasShiftDown()){
            componentList.add(new TranslatableComponent("tooltip.pirates_jalster.strawhat.shift"));
        }
        else{
            componentList.add(new TranslatableComponent("tooltip.pirates_jalster.strawhat.noshift"));
        }
    }
}
