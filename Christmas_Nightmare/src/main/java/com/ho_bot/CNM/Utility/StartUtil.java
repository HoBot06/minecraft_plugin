package com.ho_bot.CNM.Utility;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.ho_bot.CNM.Main;
import com.ho_bot.CNM.Var.TeamVar;
import com.ho_bot.CNM.Var.WordVar;

public class StartUtil {
	
	@SuppressWarnings("deprecation")
	public static void onPlayerReSpawn(PlayerRespawnEvent event) {
		Player player = event.getPlayer();
		Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), () -> {
			player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 1000000, 1, false, false), true);
        }, 10);
	}
	
	public static void SetTeamSpawn(Player player) {
		if(TeamVar.Player_Team.get(player.getUniqueId()).equalsIgnoreCase(WordVar.Santa)) {
			String loc = Main.getPlugin(Main.class).getConfig().getString("산타스폰");
			String[] loc_ = loc.split(":");
			Location location = new Location(Bukkit.getWorld(loc_[0]), Double.parseDouble(loc_[1]), Double.parseDouble(loc_[2]), Double.parseDouble(loc_[3]));
			player.setBedSpawnLocation(location, true);
		}
		else if(TeamVar.Player_Team.get(player.getUniqueId()).equalsIgnoreCase(WordVar.Krampus)) {
			String loc = Main.getPlugin(Main.class).getConfig().getString("크람스폰");
			String[] loc_ = loc.split(":");
			Location location = new Location(Bukkit.getWorld(loc_[0]), Double.parseDouble(loc_[1]), Double.parseDouble(loc_[2]), Double.parseDouble(loc_[3]));
			player.setBedSpawnLocation(location, true);
		}
	}
	
	public static void SetTeamTel(Player player) {
		if(TeamVar.Player_Team.get(player.getUniqueId()).equalsIgnoreCase(WordVar.Santa)) {
			String loc = Main.getPlugin(Main.class).getConfig().getString("산타스폰");
			String[] loc_ = loc.split(":");
			Location location = new Location(Bukkit.getWorld(loc_[0]), Double.parseDouble(loc_[1]), Double.parseDouble(loc_[2]), Double.parseDouble(loc_[3]));
			player.teleport(location);
		}
		else if(TeamVar.Player_Team.get(player.getUniqueId()).equalsIgnoreCase(WordVar.Krampus)) {
			String loc = Main.getPlugin(Main.class).getConfig().getString("크람스폰");
			String[] loc_ = loc.split(":");
			Location location = new Location(Bukkit.getWorld(loc_[0]), Double.parseDouble(loc_[1]), Double.parseDouble(loc_[2]), Double.parseDouble(loc_[3]));
			player.teleport(location);
		}
	}

}
