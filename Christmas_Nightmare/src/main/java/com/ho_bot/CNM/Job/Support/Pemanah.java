// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Pemanah.java

package com.ho_bot.CNM.Job.Support;

import com.ho_bot.CNM.Job.Job;
import com.ho_bot.CNM.Tools.GetNearSomeThing;
import com.ho_bot.CNM.Tools.Print_Effect;
import com.ho_bot.CNM.Var.ItemVar;
import com.ho_bot.CNM.Var.JobVar;
import java.util.Iterator;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.entity.ProjectileHitEvent;

public class Pemanah extends Job
{

    public Pemanah(String playerName)
    {
        super(playerName, "\uD398\uBAA8\uB098", 12, des, ItemVar.PemanahJobItem(Bukkit.getPlayer(playerName))[0], ItemVar.PemanahJobItem(Bukkit.getPlayer(playerName))[1], ItemVar.PemanahJobItem(Bukkit.getPlayer(playerName))[2], ItemVar.PemanahJobItem(Bukkit.getPlayer(playerName))[3], ItemVar.PemanahJobItem(Bukkit.getPlayer(playerName))[4]);
        particle = Particle.HEART;
        cool = 30;
    }

    public void T_Passive(ProjectileHitEvent event)
    {
        if(event.getEntity().getShooter() instanceof Player)
        {
            Player player = (Player)event.getEntity().getShooter();
            if(player.getName().equals(playerName))
            {
                List NearList = GetNearSomeThing.GetArrowNearTeam(event.getEntity(), player, 7D, 7D, 7D);
                Player p;
                for(Iterator iterator = NearList.iterator(); iterator.hasNext(); p.setHealth(Math.min(p.getMaxHealth(), p.getHealth() + 4D)))
                {
                    p = (Player)iterator.next();
                    Print_Effect.CircleParticle(particle, event.getEntity().getLocation(), 7, 1, 0.0D, 0.0D, 0.0D, 0.0D);
                }

            }
        }
    }

    private final int coolTime = 30;
    private final int dis = 7;
    private final int heal = 4;
    private final Particle particle;
    private static final String des[];

    static 
    {
        des = JobVar.Pemanah_Des;
    }
}
