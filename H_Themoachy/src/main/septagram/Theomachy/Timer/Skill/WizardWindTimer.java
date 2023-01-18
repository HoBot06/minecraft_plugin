package septagram.Theomachy.Timer.Skill;

import java.util.List;
import java.util.TimerTask;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class WizardWindTimer extends BukkitRunnable
{
	final private List<Player> targetList;
	final private Vector v;
	private int duration;
	
	public WizardWindTimer(List<Player> targetList, Vector v, int duration)
	{
		this.targetList=targetList;
		this.v=v;
		this.duration=duration;
	}
	
	public void run()
	{
		for (Player e : targetList)
			e.setVelocity(v);
		if(duration <= 0) {
			this.cancel();
		}
		duration--;
	}
}
