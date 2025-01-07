package com.ho_bot.HB_Rune.file;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.bukkit.Material;
import org.yaml.snakeyaml.Yaml;

import com.google.common.base.Charsets;
import com.ho_bot.HB_Rune.main.HB_Rune;
import com.ho_bot.HB_Rune.rune.ActiveRune;
import com.ho_bot.HB_Rune.rune.PassiveRune;
import com.ho_bot.HB_Rune.rune.PowerRune;
import com.ho_bot.HB_Rune.rune.Rune;
import com.ho_bot.HB_Rune.util.RuneUtil;
import com.ho_bot.HB_Rune.util.VarUtil;
import com.ho_bot.HB_Rune.util.VarUtil.RuneType;
import com.ho_bot.HB_Rune.util.YmlUtil;

public class RuneFile {
	
	private YmlUtil YU = new YmlUtil();
	private RuneUtil runeU = new RuneUtil();
	
	@SuppressWarnings("unchecked")
	public void reloadRuneFile() throws IOException {
		File file = new File(HB_Rune.inst.getDataFolder() + File.separator + "Rune");
		for(File f : file.listFiles()) {
			FileReader fr = new FileReader(f, Charsets.UTF_8);
			Map<String, Object> map = new Yaml().load(fr);
			Map<String, Object> rune_map = (Map<String, Object>) map.get("룬");
			Map<String, Object> item_map = (Map<String, Object>) rune_map.get("아이템");
			Map<String, Object> ability_map = (Map<String, Object>) rune_map.get("능력");
			String type = (String) rune_map.get("타입");
			Rune P_rune = new Rune();
			if(type.equalsIgnoreCase("발화룬")) {
				P_rune = new PassiveRune(f.getName().replace(".yml", ""));
				P_rune.type = RuneType.Passive;
			}
			if(type.equalsIgnoreCase("파워룬")) {
				P_rune = new ActiveRune(f.getName().replace(".yml", ""));
				P_rune.type = RuneType.Active;
			}
			if(type.equalsIgnoreCase("증폭룬")) {
				P_rune = new PowerRune(f.getName().replace(".yml", ""));
				P_rune.type = RuneType.Power;
			}
			returnAbility(P_rune, ability_map);
			P_rune.name = (String) item_map.get("이름");
			P_rune.material = Material.getMaterial((String) item_map.get("종류"));
			P_rune.lore = (List<String>) item_map.get("설명");
			VarUtil.runelist.add(P_rune);
		}
	}
	
	private void returnAbility(Rune rune, Map<String, Object> abilitymap) {
		return;
	}
	
	//private 

}
