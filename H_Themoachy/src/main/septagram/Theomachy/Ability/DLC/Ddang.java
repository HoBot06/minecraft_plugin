package septagram.Theomachy.Ability.DLC;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import septagram.Theomachy.Theomachy;
import septagram.Theomachy.Ability.Ability;
import septagram.Theomachy.Utility.Sounds;

public class Ddang extends Ability
{
	private final static String[] des= {"�������� �ɷ��Դϴ�.",
			   "20%�� Ȯ���� �ڽ��� ���� �÷��̾��" ,
			   "����� ���� �ֹ̿� �ɸ��� �ϰ� �� ������ �½��ϴ�"};
	
	public Ddang(String playerName)
	{
		super(playerName,"�趯��", 202, false, true, false, des);
		Theomachy.log.info(playerName+abilityName);
		
		this.rank=3;
	}
	
	public void T_Passive(EntityDamageByEntityEvent event)
	{
		if(event.getDamager() instanceof Player) {
			if(event.getEntity().getName().equalsIgnoreCase(playerName)) {
				Player player = (Player) event.getDamager();
				Random r = new Random();
				int rn = r.nextInt(5);
				if (rn == 0)
				{
					event.setDamage((event.getDamage()/3)*2);
					for(Player p : Bukkit.getOnlinePlayers()) {
						Sounds.SoundPL(p, event.getEntity().getLocation(), Sound.ENTITY_GHAST_SCREAM, 2.0f, 1.5f);
					}
					player.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 250,0),true);
				}
			}
		}
	}
}
