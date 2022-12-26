// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Point_Scheduler.java

package com.ho_bot.CNM.Scheduler;

import com.ho_bot.CNM.Var.EtcVar;
import java.util.*;
import org.bukkit.scheduler.BukkitRunnable;

public class Point_Scheduler extends BukkitRunnable
{

    public Point_Scheduler()
    {
    }

    public void run()
    {
        for(Iterator iterator = EtcVar.NowCapTeam.entrySet().iterator(); iterator.hasNext();)
        {
            java.util.Map.Entry Cap = (java.util.Map.Entry)iterator.next();
            if(!((String)Cap.getValue()).equals("white"))
            {
                if(((String)Cap.getValue()).equals("\uD06C\uB78C\uD478\uC2A4"))
                    EtcVar.TeamPoint.put("\uD06C\uB78C\uD478\uC2A4", Integer.valueOf(((Integer)EtcVar.TeamPoint.get("\uD06C\uB78C\uD478\uC2A4")).intValue() + 1));
                if(((String)Cap.getValue()).equals("\uC0B0\uD0C0"))
                    EtcVar.TeamPoint.put("\uC0B0\uD0C0", Integer.valueOf(((Integer)EtcVar.TeamPoint.get("\uC0B0\uD0C0")).intValue() + 1));
            }
        }

    }
}
