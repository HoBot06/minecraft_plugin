package septagram.Theomachy.Ability.HUMAN;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import septagram.Theomachy.Theomachy;
import septagram.Theomachy.Ability.Ability;
import septagram.Theomachy.Timer.Skill.WizardDisasterTimer;
import septagram.Theomachy.Timer.Skill.WizardWindTimer;
import septagram.Theomachy.Utility.CoolTimeChecker;
import septagram.Theomachy.Utility.DirectionChecker;
import septagram.Theomachy.Utility.EventFilter;
import septagram.Theomachy.Utility.PlayerInventory;
import septagram.Theomachy.Utility.Skill;

public class Wizard extends Ability
{
	private final int coolTime1=180;
	private final int coolTime2=300;
	private final Material material=Material.COBBLESTONE;
	private final int stack1=10;
	private final int stack2=20;
	private final static String[] des= {"���� �ɷ��� ���� ���� �ɷ��Դϴ�.",
			   "�Ϲݴɷ��� �ֺ� 10ĭ ��� �÷��̾ �ڽ��� ���� �������� ��� ���������ϴ�.",
			   "��޴ɷ��� �ֺ� 5ĭ ��� �÷��̾ �������� ��� �� ",
			   "�÷��̾�� ������ ����߸��ϴ�.",
			   "��޴ɷ� �ߵ� �� �г�Ƽ�� �ڽ��� ü���� ������ �پ��ϴ�."};
	
	public Wizard(String playerName)
	{
		super(playerName,"������", 107, true, false, false, des);
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
			List<Entity> entityList = player.getNearbyEntities(10, 10, 10);
			ArrayList<Player> targetList = new ArrayList<Player>(); 
			for (Entity e : entityList)
				if (e instanceof Player)
					targetList.add((Player) e);
			if (!targetList.isEmpty())
			{
				Skill.Use(player, material, stack1, 1, coolTime1);
				Timer t = new Timer();
				Vector v = new Vector(0,0.5,0);
				double vertical = 2.4d;
				double diagonal = vertical*1.4d;
				for (Player e : targetList)
				{
					e.setVelocity(v);
					e.sendMessage("�������� �ɷ¿� ���� ���ư��ϴ�.");
				}
				switch(DirectionChecker.PlayerDirection(player))
				{
				case 0:
					v.add(new Vector(0,0,diagonal));
					break;
				case 1:
					v.add(new Vector(-vertical,0,vertical));
					break;
				case 2:
					v.add(new Vector(-diagonal,0,0));
					break;
				case 3:
					v.add(new Vector(-vertical,0,-vertical));
					break;
				case 4:
					v.add(new Vector(0,0,-diagonal));
					break;
				case 5:
					v.add(new Vector(vertical,0,-vertical));
					break;
				case 6:
					v.add(new Vector(diagonal,0,0));
					break;
				case 7:
					v.add(new Vector(vertical,0,vertical));
					break;
				}
				BukkitRunnable WWT = new WizardWindTimer(targetList, v, 1);
				WWT.runTaskTimer(Theomachy.getPlugin(Theomachy.class), 0, 20L);
			}
			else
				player.sendMessage("�ɷ��� ����� �� �ִ� ����� �����ϴ�.");
		}
	}
	
	private void rightAction(Player player)
	{
		if (CoolTimeChecker.Check(player, 2)&&PlayerInventory.ItemCheck(player, material, stack2))
		
		{
			List<Entity> entityList = player.getNearbyEntities(5, 5, 5);
			ArrayList<Player> targetList = new ArrayList<Player>(); 
			for (Entity e : entityList)
				if (e instanceof Player)
					targetList.add((Player) e);
			if (!targetList.isEmpty())
			{
				Skill.Use(player, material, stack2, 2, coolTime2);
				player.setHealth(player.getHealth()/2);
				Vector v = new Vector(0,1.6,0);
				for (Player e : targetList)
				{
					e.setVelocity(v);
					e.sendMessage(ChatColor.RED+"�������� ��޴ɷ¿� ���߽��ϴ�!");
				}
				BukkitRunnable WDT = new WizardDisasterTimer(targetList, player, 2);
				WDT.runTaskTimer(Theomachy.getPlugin(Theomachy.class), 0, 20L);
			}
			player.sendMessage("�ɷ��� ����� �� �ִ� ����� �����ϴ�.");
		}
	}
}
