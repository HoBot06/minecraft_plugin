package septagram.Theomachy.Ability.DLC;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import septagram.Theomachy.Theomachy;
import septagram.Theomachy.Ability.Ability;
import septagram.Theomachy.Utility.CoolTimeChecker;
import septagram.Theomachy.Utility.EventFilter;
import septagram.Theomachy.Utility.PlayerInventory;
import septagram.Theomachy.Utility.Skill;

public class VendingMachine extends Ability
{
	private final int coolTime1=60;
	private final Material material1=Material.COBBLESTONE;
	private final int stack1=20;
	
	private final static String[] des= {"기계형 능력입니다.",
			   "능력 사용시 무작위 양동이를 뽑습니다."};
	
	public VendingMachine(String playerName)
	{
		super(playerName,"자판기", 210, true, false, false, des);
		Theomachy.log.info(playerName+abilityName);
		
		this.cool1=coolTime1;
		this.sta1=stack1;
		
		this.rank=1;
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
			Random r = new Random();
			int rn = r.nextInt(9);
			ItemStack item = new ItemStack(Material.BUCKET);
			item.setAmount(1);
			switch(rn) {
			case 0: item.setType(Material.WATER_BUCKET); break;
			case 1: item.setType(Material.LAVA_BUCKET); break;
			case 2: item.setType(Material.POWDER_SNOW_BUCKET); break;
			case 3: item.setType(Material.MILK_BUCKET); break;
			case 4: item.setType(Material.AXOLOTL_BUCKET); break;
			case 5: item.setType(Material.COD_BUCKET); break;
			case 6: item.setType(Material.PUFFERFISH_BUCKET); break;
			case 7: item.setType(Material.TROPICAL_FISH_BUCKET); break;
			case 8: item.setType(Material.SALMON_BUCKET); break;
			}
			player.getInventory().addItem(item);
		}
	}

}
