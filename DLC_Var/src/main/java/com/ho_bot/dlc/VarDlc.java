package com.ho_bot.dlc;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import com.ho_bot.main.DLC_Var;
import com.ho_bot.util.VarUtil;

public class VarDlc extends DLC_Donation{
	
	private Random rand = new Random();

	public VarDlc(String key) {
		super(key);
	}

	@Override
	public void active(UUID uuid, String playername, String sender, String platform, int cash, String cmd) {
		String[] cmd_s = cmd.split(" ");
		new BukkitRunnable() {
			
			@Override
			public void run() {
				Bukkit.getPlayer(uuid).sendMessage(cmd_s+"");
			}
		}.runTask(DLC_Var.inst);
	}


}
