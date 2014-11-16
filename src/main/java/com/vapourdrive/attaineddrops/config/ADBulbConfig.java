package com.vapourdrive.attaineddrops.config;

import java.io.File;

import net.minecraft.util.StatCollector;
import net.minecraftforge.common.config.Configuration;

public class ADBulbConfig
{
	public static Configuration config;

	private static final String CATEGORY_BULB_ITEM_ENABLING = "Bulb Enabling";

	public static void init(File bulbConfig)
	{
		config = new Configuration(bulbConfig);

		System.out.println("[Attained Drops]Loading config for Attained Drops");

		config.load();

		BulbInfo.EnabledBulbs = config.get(CATEGORY_BULB_ITEM_ENABLING, BulbInfo.EnabledBulbsName, BulbInfo.EnabledBulbsDefault,
				StatCollector.translateToLocal("phrase.AttainedDrops.BulbEnablingComment"), BulbInfo.isBulbEnablingFixedLength,
				BulbInfo.EnabledBulbsMaxLength);

		config.save();
	}
}
