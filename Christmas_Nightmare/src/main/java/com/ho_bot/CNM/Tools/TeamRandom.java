package com.ho_bot.CNM.Tools;

import java.util.ArrayList;
import java.util.Collections;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.ho_bot.CNM.Utility.TeamUtil;
import com.ho_bot.CNM.Var.EtcVar;
import com.ho_bot.CNM.Var.WordVar;

public class TeamRandom {
	
	public static TeamUtil TU = new TeamUtil();
	
	public static void Module(CommandSender sender, ArrayList<String> TeamList)
	{
		TeamList.remove(0);
		ArrayList<String> PlayerName_A = new ArrayList<String>();
		for(Player pp : Bukkit.getOnlinePlayers()) {
			PlayerName_A.add(pp.getName());
		}
		Collections.shuffle(PlayerName_A);
		int Team_Num = 0;
		for(String playerName : PlayerName_A) {
			Player p = Bukkit.getPlayer(playerName);
			TU.TeamSet(p, p, TeamList.get(Team_Num%TeamList.size()));
			PlayerTeleport(p, TeamList.get(Team_Num%TeamList.size()));
			Team_Num++;
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
			Player p = Bukkit.getPlayer(playerName);
			TU.TeamSet(p, p, TeamList.get(Team_Num%TeamList.size()));
			PlayerTeleport(p, TeamList.get(Team_Num%TeamList.size()));
			Team_Num++;
		}
	}
	
	public static void PlayerTeleport(Player player, String s) {
		if(s.equalsIgnoreCase(WordVar.Santa)) {
			player.teleport(EtcVar.SantaRoleLoc);
			return;
		}
		if(s.equalsIgnoreCase(WordVar.Krampus)) {
			player.teleport(EtcVar.KrampusRoleLoc);
			return;
		}
	}
}
