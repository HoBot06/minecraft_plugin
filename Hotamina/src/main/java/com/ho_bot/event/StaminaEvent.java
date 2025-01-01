package com.ho_bot.event;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.event.player.PlayerFishEvent.State;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import com.ho_bot.main.Hotamina;
import com.ho_bot.util.StaminaUtil;
import com.ho_bot.util.VarUtil;

public class StaminaEvent implements Listener{
	
	public static Hotamina plugin;

	public static void setPlugin(Hotamina MainPlugin)
    {
        plugin = MainPlugin;
    }
	
	private StaminaUtil staminaU = new StaminaUtil();
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		if(VarUtil.Player_Stamina.containsKey(event.getPlayer().getUniqueId())) return;
		VarUtil.Player_Stamina.put(event.getPlayer().getUniqueId(), (float) VarUtil.maxStamina);
	}
	
	/*@EventHandler
	public void onQuit(PlayerQuitEvent event) {
		if(!VarUtil.Player_Stamina.containsKey(event.getPlayer().getUniqueId())) return;
		VarUtil.Player_Stamina.remove(event.getPlayer().getUniqueId());
	}*/
	
	@EventHandler
	public void onBreak(BlockBreakEvent event) {
		staminaU.setStamina(event.getPlayer(), staminaU.getStamina(event.getPlayer())-VarUtil.breakStamina);
	}
	
	/*@EventHandler
	public void onPlace(BlockPlaceEvent event) {
		staminaU.setStamina(event.getPlayer(), staminaU.getStamina(event.getPlayer())-VarUtil.breakStamina);
	}*/
	
	@EventHandler
	public void onInteractEntity(PlayerInteractEntityEvent event) {
		if(event.getRightClicked() != null) {
			staminaU.setStamina(event.getPlayer(), staminaU.getStamina(event.getPlayer())-VarUtil.breakStamina);
		}
	}
	
	@EventHandler
	public void onDamage(EntityDamageByEntityEvent event) {
		if(event.getDamager() instanceof Player player) {
			staminaU.setStamina(player, staminaU.getStamina(player)-VarUtil.breakStamina);
		}
	}
	
	@EventHandler
	public void onInteract(PlayerInteractEvent event) {
		if(event.getAction()==Action.LEFT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
			staminaU.setStamina(event.getPlayer(), staminaU.getStamina(event.getPlayer())-VarUtil.breakStamina);
		}
	}
	
	@EventHandler
	public void onFish(PlayerFishEvent event) {
		if(event.getState() == State.CAUGHT_ENTITY || event.getState() == State.CAUGHT_FISH || event.getState() == State.FAILED_ATTEMPT) {
			staminaU.setStamina(event.getPlayer(), staminaU.getStamina(event.getPlayer())-VarUtil.breakStamina);
		}
	}
	
	@EventHandler
	public void onItemConsume(PlayerItemConsumeEvent event) {
		VarUtil.Player_Foodlevel.put(event.getPlayer().getUniqueId(), event.getPlayer().getFoodLevel());
	}
	
	@EventHandler
	public void onFoodlevel(FoodLevelChangeEvent event) {
		if(event.getFoodLevel() > 0) {
			healFood((Player) event.getEntity(), event.getFoodLevel());
		}
	}
	
	private void healFood(Player player, int foodlevel) {
		try {
			int food = foodlevel - VarUtil.Player_Foodlevel.get(player.getUniqueId());
			staminaU.setStamina(player, Math.min(VarUtil.maxStamina, staminaU.getStamina(player)+food*VarUtil.healFood));
		} catch (Exception e) {

		}
	}

}
