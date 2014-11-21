package com.vapourdrive.attaineddrops.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.IGrowable;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import com.vapourdrive.attaineddrops.items.AD_Items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockMobPlant extends BlockBush implements IGrowable
{
	@SideOnly(Side.CLIENT)
	private IIcon[] mobDropPlant;

	protected BlockMobPlant()
	{
		super(Material.plants);
		setTickRandomly(true);
		setBlockName(BlockInfo.BlockMobPlantName);
		setHardness(BlockInfo.BlockMobPlantHardness);
		setStepSound(Block.soundTypeGrass);
		float f = 0.5F;
		setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 0.25F, 0.5F + f);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister icon)
	{
		mobDropPlant = new IIcon[8];

		for (int i = 0; i < mobDropPlant.length; ++i)
		{
			mobDropPlant[i] = icon.registerIcon(BlockInfo.BlockIconLocation + BlockInfo.BlockMobPlantIcon + i);
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta)
	{
		if (meta < 0 || meta > 7)
		{
			meta = 7;
		}

		return mobDropPlant[meta];
	}

	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess block, int x, int y, int z)
	{
		this.maxY = (double) ((float) (block.getBlockMetadata(x, y, z) * 2 + 2) / 16.0F);
		if (maxY > 1.0F)
		{
			maxY = 1.0F;
		}
		float f = 0.125F;
		this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, (float) this.maxY, 0.5F + f);
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_)
	{
		return null;
	}

	@Override
	protected boolean canPlaceBlockOn(Block block)
	{
		return block == AD_Blocks.BlockMobDirt;
	}

	@Override
	public boolean func_149851_a(World world, int x, int y, int z, boolean bool)
	{
		int i = world.getBlockMetadata(x, y, z);
		int dropNumber = (world.getBlockMetadata(x, y - 1, z) - 1);
		Block upperBlock = world.getBlock(x, y + 1, z);
		if (i < 8)
		{
			return true;
		}
		else
			if (i == 8 && BulbHelper.canBonemealBulb(dropNumber) == true && upperBlock.isAir(world, x, y, z))
			{
				return true;
			}
		return false;
	}

	@Override
	public boolean func_149852_a(World world, Random rand, int x, int y, int z)
	{
		return true;
	}

	@Override
	public void func_149853_b(World world, Random rand, int x, int y, int z)
	{
		growBlock(world, x, y, z);
	}

	public void growBlock(World world, int x, int y, int z)
	{
		int l = world.getBlockMetadata(x, y, z);
		int i = l + MathHelper.getRandomIntegerInRange(world.rand, 2, 5);
		int dropNumber = world.getBlockMetadata(x, y - 1, z);

		if (l == 8 && BulbHelper.canBonemealBulb(dropNumber - 1) == true)
		{
			if (world.getBlock(x, y + 1, z).isAir(world, x, y + 1, z) && dropNumber != 0
					&& world.rand.nextInt(BulbHelper.chanceForBoneMeal(dropNumber - 1)) == 0)
			{
				world.setBlock(x, y + 1, z, AD_Blocks.BlockMobBulb, (dropNumber - 1), 2);
				if (world.rand.nextInt(BulbHelper.getSoilResetChance(dropNumber - 1)) == 0
						&& BulbHelper.getCanSoilReset(dropNumber - 1) == true)
				{
					world.setBlockMetadataWithNotify(x, y - 1, z, 0, 2);
				}
			}
		}

		if (i > 8)
		{
			i = 8;
		}

		world.setBlockMetadataWithNotify(x, y, z, i, 2);
	}

	@Override
	public void updateTick(World world, int x, int y, int z, Random rand)
	{
		super.updateTick(world, x, y, z, rand);

		int meta = world.getBlockMetadata(x, y, z);
		int dropNumber = world.getBlockMetadata(x, y - 1, z);

		if (meta < 8)
		{
			if (rand.nextInt(BlockInfo.BlockMobPlantUpdate) == 0)
			{
				++meta;
				world.setBlockMetadataWithNotify(x, y, z, meta, 2);
			}
		}
		if (meta == 8 && world.getBlock(x, y - 1, z) == AD_Blocks.BlockMobDirt && dropNumber != 0)
		{
			if (rand.nextInt(BulbHelper.getBulbRate(dropNumber)) == 0 && world.getBlock(x, y + 1, z).isAir(world, x, y + 1, z))
			{
				world.setBlock(x, y + 1, z, AD_Blocks.BlockMobBulb, (dropNumber - 1), 2);
				if (rand.nextInt(BulbHelper.getSoilResetChance(dropNumber - 1)) == 0 && BulbHelper.getCanSoilReset(dropNumber - 1) == true)
				{
					world.setBlockMetadataWithNotify(x, y - 1, z, 0, 2);
				}
			}
		}
	}

	@Override
	public Item getItemDropped(int meta, Random rand, int fortune)
	{
		if (meta >= 7)
		{
			return AD_Items.plantSeed;
		}
		else
			return null;
	}

	@Override
	public int quantityDroppedWithBonus(int fortune, Random rand)
	{
		if (fortune > 0 && Item.getItemFromBlock(this) != this.getItemDropped(0, rand, fortune))
		{
			int j = rand.nextInt(fortune + 2) - 1;

			if (j < 0)
			{
				j = 0;
			}

			return this.quantityDropped(rand) * (j + 1);
		}
		else
		{
			return this.quantityDropped(rand);
		}
	}

	@Override
	public int quantityDropped(Random rand)
	{
		return (rand.nextInt(2) + 1);
	}

}
