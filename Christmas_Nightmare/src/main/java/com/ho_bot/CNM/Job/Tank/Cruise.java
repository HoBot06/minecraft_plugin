// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Cruise.java

package com.ho_bot.CNM.Job.Tank;

import com.ho_bot.CNM.Job.Job;
import com.ho_bot.CNM.Main;
import com.ho_bot.CNM.Scheduler.Skill.CuriseTimer;
import com.ho_bot.CNM.Tools.*;
import com.ho_bot.CNM.Utility.CoolTimeUtil;
import com.ho_bot.CNM.Var.ItemVar;
import com.ho_bot.CNM.Var.JobVar;
import java.util.Iterator;
import java.util.List;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

public class Cruise extends Job
{

    public Cruise(String playerName)
    {
        super(playerName, "\uD06C\uB8E8\uC2A4", 5, des, ItemVar.CruiseJobItem(Bukkit.getPlayer(playerName))[0], ItemVar.CruiseJobItem(Bukkit.getPlayer(playerName))[1], ItemVar.CruiseJobItem(Bukkit.getPlayer(playerName))[2], ItemVar.CruiseJobItem(Bukkit.getPlayer(playerName))[3], ItemVar.CruiseJobItem(Bukkit.getPlayer(playerName))[4]);
        onSkill = false;
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
            Vector vec = new Vector();
            vec = player.getLocation().getDirection();
            vec.multiply(4);
            vec.setY(3);
            player.setVelocity(vec);
            (new BukkitRunnable() {

                public void run()
                {
                    onSkill = true;
                }

                final Cruise this$0;

            
            {
                this$0 = Cruise.this;
                super();
            }
            }
).runTaskLater(Main.getPlugin(com/ho_bot/CNM/Main), 10L);
            CuriseTimer CT = new CuriseTimer(player, -4D);
            CT.runTaskLater(Main.getPlugin(com/ho_bot/CNM/Main), 30L);
        }
    }

    public void T_Passive(PlayerMoveEvent event)
    {
        Player p = event.getPlayer();
        if(p.getName().equals(playerName) && onSkill && p.isOnGround())
        {
            Print_Effect.CircleParticle(Particle.EXPLOSION_LARGE, p.getLocation(), 10, 1, 0.0D, 0.0D, 0.0D, 0.0D);
            List NearList = GetNearSomeThing.GetPlayerNearNotTeam(p, 10D, 10D, 10D);
            if(NearList != null)
            {
                Player enemy;
                for(Iterator iterator = NearList.iterator(); iterator.hasNext(); enemy.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 200, 1), true))
                    enemy = (Player)iterator.next();

            }
            onSkill = false;
        }
    }

    private final int coolTime = 30;
    private final int dis = 10;
    private final int duration = 200;
    private final int force_power = 4;
    private final int down_power = -4;
    private final int power = 1;
    private boolean onSkill;
    private static final String des[];

    static 
    {
        des = JobVar.Cruise_Des;
    }

}
