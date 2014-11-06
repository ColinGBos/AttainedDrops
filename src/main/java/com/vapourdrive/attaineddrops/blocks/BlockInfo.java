package com.vapourdrive.attaineddrops.blocks;

import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class BlockInfo
{
	public static Item[] MobDrops =
	{ null, Items.blaze_rod, Items.ender_pearl, Items.gunpowder, Items.bone, Items.spider_eye, Items.string, Items.ghast_tear,
			Items.rotten_flesh, Items.slime_ball };

	public static final String BlockIconLocation = "attaineddrops:";

	// Mob Dirt Block
	public static final String BlockMobDirtName = "blockMobDirt";
	public static final Float BlockMobDirtHardness = 0.8F;
	public static final String BlockMobDirtIcon = "blockMobDirt";
	public static final String BlockMobDirtSideIcon = "blockMobDirtSide";
	
	public static int BlockMobDirtResetDefault = 3;
	public static int BlockMobDirtReset;
	public static final String BlockModDirtResetKey = "BlockMobDirtResetKey";
	public static final String BlockModDirtResetName = "BlockMobDirtReset";

	// Bulb Block
	public static final String BlockMobBulbName = "blockMobBulb";
	public static final Float BlockMobBulbHardness = 0.3F;
	public static final String BlockMobBulbTopIcon = "blockMobBulbTop";
	public static final String BlockMobBulbSideIcon = "blockMobBulbSide";
	
	public static final String ChancetoParticleName = "ChancetoParticle";
	public static int ChancetoParticle;
	public static int ChancetoParticleDefault = 6;
	public static int ChancetoParticleMax = 100;
	
	public static boolean ParticleBulb;
	public static boolean ParticleBulbDefault = true;
	public static final String ParticleBulbName = "BulbParticles";

	// Plant Block
	public static int BlockMobPlantUpdateMin = 1;
	public static int BlockMobPlantUpdateMax = 1000;
	
	public static final String BlockMobPlantName = "blockMobPlant";
	public static final Float BlockMobPlantHardness = 0.2F;
	public static final String BlockMobPlantIcon = "mobDropPlant";
	
	public static boolean CanBulbBonemeal;
	public static boolean CanBulbBonemealDefault = false;
	public static final String CanBulbBonemealName = "CanBulbBonemeal";
	
	public static final String ChancetoBonemealBulbName = "ChanceToBonemealBulb";
	public static int ChancetoBonemealBulbDefault = 3;
	public static int ChancetoBonemealBulb;
	public static int ChancetoBonemealBulbMax = 100;

	public static int BlockMobPlantUpdate;
	public static int BlockMobPlantUpdateDefault = 20;
	public static String BlockMobPlantUpdatesKey = "BlockMobPlantUpdateKey";
	public static String BlockMobPlantUpdateName = "BlockMobPlantUpdate";
	
	//Vitalized Soil Planter
	public static final String BlockConcentrateDropName = "blockConcentrateDrop";
	public static final Float BlockConcentrateDropHardness = 0.8F;
	public static final String BlockConcentrateDropIcon = "blockConcentrateDrop";

	public static int BlockConcentrateDropUpateDefault = 5;
	public static int BlockConcentrateDropUpate;
	public static final String BlockConcentrateDropUpdateName = "VitalizedSoilUpdate";


}
