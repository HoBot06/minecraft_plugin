package septagram.Theomachy.Timer.Skill;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.material.MaterialData;
import org.bukkit.scheduler.BukkitRunnable;

public class DdangGodTimer extends BukkitRunnable
{
	
	Player victim;
	private int duration;
	private double damage;
	
	public DdangGodTimer(Player victim, int duration, double damage)
	{
		this.victim=victim;
		this.duration=duration;
		this.damage=damage;
	}
	
	public void run()
	{
		if(duration <= 0) {
			this.cancel();
		}
		try {
			victim.getWorld().spawnParticle(Particle.FALLING_LAVA, victim.getLocation().add(0.4, 2, -0.4), 5);
			victim.getWorld().spawnParticle(Particle.FALLING_LAVA, victim.getLocation().add(0.4, 2, 0.4), 5);
			victim.getWorld().spawnParticle(Particle.FALLING_LAVA, victim.getLocation().add(-0.4, 2, 0.4), 5);
			victim.getWorld().spawnParticle(Particle.FALLING_LAVA, victim.getLocation().add(-0.4, 2, -0.4), 5);
			victim.damage(damage);
		}catch(Exception e) {}
		duration--;
		
	}
}
