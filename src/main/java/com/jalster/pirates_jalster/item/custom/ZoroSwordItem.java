package com.jalster.pirates_jalster.item.custom;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.WitherSkull;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class ZoroSwordItem extends SwordItem {
    public ZoroSwordItem(Tier p_43269_, int p_43270_, float p_43271_, Properties p_43272_) {
        super(p_43269_, p_43270_, p_43271_, p_43272_);

    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);

        if (!level.isClientSide) {
            // Spawn particles
            for (int i = 0; i < 20; i++) {
                Vec3 offset = new Vec3(
                        (level.random.nextDouble() - 0.5) * 2,
                        (level.random.nextDouble() - 0.5) * 2,
                        (level.random.nextDouble() - 0.5) * 2
                );
                ((ServerLevel) level).sendParticles(
                        net.minecraft.core.particles.ParticleTypes.SWEEP_ATTACK,
                        player.getX() + offset.x,
                        player.getY() + player.getEyeHeight() + offset.y,
                        player.getZ() + offset.z,
                        1, 0, 0, 0, 0
                );
            }

            // Spawn the custom Wither Skull
            WitherSkull skull = new WitherSkull(level, player, 0, 0, 0);
            Vec3 look = player.getLookAngle();
            skull.setDeltaMovement(look.scale(1.5));
            skull.setPos(player.getX(), player.getEyeY(), player.getZ());
            ((ServerLevel) level).addFreshEntity(skull);
            // Play sound
            player.playSound(SoundEvents.WITHER_SHOOT, 1.0F, 1.0F);

            // Cooldown
            player.getCooldowns().addCooldown(this, 80);
        }

        return InteractionResultHolder.sidedSuccess(itemStack, level.isClientSide);
    }

}
