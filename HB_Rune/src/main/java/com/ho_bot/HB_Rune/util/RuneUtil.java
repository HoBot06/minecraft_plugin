package com.ho_bot.HB_Rune.util;

import java.util.UUID;

import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import com.ho_bot.HB_Rune.main.HB_Rune;
import com.ho_bot.HB_Rune.rune.CombineRune;
import com.ho_bot.HB_Rune.rune.Rune;

public class RuneUtil {
	
	public Rune getRune(String id) {
		for(Rune rune : VarUtil.runelist) {
			if(rune.id.equalsIgnoreCase(id)) return rune;
		}
		return null;
	}
	
	public CombineRune getPlayerRune(UUID playeruuid) {
		return VarUtil.player_rune.get(playeruuid);
	}
	
	public ItemStack getItemStack(Rune rune) {
		ItemStack item = new ItemStack(rune.material);
		ItemMeta item_m = item.getItemMeta();
		item_m.setDisplayName(rune.name);
		item_m.setLore(rune.lore);
		NamespacedKey id_key = new NamespacedKey(HB_Rune.inst, "id");
		item_m.getPersistentDataContainer().set(id_key, PersistentDataType.STRING, rune.id);
		item.setItemMeta(item_m);
		return item;
	}
	
	public String getId(ItemStack item) {
		NamespacedKey id_key = new NamespacedKey(HB_Rune.inst, "id");
		return item.getItemMeta().getPersistentDataContainer().get(id_key, PersistentDataType.STRING);
	}
	
	public boolean isRuneItemStack(ItemStack item) {
		if(item.getItemMeta() == null) return false;
		if(item.getItemMeta().getPersistentDataContainer() == null) return false;
		NamespacedKey id_key = new NamespacedKey(HB_Rune.inst, "id");
		if(item.getItemMeta().getPersistentDataContainer().has(id_key, PersistentDataType.STRING)) return true;
		return false;
	}
}
