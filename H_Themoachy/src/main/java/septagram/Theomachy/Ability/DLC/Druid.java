package septagram.Theomachy.Ability.DLC;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

import septagram.Theomachy.Theomachy;
import septagram.Theomachy.Ability.Ability;
import septagram.Theomachy.Timer.Skill.DruidTimer;
import septagram.Theomachy.Utility.CoolTimeChecker;
import septagram.Theomachy.Utility.EventFilter;
import septagram.Theomachy.Utility.PlayerInventory;
import septagram.Theomachy.Utility.Skill;

public class Druid extends Ability{
	
	private final int duration=10;
	private final int coolTime1=25;
	private final int stack1=8;
	private final Material material1=Material.COBBLESTONE;
	private final int XZ_distance=4;
	private final int Y_distance=3;

	private final static String[] des= { "자연친화 능력입니다.",
			   "능력 사용시 지속시간 동안 주변 식물의 성장을 촉진시킵니다."};

	public Druid(String playerName) {
		super(playerName, "드루이드", 214, true, false, false, des);
		
		this.rank=4;
		
		this.sta1=stack1;
		this.cool1=coolTime1;
	}
	
	
	public void T_Active(PlayerInteractEvent event){
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
	
	private void leftAction(Player player) {
		if(PlayerInventory.ItemCheck(player, Material.COBBLESTONE, sta1)&&CoolTimeChecker.Check(player, 0)) {
			Skill.Use(player, material1, stack1, 0, coolTime1);
			DruidTimer DT = new DruidTimer(player, duration, XZ_distance, Y_distance);
			DT.runTaskTimer(Theomachy.getPlugin(Theomachy.class), 0, 20L);
		}
	}
}
