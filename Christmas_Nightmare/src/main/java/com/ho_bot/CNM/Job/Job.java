// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Job.java

package com.ho_bot.CNM.Job;

import org.bukkit.event.entity.*;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;

public class Job
{

    public Job(String playerName, String abilityName, int abilityCode, String des[], ItemStack weapon, ItemStack helmet, ItemStack chestplate, 
            ItemStack leggings, ItemStack boots)
    {
        cool = -1;
        this.playerName = playerName;
        this.abilityName = abilityName;
        this.abilityCode = abilityCode;
        description = des;
        this.weapon = weapon;
        this.helmet = helmet;
        this.chestplate = chestplate;
        this.leggings = leggings;
        this.boots = boots;
    }

    public void T_Active(PlayerInteractEvent playerinteractevent)
    {
    }

    public void T_Passive(EntityDamageByEntityEvent entitydamagebyentityevent)
    {
    }

    public void T_Passive(EntityDamageEvent entitydamageevent)
    {
    }

    public void T_Passive(PlayerMoveEvent playermoveevent)
    {
    }

    public void T_Passive(ProjectileHitEvent projectilehitevent)
    {
    }

    public void T_Passive(ProjectileLaunchEvent projectilelaunchevent)
    {
    }

    public final String playerName;
    public final String abilityName;
    public final int abilityCode;
    public final String description[];
    public final ItemStack weapon;
    public final ItemStack helmet;
    public final ItemStack chestplate;
    public final ItemStack leggings;
    public final ItemStack boots;
    public int cool;
}
