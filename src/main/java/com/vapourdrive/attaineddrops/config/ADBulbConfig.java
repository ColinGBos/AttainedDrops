package com.vapourdrive.attaineddrops.config;

import java.io.File;

import com.vapourdrive.attaineddrops.blocks.BlockInfo;

import net.minecraft.item.ItemStack;
import net.minecraftforge.common.config.Configuration;

public class ADBulbConfig
{
	public static Configuration config;

	private static final String BULB_ENABLING = "Bulb Enabling";
	private static final String XP_USE = "XP Consumption";

	public static void init(File bulbConfig)
	{
		config = new Configuration(bulbConfig);

		System.out.println("[Attained Drops]Loading config for Attained Drops");

		config.load();
		
		config.addCustomCategoryComment(BULB_ENABLING, "You can enable all bulbs individually here");
		config.addCustomCategoryComment(XP_USE, "You can set the various xp consumptions per soil enrichment");

		BulbInfo.EnabledBulbs0 = config.get(BULB_ENABLING, "Enable " + getItemName(0) + " Bulb", BulbInfo.EnabledBulbsDefault);
		BulbInfo.EnabledBulbs1 = config.get(BULB_ENABLING, "Enable " + getItemName(1) + " Bulb", BulbInfo.EnabledBulbsDefault);
		BulbInfo.EnabledBulbs2 = config.get(BULB_ENABLING, "Enable " + getItemName(2) + " Bulb", BulbInfo.EnabledBulbsDefault);
		BulbInfo.EnabledBulbs3 = config.get(BULB_ENABLING, "Enable " + getItemName(3) + " Bulb", BulbInfo.EnabledBulbsDefault);
		BulbInfo.EnabledBulbs4 = config.get(BULB_ENABLING, "Enable " + getItemName(4) + " Bulb", BulbInfo.EnabledBulbsDefault);
		BulbInfo.EnabledBulbs5 = config.get(BULB_ENABLING, "Enable " + getItemName(5) + " Bulb", BulbInfo.EnabledBulbsDefault);
		BulbInfo.EnabledBulbs6 = config.get(BULB_ENABLING, "Enable " + getItemName(6) + " Bulb", BulbInfo.EnabledBulbsDefault);
		BulbInfo.EnabledBulbs7 = config.get(BULB_ENABLING, "Enable " + getItemName(7) + " Bulb", BulbInfo.EnabledBulbsDefault);
		BulbInfo.EnabledBulbs8 = config.get(BULB_ENABLING, "Enable " + getItemName(8) + " Bulb", BulbInfo.EnabledBulbsDefault);

		BulbInfo.XPUse0 = config.get(XP_USE, getItemName(0) + " Enrichment XP Consumption", BulbInfo.xpUseDefault);
		BulbInfo.XPUse1 = config.get(XP_USE, getItemName(1) + " Enrichment XP Consumption", BulbInfo.xpUseDefault);
		BulbInfo.XPUse2 = config.get(XP_USE, getItemName(2) + " Enrichment XP Consumption", BulbInfo.xpUseDefault);
		BulbInfo.XPUse3 = config.get(XP_USE, getItemName(3) + " Enrichment XP Consumption", BulbInfo.xpUseDefault);
		BulbInfo.XPUse4 = config.get(XP_USE, getItemName(4) + " Enrichment XP Consumption", BulbInfo.xpUseDefault);
		BulbInfo.XPUse5 = config.get(XP_USE, getItemName(5) + " Enrichment XP Consumption", BulbInfo.xpUseDefault);
		BulbInfo.XPUse6 = config.get(XP_USE, getItemName(6) + " Enrichment XP Consumption", BulbInfo.xpUseDefault);
		BulbInfo.XPUse7 = config.get(XP_USE, getItemName(7) + " Enrichment XP Consumption", BulbInfo.xpUseDefault);
		BulbInfo.XPUse8 = config.get(XP_USE, getItemName(8) + " Enrichment XP Consumption", BulbInfo.xpUseDefault);



		config.save();
	}

	public static String getItemName(int runthrough)
	{
		String string = BlockInfo.MobDrops[runthrough].getItemStackDisplayName(new ItemStack(BlockInfo.MobDrops[runthrough]));
		return string;
	}
}
