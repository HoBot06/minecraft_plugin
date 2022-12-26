package septagram.Theomachy.Handler.CommandModule;

import java.util.Collection;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.scheduler.BukkitRunnable;

import septagram.Theomachy.Theomachy;
import septagram.Theomachy.Ability.Ability;
import septagram.Theomachy.DB.GameData;
import septagram.Theomachy.DB.ServerSetting;
import septagram.Theomachy.Timer.CoolTime;
import septagram.Theomachy.Timer.GameReadyTimer;
import septagram.Theomachy.Timer.TipTimer;
import septagram.Theomachy.Utility.PermissionChecker;

public class GameHandler
{
	public static boolean Ready=false;
	public static boolean Start=true;
	
	public static void GameReady(CommandSender sender)
	{
		if (PermissionChecker.Sender(sender))
		{
			if (!Ready)
			{
				Ready = true;
				Start = true;
				Bukkit.broadcastMessage(ChatColor.GOLD+"������("+sender.getName()+") �� ������ �����Ͽ����ϴ�.");
				BukkitRunnable GRT = new GameReadyTimer();
				BukkitRunnable TT = new TipTimer();
				if(!Theomachy.FAST_START)
					GRT.runTaskTimer(Theomachy.getPlugin(Theomachy.class), 0, 5L);
				else 
					GRT.runTaskTimer(Theomachy.getPlugin(Theomachy.class), 0, 20L);
				TT.runTaskTimer(Theomachy.getPlugin(Theomachy.class), 0, 20L);
			}
			else
				sender.sendMessage("������ �̹� ���۵Ǿ����ϴ�.");
		}
	}
	
	public static void GameStop(CommandSender sender)
	{
		if (PermissionChecker.Sender(sender))
		{
			if (Ready)
			{
				Collection<Ability> playerAbilityList = GameData.PlayerAbility.values();
				for (Ability e : playerAbilityList)
					e.conditionReSet();
				Ready=false;
				Start=false;
				CoolTime.ini=true;
				List<World> worlds = Bukkit.getWorlds();
				for (World world : worlds)
				{
					world.setPVP(ServerSetting.PVP);
					world.setSpawnFlags(ServerSetting.MONSTER, ServerSetting.ANIMAL);
					world.setAutoSave(ServerSetting.AUTO_SAVE);
					world.setDifficulty(ServerSetting.DIFFICULTY);
				}
				Bukkit.broadcastMessage(ChatColor.RED+"������("+sender.getName()+") �� ������ �����Ͽ����ϴ�.");
			}
			else
				sender.sendMessage("������ ���۵��� �ʾҽ��ϴ�.");
		}
	}
	
	
	
	
	

}
