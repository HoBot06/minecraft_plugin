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
			if (data.length==0) //설명 보기
			{
				sender.sendMessage(ChatColor.AQUA+("【        "+ChatColor.WHITE+"신들의 전쟁 명령어 일람"+ChatColor.AQUA+"        】"));
				sender.sendMessage(ChatColor.YELLOW+("/t  start    ")+ChatColor.WHITE+("게임을 시작합니다."));
				sender.sendMessage(ChatColor.YELLOW+("/t  stop     ")+ChatColor.WHITE+("게임을 중지합니다."));
				sender.sendMessage(ChatColor.YELLOW+("/t  ability(a)     ")+ChatColor.WHITE+("능력을 설정합니다"));
				sender.sendMessage(ChatColor.YELLOW+("/t  alist ")+ChatColor.WHITE+("적용된 능력을 확인합니다."));
				sender.sendMessage(ChatColor.YELLOW+("/t  help     ")+ChatColor.WHITE+("자신의 능력을 확인합니다."));
				sender.sendMessage(ChatColor.YELLOW+("/t  spawn(s) ")+ChatColor.AQUA+("<TeamName>   ")+ChatColor.WHITE+("해당 팀의 스폰지역을 설정합니다."));
				sender.sendMessage(ChatColor.YELLOW+("/t  team(t)  ")+ChatColor.AQUA+("<TeamName>  ")+ChatColor.RED+("<Player>  ")+ChatColor.WHITE+("플레이어를 팀에 등록합니다."));
				sender.sendMessage(ChatColor.YELLOW+("/t  info(i)  ")+ChatColor.AQUA+("<TeamName>     ")+ChatColor.WHITE+("해당 팀의 멤버를 확인합니다."));
				sender.sendMessage(ChatColor.YELLOW+("/t  clear(c) ")+ChatColor.WHITE+("쿨타임을 초기화합니다."));
				sender.sendMessage(ChatColor.YELLOW+("/t  black    ")+ChatColor.WHITE+("블랙리스트 시스템을 엽니다."));
				sender.sendMessage(ChatColor.YELLOW+("/t  set      ")+ChatColor.WHITE+("GUI 설정 시스템을 엽니다."));
				sender.sendMessage(ChatColor.YELLOW+("/t  random   ")+ChatColor.AQUA+("<TeamName>...     ")+ChatColor.WHITE+("팀을 랜덤으로 설정합니다."));
				sender.sendMessage(ChatColor.YELLOW+("/t  green    ")+ChatColor.WHITE+("전용 팀 세팅입니다."));
				sender.sendMessage(ChatColor.YELLOW+("/x  ")+ChatColor.RED+("<Player>     ")+ChatColor.WHITE+("해당 플레이어를 자신의 타겟으로 등록합니다"));
				sender.sendMessage(ChatColor.AQUA+"【  안내  】"+ChatColor.WHITE+"/t help 이외의 명령은 모두 OP 전용입니다.");
			}
			else
				CommandHandler.T_Handler(sender, command, label, data);
		}
		else if (label.equalsIgnoreCase("x"))
		{
			if (data.length==0) //설명 보기
				sender.sendMessage(ChatColor.YELLOW+("/x  ")+ChatColor.RED+("<Player>     ")+ChatColor.WHITE+("해당 플레이어를 자신의 타겟으로 등록합니다"));
			else
				CommandHandler.X_Handler(sender, command, label, data);
		}
		return true;
	}
}
