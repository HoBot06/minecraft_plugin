package septagram.Theomachy.Ability.HUMAN;

import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

import septagram.Theomachy.Theomachy;
import septagram.Theomachy.Ability.Ability;

public class Stance extends Ability
{
	
	private final static String[] des= {"���� ������ ���� �ִ� �ɷ��Դϴ�.",
			   "��� ������ ���� ȿ���� �����ϸ�,",
			   "��� ���ݿ� 100% Ȯ���� �з����� �ʽ��ϴ�." ,
			   "�г�Ƽ�� ��� �ڽ��� ��� ȿ���� ���õ˴ϴ�."};
	
	public Stance(String playerName)
	{
		super(playerName,"���Ľ�", 103, false, true, false ,des);
		Theomachy.log.info(playerName+abilityName);
		
		this.rank=3;
	}
	
	public void T_Passive(EntityDamageEvent event)
	{
		if (event.getCause() == DamageCause.ENTITY_ATTACK || event.getCause() == DamageCause.PROJECTILE)
		{
			Player player = (Player)event.getEntity();
			double damage = event.getDamage();
			player.damage(damage);
			event.setCancelled(true);
		}
	}
	
	
}
