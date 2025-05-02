package com.ho_bot.ApiGame.file;

import java.io.File;
import java.util.List;

import org.bukkit.configuration.file.YamlConfiguration;

import com.ho_bot.ApiGame.classes.board.diaBoard;
import com.ho_bot.ApiGame.main.DLC_ApiGame;
import com.ho_bot.ApiGame.util.VarUtil;

public class DiaFile {
	
	public void createDiaFile() {
		File file = new File(DLC_ApiGame.inst.getDataFolder() + File.separator + "다이아게임");
		if(file.exists()) return;
		DLC_ApiGame.inst.saveResource("다이아게임/config.yml", false);
	}
	
	public void reloadDiaFile() {
		createDiaFile();
		File file = new File(DLC_ApiGame.inst.getDataFolder() + File.separator + "다이아게임//config.yml");
		YamlConfiguration yml = YamlConfiguration.loadConfiguration(file);
		String disTitle = yml.getString("스코어보드.제목", "다이아게임");
		List<String> diaLore = yml.getStringList("스코어보드.내용");
		VarUtil.dia_Board = new diaBoard(disTitle, diaLore);
	}

}
