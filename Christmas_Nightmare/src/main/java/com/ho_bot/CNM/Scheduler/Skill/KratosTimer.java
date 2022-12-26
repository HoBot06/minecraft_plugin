// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   KratosTimer.java

package com.ho_bot.CNM.Scheduler.Skill;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class KratosTimer extends BukkitRunnable
{

    public KratosTimer(Player victim, Player damager, double damage)
    {
        this.victim = victim;
        this.damage = damage;
        this.damager = damager;
    }

    public void run()
    {
        victim.damage(damage, damager);
    }

    private Player victim;
    private Player damager;
    private double damage;
}
