package com.ho_bot.CNM.Tools;

import org.bukkit.entity.Player;

import com.ho_bot.CNM.Var.ItemVar;
import com.ho_bot.CNM.Var.TeamVar;
import com.ho_bot.CNM.Var.WordVar;

public class UpgradeTool {
	
	public static void UpgradeArmor(Player player, String UpgradePlayer, String Armor) {
		if(Armor.equals(WordVar.Chest_Up)) {
			int[] UpInt = TeamVar.Player_Upgrade.get(player.getUniqueId());
			if(UpInt[0]<5) {
				if(P_Inv.ItemStackCheck(player, ItemVar.TreeItem(), 3)) {
					P_Inv.ItemStackRemove(player, ItemVar.TreeItem(), 3);
					UpInt[0]=UpInt[0]+1;
					TeamVar.Player_Upgrade.put(player.getUniqueId(), UpInt);
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
			int[] UpInt = TeamVar.Player_Upgrade.get(player.getUniqueId());
			if(UpInt[1]<5) {
				if(P_Inv.ItemStackCheck(player, ItemVar.StoneItem(), 3)) {
					P_Inv.ItemStackRemove(player, ItemVar.StoneItem(), 3);
					UpInt[1]=UpInt[1]+1;
					TeamVar.Player_Upgrade.put(player.getUniqueId(), UpInt);
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
			int[] UpInt = TeamVar.Player_Upgrade.get(player.getUniqueId());
			if(UpInt[2]<5) {
				if(P_Inv.ItemStackCheck(player, ItemVar.WoolItem(), 3)) {
					P_Inv.ItemStackRemove(player, ItemVar.WoolItem(), 3);
					UpInt[2]=UpInt[2]+1;
					TeamVar.Player_Upgrade.put(player.getUniqueId(), UpInt);
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
