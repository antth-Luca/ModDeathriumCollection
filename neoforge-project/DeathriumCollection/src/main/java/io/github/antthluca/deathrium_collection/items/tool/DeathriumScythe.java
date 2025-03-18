package io.github.antthluca.deathrium_collection.items.tool;

import java.util.function.Function;

import io.github.antthluca.deathrium_collection.utils.ArmorVerificationUtils;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.component.Unbreakable;

public class DeathriumScythe extends SwordItem {
    private final float attackDamage;
    private final float attackSpeed;

    public DeathriumScythe(Tier tier) {
        this(tier, p -> {
            var uses = tier.getUses();
            if (uses == 0) {
                p.component(DataComponents.UNBREAKABLE, new Unbreakable(true));
            }
            p.durability(uses);

            p.rarity(Rarity.EPIC);

            return p;
        });
    }

    public DeathriumScythe(Tier tier, Function<Properties, Properties> prop) {
        this(tier, 3, -0.0F, prop);
    }

    public DeathriumScythe(Tier tier, int attackDamage, float attackSpeed, Function<Properties, Properties> prop) {
        super(tier, prop.apply(new Properties().attributes(createAttributes(tier, attackDamage, attackSpeed))));
        this.attackDamage = attackDamage;
        this.attackSpeed = attackSpeed;
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        boolean canHurt = super.hurtEnemy(stack, target, attacker);

        if (!(target instanceof Player player)) {
            target.kill();  // Mata instantaneamente, se não for player.
        } else if (!ArmorVerificationUtils.hasFullArmor(player)) {
            if (!player.isCreative()) {
                target.kill();  // É player. Se não estiver completo de armadura, mata instantaneamente...
            } else {
                target.setHealth(0);  // Até no criativo!
            }
        }

        return canHurt;
    }

    public float getAttackDamage() {
        return this.attackDamage + this.getTier().getAttackDamageBonus();
    }

    public float getAttackSpeed() {
        return this.attackSpeed;
    }
}
