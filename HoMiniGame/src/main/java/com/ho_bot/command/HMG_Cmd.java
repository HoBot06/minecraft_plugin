package com.ho_bot.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.ho_bot.LogLike.Items.Weapon.TestFish;
import com.ho_bot.LogLike.Items.Weapon.TestStick;
import com.ho_bot.LogLike.Items.Weapon.testWeapon;
import com.ho_bot.LogLike.Player.LogLikePlayerUtil;
import com.ho_bot.gamegui.FieldGui;
import com.ho_bot.gamegui.ItemOptionGui;

public class HMG_Cmd implements CommandExecutor {
	
	public FieldGui fieldG = new FieldGui();
	public ItemOptionGui itemOG = new ItemOptionGui();
	public LogLikePlayerUtil logplayerU = new LogLikePlayerUtil();

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(label.equalsIgnoreCase("HMG")) {
			if(sender instanceof Player) {
				if(args[0].equalsIgnoreCase("마크라이크")) {
					if(args[1].equalsIgnoreCase("test")) {
						Player player = (Player) sender;
						logplayerU.setPlayer(player);
						itemOG.openWeaponOption(player, new testWeapon(), new TestStick(), new TestFish());
						player.sendMessage("test");
					}
					if(args[1].equalsIgnoreCase("test2")) {
						Player player = (Player) sender;
						fieldG.openFieldGui(player);
						player.sendMessage("test2");
					}
				}
			}
		}
		return false;
	}

}
