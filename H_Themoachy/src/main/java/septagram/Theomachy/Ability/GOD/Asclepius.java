package septagram.Theomachy.Ability.GOD;

import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

import septagram.Theomachy.Theomachy;
import septagram.Theomachy.Ability.Ability;
import septagram.Theomachy.Utility.CoolTimeChecker;
import septagram.Theomachy.Utility.EventFilter;
import septagram.Theomachy.Utility.PlayerInventory;
import septagram.Theomachy.Utility.Skill;
import septagram.Theomachy.Utility.GetPlayerList;

public class Asclepius extends Ability
{
	private final int coolTime1=60;
	private final int coolTime2=120;
	private final Material material=Material.COBBLESTONE;
	private final int stack1=1;
	private final int stack2=5;
	private final static String[] des= {"�Ǽ��� ���Դϴ�.",
			   "�Ϲݴɷ����� �ڽ��� ��� ȸ�� ��ų �� �ֽ��ϴ�." ,
			   "��޴ɷ����� �ֺ� 5ĭ�� �ִ� �ڽ��� ������ ������ ü����",
			   "��� ȸ����ų �� �ֽ��ϴ�."};
	
	public Asclepius(String playerName)
	{
		super(playerName,"�ƽ�Ŭ���Ǿ", 10, true, false, false, des);
		Theomachy.log.info(playerName+abilityName);
		
		this.cool1=coolTime1;
		this.cool2=coolTime2;
		this.sta1=stack1;
		this.sta2=stack2;
		
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
			player.setHealth(20);
		}
	}
	
	private void rightAction(Player player)
	{
		if (CoolTimeChecker.Check(player, 2)&&PlayerInventory.ItemCheck(player, material, stack2))
		{
			List<Player> targetList = GetPlayerList.getNearByTeamMembers(player, 5, 5, 5);
			if (!targetList.isEmpty())
			{
				Skill.Use(player, material, stack2, 2, coolTime2);
				player.sendMessage("�ڽ��� ������ ��� ������ ü���� ȸ���մϴ�.");
				player.sendMessage(ChatColor.GREEN+"ü���� ȸ���� �÷��̾� ���");
				for (Player e : targetList)
				{
					e.setHealth(20);
					e.sendMessage(ChatColor.YELLOW+"�Ǽ��� ���� �ɷ����� ��� ü���� ȸ���մϴ�.");
					player.sendMessage(ChatColor.GOLD+e.getName());
				}
			}
			else
				player.sendMessage("��� ������ ����� �����ϴ�.");
		}
	}
}
