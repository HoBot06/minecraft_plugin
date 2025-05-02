package com.ho_bot.ApiGame.file;

import com.ho_bot.ApiGame.classes.board.configBoard;
import com.ho_bot.ApiGame.main.DLC_ApiGame;
import com.ho_bot.ApiGame.util.VarUtil;

public class ConfigFile {
	
	public void reloadConfig() {
		DLC_ApiGame.inst.reloadConfig();
		String b_type = DLC_ApiGame.inst.getConfig().getString("스코어보드.종류", null);
		boolean b_able = DLC_ApiGame.inst.getConfig().getBoolean("스코어보드.활성화", true);
		long b_time = DLC_ApiGame.inst.getConfig().getLong("스코어보드.주기", 10);
		VarUtil.config_board = new configBoard(b_type, b_able, b_time);
		
		reloadBoard(b_type);
	}
	
	public void reloadBoard(String type) {
		if(type.equalsIgnoreCase("다이아게임")) {
			VarUtil.nowBoard = VarUtil.dia_Board;
		}
	}

}
