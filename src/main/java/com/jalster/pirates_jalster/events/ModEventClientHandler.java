package com.jalster.pirates_jalster.events;

import com.jalster.pirates_jalster.entity.client.armor.StrawhatArmorRenderer;
import com.jalster.pirates_jalster.item.custom.LuffyArmorItem;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import software.bernie.geckolib3.renderers.geo.GeoArmorRenderer;

@Mod.EventBusSubscriber(modid = "pirates_jalster", bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEventClientHandler {
    @SubscribeEvent
    public static void registerArmorRenderers(final EntityRenderersEvent.AddLayers event) {
        // Register the renderer for the StrawHat
        GeoArmorRenderer.registerArmorRenderer(LuffyArmorItem.class, new StrawhatArmorRenderer());
    }
}
