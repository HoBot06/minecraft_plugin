package com.ho_bot.Siege_Flag.Team;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.ho_bot.Siege_Flag.Util.ColorUtil;

public class TeamCommand {
	
	public TeamFile TeamF = new TeamFile();
	public ColorUtil ColorU = new ColorUtil();
	public TeamGui TeamG = new TeamGui();
	
	public void TeamAddCommand(CommandSender sender, String[] args) {
		if(sender instanceof Player) {
			Player player = (Player) sender;
			TeamF.addTeamFile(args[2], args[3], "White", Material.STONE);
			player.sendMessage("팀 추가됨");
		}
		else {
			sender.sendMessage("[SiegeF] 플레이어가 입력해야합니다");
		}
	}
	
	public void TeamSettingCommand(CommandSender sender) {
		if(sender instanceof Player) {
			TeamG.OpenTeamSettingListGui((Player) sender);
		}
		else {
			sender.sendMessage("[SiegeF] 플레이어가 입력해야합니다");
		}
	}
	
	public void TeamJoinCommand(CommandSender sender, String[] args) {
		if(sender instanceof Player) {
			List<Team> teamlist = TeamVar.Teamlist;
			for(Team team : teamlist) {
				if(team.TeamName.equalsIgnoreCase(args[2])) {
					if(Bukkit.getPlayer(args[3])!=null) {
						TeamF.setPlayerTeam(args[2], Bukkit.getPlayer(args[3]));
					}
					else {
						sender.sendMessage("존재하지 않는 플레이어입니다");
					}
					return;
				}
			}
			sender.sendMessage("존재하지 않는 팀입니다");
		}
	}
	
	public void TeamCheckCommand(CommandSender sender) {
		List<Team> teamlist = TeamVar.Teamlist;
		for(Team team : teamlist) {
			sender.sendMessage(team.TeamName);
			if(team.playerlist!=null) {
				for(Player player : team.playerlist) {
					sender.sendMessage("- " + player.getDisplayName());
				}
			}
		}
	}

}
