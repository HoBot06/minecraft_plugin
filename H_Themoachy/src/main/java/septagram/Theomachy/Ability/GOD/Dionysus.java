package septagram.Theomachy.Ability.GOD;

import java.util.Random;

import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import septagram.Theomachy.Theomachy;
import septagram.Theomachy.Ability.Ability;

public class Dionysus extends Ability
{	
	private final static String[] des= {"���� ���Դϴ�.",
			   "10% Ȯ���� �ڽ��� ������ 10�ʰ� ����� �þ߸� ����������",
			   "���ÿ� ����� �̵��ӵ�, ���ݷ��� ����ϴ�."};
	public Dionysus(String playerName)
	{
		super(playerName,"����ϼҽ�", 12, false, true, false, des);
		Theomachy.log.info(playerName+abilityName);
		
		this.rank=3;
	}
	
	public void T_Passive(EntityDamageByEntityEvent event)
	{
		Player player = (Player)event.getEntity();
		if (player.getName().equals(playerName))
		{
			Random random = new Random();
			int rn = random.nextInt(10);
			if (rn == 0)
			{
				Player target = (Player) event.getDamager();
				target.addPotionEffect(new PotionEffect(PotionEffectType.SLOW,200,0), true);
				target.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS,200,0), true);
				target.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION,240,0), true);
				target.sendMessage("���� ���ؼ� ������ �����ϴ�!");
				player.sendMessage("���濡�� ���� �Կ����ϴ�.");
			}
		}
	}
}
