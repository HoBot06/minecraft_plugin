package septagram.Theomachy.Ability.GOD;

import java.util.Random;

import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import septagram.Theomachy.Theomachy;
import septagram.Theomachy.Ability.Ability;

public class Ares extends Ability
{
	
	private final static String[] des= {"������ ���Դϴ�.",
			   "��� ���� �������� 1.5�� ����մϴ�." ,
			   "�߰� �нú� �ɷ����� 10% Ȯ���� ������ ȸ���մϴ�"};
	
	public Ares(String playerName)
	{
		super(playerName,"�Ʒ���", 8, false, true, false, des);
		Theomachy.log.info(playerName+abilityName);
		
		this.rank=3;
		
	}
	
	public void T_Passive(EntityDamageByEntityEvent event)
	{		
		Player player = (Player) event.getEntity();
		if (!player.getName().equals(playerName)) //����
			event.setDamage((int) (event.getDamage()*1.5));
		else											//�ǰ�
		{
			Random random = new Random();
			if (random.nextInt(10) == 0) 	//1/2 Ȯ��
			{
				event.setCancelled(true);
				player.sendMessage("ȸ���߽��ϴ�!");
			}
		}
	}
}
