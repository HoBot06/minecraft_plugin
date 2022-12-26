// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   CapUtil.java

package com.ho_bot.CNM.Utility;

import com.ho_bot.CNM.Main;
import com.ho_bot.CNM.Var.EtcVar;
import java.util.HashMap;
import org.bukkit.*;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BossBar;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class CapUtil
{

    public CapUtil()
    {
    }

    public void CapCommand(Player player)
    {
        player.sendMessage("==========================================");
        player.sendMessage("/CNM Cap [Pos1/Pos2]");
        player.sendMessage("/CNM Cap Set [A/B/C]");
        player.sendMessage("==========================================");
    }

    public void SetCap(Player player, String CapName)
    {
        Location CapLoc[] = new Location[2];
        CapLoc[0] = (Location)EtcVar.Pos1.get(player.getUniqueId());
        CapLoc[1] = (Location)EtcVar.Pos2.get(player.getUniqueId());
        if(CapName.equalsIgnoreCase("A") || CapName.equalsIgnoreCase("B") || CapName.equalsIgnoreCase("C"))
        {
            EtcVar.Capture.put(CapName, CapLoc);
            FileCap(CapName, CapLoc);
            player.sendMessage((new StringBuilder(String.valueOf(CapName))).append("\uAC70\uC810 \uC704\uCE58\uAC00 \uC800\uC7A5\uB418\uC5C8\uC2B5\uB2C8\uB2E4").toString());
        } else
        {
            player.sendMessage("A, B, C \uC911\uC5D0\uC11C \uC785\uB825\uD574\uC8FC\uC2ED\uC2DC\uC694");
        }
    }

    public void FileCap(String CapName, Location CapLoc[])
    {
        ((Main)Main.getPlugin(com/ho_bot/CNM/Main)).getConfig().set((new StringBuilder(String.valueOf(CapName))).append(".W1").toString(), CapLoc[0].getWorld().getName());
        ((Main)Main.getPlugin(com/ho_bot/CNM/Main)).getConfig().set((new StringBuilder(String.valueOf(CapName))).append(".X1").toString(), Double.valueOf(CapLoc[0].getX()));
        ((Main)Main.getPlugin(com/ho_bot/CNM/Main)).getConfig().set((new StringBuilder(String.valueOf(CapName))).append(".Y1").toString(), Double.valueOf(CapLoc[0].getY()));
        ((Main)Main.getPlugin(com/ho_bot/CNM/Main)).getConfig().set((new StringBuilder(String.valueOf(CapName))).append(".Z1").toString(), Double.valueOf(CapLoc[0].getZ()));
        ((Main)Main.getPlugin(com/ho_bot/CNM/Main)).getConfig().set((new StringBuilder(String.valueOf(CapName))).append(".W2").toString(), CapLoc[1].getWorld().getName());
        ((Main)Main.getPlugin(com/ho_bot/CNM/Main)).getConfig().set((new StringBuilder(String.valueOf(CapName))).append(".X2").toString(), Double.valueOf(CapLoc[1].getX()));
        ((Main)Main.getPlugin(com/ho_bot/CNM/Main)).getConfig().set((new StringBuilder(String.valueOf(CapName))).append(".Y2").toString(), Double.valueOf(CapLoc[1].getY()));
        ((Main)Main.getPlugin(com/ho_bot/CNM/Main)).getConfig().set((new StringBuilder(String.valueOf(CapName))).append(".Z2").toString(), Double.valueOf(CapLoc[1].getZ()));
        ((Main)Main.getPlugin(com/ho_bot/CNM/Main)).saveConfig();
    }

    public void CapTeam(String CapName, String Team, BarColor barcolor)
    {
        BossBar bossbar = (BossBar)EtcVar.CaptureBossbar.get(CapName);
        if(!((String)EtcVar.NowCapTeam.get(CapName)).equals(Team))
            if(bossbar.getProgress() >= 1.0D)
            {
                bossbar.setColor(barcolor);
                bossbar.setProgress(0.0D);
                EtcVar.CaptureBossbar.put(CapName, bossbar);
            } else
            if(bossbar.getProgress() < 1.0D)
            {
                bossbar.setColor(barcolor);
                bossbar.setProgress(Math.min(1.0D, bossbar.getProgress() + 0.01D));
                EtcVar.CaptureBossbar.put(CapName, bossbar);
                if(bossbar.getProgress() >= 1.0D)
                {
                    EtcVar.NowCapTeam.put(CapName, Team);
                    Bukkit.broadcastMessage((new StringBuilder(String.valueOf(Team))).append("\uD300\uC774 ").append(CapName).append(" \uAC70\uC810\uC744 \uC810\uB839\uD588\uC2B5\uB2C8\uB2E4").toString());
                }
            }
    }
}
