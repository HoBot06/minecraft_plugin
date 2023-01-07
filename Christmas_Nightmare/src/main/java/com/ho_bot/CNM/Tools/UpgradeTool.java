package com.ho_bot.CNM.Tools;

import java.util.HashMap;

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
					player.sendMessage("���׷��̵� �Ϸ�");
				}
				else {
					player.sendMessage("��ᰡ �����մϴ�");
				}
			}
			else {
				player.sendMessage("�̹� ��ȭ�� ���� �Ϸ�Ǿ����ϴ�");
			}
		}
		if(Armor.equals(WordVar.Leg_Up)) {
			int[] UpInt = TeamVar.Player_Upgrade.get(Up_player.getUniqueId());
			if(UpInt[1]<5) {
				if(P_Inv.ItemCheck(player, ItemVar.StoneItem().getType(), 3)) {
					P_Inv.ItemStackRemove(player, ItemVar.StoneItem(), 3);
					UpInt[1]=UpInt[1]+1;
					TeamVar.Player_Upgrade.put(Up_player.getUniqueId(), UpInt);
					player.sendMessage("���׷��̵� �Ϸ�");
				}
				else {
					player.sendMessage("��ᰡ �����մϴ�");
				}
			}
			else {
				player.sendMessage("�̹� ��ȭ�� ���� �Ϸ�Ǿ����ϴ�");
			}
		}
		if(Armor.equals(WordVar.Boots_Up)) {
			int[] UpInt = TeamVar.Player_Upgrade.get(Up_player.getUniqueId());
			if(UpInt[2]<5) {
				if(P_Inv.ItemCheck(player, ItemVar.WoolItem().getType(), 3)) {
					P_Inv.ItemStackRemove(player, ItemVar.WoolItem(), 3);
					UpInt[2]=UpInt[2]+1;
					TeamVar.Player_Upgrade.put(Up_player.getUniqueId(), UpInt);
					player.sendMessage("���׷��̵� �Ϸ�");
				}
				else {
					player.sendMessage("��ᰡ �����մϴ�");
				}
			}
			else {
				player.sendMessage("�̹� ��ȭ�� ���� �Ϸ�Ǿ����ϴ�");
			}
		}
	}
	
	public static void UpgradeJob(Player player, String Job) {
		int UpPoint = TeamVar.Team_JobUpPoint.get(TeamVar.Player_Team.get(player.getUniqueId()));
		if(UpPoint>=5) {
			HashMap<String, Integer> JopUp = TeamVar.Team_JobUpgrade.get(TeamVar.Player_Team.get(player.getUniqueId()));
			int JobUpPoint = JopUp.get(Job);
			if(JobUpPoint<5) {
				UpPoint=UpPoint-5;
				JobUpPoint++;
				JopUp.put(Job, JobUpPoint);
				TeamVar.Team_JobUpgrade.put(Job, JopUp);
				TeamVar.Team_JobUpPoint.put(TeamVar.Player_Team.get(player.getUniqueId()), UpPoint);
				player.sendMessage("���׷��̵尡 �Ϸ�Ǿ����ϴ� (���� ��������Ʈ : " + UpPoint + ")");
			}
			else {
				player.sendMessage("�ִ� ���׷��̵��Դϴ�");
			}
		}
		else {
			player.sendMessage("�ּ� 5�̻��� ��������Ʈ�� �ʿ��մϴ� (���� ��������Ʈ : " + UpPoint + ")");
		}
	}

}
