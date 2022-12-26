// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Egis.java

package com.ho_bot.CNM.Job.Tank;

import com.ho_bot.CNM.Job.Job;
import com.ho_bot.CNM.Tools.*;
import com.ho_bot.CNM.Utility.CoolTimeUtil;
import com.ho_bot.CNM.Var.ItemVar;
import com.ho_bot.CNM.Var.JobVar;
import java.util.Iterator;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Egis extends Job
{

    public Egis(String playerName)
    {
        super(playerName, "\uC5D0\uAE30\uC2A4", 3, des, ItemVar.EgisJobItem(Bukkit.getPlayer(playerName))[0], ItemVar.EgisJobItem(Bukkit.getPlayer(playerName))[1], ItemVar.EgisJobItem(Bukkit.getPlayer(playerName))[2], ItemVar.EgisJobItem(Bukkit.getPlayer(playerName))[3], ItemVar.EgisJobItem(Bukkit.getPlayer(playerName))[4]);
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
            List NearList = GetNearSomeThing.GetPlayerNearTeam(player, 30D, 30D, 30D);
            Player p;
            for(Iterator iterator = NearList.iterator(); iterator.hasNext(); p.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 600, 2), true))
                p = (Player)iterator.next();

            player.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 600, 2), true);
        }
    }

    private final int coolTime = 30;
    private final int dis = 30;
    private final int duration = 600;
    private final int power = 2;
    private static final String des[];

    static 
    {
        des = JobVar.Egis_Des;
    }
}
