// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   KratosTimerTwo.java

package com.ho_bot.CNM.Scheduler.Skill;

import com.ho_bot.CNM.Var.JobVar;
import java.util.HashMap;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class KratosTimerTwo extends BukkitRunnable
{

    public KratosTimerTwo(int duration, Player player)
    {
        this.duration = duration;
        this.player = player;
    }

    public void run()
    {
        if(duration <= 0)
        {
            JobVar.Kratos_P.remove(player.getUniqueId());
            player.sendMessage("\uB2A5\uB825\uC774 \uC885\uB8CC\uB418\uC5C8\uC2B5\uB2C8\uB2E4");
            cancel();
        } else
        if(duration <= 5)
            player.sendMessage((new StringBuilder("\uB2A5\uB825 \uC885\uB8CC\uAE4C\uC9C0 : ")).append(duration).append("\uCD08").toString());
        duration--;
    }

    private Player player;
    private int duration;
}
