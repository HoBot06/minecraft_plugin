package septagram.Theomachy.Ability.DLC;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import septagram.Theomachy.Theomachy;
import septagram.Theomachy.Ability.Ability;
import septagram.Theomachy.Utility.Sounds;

public class Rev extends Ability{
	
	private final static String[] des= {"������ �ɷ��Դϴ�.",
			   "������ ���� �ִ�ü���� �����մϴ�" ,
			   "��, ����� ���� ü������ ���ư��ϴ�"};
	
	public Rev(String playerName)
	{
		super(playerName,"�跹��", 205, false, true, false, des);
		Theomachy.log.info(playerName+abilityName);
		
		this.rank=3;
	}
	
	public void T_Passive(EntityDamageByEntityEvent event)
	{
		if(event.getDamager() instanceof Player && event.getEntity() instanceof Player) {
			if(event.getEntity().getName().equalsIgnoreCase(playerName)) {
				Player victim = (Player) event.getEntity();
				for(Player p : Bukkit.getOnlinePlayers()) {
					Sounds.SoundPL(p, victim.getLocation(), Sound.ENTITY_WITHER_HURT, 0.3f, 1.5f);
				}
				victim.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 60, 0),true);
				victim.setMaxHealth(victim.getMaxHealth() + 1);
			}
					
		}
	}

	public void T_Passive(PlayerDeathEvent event)
	{
		if(event.getEntity().getName().equalsIgnoreCase(playerName)) {
			Player player = (Player) event.getEntity();
			player.setMaxHealth(20d);
		}
	}
}
