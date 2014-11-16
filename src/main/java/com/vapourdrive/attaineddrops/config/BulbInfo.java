package com.vapourdrive.attaineddrops.config;

import net.minecraftforge.common.config.Property;

public class BulbInfo
{
	public static String EnabledBulbsName = "Enabling Bulbs";
	public static Property EnabledBulbs;
	public static boolean isBulbEnablingFixedLength = true;
	public static boolean[] EnabledBulbsDefault =
	{ true, true, true, true, true, true, true, true, true };
	public static int EnabledBulbsMaxLength = 9;
}
