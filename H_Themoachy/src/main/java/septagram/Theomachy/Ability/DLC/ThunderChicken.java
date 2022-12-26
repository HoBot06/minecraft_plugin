package septagram.Theomachy.Ability.DLC;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

import septagram.Theomachy.Theomachy;
import septagram.Theomachy.Ability.Ability;
import septagram.Theomachy.Timer.Skill.ThunderChickenTimer;
import septagram.Theomachy.Utility.CoolTimeChecker;
import septagram.Theomachy.Utility.EventFilter;
import septagram.Theomachy.Utility.PlayerInventory;
import septagram.Theomachy.Utility.Skill;
import septagram.Theomachy.Utility.Sounds;

public class ThunderChicken extends Ability
{
	private final int coolTime0=50;
	private final Material material=Material.COBBLESTONE;
	private final int stack0=10;
	private final float movepower=2f;
	private final float forcepower=1f;
	private final static String[] des= {"방패형 능력입니다.",
			   "블레이즈 로드를 통해 능력을 사용하면" ,
			   "방패가 지급됩니다." ,
			   "방패를 들고 쉬프트를 누르면 앞으로 나아가며 방패로 밀칩니다.",
			   "그후 구속이 걸리고 구속이 걸린동안은 대쉬를 할 수 없습니다",
			   "단, 방패를 제외한 모든 데미지는 1이 되고 방패 데미지는 3로 고정됩니다"};
	
	public ThunderChicken(String playerName)
	{
		super(playerName,"전기구이통닭", 209, true, true, false, des);
		Theomachy.log.info(playerName+abilityName);
		
		this.cool1=coolTime0;
		this.sta1=stack0;
		
		this.rank=2;
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
		if (CoolTimeChecker.Check(player, 2)&&PlayerInventory.ItemCheck(player, material, stack0))
		{
			Skill.Use(player, material, stack0, 2, coolTime0);
			player.getInventory().addItem(new ItemStack(Material.SHIELD, 1));
		}
	}
	
	public void T_Passive(PlayerMoveEvent event)
	{
		Player player = event.getPlayer();
		if(player.getName().equalsIgnoreCase(playerName)) {
			if (player.isBlocking()&&player.isSneaking()&&!player.hasPotionEffect(PotionEffectType.SLOW))
			{
				float angle = player.getLocation().getYaw();
				player.setSneaking(false);
				World world = player.getWorld();
				Location location = player.getLocation();
				Vector v = player.getEyeLocation().getDirection();
				v.setX(-(Math.sin(Math.toRadians(angle))*movepower));
				v.setZ(Math.cos(Math.toRadians(angle))*movepower);
				player.setVelocity(v);
				world.spawnParticle(Particle.EXPLOSION_LARGE, location, 1);
				player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 200, 0), true);
				for(Player p : Bukkit.getOnlinePlayers()) {
					Sounds.SoundPL(p, player.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 0.4f, 1.0f);
				}
				
				ThunderChickenTimer TCH = new ThunderChickenTimer(player, forcepower, (int) movepower * 3);
				TCH.runTaskTimer(Theomachy.getPlugin(Theomachy.class), 0, 1L);
			}
		}
	}
	
	public void T_Passive(EntityDamageByEntityEvent event)
	{
		if(event.getDamager() instanceof Player) {
			Player player = (Player) event.getDamager();
			if(player.getName().equalsIgnoreCase(playerName)) {
				if(player.getInventory().getItemInMainHand().getType() != null) {
					if(player.getInventory().getItemInMainHand().getType() == Material.SHIELD) {
						event.setDamage(3);
					}
					else {
						event.setDamage(1);
					}
				}
			}
		}
	}
}
