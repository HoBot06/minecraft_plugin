package com.ho_bot.KoName.Cmd;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.ho_bot.KoName.File.NameFile;
import com.ho_bot.KoName.Util.NameUtil;

import xyz.haoshoku.nick.api.NickAPI;

public class Ko_Cmd implements CommandExecutor {
	
	public NameFile nameF = new NameFile();
	public NameUtil nameU = new NameUtil();

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender instanceof Player) {
			if(!sender.isOp()) {
				return false;
			}
		}
		Player player = (Player) sender;
		if(label.equalsIgnoreCase("닉네임")) {
			if(args.length == 1){
				nameF.setName(player, args[0]);
				nameU.refreshName(player);
			}
			else {
				Player p = Bukkit.getPlayer(args[1]);
				if(p==null) {
					player.sendMessage("유저가 인식되지 않았습니다");
				}
				else {
					nameF.setName(p, args[0]);
					nameU.refreshName(p);
				}
			}
		}
		if(label.equalsIgnoreCase("칭호")) {
			if(args.length == 1) {
				nameF.setPre(player, args[0]);
				nameU.refreshNick(player);
			}
			else {
				Player p = Bukkit.getPlayer(args[1]);
				if(p==null) {
					player.sendMessage("유저가 인식되지 않았습니다");
				}
				else {
					nameF.setName(p, args[0]);
					nameU.refreshName(p);
				}
			}
		}
		if(label.equalsIgnoreCase("koname")) {
			if(args[0].equalsIgnoreCase("reset")) {
				if(args.length == 1) {
					nameU.removeName(player);
				}
				else {
					Player p = Bukkit.getPlayer(args[1]);
					if(p==null) {
						player.sendMessage("유저가 인식되지 않았습니다");
					}
					else {
						nameU.removeName(p);
					}
				}
				return true;
			}
		}
		return false;
	}

}
