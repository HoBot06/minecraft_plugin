package com.ho_bot.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.ho_bot.file.ConfigFile;

public class Ho_Cmd implements CommandExecutor{
	
	private ConfigFile configF = new ConfigFile();

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(!sender.isOp()) return false;
		if(args[0].equalsIgnoreCase("reload")) {
			configF.reloadConfig();
			sender.sendMessage("[Hotamina] 리로드 완료!");
		}
		return false;
	}

}
