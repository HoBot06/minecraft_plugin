package septagram.Theomachy.Ability.HUMAN;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

import septagram.Theomachy.Theomachy;
import septagram.Theomachy.Ability.Ability;
import septagram.Theomachy.Utility.CoolTimeChecker;
import septagram.Theomachy.Utility.EventFilter;
import septagram.Theomachy.Utility.PlayerInventory;
import septagram.Theomachy.Utility.Skill;

public class Bomber extends Ability
{
	private final int coolTime0=20;
	private final Material material=Material.COBBLESTONE;
	private final int stack0=5;
	private Location tntLocation;
	private final static String[] des= {"������ �ٷ�� �ɷ��Դϴ�.",
			   "��Ŭ������ �ش� ��ġ�� ������ �ʴ� TNT�� ��ġ�ϸ�" ,
			   "��Ŭ������ ��𼭵� ���߽�ų �� �ֽ��ϴ�."};
	
	public Bomber(String playerName)
	{
		super(playerName,"����", 105, true, false, false, des);
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
			case 1:
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
		Block block = player.getTargetBlock(null, 5);
		if (block.getType() != Material.AIR)
		{
			Location location = block.getLocation();
			location.setY(location.getY()+1);
			this.tntLocation = location;
			player.sendMessage("�ش� ���� ��ź�� ��ġ�Ǿ����ϴ�.");			
		}
	}
	
	private void rightAction(Player player)
	{
		if (CoolTimeChecker.Check(player, 0)&&PlayerInventory.ItemCheck(player, material, stack0))
		{
			if (tntLocation != null)
			{
				Skill.Use(player, material, stack0, 0, coolTime0);
				World world = player.getWorld();
				world.createExplosion(tntLocation, 4.5f, true);
				tntLocation = null;
				player.sendMessage("TNT�� �����߽��ϴ�!");
				
			}
			else
				player.sendMessage("TNT�� ��ġ���� �ʾҽ��ϴ�.");
		}
	}
}
