package com.vapourdrive.attaineddrops.items;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.vapourdrive.attaineddrops.AttainedDrops;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemXPWand extends Item
{
	public ItemXPWand()
	{
		super();
		setCreativeTab(AttainedDrops.tabAttainedDrops);
		setUnlocalizedName(ItemInfo.XPWandName);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister register)
	{
		itemIcon = register.registerIcon(ItemInfo.TextureLocation + ItemInfo.XPWandIcon);
	}

	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int meta, float xf, float yf, float zf)
	{
		int experience = player.experienceLevel;
		if (world.getBlock(x, y, z) == Blocks.obsidian)
		{
//			world.setBlock(x, y, z, AD_Blocks.BlockXPObsidian, 0, 2);
			player.experienceLevel = experience - 5;
			return true;
		}
		return false;
	}
}
