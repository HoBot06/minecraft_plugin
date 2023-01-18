package septagram.Theomachy.Timer;

import java.util.ArrayList;
import java.util.Collections;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import septagram.Theomachy.DB.GameData;
import septagram.Theomachy.Handler.CommandModule.TeamRandom;

public class GreenTime extends BukkitRunnable
{
	CommandSender sender;
	ArrayList<String> Green_Member;
	ArrayList<String> TeamList;
	public static ArrayList<String> Online_Member = new ArrayList<String>();
	public static ArrayList<String> Already_Member = new ArrayList<String>();
	public GreenTime(CommandSender sender, ArrayList<String> Green_Member, ArrayList<String> TeamList)
	{
		this.Green_Member=Green_Member;
		this.TeamList=TeamList;
		this.sender=sender;
	}
	
	public int count=1;
	public static int m_count = 0;
	public void run()
	{		
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
				GameData.PlayerTeam.clear();
				break;
			case 4: 
				for(String playerName : Online_Member) {
					String teamNameOld = GameData.PlayerTeam.get(playerName);
					if (teamNameOld == null) //플레이어 팀 초기화
					{
						GameData.PlayerTeam.put(playerName, TeamList.get(0));
						Bukkit.broadcastMessage("플레이어 "+ChatColor.RED+playerName+ChatColor.WHITE+" (이)가 팀 "+ChatColor.DARK_AQUA+TeamList.get(0)+ChatColor.WHITE+" 에 등록되었습니다.");
					}
					else //플레이어 팀 변경
					{
						GameData.PlayerTeam.put(playerName, TeamList.get(0));
						Bukkit.broadcastMessage("플레이어 "+ChatColor.RED+playerName+ChatColor.WHITE+" 의 팀이 변경되었습니다.    "+ChatColor.BLUE+teamNameOld+ChatColor.WHITE+" > "+ChatColor.DARK_AQUA+TeamList.get(0));
					}
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
					String teamNameOld = GameData.PlayerTeam.get(Online_Member.get(i));
					if (teamNameOld == null) //플레이어 팀 초기화
					{
						GameData.PlayerTeam.put(Online_Member.get(i), TeamList.get(1));
						Bukkit.broadcastMessage("플레이어 "+ChatColor.RED+Online_Member.get(i)+ChatColor.WHITE+" (이)가 팀 "+ChatColor.DARK_AQUA+TeamList.get(1)+ChatColor.WHITE+" 에 등록되었습니다.");
					}
					else //플레이어 팀 변경
					{
						GameData.PlayerTeam.put(Online_Member.get(i), TeamList.get(1));
						Bukkit.broadcastMessage("플레이어 "+ChatColor.RED+Online_Member.get(i)+ChatColor.WHITE+" 의 팀이 변경되었습니다.    "+ChatColor.BLUE+teamNameOld+ChatColor.WHITE+" > "+ChatColor.DARK_AQUA+TeamList.get(1));
					}
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
