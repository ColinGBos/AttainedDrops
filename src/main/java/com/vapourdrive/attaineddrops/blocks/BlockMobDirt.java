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
import com.vapourdrive.attaineddrops.config.BulbInfo;

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
		} else
			return mobDirtSide;
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
	{
		int k = world.getBlockMetadata(x, y, z);
		int l = player.experienceLevel;
		if (player.getCurrentEquippedItem() != null)
		{
			for (int i = 0; i < BlockInfo.MobDrops.length; i++)
			{
				if (canPlayerEnrich(player, k, i, l) == true)
				{
					world.setBlockMetadataWithNotify(x, y, z, i + 1, 2);
					world.playSoundAtEntity(player, "dig.grass", (float) 0.6, (float) 0.8);
					if (player.capabilities.isCreativeMode == false)
					{
						player.inventory.consumeInventoryItem(player.getCurrentEquippedItem().getItem());
						player.experienceLevel = (l - BlockInfo.EnrichXpUse);
					}
					return true;
				}
			}
		} else if (world.isRemote)
		{
			if (k != 0)
			{
				player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("phrase.AttainedDrops.DirtStart")
						+ " "
						+ EnumChatFormatting.GREEN
						+ StatCollector.translateToLocal(BlockInfo.MobDrops[k - 1].getUnlocalizedNameInefficiently(new ItemStack(
								BlockInfo.MobDrops[k - 1])) + ".name")));
			} else
			{
				player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("phrase.AttainedDrops.DirtBlank")));
			}
		}
		return false;
	}

	public boolean canPlayerEnrich(EntityPlayer player, int meta, int dropNumber, int experienceLevel)
	{
		if (player.getCurrentEquippedItem().getItem() == BlockInfo.MobDrops[dropNumber] && isDropEnabled(dropNumber))
		{
			if (meta != (dropNumber + 1))
			{
				if (experienceLevel >= getXPUse(dropNumber) || player.capabilities.isCreativeMode)
				{
					return true;
				}
			}
		}
		return false;
	}

	public static Boolean isDropEnabled(int dropNumber)
	{
		switch (dropNumber)
		{
		case 0:
			return BulbInfo.EnabledBulbs0.getBoolean();
		case 1:
			return BulbInfo.EnabledBulbs1.getBoolean();
		case 2:
			return BulbInfo.EnabledBulbs2.getBoolean();
		case 3:
			return BulbInfo.EnabledBulbs3.getBoolean();
		case 4:
			return BulbInfo.EnabledBulbs4.getBoolean();
		case 5:
			return BulbInfo.EnabledBulbs5.getBoolean();
		case 6:
			return BulbInfo.EnabledBulbs6.getBoolean();
		case 7:
			return BulbInfo.EnabledBulbs7.getBoolean();
		case 8:
			return BulbInfo.EnabledBulbs8.getBoolean();
		default:
			return true;
		}
	}
	
	public static int getXPUse(int dropNumber)
	{
		switch (dropNumber)
		{
		case 0:
			return BulbInfo.XPUse0.getInt();
		case 1:
			return BulbInfo.XPUse1.getInt();
		case 2:
			return BulbInfo.XPUse2.getInt();
		case 3:
			return BulbInfo.XPUse3.getInt();
		case 4:
			return BulbInfo.XPUse4.getInt();
		case 5:
			return BulbInfo.XPUse5.getInt();
		case 6:
			return BulbInfo.XPUse6.getInt();
		case 7:
			return BulbInfo.XPUse7.getInt();
		case 8:
			return BulbInfo.XPUse8.getInt();
		default:
			return 0;
		}
	}

}
