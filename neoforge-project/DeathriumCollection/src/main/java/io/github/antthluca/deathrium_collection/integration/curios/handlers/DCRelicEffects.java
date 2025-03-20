package io.github.antthluca.deathrium_collection.integration.curios.handlers;

import java.util.Optional;
import java.util.Random;

import org.apache.commons.lang3.tuple.ImmutableTriple;

import io.github.antthluca.deathrium_collection.DeathriumCollection;
import io.github.antthluca.deathrium_collection.init.InitItems;
import io.github.antthluca.deathrium_collection.integration.curios.init.InitRelicItems;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import top.theillusivec4.curios.api.CuriosApi;

@EventBusSubscriber(modid = DeathriumCollection.MODID)
public class DCRelicEffects {
    // Constants
    private static final Random RANDOM = new Random();
    private static final float LIFESTEAL_BLACK_HEART = 0.3f;
    private static final float CHANCE_DROP_RING = 0.15f;
    private static final float INCREMENT_PASSAGE_KEY = 0.08f;
    private static final float INCREMENT_LAMENTATION_CROWN = 0.3f;

    // Events
    @SuppressWarnings("deprecation")
    @SubscribeEvent
    public static void onPlayerTick(PlayerTickEvent.Post event) {
        Player player = event.getEntity();

        if (player.tickCount % 20 != 0) return;

        // REAPER FEATHER
        boolean hasFeather = hasCurio((LivingEntity) player, InitRelicItems.REAPER_FEATHER.get());

        if (hasFeather) {
            if (!player.getAbilities().mayfly) {
                player.getAbilities().mayfly = true;
                player.onUpdateAbilities();
            }
        } else {
            if (player.getAbilities().mayfly) {
                player.getAbilities().mayfly = false;
                player.getAbilities().flying = false;
                player.onUpdateAbilities();
            }
        }
    }

    @SubscribeEvent
    public static void onEnemyDeath(LivingDeathEvent event) {
        if (event.getSource().getEntity() instanceof Player player) {
            // DEATH RING
            boolean hasRing = hasCurio((LivingEntity) player, InitRelicItems.DEATH_RING.get());

            if (hasRing) {
                // Sorteia a chance de drop (15%)
                if (RANDOM.nextFloat() < CHANCE_DROP_RING) {
                    dropDeathriumIngot(event.getEntity(), player);
                }
            }
        }
    }

    @SubscribeEvent
    public static void onPlayerDealDamage(LivingIncomingDamageEvent event) {
        DamageSource source = event.getSource();
        LivingEntity targetEntity = event.getEntity();
        

        // Verifica se quem causa o dano é um player
        if (source.getEntity() instanceof Player player) {
            LivingEntity sourceEntity = (LivingEntity) source.getEntity();  // Otimiza fazendo um único get com uma única conversão de tipo. Recupera a entidade que causa o dano.

            // PASSAGE KEY
            boolean hasKey = hasCurio(sourceEntity, InitRelicItems.PASSAGE_KEY.get());

            if (hasKey) {
                float extraDamage = targetEntity.getHealth() * INCREMENT_PASSAGE_KEY;

                event.setAmount(event.getAmount() + extraDamage);
            }

            // LAMENTATION CROWN
            boolean hasCrown = hasCurio(sourceEntity, InitRelicItems.LAMENTATION_CROWN.get());

            if (hasCrown && isCriticalHit(player)) {
                float extraDamage = event.getAmount() * INCREMENT_LAMENTATION_CROWN;

                event.setAmount(event.getAmount() + extraDamage);
            }

            // BLACK HEART
            boolean hasHeart = hasCurio(sourceEntity, InitRelicItems.BLACK_HEART.get());

            if (hasHeart) {
                float healAmount = event.getAmount() * LIFESTEAL_BLACK_HEART;
                player.heal(healAmount);
            }
        }
    }

    // Auxiliary functions
    @SuppressWarnings({ "deprecation", "removal" })
    public static boolean hasCurio(final LivingEntity entity, final Item curio) {
        final Optional<ImmutableTriple<String, Integer, ItemStack>> data = CuriosApi.getCuriosHelper().findEquippedCurio(curio, entity);
		return data.isPresent();
	}

    private static void dropDeathriumIngot(LivingEntity entity, Player player) {
        // Cria o item de drop
        ItemStack deathriumIngot = new ItemStack(InitItems.DEATHRIUM_INGOT.get());
        // Solta o item no mundo na posição do inimigo derrotado
        entity.spawnAtLocation(deathriumIngot);
    }

    private static boolean isCriticalHit(Player player) {
        // Verifica se o jogador realizou um acerto crítico
        return player.fallDistance > 0.0F && !player.onGround() && !player.isInWater() && !player.hasEffect(MobEffects.BLINDNESS);
    }
}
