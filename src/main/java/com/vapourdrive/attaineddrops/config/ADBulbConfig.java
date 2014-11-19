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
	private static final String UNENRICH_CHANCES = "Soil Un-enrich Chance";
	private static final String UNENRICH_ENABLING = "Soil Un-enrich Enabling";
	private static final String BONE_MEAL_ENABLE = "Bulb Sprout From Bonemeal";
	private static final String BONE_MEAL_CHANCE = "Chance for Bonemealed Bulb";
	private static final String STATIC_DROP_NUMBER = "Drop Number - Base";
	private static final String DYNAMIC_DROP_NUMBER = "Drop Number - Bonus";

	public static void init(File bulbConfig)
	{
		config = new Configuration(bulbConfig);
		System.out.println("[Attained Drops]Loading config for Attained Drops");

		config.load();

		config.addCustomCategoryComment(BULB_ENABLING, "You can enable/disable all bulbs individually here.");
		config.addCustomCategoryComment(XP_USE, "You can set the various xp consumptions per soil enrichment.\n"
				+ "If you leave it set to 0 you will not need experience to enrich the soil at all.\n"
				+ "If set to a number greater than 0 you will need to have that number of levels to\n"
				+ "perform the action of enriching the soil.");
		config.addCustomCategoryComment(SPROUT_CHANCES, "You can set the growth rates for the bulbs here.\n"
				+ "There is a 1 in x chance that the bulb will sprout on a given block update.\n"
				+ "The higher the value of x, the less likely a bulb is going to sprout.\n" + "Growth time is proportionate to x.");
		config.addCustomCategoryComment(UNENRICH_CHANCES, "You can set the chance that the soil will lose it's enrichment.\n"
				+ "There is a 1 in x chance that the dirt will lose its enrichment when a bulb sprouts\n"
				+ "The higher you set this, the less likely you will need to re-enrich the soil");
		config.addCustomCategoryComment(UNENRICH_ENABLING, "You can enable/disable the vitalized soil reset completely per bulb");
		config.addCustomCategoryComment(BONE_MEAL_ENABLE, "You can enable/disable the production of a bulb from bonemealing the plant");
		config.addCustomCategoryComment(BONE_MEAL_CHANCE, "You can set the chance that the bonemeal will cause a bulb sprout.\n"
				+ "There is a 1 in x chance that the bonemeal will succesfully cause a bulb to sprout\n"
				+ "The higher you set this, the less likely a bonemeal attempt will work");
		config.addCustomCategoryComment(STATIC_DROP_NUMBER, "This is the gauranteed base drop number for each bulb.");
		config.addCustomCategoryComment(DYNAMIC_DROP_NUMBER, "This is the random bonus drop max number.\n"
				+ "The bulb will drop an additional random number between 0 and x (not including x).\n"
				+ "eg. If you want there to be a chance for up to 3 extra set to 4.");

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

		BulbInfo.SoilUnEnrich0 = config.get(UNENRICH_CHANCES, "Soil Un-Enrich Chance For " + getItemName(0), BulbInfo.soilUnEnrichDefault, "", 1, 1000);
		BulbInfo.SoilUnEnrich1 = config.get(UNENRICH_CHANCES, "Soil Un-Enrich Chance For " + getItemName(1), BulbInfo.soilUnEnrichDefault, "", 1, 1000);
		BulbInfo.SoilUnEnrich2 = config.get(UNENRICH_CHANCES, "Soil Un-Enrich Chance For " + getItemName(2), BulbInfo.soilUnEnrichDefault, "", 1, 1000);
		BulbInfo.SoilUnEnrich3 = config.get(UNENRICH_CHANCES, "Soil Un-Enrich Chance For " + getItemName(3), BulbInfo.soilUnEnrichDefault, "", 1, 1000);
		BulbInfo.SoilUnEnrich4 = config.get(UNENRICH_CHANCES, "Soil Un-Enrich Chance For " + getItemName(4), BulbInfo.soilUnEnrichDefault, "", 1, 1000);
		BulbInfo.SoilUnEnrich5 = config.get(UNENRICH_CHANCES, "Soil Un-Enrich Chance For " + getItemName(5), BulbInfo.soilUnEnrichDefault, "", 1, 1000);
		BulbInfo.SoilUnEnrich6 = config.get(UNENRICH_CHANCES, "Soil Un-Enrich Chance For " + getItemName(6), BulbInfo.soilUnEnrichDefault, "", 1, 1000);
		BulbInfo.SoilUnEnrich7 = config.get(UNENRICH_CHANCES, "Soil Un-Enrich Chance For " + getItemName(7), BulbInfo.soilUnEnrichDefault, "", 1, 1000);
		BulbInfo.SoilUnEnrich8 = config.get(UNENRICH_CHANCES, "Soil Un-Enrich Chance For " + getItemName(8), BulbInfo.soilUnEnrichDefault, "", 1, 1000);

		BulbInfo.SoilCanUnEnrich0 = config
				.get(UNENRICH_ENABLING, "Enable Soil Reset For" + getItemName(0), BulbInfo.EnableSoilResetDefault);
		BulbInfo.SoilCanUnEnrich1 = config
				.get(UNENRICH_ENABLING, "Enable Soil Reset For" + getItemName(1), BulbInfo.EnableSoilResetDefault);
		BulbInfo.SoilCanUnEnrich2 = config
				.get(UNENRICH_ENABLING, "Enable Soil Reset For" + getItemName(2), BulbInfo.EnableSoilResetDefault);
		BulbInfo.SoilCanUnEnrich3 = config
				.get(UNENRICH_ENABLING, "Enable Soil Reset For" + getItemName(3), BulbInfo.EnableSoilResetDefault);
		BulbInfo.SoilCanUnEnrich4 = config
				.get(UNENRICH_ENABLING, "Enable Soil Reset For" + getItemName(4), BulbInfo.EnableSoilResetDefault);
		BulbInfo.SoilCanUnEnrich5 = config
				.get(UNENRICH_ENABLING, "Enable Soil Reset For" + getItemName(5), BulbInfo.EnableSoilResetDefault);
		BulbInfo.SoilCanUnEnrich6 = config
				.get(UNENRICH_ENABLING, "Enable Soil Reset For" + getItemName(6), BulbInfo.EnableSoilResetDefault);
		BulbInfo.SoilCanUnEnrich7 = config
				.get(UNENRICH_ENABLING, "Enable Soil Reset For" + getItemName(7), BulbInfo.EnableSoilResetDefault);
		BulbInfo.SoilCanUnEnrich8 = config
				.get(UNENRICH_ENABLING, "Enable Soil Reset For" + getItemName(8), BulbInfo.EnableSoilResetDefault);

		BulbInfo.EnableBonemealBulb0 = config.get(BONE_MEAL_ENABLE, "Can Bonemeal Sprout" + getItemName(0) + " Bulb",
				BulbInfo.EnableBonemealBulbDefault);
		BulbInfo.EnableBonemealBulb1 = config.get(BONE_MEAL_ENABLE, "Can Bonemeal Sprout" + getItemName(1) + " Bulb",
				BulbInfo.EnableBonemealBulbDefault);
		BulbInfo.EnableBonemealBulb2 = config.get(BONE_MEAL_ENABLE, "Can Bonemeal Sprout" + getItemName(2) + " Bulb",
				BulbInfo.EnableBonemealBulbDefault);
		BulbInfo.EnableBonemealBulb3 = config.get(BONE_MEAL_ENABLE, "Can Bonemeal Sprout" + getItemName(3) + " Bulb",
				BulbInfo.EnableBonemealBulbDefault);
		BulbInfo.EnableBonemealBulb4 = config.get(BONE_MEAL_ENABLE, "Can Bonemeal Sprout" + getItemName(4) + " Bulb",
				BulbInfo.EnableBonemealBulbDefault);
		BulbInfo.EnableBonemealBulb5 = config.get(BONE_MEAL_ENABLE, "Can Bonemeal Sprout" + getItemName(5) + " Bulb",
				BulbInfo.EnableBonemealBulbDefault);
		BulbInfo.EnableBonemealBulb6 = config.get(BONE_MEAL_ENABLE, "Can Bonemeal Sprout" + getItemName(6) + " Bulb",
				BulbInfo.EnableBonemealBulbDefault);
		BulbInfo.EnableBonemealBulb7 = config.get(BONE_MEAL_ENABLE, "Can Bonemeal Sprout" + getItemName(7) + " Bulb",
				BulbInfo.EnableBonemealBulbDefault);
		BulbInfo.EnableBonemealBulb8 = config.get(BONE_MEAL_ENABLE, "Can Bonemeal Sprout" + getItemName(8) + " Bulb",
				BulbInfo.EnableBonemealBulbDefault);

		BulbInfo.BonemealChance0 = config.get(BONE_MEAL_CHANCE, "Bonemeal Chance For " + getItemName(0) + " Bulb", BulbInfo.chanceToBonemealDefault,
				"", 1, 1000);
		BulbInfo.BonemealChance1 = config.get(BONE_MEAL_CHANCE, "Bonemeal Chance For " + getItemName(1) + " Bulb", BulbInfo.chanceToBonemealDefault,
				"", 1, 1000);
		BulbInfo.BonemealChance2 = config.get(BONE_MEAL_CHANCE, "Bonemeal Chance For " + getItemName(2) + " Bulb", BulbInfo.chanceToBonemealDefault,
				"", 1, 1000);
		BulbInfo.BonemealChance3 = config.get(BONE_MEAL_CHANCE, "Bonemeal Chance For " + getItemName(3) + " Bulb", BulbInfo.chanceToBonemealDefault,
				"", 1, 1000);
		BulbInfo.BonemealChance4 = config.get(BONE_MEAL_CHANCE, "Bonemeal Chance For " + getItemName(4) + " Bulb", BulbInfo.chanceToBonemealDefault,
				"", 1, 1000);
		BulbInfo.BonemealChance5 = config.get(BONE_MEAL_CHANCE, "Bonemeal Chance For " + getItemName(5) + " Bulb", BulbInfo.chanceToBonemealDefault,
				"", 1, 1000);
		BulbInfo.BonemealChance6 = config.get(BONE_MEAL_CHANCE, "Bonemeal Chance For " + getItemName(6) + " Bulb", BulbInfo.chanceToBonemealDefault,
				"", 1, 1000);
		BulbInfo.BonemealChance7 = config.get(BONE_MEAL_CHANCE, "Bonemeal Chance For " + getItemName(7) + " Bulb", BulbInfo.chanceToBonemealDefault,
				"", 1, 1000);
		BulbInfo.BonemealChance8 = config.get(BONE_MEAL_CHANCE, "Bonemeal Chance For " + getItemName(8) + " Bulb", BulbInfo.chanceToBonemealDefault,
				"", 1, 1000);

		BulbInfo.StaticDrop0 = config.get(STATIC_DROP_NUMBER, "Base Drop For " + getItemName(0) + " Bulb", BulbInfo.StaticDropDefault, "", 0, 100);
		BulbInfo.StaticDrop1 = config.get(STATIC_DROP_NUMBER, "Base Drop For " + getItemName(1) + " Bulb", BulbInfo.StaticDropDefault, "", 0, 100);
		BulbInfo.StaticDrop2 = config.get(STATIC_DROP_NUMBER, "Base Drop For " + getItemName(2) + " Bulb", BulbInfo.StaticDropDefault, "", 0, 100);
		BulbInfo.StaticDrop3 = config.get(STATIC_DROP_NUMBER, "Base Drop For " + getItemName(3) + " Bulb", BulbInfo.StaticDropDefault, "", 0, 100);
		BulbInfo.StaticDrop4 = config.get(STATIC_DROP_NUMBER, "Base Drop For " + getItemName(4) + " Bulb", BulbInfo.StaticDropDefault, "", 0, 100);
		BulbInfo.StaticDrop5 = config.get(STATIC_DROP_NUMBER, "Base Drop For " + getItemName(5) + " Bulb", BulbInfo.StaticDropDefault, "", 0, 100);
		BulbInfo.StaticDrop6 = config.get(STATIC_DROP_NUMBER, "Base Drop For " + getItemName(6) + " Bulb", BulbInfo.StaticDropDefault, "", 0, 100);
		BulbInfo.StaticDrop7 = config.get(STATIC_DROP_NUMBER, "Base Drop For " + getItemName(7) + " Bulb", BulbInfo.StaticDropDefault, "", 0, 100);
		BulbInfo.StaticDrop8 = config.get(STATIC_DROP_NUMBER, "Base Drop For " + getItemName(8) + " Bulb", BulbInfo.StaticDropDefault, "", 0, 100);

		BulbInfo.DynamicDrop0 = config.get(DYNAMIC_DROP_NUMBER, "Bonus Drop For " + getItemName(0) + " Bulb", BulbInfo.DynamicDropDefault, "", 1, 100);
		BulbInfo.DynamicDrop1 = config.get(DYNAMIC_DROP_NUMBER, "Bonus Drop For " + getItemName(1) + " Bulb", BulbInfo.DynamicDropDefault, "", 1, 100);
		BulbInfo.DynamicDrop2 = config.get(DYNAMIC_DROP_NUMBER, "Bonus Drop For " + getItemName(2) + " Bulb", BulbInfo.DynamicDropDefault, "", 1, 100);
		BulbInfo.DynamicDrop3 = config.get(DYNAMIC_DROP_NUMBER, "Bonus Drop For " + getItemName(3) + " Bulb", BulbInfo.DynamicDropDefault, "", 1, 100);
		BulbInfo.DynamicDrop4 = config.get(DYNAMIC_DROP_NUMBER, "Bonus Drop For " + getItemName(4) + " Bulb", BulbInfo.DynamicDropDefault, "", 1, 100);
		BulbInfo.DynamicDrop5 = config.get(DYNAMIC_DROP_NUMBER, "Bonus Drop For " + getItemName(5) + " Bulb", BulbInfo.DynamicDropDefault, "", 1, 100);
		BulbInfo.DynamicDrop6 = config.get(DYNAMIC_DROP_NUMBER, "Bonus Drop For " + getItemName(6) + " Bulb", BulbInfo.DynamicDropDefault, "", 1, 100);
		BulbInfo.DynamicDrop7 = config.get(DYNAMIC_DROP_NUMBER, "Bonus Drop For " + getItemName(7) + " Bulb", BulbInfo.DynamicDropDefault, "", 1, 100);
		BulbInfo.DynamicDrop8 = config.get(DYNAMIC_DROP_NUMBER, "Bonus Drop For " + getItemName(8) + " Bulb", BulbInfo.DynamicDropDefault, "", 1, 100);

		
		config.save();
	}

	public static String getItemName(int runthrough)
	{
		String string = BlockInfo.MobDrops[runthrough].getItemStackDisplayName(new ItemStack(BlockInfo.MobDrops[runthrough]));
		return string;
	}
}
