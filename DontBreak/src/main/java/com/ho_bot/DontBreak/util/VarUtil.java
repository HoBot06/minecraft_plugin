package com.ho_bot.DontBreak.util;

import java.util.HashMap;
import java.util.UUID;

import com.ho_bot.DontBreak.area.Area;

public class VarUtil {
	
	public static HashMap<String, Area> areaMap = new HashMap<>();
	public static HashMap<UUID, Area> areaPlayer = new HashMap<>();
	public static HashMap<UUID, Boolean> playerActive = new HashMap<>();
	public static boolean opBreak = true;
}
