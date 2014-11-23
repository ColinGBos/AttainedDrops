package com.vapourdrive.attaineddrops.creativetabs;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import com.vapourdrive.attaineddrops.blocks.AD_Blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CreativeTabAD extends CreativeTabs
{

	public CreativeTabAD(int position, String tabID)
	{
		super(position, tabID);
		setBackgroundImageName("attaineddrops.png");
	}

	@Override
	@SideOnly(Side.CLIENT)
	public String getTabLabel()
	{
		return "AttainedDrops";
	}

	@Override
	@SideOnly(Side.CLIENT)
	public String getTranslatedTabLabel()
	{
		return "Attained Drops";
	}

	@Override
	public Item getTabIconItem()
	{
		return Item.getItemFromBlock(AD_Blocks.BlockConcentrateDrop);
	}
	
	@Override
    public boolean hasSearchBar()
    {
        return true;
    }
	
	@Override
    public int getSearchbarWidth()
    {
        return 70;
    }

}
