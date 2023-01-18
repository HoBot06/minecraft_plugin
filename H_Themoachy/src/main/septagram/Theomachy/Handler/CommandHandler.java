package septagram.Theomachy.Handler;

import java.util.ArrayList;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import septagram.Theomachy.Ability.Ability;
import septagram.Theomachy.DB.GameData;
import septagram.Theomachy.Handler.CommandModule.AbilityInfo;
import septagram.Theomachy.Handler.CommandModule.AbilitySet;
import septagram.Theomachy.Handler.CommandModule.Blacklist;
import septagram.Theomachy.Handler.CommandModule.CoolTimeHandler;
import septagram.Theomachy.Handler.CommandModule.GUISetting;
import septagram.Theomachy.Handler.CommandModule.GameHandler;
import septagram.Theomachy.Handler.CommandModule.Help;
import septagram.Theomachy.Handler.CommandModule.Spawn;
import septagram.Theomachy.Handler.CommandModule.Team;
import septagram.Theomachy.Handler.CommandModule.TeamGreen;
import septagram.Theomachy.Handler.CommandModule.TeamInfo;
import septagram.Theomachy.Handler.CommandModule.TeamRandom;

public class CommandHandler
{
	public static void T_Handler(CommandSender sender, Command command, String label, String[] data)
	{
		if (data[0].equals("start"))
			GameHandler.GameReady(sender);
		else if (data[0].equals("stop"))
			GameHandler.GameStop(sender);
		else if (data[0].equals("ability") || data[0].equals("a"))
			AbilitySet.Module(sender, command, label, data);
		else if (data[0].equals("alist"))
			AbilityInfo.showAllAbility(sender);
		else if (data[0].equals("help"))
			Help.Module(sender, command, label, data);
		else if (data[0].equals("spawn") || data[0].equals("s"))
			Spawn.Module(sender, command, label, data);
		else if (data[0].equals("team") || data[0].equals("t" ))
			Team.Module(sender, command, label, data);
		else if (data[0].equals("info") || data[0].equals("i"))
			TeamInfo.Module(sender, command, label, data);
		else if (data[0].equals("clear") || data[0].equals("c"))
			CoolTimeHandler.Module(sender, command, label, data);
		else if (data[0].equals("black")) 
			Blacklist.Module(sender);
		else if (data[0].equals("set"))
			GUISetting.Module(sender);
		else if (data[0].equals("random")) {
			ArrayList<String> args = new ArrayList<>();
			for(String s : data) {
				args.add(s);
			}
			TeamRandom.Module(sender, args);
		}
		else if (data[0].equals("green")) {
			TeamGreen.Module(sender);
		}
		else
			sender.sendMessage("�߸��� ����Դϴ�.");
	}
	
	public static void X_Handler(CommandSender sender, Command command, String label, String[] data)
	{
		String playerName = sender.getName();
		String targetName = data[0];
		Ability ability = GameData.PlayerAbility.get(playerName);
		if (ability != null)
		{
			if (GameData.OnlinePlayer.containsKey(targetName))
				ability.targetSet(sender, targetName);
			else
				sender.sendMessage("�¶��� �÷��̾ �ƴմϴ�.  "+targetName);
		}
		else
			sender.sendMessage("�ɷ��� �����ϴ�.");
	}
}
