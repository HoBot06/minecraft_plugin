package septagram.Theomachy.Handler.CommandModule;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import septagram.Theomachy.DB.GameData;
import septagram.Theomachy.Utility.PermissionChecker;

public class Team
{
	public static void Module(CommandSender sender, Command command, String label, String[] data)
	{
		if (PermissionChecker.Sender(sender))
		{
			if (data.length>2)
			{
				for (int i=2; i<data.length; i++)
				{
					if (GameData.OnlinePlayer.containsKey(data[i]))
					{
						String playerName = data[i];
						String teamName = data[1];
						String teamNameOld = GameData.PlayerTeam.get(playerName);
						if (teamNameOld == null) //�÷��̾� �� �ʱ�ȭ
						{
							GameData.PlayerTeam.put(data[i], teamName);
							Bukkit.broadcastMessage("�÷��̾� "+ChatColor.RED+playerName+ChatColor.WHITE+" (��)�� �� "+ChatColor.DARK_AQUA+teamName+ChatColor.WHITE+" �� ��ϵǾ����ϴ�.");
						}
						else //�÷��̾� �� ����
						{
							GameData.PlayerTeam.put(data[i], teamName);
							Bukkit.broadcastMessage("�÷��̾� "+ChatColor.RED+playerName+ChatColor.WHITE+" �� ���� ����Ǿ����ϴ�.    "+ChatColor.BLUE+teamNameOld+ChatColor.WHITE+" > "+ChatColor.DARK_AQUA+teamName);
						}
					}
					else
						sender.sendMessage(data[i]+" �ش��ϴ� ������ �����ϴ�.");
				}
			}
			else
			{
				sender.sendMessage(ChatColor.YELLOW+("/t  team(t)   ")+ChatColor.AQUA+("<TeamName>  ")+ChatColor.RED+("<Player>  ")+ChatColor.WHITE+("�÷��̾ ���� ����մϴ�."));
				sender.sendMessage("�ѹ��� �ټ��� �÷��̾ �� ���� ��� �� �� �ֽ��ϴ�.");
				sender.sendMessage("ex) /t t  ��   �÷��̾�1   �÷��̾�2   �÷��̾�3");
			}
		}
	}
}
