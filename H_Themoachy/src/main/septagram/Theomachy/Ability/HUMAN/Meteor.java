package septagram.Theomachy.Ability.HUMAN;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.scheduler.BukkitRunnable;

import septagram.Theomachy.Theomachy;
import septagram.Theomachy.Ability.Ability;
import septagram.Theomachy.Timer.Skill.MeteorTimer;
import septagram.Theomachy.Utility.CoolTimeChecker;
import septagram.Theomachy.Utility.EventFilter;
import septagram.Theomachy.Utility.PlayerInventory;
import septagram.Theomachy.Utility.Skill;

public class Meteor extends Ability
{
	private final int coolTime0=100;
	private final Material material=Material.COBBLESTONE;
	private final int stack0=10;
	private final static String[] des= {"������ ��ȯ�ϴ� �ɷ��Դϴ�.",
			   "������ �ε带 ����� �ɷ����� ������ ��ȯ�մϴ�." ,
			   "�ɷ� ���� �ڽ��� ��ġ�� �������� ",
			   "���� ������ ������ 30�� ����߸��ϴ�." ,
			   "���� ���׿��� ���߿� �ı����� �ʽ��ϴ�."};
	
	public Meteor(String playerName)
	{
		super(playerName,"���׿�", 117, true, false, false, des);
		Theomachy.log.info(playerName+abilityName);
		
		this.cool1=coolTime0;
		this.sta1=stack0;
		
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
			}
		}
	}

	private void leftAction(Player player)
	{	
		if (CoolTimeChecker.Check(player, 0)&&PlayerInventory.ItemCheck(player, material, stack0))
		{
			Skill.Use(player, material, stack0, 0, coolTime0);
			Location location = player.getLocation();
			BukkitRunnable Meteor = new MeteorTimer(player, location, 30);
			Meteor.runTaskTimer(Theomachy.getPlugin(Theomachy.class), 0, 4L);
		}
	}
}
