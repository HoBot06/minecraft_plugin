package com.ho_bot.CNM.Scheduler;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import com.ho_bot.CNM.Utility.MsgUtil;

public class CoolTime_Scheduler extends BukkitRunnable
{
	public static HashMap<String, Integer> COOL = new HashMap<String, Integer>();
	
	public void run()
    {
        for(Player p : Bukkit.getOnlinePlayers())
        {
            if(COOL.containsKey(p.getName()))
            {
                int CoolTime = COOL.get(p.getName());
                CoolTime--;
                COOL.put(p.getName(), CoolTime);
                if(CoolTime == 0) {
                    COOL.remove(p.getName());
                }
                else if(CoolTime <= 3) {
                    MsgUtil.CoolMsg(p, CoolTime);
                }
            }
        }

    }
}
