package com.ho_bot.HoName.cmd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

import com.ho_bot.HoName.manager.NameTag;
import com.ho_bot.HoName.manager.NickManager;

public class HN_Cmd implements TabExecutor{
	
	private NickManager nickManager = new NickManager();

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(args[0].equalsIgnoreCase("닉네임")) {
			Player p = Bukkit.getPlayer(args[1]);
			String nick = args[2];
			foo(p, nick);
			sender.sendMessage("닉네임 설정");
		}
		if(args[0].equalsIgnoreCase("칭호")) {
			
		}
		if(args[0].equalsIgnoreCase("리셋")) {
			Player p = Bukkit.getPlayer(args[1]);
			sender.sendMessage("리셋 완료");
		}
		return false;
	}
	
	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
		if(args.length == 1) return Arrays.asList("닉네임", "칭호", "리셋");
		if(args.length == 2) {
			if(args[0].equalsIgnoreCase("닉네임")||args[0].equalsIgnoreCase("칭호")||args[0].equalsIgnoreCase("리셋")) {
				List<String> nicklist = new ArrayList<>();
				for(Player p : Bukkit.getOnlinePlayers()) {
					nicklist.add(p.getName());
				}
				return nicklist;
			}
		}
		return null;
	}
	
	private void foo(Player player, String name) {
	     //NameTag.of(name).applyTo(player);
		nickManager.changePlayerNameTag(player, name);
	}

}
