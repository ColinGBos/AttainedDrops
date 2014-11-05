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
		mobDirtIcon = new IIcon[BlockInfo.MobDrops.length];
        for (int i = 0; i < BlockInfo.MobDrops.length; ++i)
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
		else return mobDirtSide;
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9)
    {
		if (player.getCurrentEquippedItem() != null)
		{
			for (int i = 0; i < BlockInfo.MobDrops.length; i++)
			{
				if (player.getCurrentEquippedItem().getItem() == BlockInfo.MobDrops[i] && world.getBlockMetadata(x, y, z) != i)
				{
					world.setBlockMetadataWithNotify(x, y, z, i, 2);
					player.inventory.consumeInventoryItem(player.getCurrentEquippedItem().getItem());
					return true;
				}
			}
		}
		else if(world.isRemote)
		{
			int i = world.getBlockMetadata(x, y, z);
			if(world.getBlockMetadata(x, y, z) != 0)
			{
				player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("phrase.AttainedDrops.DirtStart") + " " + EnumChatFormatting.GREEN + 
						StatCollector.translateToLocal(BlockInfo.MobDrops[i].getUnlocalizedNameInefficiently(new ItemStack(BlockInfo.MobDrops[i])) + ".name")));
			}
			if(world.getBlockMetadata(x, y, z) == 0)
			{
				player.addChatMessage(new ChatComponentText(StatCollector.translateToLocal("phrase.AttainedDrops.DirtBlank")));
			}
		}
		return false;
    }

}
