package com.ho_bot.CNM.Tools;

import org.bukkit.entity.Player;

import com.ho_bot.CNM.Scheduler.CoolTime_Scheduler;
import com.ho_bot.CNM.Utility.MsgUtil;

public class Skill
{
    public static void Use(Player player, int coolTime)
    {
        if(coolTime > 0)
        {
            CoolTime_Scheduler.COOL.put(player.getName(), Integer.valueOf(coolTime));
        }
        MsgUtil.SkillUse(player);
    }
}
