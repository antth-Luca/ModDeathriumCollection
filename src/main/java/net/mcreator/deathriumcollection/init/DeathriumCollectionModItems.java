
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.deathriumcollection.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.BlockItem;

import net.mcreator.deathriumcollection.item.UnfinishedForgeHammerItem;
import net.mcreator.deathriumcollection.item.TheRealForgeHammerItem;
import net.mcreator.deathriumcollection.item.SignatureOfDeathItem;
import net.mcreator.deathriumcollection.item.PutridGemItem;
import net.mcreator.deathriumcollection.item.PinkIronIngotItem;
import net.mcreator.deathriumcollection.item.PinkFurnaceCoreItem;
import net.mcreator.deathriumcollection.item.PinkCoatedBoneItem;
import net.mcreator.deathriumcollection.item.OxidizedAlloyItem;
import net.mcreator.deathriumcollection.item.InsigniaOfDeathItem;
import net.mcreator.deathriumcollection.item.HeavyAgglomerateItem;
import net.mcreator.deathriumcollection.item.BedrockShardItem;
import net.mcreator.deathriumcollection.DeathriumCollectionMod;

public class DeathriumCollectionModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, DeathriumCollectionMod.MODID);
	public static final RegistryObject<Item> PINK_IRON_INGOT = REGISTRY.register("pink_iron_ingot", () -> new PinkIronIngotItem());
	public static final RegistryObject<Item> OXIDIZED_ALLOY = REGISTRY.register("oxidized_alloy", () -> new OxidizedAlloyItem());
	public static final RegistryObject<Item> PINK_COATED_BONE = REGISTRY.register("pink_coated_bone", () -> new PinkCoatedBoneItem());
	public static final RegistryObject<Item> BEDROCK_SHARD = REGISTRY.register("bedrock_shard", () -> new BedrockShardItem());
	public static final RegistryObject<Item> PUTRID_GEM = REGISTRY.register("putrid_gem", () -> new PutridGemItem());
	public static final RegistryObject<Item> OBSIDIAN_WEAKNESS = block(DeathriumCollectionModBlocks.OBSIDIAN_WEAKNESS, CreativeModeTab.TAB_MISC);
	public static final RegistryObject<Item> PINK_FURNACE_CORE = REGISTRY.register("pink_furnace_core", () -> new PinkFurnaceCoreItem());
	public static final RegistryObject<Item> UNFINISHED_FORGE_HAMMER = REGISTRY.register("unfinished_forge_hammer", () -> new UnfinishedForgeHammerItem());
	public static final RegistryObject<Item> THE_REAL_FORGE_HAMMER = REGISTRY.register("the_real_forge_hammer", () -> new TheRealForgeHammerItem());
	public static final RegistryObject<Item> HEAVY_AGGLOMERATE = REGISTRY.register("heavy_agglomerate", () -> new HeavyAgglomerateItem());
	public static final RegistryObject<Item> INSIGNIA_OF_DEATH = REGISTRY.register("insignia_of_death", () -> new InsigniaOfDeathItem());
	public static final RegistryObject<Item> SIGNATURE_OF_DEATH = REGISTRY.register("signature_of_death", () -> new SignatureOfDeathItem());

	private static RegistryObject<Item> block(RegistryObject<Block> block, CreativeModeTab tab) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
	}
}
