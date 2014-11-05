package com.vapourdrive.attaineddrops.config;

import java.io.File;

public class ConfigHandler
{

	public static File adConfig;
	
	public static void init(String configPath)
	{
        adConfig = new File(configPath + "attaineddrops.cfg");
        
        ADConfig.init(adConfig);
		
	}

}
