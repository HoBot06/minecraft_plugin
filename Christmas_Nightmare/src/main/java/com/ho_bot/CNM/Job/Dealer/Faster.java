// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Faster.java

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
import org.bukkit.util.Vector;

public class Faster extends Job
{

    public Faster(String playerName)
    {
        super(playerName, "\uD398\uC2A4\uD2B8", 7, des, ItemVar.FasterJobItem(Bukkit.getPlayer(playerName))[0], ItemVar.FasterJobItem(Bukkit.getPlayer(playerName))[1], ItemVar.FasterJobItem(Bukkit.getPlayer(playerName))[2], ItemVar.FasterJobItem(Bukkit.getPlayer(playerName))[3], ItemVar.FasterJobItem(Bukkit.getPlayer(playerName))[4]);
        cool = 5;
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

            case 2: // '\002'
            case 3: // '\003'
                rightAction(player);
                break;
            }
    }

    private void leftAction(Player player)
    {
        ShootUtility.ShootGunSpreadShoot(player, Particle.CRIT, 30, 1.0F, 4D, 0.0D, 0.0D, 0.0D, 0.0D, 1, Sound.ENTITY_GENERIC_EXPLODE, 1.0F, 1.0F, 10, 10);
    }

    private void rightAction(Player player)
    {
        if(CoolTimeUtil.Check(player))
        {
            Skill.Use(player, 5);
            Vector vec = player.getLocation().getDirection();
            vec.setY(0);
            player.setVelocity(vec.multiply(5));
        }
    }

    private final int coolTime = 5;
    private final int power = 5;
    private static final String des[];

    static 
    {
        des = JobVar.Faster_Des;
    }
}
