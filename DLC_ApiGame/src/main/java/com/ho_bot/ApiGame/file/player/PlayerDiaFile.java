package com.ho_bot.ApiGame.file.player;

import java.io.File;
import java.util.UUID;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import com.ho_bot.ApiGame.main.DLC_ApiGame;
import com.ho_bot.ApiGame.util.YmlUtil;

public class PlayerDiaFile {
	
	private YmlUtil YU = new YmlUtil();
	
	public void createPlayerDia(Player player) {
		File file = new File(DLC_ApiGame.inst.getDataFolder() + File.separator + "플레이어데이터//다이아//"+player.getUniqueId().toString()+".yml");
		YamlConfiguration yml = YamlConfiguration.loadConfiguration(file);
		if(!file.exists()) {
			yml.set("남은다이아", 0);
			yml.set("제출한다이아", 0);
			YU.SetYml(file, yml);
		}
	}
	
	public int getRemainDia(UUID playeruuid) {
		File file = new File(DLC_ApiGame.inst.getDataFolder() + File.separator + "플레이어데이터//다이아//"+playeruuid.toString()+".yml");
		YamlConfiguration yml = YamlConfiguration.loadConfiguration(file);
		return yml.getInt("남은다이아", 0);
	}
	
	public int getCompleteDia(UUID playeruuid) {
		File file = new File(DLC_ApiGame.inst.getDataFolder() + File.separator + "플레이어데이터//다이아//"+playeruuid.toString()+".yml");
		YamlConfiguration yml = YamlConfiguration.loadConfiguration(file);
		return yml.getInt("제출한다이아", 0);
	}
	
	public void setRemainDia(UUID playeruuid, int amo) {
		File file = new File(DLC_ApiGame.inst.getDataFolder() + File.separator + "플레이어데이터//다이아//"+playeruuid.toString()+".yml");
		YamlConfiguration yml = YamlConfiguration.loadConfiguration(file);
		yml.set("남은다이아", amo);
		YU.SetYml(file, yml);
	}
	
	public void setCompleteDia(UUID playeruuid, int amo) {
		File file = new File(DLC_ApiGame.inst.getDataFolder() + File.separator + "플레이어데이터//다이아//"+playeruuid.toString()+".yml");
		YamlConfiguration yml = YamlConfiguration.loadConfiguration(file);
		yml.set("제출한다이아", amo);
		YU.SetYml(file, yml);
	}
	
	public void addRemainDia(UUID playeruuid, int amo) {
		int count = getRemainDia(playeruuid);
		count+=amo;
		setRemainDia(playeruuid, count);
	}
	
	public void addCompleteDia(UUID playeruuid, int amo) {
		int count = getCompleteDia(playeruuid);
		count+=amo;
		setCompleteDia(playeruuid, count);
	}

}
