package septagram.Theomachy.Manager;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import septagram.Theomachy.Theomachy;
import septagram.Theomachy.Handler.CommandHandler;


public class CommandManager implements CommandExecutor
{
	public CommandManager(Theomachy t)
	{
		t.getCommand("t").setExecutor(this);
		t.getCommand("x").setExecutor(this);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label,String[] data) {

		if (label.equals("t"))
		{
			if (data.length==0) //���� ����
			{
				sender.sendMessage(ChatColor.AQUA+("��        "+ChatColor.WHITE+"�ŵ��� ���� ��ɾ� �϶�"+ChatColor.AQUA+"        ��"));
				sender.sendMessage(ChatColor.YELLOW+("/t  start    ")+ChatColor.WHITE+("������ �����մϴ�."));
				sender.sendMessage(ChatColor.YELLOW+("/t  stop     ")+ChatColor.WHITE+("������ �����մϴ�."));
				sender.sendMessage(ChatColor.YELLOW+("/t  ability(a)     ")+ChatColor.WHITE+("�ɷ��� �����մϴ�"));
				sender.sendMessage(ChatColor.YELLOW+("/t  alist ")+ChatColor.WHITE+("����� �ɷ��� Ȯ���մϴ�."));
				sender.sendMessage(ChatColor.YELLOW+("/t  help     ")+ChatColor.WHITE+("�ڽ��� �ɷ��� Ȯ���մϴ�."));
				sender.sendMessage(ChatColor.YELLOW+("/t  spawn(s) ")+ChatColor.AQUA+("<TeamName>   ")+ChatColor.WHITE+("�ش� ���� ���������� �����մϴ�."));
				sender.sendMessage(ChatColor.YELLOW+("/t  team(t)  ")+ChatColor.AQUA+("<TeamName>  ")+ChatColor.RED+("<Player>  ")+ChatColor.WHITE+("�÷��̾ ���� ����մϴ�."));
				sender.sendMessage(ChatColor.YELLOW+("/t  info(i)  ")+ChatColor.AQUA+("<TeamName>     ")+ChatColor.WHITE+("�ش� ���� ����� Ȯ���մϴ�."));
				sender.sendMessage(ChatColor.YELLOW+("/t  clear(c) ")+ChatColor.WHITE+("��Ÿ���� �ʱ�ȭ�մϴ�."));
				sender.sendMessage(ChatColor.YELLOW+("/t  black    ")+ChatColor.WHITE+("������Ʈ �ý����� ���ϴ�."));
				sender.sendMessage(ChatColor.YELLOW+("/t  set      ")+ChatColor.WHITE+("GUI ���� �ý����� ���ϴ�."));
				sender.sendMessage(ChatColor.YELLOW+("/t  random   ")+ChatColor.AQUA+("<TeamName>...     ")+ChatColor.WHITE+("���� �������� �����մϴ�."));
				sender.sendMessage(ChatColor.YELLOW+("/t  green    ")+ChatColor.WHITE+("���� �� �����Դϴ�."));
				sender.sendMessage(ChatColor.YELLOW+("/x  ")+ChatColor.RED+("<Player>     ")+ChatColor.WHITE+("�ش� �÷��̾ �ڽ��� Ÿ������ ����մϴ�"));
				sender.sendMessage(ChatColor.AQUA+"��  �ȳ�  ��"+ChatColor.WHITE+"/t help �̿��� ����� ��� OP �����Դϴ�.");
			}
			else
				CommandHandler.T_Handler(sender, command, label, data);
		}
		else if (label.equalsIgnoreCase("x"))
		{
			if (data.length==0) //���� ����
				sender.sendMessage(ChatColor.YELLOW+("/x  ")+ChatColor.RED+("<Player>     ")+ChatColor.WHITE+("�ش� �÷��̾ �ڽ��� Ÿ������ ����մϴ�"));
			else
				CommandHandler.X_Handler(sender, command, label, data);
		}
		return true;
	}
}
