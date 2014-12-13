package com.vapourdrive.attaineddrops.items;

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class AD_Items
{
	public static Item plantSeed;
//	public static Item lifeEssence;
//	public static Item xpWand;

	public static void init()
	{
		plantSeed = new ItemPlantSeed();
//		lifeEssence = new ItemLifeEssence();
//		xpWand = new ItemXPWand();

		GameRegistry.registerItem(plantSeed, ItemInfo.PlantSeedName);
//		GameRegistry.registerItem(lifeEssence, ItemInfo.LifeEssenceName);
//		GameRegistry.registerItem(xpWand, ItemInfo.XPWandName);

	}

	public static void registerRecipes()
	{
		GameRegistry.addShapelessRecipe(new ItemStack(plantSeed), new Object[]
		{ Items.apple, new ItemStack(Items.dye, 1, 15), Items.wheat_seeds });

	}

}
