package com.vapourdrive.attaineddrops.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

import com.vapourdrive.attaineddrops.AttainedDrops;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockXPObelisk extends Block
{
	private IIcon ObeliskTop;
	private IIcon[] ObeliskSide;

	protected BlockXPObelisk()
	{
		super(Material.rock);
		setBlockName(BlockInfo.BlockXPObeliskName);
		setCreativeTab(AttainedDrops.tabAttainedDrops);
		setHardness(BlockInfo.BlockXPObeliskHardness);
		setHarvestLevel("pickaxe", 3);
		setTickRandomly(true);
		setStepSound(soundTypeStone);
		float f = 0.1875F;
		setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 1.0F, 0.5F + f);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister register)
	{
		ObeliskTop = register.registerIcon(BlockInfo.BlockIconLocation + BlockInfo.BlockXPObeliskIconTop);
		ObeliskSide = new IIcon[(BlockInfo.BlockXPObeliskLength)];

		for (int i = 0; i < BlockInfo.BlockXPObeliskLength; ++i)
		{
			ObeliskSide[i] = register.registerIcon(BlockInfo.BlockIconLocation + BlockInfo.BlockXPObeliskIcon + i);
		}
	}

	@Override
	public IIcon getIcon(int side, int meta)
	{
		if (side != 1 && side != 0)
		{
			return ObeliskSide[meta];
		}

		if (side == 1 || side == 0)
		{
			return ObeliskTop;
		}
		else
			return blockIcon;
	}

	@Override
	public boolean renderAsNormalBlock()
	{
		return false;
	}

	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}

}
