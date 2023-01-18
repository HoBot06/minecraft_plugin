package septagram.Theomachy.Ability.ECT;

import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Momo_Eat {
	public static String Momo_Bread_Name = "모리바게트";
	public static void EatMomoBread(Player player, ItemStack item)
	{
		if (item.getType() == Material.BREAD && ChatColor.stripColor(item.getItemMeta().getDisplayName()).equalsIgnoreCase(Momo_Bread_Name)) {
			Random r = new Random();
			int rn = r.nextInt(7);
			switch(rn)
			{
			case 0: 
				player.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 100,4),true); break;
			case 1:
				player.addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 600,4),true);
				player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 100,1),true);
				break;
			case 2: 
				player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 300,0),true);
				player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 300,0),true); break;
			case 3: 
				player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 400,1),true); 
				break;
			case 4: 
				player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 600,0),true); 
				player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 600,0),true);
				break;
			case 5:
				player.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 600, 0),true);
				break;
			case 6:
				player.addPotionEffect(new PotionEffect(PotionEffectType.HEAL, 1, 0),true);
				player.addPotionEffect(new PotionEffect(PotionEffectType.SATURATION, 200, 0),true);
				break;
			}
		}
	}

}
