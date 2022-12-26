package septagram.Theomachy.Ability.GOD;

import java.util.Random;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.PlayerInteractEvent;

import septagram.Theomachy.Theomachy;
import septagram.Theomachy.Ability.Ability;
import septagram.Theomachy.Utility.BlockFilter;
import septagram.Theomachy.Utility.CoolTimeChecker;
import septagram.Theomachy.Utility.EventFilter;
import septagram.Theomachy.Utility.PlayerInventory;
import septagram.Theomachy.Utility.Skill;

public class Zeus extends Ability
{
	private final int coolTime1=90;
	private final int coolTime2=180;
	private final Material material=Material.COBBLESTONE;
	private final int stack1=1;
	private final int stack2=5;
	private final static String[] des= {"�ŵ��� ���Դϴ�.",
			   "������ ����ϸ� ������ �ε带 ������� �ߵ� ��ų �� �ֽ��ϴ�.",
			   "�нú� �ɷ����� ������ ���� �������� ���� �ʽ��ϴ�.",
			   "�Ϲݴɷ��� Ÿ������(�Ÿ����� 50)�� ������ ����߸���",
			   "��޴ɷ��� Ÿ������(�Ÿ����� 30)�� �뷮�� ������ ����߸��ϴ�."};
	
	public Zeus(String playerName)
	{
		super(playerName,"���콺", 1, true, true, false, des);
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
			case 4:
				player.sendMessage(event.getAction().toString());
			}
		}
	}

	private void leftAction(Player player)
	{
		if (CoolTimeChecker.Check(player, 1)&&PlayerInventory.ItemCheck(player, material, stack1))
		{
			Block block = player.getTargetBlock(null, 50);
			if (BlockFilter.AirToFar(player, block))
			{
				Skill.Use(player, material, stack1, 1, coolTime1);
				World world = player.getWorld();
				Location location = block.getLocation();
				world.strikeLightning(location);
			}
		}
	}
	
	private void rightAction(Player player)
	{
		if (CoolTimeChecker.Check(player, 2)&&PlayerInventory.ItemCheck(player, material, stack2))
		{
			Block block = player.getTargetBlock(null, 30);
			if (BlockFilter.AirToFar(player, block))
			{
				Skill.Use(player, material, stack2, 2, coolTime2);
				World world = player.getWorld();
				Location location = block.getLocation();
				Random random = new Random();
				for (int i=0; i<5; i++)
				{
					int X = random.nextInt(11)-5;
					int Z = random.nextInt(11)-5;
					location.add(X, 0, Z);
					world.strikeLightning(location);
					location.add(-X, 0, -Z);
				}
			}
		}
	}
	
	public void T_Passive(EntityDamageEvent event)
	{
		if (event.getCause() == DamageCause.LIGHTNING || event.getCause() == DamageCause.ENTITY_EXPLOSION)
			event.setCancelled(true);
	}
}
