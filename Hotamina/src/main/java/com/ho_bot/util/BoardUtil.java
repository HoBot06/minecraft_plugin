package com.ho_bot.util;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Criteria;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

import com.ho_bot.main.Hotamina;

public class BoardUtil {
	
	//private ConfigFile configF = new ConfigFile();
	//private StaminaUtil staminaU = new StaminaUtil();

	public void reloadScoreBoard(Player player, String stamina) {
        Scoreboard scoreboard = Hotamina.scoreManager.getNewScoreboard();
        
        Objective objective = scoreboard.registerNewObjective(player.getUniqueId().toString(), Criteria.DUMMY, ChatColor.YELLOW+player.getName());
        
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        
        objective.getScore(stamina).setScore(0);
        
        player.setScoreboard(scoreboard);
    }
}
