package com.ho_bot.CNM.Scheduler.Skill;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class KratosTimer extends BukkitRunnable
{
	private Player victim;
    private Player damager;
    private double damage;

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
}
