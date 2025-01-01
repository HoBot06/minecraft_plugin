package com.ho_bot.file;

import org.bukkit.configuration.file.FileConfiguration;

import com.ho_bot.main.Hotamina;
import com.ho_bot.util.VarUtil;

public class ConfigFile {
	
	public Hotamina getMain() {
		return Hotamina.getPlugin(Hotamina.class);
	}
	
	public FileConfiguration getConfig() {
		return getMain().getConfig();
	}
	
	public void reloadConfig() {
		getMain().reloadConfig();
		getMain().saveConfig();
		
		VarUtil.maxStamina = getConfig().getInt("최대스테미나");
		VarUtil.breakStamina = getConfig().getInt("스테미나감소량");
		VarUtil.healperStamina = (float) getConfig().getDouble("스테미나회복량");
		VarUtil.f_desStamina = (float) getConfig().getDouble("1단계디버프시작수치");
		VarUtil.s_desStamina = (float) getConfig().getDouble("2단계디버프시작수치");
		VarUtil.f_desFood = getConfig().getInt("1단계배고픔감소수치");
		VarUtil.s_desFood = getConfig().getInt("2단계배고픔감소수치");
		VarUtil.foodmsg = getConfig().getString("배고픔메세지");
		VarUtil.healFood = getConfig().getInt("회복수치");
	}

}
