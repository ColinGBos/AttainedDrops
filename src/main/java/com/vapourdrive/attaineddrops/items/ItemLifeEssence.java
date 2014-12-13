package com.vapourdrive.attaineddrops.items;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

import com.vapourdrive.attaineddrops.AttainedDrops;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemLifeEssence extends Item
{
	public ItemLifeEssence()
	{
		super();
		setCreativeTab(AttainedDrops.tabAttainedDrops);
		setUnlocalizedName(ItemInfo.LifeEssenceName);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister register)
	{
		itemIcon = register.registerIcon(ItemInfo.TextureLocation + ItemInfo.LifeEssenceIcon);
	}
}
