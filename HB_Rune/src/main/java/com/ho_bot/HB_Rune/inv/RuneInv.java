package com.ho_bot.HB_Rune.inv;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import com.ho_bot.HB_Rune.rune.Rune;
import com.ho_bot.HB_Rune.util.GuiUtil;
import com.ho_bot.HB_Rune.util.RuneUtil;
import com.ho_bot.HB_Rune.util.VarUtil;

public class RuneInv {
	
	private GuiUtil G = new GuiUtil();
	private RuneUtil runeU = new RuneUtil();
	
	public void OpenRuneBagInv(Player player) {
		Inventory inv = Bukkit.createInventory(null, 54, "[룬가방]");
		
		int count = 0;
		for(Rune rune : VarUtil.runelist) {
			G.Stack(runeU.getItemStack(rune), count, inv);
			count++;
		}
		
		player.openInventory(inv);
	}

}
