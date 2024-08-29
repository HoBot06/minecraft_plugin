package com.ho_bot.util;

import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import com.ho_bot.main.HoMiniGame;

public class NBTUtil {
	
	public static void setNBTTag(ItemStack item, String key, int value) {
		ItemMeta meta = item.getItemMeta();
		NamespacedKey namespacedKey = new NamespacedKey(HoMiniGame.inst, key);
		meta.getPersistentDataContainer().set(namespacedKey, PersistentDataType.INTEGER, value);
		item.setItemMeta(meta);
	}
	
	public static Object getNBTTag(ItemStack item, String key, PersistentDataType<?, ?> type) {
		ItemMeta meta = item.getItemMeta();
		NamespacedKey namespacedKey = new NamespacedKey(HoMiniGame.inst, key);
		return meta.getPersistentDataContainer().get(namespacedKey, type);
	}

}
