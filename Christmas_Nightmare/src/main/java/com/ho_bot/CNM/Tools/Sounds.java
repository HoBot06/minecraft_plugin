package com.ho_bot.CNM.Tools;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class Sounds {

	public static void SoundP(Player player, Sound sound, float volume, float pitch) {
		player.playSound(player, sound, volume, pitch);
	}

	public static void SoundPL(Player player, Location loc, Sound sound, float volume, float pitch) {
		player.playSound(loc, sound, volume, pitch);
	}
	
	public static void SoundAL(Location loc, Sound sound, float volume, float pitch) {
		for(Player player : Bukkit.getOnlinePlayers()) {
			player.playSound(loc, sound, volume, pitch);
		}
	}
}
