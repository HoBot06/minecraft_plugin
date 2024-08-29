package com.ho_bot.gamegui;

import java.util.Arrays;
import java.util.UUID;
import java.util.Map.Entry;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataType;

import com.ho_bot.LogLike.Items.LogLikeWeapon;
import com.ho_bot.LogLike.Player.LogLikePlayer;
import com.ho_bot.LogLike.Player.LogLikePlayerUtil;
import com.ho_bot.util.GuiUtil;
import com.ho_bot.util.ItemUtil;
import com.ho_bot.util.NBTUtil;
import com.ho_bot.util.VarUtil;

public class ItemOptionGui {
	
	public GuiUtil GU = new GuiUtil();
	public ItemUtil itemU = new ItemUtil();

	public LogLikePlayerUtil logplayerU = new LogLikePlayerUtil();
	public FieldGui fieldG = new FieldGui();

	private final String weaponOptionTitle = VarUtil.LogLikeTitle + "무기선택";
	private final String playerweaponTitle = VarUtil.LogLikeTitle + "플레이어무기";
	
	public void openWeaponOption(Player player, LogLikeWeapon weapon_1, LogLikeWeapon weapon_2, LogLikeWeapon weapon_3) {
		Inventory inv = Bukkit.createInventory(null, 36, weaponOptionTitle);
		
		GU.Stack("플레이어", itemU.getPlayerSkull(player), Arrays.asList(""), 31, inv);
		
		GU.Stack(weapon_1, 10, inv);
		GU.Stack(weapon_2, 13, inv);
		GU.Stack(weapon_3, 16, inv);
		
		for(int i = 27; i < 36; i++) {
			if(inv.getItem(i)==null) {
				GU.Stack("", Material.WHITE_STAINED_GLASS_PANE, 1, Arrays.asList(""), i, inv);
			}
		}
		
		player.openInventory(inv);
	}
	
	public void openPlayerWeapon(Player player) {
		Inventory inv = Bukkit.createInventory(null, 36, playerweaponTitle);
		
		GU.Stack("플레이어", itemU.getPlayerSkull(player), Arrays.asList(""), 31, inv);
		
		LogLikePlayer logplayer = VarUtil.loglikeplayerMap.get(player.getUniqueId());
		for(int i = 1; i <= 3; i++) {
			if(logplayer.weaponMap.containsKey(i)) {
				GU.Stack(logplayer.weaponMap.get(i), 7+(3*i), inv);
			}
			else {
				GU.Stack("미보유", Material.RED_STAINED_GLASS_PANE, 1, Arrays.asList("무기가 없습니다"), 7+(3*i), inv);
			}
		}
		
		for(int i = 27; i < 36; i++) {
			if(inv.getItem(i)==null) {
				GU.Stack("", Material.WHITE_STAINED_GLASS_PANE, 1, Arrays.asList(""), i, inv);
			}
		}
		
		player.openInventory(inv);
	}
	
	public void clickWeaponOption(InventoryClickEvent event) {
		if(event.getView().getTitle().equalsIgnoreCase(weaponOptionTitle)) {
			event.setCancelled(true);
			if(event.getSlot()==10||event.getSlot()==13||event.getSlot()==16) {
				LogLikeWeapon weapon = itemU.getWeapon(event.getCurrentItem());
				logplayerU.setPlayerWeapon((Player) event.getView().getPlayer(), weapon, 1);
				openPlayerWeapon((Player) event.getView().getPlayer());
			}
		}
	}
	
	public void clickPlayerWeapon(InventoryClickEvent event) {
		if(event.getView().getTitle().equalsIgnoreCase(playerweaponTitle)) {
			event.setCancelled(true);
			if(event.getSlot()==10||event.getSlot()==13||event.getSlot()==16) {
				if(event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("미보유")) {
					LogLikeWeapon weapon = itemU.getWeapon(event.getCurrentItem());
					int num = (event.getSlot()-8)/2;
					logplayerU.setPlayerWeapon((Player) event.getView().getPlayer(), weapon, num);
					//다음행동
					fieldG.openFieldGui((Player) event.getView().getPlayer());
				}
			}
		}
	}

}
