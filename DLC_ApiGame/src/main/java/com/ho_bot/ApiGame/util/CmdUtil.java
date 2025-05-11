package com.ho_bot.ApiGame.util;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class CmdUtil {
	
	public void runCmd(String s_cmd, UUID uuid, String playername, String sender, String platform, int cash) {
		String[] ho_cmd = s_cmd.split(":");
		if(ho_cmd[0].equalsIgnoreCase("honation")) {
			if(ho_cmd.length >= 2) {
				try {
					if(ho_cmd[1].contains("op_player")) {
						String r_cmd = s_cmd.split(" ", 2)[1];
						final Player player = Bukkit.getPlayer(uuid);
						boolean op = player.isOp();
						player.setOp(true);
						Bukkit.dispatchCommand(player, r_cmd);
						if(!op) {
							player.setOp(false);
						}
						return;
					}
					if(ho_cmd[1].contains("player")) {
						String r_cmd = s_cmd.split(" ", 2)[1];
						final Player player = Bukkit.getPlayer(uuid);
						Bukkit.dispatchCommand(player, r_cmd);
						return;
					}
					if(ho_cmd[1].equalsIgnoreCase("chance")) {
						double num = Double.parseDouble(s_cmd.split(" ")[0].replace("honation:chance:", ""));
						double d_r = ThreadLocalRandom.current().nextDouble() * 100;
						String[] next_cmd = s_cmd.split(" ", 2);
						if(num > d_r) {
							runCmd(next_cmd[1], uuid, playername, sender, platform, cash);
							return;
						}
					}
					if(ho_cmd[1].equalsIgnoreCase("kill")) {
						final Player player = Bukkit.getPlayer(uuid);
						player.setHealth(0);
						return;
					}
					if(ho_cmd[1].equalsIgnoreCase("alltitle")) {
						String title = "";
						String subTitle = "";
						int fadeIn = 0;
						int stay = 0;
						int fadeOut = 0;
						for(int i = 2; i < ho_cmd.length; i++) {
							if(i==2) {
								title = ho_cmd[i].replace('&', ChatColor.COLOR_CHAR);
							}
							if(i==3) {
								subTitle = ho_cmd[i].replace('&', ChatColor.COLOR_CHAR);
							}
							if(i==4) {
								fadeIn = Integer.parseInt(ho_cmd[i]);
							}
							if(i==5) {
								stay = Integer.parseInt(ho_cmd[i]);
							}
							if(i==6) {
								fadeOut = Integer.parseInt(ho_cmd[i]);
							}
						}
						for(Player allp : Bukkit.getOnlinePlayers()) {
							allp.sendTitle(title, subTitle, fadeIn, stay, fadeOut);
						}
						return;
					}
					if(ho_cmd[1].equalsIgnoreCase("title")) {
						Player player = Bukkit.getPlayer(uuid);
						String title = "";
						String subTitle = "";
						int fadeIn = 0;
						int stay = 0;
						int fadeOut = 0;
						for(int i = 2; i < ho_cmd.length; i++) {
							if(i==2) {
								title = ho_cmd[i].replace('&', ChatColor.COLOR_CHAR);
							}
							if(i==3) {
								subTitle = ho_cmd[i].replace('&', ChatColor.COLOR_CHAR);
							}
							if(i==4) {
								fadeIn = Integer.parseInt(ho_cmd[i]);
							}
							if(i==5) {
								stay = Integer.parseInt(ho_cmd[i]);
							}
							if(i==6) {
								fadeOut = Integer.parseInt(ho_cmd[i]);
							}
						}
						player.sendTitle(title, subTitle, fadeIn, stay, fadeOut);
						return;
					}
					if(ho_cmd[1].equalsIgnoreCase("teleport")) {
						Player player = Bukkit.getPlayer(uuid);
						String world = ho_cmd[2];
						double x = Double.parseDouble(ho_cmd[3]);
						double y = Double.parseDouble(ho_cmd[4]);
						double z = Double.parseDouble(ho_cmd[5]);
						Location loc = new Location(Bukkit.getWorld(world), x, y, z);
						player.teleport(loc);
						return;
					}
					if(VarUtil.apidlclist.containsKey(ho_cmd[1])) {
						String dlc_cmd = s_cmd.replace("honation:"+ho_cmd[1], "");
						VarUtil.apidlclist.get(ho_cmd[1]).active(uuid, playername, sender, platform, cash, dlc_cmd);
						return;
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		else {
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), s_cmd);
		}
	}

}
