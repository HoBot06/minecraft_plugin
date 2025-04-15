package com.ho_bot.HoEatAll.cmd;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.ho_bot.HoEatAll.util.ItemUtil;

public class Ho_Cmd implements TabExecutor{
	
	private ItemUtil itemU = new ItemUtil();

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender instanceof Player p) {
			if(args.length > 0) {
				if(args[0].equalsIgnoreCase("음식만들기")) {
					float saturation = Float.parseFloat(args[1]);
					int nuration = Integer.parseInt(args[2]);
					float second = Float.parseFloat(args[3]);
					ItemStack item = p.getInventory().getItemInMainHand();
					p.getInventory().setItemInMainHand(itemU.setFood(item, true, saturation, nuration, second));
					p.sendMessage("손에 든 아이템을 음식으로 만들었습니다");
				}
			}
		}
		return false;
	}

}
