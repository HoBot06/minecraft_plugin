package com.ho_bot.util;

import java.util.HashMap;
import java.util.UUID;

public class VarUtil {
	
	public static int maxStamina = 0;
	public static int breakStamina = 0;
	public static float healperStamina = 0;
	public static float f_desStamina = 0;
	public static float s_desStamina = 0;
	public static int f_desFood = 0;
	public static int s_desFood = 0;
	public static String foodmsg = "";
	
	public static HashMap<UUID, Float> Player_Stamina = new HashMap<>();
	public static HashMap<UUID, Boolean> Player_Foodmsg = new HashMap<>();

}
