package septagram.Theomachy.Timer.Skill;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import septagram.Theomachy.DB.GameData;

public class ApollonPlayerScorching extends BukkitRunnable
{
	final String playerName;
	private int count;
	
	public ApollonPlayerScorching(Player player, int count)
	{
		this.playerName=player.getName();
		this.count=count;
		Bukkit.broadcastMessage(ChatColor.RED+"�¾��� �ſ� �߰ſ����ϴ�.");
	}
	public void run()
	{
		if(count>0)
		{
			List<Player> playerList = GameData.OnlinePlayer.get(playerName).getWorld().getPlayers();
			for (Player e : playerList)
			{
				if (e.getName() != playerName && e.getLocation().getBlock().getLightLevel() == 15)
					e.setFireTicks(100);
			}
		}
		else
		{
			Bukkit.broadcastMessage("�¾��� ���� �Ҿ����ϴ�.");
			World world = GameData.OnlinePlayer.get(playerName).getWorld();
			world.setTime(18000);
			this.cancel();
		}
		count--;
	}
}
