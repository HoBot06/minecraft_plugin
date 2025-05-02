package com.ho_bot.ApiGame.file;

import com.ho_bot.ApiGame.classes.board.ApiGameConfig;
import com.ho_bot.ApiGame.main.DLC_ApiGame;
import com.ho_bot.ApiGame.util.VarUtil;
import com.ho_bot.ApiGame.util.VarUtil.GameType;

public class ConfigFile {
	
	public void reloadConfig() {
		DLC_ApiGame.inst.reloadConfig();
		boolean g_able = DLC_ApiGame.inst.getConfig().getBoolean("게임.활성화", true);
		String g_type = DLC_ApiGame.inst.getConfig().getString("스코어보드.종류", GameType.DiaGame.getString());

		boolean b_able = DLC_ApiGame.inst.getConfig().getBoolean("스코어보드.활성화", true);
		long b_time = DLC_ApiGame.inst.getConfig().getLong("스코어보드.주기", 10);
		VarUtil.apiGameConfig = new ApiGameConfig(g_able, GameType.fromString(g_type), b_able, b_time);
		
		reloadBoard(VarUtil.apiGameConfig.gametype);
	}
	
	public void reloadBoard(GameType type) {
		if(type == GameType.DiaGame) {
			VarUtil.nowBoard = VarUtil.dia_Board;
		}
	}

}
