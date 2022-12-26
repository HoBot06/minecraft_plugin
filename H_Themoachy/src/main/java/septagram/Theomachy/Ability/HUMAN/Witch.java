package septagram.Theomachy.Ability.HUMAN;

import java.util.List;
import java.util.Random;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import septagram.Theomachy.Theomachy;
import septagram.Theomachy.Ability.Ability;
import septagram.Theomachy.Utility.CoolTimeChecker;
import septagram.Theomachy.Utility.EventFilter;
import septagram.Theomachy.Utility.GetPlayerList;
import septagram.Theomachy.Utility.PlayerInventory;
import septagram.Theomachy.Utility.Skill;

public class Witch extends Ability
{
	private final int coolTime0=60;
	private final Material material=Material.COBBLESTONE;
	private final int stack0=5;
	private final static String[] des= {"������� ����ϴ� �ɷ��Դϴ�.",
			   "������ �ε带 �̿��� �ɷ� ���� �ֺ� 10ĭ �ȿ� �ִ�",
			   "�ڽ��� ������ ������ ��ο��� ���� 10�ʰ� ������� �����մϴ�." ,
			   "�ڽ��� ������ ���� 7% Ȯ���� 5�ʰ� ������� �ɸ��� �˴ϴ�."};
	
	public Witch(String playerName)
	{
		super(playerName,"����", 116, true, false, false, des);
		Theomachy.log.info(playerName+abilityName);
		
		this.cool1=coolTime0;
		this.sta1=stack0;
		
		this.rank=2;
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
			}
		}
	}

	private void leftAction(Player player)
	{
		if (CoolTimeChecker.Check(player, 0)&&PlayerInventory.ItemCheck(player, material, stack0))
		{
			List<Player> targetList = GetPlayerList.getNearByNotTeamMembers(player, 10, 10, 10);
			if (targetList != null)
			{
				Skill.Use(player, material, stack0, 0, coolTime0);
				for (Player e : targetList)
				{
					
					e.addPotionEffect(new PotionEffect(PotionEffectType.HUNGER, 200,0),true);
					e.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 200,0),true);
					e.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 200,0),true);
					e.addPotionEffect(new PotionEffect(PotionEffectType.HUNGER, 200,0),true);
					e.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, 200,0),true);
					e.sendMessage("���࿡ ���� ���ֿ� �ɷȽ��ϴ�.");
				}
			}
			else
				player.sendMessage("�ɷ��� ��� �� ����� �����ϴ�.");
		}
	}
	
	public void T_Passive(EntityDamageByEntityEvent event)
	{
		Player player = (Player)event.getEntity();
		if (player.getName().equals(playerName))
		{
			Random random = new Random();
			int rn = random.nextInt(14);
			if (rn == 0)
			{
				Player target = (Player) event.getDamager();
				target.addPotionEffect(new PotionEffect(PotionEffectType.HUNGER, 100,0),true);//*20	
				target.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 100,0),true);
				target.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100,0),true);
				target.addPotionEffect(new PotionEffect(PotionEffectType.HUNGER, 100,0),true);
				target.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, 100,0),true);
				target.sendMessage("���࿡ ���� ���ְ� �ɷȽ��ϴ�.");
			}
		}
	}
}
