package septagram.Theomachy.Ability.GOD;

import java.util.Collection;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;

import septagram.Theomachy.Theomachy;
import septagram.Theomachy.Ability.Ability;
import septagram.Theomachy.DB.GameData;
import septagram.Theomachy.Message.T_Message;
import septagram.Theomachy.Timer.CoolTime;
import septagram.Theomachy.Utility.CoolTimeChecker;
import septagram.Theomachy.Utility.EventFilter;
import septagram.Theomachy.Utility.PlayerInventory;
import septagram.Theomachy.Utility.Skill;

public class Poseidon extends Ability
{
	private boolean flag = true;
	private final int coolTime0=240;
	private final Material material=Material.COBBLESTONE;
	private final int stack0=5;
	private final static String[] des= {"���� ���Դϴ�.",
			   "�� �ӿ� ���� �� ����Ȯ���� ��� �ǰ��� 33% Ȯ���� ȸ���մϴ�.",
			   "�� �ӿ��� ���� ���� 7�� ���� ȿ���� ���ӵ˴ϴ�.",
			   "������ �ε带 �̿��� �ɷ����� �ڽ��� ������ ���� �����ϸ�",
			   "���� 7�� ���� ���� �ִ� �÷��̾�� ��� ���������ϴ�.",
			   "������ ���൹�� ���� �� �ֽ��ϴ�."};
	
	public Poseidon(String playerName)
	{
		super(playerName,"�����̵�", 2, true, true, false, des);
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
			if (flag)
			{
				Skill.Use(player, material, stack0, 0, coolTime0);
				Location location = player.getLocation();
				Vector v = player.getEyeLocation().getDirection();
				v.setX(Math.round(v.getX()));
				v.setY(0);
				v.setZ(Math.round(v.getZ()));
				KnockBack  k = new KnockBack(player,v); 
				Wave w = new Wave(player, location, v);
				k.start();
				w.start();
			}
			else
				player.sendMessage("��ų�� ���ӽð��� ������ �ʾ� ����� �� �����ϴ�.");
		}
	}
	class KnockBack extends Thread
	{
		final Player player;
		Vector v;
		
		KnockBack(Player player, Vector v)
		{
			this.player=player;
			this.v=v.clone();
			this.v.multiply(10);
			this.v.setY(10);
		}

		public void run()
		{
			flag = false;
			Collection<? extends Player> players = Bukkit.getOnlinePlayers();
			for (int i=0; i<5; i++)
			{
				for (Player player : players)
					if (player != this.player && (player.getLocation().getBlock().getType() == Material.WATER)) {
						player.setVelocity(v);
					}
				try {
					sleep(1500);
				} catch (InterruptedException e) {
				}
			}
			flag = true;
		}
	}
	class Wave extends Thread
	{
		final Player player;
		final Location location;
		final Location remove;
		final Vector v;
		
		
		
		Wave(Player player, Location location, Vector v)
		{
			this.player = player;
			this.location = location.add(0,2,0);
			this.remove = location.clone();
			this.v=v;
		}
		
		public void run()
		{
			try
			{
				for (int i=0; i<9; i++)
				{
					Block b = location.add(v).getBlock();
					if (b.getType() == Material.AIR || b.getType() == Material.COBBLESTONE)
						b.setType(Material.WATER);
				}
				sleep(3000);
				for (int i=0; i<9; i++)
				{
					Block b = remove.add(v).getBlock();
					if (b.getType() == Material.WATER)
						b.setType(Material.WATER);
				}
			}
			catch(Exception e)
			{}
		}
	}


	public void T_Passive(EntityDamageEvent event)
	{
		Player player = (Player) event.getEntity();
		if (event.getCause() == DamageCause.DROWNING)
		{
			event.setCancelled(true);
			CoolTime.COOL0.put(playerName+"0", 7);
			T_Message.PassiveEnable(player, 0);
		}
		else if (CoolTime.COOL0.containsKey(player.getName()+"0"))
		{
			int rn = (int) (Math.random()*3);
			if (rn == 0)
			{
				event.setCancelled(true);
				player.sendMessage("ȸ��");
			}
		}
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
}
