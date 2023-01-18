package septagram.Theomachy.Timer.Skill;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class MineSkyTimer extends BukkitRunnable
{
	Player player;
	private int duration;
	private int in_time;
	private boolean bool_in = false;
	
	public MineSkyTimer(Player player, int duration, int in_time)
	{
		this.player=player;
		this.duration=duration;
		this.in_time=in_time;
	}
	
	public void run()
	{
		ArrayList<Player> targetList = new ArrayList<Player>(Bukkit.getOnlinePlayers());
		if(in_time <= 0 && bool_in) {
			if(duration <= 0) {
				try{
					player.sendMessage("안정화되었습니다");
					player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 20, 9),true);
					player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 40, 4),true);
					bool_in = false;
					for (Player another : targetList)
					{
						another.showPlayer(player);
						player.showPlayer(another);
					}
				}
				catch (Exception e)
				{
				}
				this.cancel();
			}
			else if(duration <= 3) {
				player.sendMessage("안정화까지 " + duration + "초");
				for (Player another : targetList)
				{
					another.hidePlayer(player);
					player.hidePlayer(another);
				}
			}
			else {
				for (Player another : targetList)
				{
					another.hidePlayer(player);
					player.hidePlayer(another);
				}
			}
			duration--;
		}
		else if(in_time <= 0 && !bool_in) {
			try{
				player.sendMessage("다른차원으로 이동되었습니다");
				player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 20, 9),true);
				player.addPotionEffect(new PotionEffect(PotionEffectType.SATURATION, duration*20, 0),true);
				player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, duration*20, 2),true);
				for (Player another : targetList)
				{
					another.hidePlayer(player);
					player.hidePlayer(another);
				}
				bool_in=true;
			}
			catch (Exception e)
			{
			}
		}
		else {
			player.sendMessage("불안정화까지 " + in_time + "초");
			in_time--;
		}
		
	}
}
