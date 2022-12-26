// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   AllSkillTimer.java

package com.ho_bot.CNM.Scheduler.Skill;

import com.ho_bot.CNM.Job.Job;
import com.ho_bot.CNM.Var.JobVar;
import java.util.*;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

// Referenced classes of package com.ho_bot.CNM.Scheduler.Skill:
//            ZoukTimer

public class AllSkillTimer extends BukkitRunnable
{

    public AllSkillTimer()
    {
    }

    public void run()
    {
        for(Iterator iterator = Bukkit.getOnlinePlayers().iterator(); iterator.hasNext();)
        {
            Player p = (Player)iterator.next();
            Job job = (Job)JobVar.Job_Player.get(p.getUniqueId());
            if(job != null && job.abilityCode == 10)
                ZoukTimer.ZoukSkill(p);
        }

    }
}
