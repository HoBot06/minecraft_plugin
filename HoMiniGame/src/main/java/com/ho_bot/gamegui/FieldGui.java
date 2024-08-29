package com.ho_bot.gamegui;

import java.util.Arrays;
import java.util.Map.Entry;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import com.ho_bot.LogLike.Enemy.LogLikeEnemy;
import com.ho_bot.LogLike.Enemy.TestZombie;
import com.ho_bot.LogLike.Enemy.Skill.LogLikeEnemySkill;
import com.ho_bot.LogLike.Items.LogLikeWeapon;
import com.ho_bot.LogLike.Player.LogLikePlayer;
import com.ho_bot.util.GuiUtil;
import com.ho_bot.util.ItemUtil;
import com.ho_bot.util.NBTUtil;
import com.ho_bot.util.VarUtil;

public class FieldGui {
	
	public GuiUtil GU = new GuiUtil();
	public ItemUtil itemU = new ItemUtil();
	
	private final String fieldTitle = VarUtil.LogLikeTitle + "전투필드";
	
	//1,2,3 <- 무기 || 4 <- 좌클릭 앞으로, 우클릭 뒤로
	public void openFieldGui(Player player) {
		Inventory inv = Bukkit.createInventory(null, 36, fieldTitle);
		UUID playeruuid = player.getUniqueId();
		
		GU.Stack("", Material.WHITE_STAINED_GLASS_PANE, 1, Arrays.asList(""), 31, inv);
		
		GU.Stack("플레이어", itemU.getPlayerSkull(player), Arrays.asList(""), 10, inv);
		GU.Stack("", Material.ZOMBIE_HEAD, 1, Arrays.asList(""), 16, inv);
		
		LogLikePlayer logPlayer = VarUtil.loglikeplayerMap.get(playeruuid);
		for(Entry<Integer, LogLikeWeapon> entry : logPlayer.weaponMap.entrySet()) {
			LogLikeWeapon weapon = entry.getValue();
			GU.Stack(weapon, 26+entry.getKey(), inv);
		}
		for(int i = 0; i < 3; i++) {
			if(inv.getItem(27+i)==null) {
				GU.Stack("비어있음", Material.RED_STAINED_GLASS_PANE, 1, Arrays.asList(""), 27+i, inv);
			}
		}
		GU.Stack("이동하기", Material.LEATHER_BOOTS, 1, Arrays.asList("좌클릭 앞으로", "우클릭 뒤로"), 30, inv);
		
		LogLikeEnemy logEnemy = new TestZombie();
		for(Entry<Integer, LogLikeEnemySkill> entry : logEnemy.skillMap.entrySet()) {
			LogLikeEnemySkill enemySkill = entry.getValue();
			GU.Stack(enemySkill, 31+entry.getKey(), inv);
		}
		for(int i = 0; i < 3; i++) {
			if(inv.getItem(32+i)==null) {
				GU.Stack("비어있음", Material.RED_STAINED_GLASS_PANE, 1, Arrays.asList(""), 32+i, inv);
			}
		}
		GU.Stack("이동하기", Material.LEATHER_BOOTS, 1, Arrays.asList("좌클릭 앞으로", "우클릭 뒤로"), 35, inv);
		
		
		for(int i = 0; i < 9; i++) {
			if(inv.getItem(i)==null) {
				GU.Stack("", Material.WHITE_STAINED_GLASS_PANE, 1, Arrays.asList(""), i, inv);
			}
		}
		for(int i = 9; i < 18; i++) {
			if(inv.getItem(i)==null) {
				GU.Stack("", Material.GRAY_STAINED_GLASS_PANE, 1, Arrays.asList(""), i, inv);
			}
		}
		for(int i = 18; i < 27; i++) {
			if(inv.getItem(i)==null) {
				GU.Stack("", Material.WHITE_STAINED_GLASS_PANE, 1, Arrays.asList(""), i, inv);
			}
		}
		player.openInventory(inv);
	}
	
	public void clickFieldGui(InventoryClickEvent event) {
		if(event.getView().getTitle().equalsIgnoreCase(fieldTitle)) {
			event.setCancelled(true);
			//필드 전투 만들기
			if(event.getClickedInventory().getType() == InventoryType.CHEST) {
				Inventory inv = event.getClickedInventory();
				if(event.getSlot()==27||event.getSlot()==28||event.getSlot()==29) {
					if(itemU.getWeapon(event.getCurrentItem())!=null) {
						LogLikeWeapon weapon = itemU.getWeapon(event.getCurrentItem());
						int playerloc = GU.getPlayerHead(event.getClickedInventory(), 9, 17);
						//클릭시 사거리 표시
						for(int i = 0; i < weapon.distance; i++) {
							int slot = playerloc + i + 1;
							if(slot < 18) {
								if(inv.getItem(i).getType() == Material.GRAY_STAINED_GLASS_PANE) {
									GU.Stack("", Material.GREEN_STAINED_GLASS_PANE, 1, Arrays.asList(""), i, inv);
								}
							}
						}
						//NBT에 공격 저장
						ItemStack item = event.getClickedInventory().getItem(31);
						NBTUtil.setNBTTag(item, VarUtil.fieldKey, event.getSlot()-26);
					}
				}
			}
		}
	}

}
