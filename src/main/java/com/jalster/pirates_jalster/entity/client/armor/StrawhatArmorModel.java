package com.jalster.pirates_jalster.entity.client.armor;

import com.jalster.pirates_jalster.PiratesJalster;
import com.jalster.pirates_jalster.item.custom.LuffyArmorItem;
import net.minecraft.resources.ResourceLocation;
import software.bernie.example.client.model.armor.GeckoArmorModel;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class StrawhatArmorModel extends AnimatedGeoModel<LuffyArmorItem> {

    @Override
    public ResourceLocation getModelLocation(LuffyArmorItem luffyArmorItem) {
        return new ResourceLocation(PiratesJalster.MOD_ID,"geo/strawhat.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(LuffyArmorItem luffyArmorItem) {
        return new ResourceLocation(PiratesJalster.MOD_ID,"textures/models/armor/strawhat_texture.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(LuffyArmorItem luffyArmorItem) {
        return new ResourceLocation(PiratesJalster.MOD_ID,"animations/strawhat_animation.json");
    }
}
