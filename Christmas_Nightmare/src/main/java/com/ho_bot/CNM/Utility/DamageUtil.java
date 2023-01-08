package com.ho_bot.CNM.Utility;

import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import com.ho_bot.CNM.Var.TeamVar;

public class DamageUtil
{
    public static void PlayerDamageEntity(EntityDamageByEntityEvent event)
    {
        if((event.getEntity() instanceof Player) && (event.getDamager() instanceof Player))
        {
            Player victim = (Player)event.getEntity();
            Player attacker = (Player)event.getDamager();
            if(TeamVar.Player_Team.containsKey(victim.getUniqueId()) && TeamVar.Player_Team.containsKey(attacker.getUniqueId())) {
            	if(TeamVar.Player_Team.get(victim.getUniqueId()).equals(TeamVar.Player_Team.get(attacker.getUniqueId()))) {
            		event.setCancelled(true);
            	}
            }
        }
        if((event.getEntity() instanceof Player) && (event.getDamager() instanceof Projectile))
        {
            Player victim = (Player)event.getEntity();
            Projectile arrow = (Projectile) event.getDamager();
            if(arrow.getShooter() instanceof Player) {
            	Player attacker = (Player) arrow.getShooter();
	            if(TeamVar.Player_Team.containsKey(victim.getUniqueId()) && TeamVar.Player_Team.containsKey(attacker.getUniqueId())) {
	            	if(TeamVar.Player_Team.get(victim.getUniqueId()).equals(TeamVar.Player_Team.get(attacker.getUniqueId()))) {
	            		arrow.remove();
	            		event.setCancelled(true);
	            	}
	            }
            }
        }
    }
}
