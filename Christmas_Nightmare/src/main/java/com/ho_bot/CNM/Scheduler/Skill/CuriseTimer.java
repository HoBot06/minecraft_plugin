package com.ho_bot.CNM.Scheduler.Skill;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class CuriseTimer extends BukkitRunnable
{
	private Player player;
    private double power;

    public CuriseTimer(Player player, double power)
    {
        this.player = player;
        this.power = power;
    }

    public void run()
    {
        Vector vec = new Vector();
        vec.setY(power);
        player.setVelocity(vec);
    }
}
