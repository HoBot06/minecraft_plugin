package com.ho_bot.dlc;

import java.util.Map;
import java.util.Random;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import com.ho_bot.util.DLCUtil;
import com.ho_bot.util.VarUtil;

public class VarDlc extends DLC_Donation{
	
	//private Random rand = new Random();

	public VarDlc(String key) {
		super(key);
	}

	@Override
	public void active(UUID uuid, String playername, String sender, String platform, int cash, String cmd) {
		String[] cmd_s = cmd.split(" ");
		if(cmd_s[0].equalsIgnoreCase(":isop")) {
			isOp(uuid, playername, sender, platform, cash, cmd);
		}
		
	}
	
	private void isOp(UUID uuid, String playername, String sender, String platform, int cash, String cmd) {
		if(Bukkit.getPlayer(uuid) == null) return;
		if(!Bukkit.getPlayer(uuid).isOp()) return;
		Map<String, DLC_Donation> dlc_list = DLCUtil.getDlclist();
		String s_cmd = cmd.replace(":isop ", "");
		String[] ho_cmd = s_cmd.split(":");
		if(ho_cmd[0].equalsIgnoreCase("honation")) {
			if(ho_cmd.length >= 2) {
				try {
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
					if(VarUtil.dlclist.containsKey(ho_cmd[1])) {
						String dlc_cmd = s_cmd.replace("honation:"+ho_cmd[1], "");
						dlc_list.get(ho_cmd[1]).active(uuid, playername, sender, platform, cash, dlc_cmd);
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
