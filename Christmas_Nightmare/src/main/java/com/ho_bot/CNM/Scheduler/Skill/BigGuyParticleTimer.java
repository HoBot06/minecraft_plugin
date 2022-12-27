package com.ho_bot.CNM.Scheduler.Skill;

import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import com.ho_bot.CNM.Tools.Print_Effect;

public class BigGuyParticleTimer extends BukkitRunnable
{
	private Player player;
    private int duration;
    private Particle particle;

    public BigGuyParticleTimer(Player player, int duration, Particle particle)
    {
        this.player = player;
        this.duration = duration;
        this.particle = particle;
    }

    public void run()
    {
        if(duration <= 0) {
        	this.cancel();
        }
        Print_Effect.CircleParticle(particle, player.getLocation(), 6, 1, 0, 0, 0, 0);
        duration--;
    }
}
