package com.ho_bot.CNM.Utility;

import java.util.UUID;

import org.bukkit.entity.Player;

import com.ho_bot.CNM.Scheduler.CoolTime_Scheduler;
import com.ho_bot.CNM.Var.JobVar;

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
	
	public static boolean ShootCheck(Player p)
    {
        UUID pkey = p.getUniqueId();
        if(JobVar.ShootDelay_Player.containsKey(pkey))
        {
            return false;
        }
        return true;
    }
}
