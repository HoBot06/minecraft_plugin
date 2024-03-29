package septagram.Theomachy.Ability.HUMAN;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

import septagram.Theomachy.Theomachy;
import septagram.Theomachy.Ability.Ability;
import septagram.Theomachy.Utility.CoolTimeChecker;
import septagram.Theomachy.Utility.EventFilter;
import septagram.Theomachy.Utility.PlayerInventory;
import septagram.Theomachy.Utility.Skill;

public class Bomber extends Ability
{
	private final int coolTime0=20;
	private final Material material=Material.COBBLESTONE;
	private final int stack0=5;
	private Location tntLocation;
	private final static String[] des= {"폭발을 다루는 능력입니다.",
			   "좌클릭으로 해당 위치에 보이지 않는 TNT를 설치하며" ,
			   "우클릭으로 어디서든 폭발시킬 수 있습니다."};
	
	public Bomber(String playerName)
	{
		super(playerName,"봄버", 105, true, false, false, des);
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
			case 1:
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
		Block block = player.getTargetBlock(null, 5);
		if (block.getType() != Material.AIR)
		{
			Location location = block.getLocation();
			location.setY(location.getY()+1);
			this.tntLocation = location;
			player.sendMessage("해당 블럭에 폭탄이 설치되었습니다.");			
		}
	}
	
	private void rightAction(Player player)
	{
		if (CoolTimeChecker.Check(player, 0)&&PlayerInventory.ItemCheck(player, material, stack0))
		{
			if (tntLocation != null)
			{
				Skill.Use(player, material, stack0, 0, coolTime0);
				World world = player.getWorld();
				world.createExplosion(tntLocation, 4.5f, true);
				tntLocation = null;
				player.sendMessage("TNT가 폭발했습니다!");
				
			}
			else
				player.sendMessage("TNT가 설치되지 않았습니다.");
		}
	}
}
