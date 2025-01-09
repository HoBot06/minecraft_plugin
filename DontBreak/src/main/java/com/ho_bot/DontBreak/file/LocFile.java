package com.ho_bot.DontBreak.file;

import java.io.File;
import java.io.FileReader;
import java.util.Map;
import java.util.Map.Entry;

import org.bukkit.Location;
import org.bukkit.configuration.file.YamlConfiguration;
import org.yaml.snakeyaml.Yaml;

import com.google.common.base.Charsets;
import com.ho_bot.DontBreak.area.Area;
import com.ho_bot.DontBreak.main.DontBreak;
import com.ho_bot.DontBreak.util.VarUtil;
import com.ho_bot.DontBreak.util.YmlUtil;

public class LocFile {
	
	private YmlUtil YU = new YmlUtil();
	
	public void reloadLocFile() {
		File file = new File(DontBreak.inst.getDataFolder() + File.separator + "Data//Area.yml");
		YamlConfiguration yml = YamlConfiguration.loadConfiguration(file);
		VarUtil.areaMap.clear();
		if(!file.exists()) {
			YU.SetYml(file, yml);
			return;
		}
		try {
			FileReader fr = new FileReader(file, Charsets.UTF_8);
			Map<String, Object> map = new Yaml().load(fr);
			Map<String, Object> loc_map = (Map<String, Object>) map.get("구역");
			for(Entry<String, Object> entry : loc_map.entrySet()) {
				Location loc1 = yml.getLocation("구역."+entry.getKey()+".pos1");
				Location loc2 = yml.getLocation("구역."+entry.getKey()+".pos2");
				Area area = new Area(entry.getKey(), loc1, loc2);
				VarUtil.areaMap.put(entry.getKey(), area);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void setLoc(String areaName, Location loc1, Location loc2) {
		File file = new File(DontBreak.inst.getDataFolder() + File.separator + "Data//Area.yml");
		YamlConfiguration yml = YamlConfiguration.loadConfiguration(file);
		yml.set("구역."+areaName+".pos1", loc1);
		yml.set("구역."+areaName+".pos2", loc2);
		YU.SetYml(file, yml);
		
		reloadLocFile();
	}

}
