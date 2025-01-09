package com.ho_bot.DontBreak.file;

import com.ho_bot.DontBreak.main.DontBreak;
import com.ho_bot.DontBreak.util.VarUtil;

public class ConfigFile {
	
	public void reloadConfig() {
		DontBreak.inst.reloadConfig();
		VarUtil.opBreak = DontBreak.inst.getConfig().getBoolean("opBreak");
	}

}
