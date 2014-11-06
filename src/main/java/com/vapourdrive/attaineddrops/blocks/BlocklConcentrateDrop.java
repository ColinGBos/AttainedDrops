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

public class BlocklConcentrateDrop extends Block
{
	public static IIcon BlockConcentrateDrop;

	protected BlocklConcentrateDrop()
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

        if (rand.nextInt(BlockInfo.BlockConcentrateDropUpate) == 0)
        {
            ++l;
            world.setBlockMetadataWithNotify(x, y, z, l, 2);
        }
        if (l > 3 && l < 15)
        {
        	l++;
        	int i = x + (rand.nextInt(3) - 1);
        	int j = y + (rand.nextInt(3) - 1);
        	int k = z + (rand.nextInt(3) - 1);
        	if (world.getBlock(i, j, k) == Blocks.dirt || world.getBlock(i, j, k) == Blocks.grass)
        	{
        		world.setBlock(i, j, k, AD_Blocks.BlockMobDirt, 0, 2);
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
