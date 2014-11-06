package com.vapourdrive.attaineddrops.items;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.vapourdrive.attaineddrops.AttainedDrops;
import com.vapourdrive.attaineddrops.blocks.AD_Blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemPlantSeed extends Item
{
	public ItemPlantSeed()
	{
		super();
		setCreativeTab(AttainedDrops.tabAttainedDrops);
		this.setUnlocalizedName(ItemInfo.PlantSeedUnlocalizedName);
	}

	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float par8, float par9,
			float par10)
	{
		if (world.getBlock(x, y, z) == AD_Blocks.BlockMobDirt && world.isAirBlock(x, y + 1, z))
		{
			if (player.canPlayerEdit(x, y, z, side, stack) && side == 1)
				world.setBlock(x, y + 1, z, AD_Blocks.BlockMobPlant);
			--stack.stackSize;
			return true;
		}

		else
		{
			return false;
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister register)
	{
		itemIcon = register.registerIcon(ItemInfo.TextureLocation + ItemInfo.PlantSeedIcon);
	}
}
