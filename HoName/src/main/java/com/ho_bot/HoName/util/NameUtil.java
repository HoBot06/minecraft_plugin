package com.ho_bot.HoName.util;

import org.bukkit.entity.Player;

import com.ho_bot.HoName.file.PlayerFile;

import xyz.haoshoku.nick.api.NickAPI;

public class NameUtil {
	
	private PlayerFile playerF = new PlayerFile();
	
	public void setForceNick(Player player, String newName) {
		NickAPI.nick(player, newName);
		NickAPI.setGameProfileName(player, newName);
		NickAPI.refreshPlayer(player);
		
		player.setDisplayName(newName);
		player.setCustomName(newName);
	}
	
	public void setNick(Player player, String newName) {
		NickAPI.nick(player, newName);
		NickAPI.setGameProfileName(player, newName);
		NickAPI.refreshPlayer(player);
		
		player.setDisplayName(newName);
		//player.setCustomName(newName);
	}
	
	public String getNick(Player player) {
		return NickAPI.getName(player);
	}
	
	public void resetPlayer(Player player) {
		NickAPI.resetNick(player);
		NickAPI.resetGameProfileName(player);
		NickAPI.refreshPlayer(player);
		
		player.setDisplayName(player.getName());
		player.setCustomName(player.getName());
		
		playerF.setPlayerNick(player, player.getName());
		playerF.setPlayerPrefix(player, "");
	}
	
	public void reloadNick(Player player) {
		String nick = VarUtil.nickFrame.replace("%prefix%", playerF.getPlayerPrefix(player)).replace("%nick%", playerF.getPlayerNick(player));
		if(VarUtil.forceNick) {
			setForceNick(player, nick);
		}
		else {
			setNick(player, nick);
		}
	}

}
