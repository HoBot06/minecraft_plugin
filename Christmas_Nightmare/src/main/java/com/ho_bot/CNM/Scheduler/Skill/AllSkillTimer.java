package com.ho_bot.CNM.Scheduler.Skill;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import com.ho_bot.CNM.Job.Job;
import com.ho_bot.CNM.Var.JobVar;

public class AllSkillTimer extends BukkitRunnable
{
	public void run()
    {
        for(Player p : Bukkit.getOnlinePlayers())
        {
            Job job = JobVar.Job_Player.get(p.getUniqueId());
            if(job != null) {
            	if(job.abilityCode == 10) {
            		ZoukTimer.ZoukSkill(p);
            	}
            }
            if(JobVar.ShootDelay_Player.containsKey(p.getUniqueId())) {
            	int cool = JobVar.ShootDelay_Player.get(p.getUniqueId());
            	cool--;
            	if(cool<0) {
            		JobVar.ShootDelay_Player.remove(p.getUniqueId());
            	}
            	else {
            		JobVar.ShootDelay_Player.put(p.getUniqueId(), cool);
            	}
            }
        }
    }
}
