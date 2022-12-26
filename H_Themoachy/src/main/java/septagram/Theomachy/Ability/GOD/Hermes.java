package septagram.Theomachy.Ability.GOD;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import septagram.Theomachy.Theomachy;
import septagram.Theomachy.Ability.Ability;
import septagram.Theomachy.DB.GameData;
import septagram.Theomachy.Timer.Skill.HermesFlying;
import septagram.Theomachy.Utility.CoolTimeChecker;
import septagram.Theomachy.Utility.EventFilter;
import septagram.Theomachy.Utility.PlayerInventory;
import septagram.Theomachy.Utility.Skill;

public class Hermes extends Ability
{
	private final int coolTime0=60;
	private final Material material=Material.COBBLESTONE;
	private final int stack0=2;
	private final static String[] des= {"�������� ���Դϴ�.",
			   "�⺻������ �̵��ӵ��� ������ ������ �ε带",
			   "����� �ɷ��� ���� ���� �� �� �ֽ��ϴ�.",
			   "���� �� �����ϸ鼭 ���ø� �ٷ� �� �� �ֽ��ϴ�." ,
			   "���� �߿��� ���� �������� ���� �ʽ��ϴ�."};
	
	public Hermes(String playerName)
	{
		super(playerName,"�츣�޽�", 11, true, true, true, des);
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
			player.setAllowFlight(true);
			player.setFlying(true);
			BukkitRunnable Hermes = new HermesFlying(player);
			Hermes.runTaskTimer(Theomachy.getPlugin(Theomachy.class), 0, 20L);
		}
	}
	
	public void buff()
	{
		Player player = GameData.OnlinePlayer.get(playerName);
		if (player != null)
		{
			BukkitRunnable bf = new buff(player);
			bf.runTaskTimer(Theomachy.getPlugin(Theomachy.class), 0, 20L);
		}
	}
	
	private class buff extends BukkitRunnable
	{
		final Player player;
		
		buff(Player player)
		{
			this.player = player;	
		}
		public void run()
		{
			player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 6000, 0),true);
		}
	}
}
