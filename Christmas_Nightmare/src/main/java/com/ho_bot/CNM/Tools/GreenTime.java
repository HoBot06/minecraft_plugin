package com.ho_bot.CNM.Tools;

import java.util.ArrayList;
import java.util.Collections;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import com.ho_bot.CNM.Utility.TeamUtil;
import com.ho_bot.CNM.Var.EtcVar;
import com.ho_bot.CNM.Var.TeamVar;
import com.ho_bot.CNM.Var.WordVar;

public class GreenTime extends BukkitRunnable
{
	public TeamUtil TU = new TeamUtil();
	CommandSender sender;
	ArrayList<String> Green_Member;
	ArrayList<String> TeamList = new ArrayList<String>();;
	public static ArrayList<String> Online_Member = new ArrayList<String>();
	public static ArrayList<String> Already_Member = new ArrayList<String>();
	public GreenTime(CommandSender sender, ArrayList<String> Green_Member)
	{
		this.Green_Member=Green_Member;
		this.sender=sender;
	}
	
	public int count=1;
	public static int m_count = 0;
	public void run()
	{
		TeamList.add(WordVar.Santa);
		TeamList.add(WordVar.Krampus);
		if (count<12)
		{
			switch(count)
			{
			case 1: 
				Bukkit.broadcastMessage(ChatColor.BLUE + "등록된 멤버 : ");
				for(String s : Green_Member) {
					Bukkit.broadcastMessage(ChatColor.GOLD + "- " + s);
				}
				break;
			case 2: 
				Bukkit.broadcastMessage(ChatColor.BLUE + "현재 존재하는 멤버 : ");
				for(Player p : Bukkit.getOnlinePlayers()) {
					if(Green_Member.contains(p.getName())) {
						Online_Member.add(p.getName());
					}
				}
				for(String s : Online_Member) {
					Bukkit.broadcastMessage(ChatColor.GOLD + "- " + s);
				}
				break;
			case 3: 
				Bukkit.broadcastMessage(ChatColor.AQUA + "멤버 우선 팀 처리 및 초기화 중");
				TeamVar.Player_Team.clear();
				break;
			case 4: 
				for(String playerName : Online_Member) {
					Player p = Bukkit.getPlayer(playerName);
					TU.TeamSet(p, p, WordVar.Santa);
					p.teleport(EtcVar.SantaRoleLoc);
				}
				m_count = Online_Member.size();
				Bukkit.broadcastMessage(ChatColor.AQUA + "완료!");
				break;
			case 5: 
				Bukkit.broadcastMessage(ChatColor.BLUE + "남은 플레이어 : ");
				Online_Member.clear();
				for(Player p : Bukkit.getOnlinePlayers()) {
					if(!Green_Member.contains(p.getName())) {
						Online_Member.add(p.getName());
					}
				}
				for(String s : Online_Member) {
					Bukkit.broadcastMessage(ChatColor.GOLD + "- " + s);
				}
				break;
			case 6:
				Bukkit.broadcastMessage(ChatColor.AQUA + "멤버 수만큼 등가교환중...");
				break;
			case 7: 
				Collections.shuffle(Online_Member);
				for(int i=0; i<m_count; i++) {
					Player p = Bukkit.getPlayer(Online_Member.get(i));
					TU.TeamSet(p, p, WordVar.Krampus);
					p.teleport(EtcVar.KrampusRoleLoc);
					Already_Member.add(Online_Member.get(i));
				}
				break;
			case 8:
				Bukkit.broadcastMessage(ChatColor.BLUE + "남은 플레이어 : ");
				Online_Member.clear();
				for(Player p : Bukkit.getOnlinePlayers()) {
					if(!Already_Member.contains(p.getName())&&!Green_Member.contains(p.getName())) {
						Online_Member.add(p.getName());
					}
				}
				for(String s : Online_Member) {
					Bukkit.broadcastMessage(ChatColor.GOLD + "- " + s);
				}
				break;
			case 9:
				Bukkit.broadcastMessage(ChatColor.AQUA + "남은 플레이어 랜덤팀 보내는중..");
				break;
			case 10:
				if(Online_Member.size() > 0) {
					TeamRandom.Module_2(Online_Member, TeamList);
				}
				break;
			}
			
			
		}
		else
			this.cancel();
		count++;
	}
}
