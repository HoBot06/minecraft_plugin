package com.ho_bot.HoName.file;

import com.ho_bot.HoName.main.HoName;
import com.ho_bot.HoName.util.VarUtil;

public class ConfigFile {
	
	public void reloadConfig() {
		HoName.inst.reloadConfig();
		VarUtil.forceNick = HoName.inst.getConfig().getBoolean("forceNick");
		VarUtil.nickFrame = HoName.inst.getConfig().getString("표시닉네임");
		VarUtil.profileNick = HoName.inst.getConfig().getBoolean("프로필닉네임");
	}
}
