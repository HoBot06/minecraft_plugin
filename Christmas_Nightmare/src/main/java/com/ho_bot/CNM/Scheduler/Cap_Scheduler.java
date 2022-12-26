// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Cap_Scheduler.java

package com.ho_bot.CNM.Scheduler;

import com.ho_bot.CNM.Utility.CapUtil;
import com.ho_bot.CNM.Utility.ToolUtil;
import com.ho_bot.CNM.Var.EtcVar;
import com.ho_bot.CNM.Var.TeamVar;
import java.util.*;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class Cap_Scheduler extends BukkitRunnable
{

    public Cap_Scheduler()
    {
        Tutil = new ToolUtil();
        Cutil = new CapUtil();
    }

    public void run()
    {
        for(Iterator iterator = EtcVar.Capture.entrySet().iterator(); iterator.hasNext();)
        {
            java.util.Map.Entry Cap = (java.util.Map.Entry)iterator.next();
            String isTeam = "white";
            Boolean isCap = Boolean.valueOf(true);
            for(Iterator iterator6 = Bukkit.getOnlinePlayers().iterator(); iterator6.hasNext();)
            {
                Player player = (Player)iterator6.next();
                Location CapList[] = (Location[])Cap.getValue();
                if(Tutil.CheckInLocation(player.getLocation().getBlock().getLocation(), CapList[0], CapList[1]))
                    EtcVar.AddNowCap((String)Cap.getKey(), player);
                else
                    EtcVar.RemoveNowCap((String)Cap.getKey(), player);
            }

            for(Iterator iterator7 = ((ArrayList)EtcVar.NowInCapture.get(Cap.getKey())).iterator(); iterator7.hasNext();)
            {
                UUID player_uuid = (UUID)iterator7.next();
                if(TeamVar.Player_Team.containsKey(player_uuid))
                    if(isTeam.equalsIgnoreCase("white"))
                        isTeam = (String)TeamVar.Player_Team.get(player_uuid);
                    else
                    if(isTeam != TeamVar.Player_Team.get(player_uuid))
                        isCap = Boolean.valueOf(false);
            }

            if(isCap.booleanValue())
            {
                if(!isTeam.equals("white") && !isTeam.equals(EtcVar.NowCapTeam.get(Cap.getKey())))
                {
                    if(isTeam.equals("\uC0B0\uD0C0"))
                        Cutil.CapTeam((String)Cap.getKey(), isTeam, BarColor.RED);
                    else
                    if(isTeam.equals("\uD06C\uB78C\uD478\uC2A4"))
                        Cutil.CapTeam((String)Cap.getKey(), isTeam, BarColor.BLUE);
                } else
                if(isTeam.equals("white") && !((String)EtcVar.NowCapTeam.get(Cap.getKey())).equals("white") || !isTeam.equals("white") && ((String)EtcVar.NowCapTeam.get(Cap.getKey())).equals(isTeam))
                {
                    BossBar bossbar = (BossBar)EtcVar.CaptureBossbar.get(Cap.getKey());
                    bossbar.setProgress(1.0D);
                    if(((String)EtcVar.NowCapTeam.get(Cap.getKey())).equals("\uC0B0\uD0C0"))
                        bossbar.setColor(BarColor.RED);
                    else
                    if(((String)EtcVar.NowCapTeam.get(Cap.getKey())).equals("\uD06C\uB78C\uD478\uC2A4"))
                        bossbar.setColor(BarColor.BLUE);
                    EtcVar.CaptureBossbar.put((String)Cap.getKey(), bossbar);
                } else
                if(isTeam.equals("white") && ((String)EtcVar.NowCapTeam.get(Cap.getKey())).equals("white"))
                {
                    BossBar bossbar = (BossBar)EtcVar.CaptureBossbar.get(Cap.getKey());
                    bossbar.setColor(BarColor.WHITE);
                    bossbar.setProgress(0.0D);
                    EtcVar.CaptureBossbar.put((String)Cap.getKey(), bossbar);
                }
            } else
            {
                BossBar bossbar = (BossBar)EtcVar.CaptureBossbar.get(Cap.getKey());
                bossbar.setColor(BarColor.WHITE);
                bossbar.setProgress(0.0D);
                EtcVar.CaptureBossbar.put((String)Cap.getKey(), bossbar);
            }
        }

        ArrayList noinplayer = new ArrayList();
        Player player;
        for(Iterator iterator1 = Bukkit.getOnlinePlayers().iterator(); iterator1.hasNext(); noinplayer.add(player.getUniqueId()))
            player = (Player)iterator1.next();

        for(Iterator iterator2 = EtcVar.CapNameList.iterator(); iterator2.hasNext();)
        {
            String capname = (String)iterator2.next();
            UUID player_uuid;
            for(Iterator iterator4 = ((ArrayList)EtcVar.NowInCapture.get(capname)).iterator(); iterator4.hasNext(); ((BossBar)EtcVar.CaptureBossbar.get(capname)).addPlayer(Bukkit.getPlayer(player_uuid)))
            {
                player_uuid = (UUID)iterator4.next();
                noinplayer.remove(player_uuid);
            }

        }

        for(Iterator iterator3 = EtcVar.CapNameList.iterator(); iterator3.hasNext();)
        {
            String capname = (String)iterator3.next();
            UUID p;
            for(Iterator iterator5 = noinplayer.iterator(); iterator5.hasNext(); ((BossBar)EtcVar.CaptureBossbar.get(capname)).removePlayer(Bukkit.getPlayer(p)))
                p = (UUID)iterator5.next();

        }

    }

    ToolUtil Tutil;
    CapUtil Cutil;
}
