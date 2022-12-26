// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Skill.java

package com.ho_bot.CNM.Tools;

import com.ho_bot.CNM.Scheduler.CoolTime_Scheduler;
import com.ho_bot.CNM.Utility.MsgUtil;
import java.util.HashMap;
import org.bukkit.entity.Player;

public class Skill
{

    public Skill()
    {
    }

    public static void Use(Player player, int coolTime)
    {
        if(coolTime > 0)
        {
            CoolTime_Scheduler.COOL.put(player.getName(), Integer.valueOf(coolTime));
            MsgUtil.SkillUse(player);
        }
        MsgUtil.SkillUse(player);
    }
}
