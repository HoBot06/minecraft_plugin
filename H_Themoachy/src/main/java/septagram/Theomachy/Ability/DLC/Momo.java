package septagram.Theomachy.Ability.DLC;

import java.util.Arrays;
import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import septagram.Theomachy.Theomachy;
import septagram.Theomachy.Ability.Ability;
import septagram.Theomachy.Ability.ECT.Momo_Eat;
import septagram.Theomachy.Utility.EventFilter;
import septagram.Theomachy.Utility.PlayerInventory;

public class Momo extends Ability
{
	private final static String[] des= {"귀농형 능력입니다.",
			   "20%의 확률로 자신이 캔 밀이 3배로 나옵니다" ,
			   "일반능력 사용시 밀3개를 소모하여 특별한 빵을 만듭니다",
			   "고급능력 사용시 밀30개를 소모하여 특별한 빵 10개를 만듭니다"};
	
	public Momo(String playerName)
	{
		super(playerName,"김모모", 203, true, true, false, des);
		Theomachy.log.info(playerName+abilityName);
		
		this.cool1=0;
		this.cool2=0;
		this.sta1=0;
		this.sta2=0;
		
		this.rank=3;
	}
	
	public void T_Passive(BlockBreakEvent event)
	{
		Player player = event.getPlayer();
		if(event.getBlock().getType() == Material.WHEAT) {
			Random r = new Random();
			int rn = r.nextInt(5);
			if(rn == 0) {
				World world = player.getWorld();
				Location loc = event.getBlock().getLocation();
				event.setDropItems(false);
				world.dropItem(loc, new ItemStack(Material.WHEAT, 3));
				world.dropItem(loc, new ItemStack(Material.WHEAT_SEEDS, 1));
				player.sendMessage("풍년이다!");
			}
		}
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
		if (player.getInventory().contains(Material.WHEAT, 3))
		{
			ItemStack momo_b = new ItemStack(Material.BREAD);
			ItemMeta momo_bm = momo_b.getItemMeta();
			momo_bm.setDisplayName(ChatColor.WHITE + Momo_Eat.Momo_Bread_Name);
			momo_bm.setLore(Arrays.asList(ChatColor.GRAY + "먹으면 든든해질 것 같다"));
			momo_b.setItemMeta(momo_bm);
			momo_b.setAmount(1);
			
			player.getInventory().removeItem(new ItemStack(Material.WHEAT, 3));
			player.getInventory().addItem(momo_b);
		}
		else
		{
			player.sendMessage("밀이 부족합니다");
		}
	}
	
	private void rightAction(Player player)
	{
		if (player.getInventory().contains(Material.WHEAT, 30))
		{
			ItemStack momo_b = new ItemStack(Material.BREAD);
			ItemMeta momo_bm = momo_b.getItemMeta();
			momo_bm.setDisplayName(ChatColor.WHITE + Momo_Eat.Momo_Bread_Name);
			momo_bm.setLore(Arrays.asList(ChatColor.GRAY + "먹으면 든든해질 것 같다"));
			momo_b.setItemMeta(momo_bm);
			momo_b.setAmount(10);
			
			player.getInventory().removeItem(new ItemStack(Material.WHEAT, 30));
			player.getInventory().addItem(momo_b);
		}
		else
		{
			player.sendMessage("밀이 부족합니다");
		}
	}
}
