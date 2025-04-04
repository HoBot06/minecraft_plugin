package com.ho_bot.Horavity.event;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;

import com.ho_bot.Horavity.main.Horavity;
import com.ho_bot.Horavity.util.GravityUtil;
import com.ho_bot.Horavity.util.VarUtil;

public class HO_Event implements Listener{
	
	public static Horavity plugin;
	
	public static void setPlugin(Horavity MainPlugin)
    {
        plugin = MainPlugin;
    }
	
	public GravityUtil gravityU = new GravityUtil();
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event) {
		if(event.getItem() != null) {
			if(event.getItem().getType() == Material.BLAZE_ROD) {
				if(event.getHand() == EquipmentSlot.HAND) {
					if(VarUtil.is_Grab.getOrDefault(event.getPlayer().getUniqueId(), false)) {
						gravityU.grab_off(event.getPlayer());
					}
					else {
						gravityU.grab_on(event.getPlayer());
					}
				}
			}
		}
	}

}
