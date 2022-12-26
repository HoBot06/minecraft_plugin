package septagram.Theomachy.Handler.CommandModule;

import java.util.ArrayList;

import org.bukkit.command.CommandSender;

import septagram.Theomachy.Theomachy;
import septagram.Theomachy.Timer.GreenTime;
import septagram.Theomachy.Utility.PermissionChecker;

public class TeamGreen {
	public static void Module(CommandSender sender)
	{
		if (PermissionChecker.Sender(sender))
		{
			ArrayList<String> TeamList = new ArrayList<String>();
			ArrayList<String> Player_Green = new ArrayList<String>();
			Player_Green.add("Ddang67");
			Player_Green.add("newpokemon_");
			Player_Green.add("Flower_piggy97");
			Player_Green.add("green_kim");
			Player_Green.add("momo_52");
			Player_Green.add("Rev_0602");
			Player_Green.add("Dire5778");
			TeamList.add("red"); TeamList.add("blue");
			GreenTime GT = new GreenTime(sender, Player_Green, TeamList);
			GT.runTaskTimer(Theomachy.getPlugin(Theomachy.class), 0, 20L);
		}
	}
}
