package com.ho_bot.CNM.Scheduler;

import java.util.Map.Entry;

import org.bukkit.scheduler.BukkitRunnable;

import com.ho_bot.CNM.Var.EtcVar;
import com.ho_bot.CNM.Var.WordVar;

public class Point_Scheduler extends BukkitRunnable
{
    public void run()
    {
        for(Entry<String, String> Cap : EtcVar.NowCapTeam.entrySet())
        {
            if(!Cap.getValue().equals("white"))
            {
                if(Cap.getValue().equals(WordVar.Krampus)) {
                    EtcVar.TeamPoint.put(WordVar.Krampus, EtcVar.TeamPoint.get(WordVar.Krampus) + 1);
                }
                if(Cap.getValue().equals(WordVar.Santa)) {
                    EtcVar.TeamPoint.put(WordVar.Santa, EtcVar.TeamPoint.get(WordVar.Santa) + 1);
                }
            }
        }
    }
}
