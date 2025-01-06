package com.ho_bot.HB_Rune.file;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

import org.bukkit.configuration.file.YamlConfiguration;
import org.yaml.snakeyaml.Yaml;

import com.google.common.base.Charsets;
import com.ho_bot.HB_Rune.main.HB_Rune;
import com.ho_bot.HB_Rune.rune.PassiveRune;
import com.ho_bot.HB_Rune.util.VarUtil;
import com.ho_bot.HB_Rune.util.VarUtil.RuneType;
import com.ho_bot.HB_Rune.util.YmlUtil;

public class RuneFile {
	
	private YmlUtil YU = new YmlUtil();
	
	public void reloadRuneFile() throws IOException {
		File file = new File(HB_Rune.inst.getDataFolder() + File.separator + "Rune");
		YamlConfiguration yml = YamlConfiguration.loadConfiguration(file);
		for(File f : file.listFiles()) {
			FileReader fr = new FileReader(f, Charsets.UTF_8);
			Map<String, Object> map = new Yaml().load(fr);
			Map<String, Object> rune_map = (Map<String, Object>) map.get("룬");
			String type = (String) rune_map.get("타입");
			if(type.equalsIgnoreCase("지속형")) {
				PassiveRune P_rune = new PassiveRune(f.getName().replace(".yml", ""));
				P_rune.type = RuneType.Passive;
				
				VarUtil.runelist.add(null);
			}
			if(type.equalsIgnoreCase("발화형")) {
				
			}
			if(type.equalsIgnoreCase("증폭형")) {
				
			}
		}
	}
	
	//private 

}
