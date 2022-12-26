// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ZoukTimer.java

package com.ho_bot.CNM.Scheduler.Skill;

import com.ho_bot.CNM.Tools.GetNearSomeThing;
import com.ho_bot.CNM.Tools.Print_Effect;
import com.ho_bot.CNM.Var.JobVar;
import java.util.*;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class ZoukTimer extends BukkitRunnable
{

    public ZoukTimer(Player player, int duration)
    {
        this.player = player;
        this.duration = duration;
    }

    public void run()
    {
        if(duration <= 0)
        {
            JobVar.Zouk_P.remove(player.getUniqueId());
            player.sendMessage("\uB2A5\uB825\uC774 \uC885\uB8CC\uB418\uC5C8\uC2B5\uB2C8\uB2E4");
            cancel();
        } else
        if(duration <= 5)
            player.sendMessage((new StringBuilder("\uB2A5\uB825 \uC885\uB8CC\uAE4C\uC9C0 : ")).append(duration).append("\uCD08").toString());
        duration--;
    }

    public static void ZoukSkill(Player player)
    {
        List NearList = GetNearSomeThing.GetPlayerNearTeam(player, 8D, 8D, 8D);
        Print_Effect.CircleParticle(JobVar.Zouk_Particle, player.getLocation(), 8, 1, 0.0D, 0.0D, 0.0D, 0.0D);
        for(Iterator iterator = NearList.iterator(); iterator.hasNext();)
        {
            Player p = (Player)iterator.next();
            p.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 20, 0), true);
            p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 20, 0), true);
            if(JobVar.Zouk_P.containsKey(player.getUniqueId()) && ((Boolean)JobVar.Zouk_P.get(player.getUniqueId())).booleanValue())
            {
                p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 20, 0), true);
                p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 20, 0), true);
            }
        }

    }

    private Player player;
    private int duration;
}
