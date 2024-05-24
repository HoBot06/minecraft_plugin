package com.ho_bot.Siege_Flag.Command;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import com.ho_bot.Siege_Flag.Team.TeamFile;

public class SF_TabCompleter implements TabCompleter{
	
	public TeamFile TeamF = new TeamFile();

	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		if(alias.equalsIgnoreCase("SiegeF")) {
			if(args.length == 1) {
				List<String> tablist = new ArrayList<String>();
				tablist.add("팀");
				tablist.add("구역");
				return tablist;
			}
			else if(args.length == 2) {
				if(args[0].equalsIgnoreCase("팀")) {
					List<String> tablist = new ArrayList<String>();
					tablist.add("생성");
					tablist.add("설정");
					tablist.add("참가");
					tablist.add("확인");
					return tablist;
				}
				if(args[0].equalsIgnoreCase("구역")) {
					List<String> tablist = new ArrayList<String>();
					tablist.add("생성");
					tablist.add("설정");
					tablist.add("활성화");
					return tablist;
				}
			}
			else if(args.length == 3) {
				if(args[0].equalsIgnoreCase("팀")) {
					if(args[1].equalsIgnoreCase("참가")) {
						return TeamF.getTeamNameList();
					}
				}
			}
			else if(args.length == 4) {
				if(args[0].equalsIgnoreCase("팀")) {
					if(args[1].equalsIgnoreCase("참가")) {
						List<String> pname_list = new ArrayList<String>();
						for(Player p : Bukkit.getOnlinePlayers()) {
							pname_list.add(p.getName());
						}
						return pname_list;
					}
				}
			}
			else {
				return null;
			}
		}
		return null;
	}

}
