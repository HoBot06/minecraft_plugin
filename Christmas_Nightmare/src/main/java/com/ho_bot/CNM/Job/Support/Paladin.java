// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Paladin.java

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
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class Paladin extends Job
{

    public Paladin(String playerName)
    {
        super(playerName, "\uD314\uB77C\uB518", 11, des, ItemVar.PaladinJobItem(Bukkit.getPlayer(playerName))[0], ItemVar.PaladinJobItem(Bukkit.getPlayer(playerName))[1], ItemVar.PaladinJobItem(Bukkit.getPlayer(playerName))[2], ItemVar.PaladinJobItem(Bukkit.getPlayer(playerName))[3], ItemVar.PaladinJobItem(Bukkit.getPlayer(playerName))[4]);
        cool = 30;
    }

    public void T_Passive(EntityDamageByEntityEvent event)
    {
        if(event.getDamager() instanceof Player)
        {
            Player atp = (Player)event.getDamager();
            if(atp.getName().equals(playerName))
            {
                List NearList = GetNearSomeThing.GetPlayerNearTeam(atp, 5D, 5D, 5D);
                Print_Effect.CircleParticle(Particle.HEART, atp.getLocation(), 5, 1, 0.0D, 0.0D, 0.0D, 0.0D);
                Player p;
                for(Iterator iterator = NearList.iterator(); iterator.hasNext(); p.setHealth(Math.min(p.getMaxHealth(), p.getHealth() + 2D)))
                    p = (Player)iterator.next();

            }
        }
    }

    private final int coolTime = 30;
    private final int dis = 5;
    private final double heal = 2D;
    private static final String des[];

    static 
    {
        des = JobVar.Paladin_Des;
    }
}
