package septagram.Theomachy.Ability.DLC;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import septagram.Theomachy.Theomachy;
import septagram.Theomachy.Ability.Ability;
import septagram.Theomachy.Utility.CoolTimeChecker;
import septagram.Theomachy.Utility.EventFilter;
import septagram.Theomachy.Utility.PlayerInventory;
import septagram.Theomachy.Utility.Skill;

public class ICanFly extends Ability
{
	private boolean IsFly = false;
	private final int coolTime1=100;
	private final Material material1=Material.COBBLESTONE;
	private final int stack1=30;
	
	private final static String[] des= {"���۱��� �ɷ��Դϴ�.",
			   "�ɷ� ���� 5�� ���� ���� �ڽ��� �߹ؿ� ���� ����ϴ�"};
	
	public ICanFly(String playerName)
	{
		super(playerName,"����ĵ�ö���", 213, true, true, false, des);
		Theomachy.log.info(playerName+abilityName);
		
		this.cool1=coolTime1;
		this.sta1=stack1;
		
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
		if (CoolTimeChecker.Check(player, 0)&&PlayerInventory.ItemCheck(player, material1, stack1))
		{
			Skill.Use(player, material1, stack1, 0, cool1);
			IsFly = true;
			player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100,1),true);
			new BukkitRunnable() {
				@Override
				public void run() {
					player.sendMessage("�ɷ� ������� 3����");
				}
			}.runTaskLater(Theomachy.getPlugin(Theomachy.class), 40);
			new BukkitRunnable() {
				@Override
				public void run() {
					player.sendMessage("�ɷ� ������� 2����");
				}
			}.runTaskLater(Theomachy.getPlugin(Theomachy.class), 60);
			new BukkitRunnable() {
				@Override
				public void run() {
					player.sendMessage("�ɷ� ������� 1����");
				}
			}.runTaskLater(Theomachy.getPlugin(Theomachy.class), 80);
			new BukkitRunnable() {
				@Override
				public void run() {
					IsFly = false;
				}
			}.runTaskLater(Theomachy.getPlugin(Theomachy.class), 100);
		}
	}
	
	public void T_Passive(PlayerMoveEvent event)
	{
		if(event.getPlayer().getName().equalsIgnoreCase(playerName)) {
			if(IsFly) {
				Location blockloc = event.getPlayer().getLocation().getBlock().getLocation();
				blockloc.setY(blockloc.getY()-1);
				if(blockloc.getBlock().getType()==Material.AIR) {
					event.getPlayer().getWorld().getBlockAt(blockloc).setType(Material.GLASS);
				}
			}
		}
	}

}
