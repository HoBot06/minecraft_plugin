package com.ho_bot.LogLike.Player;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import com.ho_bot.LogLike.Items.LogLikeWeapon;
import com.ho_bot.util.VarUtil;

public class LogLikePlayerUtil {
	
	public void setPlayer(Player player) {
		if(VarUtil.loglikeplayerMap==null||!VarUtil.loglikeplayerMap.containsKey(player.getUniqueId())) {
			LogLikePlayer logplayer = new LogLikePlayer(player.getUniqueId());
			VarUtil.loglikeplayerMap.put(player.getUniqueId(), logplayer);
		}
	}
	
	public void setPlayerWeapon(Player player, LogLikeWeapon weapon, int num) {
		LogLikePlayer logplayer = VarUtil.loglikeplayerMap.get(player.getUniqueId());
		logplayer.weaponMap.put(num, weapon);
		VarUtil.loglikeplayerMap.put(player.getUniqueId(), logplayer);
	}

}
