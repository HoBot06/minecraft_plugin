package com.ho_bot.CNM.Scheduler.Skill;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import com.ho_bot.CNM.Var.JobVar;

public class BomberTimer extends BukkitRunnable
{
	private Player player;
    private int duration;

    public BomberTimer(Player player, int duration)
    {
        this.player = player;
        this.duration = duration;
    }

    public void run()
    {
        if(duration <= 0)
        {
            JobVar.Bomber_P.remove(player.getUniqueId());
            player.sendMessage("�ɷ��� ����Ǿ����ϴ�");
            this.cancel();
        }
        else if(duration <= 5) {
            player.sendMessage("�ɷ� ������� : " + duration + "��");
        }
        duration--;
    }
}
