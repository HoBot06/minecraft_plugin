package septagram.Theomachy.Ability.GOD;

import java.util.List;
import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;

import septagram.Theomachy.Theomachy;
import septagram.Theomachy.Ability.Ability;
import septagram.Theomachy.Utility.CoolTimeChecker;
import septagram.Theomachy.Utility.EventFilter;
import septagram.Theomachy.Utility.PlayerInventory;
import septagram.Theomachy.Utility.Skill;

public class Hades extends Ability
{	
	private final int coolTime1=100;
	private final int coolTime2=300;
	private final Material material=Material.COBBLESTONE;
	private final int stack1=5;
	private final int stack2=10;
	private final static String[] des= {"������ ���Դϴ�.",
			   "�нú� �ɷ����� ����� 70% Ȯ���� �������� ���� �ʽ��ϴ�." ,
			   "�Ϲݴɷ��� �ֺ� 2ĭ�� �ִ� �ڽ��� ������ ",
			   "��� �÷��̾�� �Բ� �������� �������ϴ�.",
			   "��޴ɷ��� �ֺ� 4ĭ�� �ִ� �ڽ��� ������ ",
			   "��� �÷��̾ �������� ����߸��ϴ�."};
	
	public Hades(String playerName)
	{
		super(playerName,"�ϵ���", 3, true, false, false, des);
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
			Skill.Use(player, material, stack1, 1,coolTime1);
			Entity entity=player;
			Location location = player.getLocation();
			location.setY(-2.0d);
			List<Entity> entitylist = entity.getNearbyEntities(2, 2, 2);
			for (Entity e : entitylist)
			{
				if (e instanceof LivingEntity)
				{
					e.teleport(location);
					if (e.getType() == EntityType.PLAYER)
						((Player)e).sendMessage("������ ���� �ɷ¿� ���� �������� �������ϴ�.");
				}
			}
			player.teleport(location);
		}
	}
	
	private void rightAction(Player player)
	{
		if (CoolTimeChecker.Check(player, 2)&&PlayerInventory.ItemCheck(player, material, stack2))
		{
			Skill.Use(player, material, stack2, 2,coolTime2);
			Entity entity=player;
			Location location = player.getLocation();
			location.setY(-2.0d);
			List<Entity> entitylist = entity.getNearbyEntities(4, 4, 4);
			for (Entity e : entitylist)
			{
				if (e instanceof LivingEntity)
				{
					e.teleport(location);
					if (e.getType() == EntityType.PLAYER)
						((Player)e).sendMessage(ChatColor.RED+"������ ���� �ɷ¿� ���� �������� �������ϴ�.");
				}
			}
		}
	}
	
	private ItemStack[] inventory;
	private ItemStack[] armor;
	public void T_Passive(PlayerDeathEvent event)
	{
		Random r=new Random();
		if (r.nextInt(10) <=5)
		{
			this.inventory=event.getEntity().getInventory().getContents();
			this.armor = event.getEntity().getInventory().getArmorContents();
			event.getDrops().clear();
		}
		else
			event.getEntity().sendMessage("�������� ��� �Ҿ����ϴ�.");
	}
	public void T_Passive(PlayerRespawnEvent event)
	{
		Player player = event.getPlayer();
		if (inventory !=null)
			player.getInventory().setContents(inventory);
		if (armor !=null)
		player.getInventory().setArmorContents(armor);
		inventory = null;
		armor = null;
	}
}

