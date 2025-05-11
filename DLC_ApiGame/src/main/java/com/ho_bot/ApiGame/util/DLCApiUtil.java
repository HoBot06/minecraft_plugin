package com.ho_bot.ApiGame.util;

import java.util.Map;

import org.bukkit.ChatColor;

import com.ho_bot.dlc.DLC_Donation;
import com.ho_bot.util.LogUtil;

public class DLCApiUtil {

	public static void addDlc(String key, DLC_Donation dlc) {
		VarUtil.apidlclist.put(key, dlc);
		LogUtil.info("[DLC_APIGAME] " + ChatColor.GREEN + key + " 인식 완료");
	}
	
	public static Map<String, DLC_Donation> getDlclist() {
		return VarUtil.apidlclist;
	}
	
}
