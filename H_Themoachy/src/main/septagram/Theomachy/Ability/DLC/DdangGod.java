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
import septagram.Theomachy.Timer.Skill.DdangGodTimer;
import septagram.Theomachy.Utility.Sounds;

public class DdangGod extends Ability
{
	private final static String[] des= {"���̻� �����̰� �ƴ� �ɷ��Դϴ�.",
			   "25%�� Ȯ���� �ڽ��� ���� �÷��̾��" ,
			   "���� ū ����� ���� ������ ������ ���ظ� �԰� �Ϳ��� �������� �帣�� �˴ϴ�"};
	
	public DdangGod(String playerName)
	{
		super(playerName,"����", 217, false, true, false, des);
		Theomachy.log.info(playerName+abilityName);
		
		this.rank=4;
	}
	
	public void T_Passive(EntityDamageByEntityEvent event)
	{
		if(event.getDamager() instanceof Player) {
			if(event.getEntity().getName().equalsIgnoreCase(playerName)) {
				Player player = (Player) event.getDamager();
				Random r = new Random();
				int rn = r.nextInt(4);
				if (rn == 0)
				{
					for(Player p : Bukkit.getOnlinePlayers()) {
						Sounds.SoundPL(p, event.getEntity().getLocation(), Sound.ENTITY_WITHER_AMBIENT, 2.0f, 2.0f);
					}
					player.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 60, 0),true);
					player.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 40, 0),true);
					player.addPotionEffect(new PotionEffect(PotionEffectType.HUNGER, 60, 1),true);
					DdangGodTimer DGT = new DdangGodTimer(player, 2, 1d);
					DGT.runTaskTimer(Theomachy.getPlugin(Theomachy.class), 0, 10L);
				}
			}
		}
	}
}
