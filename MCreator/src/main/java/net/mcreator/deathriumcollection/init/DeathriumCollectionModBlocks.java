
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.deathriumcollection.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.block.Block;

import net.mcreator.deathriumcollection.block.ObsidianWeaknessBlock;
import net.mcreator.deathriumcollection.DeathriumCollectionMod;

public class DeathriumCollectionModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, DeathriumCollectionMod.MODID);
	public static final RegistryObject<Block> OBSIDIAN_WEAKNESS = REGISTRY.register("obsidian_weakness", () -> new ObsidianWeaknessBlock());

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class ClientSideHandler {
		@SubscribeEvent
		public static void clientSetup(FMLClientSetupEvent event) {
			ObsidianWeaknessBlock.registerRenderLayer();
		}
	}
}
