package com.ho_bot.Siege_Flag.Command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.ho_bot.Siege_Flag.Team.TeamCommand;

public class SF_Command implements CommandExecutor{
	
	public TeamCommand TeamC = new TeamCommand();

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if(label.equalsIgnoreCase("SiegeF")) {
			if(args[0].equalsIgnoreCase("팀생성")) {
				TeamC.TeamAddCommand(sender, args);
			}
			if(args[0].equalsIgnoreCase("팀설정")) {
				TeamC.TeamSettingCommand(sender);
			}
		}
		
		return false;
	}

}
