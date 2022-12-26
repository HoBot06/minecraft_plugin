package septagram.Theomachy.Ability.HUMAN;

import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import septagram.Theomachy.Theomachy;
import septagram.Theomachy.Ability.Ability;

public class Reflection extends Ability
{	
	private final static String[] des= {"���ݹ��� �������� �����ڿ��� �ݻ��ϴ� �ɷ��Դϴ�.",
			   "33% Ȯ���� �ڽ��� ���� �������� ���� ���濡�� �ݻ��մϴ�." ,
			   "ȭ�� �� ���������� �޴� �������� �ݻ����� ���մϴ�.",
			   "�� �ɷ��� �� �����մϴ�."};
	
	public Reflection(String playerName)
	{
		super(playerName,"�ݻ�", 109, false, true, false, des);
		Theomachy.log.info(playerName+abilityName);
		
		this.rank=2;
	}
	
	public void T_Passive(EntityDamageByEntityEvent event)
	{
		Player player = (Player) event.getEntity();
		if (player.getName().equals(playerName))
		{
			int rn = (int) (Math.random()*3);
			if (rn == 0)
			{
				Player damager = (Player) event.getDamager();
				damager.damage(event.getDamage()/3);
			}
		}
	}
	
}
