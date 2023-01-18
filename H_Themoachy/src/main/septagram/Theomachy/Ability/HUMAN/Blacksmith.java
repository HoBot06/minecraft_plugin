package septagram.Theomachy.Ability.HUMAN;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import septagram.Theomachy.Theomachy;
import septagram.Theomachy.Ability.Ability;
import septagram.Theomachy.Utility.CoolTimeChecker;
import septagram.Theomachy.Utility.EventFilter;
import septagram.Theomachy.Utility.PlayerInventory;
import septagram.Theomachy.Utility.Skill;

public class Blacksmith extends Ability
{
	private final int coolTime1=120;
	private final int coolTime2=300;
	private final Material material1=Material.COBBLESTONE;
	private final Material material2=Material.IRON_INGOT;//ö��
	private final int stack1=70;
	private final int stack2=15;
	private final static String[] des= {"ö,���̾Ƹ� ����� �� �� �ִ� �ɷ��Դϴ�.",
			   "�Ϲݴɷ����� �ں����� �Һ��Ͽ� ö�� 5���� ȹ���� �� �ֽ��ϴ�.",
			   "��޴ɷ����� ö���� �Һ��Ͽ� ���̾� 3���� ���� �� �ֽ��ϴ�."};
	
	public Blacksmith(String playerName)
	{
		super(playerName,"��������", 113, true, false, false, des);
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
		if (CoolTimeChecker.Check(player, 1)&&PlayerInventory.ItemCheck(player, material1, stack1))
		{
			Skill.Use(player, material1, stack1, 1, coolTime1);
			player.getInventory().addItem(new ItemStack(Material.IRON_INGOT, 5));
		}
	}
	
	private void rightAction(Player player)
	{
		if (CoolTimeChecker.Check(player, 2)&&PlayerInventory.ItemCheck(player, material2, stack2))
		{
			Skill.Use(player, material2, stack2, 2, coolTime2);
			player.getInventory().addItem(new ItemStack(Material.DIAMOND, 3));
		}
	}
}
