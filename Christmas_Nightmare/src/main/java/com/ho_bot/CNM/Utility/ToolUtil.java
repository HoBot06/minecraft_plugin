// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   ToolUtil.java

package com.ho_bot.CNM.Utility;

import com.ho_bot.CNM.Main;
import org.bukkit.*;
import org.bukkit.configuration.file.FileConfiguration;

public class ToolUtil
{

    public ToolUtil()
    {
    }

    public boolean CheckInLocation(Location PlayerLoc, Location Loc1, Location Loc2)
    {
        Boolean IsIn = Boolean.valueOf(false);
        if(Math.max(Loc1.getX(), Loc2.getX()) >= PlayerLoc.getX() && PlayerLoc.getX() >= Math.min(Loc1.getX(), Loc2.getX()) && Math.max(Loc1.getY(), Loc2.getY()) >= PlayerLoc.getY() && PlayerLoc.getY() >= Math.min(Loc1.getY(), Loc2.getY()) && Math.max(Loc1.getZ(), Loc2.getZ()) >= PlayerLoc.getZ() && PlayerLoc.getZ() >= Math.min(Loc1.getZ(), Loc2.getZ()))
            IsIn = Boolean.valueOf(true);
        return IsIn.booleanValue();
    }

    public Location[] ReturnCapLoc(String CapName)
    {
        Location LocList[] = new Location[2];
        Location loc1 = new Location(Bukkit.getWorld(((Main)Main.getPlugin(com/ho_bot/CNM/Main)).getConfig().getString((new StringBuilder(String.valueOf(CapName))).append(".W1").toString())), ((Main)Main.getPlugin(com/ho_bot/CNM/Main)).getConfig().getDouble((new StringBuilder(String.valueOf(CapName))).append(".X1").toString()), ((Main)Main.getPlugin(com/ho_bot/CNM/Main)).getConfig().getDouble((new StringBuilder(String.valueOf(CapName))).append(".Y1").toString()), ((Main)Main.getPlugin(com/ho_bot/CNM/Main)).getConfig().getDouble((new StringBuilder(String.valueOf(CapName))).append(".Z1").toString()));
        Location loc2 = new Location(Bukkit.getWorld(((Main)Main.getPlugin(com/ho_bot/CNM/Main)).getConfig().getString((new StringBuilder(String.valueOf(CapName))).append(".W2").toString())), ((Main)Main.getPlugin(com/ho_bot/CNM/Main)).getConfig().getDouble((new StringBuilder(String.valueOf(CapName))).append(".X2").toString()), ((Main)Main.getPlugin(com/ho_bot/CNM/Main)).getConfig().getDouble((new StringBuilder(String.valueOf(CapName))).append(".Y2").toString()), ((Main)Main.getPlugin(com/ho_bot/CNM/Main)).getConfig().getDouble((new StringBuilder(String.valueOf(CapName))).append(".Z2").toString()));
        LocList[0] = loc1;
        LocList[1] = loc2;
        return LocList;
    }

    public ChatColor CapTeamChatColor(String team)
    {
        if(team.equals("\uC0B0\uD0C0"))
            return ChatColor.RED;
        if(team.equals("\uD06C\uB78C\uD478\uC2A4"))
            return ChatColor.BLUE;
        else
            return ChatColor.WHITE;
    }
}
