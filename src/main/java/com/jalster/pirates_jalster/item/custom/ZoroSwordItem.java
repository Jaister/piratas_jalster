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
            // Spawn sword slash particles (sweep effect)
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

            Vec3 look = player.getLookAngle();

            // Spawn multiple slashes to resemble Zoro's techniques
            for (int i = -1; i <= 1; i++) {
                double angleOffset = i * 0.3; // Offset for multi-directional slashes
                Vec3 adjustedLook = new Vec3(
                        look.x * Math.cos(angleOffset) - look.z * Math.sin(angleOffset),
                        look.y,
                        look.x * Math.sin(angleOffset) + look.z * Math.cos(angleOffset)
                ).normalize();

                // Custom Slash Entity or small Fireball
                net.minecraft.world.entity.projectile.SmallFireball slash = new net.minecraft.world.entity.projectile.SmallFireball(
                        level,
                        player,
                        adjustedLook.x,
                        adjustedLook.y,
                        adjustedLook.z
                );
                slash.setDeltaMovement(adjustedLook.scale(1.5));
                slash.setPos(player.getX(), player.getEyeY(), player.getZ());
                ((ServerLevel) level).addFreshEntity(slash);
            }

            // Delay for a larger attack
            level.getServer().execute(() -> {
                net.minecraft.world.entity.projectile.LargeFireball fireball = new net.minecraft.world.entity.projectile.LargeFireball(
                        level,
                        player,
                        look.x,
                        look.y,
                        look.z,
                        3
                );
                fireball.setDeltaMovement(look.scale(2.0));
                fireball.setPos(player.getX() + look.x * 3, player.getEyeY() + look.y * 3, player.getZ() + look.z * 3);
                ((ServerLevel) level).addFreshEntity(fireball);
            });

            // Play sword slash sound
            level.playSound(
                    null, // Null means all players near the position can hear it
                    player.getX(),
                    player.getY(),
                    player.getZ(),
                    SoundEvents.PLAYER_ATTACK_SWEEP, // Sound event
                    net.minecraft.sounds.SoundSource.PLAYERS, // Sound category
                    1.0F, // Volume
                    1.0F // Pitch
            );

            // Cooldown
            player.getCooldowns().addCooldown(this, 80);
        }


        return InteractionResultHolder.sidedSuccess(itemStack, level.isClientSide);
    }


}
