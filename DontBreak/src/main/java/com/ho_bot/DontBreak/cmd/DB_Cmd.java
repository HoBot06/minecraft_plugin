package com.ho_bot.DontBreak.cmd;

import java.util.Arrays;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

import com.ho_bot.DontBreak.area.Area;
import com.ho_bot.DontBreak.file.ConfigFile;
import com.ho_bot.DontBreak.file.LocFile;
import com.ho_bot.DontBreak.util.VarUtil;

public class DB_Cmd implements TabExecutor{
	
	private ConfigFile configF = new ConfigFile();
	private LocFile locF = new LocFile();

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(!(sender instanceof Player p)) return false;
		if(!p.isOp()) return false;
		try {
			if(args[0].equalsIgnoreCase("reload")) {
				configF.reloadConfig();
				p.sendMessage("config 리로드");
			}
			if(args[0].equalsIgnoreCase("setup")) {
				if(VarUtil.playerActive.containsKey(p.getUniqueId())) {
					if(VarUtil.playerActive.get(p.getUniqueId())) {
						VarUtil.playerActive.put(p.getUniqueId(), false);
						p.sendMessage("OFF");
					}
					else {
						VarUtil.playerActive.put(p.getUniqueId(), true);
						p.sendMessage("ON");
					}
				}
				else {
					VarUtil.playerActive.put(p.getUniqueId(), true);
					p.sendMessage("ON");
				}
			}
			if(args[0].equalsIgnoreCase("create")) {
				String name = args[1];
				if(VarUtil.areaPlayer.containsKey(p.getUniqueId())) {
					Area area = VarUtil.areaPlayer.get(p.getUniqueId());
					if(area.loc1 != null && area.loc2 != null) {
						area.areaName = name;
						
						locF.setLoc(area.areaName, area.loc1, area.loc2);
						p.sendMessage(area.areaName + " 구역 설정완료");
					}
					else {
						p.sendMessage("좌표를 지정해주십쇼");
					}
				}
			}
		} catch (Exception e) {
			HelpUsage(p);
		}
		return false;
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
		if(args.length == 1) return Arrays.asList("reload", "setup", "create");
		return null;
	}
	
	private void HelpUsage(Player p) {
		p.sendMessage("================");
		p.sendMessage("/DontBreak reload");
		p.sendMessage("/DontBreak setup");
		p.sendMessage("/DontBreak create [이름]");
		p.sendMessage("================");
	}
}
