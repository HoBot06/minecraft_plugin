package com.ho_bot.Horavity.util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import org.bukkit.Material;

public class VarUtil {
	
	public static int gravity_range = 20;
	public static float gravity_area = 0.5f;
	public static HashMap<UUID, Boolean> is_Grab = new HashMap<>();
	public static Set<Material> gravity_not_block = new HashSet<>(Arrays.asList(Material.AIR, Material.GRASS));

}
