package io.github.antthluca.deathrium_collection.integration.curios.handlers;

import java.util.Optional;
import java.util.Random;

import org.apache.commons.lang3.tuple.ImmutableTriple;

import io.github.antthluca.deathrium_collection.DeathriumCollection;
import io.github.antthluca.deathrium_collection.init.InitItems;
import io.github.antthluca.deathrium_collection.integration.curios.init.InitRelicItems;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingDeathEvent;
import net.neoforged.neoforge.event.entity.living.LivingIncomingDamageEvent;
import top.theillusivec4.curios.api.CuriosApi;

@EventBusSubscriber(modid = DeathriumCollection.MODID)
public class DCRelicEffects {
    // Constants
    private static final Random RANDOM = new Random();
    private static final float LIFESTEAL_BLACK_HEART = 0.3f;
    private static final float CHANCE_DROP_RING = 0.15f;

    // Events
    @SubscribeEvent
    public static void onEnemyDeath(LivingDeathEvent event) {
        if (event.getSource().getEntity() instanceof Player player) {
            // Verifica se o jogador tem a relíquia equipada
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
        if (event.getSource().getEntity() instanceof Player player) {
            // Verifica se o jogador tem a relíquia equipada
            boolean hasHeart = hasCurio((LivingEntity) player, InitRelicItems.BLACK_HEART.get());

            if (hasHeart) {
                float healAmount = event.getAmount() * LIFESTEAL_BLACK_HEART;
                player.heal(healAmount);
            }
        }
    }

    // Help functions
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
}
