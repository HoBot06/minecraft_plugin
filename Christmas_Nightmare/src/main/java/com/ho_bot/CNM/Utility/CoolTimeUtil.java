package com.ho_bot.CNM.Utility;

import org.bukkit.entity.Player;

import com.ho_bot.CNM.Scheduler.CoolTime_Scheduler;

public class CoolTimeUtil
{
	public static boolean Check(Player p)
    {
        String key = p.getName();
        if(CoolTime_Scheduler.COOL.containsKey(key))
        {
            int cool = CoolTime_Scheduler.COOL.get(key);
            MsgUtil.CoolMsg(p, cool);
            return false;
        }
        return true;
    }
}
