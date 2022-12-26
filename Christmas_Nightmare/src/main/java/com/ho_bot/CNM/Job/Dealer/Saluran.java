// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Saluran.java

package com.ho_bot.CNM.Job.Dealer;

import com.ho_bot.CNM.Job.Job;
import com.ho_bot.CNM.Tools.*;
import com.ho_bot.CNM.Utility.CoolTimeUtil;
import com.ho_bot.CNM.Utility.ShootUtility;
import com.ho_bot.CNM.Var.ItemVar;
import com.ho_bot.CNM.Var.JobVar;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

public class Saluran extends Job
{

    public Saluran(String playerName)
    {
        super(playerName, "\uC0B4\uB8E8\uB780", 6, des, ItemVar.SaluranJobItem(Bukkit.getPlayer(playerName))[0], ItemVar.SaluranJobItem(Bukkit.getPlayer(playerName))[1], ItemVar.SaluranJobItem(Bukkit.getPlayer(playerName))[2], ItemVar.SaluranJobItem(Bukkit.getPlayer(playerName))[3], ItemVar.SaluranJobItem(Bukkit.getPlayer(playerName))[4]);
        coolTime = 1;
        cool = coolTime;
    }

    public void T_Active(PlayerInteractEvent event)
    {
        Player player = event.getPlayer();
        if(P_Inv.InHandItemCheck(player, Material.BLAZE_ROD))
            switch(EventFilter.PlayerInteract(event))
            {
            case 0: // '\0'
            case 1: // '\001'
                leftAction(player);
                break;
            }
    }

    private void leftAction(Player player)
    {
        if(CoolTimeUtil.Check(player))
        {
            Skill.Use(player, coolTime);
            ShootUtility.LineShoot(player, Particle.CRIT, 30, 1.0F, 4D, 0.0D, 0.0D, 0.0D, 0.0D, 1, Sound.ITEM_CROSSBOW_SHOOT, 1.0F, 1.0F);
        }
    }

    private int coolTime;
    private static final String des[];

    static 
    {
        des = JobVar.Saluran_Des;
    }
}
