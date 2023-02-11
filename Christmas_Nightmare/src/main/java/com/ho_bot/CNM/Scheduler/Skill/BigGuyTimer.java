package com.ho_bot.CNM.Scheduler.Skill;

import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import com.ho_bot.CNM.Tools.Sounds;
import com.ho_bot.CNM.Var.JobVar;

public class BigGuyTimer extends BukkitRunnable
{
	private Player player;
    private int duration;

    public BigGuyTimer(Player player, int duration)
    {
        this.player = player;
        this.duration = duration;
    }

    public void run()
    {
        if(duration <= 0)
        {
            JobVar.BigGuy_P.remove(player.getUniqueId());
            player.sendMessage("능력이 종료되었습니다");
            this.cancel();
        }
        else if(duration <= 5) {
            player.sendMessage("능력 종료까지 : " + duration + "초");
        }
        Sounds.SoundAL(player.getLocation(), Sound.BLOCK_ANVIL_LAND, 1.0f, 1.0f);
        duration--;
    }
}
