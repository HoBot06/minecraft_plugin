package com.ho_bot.KoName.Timer;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import com.ho_bot.KoName.Util.ArmorStandUtil;
import com.ho_bot.KoName.Util.VarUtil;

public class StandTimer extends BukkitRunnable{
	
	public ArmorStandUtil armorstandU = new ArmorStandUtil();

	@Override
	public void run() {
		for(Player p : Bukkit.getOnlinePlayers()) {
			if(VarUtil.player_stand.containsKey(p.getUniqueId())) {
				if(VarUtil.player_stand.get(p.getUniqueId()).getWorld()!=p.getLocation().getWorld()) {
					VarUtil.player_stand.get(p.getUniqueId()).teleport(p.getLocation().add(0, 2.2, 0));
					continue;
				}
				if(VarUtil.player_loc.containsKey(p.getUniqueId())) {
					Location loc_end = p.getLocation();
					Location loc_start = VarUtil.player_loc.get(p.getUniqueId());
					armorstandU.moveStand(p.getUniqueId(), loc_end, loc_start);
					VarUtil.player_loc.put(p.getUniqueId(), loc_end);
				}
				else {
					VarUtil.player_loc.put(p.getUniqueId(), new Location(p.getWorld(), p.getLocation().getX(), 0, p.getLocation().getZ()));
					VarUtil.player_stand.get(p.getUniqueId()).teleport(p.getLocation().add(0, 2.2, 0));
					continue;
				}
			}
		}
	}
}
