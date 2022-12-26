package septagram.Theomachy.Ability.HUMAN;

import java.util.List;
import java.util.Random;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.scheduler.BukkitRunnable;

import septagram.Theomachy.Theomachy;
import septagram.Theomachy.Ability.Ability;
import septagram.Theomachy.Timer.Skill.ClockingTimer;
import septagram.Theomachy.Utility.CoolTimeChecker;
import septagram.Theomachy.Utility.EventFilter;
import septagram.Theomachy.Utility.PlayerInventory;
import septagram.Theomachy.Utility.Skill;

public class Clocking extends Ability
{
	private final int coolTime0=45;
	private final Material material=Material.COBBLESTONE;
	private final int stack0=15;
	private List<Player> targetList;
	private final static String[] des= {"�����ð� �ڽ��� ���� ���� �� �ִ� �ɷ��Դϴ�.",
			   "�Ϲ� �ɷ��� �̿��� �ڽ��� ����� 7�ʵ��� ���� �� �ֽ��ϴ�.", 
			   "���� ���¿��� ������ ������ �� �ٽ� ����� ��Ÿ���� �Ǹ�,",
			   "���� ���� ���� 20% Ȯ���� ����մϴ�."};
	
	public Clocking(String playerName)
	{
		super(playerName,"Ŭ��ŷ", 112, true, true, false, des);
		Theomachy.log.info(playerName+abilityName);
		
		this.cool1=coolTime0;
		this.sta1=stack0;
		
		this.rank=3;
	}
	
	public void T_Active(PlayerInteractEvent event)
	{
		Player player = event.getPlayer();
		if (PlayerInventory.InHandItemCheck(player, Material.BLAZE_ROD))
		{
			switch(EventFilter.PlayerInteract(event))
			{
			case 2:case 3:
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
			targetList = player.getWorld().getPlayers();
			for (Player e : targetList)
				e.hidePlayer(player);	
			BukkitRunnable Clocking = new ClockingTimer(targetList, player, 7);
			Clocking.runTaskTimer(Theomachy.getPlugin(Theomachy.class), 0, 20L);
			super.flag = true;
		}
	}
	
	public void T_Passive(EntityDamageByEntityEvent event)
	{
		if (flag)
		{
			Player player = (Player) event.getDamager();
			if (player.getName().equals(this.playerName))
			{
				targetList = player.getWorld().getPlayers();
				for (Player e : targetList)
					e.showPlayer(player);
				Random random = new Random();
				if (random.nextInt(5)==0)
				{
					Player target = (Player) event.getEntity();
					event.setDamage(100);
					target.sendMessage("�� �� ���� ������ ���� ��� �Ͽ����ϴ�.");
					player.sendMessage("��밡 ��� �Ͽ����ϴ�.");
				}
			}
			super.flag = false;
		}
	}
}
