package com.ho_bot.Siege_Flag.Team;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerChatEvent;

public class TeamChat {
	
	public TeamFile TeamF = new TeamFile();
	
	public void TeamSettingChat(PlayerChatEvent event) {
		if(TeamVar.TeamSettingDisplay.containsKey(event.getPlayer().getUniqueId())) {
			Player player = event.getPlayer();
			boolean isTSD = TeamVar.TeamSettingDisplay.get(player.getUniqueId());
			if(isTSD) {
				String chat = event.getMessage();
				if(chat.equalsIgnoreCase("cancel")) {
					player.sendMessage(ChatColor.RED+"취소되었습니다");
				}
				else {
					Team team = TeamF.getTeam(TeamVar.TeamSelect.get(player.getUniqueId()));
					TeamF.addTeamFile(team.TeamName, chat, team.TeamColor, team.TeamBlock);
				}
				TeamVar.TeamSettingDisplay.put(player.getUniqueId(), false);
				event.setCancelled(true);
			}
		}
	}

}
