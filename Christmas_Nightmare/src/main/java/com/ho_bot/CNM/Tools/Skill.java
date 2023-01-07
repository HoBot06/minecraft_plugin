package com.ho_bot.CNM.Tools;

import org.bukkit.entity.Player;

import com.ho_bot.CNM.Scheduler.CoolTime_Scheduler;
import com.ho_bot.CNM.Utility.MsgUtil;
import com.ho_bot.CNM.Var.JobVar;

public class Skill
{
    public static void Use(Player player, int coolTime)
    {
        if(coolTime > 0)
        {
            CoolTime_Scheduler.COOL.put(player.getName(), coolTime);
        }
        MsgUtil.SkillUse(player);
    }
    
    public static void Shoot(Player player, int coolTime)
    {
        if(coolTime > 0)
        {
            JobVar.ShootDelay_Player.put(player.getUniqueId(), coolTime);
        }
    }
}
