package com.ho_bot.Siege_Flag.Command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.ho_bot.Siege_Flag.Area.AreaCommand;
import com.ho_bot.Siege_Flag.Area.AreaFile;
import com.ho_bot.Siege_Flag.Team.TeamCommand;
import com.ho_bot.Siege_Flag.Team.TeamFile;
import com.ho_bot.Siege_Flag.Team.TeamVar;

public class SF_Command implements CommandExecutor{
	
	public TeamCommand TeamC = new TeamCommand();
	public TeamFile TeamF = new TeamFile();
	public AreaCommand AreaC = new AreaCommand();
	public AreaFile AreaF = new AreaFile();

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if(label.equalsIgnoreCase("SiegeF")) {
			if(args[0].equalsIgnoreCase("팀")) {
				if(args.length > 1) {
					if(args[1].equalsIgnoreCase("생성")) {
						TeamC.TeamAddCommand(sender, args);
					}
					else if(args[1].equalsIgnoreCase("설정")) {
						TeamC.TeamSettingCommand(sender);
					}
					else if(args[1].equalsIgnoreCase("참가")) {
						TeamC.TeamJoinCommand(sender, args);
					}
					else if(args[1].equalsIgnoreCase("확인")) {
						TeamC.TeamCheckCommand(sender);
					}
				}
			}
			if(args[0].equalsIgnoreCase("구역")) {
				if(args.length > 1) {
					if(args[1].equalsIgnoreCase("생성")) {
						AreaC.AreaCreateCommand(sender, args);
					}
					else if(args[1].equalsIgnoreCase("설정")) {
						AreaC.AreaGuiOpenCommand(sender);
					}
					else if(args[1].equalsIgnoreCase("삭제")) {
						AreaC.AreaRemoveCommand(sender, args);
					}
				}
				else {
					AreaC.AreaSettingCommand(sender, args);
				}
			}
			if(args[0].equalsIgnoreCase("reload")) {
				TeamF.reloadTeamFile();
				AreaF.reloadAreaFile();
				sender.sendMessage("리로드 완료");
			}
		}
		
		return false;
	}

}
