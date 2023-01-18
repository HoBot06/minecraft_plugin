package septagram.Theomachy.Handler.CommandModule;

import java.util.ArrayList;
import java.util.Collections;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import septagram.Theomachy.DB.GameData;
import septagram.Theomachy.Utility.PermissionChecker;

public class TeamRandom {
	public static void Module(CommandSender sender, ArrayList<String> TeamList)
	{
		if (PermissionChecker.Sender(sender))
		{
			TeamList.remove(0);
			ArrayList<String> PlayerName_A = new ArrayList<String>();
			for(Player pp : Bukkit.getOnlinePlayers()) {
				PlayerName_A.add(pp.getName());
			}
			Collections.shuffle(PlayerName_A);
			int Team_Num = 0;
			for(String playerName : PlayerName_A) {
				String teamNameOld = GameData.PlayerTeam.get(playerName);
				if (teamNameOld == null) //플레이어 팀 초기화
				{
					GameData.PlayerTeam.put(playerName, TeamList.get(Team_Num%TeamList.size()));
					Bukkit.broadcastMessage("플레이어 "+ChatColor.RED+playerName+ChatColor.WHITE+" (이)가 팀 "+ChatColor.DARK_AQUA+TeamList.get(Team_Num%TeamList.size())+ChatColor.WHITE+" 에 등록되었습니다.");
				}
				else //플레이어 팀 변경
				{
					GameData.PlayerTeam.put(playerName, TeamList.get(Team_Num%TeamList.size()));
					Bukkit.broadcastMessage("플레이어 "+ChatColor.RED+playerName+ChatColor.WHITE+" 의 팀이 변경되었습니다.    "+ChatColor.BLUE+teamNameOld+ChatColor.WHITE+" > "+ChatColor.DARK_AQUA+TeamList.get(Team_Num%TeamList.size()));
				}
				Team_Num++;
			}
		}
	}
	
	public static void Module_2(ArrayList<String> Player_List, ArrayList<String> TeamList)
	{
		ArrayList<String> PlayerName_A = new ArrayList<String>();
		for(String pp : Player_List) {
			PlayerName_A.add(pp);
		}
		Collections.shuffle(PlayerName_A);
		int Team_Num = 0;
		for(String playerName : PlayerName_A) {
			String teamNameOld = GameData.PlayerTeam.get(playerName);
			if (teamNameOld == null) //플레이어 팀 초기화
			{
				GameData.PlayerTeam.put(playerName, TeamList.get(Team_Num%TeamList.size()));
				Bukkit.broadcastMessage("플레이어 "+ChatColor.RED+playerName+ChatColor.WHITE+" (이)가 팀 "+ChatColor.DARK_AQUA+TeamList.get(Team_Num%TeamList.size())+ChatColor.WHITE+" 에 등록되었습니다.");
			}
			else //플레이어 팀 변경
			{
				GameData.PlayerTeam.put(playerName, TeamList.get(Team_Num%TeamList.size()));
				Bukkit.broadcastMessage("플레이어 "+ChatColor.RED+playerName+ChatColor.WHITE+" 의 팀이 변경되었습니다.    "+ChatColor.BLUE+teamNameOld+ChatColor.WHITE+" > "+ChatColor.DARK_AQUA+TeamList.get(Team_Num%TeamList.size()));
			}
			Team_Num++;
		}
	}
}
