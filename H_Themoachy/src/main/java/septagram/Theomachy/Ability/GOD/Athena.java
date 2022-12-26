package septagram.Theomachy.Ability.GOD;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import septagram.Theomachy.Theomachy;
import septagram.Theomachy.Ability.Ability;
import septagram.Theomachy.DB.GameData;
import septagram.Theomachy.Manager.EventManager;
import septagram.Theomachy.Utility.CoolTimeChecker;
import septagram.Theomachy.Utility.EventFilter;
import septagram.Theomachy.Utility.PlayerInventory;
import septagram.Theomachy.Utility.Skill;

public class Athena extends Ability
{
	private final int coolTime1=10;
	private final int coolTime2=3;
	private final Material material=Material.COBBLESTONE;
	private final int stack1=5;
	private final int stack2=64;
	private int abilityLimitCounter=2;
	private final static String[] des= {"������ ���Դϴ�.",
			   "�÷��̾���� ����� �� ���� ����ġ�� ����ϴ�.",
			   "�ڽ��� ����ϸ� ����ġ�� �ʱ�ȭ�˴ϴ�.",
			   "�Ϲݴɷ����� å�� û�ݼ��� ���� �� ������",
			   "��޴ɷ����� ���� �� 2�� ��æƮ ���̺��� ���� �� �ֽ��ϴ�."};
	
	public Athena(String playerName)
	{
		super(playerName,"���׳�", 5, true, true, false, des);
		Theomachy.log.info(playerName+abilityName);
		
		this.cool1=coolTime1;
		this.cool2=coolTime2;
		this.sta1=stack1;
		this.sta2=stack2;
		
		this.rank=4;
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
			player.getInventory().addItem(new ItemStack(Material.BOOK,3));
			player.getInventory().addItem(new ItemStack(Material.LAPIS_BLOCK,3));
		}
	}
	
	private void rightAction(Player player)
	{
		if (abilityLimitCounter>0)
		{
			if (CoolTimeChecker.Check(player, 2)&&PlayerInventory.ItemCheck(player, material, stack2))
			{
				if (abilityLimitCounter>1)
				{
					Skill.Use(player, material, stack2, 2, coolTime2);
					player.getInventory().addItem(new ItemStack(Material.ENCHANTING_TABLE,1));
					player.sendMessage("���� ��ȯ Ƚ�� : "+--abilityLimitCounter);
				}
				else
				{
					Skill.Use(player, material, stack2, 2, 0);
					player.getInventory().addItem(new ItemStack(Material.ENCHANTING_TABLE,1));
					player.sendMessage("���� ��ȯ Ƚ�� : "+--abilityLimitCounter);
				}
			}
		}
		else
			player.sendMessage("�� �ɷ��� ���̻� ����� �� �����ϴ�.");
	}
	
	public void T_Passive(PlayerDeathEvent event)
	{
		if (event.getEntity().getLastDamageCause().getCause() != DamageCause.SUICIDE)
		{
			Player player = GameData.OnlinePlayer.get(playerName);
			player.setLevel(player.getLevel()+1);
		}
	}
	
	public void conditionSet()
	{
		EventManager.PlayerDeathEventList.add(this);//���߿� �ܵ�˼����� �ٲٱ�
	}
	public void conditionReSet()
	{
		EventManager.PlayerDeathEventList.remove(this);//���߿� �ܵ�� �������� �ٲٱ�
	}
}

