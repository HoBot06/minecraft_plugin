package com.ho_bot.HoName.file;

import java.io.File;
import java.util.List;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import com.ho_bot.HoName.main.HoName;
import com.ho_bot.HoName.util.YmlUtil;

public class PlayerFile {
	
	private YmlUtil YU = new YmlUtil();
	
	public void createPlayerFile(Player player) {
		File file = new File(HoName.inst.getDataFolder( ) + File.separator + "playerdata//"+player.getUniqueId().toString()+".yml");
		YamlConfiguration yml = YamlConfiguration.loadConfiguration(file);
		if(!file.exists()) {
			YU.SetYml(file, yml);
		}
	}
	
	public void setPlayerNick(Player player, String nick) {
		File file = new File(HoName.inst.getDataFolder( ) + File.separator + "playerdata//"+player.getUniqueId().toString()+".yml");
		YamlConfiguration yml = YamlConfiguration.loadConfiguration(file);
		yml.set("nick", nick);
		YU.SetYml(file, yml);
	}
	
	public void setPlayerPrefix(Player player, String nick) {
		File file = new File(HoName.inst.getDataFolder( ) + File.separator + "playerdata//"+player.getUniqueId().toString()+".yml");
		YamlConfiguration yml = YamlConfiguration.loadConfiguration(file);
		yml.set("prefix", nick);
		YU.SetYml(file, yml);
	}
	
	public String getPlayerNick(Player player) {
		File file = new File(HoName.inst.getDataFolder( ) + File.separator + "playerdata//"+player.getUniqueId().toString()+".yml");
		YamlConfiguration yml = YamlConfiguration.loadConfiguration(file);
		if(yml.contains("nick")) {
			return yml.getString("nick");
		}
		return player.getName();
	}
	
	public String getPlayerPrefix(Player player) {
		File file = new File(HoName.inst.getDataFolder( ) + File.separator + "playerdata//"+player.getUniqueId().toString()+".yml");
		YamlConfiguration yml = YamlConfiguration.loadConfiguration(file);
		if(yml.contains("prefix")) {
			return yml.getString("prefix");
		}
		return "";
	}

}
