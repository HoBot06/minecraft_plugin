package com.ho_bot.HB_Rune.file;

import java.io.File;
import java.util.UUID;

import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;

import com.ho_bot.HB_Rune.main.HB_Rune;
import com.ho_bot.HB_Rune.util.YmlUtil;

public class RuneFile {
	
	private YmlUtil YU = new YmlUtil();
	
	public void reloadRuneFile() {
		File file = new File(HB_Rune.inst.getDataFolder() + File.separator + "Rune//test.yml");
		YamlConfiguration yml = YamlConfiguration.loadConfiguration(file);
		
		YU.SetYml(file, yml);
	}

}
