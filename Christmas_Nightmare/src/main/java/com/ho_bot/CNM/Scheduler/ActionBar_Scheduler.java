// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ActionBar_Scheduler.java

package com.ho_bot.CNM.Scheduler;

import com.ho_bot.CNM.Utility.ToolUtil;
import com.ho_bot.CNM.Var.EtcVar;
import java.util.*;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class ActionBar_Scheduler extends BukkitRunnable
{

    public ActionBar_Scheduler()
    {
        TU = new ToolUtil();
    }

    public void run()
    {
        String CapMsg = "";
        for(Iterator iterator = EtcVar.NowCapTeam.entrySet().iterator(); iterator.hasNext();)
        {
            java.util.Map.Entry Cap = (java.util.Map.Entry)iterator.next();
            CapMsg = (new StringBuilder(String.valueOf(CapMsg))).append(ChatColor.WHITE).append("| ").append(TU.CapTeamChatColor((String)Cap.getValue())).append((String)Cap.getKey()).append(ChatColor.WHITE).append(" |").toString();
        }

        CapMsg = (new StringBuilder()).append(ChatColor.RED).append(ChatColor.BOLD).append("\uC0B0\uD0C0 : ").append(ChatColor.RED).append(EtcVar.TeamPoint.get("\uC0B0\uD0C0")).append("   ").append(CapMsg).append("   ").append(ChatColor.BLUE).append(EtcVar.TeamPoint.get("\uD06C\uB78C\uD478\uC2A4")).append(ChatColor.BLUE).append(ChatColor.BOLD).append(" : \uD06C\uB78C").toString();
        Player p;
        for(Iterator iterator1 = Bukkit.getOnlinePlayers().iterator(); iterator1.hasNext(); p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent((new StringBuilder(String.valueOf(CapMsg))).toString())))
            p = (Player)iterator1.next();

    }

    ToolUtil TU;
}
