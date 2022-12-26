// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Patai.java

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
import org.bukkit.util.Vector;

public class Patai extends Job
{

    public Patai(String playerName)
    {
        super(playerName, "\uD30C\uD0C0\uC774", 4, des, ItemVar.PataiJobItem(Bukkit.getPlayer(playerName))[0], ItemVar.PataiJobItem(Bukkit.getPlayer(playerName))[1], ItemVar.PataiJobItem(Bukkit.getPlayer(playerName))[2], ItemVar.PataiJobItem(Bukkit.getPlayer(playerName))[3], ItemVar.PataiJobItem(Bukkit.getPlayer(playerName))[4]);
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
            List NearNotTeamList = GetNearSomeThing.GetPlayerNearNotTeam(player, 15D, 15D, 15D);
            Vector vec;
            for(Iterator iterator = NearNotTeamList.iterator(); iterator.hasNext(); vec.multiply(1))
            {
                Player p = (Player)iterator.next();
                vec = new Vector();
                vec = Vector_Cal.PlayerGrabVec(player.getLocation(), p.getLocation());
                vec.setY(2);
            }

            if(NearNotTeamList != null)
                player.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 600, 1 * NearNotTeamList.size()), true);
        }
    }

    private final int coolTime = 30;
    private final int dis = 15;
    private final int duration = 600;
    private final int grab_power = 1;
    private final int power = 1;
    private static final String des[];

    static 
    {
        des = JobVar.Patai_Des;
    }
}
