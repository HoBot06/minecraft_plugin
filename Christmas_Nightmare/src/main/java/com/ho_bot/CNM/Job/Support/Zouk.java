// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Zouk.java

package com.ho_bot.CNM.Job.Support;

import com.ho_bot.CNM.Job.Job;
import com.ho_bot.CNM.Main;
import com.ho_bot.CNM.Scheduler.Skill.ZoukTimer;
import com.ho_bot.CNM.Tools.*;
import com.ho_bot.CNM.Utility.CoolTimeUtil;
import com.ho_bot.CNM.Var.ItemVar;
import com.ho_bot.CNM.Var.JobVar;
import java.util.HashMap;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

public class Zouk extends Job
{

    public Zouk(String playerName)
    {
        super(playerName, "\uC8FC\uD06C", 10, des, ItemVar.ZoukJobItem(Bukkit.getPlayer(playerName))[0], ItemVar.ZoukJobItem(Bukkit.getPlayer(playerName))[1], ItemVar.ZoukJobItem(Bukkit.getPlayer(playerName))[2], ItemVar.ZoukJobItem(Bukkit.getPlayer(playerName))[3], ItemVar.ZoukJobItem(Bukkit.getPlayer(playerName))[4]);
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
            JobVar.Zouk_P.put(player.getUniqueId(), Boolean.valueOf(true));
            ZoukTimer ZT = new ZoukTimer(player, 5);
            ZT.runTaskTimer(Main.getPlugin(com/ho_bot/CNM/Main), 0L, 20L);
        }
    }

    private final int coolTime = 10;
    private final int duration = 5;
    private static final String des[];

    static 
    {
        des = JobVar.Zouk_Des;
    }
}
