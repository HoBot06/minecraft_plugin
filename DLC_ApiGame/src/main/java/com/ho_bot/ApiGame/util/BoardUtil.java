package com.ho_bot.ApiGame.util;
import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

import com.ho_bot.ApiGame.classes.BoardClass;
import com.ho_bot.ApiGame.main.DLC_ApiGame;

public class BoardUtil {
	
	private ReplaceUtil replaceU = new ReplaceUtil();

	public void reloadScoreBoard(Player player, BoardClass board) {
        Scoreboard scoreboard = DLC_ApiGame.scoreManager.getNewScoreboard();
        
        //타이틀 replace
        String title = board.title;
        title = replaceU.replaceBoard(title, board);
        title= replaceU.replacePlayer(title, player);
        
        //내용 replace
        List<String> lore = board.lore;
        lore = replaceU.replaceBoard_L(lore, board);
        lore = replaceU.replacePlayer_L(lore, player);
        
        //표시
        Objective objective = scoreboard.registerNewObjective(player.getUniqueId().toString(), "DUMMY", title);
        
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        
        for(int i = 0; i < lore.size(); i++) {
        	objective.getScore(lore.get(i)).setScore(lore.size()-i);
        }
        
        player.setScoreboard(scoreboard);
    }
	
	public void removeScoreBoard(Player player) {
		Scoreboard scoreboard = DLC_ApiGame.scoreManager.getNewScoreboard();
		player.setScoreboard(scoreboard);
	}
}
