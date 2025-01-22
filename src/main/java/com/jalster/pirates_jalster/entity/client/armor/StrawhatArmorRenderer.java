package com.jalster.pirates_jalster.entity.client.armor;

import com.jalster.pirates_jalster.item.custom.LuffyArmorItem;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

public class StrawhatArmorRenderer extends GeoArmorRenderer<LuffyArmorItem> {

    public StrawhatArmorRenderer() {
        super(new StrawhatArmorModel());
        this.headBone = "armorHead";
        this.bodyBone = "armorBody";
        this.rightArmBone = "armorRightArm";
        this.leftArmBone = "armorLeftArm";
        this.rightLegBone = "armorRightLeg";
        this.leftLegBone = "armorLeftLeg";
        this.rightBootBone = "armorRightBoot";
        this.leftBootBone = "armorLeftBoot";

    }
}
