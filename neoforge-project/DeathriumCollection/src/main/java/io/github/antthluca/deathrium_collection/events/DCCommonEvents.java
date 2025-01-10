package io.github.antthluca.deathrium_collection.events;

import io.github.antthluca.deathrium_collection.DeathriumCollection;
import io.github.antthluca.deathrium_collection.utils.ArmorVerification;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.entity.player.Player;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityInvulnerabilityCheckEvent;
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
            // Ivunerável ao dano de fogo
            if (source.is(DamageTypeTags.IS_FIRE)) event.setInvulnerable(true);
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
