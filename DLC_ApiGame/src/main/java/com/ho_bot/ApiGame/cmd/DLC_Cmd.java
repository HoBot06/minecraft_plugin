package com.ho_bot.ApiGame.cmd;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;

import com.ho_bot.ApiGame.file.ConfigFile;
import com.ho_bot.ApiGame.file.DiaFile;
import com.ho_bot.ApiGame.main.DLC_ApiGame;
import com.ho_bot.ApiGame.timer.BoardTimer;
import com.ho_bot.ApiGame.util.VarUtil;

public class DLC_Cmd implements TabExecutor{
	
	private ConfigFile configF = new ConfigFile();
	private DiaFile diaF = new DiaFile();

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(args[0].equalsIgnoreCase("reload")) {
			//무조건 config가 나중에
			diaF.reloadDiaFile();
			
			configF.reloadConfig();
			sender.sendMessage("콘피그 리로드 완료");
		}
		if(args[0].equalsIgnoreCase("보드켜기")) {
			if(VarUtil.turnBoard) {
				sender.sendMessage("이미 보드가 켜져있습니다");
				return true;
			}
			else {
				VarUtil.turnBoard = true;
				BoardTimer boardT = new BoardTimer();
				boardT.runTaskTimerAsynchronously(DLC_ApiGame.inst, 0, VarUtil.apiGameConfig.time);
				sender.sendMessage("보드가 켜졌습니다");
				return false;
			}
		}
		if(args[0].equalsIgnoreCase("보드끄기")) {
			if(!VarUtil.turnBoard) {
				sender.sendMessage("이미 보드가 꺼져있습니다");
				return true;
			}
			else {
				VarUtil.turnBoard = false;
				sender.sendMessage("보드가 꺼졌습니다");
				return false;
			}
		}
		if(args[0].equalsIgnoreCase("test")) {
			for(String s : VarUtil.dia_Board.lore) {
				sender.sendMessage(s);
			}
		}
		return false;
	}

}
