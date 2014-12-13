package com.vapourdrive.attaineddrops;

import net.minecraft.creativetab.CreativeTabs;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.vapourdrive.attaineddrops.blocks.AD_Blocks;
import com.vapourdrive.attaineddrops.config.ConfigHandler;
import com.vapourdrive.attaineddrops.creativetabs.CreativeTabAD;
import com.vapourdrive.attaineddrops.items.AD_Items;
import com.vapourdrive.attaineddrops.materials.AD_Materials;
import com.vapourdrive.attaineddrops.oredict.OreDictionaryRegistry;
import com.vapourdrive.attaineddrops.proxies.CommonProxy;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = ADModInfo.ModID, version = ADModInfo.VERSION)
public class AttainedDrops
{
	@Instance(ADModInfo.ModID)
	public static AttainedDrops instance;

	@SidedProxy(clientSide = "com.vapourdrive.attaineddrops.proxies.ClientProxy", serverSide = "com.vapourdrive.attaineddrops.proxies.CommonProxy")
	public static CommonProxy proxy;

	public static CreativeTabs tabAttainedDrops;
	public static String configPath;

	public static final Logger log = LogManager.getLogger(ADModInfo.ModName);

	@EventHandler
	public void preinit(FMLPreInitializationEvent event)
	{

		configPath = event.getModConfigurationDirectory() + "/attaineddrops/";
		tabAttainedDrops = new CreativeTabAD(CreativeTabs.getNextID(), "tabAttainedDrops");

		//MinecraftForge.EVENT_BUS.register(new ForgeEventHooks());
		//FMLCommonHandler.instance().bus().register(new FMLEventHooks());

		ConfigHandler.init(configPath);
		proxy.initSounds();
		proxy.initRenderers();

		AD_Materials.init();
		AD_Items.init();
		AD_Blocks.init();
	}

	@EventHandler
	public void Init(FMLInitializationEvent event)
	{

		AD_Items.registerRecipes();

		AD_Blocks.registerRecipes();
		OreDictionaryRegistry.init();

		/*
		 * ChestGenHooks.getInfo(ChestGenHooks.DUNGEON_CHEST).addItem( new
		 * WeightedRandomChestContent(new ItemStack(AD_Items.chestKey), 1, 1,
		 * 30));
		 */

		/*
		 * if (WorldInfo.GENERATE_WORLD == false) { new WorldStoneGeneration();
		 * }
		 */
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{

	}
}
