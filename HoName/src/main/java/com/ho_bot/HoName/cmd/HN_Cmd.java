package com.ho_bot.HoName.cmd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

import com.ho_bot.HoName.file.ConfigFile;
import com.ho_bot.HoName.file.PlayerFile;
import com.ho_bot.HoName.util.NameUtil;
import com.ho_bot.HoName.util.VarUtil;

import xyz.haoshoku.nick.api.NickAPI;

public class HN_Cmd implements TabExecutor{
	
	private NameUtil nameU = new NameUtil();
	private PlayerFile playerF = new PlayerFile();
	private ConfigFile configF = new ConfigFile();

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		try {
			if(args[0].equalsIgnoreCase("닉네임")) {
				Player p = Bukkit.getPlayer(args[1]);
				String nick = args[2];
				playerF.setPlayerNick(p, nick);
				nameU.reloadNick(p);
				sender.sendMessage("닉네임 설정");
			}
			if(args[0].equalsIgnoreCase("칭호")) {
				Player p = Bukkit.getPlayer(args[1]);
				String prefix = args[2];
				playerF.setPlayerPrefix(p, prefix);
				nameU.reloadNick(p);
				sender.sendMessage("닉네임 설정");
			}
			if(args[0].equalsIgnoreCase("리셋")) {
				Player p = Bukkit.getPlayer(args[1]);
				nameU.resetPlayer(p);
				sender.sendMessage("리셋 완료");
			}
			if(args[0].equalsIgnoreCase("리로드")) {
				configF.reloadConfig();
				sender.sendMessage("Config 파일 리로드 완료");
			}
		} catch (Exception e) {
			HelpUsage(sender);
			return false;
		}
		return false;
	}
	
	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
		if(args.length == 1) return Arrays.asList("닉네임", "칭호", "리셋", "리로드");
		if(args.length == 2) {
			if(args[0].equalsIgnoreCase("닉네임")||args[0].equalsIgnoreCase("칭호")||args[0].equalsIgnoreCase("리셋")) {
				List<String> nicklist = new ArrayList<>();
				for(Player p : Bukkit.getOnlinePlayers()) {
					nicklist.add(p.getName());
				}
				return nicklist;
			}
		}
		return Arrays.asList("");
	}
	
	private void HelpUsage(CommandSender s) {
		s.sendMessage("=======================");
		s.sendMessage("/honame 닉네임 [마크닉네임] [설정할닉네임]");
		s.sendMessage("/honame 칭호 [마크닉네임] [설정할칭호]");
		s.sendMessage("/honame 리셋 [마크닉네임]");
		s.sendMessage("/honame 리로드");
		s.sendMessage("=======================");
	}

}
