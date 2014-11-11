package com.vapourdrive.attaineddrops.events;

import java.util.Random;

import net.minecraftforge.event.entity.living.LivingDropsEvent;

import com.vapourdrive.attaineddrops.items.AD_Items;

import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class ForgeEventHooks
{
	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public void dropEvent(LivingDropsEvent event)
	{
		if (event.entityLiving.worldObj.isRemote)
			return;
		Random rand = event.entityLiving.worldObj.rand;
		int chance = rand.nextInt(100);
		if (chance == 0)
		{
			event.entityLiving.dropItem(AD_Items.lifeEssence, 1);
		}
	}
}
