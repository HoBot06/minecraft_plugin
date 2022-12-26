// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Kratos.java

package com.ho_bot.CNM.Job.Dealer;

import com.ho_bot.CNM.Job.Job;
import com.ho_bot.CNM.Main;
import com.ho_bot.CNM.Scheduler.Skill.KratosTimer;
import com.ho_bot.CNM.Scheduler.Skill.KratosTimerTwo;
import com.ho_bot.CNM.Tools.*;
import com.ho_bot.CNM.Utility.CoolTimeUtil;
import com.ho_bot.CNM.Var.ItemVar;
import com.ho_bot.CNM.Var.JobVar;
import java.util.HashMap;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class Kratos extends Job
{

    public Kratos(String playerName)
    {
        super(playerName, "\uD06C\uB77C\uD1A0\uC2A4", 9, des, ItemVar.KratosJobItem(Bukkit.getPlayer(playerName))[0], ItemVar.KratosJobItem(Bukkit.getPlayer(playerName))[1], ItemVar.KratosJobItem(Bukkit.getPlayer(playerName))[2], ItemVar.KratosJobItem(Bukkit.getPlayer(playerName))[3], ItemVar.KratosJobItem(Bukkit.getPlayer(playerName))[4]);
        cool = 30;
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
            Skill.Use(player, 30);
            JobVar.Kratos_P.put(player.getUniqueId(), Boolean.valueOf(true));
            KratosTimerTwo KTT = new KratosTimerTwo(10, player);
            KTT.runTaskTimer(Main.getPlugin(com/ho_bot/CNM/Main), 0L, 20L);
        }
    }

    public void T_Passive(EntityDamageByEntityEvent event)
    {
        if(event.getDamager() instanceof Player)
        {
            Player atp = (Player)event.getDamager();
            if(atp.getName().equals(playerName) && JobVar.Kratos_P.containsKey(atp.getUniqueId()) && ((Boolean)JobVar.Kratos_P.get(atp.getUniqueId())).booleanValue())
            {
                KratosTimer KT = new KratosTimer((Player)event.getEntity(), atp, event.getDamage() / 2D);
                KT.runTaskLater(Main.getPlugin(com/ho_bot/CNM/Main), 10L);
                atp.sendMessage("\uB354\uBE14\uC5B4\uD0DD!");
            }
        }
    }

    private final int coolTime = 30;
    private static final String des[];

    static 
    {
        des = JobVar.Kratos_Des;
    }
}
