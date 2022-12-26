// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   BigGuyParticleTimer.java

package com.ho_bot.CNM.Scheduler.Skill;

import com.ho_bot.CNM.Tools.Print_Effect;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class BigGuyParticleTimer extends BukkitRunnable
{

    public BigGuyParticleTimer(Player player, int duration, Particle particle)
    {
        this.player = player;
        this.duration = duration;
        this.particle = particle;
    }

    public void run()
    {
        if(duration <= 0)
            cancel();
        Print_Effect.CircleParticle(particle, player.getLocation(), 6, 1, 0.0D, 0.0D, 0.0D, 0.0D);
        duration--;
    }

    private Player player;
    private int duration;
    private Particle particle;
}
