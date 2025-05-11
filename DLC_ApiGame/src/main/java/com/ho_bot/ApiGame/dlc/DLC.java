package com.ho_bot.ApiGame.dlc;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import com.ho_bot.ApiGame.file.player.PlayerDiaFile;
import com.ho_bot.ApiGame.tools.RoulTools;
import com.ho_bot.ApiGame.util.NumUtil;
import com.ho_bot.dlc.DLC_Donation;

public class DLC extends DLC_Donation{
	
	private PlayerDiaFile pdf = new PlayerDiaFile();
	
	private NumUtil numU = new NumUtil();
	
	private RoulTools roulT = new RoulTools();

	public DLC(String key) {
		super(key);
	}

	@Override
	public void active(UUID uuid, String playername, String sender, String platform, int cash, String cmd) {
		String[] s_s = cmd.split(" ");
		if(s_s[0].equalsIgnoreCase(":다이아")) {
			try {
				if(s_s[2].split("~").length > 1) {
					int count = numU.getRandNum(s_s[2]);
					if(s_s[1].equalsIgnoreCase("PLAYER")) {
						pdf.addRemainDia(uuid, count);
					}
					if(s_s[1].equalsIgnoreCase("ALL")) {
						for(Player p : Bukkit.getOnlinePlayers()) {
							pdf.addRemainDia(p.getUniqueId(), count);
						}
					}
				}
				else {
					int count = Integer.parseInt(s_s[2]);
					if(s_s[1].equalsIgnoreCase("PLAYER")) {
						pdf.addRemainDia(uuid, count);
					}
					if(s_s[1].equalsIgnoreCase("ALL")) {
						for(Player p : Bukkit.getOnlinePlayers()) {
							pdf.addRemainDia(p.getUniqueId(), count);
						}
					}
				}
			} catch (Exception e) {
			}
			return;
		}
		//honation:ApiGame:룰렛 테스트룰렛
		if(s_s[0].equalsIgnoreCase(":룰렛")) {
			String roulname = s_s[1];
			roulT.runRoul(Bukkit.getPlayer(uuid), roulname, uuid, playername, sender, platform, cash);
			return;
		}
	}

}
