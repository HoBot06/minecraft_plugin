package com.ho_bot.CNM.Scheduler.Skill;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import com.ho_bot.CNM.Var.JobVar;

public class KratosTimerTwo extends BukkitRunnable
{
	private Player player;
    private int duration;

    public KratosTimerTwo(int duration, Player player)
    {
        this.duration = duration;
        this.player = player;
    }

    public void run()
    {
        if(duration <= 0)
        {
            JobVar.Kratos_P.remove(player.getUniqueId());
            player.sendMessage("능력이 종료되었습니다");
            this.cancel();
        }
        else if(duration <= 5) {
            player.sendMessage("능력 종료까지 : " + duration + "초");
        }
        duration--;
    }
}
