package com.ho_bot.Siege_Flag.Command;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

public class SF_TabCompleter implements TabCompleter{

	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		if(alias.equalsIgnoreCase("SiegeF")) {
			if(args.length == 1) {
				List<String> tablist = new ArrayList<String>();
				tablist.add("팀생성");
				//tablist.add("팀리스트");
				tablist.add("팀설정");
				return tablist;
			}
		}
		return null;
	}

}
