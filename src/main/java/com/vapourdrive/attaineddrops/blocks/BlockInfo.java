package com.vapourdrive.attaineddrops.blocks;

import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class BlockInfo
{
	public static Item[] MobDrops =
	{ Items.blaze_rod, Items.ender_pearl, Items.gunpowder, Items.bone, Items.spider_eye, Items.string, Items.ghast_tear,
			Items.rotten_flesh, Items.slime_ball };

	public static final String BlockIconLocation = "attaineddrops:";

	// Mob Dirt Block
	public static final String BlockMobDirtName = "blockMobDirt";
	public static final Float BlockMobDirtHardness = 0.8F;
	public static final String BlockMobDirtIcon = "blockMobDirt";
	public static final String BlockMobDirtSideIcon = "blockMobDirtSide";

	// Bulb Block
	public static final String BlockMobBulbName = "blockMobBulb";
	public static final Float BlockMobBulbHardness = 0.3F;
	public static final String BlockMobBulbTopIcon = "blockMobBulbTop";
	public static final String BlockMobBulbSideIcon = "blockMobBulbSide";

	// Plant Block
	public static int BlockMobPlantUpdateMin = 1;
	public static int BlockMobPlantUpdateMax = 1000;

	public static final String BlockMobPlantName = "blockMobPlant";
	public static final Float BlockMobPlantHardness = 0.2F;
	public static final String BlockMobPlantIcon = "mobDropPlant";

	public static int BlockMobPlantUpdate;
	public static int BlockMobPlantUpdateDefault = 20;
	public static String BlockMobPlantUpdatesKey = "BlockMobPlantUpdateKey";
	public static String BlockMobPlantUpdateName = "BlockMobPlantUpdate";

	// Vitalized Soil Planter
	public static final String BlockConcentrateDropName = "blockConcentrateDrop";
	public static final Float BlockConcentrateDropHardness = 0.8F;
	public static final String BlockConcentrateDropIcon = "blockConcentrateDrop";

	public static int BlockConcentrateDropUpateDefault = 5;
	public static int BlockConcentrateDropUpate;
	public static final String BlockConcentrateDropUpdateName = "VitalizedSoilUpdate";
	
	// XP Obelisk
	public static final String BlockXPObeliskName = "blockxpObelisk";
	public static final String BlockXPObeliskIcon = "xpObelisk";
	public static final String BlockXPObeliskIconTop = "xpObeliskTop";
	public static final Float BlockXPObeliskHardness = 5.0F;
	public static final int BlockXPObeliskLength = 9;
	
	// XP Ball
	public static final String BlockXPBallName = "blockxpBall";
	public static final String BlockXPBallTopIcon = "xpBallTop";
	public static final String BlockXPBallSideIcon = "xpBallSide";
	public static final Float BlockXPBallHardness = 2.0F;
	public static final Float BlockXPBallLight = 1.0F;

}
