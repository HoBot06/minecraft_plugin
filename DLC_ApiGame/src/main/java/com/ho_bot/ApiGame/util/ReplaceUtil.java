package com.ho_bot.ApiGame.util;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;

import com.ho_bot.ApiGame.classes.BoardClass;
import com.ho_bot.ApiGame.file.player.PlayerDiaFile;

public class ReplaceUtil {
	
	private PlayerDiaFile pdf = new PlayerDiaFile();
	
	public String replaceBoard(String str, BoardClass board) {
		
		return str;
	}
	
	public List<String> replaceBoard_L(List<String> list, BoardClass board) {
		List<String> newList = new ArrayList<>();
		for(String s : list) {
			newList.add(replaceBoard(s, board));
		}
		return newList;
	}
	
	public String replacePlayer(String str, Player player) {
		str=str.replace("%playername%", player.getName());
		str=str.replace("%displayname%", player.getDisplayName());
		str=str.replace("%customname%", player.getCustomName());
		str=str.replace("%남은다이아%", pdf.getRemainDia(player.getUniqueId())+"");
		str=str.replace("%제출한다이아%", pdf.getCompleteDia(player.getUniqueId())+"");
		return str;
	}
	
	public List<String> replacePlayer_L(List<String> list, Player player) {
		List<String> newList = new ArrayList<>();
		for(String s : list) {
			newList.add(replacePlayer(s, player));
		}
		return newList;
	}

}
