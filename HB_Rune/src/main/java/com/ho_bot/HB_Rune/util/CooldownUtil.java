package com.ho_bot.HB_Rune.util;

import org.bukkit.entity.Player;

public class CooldownUtil {
	
	public boolean isC(Player player) {
		if(VarUtil.player_cool.containsKey(player.getUniqueId())) {
			if(VarUtil.player_cool.get(player.getUniqueId()) > 0) {
				return true;
			}
		}
		return false;
	}
	
	public void deC() {
		
	}
	
	public void addC() {
		
	}

}
