package com.ho_bot.CNM.Utility;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;

import com.ho_bot.CNM.Main;
import com.ho_bot.CNM.Var.EtcVar;

public class CapUtil
{
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
        CapLoc[0] = EtcVar.Pos1.get(player.getUniqueId());
        CapLoc[1] = EtcVar.Pos2.get(player.getUniqueId());
        if(CapName.equalsIgnoreCase("A") || CapName.equalsIgnoreCase("B") || CapName.equalsIgnoreCase("C"))
        {
            EtcVar.Capture.put(CapName, CapLoc);
            FileCap(CapName, CapLoc);
            player.sendMessage(CapName + "거점 위치가 저장되었습니다");
        } else
        {
            player.sendMessage("A, B, C 중에서 입력해주십시요");
        }
    }

    public void FileCap(String CapName, Location CapLoc[])
    {
        Main.getPlugin(Main.class).getConfig().set(CapName + ".W1", CapLoc[0].getWorld().getName());
        Main.getPlugin(Main.class).getConfig().set(CapName + ".X1", CapLoc[0].getX());
        Main.getPlugin(Main.class).getConfig().set(CapName + ".Y1", CapLoc[0].getY());
        Main.getPlugin(Main.class).getConfig().set(CapName + ".Z1", CapLoc[0].getZ());
        Main.getPlugin(Main.class).getConfig().set(CapName + ".W2", CapLoc[1].getWorld().getName());
        Main.getPlugin(Main.class).getConfig().set(CapName + ".X2", CapLoc[1].getX());
        Main.getPlugin(Main.class).getConfig().set(CapName + ".Y2", CapLoc[1].getY());
        Main.getPlugin(Main.class).getConfig().set(CapName + ".Z2", CapLoc[1].getZ());
        Main.getPlugin(Main.class).saveConfig();
    }

    public void CapTeam(String CapName, String Team, BarColor barcolor)
    {
        BossBar bossbar = EtcVar.CaptureBossbar.get(CapName);
        if(!EtcVar.NowCapTeam.get(CapName).equals(Team)) {
            if(bossbar.getProgress() >= 1)
            {
                bossbar.setColor(barcolor);
                bossbar.setProgress(0);
                EtcVar.CaptureBossbar.put(CapName, bossbar);
            }
            else if(bossbar.getProgress() < 1)
            {
                bossbar.setColor(barcolor);
                bossbar.setProgress(Math.min(1, bossbar.getProgress() + 0.01));
                EtcVar.CaptureBossbar.put(CapName, bossbar);
                if(bossbar.getProgress() >= 1)
                {
                    EtcVar.NowCapTeam.put(CapName, Team);
                    Bukkit.broadcastMessage(Team + "팀이 " + CapName + " 거점을 점령했습니다");
                }
            }
        }
    }
}
