package com.ho_bot.AntWar;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.ho_bot.AntWar.Team.TeamCommand;
import com.ho_bot.AntWar.Util.ColorUtil;
import com.ho_bot.AntWar.Util.StartUtil;
import com.ho_bot.AntWar.Var.GameVar;

public class AntWarCommand implements CommandExecutor{
	
	public TeamCommand TeamC = new TeamCommand();
	public StartUtil StartU = new StartUtil();
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(label.equalsIgnoreCase("AntWar")) {
			if(args[0].equalsIgnoreCase("Start")) {
				GameVar.isGame = true;
				StartU.GameStart();
			}
			if(args[0].equalsIgnoreCase("Stop")) {
				GameVar.isGame = false;
			}
			if(args[0].equalsIgnoreCase("Team")) {
				if(args[1].equalsIgnoreCase("create")) {
					String TeamName = args[2];
					String TeamDisplay = args[3];
					TeamC.setTeam(TeamName, TeamDisplay, ColorUtil.AntColor.WHITE);
				}
				if(args[1].equalsIgnoreCase("remove")) {
					String TeamName = args[2];
					TeamC.removeTeam(TeamName);
				}
			}
			if(args[0].equalsIgnoreCase("Player")) {
				if(args[1].equalsIgnoreCase("set")) {
					String TeamName = args[2];
					Player P = Bukkit.getPlayer(args[3]);
					TeamC.setPlayerTeam(TeamName, P);
				}
				if(args[1].equalsIgnoreCase("get")) {
					String TeamName = args[2];
					Player P = Bukkit.getPlayer(args[3]);
					TeamC.getPlayerTeam(TeamName, P);
				}
				if(args[1].equalsIgnoreCase("remove")) {
					Player P = Bukkit.getPlayer(args[2]);
					TeamC.removePlayerTeam(P);
				}
			}
		}
		return false;
	}

}
