package septagram.Theomachy.Timer.Skill;

import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import septagram.Theomachy.DB.GameData;

public class ClockingTimer extends BukkitRunnable
{
	List<Player> targetList;
	Player player;
	private int duration;
	
	public ClockingTimer(List<Player> targetList, Player player, int duration)
	{
		this.targetList=targetList;
		this.player=player;
		this.duration=duration;
	}
	
	public void run()
	{
		if(duration <= 0) {
			try{
				if (GameData.PlayerAbility.get(player.getName()).flag)
				{
					player.sendMessage("은신 시간이 종료되었습니다.");
					GameData.PlayerAbility.get(player.getName()).flag = false;
				}
				for (Player e : targetList)
					e.showPlayer(player);
				}
			catch (Exception e)
			{
			}
			this.cancel();
		}
		duration--;
		
	}
}
