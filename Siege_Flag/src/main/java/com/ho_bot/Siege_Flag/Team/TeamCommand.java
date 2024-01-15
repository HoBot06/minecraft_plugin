package com.ho_bot.Siege_Flag.Team;

import java.util.List;

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
			TeamF.setTeamFile(args[1], args[2], "White", Material.STONE);
			player.sendMessage("팀 추가됨");
		}
		else {
			sender.sendMessage("[SiegeF] 플레이어가 입력해야합니다");
		}
	}
	
	/*public void TeamListCommand(CommandSender sender) {
		List<Team> teamlist = TeamF.getTeamFile();
		int count = 1;
		sender.sendMessage("================");
		sender.sendMessage("");
		for(Team team : teamlist) {
			sender.sendMessage(ChatColor.WHITE + ""+count+". "+ColorU.returnChatColor(team.TeamColor)+team.TeamName);
			count++;
		}
		sender.sendMessage("");
		sender.sendMessage("================");
	}*/
	
	public void TeamSettingCommand(CommandSender sender) {
		if(sender instanceof Player) {
			TeamG.OpenTeamSettingListGui((Player) sender);
		}
		else {
			sender.sendMessage("[SiegeF] 플레이어가 입력해야합니다");
		}
	}

}
