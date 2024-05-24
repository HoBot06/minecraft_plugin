package com.ho_bot.Siege_Flag.Area;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AreaCommand {
	
	public AreaFile AreaF = new AreaFile();
	public AreaGui AreaG = new AreaGui();
	
	public void AreaCreateCommand(CommandSender sender, String[] args) {
		if(sender instanceof Player) {
			Player player = (Player) sender;
			if(args[2]!=null) {
				if(AreaVar.AreaSel_left.containsKey(player)&&AreaVar.AreaSel_right.containsKey(player)) {
					Area area = new Area(args[2], Material.WHITE_CONCRETE, AreaVar.AreaSel_left.get(player), AreaVar.AreaSel_right.get(player));
					AreaF.addAreaList(area);
				}
			}
		}
	}
	
	public void AreaRemoveCommand(CommandSender sender, String[] args) {
		if(sender instanceof Player) {
			List<Area> arealist = new ArrayList<Area>();
			for(Area area : AreaVar.AreaList) {
				if(args[2].equalsIgnoreCase(area.AreaName)) {
					for(Area farea : AreaVar.AreaList) {
						if(!farea.AreaName.equalsIgnoreCase(args[2])) {
							arealist.add(farea);
						}
					}
					AreaVar.AreaList = arealist;
					sender.sendMessage("구역을 삭제했습니다");
					return;
				}
			}
			sender.sendMessage("존재하지 않는 구역입니다");
		}
	}
	
	public void AreaGuiOpenCommand(CommandSender sender) {
		if(sender instanceof Player) {
			if(AreaVar.AreaList!=null) {
				AreaG.OpenAreaSettingList((Player) sender);
			}
			else {
				sender.sendMessage("생성된 구역이 없습니다");
			}
		}
	}
	
	public void AreaSettingCommand(CommandSender sender, String[] args) {
		if(sender instanceof Player) {
			Player player = (Player) sender;
			if(AreaVar.AreaPlayer.containsKey(player)) {
				if(AreaVar.AreaPlayer.get(player)) {
					AreaVar.AreaPlayer.put(player, true);
					sender.sendMessage("구역 생성 ON");
					sender.sendMessage("나무 괭이를 들고 좌클릭 우클릭으로 설정이 가능합니다");
				}
				else {
					AreaVar.AreaPlayer.put(player, false);
					sender.sendMessage("구역 생성 OFF");
				}
			}
			else {
				AreaVar.AreaPlayer.put(player, true);
				sender.sendMessage("구역 생성 ON");
				sender.sendMessage("나무 괭이를 들고 좌클릭 우클릭으로 설정이 가능합니다");
			}
		}
	}
	
}
