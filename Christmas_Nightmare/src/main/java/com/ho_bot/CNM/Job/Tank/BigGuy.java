// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   BigGuy.java

package com.ho_bot.CNM.Job.Tank;

import com.ho_bot.CNM.Job.Job;
import com.ho_bot.CNM.Main;
import com.ho_bot.CNM.Scheduler.Skill.BigGuyParticleTimer;
import com.ho_bot.CNM.Scheduler.Skill.BigGuyTimer;
import com.ho_bot.CNM.Tools.*;
import com.ho_bot.CNM.Utility.CoolTimeUtil;
import com.ho_bot.CNM.Var.ItemVar;
import com.ho_bot.CNM.Var.JobVar;
import java.util.HashMap;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class BigGuy extends Job
{

    public BigGuy(String playerName)
    {
        super(playerName, "\uBE45\uAC00\uC774", 2, des, ItemVar.BigGuyJobItem(Bukkit.getPlayer(playerName))[0], ItemVar.BigGuyJobItem(Bukkit.getPlayer(playerName))[1], ItemVar.BigGuyJobItem(Bukkit.getPlayer(playerName))[2], ItemVar.BigGuyJobItem(Bukkit.getPlayer(playerName))[3], ItemVar.BigGuyJobItem(Bukkit.getPlayer(playerName))[4]);
        particle = Particle.CRIT;
        cool = 10;
    }

    public void T_Active(PlayerInteractEvent event)
    {
        Player player = event.getPlayer();
        if(P_Inv.InHandItemCheck(player, Material.BLAZE_ROD))
            switch(EventFilter.PlayerInteract(event))
            {
            case 2: // '\002'
            case 3: // '\003'
                rightAction(player);
                break;
            }
    }

    private void rightAction(Player player)
    {
        if(CoolTimeUtil.Check(player))
        {
            Skill.Use(player, 10);
            JobVar.BigGuy_P.put(player.getUniqueId(), Boolean.valueOf(true));
            BigGuyTimer BGT = new BigGuyTimer(player, 5);
            BGT.runTaskTimer(Main.getPlugin(com/ho_bot/CNM/Main), 0L, 20L);
            BigGuyParticleTimer BGPT = new BigGuyParticleTimer(player, 20, particle);
            BGPT.runTaskTimer(Main.getPlugin(com/ho_bot/CNM/Main), 0L, 5L);
        }
    }

    public void T_Passive(EntityDamageByEntityEvent event)
    {
        if(event.getEntity() instanceof Player)
        {
            Player p = (Player)event.getEntity();
            if(p.getName().equals(playerName) && JobVar.BigGuy_P.containsKey(p.getUniqueId()) && ((Boolean)JobVar.BigGuy_P.get(p.getUniqueId())).booleanValue())
                event.setDamage(event.getDamage() / 2D);
        }
    }

    private final int coolTime = 10;
    private final int duration = 5;
    private final Particle particle;
    private static final String des[];

    static 
    {
        des = JobVar.BigGuy_Des;
    }
}
