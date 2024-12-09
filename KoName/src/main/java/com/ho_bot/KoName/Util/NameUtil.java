package com.ho_bot.KoName.Util;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.profile.PlayerProfile;

import com.ho_bot.KoName.File.NameFile;

//import me.ministrie.classes.AuthPlayer;
//import me.ministrie.classes.NameChanger;
import net.md_5.bungee.api.ChatColor;
import xyz.haoshoku.nick.api.NickAPI;

public class NameUtil {
	
	public NameFile nameF = new NameFile();
	public ArmorStandUtil armorstandU = new ArmorStandUtil();
	
	public void refreshName(Player player) {
		String name = null;
		String pre = "";
		if(nameF.hasName(player)) {
			name = nameF.getName(player);
		}
		if(nameF.hasPre(player)) {
			pre = nameF.getPre(player);
		}
		String nick = "";
		if(pre!=null) {
			nick = pre+name;
		}
		else {
			nick = name;
		}
		if(name != null) {
//			AuthPlayer auth = AuthPlayer.getPlayer(player);
//			NameChanger namechaner = auth.getNameChanger();
			
//			namechaner.setName(name.replace('&', ChatColor.COLOR_CHAR));
			NickAPI.nick(player, nick.replace('&', ChatColor.COLOR_CHAR));
			NickAPI.setGameProfileName(player, name.replace('&', ChatColor.COLOR_CHAR));
//			armorstandU.setNameStand(player.getUniqueId(), nick);
			NickAPI.refreshPlayer(player);
		}	
	}
	
	public void refreshNick(Player player) {
		String name = null;
		String pre = "";
		if(nameF.hasName(player)) {
			name = nameF.getName(player);
		}
		if(nameF.hasPre(player)) {
			pre = nameF.getPre(player);
		}
		String nick = "";
		if(pre!=null) {
			nick = pre+name;
		}
		else {
			nick = name;
		}
		if(name != null) {
			NickAPI.nick(player, nick.replace('&', ChatColor.COLOR_CHAR));
			NickAPI.setGameProfileName(player, name.replace('&', ChatColor.COLOR_CHAR));
			NickAPI.refreshPlayer(player);
		}
	}
	
	public void removeName(Player player) {
		NickAPI.resetGameProfileName(player);
		NickAPI.resetNick(player);
		NickAPI.refreshPlayer(player);
//		armorstandU.removeStand(player.getUniqueId());
	}

}
