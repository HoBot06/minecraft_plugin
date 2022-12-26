package septagram.Theomachy.Timer.Skill;

import java.util.List;
import java.util.TimerTask;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class WizardDisasterTimer extends BukkitRunnable
{
	final private List<Player> targetList;
	final private Player player;
	private int duration;
	
	public WizardDisasterTimer(List<Player> targetList, Player player, int duration)
	{
		this.targetList=targetList;
		this.player=player;
		this.duration=duration;
	}
	
	public void run()
	{
		World world = player.getWorld();
		for (Player e : targetList)
		{
			Location location = e.getLocation();
			world.strikeLightning(location);
			e.setFireTicks(100);
		}
		if(duration <= 0) {
			this.cancel();
		}
		duration--;
	}
}
