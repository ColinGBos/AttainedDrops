package com.vapourdrive.attaineddrops.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

import com.vapourdrive.attaineddrops.AttainedDrops;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockXPBall extends Block
{
	private IIcon BallTop;
	private IIcon BallSide;

	protected BlockXPBall()
	{
		super(Material.rock);
		setCreativeTab(AttainedDrops.tabAttainedDrops);
		setHardness(BlockInfo.BlockXPBallHardness);
		setLightLevel(BlockInfo.BlockXPBallLight);
		setBlockName(BlockInfo.BlockXPBallName);
		setHarvestLevel("pickaxe", 3);
		setStepSound(soundTypeStone);
		float f = 0.1875F;
		setBlockBounds(f, 0.0F, f, 1 - f, 1 - (2 * f), 1 - f);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister register)
	{
		BallTop = register.registerIcon(BlockInfo.BlockIconLocation + BlockInfo.BlockXPBallTopIcon);
		BallSide = register.registerIcon(BlockInfo.BlockIconLocation + BlockInfo.BlockXPBallSideIcon);
	}

	@Override
	public IIcon getIcon(int side, int meta)
	{
		if (side != 1 && side != 0)
		{
			return BallSide;
		}

		if (side == 1 || side == 0)
		{
			return BallTop;
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
