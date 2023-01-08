package com.ho_bot.CNM.Scheduler;

import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import com.ho_bot.CNM.Utility.CapUtil;
import com.ho_bot.CNM.Utility.ToolUtil;
import com.ho_bot.CNM.Var.EtcVar;
import com.ho_bot.CNM.Var.TeamVar;
import com.ho_bot.CNM.Var.WordVar;

public class Cap_Scheduler extends BukkitRunnable
{
	ToolUtil Tutil;
    CapUtil Cutil;

    public Cap_Scheduler()
    {
        Tutil = new ToolUtil();
        Cutil = new CapUtil();
    }

    public void run()
    {
        for(Entry<String, Location[]> Cap : EtcVar.Capture.entrySet())
        {
            String isTeam = WordVar.NoTeam;
            Boolean isCap = true;
            for(Player player : Bukkit.getOnlinePlayers())
            {
                Location CapList[] = Cap.getValue();
                if(Tutil.CheckInLocation(player.getLocation().getBlock().getLocation(), CapList[0], CapList[1])) {
                	EtcVar.AddNowCap(Cap.getKey(), player);
                }
                else {
                    EtcVar.RemoveNowCap(Cap.getKey(), player);
                }
            }

            for(UUID player_uuid : EtcVar.NowInCapture.get(Cap.getKey()))
            {
                if(TeamVar.Player_Team.containsKey(player_uuid)) {
                    if(isTeam.equalsIgnoreCase(WordVar.NoTeam) || isTeam.equals(TeamVar.Player_Team.get(player_uuid))) {
                        isTeam = TeamVar.Player_Team.get(player_uuid);
                        continue;
                    }
                    if(isTeam != TeamVar.Player_Team.get(player_uuid)) {
                    	isCap = false;
                    }
                }
            }

            if(isCap)
            {
                if(!isTeam.equals(WordVar.NoTeam) && !isTeam.equals(EtcVar.NowCapTeam.get(Cap.getKey())))
                {
                    if(isTeam.equals(WordVar.Santa)) {
                        Cutil.CapTeam(Cap.getKey(), isTeam, BarColor.RED);
                        continue;
                    }
                    if(isTeam.equals(WordVar.Krampus)) {
                        Cutil.CapTeam(Cap.getKey(), isTeam, BarColor.BLUE);
                        continue;
                    }
                }
                if(isTeam.equals(WordVar.NoTeam) && !EtcVar.NowCapTeam.get(Cap.getKey()).equals(WordVar.NoTeam) || !isTeam.equals(WordVar.NoTeam) && EtcVar.NowCapTeam.get(Cap.getKey()).equals(isTeam))
                {
                    BossBar bossbar = EtcVar.CaptureBossbar.get(Cap.getKey());
                    bossbar.setProgress(1);
                    if(EtcVar.NowCapTeam.get(Cap.getKey()).equals(WordVar.Santa)) {
                        bossbar.setColor(BarColor.RED);
                    }
                    else if(EtcVar.NowCapTeam.get(Cap.getKey()).equals(WordVar.Krampus)) {
                        bossbar.setColor(BarColor.BLUE);
                    }
                    EtcVar.CaptureBossbar.put(Cap.getKey(), bossbar);
                }
                if(isTeam.equals(WordVar.NoTeam) && EtcVar.NowCapTeam.get(Cap.getKey()).equals(WordVar.NoTeam))
                {
                    BossBar bossbar = EtcVar.CaptureBossbar.get(Cap.getKey());
                    bossbar.setColor(BarColor.WHITE);
                    bossbar.setProgress(0.0D);
                    EtcVar.CaptureBossbar.put(Cap.getKey(), bossbar);
                }
            }
            BossBar bossbar = (BossBar)EtcVar.CaptureBossbar.get(Cap.getKey());
            bossbar.setColor(BarColor.WHITE);
            bossbar.setProgress(0.0D);
            EtcVar.CaptureBossbar.put((String)Cap.getKey(), bossbar);
        }

        ArrayList<UUID> noinplayer = new ArrayList<UUID>();
        for(Player player : Bukkit.getOnlinePlayers()) {
        	noinplayer.add(player.getUniqueId());
        }
        for(String capname : EtcVar.CapNameList)
        {
            for(UUID player_uuid : EtcVar.NowInCapture.get(capname))
            {
                noinplayer.remove(player_uuid);
                EtcVar.CaptureBossbar.get(capname).addPlayer(Bukkit.getPlayer(player_uuid));
            }

        }

        for(String capname : EtcVar.CapNameList)
        {
            for(UUID p : noinplayer)
                EtcVar.CaptureBossbar.get(capname).removePlayer(Bukkit.getPlayer(p));
        }

    }
}
