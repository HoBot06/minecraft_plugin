package septagram.Theomachy.Ability.HUMAN;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import septagram.Theomachy.Theomachy;
import septagram.Theomachy.Ability.Ability;
import septagram.Theomachy.Utility.CoolTimeChecker;
import septagram.Theomachy.Utility.EventFilter;
import septagram.Theomachy.Utility.PlayerInventory;
import septagram.Theomachy.Utility.Skill;

public class Creeper extends Ability
{
	private final int coolTime0=60;
	private final Material material=Material.COBBLESTONE;
	private final int stack0=20;
	private boolean plasma = false;
	private final static String[] des= {"������ �ɷ��Դϴ�.",
			   "������ �ε带 ���� �ɷ��� ����ϸ�" ,
			   "ũ���ۿ� ���� ���߷��� ������ ����ŵ�ϴ�." ,
			   "������ ���� ���� �ִٸ� ���߷��� �� ��� �����մϴ�.",
			   "���� ī������ ������ �ʱ�ȭ�˴ϴ�."};
	
	public Creeper(String playerName)
	{
		super(playerName,"ũ����", 106, true, false, false, des);
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
			World world = player.getWorld();
			Location location = player.getLocation();
			float power = plasma ? 9.0f : 5.0f;
			player.setHealth(0);
			world.createExplosion(location, power);
		}
	}
	
	public void T_Passive(EntityDamageEvent event)
	{
		if (event.getCause() == DamageCause.LIGHTNING)
		{
			this.plasma = true;
			((Player)event.getEntity()).sendMessage(ChatColor.AQUA+"�ö�� ũ���� ��� Ȱ��ȭ!");
		}
	}
	
	public void T_Passive(PlayerDeathEvent event)
	{
		this.plasma=false;
	}
}
