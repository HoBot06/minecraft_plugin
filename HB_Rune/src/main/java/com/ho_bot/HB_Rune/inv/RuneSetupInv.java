package com.ho_bot.HB_Rune.inv;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import com.ho_bot.HB_Rune.file.PlayerRuneFile;
import com.ho_bot.HB_Rune.rune.Rune;
import com.ho_bot.HB_Rune.util.GuiUtil;
import com.ho_bot.HB_Rune.util.RuneUtil;
import com.ho_bot.HB_Rune.util.VarUtil;
import com.ho_bot.HB_Rune.util.VarUtil.RuneType;

public class RuneSetupInv {
	
	private GuiUtil G = new GuiUtil();
	private RuneUtil runeU = new RuneUtil();
	private PlayerRuneFile PRF = new PlayerRuneFile();
	
	public void OpenRuneSettingInv(Player player) {
		runeinv(player);
	}
	
	public void OpenRuneSettingInv(Player player, RuneType type, String id) {
		PRF.setPlayerRune(player, type, id);
		
		runeinv(player);
	}
	
	private void runeinv(Player player) {
		Inventory inv = Bukkit.createInventory(null, 9, "[룬설정]");
		
		String passiveR_id = PRF.getPlayerRune(player, RuneType.Passive);
		String activeR_id = PRF.getPlayerRune(player, RuneType.Active);
		String powerR_id = PRF.getPlayerRune(player, RuneType.Power);
		if(passiveR_id != null) {
			Rune passiveR = runeU.getRune(passiveR_id);
			ItemStack passiveI = runeU.getItemStack(passiveR);
			G.Stack(passiveI, 2, inv);
		}
		else {
			G.Stack("발화룬", Material.RED_DYE, 1, Arrays.asList("클릭시 설정"), 2, inv);
		}
		if(activeR_id != null) {
			Rune activeR = runeU.getRune(activeR_id);
			ItemStack activeI = runeU.getItemStack(activeR);
			G.Stack(activeI, 2, inv);
		}
		else {
			G.Stack("파워룬", Material.GREEN_DYE, 1, Arrays.asList("클릭시 설정"), 4, inv);
		}
		if(powerR_id != null) {
			Rune powerR = runeU.getRune(powerR_id);
			ItemStack powerI = runeU.getItemStack(powerR);
			G.Stack(powerI, 2, inv);
		}
		else {
			G.Stack("증폭룬", Material.BLUE_DYE, 1, Arrays.asList("클릭시 설정"), 6, inv);
		}
		
		player.openInventory(inv);
	}
	
	public void OpenRuneChooseInv(Player player, RuneType type) {
		Inventory inv = Bukkit.createInventory(null, 54, "[룬선택]");
		
		int count = 0;
		for(Rune rune : VarUtil.runelist) {
			if(rune.type!=type) continue;
			G.Stack(runeU.getItemStack(rune), count, inv);
			count++;
		}
		
		player.openInventory(inv);
	}
	
	public void EventRuneSettingClick(InventoryClickEvent event) {
		if(event.getClickedInventory()==null) return;
		if(event.getView().getTitle().equalsIgnoreCase("[룬설정]")) {
			if(event.getClickedInventory().getType() == InventoryType.CHEST) {
				if(event.getSlot() == 2) {
					OpenRuneChooseInv((Player) event.getWhoClicked(), RuneType.Passive);
				}
				if(event.getSlot() == 4) {
					OpenRuneChooseInv((Player) event.getWhoClicked(), RuneType.Active);
				}
				if(event.getSlot() == 6) {
					OpenRuneChooseInv((Player) event.getWhoClicked(), RuneType.Power);
				}
			}
		}
	}
	
	public void EventRuneChooseClick(InventoryClickEvent event) {
		if(event.getClickedInventory()==null) return;
		if(event.getView().getTitle().equalsIgnoreCase("[룬선택]")) {
			if(event.getClickedInventory().getType() != InventoryType.CHEST) return;
			if(event.getCurrentItem() == null) return;
			String id = runeU.getId(event.getCurrentItem());
			RuneType type = runeU.getRune(id).type;
			OpenRuneSettingInv((Player) event.getWhoClicked(), type, id);
		}
	}
	
	public void EventRuneSettingClose(InventoryCloseEvent event) {
		if(event.getView().getTitle().equalsIgnoreCase("[룬설정]")) {
			Player player = (Player) event.getPlayer();
			runeU.reloadPlayerRune(player);
		}
	}

}
