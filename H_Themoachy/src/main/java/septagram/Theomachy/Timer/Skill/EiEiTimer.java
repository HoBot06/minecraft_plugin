package septagram.Theomachy.Timer.Skill;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import septagram.Theomachy.Handler.CommandModule.AbilitySet;
import septagram.Theomachy.Timer.CoolTime;

public class EiEiTimer extends BukkitRunnable
{
	Player player;
	private int duration;
	private int cooltime;
	
	public EiEiTimer(Player player, int duration, int cooltime)
	{
		this.player=player;
		this.duration=duration;
		this.cooltime=cooltime;
	}
	
	public void run()
	{
		if(duration <= 0) {
			try{
				CoolTime.COOL0.remove(player.getName());
				CoolTime.COOL1.remove(player.getName());
				CoolTime.COOL2.remove(player.getName());
				AbilitySet.abiltiyAssignment(206, player.getName(), player);
				player.sendMessage("김티티 능력으로 돌아왔습니다");
				CoolTime.COOL0.put(player.getName(), cooltime);
			}
			catch (Exception e)
			{
			}
			this.cancel();
		}
		else if(duration <= 5) {
			player.sendMessage("김티티로 돌아가기까지 : " + duration + "초");
		}
		duration--;
		
	}
}
