package septagram.Theomachy.Ability.DLC;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

import septagram.Theomachy.Theomachy;
import septagram.Theomachy.Ability.Ability;
import septagram.Theomachy.Timer.Skill.DireTimer;
import septagram.Theomachy.Utility.CoolTimeChecker;
import septagram.Theomachy.Utility.EventFilter;
import septagram.Theomachy.Utility.PlayerInventory;
import septagram.Theomachy.Utility.Skill;

public class Dire extends Ability
{
	private final int coolTime1=40;
	private final Material material1=Material.COBBLESTONE;
	private final int stack1=15;
	
	private final static String[] des= {"디르형 능력입니다.",
			   "능력 사용시 몇초동안 우~아한 목소리로 상대방을 혼란스럽게 합니다"};
	
	public Dire(String playerName)
	{
		super(playerName,"김디르", 216, true, true, false, des);
		Theomachy.log.info(playerName+abilityName);
		
		this.cool1=coolTime1;
		this.sta1=stack1;
		
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
		if (CoolTimeChecker.Check(player, 0)&&PlayerInventory.ItemCheck(player, material1, stack1))
		{
			Skill.Use(player, material1, stack1, 0, cool1);
			DireTimer DT = new DireTimer(player, 8);
			DT.runTaskTimer(Theomachy.getPlugin(Theomachy.class), 0, 20L);
		}
	}

}
