package com.vapourdrive.attaineddrops.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import com.vapourdrive.attaineddrops.AttainedDrops;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockVitalizedSoil extends Block
{
	public static IIcon BlockConcentrateDrop;

	protected BlockVitalizedSoil()
	{
		super(Material.rock);
		setBlockName(BlockInfo.BlockConcentrateDropName);
		setHardness(BlockInfo.BlockConcentrateDropHardness);
		setTickRandomly(true);
		setStepSound(soundTypeGrass);
		setCreativeTab(AttainedDrops.tabAttainedDrops);
	}

	@Override
	public void updateTick(World world, int x, int y, int z, Random rand)
	{
		super.updateTick(world, x, y, z, rand);

		int l = world.getBlockMetadata(x, y, z);

		if (l < 15 && rand.nextInt(3) == 0)
		{
			l++;
			int i = x + (rand.nextInt(3) - 1);
			int k = z + (rand.nextInt(3) - 1);
			if (world.getBlock(i, y, k) == Blocks.dirt || world.getBlock(i, y, k) == Blocks.grass)
			{
				world.setBlock(i, y, k, AD_Blocks.BlockMobDirt, 0, 2);
				world.setBlockMetadataWithNotify(x, y, z, l, 2);
			}
		}
		if (l == 15)
		{
			world.setBlock(x, y, z, Blocks.dirt);
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister icon)
	{
		BlockConcentrateDrop = icon.registerIcon(BlockInfo.BlockIconLocation + BlockInfo.BlockConcentrateDropIcon);
	}

	@Override
	public IIcon getIcon(int side, int meta)
	{
		return BlockConcentrateDrop;
	}

}
