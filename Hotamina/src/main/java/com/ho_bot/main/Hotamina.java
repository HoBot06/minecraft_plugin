package com.ho_bot.main;

import org.bukkit.plugin.java.JavaPlugin;

import com.ho_bot.event.StaminaEvent;
import com.ho_bot.timer.staminaTimer;

public class Hotamina extends JavaPlugin{
	
	public static Hotamina inst;
	
	@Override
	public void onEnable() {
		inst = this;
		
		StaminaEvent.setPlugin(this);
		getServer().getPluginManager().registerEvents(new StaminaEvent(), this);
		
		staminaTimer staminaT = new staminaTimer();
		staminaT.runTaskTimer(this, 0L, 2L);
	}

}
