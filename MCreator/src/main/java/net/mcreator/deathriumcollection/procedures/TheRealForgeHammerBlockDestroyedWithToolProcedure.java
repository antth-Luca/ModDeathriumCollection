package net.mcreator.deathriumcollection.procedures;

import net.minecraftforge.common.TierSortingRegistry;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

public class TheRealForgeHammerBlockDestroyedWithToolProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if ((itemstack).getMaxDamage() - (itemstack).getDamageValue() > (itemstack).getMaxDamage() * 0.2) {
			if ((entity.getDirection()) == Direction.NORTH || (entity.getDirection()) == Direction.SOUTH) {
				if ((world.getBlockState(new BlockPos(x + 0, y + 1, z + 0))).getMaterial() == net.minecraft.world.level.material.Material.STONE && new Object() {
					public int getHarvestLevel(Block _bl) {
						return TierSortingRegistry.getSortedTiers().stream().filter(t -> t.getTag() != null && _bl.defaultBlockState().is(t.getTag())).map(Tier::getLevel).findFirst().orElse(0);
					}
				}.getHarvestLevel(world.getBlockState(new BlockPos(x + 0, y + 1, z + 0)).getBlock()) < 3) {
					{
						BlockPos _pos = new BlockPos(x + 0, y + 1, z + 0);
						Block.dropResources(world.getBlockState(_pos), world, new BlockPos(x + 0, y + 1, z + 0), null);
						world.destroyBlock(_pos, false);
					}
					((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).setDamageValue((int) (((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).getDamageValue() + 1));
					if ((world.getBlockState(new BlockPos(x + 1, y + 1, z + 0))).getMaterial() == net.minecraft.world.level.material.Material.STONE && new Object() {
						public int getHarvestLevel(Block _bl) {
							return TierSortingRegistry.getSortedTiers().stream().filter(t -> t.getTag() != null && _bl.defaultBlockState().is(t.getTag())).map(Tier::getLevel).findFirst().orElse(0);
						}
					}.getHarvestLevel(world.getBlockState(new BlockPos(x + 1, y + 1, z + 0)).getBlock()) < 3) {
						{
							BlockPos _pos = new BlockPos(x + 1, y + 1, z + 0);
							Block.dropResources(world.getBlockState(_pos), world, new BlockPos(x + 1, y + 1, z + 0), null);
							world.destroyBlock(_pos, false);
						}
						((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).setDamageValue((int) (((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).getDamageValue() + 1));
						if ((world.getBlockState(new BlockPos(x - 1, y + 1, z + 0))).getMaterial() == net.minecraft.world.level.material.Material.STONE && new Object() {
							public int getHarvestLevel(Block _bl) {
								return TierSortingRegistry.getSortedTiers().stream().filter(t -> t.getTag() != null && _bl.defaultBlockState().is(t.getTag())).map(Tier::getLevel).findFirst().orElse(0);
							}
						}.getHarvestLevel(world.getBlockState(new BlockPos(x - 1, y + 1, z + 0)).getBlock()) < 3) {
							{
								BlockPos _pos = new BlockPos(x - 1, y + 1, z + 0);
								Block.dropResources(world.getBlockState(_pos), world, new BlockPos(x - 1, y + 1, z + 0), null);
								world.destroyBlock(_pos, false);
							}
							((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY))
									.setDamageValue((int) (((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).getDamageValue() + 1));
							if ((world.getBlockState(new BlockPos(x + 1, y + 0, z + 0))).getMaterial() == net.minecraft.world.level.material.Material.STONE && new Object() {
								public int getHarvestLevel(Block _bl) {
									return TierSortingRegistry.getSortedTiers().stream().filter(t -> t.getTag() != null && _bl.defaultBlockState().is(t.getTag())).map(Tier::getLevel).findFirst().orElse(0);
								}
							}.getHarvestLevel(world.getBlockState(new BlockPos(x + 1, y + 0, z + 0)).getBlock()) < 3) {
								{
									BlockPos _pos = new BlockPos(x + 1, y + 0, z + 0);
									Block.dropResources(world.getBlockState(_pos), world, new BlockPos(x + 1, y + 0, z + 0), null);
									world.destroyBlock(_pos, false);
								}
								((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY))
										.setDamageValue((int) (((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).getDamageValue() + 1));
								if ((world.getBlockState(new BlockPos(x - 1, y + 0, z + 0))).getMaterial() == net.minecraft.world.level.material.Material.STONE && new Object() {
									public int getHarvestLevel(Block _bl) {
										return TierSortingRegistry.getSortedTiers().stream().filter(t -> t.getTag() != null && _bl.defaultBlockState().is(t.getTag())).map(Tier::getLevel).findFirst().orElse(0);
									}
								}.getHarvestLevel(world.getBlockState(new BlockPos(x - 1, y + 0, z + 0)).getBlock()) < 3) {
									{
										BlockPos _pos = new BlockPos(x - 1, y + 0, z + 0);
										Block.dropResources(world.getBlockState(_pos), world, new BlockPos(x - 1, y + 0, z + 0), null);
										world.destroyBlock(_pos, false);
									}
									((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY))
											.setDamageValue((int) (((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).getDamageValue() + 1));
									if ((world.getBlockState(new BlockPos(x + 0, y - 1, z + 0))).getMaterial() == net.minecraft.world.level.material.Material.STONE && new Object() {
										public int getHarvestLevel(Block _bl) {
											return TierSortingRegistry.getSortedTiers().stream().filter(t -> t.getTag() != null && _bl.defaultBlockState().is(t.getTag())).map(Tier::getLevel).findFirst().orElse(0);
										}
									}.getHarvestLevel(world.getBlockState(new BlockPos(x + 0, y - 1, z + 0)).getBlock()) < 3) {
										{
											BlockPos _pos = new BlockPos(x + 0, y - 1, z + 0);
											Block.dropResources(world.getBlockState(_pos), world, new BlockPos(x + 0, y - 1, z + 0), null);
											world.destroyBlock(_pos, false);
										}
										((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY))
												.setDamageValue((int) (((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).getDamageValue() + 1));
										if ((world.getBlockState(new BlockPos(x + 1, y - 1, z + 0))).getMaterial() == net.minecraft.world.level.material.Material.STONE && new Object() {
											public int getHarvestLevel(Block _bl) {
												return TierSortingRegistry.getSortedTiers().stream().filter(t -> t.getTag() != null && _bl.defaultBlockState().is(t.getTag())).map(Tier::getLevel).findFirst().orElse(0);
											}
										}.getHarvestLevel(world.getBlockState(new BlockPos(x + 1, y - 1, z + 0)).getBlock()) < 3) {
											{
												BlockPos _pos = new BlockPos(x + 1, y - 1, z + 0);
												Block.dropResources(world.getBlockState(_pos), world, new BlockPos(x + 1, y - 1, z + 0), null);
												world.destroyBlock(_pos, false);
											}
											((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY))
													.setDamageValue((int) (((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).getDamageValue() + 1));
											if ((world.getBlockState(new BlockPos(x - 1, y - 1, z + 0))).getMaterial() == net.minecraft.world.level.material.Material.STONE && new Object() {
												public int getHarvestLevel(Block _bl) {
													return TierSortingRegistry.getSortedTiers().stream().filter(t -> t.getTag() != null && _bl.defaultBlockState().is(t.getTag())).map(Tier::getLevel).findFirst().orElse(0);
												}
											}.getHarvestLevel(world.getBlockState(new BlockPos(x - 1, y - 1, z + 0)).getBlock()) < 3) {
												{
													BlockPos _pos = new BlockPos(x - 1, y - 1, z + 0);
													Block.dropResources(world.getBlockState(_pos), world, new BlockPos(x - 1, y - 1, z + 0), null);
													world.destroyBlock(_pos, false);
												}
												((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY))
														.setDamageValue((int) (((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).getDamageValue() + 1));
											}
										}
									}
								}
							}
						}
					}
				}
			} else if ((entity.getDirection()) == Direction.WEST || (entity.getDirection()) == Direction.EAST) {
				if ((world.getBlockState(new BlockPos(x + 0, y + 1, z + 0))).getMaterial() == net.minecraft.world.level.material.Material.STONE && new Object() {
					public int getHarvestLevel(Block _bl) {
						return TierSortingRegistry.getSortedTiers().stream().filter(t -> t.getTag() != null && _bl.defaultBlockState().is(t.getTag())).map(Tier::getLevel).findFirst().orElse(0);
					}
				}.getHarvestLevel(world.getBlockState(new BlockPos(x + 0, y + 1, z + 0)).getBlock()) < 3) {
					{
						BlockPos _pos = new BlockPos(x + 0, y + 1, z + 0);
						Block.dropResources(world.getBlockState(_pos), world, new BlockPos(x + 0, y + 1, z + 0), null);
						world.destroyBlock(_pos, false);
					}
					((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).setDamageValue((int) (((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).getDamageValue() + 1));
					if ((world.getBlockState(new BlockPos(x + 0, y + 1, z + 1))).getMaterial() == net.minecraft.world.level.material.Material.STONE && new Object() {
						public int getHarvestLevel(Block _bl) {
							return TierSortingRegistry.getSortedTiers().stream().filter(t -> t.getTag() != null && _bl.defaultBlockState().is(t.getTag())).map(Tier::getLevel).findFirst().orElse(0);
						}
					}.getHarvestLevel(world.getBlockState(new BlockPos(x + 0, y + 1, z + 1)).getBlock()) < 3) {
						{
							BlockPos _pos = new BlockPos(x + 0, y + 1, z + 1);
							Block.dropResources(world.getBlockState(_pos), world, new BlockPos(x + 0, y + 1, z + 1), null);
							world.destroyBlock(_pos, false);
						}
						((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).setDamageValue((int) (((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).getDamageValue() + 1));
						if ((world.getBlockState(new BlockPos(x - 0, y + 1, z - 1))).getMaterial() == net.minecraft.world.level.material.Material.STONE && new Object() {
							public int getHarvestLevel(Block _bl) {
								return TierSortingRegistry.getSortedTiers().stream().filter(t -> t.getTag() != null && _bl.defaultBlockState().is(t.getTag())).map(Tier::getLevel).findFirst().orElse(0);
							}
						}.getHarvestLevel(world.getBlockState(new BlockPos(x - 0, y + 1, z - 1)).getBlock()) < 3) {
							{
								BlockPos _pos = new BlockPos(x - 0, y + 1, z - 1);
								Block.dropResources(world.getBlockState(_pos), world, new BlockPos(x - 0, y + 1, z - 1), null);
								world.destroyBlock(_pos, false);
							}
							((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY))
									.setDamageValue((int) (((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).getDamageValue() + 1));
							if ((world.getBlockState(new BlockPos(x + 0, y + 0, z + 1))).getMaterial() == net.minecraft.world.level.material.Material.STONE && new Object() {
								public int getHarvestLevel(Block _bl) {
									return TierSortingRegistry.getSortedTiers().stream().filter(t -> t.getTag() != null && _bl.defaultBlockState().is(t.getTag())).map(Tier::getLevel).findFirst().orElse(0);
								}
							}.getHarvestLevel(world.getBlockState(new BlockPos(x + 0, y + 0, z + 1)).getBlock()) < 3) {
								{
									BlockPos _pos = new BlockPos(x + 0, y + 0, z + 1);
									Block.dropResources(world.getBlockState(_pos), world, new BlockPos(x + 0, y + 0, z + 1), null);
									world.destroyBlock(_pos, false);
								}
								((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY))
										.setDamageValue((int) (((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).getDamageValue() + 1));
								if ((world.getBlockState(new BlockPos(x - 0, y + 0, z - 1))).getMaterial() == net.minecraft.world.level.material.Material.STONE && new Object() {
									public int getHarvestLevel(Block _bl) {
										return TierSortingRegistry.getSortedTiers().stream().filter(t -> t.getTag() != null && _bl.defaultBlockState().is(t.getTag())).map(Tier::getLevel).findFirst().orElse(0);
									}
								}.getHarvestLevel(world.getBlockState(new BlockPos(x - 0, y + 0, z - 1)).getBlock()) < 3) {
									{
										BlockPos _pos = new BlockPos(x - 0, y + 0, z - 1);
										Block.dropResources(world.getBlockState(_pos), world, new BlockPos(x - 0, y + 0, z - 1), null);
										world.destroyBlock(_pos, false);
									}
									((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY))
											.setDamageValue((int) (((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).getDamageValue() + 1));
									if ((world.getBlockState(new BlockPos(x + 0, y - 1, z + 0))).getMaterial() == net.minecraft.world.level.material.Material.STONE && new Object() {
										public int getHarvestLevel(Block _bl) {
											return TierSortingRegistry.getSortedTiers().stream().filter(t -> t.getTag() != null && _bl.defaultBlockState().is(t.getTag())).map(Tier::getLevel).findFirst().orElse(0);
										}
									}.getHarvestLevel(world.getBlockState(new BlockPos(x + 0, y - 1, z + 0)).getBlock()) < 3) {
										{
											BlockPos _pos = new BlockPos(x + 0, y - 1, z + 0);
											Block.dropResources(world.getBlockState(_pos), world, new BlockPos(x + 0, y - 1, z + 0), null);
											world.destroyBlock(_pos, false);
										}
										((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY))
												.setDamageValue((int) (((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).getDamageValue() + 1));
										if ((world.getBlockState(new BlockPos(x + 0, y - 1, z + 1))).getMaterial() == net.minecraft.world.level.material.Material.STONE && new Object() {
											public int getHarvestLevel(Block _bl) {
												return TierSortingRegistry.getSortedTiers().stream().filter(t -> t.getTag() != null && _bl.defaultBlockState().is(t.getTag())).map(Tier::getLevel).findFirst().orElse(0);
											}
										}.getHarvestLevel(world.getBlockState(new BlockPos(x + 0, y - 1, z + 1)).getBlock()) < 3) {
											{
												BlockPos _pos = new BlockPos(x + 0, y - 1, z + 1);
												Block.dropResources(world.getBlockState(_pos), world, new BlockPos(x + 0, y - 1, z + 1), null);
												world.destroyBlock(_pos, false);
											}
											((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY))
													.setDamageValue((int) (((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).getDamageValue() + 1));
											if ((world.getBlockState(new BlockPos(x - 0, y - 1, z - 1))).getMaterial() == net.minecraft.world.level.material.Material.STONE && new Object() {
												public int getHarvestLevel(Block _bl) {
													return TierSortingRegistry.getSortedTiers().stream().filter(t -> t.getTag() != null && _bl.defaultBlockState().is(t.getTag())).map(Tier::getLevel).findFirst().orElse(0);
												}
											}.getHarvestLevel(world.getBlockState(new BlockPos(x - 0, y - 1, z - 1)).getBlock()) < 3) {
												{
													BlockPos _pos = new BlockPos(x - 0, y - 1, z - 1);
													Block.dropResources(world.getBlockState(_pos), world, new BlockPos(x - 0, y - 1, z - 1), null);
													world.destroyBlock(_pos, false);
												}
												((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY))
														.setDamageValue((int) (((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY)).getDamageValue() + 1));
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}
	}
}
