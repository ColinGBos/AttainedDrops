package com.vapourdrive.attaineddrops.events;

import java.util.Random;

import net.minecraft.init.Items;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
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
			event.entityLiving.dropItem(Items.diamond, 1);
		}
	}
}
