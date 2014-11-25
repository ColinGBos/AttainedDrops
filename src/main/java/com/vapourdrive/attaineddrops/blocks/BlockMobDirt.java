package com.vapourdrive.attaineddrops.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IIcon;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import com.vapourdrive.attaineddrops.AttainedDrops;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockMobDirt extends Block
{
	public static IIcon[] mobDirtIcon;
	public static IIcon mobDirtSide;

	protected BlockMobDirt()
	{
		super(Material.ground);
		setBlockName(BlockInfo.BlockMobDirtName);
		setHardness(BlockInfo.BlockMobDirtHardness);
		setCreativeTab(AttainedDrops.tabAttainedDrops);
		setStepSound(soundTypeGrass);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister icon)
	{
		mobDirtSide = icon.registerIcon(BlockInfo.BlockIconLocation + BlockInfo.BlockMobDirtSideIcon);
		mobDirtIcon = new IIcon[BlockInfo.MobDrops.length + 1];
		for (int i = 0; i <= BlockInfo.MobDrops.length; ++i)
		{
			mobDirtIcon[i] = icon.registerIcon(BlockInfo.BlockIconLocation + BlockInfo.BlockMobDirtIcon + i);
		}
	}

	@Override
	public IIcon getIcon(int side, int meta)
	{
		if (side == 1)
		{
			return mobDirtIcon[meta];
		}
		else
			return mobDirtSide;
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
	{
		int k = world.getBlockMetadata(x, y, z);
		int xp = player.experienceLevel;
		if (player.getCurrentEquippedItem() != null)
		{
			for (int i = 0; i < BlockInfo.MobDrops.length; i++)
			{
				if (canPlayerEnrich(world, x, y, z, player, k, i, xp) == true)
				{
					world.setBlockMetadataWithNotify(x, y, z, i + 1, 2);
					world.playSoundAtEntity(player, "dig.grass", (float) 0.6, (float) 0.8);
					if (player.capabilities.isCreativeMode == false)
					{
						player.inventory.consumeInventoryItem(player.getCurrentEquippedItem().getItem());
						player.experienceLevel = (xp - BulbHelper.getXPUse(i));
					}
					return true;
				}
			}
		}
		else if (world.isRemote)
		{
			if (k != 0)
			{
				player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("phrase.AttainedDrops.DirtStart")
						+ " "
						+ EnumChatFormatting.GREEN
						+ StatCollector.translateToLocal(BlockInfo.MobDrops[k - 1].getUnlocalizedNameInefficiently(new ItemStack(
								BlockInfo.MobDrops[k - 1])) + ".name")));
			}
			else
			{
				player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("phrase.AttainedDrops.DirtBlank")));
			}
		}
		return false;
	}

	public boolean canPlayerEnrich(World world, int x, int y, int z, EntityPlayer player, int meta, int dropNumber, int xp)
	{
		if (player.getCurrentEquippedItem().getItem() == BlockInfo.MobDrops[dropNumber])
		{
			if (meta != (dropNumber + 1) && BulbHelper.isDropEnabled(dropNumber))
			{
				if (xp >= BulbHelper.getXPUse(dropNumber) || player.capabilities.isCreativeMode)
				{
					return true;
				}
			}
			chatHelper(world, x, y, z, player, dropNumber, xp);
		}

		return false;
	}

	public static void chatHelper(World world, int x, int y, int z, EntityPlayer player, int dropNumber, int xp)
	{
		if (world.isRemote)
		{
			if (BulbHelper.isDropEnabled(dropNumber) == false)
			{
				player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("phrase.AttainedDrops.DisabledBulbChat")));
			}
			if (xp < BulbHelper.getXPUse(dropNumber))
			{
				player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("phrase.AttainedDrops.ShortXPChat")));
			}
		}
	}

}
