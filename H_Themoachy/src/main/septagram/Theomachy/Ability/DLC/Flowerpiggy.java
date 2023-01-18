package septagram.Theomachy.Ability.DLC;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerMoveEvent;

import septagram.Theomachy.Theomachy;
import septagram.Theomachy.Ability.Ability;
import septagram.Theomachy.Utility.Sounds;

public class Flowerpiggy extends Ability
{
	private float MovePower = 0;
	private final static String[] des= {"강력한 능력입니다.",
			   "움직일때 마다 주먹에 힘을 저장합니다" ,
			   "상대방을 때릴시 저장한 힘을 소모하여 때립니다"};
	
	public Flowerpiggy(String playerName)
	{
		super(playerName,"김뚠뚠", 204, false, true, false, des);
		Theomachy.log.info(playerName+abilityName);
		
		this.rank=4;
	}
	
	public void T_Passive(EntityDamageByEntityEvent event)
	{
		if(event.getDamager() instanceof Player) {
			if(event.getDamager().getName().equalsIgnoreCase(playerName)) {
				Player player = (Player) event.getDamager();
				Entity victim = event.getEntity();
				if(MovePower >= 200) {
					for(Player p : Bukkit.getOnlinePlayers()) {
						Sounds.SoundPL(p, victim.getLocation(), Sound.ENTITY_IRON_GOLEM_REPAIR, 1.5f, 0.1f);
					}
					player.sendMessage(ChatColor.YELLOW + "뚝배기!!");
				}
				if(MovePower > 0) {
					event.setDamage(event.getDamage() + (MovePower/20));
					MovePower = 0;
				}
			}
		}
	}
	
	public void T_Passive(PlayerMoveEvent event)
	{
		if(event.getPlayer().getName().equalsIgnoreCase(playerName)) {
			this.MovePower = Math.min(this.MovePower+1, 220);
		}
	}
}
