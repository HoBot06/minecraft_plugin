package com.ho_bot.AntWar.File;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;

import com.ho_bot.AntWar.AntWar;
import com.ho_bot.AntWar.SpawnLoc.SpawnLoc;
import com.ho_bot.AntWar.Util.YmlUtil;
import com.ho_bot.AntWar.Var.GameVar;

public class LocationFile {
	
	public YmlUtil YU = new YmlUtil();
	
	public File getSpawnDir() {
		return new File(AntWar.getPlugin(AntWar.class).getDataFolder( ) + File.separator + "Location//SpawnLoc.yml");
	}
	
	public void reloadSpawnFile() {
		Logger log = Bukkit.getLogger();
		GameVar.spawnlocList.clear();
		if(getSpawnFile()!=null) {
			GameVar.spawnlocList = getSpawnFile();
		}
		log.info("[AntWar] 총 " + GameVar.spawnlocList.size() + " 개의 스폰구역 확인");
	}
	
	public void setSpawnFile(List<SpawnLoc> spawnlist) {
		YamlConfiguration yml = YamlConfiguration.loadConfiguration(getSpawnDir());
		ConfigurationSection sel = yml.createSection("SpawnList");
		for(SpawnLoc spawnloc : spawnlist) {
			ConfigurationSection areasel = sel.createSection(spawnloc.Name);
			areasel.set("Location", spawnloc.location);
		}
		YU.SetYml(getSpawnDir(), yml);
	}
	
	public List<SpawnLoc> getSpawnFile() {
		YamlConfiguration yml = YamlConfiguration.loadConfiguration(getSpawnDir());
		List<SpawnLoc> sl_list = new ArrayList<SpawnLoc>();
		if(yml.getConfigurationSection("SpawnList") != null) {
			ConfigurationSection spawn_list = yml.getConfigurationSection("SpawnList");
			Set<String> list = spawn_list.getKeys(false);
			for(String spawn_name : list) {
				ConfigurationSection spawn_sel = spawn_list.getConfigurationSection(spawn_name);
				SpawnLoc spawnloc = new SpawnLoc(spawn_name, spawn_sel.getLocation("Location"));
				sl_list.add(spawnloc);
			}
		}
		else {
			return null;
		}
		return sl_list;
	}

}
