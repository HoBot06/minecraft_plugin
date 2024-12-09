package com.ho_bot.event;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import com.ho_bot.main.Hotamina;
import com.ho_bot.util.StaminaUtil;
import com.ho_bot.util.VarUtil;

public class StaminaEvent implements Listener{
	
	public static Hotamina plugin;

	public static void setPlugin(Hotamina MainPlugin)
    {
        plugin = MainPlugin;
    }
	
	private StaminaUtil staminaU = new StaminaUtil();
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		if(VarUtil.Player_Stamina.containsKey(event.getPlayer().getUniqueId())) return;
		VarUtil.Player_Stamina.put(event.getPlayer().getUniqueId(), (float) VarUtil.maxStamina);
	}
	
	/*@EventHandler
	public void onQuit(PlayerQuitEvent event) {
		if(!VarUtil.Player_Stamina.containsKey(event.getPlayer().getUniqueId())) return;
		VarUtil.Player_Stamina.remove(event.getPlayer().getUniqueId());
	}*/
	
	@EventHandler
	public void onBreak(BlockBreakEvent event) {
		staminaU.setStamina(event.getPlayer(), staminaU.getStamina(event.getPlayer())-VarUtil.breakStamina);
	}

}
