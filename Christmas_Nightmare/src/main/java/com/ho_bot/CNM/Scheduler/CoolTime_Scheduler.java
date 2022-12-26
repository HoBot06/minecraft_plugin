// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   CoolTime_Scheduler.java

package com.ho_bot.CNM.Scheduler;

import com.ho_bot.CNM.Utility.MsgUtil;
import java.util.*;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class CoolTime_Scheduler extends BukkitRunnable
{

    public CoolTime_Scheduler()
    {
    }

    public void run()
    {
        for(Iterator iterator = Bukkit.getOnlinePlayers().iterator(); iterator.hasNext();)
        {
            Player p = (Player)iterator.next();
            if(COOL.containsKey(p.getName()))
            {
                int CoolTime = ((Integer)COOL.get(p.getName())).intValue();
                CoolTime--;
                COOL.put(p.getName(), Integer.valueOf(CoolTime));
                if(CoolTime == 0)
                    COOL.remove(p.getName());
                else
                if(CoolTime <= 3)
                    MsgUtil.CoolMsg(p, CoolTime);
            }
        }

    }

    public static HashMap COOL = new HashMap();

}
