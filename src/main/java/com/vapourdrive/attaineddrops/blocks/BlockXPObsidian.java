package com.vapourdrive.attaineddrops.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

import com.vapourdrive.attaineddrops.AttainedDrops;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockXPObsidian extends Block
{
	
	protected BlockXPObsidian()
	{
		super(Material.rock);
		setBlockName(BlockInfo.BlockXPObsidianName);
		setCreativeTab(AttainedDrops.tabAttainedDrops);
		setHardness(BlockInfo.BlockXPObsidianHardness);
		setResistance(BlockInfo.BlockXPObsidianResistance);
		setStepSound(soundTypeStone);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister register)
	{
		blockIcon = register.registerIcon(BlockInfo.BlockIconLocation + BlockInfo.BlockXPObsidianIcon);
	}

	@Override
	public IIcon getIcon(int side, int meta)
	{
		return blockIcon;
	}

}
