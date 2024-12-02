package com.ho_bot.KoName.File;

import java.io.File;

import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import com.ho_bot.KoName.Ko_Main;
import com.ho_bot.KoName.Util.YmlUtil;

public class NameFile {
	
	public YmlUtil YU = new YmlUtil();
	
	public void createName(Player player) {
		File file = new File(Ko_Main.getPlugin(Ko_Main.class).getDataFolder() + File.separator + "playerdata//"+player.getUniqueId()+".yml");
		YamlConfiguration yml = YamlConfiguration.loadConfiguration(file);
		if(!yml.isString("닉네임")) {
			yml.set("닉네임", player.getName());
		}
		if(!yml.isString("칭호")) {
			yml.set("칭호", null);
		}
		YU.SetYml(file, yml);
	}
	
	/**서클 초기화**/
	public void setName(Player player, String name) {
		File file = new File(Ko_Main.getPlugin(Ko_Main.class).getDataFolder() + File.separator + "playerdata//"+player.getUniqueId()+".yml");
		YamlConfiguration yml = YamlConfiguration.loadConfiguration(file);
		yml.set("닉네임", name);
		YU.SetYml(file, yml);
	}
	
	public void setPre(Player player, String pre) {
		File file = new File(Ko_Main.getPlugin(Ko_Main.class).getDataFolder() + File.separator + "playerdata//"+player.getUniqueId()+".yml");
		YamlConfiguration yml = YamlConfiguration.loadConfiguration(file);
		yml.set("칭호", pre);
		YU.SetYml(file, yml);
	}
	
	public String getName(String uuid) {
		File file = new File(Ko_Main.getPlugin(Ko_Main.class).getDataFolder() + File.separator + "playerdata//"+uuid+".yml");
		YamlConfiguration yml = YamlConfiguration.loadConfiguration(file);
		if(yml.contains("닉네임")) {
			return yml.getString("닉네임");
		}
		return null;
	}
	
	public String getName(Player player) {
		return getName(player.getUniqueId().toString());
	}
	
	public String getName(OfflinePlayer player) {
		return getName(player.getUniqueId().toString());
	}
	
	public String getPre(String uuid) {
		File file = new File(Ko_Main.getPlugin(Ko_Main.class).getDataFolder() + File.separator + "playerdata//"+uuid+".yml");
		YamlConfiguration yml = YamlConfiguration.loadConfiguration(file);
		if(yml.contains("칭호")) {
			return yml.getString("칭호");
		}
		return null;
	}
	
	public String getPre(Player player) {
		return getPre(player.getUniqueId().toString());
	}
	
	public String getPre(OfflinePlayer player) {
		return getPre(player.getUniqueId().toString());
	}
	
	public boolean hasName(Player player) {
		File file = new File(Ko_Main.getPlugin(Ko_Main.class).getDataFolder() + File.separator + "playerdata//"+player.getUniqueId()+".yml");
		YamlConfiguration yml = YamlConfiguration.loadConfiguration(file);
		if(yml.contains("닉네임")) {
			if(yml.getString("닉네임")!=null) {
				return true;
			}
		}
		return false;
	}
	
	public boolean hasPre(Player player) {
		File file = new File(Ko_Main.getPlugin(Ko_Main.class).getDataFolder() + File.separator + "playerdata//"+player.getUniqueId()+".yml");
		YamlConfiguration yml = YamlConfiguration.loadConfiguration(file);
		if(yml.isString("칭호")) {
			if(yml.getString("칭호")!=null) {
				return true;
			}
		}
		return false;
	}

}
