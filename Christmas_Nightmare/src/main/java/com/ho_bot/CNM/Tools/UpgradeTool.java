package com.ho_bot.CNM.Tools;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import com.ho_bot.CNM.Var.ItemVar;
import com.ho_bot.CNM.Var.TeamVar;
import com.ho_bot.CNM.Var.WordVar;

import net.md_5.bungee.api.ChatColor;

public class UpgradeTool {
	
	public static void UpgradeArmor(Player player, String UpgradePlayer, String Armor) {
		Player Up_player = Bukkit.getPlayer(ChatColor.stripColor(UpgradePlayer));
		if(Armor.equals(WordVar.Chest_Up)) {
			int[] UpInt = TeamVar.Player_Upgrade.get(Up_player.getUniqueId());
			if(UpInt[0]<5) {
				if(P_Inv.ItemCheck(player, ItemVar.TreeItem().getType(), 3)) {
					P_Inv.ItemStackRemove(player, ItemVar.TreeItem(), 3);
					UpInt[0]=UpInt[0]+1;
					TeamVar.Player_Upgrade.put(Up_player.getUniqueId(), UpInt);
					player.sendMessage("업그레이드 완료");
				}
				else {
					player.sendMessage("재료가 부족합니다");
				}
			}
			else {
				player.sendMessage("이미 강화가 전부 완료되었습니다");
			}
		}
		if(Armor.equals(WordVar.Leg_Up)) {
			int[] UpInt = TeamVar.Player_Upgrade.get(Up_player.getUniqueId());
			if(UpInt[1]<5) {
				if(P_Inv.ItemCheck(player, ItemVar.StoneItem().getType(), 3)) {
					P_Inv.ItemStackRemove(player, ItemVar.StoneItem(), 3);
					UpInt[1]=UpInt[1]+1;
					TeamVar.Player_Upgrade.put(Up_player.getUniqueId(), UpInt);
					player.sendMessage("업그레이드 완료");
				}
				else {
					player.sendMessage("재료가 부족합니다");
				}
			}
			else {
				player.sendMessage("이미 강화가 전부 완료되었습니다");
			}
		}
		if(Armor.equals(WordVar.Boots_Up)) {
			int[] UpInt = TeamVar.Player_Upgrade.get(Up_player.getUniqueId());
			if(UpInt[2]<5) {
				if(P_Inv.ItemCheck(player, ItemVar.WoolItem().getType(), 3)) {
					P_Inv.ItemStackRemove(player, ItemVar.WoolItem(), 3);
					UpInt[2]=UpInt[2]+1;
					TeamVar.Player_Upgrade.put(Up_player.getUniqueId(), UpInt);
					player.sendMessage("업그레이드 완료");
				}
				else {
					player.sendMessage("재료가 부족합니다");
				}
			}
			else {
				player.sendMessage("이미 강화가 전부 완료되었습니다");
			}
		}
	}

}
