package com.ho_bot.Siege_Flag.Area;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;

import com.ho_bot.Siege_Flag.Siege_Flag;

public class AreaEvent implements Listener{
	
	public static Siege_Flag plugin;
	
	public AreaGui AreaG = new AreaGui();
	
	public static void setPlugin(Siege_Flag MainPlugin)
    {
        plugin = MainPlugin;
    }
	
	@EventHandler
	public void onBlockClick(PlayerInteractEvent event) {
		Action action = event.getAction();
		Player player = event.getPlayer();
		if(AreaVar.getAreaPlayer(player)) {
			if(event.getHand()==EquipmentSlot.HAND) {
				if(player.getInventory().getItemInMainHand().getType()==Material.WOODEN_HOE) {
					Location loc = event.getClickedBlock().getLocation();
					if(action==Action.LEFT_CLICK_BLOCK) {
						AreaVar.AreaSel_left.put(player, loc);
						player.sendMessage("Pos1 : [" + loc.getX() + ", " + loc.getY() + ", " + loc.getZ() + "]");
					}
					if(action==Action.RIGHT_CLICK_BLOCK) {
						AreaVar.AreaSel_right.put(player, loc);
						player.sendMessage("Pos2 : [" + loc.getX() + ", " + loc.getY() + ", " + loc.getZ() + "]");
					}
					event.setCancelled(true);
				}
			}
		}
	}
	
	@EventHandler
    public void InventoryClick(InventoryClickEvent event) {
		AreaG.EventAreaSettingListGui(event);
		AreaG.EventAreaGui(event);
    }

}
