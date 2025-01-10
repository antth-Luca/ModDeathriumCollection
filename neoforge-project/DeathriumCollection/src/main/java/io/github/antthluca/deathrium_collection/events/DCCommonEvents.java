package io.github.antthluca.deathrium_collection.events;

import io.github.antthluca.deathrium_collection.DeathriumCollection;
import io.github.antthluca.deathrium_collection.utils.ArmorVerification;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityInvulnerabilityCheckEvent;
import net.neoforged.neoforge.event.entity.EntityTeleportEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

@EventBusSubscriber(modid = DeathriumCollection.MODID)
public class DCCommonEvents {
    @SubscribeEvent
    public static void playerTick(PlayerTickEvent.Post event) {
        Player player = event.getEntity();
        if (!player.level().isClientSide() && ArmorVerification.hasFullArmor(player)) {
            // Remover fogo
            if (player.isOnFire() ) player.clearFire();
        }
    }

    @SubscribeEvent
    public static void onInvulnerabilityChecked(EntityInvulnerabilityCheckEvent event) {
        if (event.getEntity() instanceof ServerPlayer player && ArmorVerification.hasFullArmor(player)) {
            var source = event.getSource();
            // Invulnerável ao dano de fogo
            if (source.is(DamageTypeTags.IS_FIRE)) event.setInvulnerable(true);
            // Invulnerável ao dano de queda
            if (source.is(DamageTypeTags.IS_FALL)) event.setInvulnerable(true);
            // Invulnerável ao dano de congelamento
            if (source.is(DamageTypeTags.IS_FREEZING)) event.setInvulnerable(true);
        }
    }

    // Invulnerável ao dano de Ender Pearl
    @SubscribeEvent
	public static void onEnderPearlTeleport(EntityTeleportEvent.EnderPearl event) {
		if (event.getEntity() instanceof ServerPlayer player && ArmorVerification.hasFullArmor(player)) {
			event.setAttackDamage(0);
		}
	}

    // @SubscribeEvent
    // public static void onPotionApplicable(MobEffectEvent.Applicable event) {
    //     if (event.getEntity() instanceof Player player && ArmorVerification.hasFullArmor(player)) {
	// 		MobEffectInstance effect = event.getEffectInstance();
    //         if (((MobEffect) effect.getEffect()).getCategory() == MobEffectCategory.HARMFUL) event.setResult(MobEffectEvent.Applicable.Result.DO_NOT_APPLY);;
    //     }
    // }
}
