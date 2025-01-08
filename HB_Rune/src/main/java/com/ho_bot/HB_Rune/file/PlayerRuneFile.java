package com.ho_bot.HB_Rune.file;

import java.io.File;
import java.util.UUID;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import com.ho_bot.HB_Rune.main.HB_Rune;
import com.ho_bot.HB_Rune.util.VarUtil.RuneType;
import com.ho_bot.HB_Rune.util.YmlUtil;

public class PlayerRuneFile {

	private YmlUtil YU = new YmlUtil();
	
	public void createPlayerFile(UUID uuid) {
		File file = new File(HB_Rune.inst.getDataFolder() + File.separator + "PlayerData//"+uuid.toString()+".yml");
		YamlConfiguration yml = YamlConfiguration.loadConfiguration(file);
		if(!file.exists()) {
			YU.SetYml(file, yml);
		}
	}
	
	public String getPlayerRune(Player player, RuneType type) {
		File file = new File(HB_Rune.inst.getDataFolder() + File.separator + "PlayerData//"+player.getUniqueId().toString()+".yml");
		YamlConfiguration yml = YamlConfiguration.loadConfiguration(file);
		return yml.getString("룬."+type.toString());
	}
	
	public void setPlayerRune(Player player, RuneType type, String id) {
		File file = new File(HB_Rune.inst.getDataFolder() + File.separator + "PlayerData//"+player.getUniqueId().toString()+".yml");
		YamlConfiguration yml = YamlConfiguration.loadConfiguration(file);
		yml.set("룬."+type.toString(), id);
		YU.SetYml(file, yml);
	}
}
