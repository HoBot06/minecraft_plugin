package com.ho_bot.HB_Rune.util;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import com.ho_bot.HB_Rune.file.PlayerRuneFile;
import com.ho_bot.HB_Rune.main.HB_Rune;
import com.ho_bot.HB_Rune.rune.CombineRune;
import com.ho_bot.HB_Rune.rune.Rune;
import com.ho_bot.HB_Rune.util.VarUtil.RuneType;

public class RuneUtil {
	
	private PlayerRuneFile PRF = new PlayerRuneFile();
	
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
		item_m.setDisplayName(rune.getName());
		item_m.setLore(rune.getLore());
		NamespacedKey id_key = new NamespacedKey(HB_Rune.inst, "id");
		item_m.getPersistentDataContainer().set(id_key, PersistentDataType.STRING, rune.id);
		item.setItemMeta(item_m);
		return item;
	}
	
	public String getId(ItemStack item) {
		NamespacedKey id_key = new NamespacedKey(HB_Rune.inst, "id");
		return item.getItemMeta().getPersistentDataContainer().get(id_key, PersistentDataType.STRING);
	}
	
	public boolean hasPlayerRune(UUID playeruuid) {
		if(getPlayerRune(playeruuid) == null) return false;
		return true;
	}
	
	public boolean isRuneItemStack(ItemStack item) {
		if(item.getItemMeta() == null) return false;
		if(item.getItemMeta().getPersistentDataContainer() == null) return false;
		NamespacedKey id_key = new NamespacedKey(HB_Rune.inst, "id");
		if(item.getItemMeta().getPersistentDataContainer().has(id_key, PersistentDataType.STRING)) return true;
		return false;
	}
	
	public void reloadPlayerRune(Player player) {
		CombineRune combine_rune = new CombineRune();
		List<Rune> list = new ArrayList<>();
		String passiveR_id = PRF.getPlayerRune(player, RuneType.Passive);
		String activeR_id = PRF.getPlayerRune(player, RuneType.Active);
		String powerR_id = PRF.getPlayerRune(player, RuneType.Power);
		if(passiveR_id != null) {
			Rune passiveR = getRune(passiveR_id);
			list.add(passiveR);
		}
		if(activeR_id != null) {
			Rune activeR = getRune(activeR_id);
			list.add(activeR);
		}
		if(powerR_id != null) {
			Rune powerR = getRune(powerR_id);
			list.add(powerR);
		}
		for(Rune rune : list) {
			combine_rune.addRune(rune);
		}
		VarUtil.player_rune.put(player.getUniqueId(), combine_rune);
	}
}
