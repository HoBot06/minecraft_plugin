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
	private final static String[] des= {"일정시간 자신의 몸을 숨길 수 있는 능력입니다.",
			   "일반 능력을 이용해 자신의 모습을 7초동안 감출 수 있습니다.", 
			   "감춘 상태에서 상대방을 공격할 시 다시 모습이 나타나게 되며,",
			   "공격 당한 상대는 20% 확률로 사망합니다."};
	
	public Clocking(String playerName)
	{
		super(playerName,"클로킹", 112, true, true, false, des);
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
					target.sendMessage("알 수 없는 이유로 인해 즉사 하였습니다.");
					player.sendMessage("상대가 즉사 하였습니다.");
				}
			}
			super.flag = false;
		}
	}
}
