package septagram.Theomachy.Timer.Skill;

import java.util.List;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import septagram.Theomachy.Utility.Cal_Distance;
import septagram.Theomachy.Utility.GetPlayerList;
import septagram.Theomachy.Utility.Sounds;

public class DireTimer extends BukkitRunnable
{
	
	Player player;
	private int duration;
	
	public DireTimer(Player player, int duration)
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
				Sounds.SoundP(e, Sound.ENTITY_VILLAGER_AMBIENT, (2.0f - Cal_Distance.GetFloatDistance(player.getLocation(), e.getLocation())/10), 0.3f);
				e.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 40, 0),true);
				e.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 15, 2),true);
				e.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 20, 0),true);
				e.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 100, 0),true);
				e.addPotionEffect(new PotionEffect(PotionEffectType.HUNGER, 40, 0),true);
			}
			Sounds.SoundP(player, Sound.ENTITY_VILLAGER_AMBIENT, 1.0f, 0.3f);
		}catch(Exception e) {}
		duration--;
		
	}

}
