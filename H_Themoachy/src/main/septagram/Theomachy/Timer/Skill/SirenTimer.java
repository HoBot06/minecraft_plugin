package septagram.Theomachy.Timer.Skill;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import septagram.Theomachy.Utility.GetPlayerList;
import septagram.Theomachy.Utility.Sounds;

public class SirenTimer extends BukkitRunnable
{
	Player player;
	private int duration;
	
	public SirenTimer(Player player, int duration)
	{
		this.player=player;
		this.duration=duration;
	}
	
	public void run()
	{
		if(duration <= 0) {
			this.cancel();
		}
		else if(duration <= 5) {
			player.sendMessage("남은 지속시간 : " + duration + "초");
		}
		try {
			List<Player> list=GetPlayerList.getNearByNotTeamMembers(player, 20, 20, 20);
		
			for(Player e:list) {
				Location loc = e.getLocation();
				loc.setY(loc.getY()+1);
				e.getWorld().spawnParticle(Particle.FIREWORKS_SPARK,loc, 8);
				e.getWorld().spawnParticle(Particle.CLOUD,loc, 8);
				for(Player sp : Bukkit.getOnlinePlayers()) {
					Sounds.SoundPL(sp, e.getLocation(), Sound.ENTITY_FIREWORK_ROCKET_BLAST, 1.5f, 1.0f);
				}
				
			}
		}catch(Exception e) {}
		duration--;
		
	}
}
