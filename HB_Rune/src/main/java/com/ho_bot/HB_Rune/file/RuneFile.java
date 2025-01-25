package com.ho_bot.HB_Rune.file;

import java.io.File;
import java.io.FileReader;
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
import com.ho_bot.HB_Rune.util.LogUtil;
import com.ho_bot.HB_Rune.util.RuneUtil;
import com.ho_bot.HB_Rune.util.VarUtil;
import com.ho_bot.HB_Rune.util.VarUtil.AbilityType;
import com.ho_bot.HB_Rune.util.VarUtil.RuneType;
import com.ho_bot.HB_Rune.util.YmlUtil;

public class RuneFile {
	
	private YmlUtil YU = new YmlUtil();
	private RuneUtil runeU = new RuneUtil();
	
	@SuppressWarnings("unchecked")
	public void reloadRuneFile() {
		File file = new File(HB_Rune.inst.getDataFolder() + File.separator + "Rune");
		if(!file.exists()) {
			file.mkdirs();
			return;
		}
		for(File f : file.listFiles()) {
			try {
				FileReader fr = new FileReader(f, Charsets.UTF_8);
				Map<String, Object> map = new Yaml().load(fr);
				Map<String, Object> rune_map = (Map<String, Object>) map.get("룬");
				Map<String, Object> item_map = (Map<String, Object>) rune_map.get("아이템");
				Map<String, Object> ability_map = (Map<String, Object>) rune_map.get("능력");
				String type = (String) rune_map.get("타입");
				Rune rune = new Rune();
				if(type.equalsIgnoreCase("발화룬")) {
					rune = new PassiveRune(f.getName().replace(".yml", ""));
					rune.type = RuneType.Passive;
				}
				if(type.equalsIgnoreCase("파워룬")) {
					rune = new ActiveRune(f.getName().replace(".yml", ""));
					rune.type = RuneType.Active;
				}
				if(type.equalsIgnoreCase("증폭룬")) {
					rune = new PowerRune(f.getName().replace(".yml", ""));
					rune.type = RuneType.Power;
				}
				returnAbility(rune, ability_map);
				rune.name = (String) item_map.get("이름");
				rune.material = Material.getMaterial((String) item_map.get("종류"));
				rune.lore = (List<String>) item_map.get("설명");
				VarUtil.runelist.add(rune);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		LogUtil.info(VarUtil.runelist.size() + "개 룬 인식됨");
	}
	
	private void returnAbility(Rune rune, Map<String, Object> abilitymap) {
		if(abilitymap.containsKey("타입")) rune.abilityType = AbilityType.valueOfName((String) abilitymap.get("타입"));
		
		//발화룬
		if(abilitymap.containsKey("쿨타임")) rune.cooldown = (int) abilitymap.get("쿨타임");
		if(abilitymap.containsKey("쿨타임메세지")) rune.cooldown_msg = (String) abilitymap.get("쿨타임메세지");
		
		//파워룬
		if(abilitymap.containsKey("효과")) rune.abilityEffet = (String) abilitymap.get("효과");
		if(abilitymap.containsKey("파워")) rune.power_val = (int) abilitymap.get("파워");
		if(abilitymap.containsKey("파워(%)")) rune.power_per = (double) abilitymap.get("파워(%)");
		if(abilitymap.containsKey("지속시간")) rune.duration = (int) abilitymap.get("지속시간");
		
		//증폭룬
		if(abilitymap.containsKey("증폭")) rune.amp_val = (int) abilitymap.get("증폭");
		if(abilitymap.containsKey("증폭(%)")) rune.amp_per = (double) abilitymap.get("증폭(%)");
		return;
	}
	
	

}
