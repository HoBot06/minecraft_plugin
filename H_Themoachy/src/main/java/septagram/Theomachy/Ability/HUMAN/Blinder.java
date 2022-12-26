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

public class Blinder extends Ability
{
	private final int coolTime0=30;
	private final Material material=Material.COBBLESTONE;
	private final int stack0=10;
	private final static String[] des= {"������ �þ߸� ������ �ɷ��Դϴ�.",
			   "�ڽ��� ������ ���� ���� Ȯ���� �þ߰� �������ϴ�. (4�� ����)",
			   "������ �ε带 �̿��� �ɷ����� �ڽ��� ������ ������",
			   "10ĭ �ȿ� �ִ� ������ ����ε� �� �� �ֽ��ϴ�. (8�� ����)"};
	
	public Blinder(String playerName)
	{
		super(playerName,"����δ�", 110, true, true, false, des);
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
			List<Player> targetList = GetPlayerList.getNearByNotTeamMembers(player, 5, 5, 5);
			if (!targetList.isEmpty())
			{
				Skill.Use(player, material, stack0, 0, coolTime0);
				player.sendMessage("�ڽ��� ������ ������ ��� �÷��̾ ����ε� �մϴ�.");
				for (Player e : targetList)
				{
					e.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 160, 0), true);
					e.sendMessage("����δ��� ���� �þ߰� ��ο����ϴ�.");
				}
			}
			else
				player.sendMessage("��� ������ ����� �����ϴ�.");
		}
	}
	
	public void T_Passive(EntityDamageByEntityEvent event)
	{
		Player player = (Player) event.getEntity();
		if (player.getName().equals(this.playerName))
		{
			Random random = new Random();
			if (random.nextInt(10) == 0)
			{
				Player target = (Player) event.getDamager();
				target.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 80, 0), true);
				target.sendMessage("����δ��� ���� �þ߰� ��ο����ϴ�.");
			}
		}
	}
}
