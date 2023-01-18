package septagram.Theomachy.Ability.DLC;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

import septagram.Theomachy.Theomachy;
import septagram.Theomachy.Ability.Ability;
import septagram.Theomachy.DB.GameData;
import septagram.Theomachy.Timer.Skill.BlueMoonTimer;
import septagram.Theomachy.Utility.CoolTimeChecker;
import septagram.Theomachy.Utility.EventFilter;
import septagram.Theomachy.Utility.PlayerInventory;
import septagram.Theomachy.Utility.Skill;

public class Ruckgeld extends Ability
{
	private final int coolTime1=30;
	private final int coolTime2=30;
	private final Material material1=Material.COBBLESTONE;
	private final Material material2=Material.COBBLESTONE;
	private final int stack1=5;
	private final int stack2=20;
	private final int duration=15;
	private String abilitytarget;
	private double p_health=0;
	private double e_health=0;
	
	private final static String[] des= {"õĪ�� �ɷ��Դϴ�.",
			   "�Ϲݴɷ����� ������ ����� ü���� 15�ʵ��� �����մϴ�." ,
			   "��޴ɷ����� ������ ����� ü���� �ڹٲߴϴ�",
			   "��ǥ ����: /x <���>"};
	
	public Ruckgeld(String playerName)
	{
		super(playerName,"��ֵ�", 208, true, false, false, des);
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
		if (CoolTimeChecker.Check(player, 1)&&PlayerInventory.ItemCheck(player, material1, stack1))
		{
			if (abilitytarget != null)
			{
				Player target = GameData.OnlinePlayer.get(abilitytarget);
				if (target != null)
				{
					Skill.Use(player, material1, stack1, 1, coolTime1);
					player.sendMessage("�ɷ��� Ȱ��ȭ �Ǿ����ϴ�");
					BlueMoonTimer BMT = new BlueMoonTimer(player, target, duration);
					BMT.runTaskTimer(Theomachy.getPlugin(Theomachy.class), 0, 20L);
				}
				else
					player.sendMessage("�÷��̾ �¶����� �ƴմϴ�.");
			}
			else
				player.sendMessage("Ÿ���� �������� �ʾҽ��ϴ�. (Ÿ�� ��Ϲ� : /x <Player>)");
		}
	}
	
	private void rightAction(Player player)
	{
		if (CoolTimeChecker.Check(player, 2)&&PlayerInventory.ItemCheck(player, material2, stack2))
		{
			if (abilitytarget != null)
			{
				Player target = GameData.OnlinePlayer.get(abilitytarget);
				if (target != null)
				{
					Skill.Use(player, material2, stack2, 2, coolTime2);
					p_health = ((LivingEntity) player).getHealth();
					e_health = ((LivingEntity) target).getHealth();
					p_health = Math.min(p_health, ((LivingEntity) target).getMaxHealth());
					e_health = Math.min(e_health, ((LivingEntity) player).getMaxHealth());
					((LivingEntity) target).setHealth(p_health);
					((LivingEntity) player).setHealth(e_health);
				}
				else
					player.sendMessage("�÷��̾ �¶����� �ƴմϴ�.");
			}
			else
				player.sendMessage("Ÿ���� �������� �ʾҽ��ϴ�. (Ÿ�� ��Ϲ� : /x <Player>)");
		}
	}
	
	public void targetSet(CommandSender sender, String targetName)
	{
		if (!playerName.equals(targetName))
		{
			this.abilitytarget = targetName;
			sender.sendMessage("Ÿ���� ����߽��ϴ�.   "+ChatColor.GREEN+targetName);
		}
		else
			sender.sendMessage("�ڱ� �ڽ��� Ÿ������ ��� �� �� �����ϴ�.");	
	}
}
