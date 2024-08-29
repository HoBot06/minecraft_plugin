package com.ho_bot.LogLike.Player;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.bukkit.entity.Player;

import com.ho_bot.LogLike.Items.LogLikeItem;
import com.ho_bot.LogLike.Items.LogLikeWeapon;

public class LogLikePlayer {
	
	public final UUID playeruuid;
	
	public double health;
	public double attack;
	public int speed;
	public HashMap<LogLikeItem, Integer> itemMap = new HashMap<>();
	
	public HashMap<Integer, LogLikeWeapon> weaponMap = new HashMap<>();
	
	public LogLikePlayer(UUID playeruuid) {
		this.playeruuid = playeruuid;
	}

}
