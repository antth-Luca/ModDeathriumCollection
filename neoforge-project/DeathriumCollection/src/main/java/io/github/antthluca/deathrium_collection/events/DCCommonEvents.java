package io.github.antthluca.deathrium_collection.events;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import io.github.antthluca.deathrium_collection.DeathriumCollection;
import io.github.antthluca.deathrium_collection.init.InitToolItems;
import io.github.antthluca.deathrium_collection.utils.ArmorVerification;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.food.FoodData;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.EntityInvulnerabilityCheckEvent;
import net.neoforged.neoforge.event.entity.EntityTeleportEvent;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

@EventBusSubscriber(modid = DeathriumCollection.MODID)
public class DCCommonEvents {
    @SubscribeEvent
    public static void playerTick(PlayerTickEvent.Post event) {
        if (event.getEntity() instanceof Player player
            && !player.level().isClientSide() 
            && ArmorVerification.hasFullArmor(player)) {
            // Remover fogo
            if (player.isOnFire() ) player.clearFire();
            // Respiração infinita
            if (player.getAirSupply() < player.getMaxAirSupply()) player.setAirSupply(player.getMaxAirSupply());
            // Não sente fome
            FoodData foodData = player.getFoodData();
            if (foodData.getSaturationLevel() < 5.0F) {
                System.out.println("SATURAÇÃO DEFINIDA");
                foodData.setSaturation(5.0F);
            }
            if (foodData.getFoodLevel() < 20) {
                System.out.println("FOME DEFINIDA");
                foodData.setFoodLevel(20);
            }
            // Remover efeitos negativos
            Collection<MobEffectInstance> activeEffects = player.getActiveEffects();  // Obtem efeitos ativos
            List<MobEffectInstance> harmfulEffectsToRemove = new ArrayList<>();
            for (MobEffectInstance effect : activeEffects) {  // Separa efeitos negativos
                if (effect != null && effect.getEffect().value().getCategory() == MobEffectCategory.HARMFUL) {
                    harmfulEffectsToRemove.add(effect);
                }
            }
            for (MobEffectInstance effect : harmfulEffectsToRemove) {
                player.removeEffect(effect.getEffect());  // Remove os efeitos negativos enteriormente separados
            }
        }
    }

    @SubscribeEvent
    public static void onLivingHurt(LivingIncomingDamageEvent event) {
        LivingEntity entity = event.getEntity();
        DamageSource source = event.getSource();

        if (// Quem sofre o dano é player...
            entity instanceof Player player
            // ...e tem armadura completa
            && ArmorVerification.hasFullArmor(player)
            // Causador do dano é entidade...
            && source.getEntity() instanceof LivingEntity sourceEntity
            // ...e item usado para causar dano não é a foice
            && !(sourceEntity.getMainHandItem().getItem() == InitToolItems.DEATHRIUM_SICKLE.get())
        ) event.setCanceled(true);  // Cancela o dano!
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
}
