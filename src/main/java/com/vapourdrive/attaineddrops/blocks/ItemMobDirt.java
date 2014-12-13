package com.vapourdrive.attaineddrops.blocks;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemMobDirt extends ItemBlock
{

	public ItemMobDirt(Block block)
	{
		super(block);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean useExtraInformation)
	{
		if (Keyboard.isKeyDown(Keyboard.KEY_LSHIFT) || Keyboard.isKeyDown(Keyboard.KEY_RSHIFT))
		{
			list.add("");
			list.add("Right click with enabled drop to enrich");
			list.add("Enabled Items:");
			printItems(list);
		}
		else
		{
			list.add(EnumChatFormatting.GRAY + "Hold Shift");
		}
	}

	public static void printItems(List list)
	{
		String string = "";
		for (int i = 0; i < 4; i++)
		{
			if (BulbHelper.isDropEnabled(i))
			{
				string = string + BlockInfo.MobDrops[i].getItemStackDisplayName(new ItemStack(BlockInfo.MobDrops[i])) + ", ";
			}
		}
		list.add(EnumChatFormatting.GREEN + string);
		string = "";
		for (int i = 4; i < BlockInfo.MobDrops.length; i++)
		{
			if (BulbHelper.isDropEnabled(i))
			{
				string = string + BlockInfo.MobDrops[i].getItemStackDisplayName(new ItemStack(BlockInfo.MobDrops[i])) + ", ";
			}
		}
		list.add(EnumChatFormatting.GREEN + string);
		return;
	}

}
