package com.vapourdrive.attaineddrops.config;

import java.io.File;

import com.vapourdrive.attaineddrops.blocks.BlockInfo;

import net.minecraft.util.StatCollector;
import net.minecraftforge.common.config.Configuration;

public class ADConfig
{

	public static Configuration config;

	private static final String CATEGORY_BLOCKUPDATES = "Block Updates";
	private static final String CATEGORY_BLOCKOPTIONS = "Block Options";

	public static void init(File adConfig)
	{
		config = new Configuration(adConfig);

		config.load();
		System.out.println("[Attained Drops]Generating config for Attained Drops");

		// Block Update times
		BlockInfo.BlockMobPlantUpdate = config.getInt(BlockInfo.BlockMobPlantUpdateName, CATEGORY_BLOCKUPDATES,
				BlockInfo.BlockMobPlantUpdateDefault, BlockInfo.BlockMobPlantUpdateMin, BlockInfo.BlockMobPlantUpdateMax,
				StatCollector.translateToLocal("phrase.AttainedDrops.BlockMobPlantUpdateComment"));

		BlockInfo.BlockMobDirtReset = config.getInt(BlockInfo.BlockModDirtResetName, CATEGORY_BLOCKUPDATES,
				BlockInfo.BlockMobDirtResetDefault, BlockInfo.BlockMobPlantUpdateMin, BlockInfo.BlockMobPlantUpdateMax,
				StatCollector.translateToLocal("phrase.AttainedDrops.BlockMobDirtResetComment"));

		BlockInfo.BlockConcentrateDropUpate = config.getInt(BlockInfo.BlockConcentrateDropName, CATEGORY_BLOCKUPDATES,
				BlockInfo.BlockConcentrateDropUpateDefault, BlockInfo.BlockMobPlantUpdateMin, BlockInfo.BlockMobPlantUpdateMax,
				StatCollector.translateToLocal("phrase.AttainedDrops.BlockMobDirtResetComment"));

		BlockInfo.CanBulbBonemeal = config.getBoolean(BlockInfo.CanBulbBonemealName, CATEGORY_BLOCKOPTIONS,
				BlockInfo.CanBulbBonemealDefault, StatCollector.translateToLocal("phrase.AttainedDrops.CanBulbBonemealComment"));

		BlockInfo.ChancetoBonemealBulb = config.getInt(BlockInfo.ChancetoBonemealBulbName, CATEGORY_BLOCKOPTIONS,
				BlockInfo.ChancetoBonemealBulbDefault, BlockInfo.BlockMobPlantUpdateMin, BlockInfo.ChancetoBonemealBulbMax,
				StatCollector.translateToLocal("phrase.AttainedDrops.ChancetoBonemealBulbComment"));

		config.save();

	}

}
