package septagram.Theomachy.Ability.HUMAN;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import septagram.Theomachy.Theomachy;
import septagram.Theomachy.Ability.Ability;
import septagram.Theomachy.Timer.CoolTime;
import septagram.Theomachy.Utility.CoolTimeChecker;
import septagram.Theomachy.Utility.EventFilter;
import septagram.Theomachy.Utility.PlayerInventory;
import septagram.Theomachy.Utility.Skill;

public class Invincibility extends Ability
{
	private final int coolTime1=50;
	private final int coolTime2=60;
	private final Material material=Material.COBBLESTONE;
	private final int stack1=10;
	private final int stack2=3;
	private final static String[] des= {"�����ð� �������� ���� ���� �� �ִ� �ɷ��Դϴ�.",
			   "������ �ε带 �̿��� �ɷ��� ����� �� �ֽ��ϴ�.",
			   "��Ŭ���� �̿��� �����ð� �ڽ��� ���� ���·� ����ϴ�.",
			   "��Ŭ���� �ڽſ��� ü��ȸ�� ������ �����մϴ�."};
	
	public Invincibility(String playerName)
	{
		super(playerName,"����", 111, true, false, false, des);
		Theomachy.log.info(playerName+abilityName);
		
		this.cool1=coolTime1;
		this.cool2=coolTime2;
		this.sta1=stack1;
		this.sta2=stack2;
		
		this.rank=3;
	}
	
	public void T_Active(PlayerInteractEvent event)
	{
		Player player = event.getPlayer();
		if (PlayerInventory.InHandItemCheck(player, Material.BLAZE_ROD))
		{
			switch(EventFilter.PlayerInteract(event))
			{
			case 0:case 1:
				leftAction(player);
				break;
			case 2:case 3:
				rightAction(player);
				break;
			}
		}
	}

	private void leftAction(Player player)
	{
		if (CoolTimeChecker.Check(player, 1)&&PlayerInventory.ItemCheck(player, material, stack1))
		{
			Skill.Use(player, material, stack1, 1, coolTime1);
			{
				CoolTime.COOL0.put(playerName+"1", 7);
			}
		}
	}
	
	private void rightAction(Player player)
	{
		if (CoolTimeChecker.Check(player, 2)&&PlayerInventory.ItemCheck(player, material, stack2))
		{
			Skill.Use(player, material, stack2, 2, coolTime2);
			player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 500, 0), true);
		}
	}
	
	public void T_Passive(EntityDamageEvent event)
	{
		if (CoolTime.COOL0.containsKey(playerName+"1"))
		{
			event.setCancelled(true);
			event.getEntity().setFireTicks(0);
		}
	}
}
