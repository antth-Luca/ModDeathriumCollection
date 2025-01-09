package io.github.antthluca.deathrium_collection.items.tool;

import java.util.function.Function;

import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.component.Unbreakable;

public class DeathriumSickle extends SwordItem {
    private final float attackDamage;
    private final float attackSpeed;

    public DeathriumSickle(Tier tier) {
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

    public DeathriumSickle(Tier tier, Function<Properties, Properties> prop) {
        this(tier, 3, -0.0F, prop);
    }

    public DeathriumSickle(Tier tier, int attackDamage, float attackSpeed, Function<Properties, Properties> prop) {
        super(tier, prop.apply(new Properties().attributes(createAttributes(tier, attackDamage, attackSpeed))));
        this.attackDamage = attackDamage;
        this.attackSpeed = attackSpeed;
    }

    public float getAttackDamage() {
        return this.attackDamage + this.getTier().getAttackDamageBonus();
    }

    public float getAttackSpeed() {
        return this.attackSpeed;
    }
}
