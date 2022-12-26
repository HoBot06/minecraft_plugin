// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Bomber.java

package com.ho_bot.CNM.Job.Dealer;

import com.ho_bot.CNM.Job.Job;
import com.ho_bot.CNM.Main;
import com.ho_bot.CNM.Scheduler.Skill.BomberTimer;
import com.ho_bot.CNM.Tools.*;
import com.ho_bot.CNM.Utility.CoolTimeUtil;
import com.ho_bot.CNM.Utility.ShootUtility;
import com.ho_bot.CNM.Var.ItemVar;
import com.ho_bot.CNM.Var.JobVar;
import java.util.HashMap;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class Bomber extends Job
{

    public Bomber(String playerName)
    {
        super(playerName, "\uBD04\uBC84", 8, des, ItemVar.BomberJobItem(Bukkit.getPlayer(playerName))[0], ItemVar.BomberJobItem(Bukkit.getPlayer(playerName))[1], ItemVar.BomberJobItem(Bukkit.getPlayer(playerName))[2], ItemVar.BomberJobItem(Bukkit.getPlayer(playerName))[3], ItemVar.BomberJobItem(Bukkit.getPlayer(playerName))[4]);
        cool = 30;
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
        if(JobVar.Bomber_P.containsKey(player.getUniqueId()))
        {
            if(((Boolean)JobVar.Bomber_P.get(player.getUniqueId())).booleanValue())
                ShootUtility.SnowShoot(player, player.getLocation().getDirection(), 1.2F);
        } else
        {
            ShootUtility.LineShoot(player, Particle.END_ROD, 30, 1.0F, 2D, 0.0D, 0.0D, 0.0D, 0.0D, 1, Sound.BLOCK_PISTON_CONTRACT, 1.0F, 1.0F);
        }
    }

    private void rightAction(Player player)
    {
        if(CoolTimeUtil.Check(player))
        {
            Skill.Use(player, 30);
            JobVar.Bomber_P.put(player.getUniqueId(), Boolean.valueOf(true));
            BomberTimer BT = new BomberTimer(player, 20);
            BT.runTaskTimer(Main.getPlugin(com/ho_bot/CNM/Main), 0L, 20L);
        }
    }

    public void T_Passive(ProjectileHitEvent event)
    {
        if(event.getEntity().getShooter() instanceof Player)
        {
            Player player = (Player)event.getEntity().getShooter();
            if(player.getName().equals(playerName) && JobVar.Bomber_P.containsKey(player.getUniqueId()) && ((Boolean)JobVar.Bomber_P.get(player.getUniqueId())).booleanValue())
                event.getEntity().getWorld().createExplosion(event.getEntity().getLocation(), 2.0F, false, false, player);
        }
    }

    private final int coolTime = 30;
    private final int duration = 20;
    private final int power = 2;
    private static final String des[];

    static 
    {
        des = JobVar.Bomber_Des;
    }
}
