package septagram.Theomachy.Timer.Skill;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class ThunderChickenTimer extends BukkitRunnable
{
	Player player;
	private float forcepower;
	private int distance;
	
	public ThunderChickenTimer(Player player, float forcepower, int distance)
	{
		this.player=player;
		this.forcepower=forcepower;
		this.distance=distance;
	}
	
	public void run()
	{
		if(distance <= 0) {
			this.cancel();
		}
		List<Entity> Entity_L = player.getNearbyEntities(1, 1, 1);
		float angle = player.getLocation().getYaw();
		Vector v = player.getEyeLocation().getDirection();
		v.setX(-(Math.sin(Math.toRadians(angle))*forcepower));
		v.setZ(Math.cos(Math.toRadians(angle))*forcepower);
		for(Entity e : Entity_L) {
			e.setVelocity(v);
			if(e instanceof LivingEntity) {
				((LivingEntity) e).damage(5d);
			}
		}
		
		distance--;
		
	}

}
