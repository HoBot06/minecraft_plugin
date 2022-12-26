package septagram.Theomachy.Ability.HUMAN;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import septagram.Theomachy.Ability.Ability;
import septagram.Theomachy.Utility.BlockFilter;
import septagram.Theomachy.Utility.CoolTimeChecker;
import septagram.Theomachy.Utility.EventFilter;
import septagram.Theomachy.Utility.PlayerInventory;
import septagram.Theomachy.Utility.Skill;

public class Megumin extends Ability{

	private final static String[] des= { "이 능력은 메구밍!",
											   "아크 위저드이자, 최강의 공격 마법인",
											   "폭렬 마법을 다루는 능력!",
											   "그렇습니다. 목숨당 한 번,",
											   "전방에 폭렬 마법을 날릴 수 있습니다.",
											   "블레이즈 로드로 선택한 블럭에 강력한 ",
											   "폭발을 날릴 수 있습니다. 단, 리스폰시 사용가능해집니다"};
	
	public Megumin(String playerName) {
		super(playerName, "메구밍", 128, true, false, false, des);
		
		this.rank=4;
		
		this.sta1=32;
		this.cool1=30;
	}

	private boolean cancel=false;
	
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
			if(!cancel) {
				Block block=player.getTargetBlock(null, 25);
				if (BlockFilter.AirToFar(player, block))
				{
					Skill.Use(player, Material.COBBLESTONE, 32, 0, 10);
					Location loc = block.getLocation();
					loc.add(0, 1, 0);
					player.getWorld().createExplosion(loc, 8.0f);
					Bukkit.broadcastMessage(ChatColor.RED + "★☆★☆익스플로젼!☆★☆★");
					
					this.cancel=true;
				}
			}
			else {
				player.sendMessage("더 이상 쓸 수 없습니다...");
			}
		}
	}
	
	public void T_Passive(PlayerDeathEvent event)
	{
		Player player = event.getEntity();
		if(player.getName().equalsIgnoreCase(playerName)) {
			conditionSet();
		}
	}
	
	public void conditionSet(){
		this.cancel=false;
	}
	
}
