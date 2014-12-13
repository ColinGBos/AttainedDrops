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

public class ItemVitalizedSoil extends ItemBlock
{

	public ItemVitalizedSoil(Block block)
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
			list.add("Surround with dirt or grass");
			list.add("Plants Vitalized soil overtime");
			list.add("Eventually may turn to dirt");
		}
		else
		{
			list.add(EnumChatFormatting.GRAY + "Hold Shift");
		}
	}
}
