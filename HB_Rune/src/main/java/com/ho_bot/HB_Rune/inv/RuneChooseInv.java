package com.ho_bot.HB_Rune.inv;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;

import com.ho_bot.HB_Rune.rune.CombineRune;
import com.ho_bot.HB_Rune.rune.Rune;
import com.ho_bot.HB_Rune.util.GuiUtil;
import com.ho_bot.HB_Rune.util.RuneUtil;
import com.ho_bot.HB_Rune.util.VarUtil;
import com.ho_bot.HB_Rune.util.VarUtil.RuneType;

public class RuneChooseInv {
	
	private GuiUtil G = new GuiUtil();
	private RuneUtil runeU = new RuneUtil();
	
	public void OpenRuneChooseInv(Player player, RuneType type) {
		Inventory inv = Bukkit.createInventory(null, 9, "[룬선택]");
		
		int count = 0;
		for(Rune rune : VarUtil.runelist) {
			if(rune.type!=type) continue;
			G.Stack(runeU.getItemStack(rune), count, inv);
			count++;
		}
		
		player.openInventory(inv);
	}
	
	public void EventRuneChooseClick(InventoryClickEvent event) {
		CombineRune combine_rune = new CombineRune();
		List<Rune> list = new ArrayList<>();
		for(Rune rune : list) {
			combine_rune.addRune(rune);
		}
	}

}
