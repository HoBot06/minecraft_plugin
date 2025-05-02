package com.ho_bot.ApiGame.timer;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import com.ho_bot.ApiGame.main.DLC_ApiGame;
import com.ho_bot.ApiGame.util.BoardUtil;
import com.ho_bot.ApiGame.util.VarUtil;

public class BoardTimer extends BukkitRunnable{
	
	private BoardUtil bu = new BoardUtil();

	@Override
	public void run() {
		if(!VarUtil.turnBoard) {
			VarUtil.turnBoard = false;
			for(Player p : Bukkit.getOnlinePlayers()) {
				new BukkitRunnable() {
					@Override
					public void run() {
						bu.removeScoreBoard(p);
					}
				}.runTask(DLC_ApiGame.inst);
			}
			cancel();
			return;
		}
		for(Player p : Bukkit.getOnlinePlayers()) {
			new BukkitRunnable() {
				@Override
				public void run() {
					bu.reloadScoreBoard(p, VarUtil.nowBoard);
				}
			}.runTask(DLC_ApiGame.inst);
		}
	}

}
