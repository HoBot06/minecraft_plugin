package septagram.Theomachy.Utility;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PermissionChecker
{
	public static boolean Player(Player player)
	{
		if (player.isOp())
			return true;
		else
		{
			player.sendMessage("������ �����ϴ�.");
			return false;
		}
	}
	
	public static boolean Sender(CommandSender sender)
	{
		if (sender.isOp())
			return true;
		else
		{
			sender.sendMessage("������ �����ϴ�.");
			return false;
		}
	}
}
