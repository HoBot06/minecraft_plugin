package com.ho_bot.CNM.Job;

import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;

public class Job
{
	public final String playerName;
    public final String abilityName;
    public final int abilityCode;
    public final String description[];
    public final ItemStack weapon;
    public final ItemStack helmet;
    public final ItemStack chestplate;
    public final ItemStack leggings;
    public final ItemStack boots;
    public int cool = -1;

    public Job(String playerName, String abilityName, int abilityCode, String des[],
    		ItemStack weapon, ItemStack helmet, ItemStack chestplate, ItemStack leggings, ItemStack boots) 
    {
        this.playerName = playerName;
        this.abilityName = abilityName;
        this.abilityCode = abilityCode;
        this.description = des;
        this.weapon = weapon;
        this.helmet = helmet;
        this.chestplate = chestplate;
        this.leggings = leggings;
        this.boots = boots;
    }

    public void T_Active(PlayerInteractEvent playerinteractevent) {}

    public void T_Passive(EntityDamageByEntityEvent entitydamagebyentityevent) {}

    public void T_Passive(EntityDamageEvent entitydamageevent) {}

    public void T_Passive(PlayerMoveEvent playermoveevent) {}

    public void T_Passive(ProjectileHitEvent projectilehitevent) {}
    
    public void T_Passive(ProjectileLaunchEvent projectilelaunchevent) {}

}
