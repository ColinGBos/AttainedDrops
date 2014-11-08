package com.vapourdrive.attaineddrops.config;

import java.io.File;

import net.minecraft.util.StatCollector;
import net.minecraftforge.common.config.Configuration;

import com.vapourdrive.attaineddrops.blocks.BlockInfo;

public class ADConfig
{

	public static Configuration config;

	private static final String CATEGORY_BLOCKUPDATES = "Block Updates";
	private static final String CATEGORY_BLOCKOPTIONS = "Block Options";
	private static final String CATEGORY_XP = "XP Consumption Options";

	/*
	 * prints config options get posted to attaineddrops.cfg in here players can
	 * set options for gameplay, tailoring it to their style
	 */
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

		BlockInfo.BlockConcentrateDropUpate = config.getInt(BlockInfo.BlockConcentrateDropUpdateName, CATEGORY_BLOCKUPDATES,
				BlockInfo.BlockConcentrateDropUpateDefault, BlockInfo.BlockMobPlantUpdateMin, BlockInfo.BlockMobPlantUpdateMax,
				StatCollector.translateToLocal("phrase.AttainedDrops.BlockMobConcetrateDropComment"));

		// Block Options
		BlockInfo.CanBulbBonemeal = config.getBoolean(BlockInfo.CanBulbBonemealName, CATEGORY_BLOCKOPTIONS,
				BlockInfo.CanBulbBonemealDefault, StatCollector.translateToLocal("phrase.AttainedDrops.CanBulbBonemealComment"));

		BlockInfo.ParticleBulb = config.getBoolean(BlockInfo.ParticleBulbName, CATEGORY_BLOCKOPTIONS, BlockInfo.ParticleBulbDefault,
				StatCollector.translateToLocal("phrase.AttainedDrops.CanBulbParticleComment"));

		BlockInfo.ChancetoBonemealBulb = config.getInt(BlockInfo.ChancetoBonemealBulbName, CATEGORY_BLOCKOPTIONS,
				BlockInfo.ChancetoBonemealBulbDefault, BlockInfo.BlockMobPlantUpdateMin, BlockInfo.ChancetoBonemealBulbMax,
				StatCollector.translateToLocal("phrase.AttainedDrops.ChancetoBonemealBulbComment"));

		BlockInfo.CanFortuneBulb = config.getBoolean(BlockInfo.CanFortuneBulbName, CATEGORY_BLOCKOPTIONS, BlockInfo.CanFortuneBulbDefault,
				StatCollector.translateToLocal("phrase.AttainedDrops.CanFortuneBulbComment"));

		BlockInfo.BulbStaticDropNumber = config.getInt(BlockInfo.BulbStaticDropNumberName, CATEGORY_BLOCKOPTIONS,
				BlockInfo.BulbStaticDropNumberDefault, BlockInfo.BulbStaticDropNumberMin, BlockInfo.BulbStaticDropNumberMax,
				StatCollector.translateToLocal("phrase.AttainedDrops.BulbStaticDropNumberComment"));

		BlockInfo.BulbDynamicDropNumber = config.getInt(BlockInfo.BulbDynamicDropNumberName, CATEGORY_BLOCKOPTIONS,
				BlockInfo.BulbDynamicDropNumberDefault, BlockInfo.BulbDynamicDropNumberMin, BlockInfo.BulbDynamicDropNumberMax,
				StatCollector.translateToLocal("phrase.AttainedDrops.BulbDynamicDropNumberComment"));

		BlockInfo.ChancetoParticle = config.getInt(BlockInfo.ChancetoParticleName, CATEGORY_BLOCKOPTIONS,
				BlockInfo.ChancetoParticleDefault, BlockInfo.BlockMobPlantUpdateMin, BlockInfo.ChancetoParticleMax,
				StatCollector.translateToLocal("phrase.AttainedDrops.ChancetoParticleComment"));

		BlockInfo.EnrichXpUse = config.getInt(BlockInfo.EnrichXpUseName, CATEGORY_XP, BlockInfo.EnrichXpUseDefault,
				BlockInfo.EnrichXpUseMin, BlockInfo.EnrichXpUseMax,
				StatCollector.translateToLocal("phrase.AttainedDrops.EnrichXpUseComment"));

		config.save();

	}

}
