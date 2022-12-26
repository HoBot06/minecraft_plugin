// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   CoolTimeUtil.java

package com.ho_bot.CNM.Utility;

import com.ho_bot.CNM.Scheduler.CoolTime_Scheduler;
import java.util.HashMap;
import org.bukkit.entity.Player;

// Referenced classes of package com.ho_bot.CNM.Utility:
//            MsgUtil

public class CoolTimeUtil
{

    public CoolTimeUtil()
    {
    }

    public static boolean Check(Player p)
    {
        String key = p.getName();
        if(CoolTime_Scheduler.COOL.containsKey(key))
        {
            int cool = ((Integer)CoolTime_Scheduler.COOL.get(key)).intValue();
            MsgUtil.CoolMsg(p, cool);
            return false;
        } else
        {
            return true;
        }
    }
}
