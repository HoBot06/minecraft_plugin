package com.ho_bot.HB_Rune.inv;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryCloseEvent;

import com.ho_bot.HB_Rune.rune.CombineRune;
import com.ho_bot.HB_Rune.rune.Rune;

public class RuneInv {
	
	public void OpenRuneInv(Player player) {
		
	}
	
	public void EventRuneInv(InventoryCloseEvent event) {
		CombineRune combine_rune = new CombineRune();
		List<Rune> list = new ArrayList<>();
		for(Rune rune : list) {
			combine_rune.addRune(rune);;
		}
	}

}
