package septagram.Theomachy.Ability.GOD;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.scheduler.BukkitRunnable;

import septagram.Theomachy.Theomachy;
import septagram.Theomachy.Ability.Ability;
import septagram.Theomachy.DB.GameData;
import septagram.Theomachy.Utility.CoolTimeChecker;
import septagram.Theomachy.Utility.EventFilter;
import septagram.Theomachy.Utility.PlayerInventory;
import septagram.Theomachy.Utility.Skill;

public class Hephaestus extends Ability
{
	private final int coolTime0=10;
	private final Material material=Material.COBBLESTONE;
	private final int stack0=1;
	private final static String[] des= {"���� ���Դϴ�.",
			   "�⺻������ ȭ���������� ���� ������ ����� ��������� �ٷ� �� �ֽ��ϴ�.",
			   "�Ϲݴɷ��� ���� �ش� ������ ����� ���� �� �ֽ��ϴ�.",
			   "���� ����� 2�� �� ������ϴ�.",
			   "���� �� �� �������� �Խ��ϴ�."};
	
	public Hephaestus(String playerName)
	{
		super(playerName,"�������佺", 9, true, true, false, des);
		Theomachy.log.info(playerName+abilityName);
		
		this.cool1=coolTime0;
		this.sta1=stack0;
		
		this.rank=2;
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
			}
		}
	}

	private void leftAction(Player player)
	{
		Location location = player.getTargetBlock(null, 5).getLocation();
		location.setY(location.getY()+1);
		Block block = location.getBlock();
		if (block.getType() == Material.AIR)
		{
			if (CoolTimeChecker.Check(player, 0)&&PlayerInventory.ItemCheck(player, material, stack0))
			{
				Skill.Use(player, material, stack0, 0, coolTime0);
				block.setType(Material.LAVA);
				BukkitRunnable br = new LavaTimer(block);
				br.runTaskLater(Theomachy.getPlugin(Theomachy.class), 40L);
			}
		}
	}
	
	public void T_Passive(EntityDamageEvent event)
	{
		Player player = (Player) event.getEntity();
		DamageCause dc = event.getCause();
		if (dc.equals(DamageCause.LAVA) ||
			dc.equals(DamageCause.FIRE) ||
			dc.equals(DamageCause.FIRE_TICK))
		{
			event.setCancelled(true);
			player.setFireTicks(0);
		}
		else if (dc.equals(DamageCause.DROWNING))
			event.setDamage(event.getDamage()+1);
	}
	
	public void conditionSet()
	{
		Player player = GameData.OnlinePlayer.get(playerName);
		player.setMaximumAir(0);
		player.setRemainingAir(0);
	}
	
	
	public void conditionReSet()
	{
		Player player = GameData.OnlinePlayer.get(playerName);
		player.setMaximumAir(300);
		player.setRemainingAir(300);
	}
	
	
	
	
	class LavaTimer extends BukkitRunnable
	{
		Block block;
		
		LavaTimer(Block block)
		{
			this.block=block;
		}
		
		public void run()
		{
			block.setType(Material.AIR);
		}
	}
	
}
