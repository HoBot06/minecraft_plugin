package com.ho_bot.event;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;

import com.ho_bot.main.HoxelMonTest;
import com.pixelmonmod.pixelmon.Pixelmon;
import com.pixelmonmod.pixelmon.api.events.HealerEvent;

import net.minecraftforge.eventbus.api.EventPriority;

public class PixelEvent implements Listener{
	
	public final void register(HoxelMonTest plugin) {
		Pixelmon.EVENT_BUS.register(this);
		Pixelmon.EVENT_BUS.addListener(EventPriority.NORMAL, true, HealerEvent.class, this::onPixel);
	}
	
	public void onPixel(HealerEvent event) {
		Bukkit.broadcastMessage("ttest");
	}

}
