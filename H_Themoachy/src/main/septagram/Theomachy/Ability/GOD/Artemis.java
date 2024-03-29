package septagram.Theomachy.Ability.GOD;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import septagram.Theomachy.Theomachy;
import septagram.Theomachy.Ability.Ability;
import septagram.Theomachy.Timer.CoolTime;
import septagram.Theomachy.Utility.CoolTimeChecker;
import septagram.Theomachy.Utility.EventFilter;
import septagram.Theomachy.Utility.PlayerInventory;
import septagram.Theomachy.Utility.Skill;

public class Artemis extends Ability
{	
	private final int coolTime1=20;
	private final int coolTime2=180;
	private final Material material=Material.COBBLESTONE;
	private final int stack1=7;
	private final int stack2=15;
	private final static String[] des= {"사냥과 달의 신입니다.\n",
			   "일반능력으로 화살을, 고급 능력으로 활을 만들 수 있습니다.\n",
			   "화살로 공격당한 플레이어는 15%의 확률로 즉사합니다."};
	
	public Artemis(String playerName)
	{
		super(playerName,"아르테미스", 7, true, true, false, des);
		Theomachy.log.info(playerName+abilityName);
		
		this.cool1=coolTime1;
		this.cool2=coolTime2;
		this.sta1=stack1;
		this.sta2=stack2;
		
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
			Skill.Use(player, material, stack1, 1, coolTime1);
			player.getInventory().addItem(new ItemStack(Material.ARROW, 1));
		}
	}
	
	private void rightAction(Player player)
	{
		if (CoolTimeChecker.Check(player, 2)&&PlayerInventory.ItemCheck(player, material, stack2))
		{
			Skill.Use(player, material, stack2, 2, coolTime2);
			player.getInventory().addItem(new ItemStack(Material.BOW, 1));
		}
	}
	
	public void T_Passive(EntityDamageByEntityEvent event)
	{
		
		Arrow arrow = (Arrow) event.getDamager();
		Player player = (Player) arrow.getShooter();
		Player target = (Player) event.getEntity();
		if (!CoolTime.COOL0.containsKey(target.getName()+"1"))
		{
			Random random = new Random();
			if (random.nextInt(20) <= 2)
			{
				
				event.setDamage(100);
				player.sendMessage("화살이 상대방의 심장을 꿰뚫었습니다!");
				target.sendMessage("아르테미스의 화살에 즉사하였습니다.");
			}
		}
	}	
}
