package com.ho_bot.Siege_Flag.Area;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;

import com.ho_bot.Siege_Flag.Siege_Flag;
import com.ho_bot.Siege_Flag.Util.YmlUtil;

public class AreaFile {
	
	public YmlUtil YU = new YmlUtil();
	
	public void reloadAreaFile() {
		Logger log = Bukkit.getLogger();
		AreaVar.AreaList.clear();
		if(getAreaFile()!=null) {
			AreaVar.AreaList = getAreaFile();
		}
		log.info("[Siege_Flag] 총 " + AreaVar.AreaList.size() + " 개의 구역 확인완료");
	}
	
	public void setAreaFile(List<Area> arealist) {
		File file = new File(Siege_Flag.getPlugin(Siege_Flag.class).getDataFolder( ) + File.separator + "Area//config.yml");
		YamlConfiguration yml = YamlConfiguration.loadConfiguration(file);
		ConfigurationSection sel = yml.createSection("AreaList");
		for(Area area : arealist) {
			ConfigurationSection areasel = sel.createSection(area.AreaName);
			areasel.set("AreaBlock", area.AreaBlock.toString());
			areasel.set("AreaLoc1", area.AreaLoc1);
			areasel.set("AreaLoc2", area.AreaLoc2);
		}
		YU.SetYml(file, yml);
	}
	
	public List<Area> getAreaFile() {
		File file = new File(Siege_Flag.getPlugin(Siege_Flag.class).getDataFolder( ) + File.separator + "Area//config.yml");
		YamlConfiguration yml = YamlConfiguration.loadConfiguration(file);
		List<Area> m_list = new ArrayList<Area>();
		if(yml.getConfigurationSection("AreaList") != null) {
			ConfigurationSection area_list = yml.getConfigurationSection("AreaList");
			Set<String> list = area_list.getKeys(false);
			for(String area_name : list) {
				ConfigurationSection areasel = area_list.getConfigurationSection(area_name);
				Area area = new Area(area_name, Material.matchMaterial(areasel.getString("AreaBlock")), areasel.getLocation("AreaLoc1"), areasel.getLocation("AreaLoc2"));
				m_list.add(area);
			}
		}
		else {
			return null;
		}
		return m_list;
	}
	
	public void addAreaList(Area area) {
		List<Area> arealist = new ArrayList<Area>();
		arealist.add(area);
		for(Area a : AreaVar.AreaList) {
			if(!area.AreaName.equalsIgnoreCase(a.AreaName)) {
				arealist.add(a);
			}
		}
		AreaVar.AreaList = arealist;
		setAreaFile(arealist);
	}
	
	public void removeAreaList(String AreaName) {
		List<Area> Arealist = getAreaFile();
		List<Area> Fix_Arealist = new ArrayList<Area>();
		for(Area area : Arealist) {
			if(!area.AreaName.equalsIgnoreCase(AreaName)) {
				Fix_Arealist.add(area);
			}
		}
		setAreaFile(Fix_Arealist);
	}
	
	public Area getArea(String AreaName) {
		for(Area a : AreaVar.AreaList) {
			if(a.AreaName.equalsIgnoreCase(AreaName)) {
				return a;
			}
		}
		return null;
	}
	
	public boolean hasArea(String AreaName) {
		for(Area a : AreaVar.AreaList) {
			if(a.AreaName.equalsIgnoreCase(AreaName)) {
				return true;
			}
		}
		return false;
	}
	
	public void fixArea(String AreaName, Material mat, Location loc1, Location loc2) {
		List<Area> arealist = new ArrayList<Area>();
		for(Area a : AreaVar.AreaList) {
			if(a.AreaName.equalsIgnoreCase(AreaName)) {
				arealist.add(new Area(AreaName, mat, loc1, loc2));
			}
			else {
				arealist.add(a);
			}
		}
		setAreaFile(arealist);
	}

}
