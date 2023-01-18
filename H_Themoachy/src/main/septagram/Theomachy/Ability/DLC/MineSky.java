package septagram.Theomachy.Ability.DLC;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.scheduler.BukkitRunnable;

import septagram.Theomachy.Theomachy;
import septagram.Theomachy.Ability.Ability;
import septagram.Theomachy.Timer.Skill.MineSkyTimer;
import septagram.Theomachy.Utility.Particles;

public class MineSky extends Ability
{
	private boolean Dimension_in = false;
	private boolean Dimension_try = false;
	private final int in_time = 3;
	private final static String[] des= {"불안정한 능력입니다.",
			   "주기적으로 차원여행을 떠납니다" ,
			   "다른 차원에서는 데미지를 받지 않습니다"};
	
	public MineSky(String playerName)
	{
		super(playerName,"김마스", 207, false, true, false, des);
		Theomachy.log.info(playerName+abilityName);
		
		this.rank=3;
	}
	
	
	public void T_Passive(PlayerMoveEvent event) {
		if(event.getPlayer().getName().equalsIgnoreCase(playerName)) {
			Random r = new Random();
			int r_i = r.nextInt(400);
			if(r_i == 0 && !Dimension_try) {
				event.getPlayer().sendMessage("몸이 불안정해지고 있습니다");
				int inv_duraion = r.nextInt(3) + 3;
				Dimension_try = true;
				MineSkyTimer MST = new MineSkyTimer(event.getPlayer(), inv_duraion, in_time);
				MST.runTaskTimer(Theomachy.getPlugin(Theomachy.class), 0, 20L);
				new BukkitRunnable() {
					@Override
					public void run() {
						Dimension_in = true;
					}
				}.runTaskLater(Theomachy.getPlugin(Theomachy.class), (long)(in_time*20));
				new BukkitRunnable() {
					@Override
					public void run() {
						Dimension_try = false;
						Dimension_in = false;
					}
				}.runTaskLater(Theomachy.getPlugin(Theomachy.class), (long)((inv_duraion+in_time+1)*20));
			}
			if(Dimension_in && event.getPlayer().isSprinting()) {
				Particles.particleL(Particle.ASH, event.getPlayer().getLocation().getBlock().getLocation(), event.getPlayer(), 15, 0.4d, 0.2d, 0.4d);
			}
		}
	}
	
	public void T_Passive(EntityDamageEvent event)
	{
		if(event.getEntity() instanceof Player) {
			if(event.getEntity().getName().equalsIgnoreCase(playerName) && Dimension_in) {
				event.setCancelled(true);
			}
		}
	}
	
	public void T_Passive(BlockBreakEvent event)
	{
		if(event.getPlayer().getName().equalsIgnoreCase(playerName) && Dimension_in) {
			event.setCancelled(true);
		}
	}
	
	public void T_Passive(BlockPlaceEvent event)
	{
		if(event.getPlayer().getName().equalsIgnoreCase(playerName) && Dimension_in) {
			event.setCancelled(true);
		}
	}
	
	public void T_PassiveInteract(PlayerInteractEvent event) {
		if(event.getPlayer().getName().equalsIgnoreCase(playerName) && Dimension_in) {
			event.setCancelled(true);
		}
	}
}
