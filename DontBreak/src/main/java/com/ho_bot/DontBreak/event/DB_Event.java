package com.ho_bot.DontBreak.event;

import java.util.Iterator;
import java.util.Map.Entry;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import com.ho_bot.DontBreak.area.Area;
import com.ho_bot.DontBreak.main.DontBreak;
import com.ho_bot.DontBreak.util.LocationUtil;
import com.ho_bot.DontBreak.util.VarUtil;

public class DB_Event implements Listener {
	
	public static DontBreak plugin;

	public static void setPlugin(DontBreak dontBreak)
    {
        plugin = dontBreak;
    }
	
	@EventHandler
	public void onBreak(BlockBreakEvent event) {
		if(event.getBlock()==null) return;
		if(VarUtil.opBreak) {
			if(event.getPlayer().isOp()) return;
		}
		for(Entry<String, Area> entry : VarUtil.areaMap.entrySet()) {
			Location blockLoc = event.getBlock().getLocation();
			if(LocationUtil.isIn(entry.getValue().loc1, entry.getValue().loc2, blockLoc)) {
				event.setCancelled(true);
			}
		}
	}
	
	@EventHandler
	public void onExplosion(EntityExplodeEvent event) {
		Iterator<Block> iterator = event.blockList().iterator();
		while(iterator.hasNext()) {
			Block block = iterator.next();
			for(Entry<String, Area> entry : VarUtil.areaMap.entrySet()) {
				Location blockLoc = block.getLocation();
				if(LocationUtil.isIn(entry.getValue().loc1, entry.getValue().loc2, blockLoc)) {
					iterator.remove();
				}
			}
		}
	}
	
	@EventHandler
	public void onClick(PlayerInteractEvent event) {
		if(!VarUtil.playerActive.containsKey(event.getPlayer().getUniqueId())) return;
		if(!VarUtil.playerActive.get(event.getPlayer().getUniqueId())) return;
		if(event.getAction() == Action.LEFT_CLICK_BLOCK) {
			Area area = new Area();
			if(VarUtil.areaPlayer.containsKey(event.getPlayer().getUniqueId())) {
				area = VarUtil.areaPlayer.get(event.getPlayer().getUniqueId());
			}
			area.loc1 = event.getClickedBlock().getLocation();
			VarUtil.areaPlayer.put(event.getPlayer().getUniqueId(), area);
			
			event.getPlayer().sendMessage("[Pos1] X: " + area.loc1.getX() + " Y: " + area.loc1.getY() + " Z: " + area.loc1.getZ() 
											+ " World: " + area.loc1.getWorld().toString());
			event.setCancelled(true);
		}
		if(event.getAction() == Action.RIGHT_CLICK_BLOCK) {
			Area area = new Area();
			if(VarUtil.areaPlayer.containsKey(event.getPlayer().getUniqueId())) {
				area = VarUtil.areaPlayer.get(event.getPlayer().getUniqueId());
			}
			area.loc2 = event.getClickedBlock().getLocation();
			VarUtil.areaPlayer.put(event.getPlayer().getUniqueId(), area);
			
			event.getPlayer().sendMessage("[Pos2] X: " + area.loc2.getX() + " Y: " + area.loc2.getY() + " Z: " + area.loc2.getZ()
											+ " World: " + area.loc2.getWorld().toString());
			event.setCancelled(true);
		}
	}

}
