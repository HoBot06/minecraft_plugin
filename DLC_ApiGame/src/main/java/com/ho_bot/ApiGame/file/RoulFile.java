package com.ho_bot.ApiGame.file;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import org.bukkit.configuration.file.YamlConfiguration;

import com.ho_bot.ApiGame.classes.RoulClass;
import com.ho_bot.ApiGame.classes.roul.RoulChat;
import com.ho_bot.ApiGame.classes.roul.RoulList;
import com.ho_bot.ApiGame.classes.roul.RoulTitle;
import com.ho_bot.ApiGame.main.DLC_ApiGame;
import com.ho_bot.ApiGame.util.VarUtil;
import com.ho_bot.ApiGame.util.VarUtil.RoulType;
import com.ho_bot.util.LogUtil;

public class RoulFile {
	
	public void createDiaFile() {
		File file = new File(DLC_ApiGame.inst.getDataFolder() + File.separator + "룰렛게임");
		if(file.exists()) return;
		DLC_ApiGame.inst.saveResource("룰렛게임/룰렛/테스트룰렛.yml", false);
		DLC_ApiGame.inst.saveResource("룰렛게임/config.yml", false);
	}
	
	public void reloadRoul() {
		createDiaFile();
		File file = new File(DLC_ApiGame.inst.getDataFolder() + File.separator + "룰렛게임//룰렛");
		VarUtil.roulMap.clear();
		if(!file.exists()) return;
		for(File f : file.listFiles()) {
			RoulClass roulclass = new RoulClass();
			String roulname = f.getName().replace(".yml", "");
			YamlConfiguration yml = YamlConfiguration.loadConfiguration(f);
			HashMap<Integer, RoulList> roulListMap = new HashMap<>();
			if(yml.getConfigurationSection("룰렛")!=null) {
				for(String s : yml.getConfigurationSection("룰렛").getKeys(false)) {
					RoulType roulType = RoulType.fromString(yml.getString("룰렛."+s+".종류"));
					String type = yml.getString("룰렛."+s+".타입", "NONE");
					int amo = yml.getInt("룰렛."+s+".갯수", 0);
					int percent = yml.getInt("룰렛."+s+".확률", 0);
					int power = yml.getInt("룰렛."+s+".수치", 0);
					int duration = yml.getInt("룰렛."+s+".지속시간", 0);
					List<String> list = yml.getStringList("룰렛."+s+".커맨드");
					roulListMap.put(Integer.parseInt(s), new RoulList(roulType, type, amo, percent, power, duration, list));
				}
			}
			roulclass.roulMap = roulListMap;
			
			boolean isTitle = yml.getBoolean("타이틀.활성화", false);
			boolean isChat = yml.getBoolean("채팅.활성화", false);
			
			if(isTitle) {
				String mainmsg = yml.getString("타이틀.메인메세지", "");
				String submsg = yml.getString("타이틀.서브메세지", "");
				int fadeIn = yml.getInt("타이틀.페이드인", 0);
				int fadeStay = yml.getInt("타이틀.지속시간", 0);
				int fadeOut = yml.getInt("타이틀.페이드아웃", 0);
				roulclass.r_title = new RoulTitle(isTitle, mainmsg, submsg, fadeIn, fadeStay, fadeOut);
			}
			if(isChat) {
				String msg = yml.getString("채팅.메세지", "");
				roulclass.r_chat = new RoulChat(isChat, msg);
			}
			VarUtil.roulMap.put(roulname, roulclass);
		}
	}

}
