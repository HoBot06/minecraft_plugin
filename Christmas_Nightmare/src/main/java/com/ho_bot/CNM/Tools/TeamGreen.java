package com.ho_bot.CNM.Tools;

import java.util.ArrayList;

import org.bukkit.command.CommandSender;

import com.ho_bot.CNM.Main;

public class TeamGreen {
	public static void Module(CommandSender sender)
	{
		ArrayList<String> Player_Green = new ArrayList<String>();
		Player_Green.add("Ddang67");
		Player_Green.add("Ddun_kim");
		Player_Green.add("green_kim");
		Player_Green.add("Rev_0602");
		Player_Green.add("Dire5778");
		GreenTime GT = new GreenTime(sender, Player_Green);
		GT.runTaskTimer(Main.getPlugin(Main.class), 0, 20L);
	}
}
