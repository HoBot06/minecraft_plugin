package com.ho_bot.HB_Rune.cmd;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

import com.ho_bot.HB_Rune.inv.RuneInv;

public class HB_Cmd implements TabExecutor{
	
	private RuneInv runeI = new RuneInv();

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender instanceof Player p) {
			if(args.length == 1) {
				if(args[0].equalsIgnoreCase("가방")) {
					runeI.OpenRuneBagInv(p);
				}
				if(args[0].equalsIgnoreCase("설정")) {
					
				}
			}
		}
		return false;
	}
	
	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
		// TODO Auto-generated method stub
		return null;
	}

}
