package septagram.Theomachy.Timer.Skill;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class BlueMoonTimer extends BukkitRunnable
{
	Player player;
	Player enemy;
	private int duration;
	private double p_health=0;
	private double e_health=0;
	
	public BlueMoonTimer(Player player, Player enemy, int duration)
	{
		this.player=player;
		this.duration=duration;
		this.enemy=enemy;
	}
	
	public void run()
	{
		if(duration <= 0) {
			this.cancel();
		}
		else if(duration <= 5) {
			player.sendMessage("능력 종료까지 : " + duration + "초");
		}
		
		p_health = (((LivingEntity) player).getHealth() + ((LivingEntity) enemy).getHealth())/2;
		e_health = (((LivingEntity) player).getHealth() + ((LivingEntity) enemy).getHealth())/2;
		p_health = Math.min(p_health, ((LivingEntity) player).getMaxHealth());
		e_health = Math.min(e_health, ((LivingEntity) enemy).getMaxHealth());
		((LivingEntity) player).setHealth(p_health);
		((LivingEntity) enemy).setHealth(e_health);
		
		duration--;
		
	}

}
