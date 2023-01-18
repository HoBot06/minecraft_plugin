package septagram.Theomachy.Ability.DLC;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

import septagram.Theomachy.Theomachy;
import septagram.Theomachy.Ability.Ability;
import septagram.Theomachy.Timer.Skill.SirenTimer;
import septagram.Theomachy.Utility.CoolTimeChecker;
import septagram.Theomachy.Utility.EventFilter;
import septagram.Theomachy.Utility.PlayerInventory;
import septagram.Theomachy.Utility.Skill;

public class Siren extends Ability{
	
	private final int coolTime1=60;
	private final int stack1=15;
	private final Material material1=Material.COBBLESTONE;

	private final static String[] des= { "경보기 능력입니다.",
			   "능력 사용시 일정시간동안 주변 적에게 폭죽을 터트립니다"};

	public Siren(String playerName) {
		super(playerName, "사이렌", 215, true, false, false, des);
		
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
			Bukkit.broadcastMessage("<"+player.getName()+"> "+ ChatColor.RED +"삐용삐용!!!");
			SirenTimer ST = new SirenTimer(player, 5);
			ST.runTaskTimer(Theomachy.getPlugin(Theomachy.class), 0, 20L);
		}
	}
}
