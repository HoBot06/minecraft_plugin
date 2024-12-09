package com.ho_bot.util;

import org.bukkit.entity.Player;

public class StaminaUtil {
	
	public float getStamina(Player player) {
		if(!VarUtil.Player_Stamina.containsKey(player.getUniqueId())) {
			return 0;
		}
		return VarUtil.Player_Stamina.get(player.getUniqueId());
	}
	
	public void setStamina(Player player, float stamina) {
		if(!VarUtil.Player_Stamina.containsKey(player.getUniqueId())) return;
		VarUtil.Player_Stamina.put(player.getUniqueId(), Math.max(0, stamina));
	}

}
