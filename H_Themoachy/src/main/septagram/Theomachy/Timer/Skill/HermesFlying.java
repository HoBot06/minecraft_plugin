package septagram.Theomachy.Timer.Skill;

import java.util.TimerTask;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class HermesFlying extends BukkitRunnable
{
	final Player player;
	private int count = 3;
	
	public HermesFlying(Player player)
	{
		this.player=player;
		player.sendMessage("���� �� �� �ֽ��ϴ�.");
	}
	
	public void run()
	{
		if (count == 0)
		{
			player.sendMessage(ChatColor.RED+"����ð��� ����Ǿ����ϴ�.");
			player.setAllowFlight(false);
			player.setFallDistance(0);
			this.cancel();
		}
		else
		player.sendMessage("����ð��� "+ChatColor.AQUA+count+ChatColor.WHITE+"�� ���ҽ��ϴ�.");
		count--;
	}
}
