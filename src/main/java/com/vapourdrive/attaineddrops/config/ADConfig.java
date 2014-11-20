package com.vapourdrive.attaineddrops.config;

import java.io.File;

import net.minecraft.util.StatCollector;
import net.minecraftforge.common.config.Configuration;

import com.vapourdrive.attaineddrops.blocks.BlockInfo;

public class ADConfig
{

	public static Configuration config;

	private static final String CATEGORY_BLOCKUPDATES = "Block Updates";

	/*
	 * prints config options get posted to attaineddrops.cfg in here players can
	 * set options for gameplay, tailoring it to their style
	 */
	public static void init(File adConfig)
	{
		config = new Configuration(adConfig);

		System.out.println("[Attained Drops]Loading config for Attained Drops");

		config.load();

		// Block Update times
		BlockInfo.BlockMobPlantUpdate = config.getInt(BlockInfo.BlockMobPlantUpdateName, CATEGORY_BLOCKUPDATES,
				BlockInfo.BlockMobPlantUpdateDefault, BlockInfo.BlockMobPlantUpdateMin, BlockInfo.BlockMobPlantUpdateMax,
				StatCollector.translateToLocal("phrase.AttainedDrops.BlockMobPlantUpdateComment"));

		BlockInfo.BlockConcentrateDropUpate = config.getInt(BlockInfo.BlockConcentrateDropUpdateName, CATEGORY_BLOCKUPDATES,
				BlockInfo.BlockConcentrateDropUpateDefault, BlockInfo.BlockMobPlantUpdateMin, BlockInfo.BlockMobPlantUpdateMax,
				StatCollector.translateToLocal("phrase.AttainedDrops.BlockMobConcetrateDropComment"));
		
		config.save();

	}

}
