package io.github.antthluca.deathrium_collection.integration.curios.rarities;

import java.util.function.UnaryOperator;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Style;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.Rarity;
import net.neoforged.fml.common.asm.enumextension.ExtensionInfo;
import net.neoforged.fml.common.asm.enumextension.IExtensibleEnum;

public enum DCRarities implements StringRepresentable, IExtensibleEnum {
    COMMON(0, "common", ChatFormatting.WHITE),
    UNCOMMON(1, "uncommon", ChatFormatting.YELLOW),
    RARE(2, "rare", ChatFormatting.AQUA),
    EPIC(3, "epic", ChatFormatting.LIGHT_PURPLE),
    MITHIC(4, "mithic", ChatFormatting.RED),
    LEGENDARY(5, "legendary", ChatFormatting.GOLD);

    @SuppressWarnings("unused")
    private final int id;
    private final String name;
    private final ChatFormatting color;
    private final UnaryOperator<Style> styleModifier;

    private DCRarities(int id, String name, ChatFormatting color) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.styleModifier = (style) -> {
            return style.withColor(color);
        };
    }

    @SuppressWarnings("unchecked")
    private DCRarities(int id, String name, @SuppressWarnings("rawtypes") UnaryOperator styleModifier) {
        this.id = id;
        this.name = name;
        this.color = ChatFormatting.BLACK;
        this.styleModifier = styleModifier;
    }

    /** @deprecated */
    @Deprecated
    public ChatFormatting color() {
        return this.color;
    }

    public UnaryOperator<Style> getStyleModifier() {
        return this.styleModifier;
    }

    public String getSerializedName() {
        return this.name;
    }

    public static ExtensionInfo getExtensionInfo() {
        return ExtensionInfo.nonExtended(Rarity.class);
    }
}
