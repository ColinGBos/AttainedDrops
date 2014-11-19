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
	private static final String SPROUT_CHANCES = "Bulb Sprout Rate";

	public static void init(File bulbConfig)
	{
		config = new Configuration(bulbConfig);
		System.out.println("[Attained Drops]Loading config for Attained Drops");

		config.load();
		
		config.addCustomCategoryComment(BULB_ENABLING, "You can enable all bulbs individually here.");
		config.addCustomCategoryComment(XP_USE, "You can set the various xp consumptions per soil enrichment.\n"
				+ "If you leave it set to 0 you will not need experience to enrich the soil at all.\n"
				+ "If set to a number greater than 0 you will need to have that number of levels to\n"
				+ "perform the action of enriching the soil.");
		config.addCustomCategoryComment(SPROUT_CHANCES, "You can set the growth rates for the bulbs here.\n"
				+ "There is a 1 in x chance that the bulb will sprout on a given block update.\n"
				+ "The higher the value of x, the less likely a bulb is going to sprout.\n"
				+ "Growth time is proportionate to x.");

		BulbInfo.EnabledBulbs0 = config.get(BULB_ENABLING, "Enable " + getItemName(0) + " Bulb", BulbInfo.EnabledBulbsDefault);
		BulbInfo.EnabledBulbs1 = config.get(BULB_ENABLING, "Enable " + getItemName(1) + " Bulb", BulbInfo.EnabledBulbsDefault);
		BulbInfo.EnabledBulbs2 = config.get(BULB_ENABLING, "Enable " + getItemName(2) + " Bulb", BulbInfo.EnabledBulbsDefault);
		BulbInfo.EnabledBulbs3 = config.get(BULB_ENABLING, "Enable " + getItemName(3) + " Bulb", BulbInfo.EnabledBulbsDefault);
		BulbInfo.EnabledBulbs4 = config.get(BULB_ENABLING, "Enable " + getItemName(4) + " Bulb", BulbInfo.EnabledBulbsDefault);
		BulbInfo.EnabledBulbs5 = config.get(BULB_ENABLING, "Enable " + getItemName(5) + " Bulb", BulbInfo.EnabledBulbsDefault);
		BulbInfo.EnabledBulbs6 = config.get(BULB_ENABLING, "Enable " + getItemName(6) + " Bulb", BulbInfo.EnabledBulbsDefault);
		BulbInfo.EnabledBulbs7 = config.get(BULB_ENABLING, "Enable " + getItemName(7) + " Bulb", BulbInfo.EnabledBulbsDefault);
		BulbInfo.EnabledBulbs8 = config.get(BULB_ENABLING, "Enable " + getItemName(8) + " Bulb", BulbInfo.EnabledBulbsDefault);

		BulbInfo.XPUse0 = config.get(XP_USE, getItemName(0) + " Enrichment XP Consumption", BulbInfo.xpUseDefault, "", 0, 100);
		BulbInfo.XPUse1 = config.get(XP_USE, getItemName(1) + " Enrichment XP Consumption", BulbInfo.xpUseDefault, "", 0, 100);
		BulbInfo.XPUse2 = config.get(XP_USE, getItemName(2) + " Enrichment XP Consumption", BulbInfo.xpUseDefault, "", 0, 100);
		BulbInfo.XPUse3 = config.get(XP_USE, getItemName(3) + " Enrichment XP Consumption", BulbInfo.xpUseDefault, "", 0, 100);
		BulbInfo.XPUse4 = config.get(XP_USE, getItemName(4) + " Enrichment XP Consumption", BulbInfo.xpUseDefault, "", 0, 100);
		BulbInfo.XPUse5 = config.get(XP_USE, getItemName(5) + " Enrichment XP Consumption", BulbInfo.xpUseDefault, "", 0, 100);
		BulbInfo.XPUse6 = config.get(XP_USE, getItemName(6) + " Enrichment XP Consumption", BulbInfo.xpUseDefault, "", 0, 100);
		BulbInfo.XPUse7 = config.get(XP_USE, getItemName(7) + " Enrichment XP Consumption", BulbInfo.xpUseDefault, "", 0, 100);
		BulbInfo.XPUse8 = config.get(XP_USE, getItemName(8) + " Enrichment XP Consumption", BulbInfo.xpUseDefault, "", 0, 100);

		BulbInfo.SproutChance0 = config.get(SPROUT_CHANCES, getItemName(0) + " Growth Rate", BulbInfo.sproutRateDefault, "", 1, 100);
		BulbInfo.SproutChance1 = config.get(SPROUT_CHANCES, getItemName(1) + " Growth Rate", BulbInfo.sproutRateDefault, "", 1, 100);
		BulbInfo.SproutChance2 = config.get(SPROUT_CHANCES, getItemName(2) + " Growth Rate", BulbInfo.sproutRateDefault, "", 1, 100);
		BulbInfo.SproutChance3 = config.get(SPROUT_CHANCES, getItemName(3) + " Growth Rate", BulbInfo.sproutRateDefault, "", 1, 100);
		BulbInfo.SproutChance4 = config.get(SPROUT_CHANCES, getItemName(4) + " Growth Rate", BulbInfo.sproutRateDefault, "", 1, 100);
		BulbInfo.SproutChance5 = config.get(SPROUT_CHANCES, getItemName(5) + " Growth Rate", BulbInfo.sproutRateDefault, "", 1, 100);
		BulbInfo.SproutChance6 = config.get(SPROUT_CHANCES, getItemName(6) + " Growth Rate", BulbInfo.sproutRateDefault, "", 1, 100);
		BulbInfo.SproutChance7 = config.get(SPROUT_CHANCES, getItemName(7) + " Growth Rate", BulbInfo.sproutRateDefault, "", 1, 100);
		BulbInfo.SproutChance8 = config.get(SPROUT_CHANCES, getItemName(8) + " Growth Rate", BulbInfo.sproutRateDefault, "", 1, 100);

		config.save();
	}

	public static String getItemName(int runthrough)
	{
		String string = BlockInfo.MobDrops[runthrough].getItemStackDisplayName(new ItemStack(BlockInfo.MobDrops[runthrough]));
		return string;
	}
}
