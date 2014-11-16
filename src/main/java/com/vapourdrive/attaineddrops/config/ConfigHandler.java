package com.vapourdrive.attaineddrops.config;

import java.io.File;

public class ConfigHandler
{

	public static File adConfig;
	public static File bulbConfig;

	public static void init(String configPath)
	{
		adConfig = new File(configPath + "attaineddrops.cfg");
		bulbConfig = new File(configPath + "bulbsettings.cfg");

		ADConfig.init(adConfig);
		ADBulbConfig.init(bulbConfig);

	}

}
