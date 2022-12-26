// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   CuriseTimer.java

package com.ho_bot.CNM.Scheduler.Skill;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class CuriseTimer extends BukkitRunnable
{

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

    private Player player;
    private double power;
}
