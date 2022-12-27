package com.ho_bot.CNM.Scheduler.Skill;

import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import com.ho_bot.CNM.Tools.GetNearSomeThing;
import com.ho_bot.CNM.Tools.Print_Effect;
import com.ho_bot.CNM.Var.JobVar;

public class ZoukTimer extends BukkitRunnable
{
	private Player player;
    private int duration;

    public ZoukTimer(Player player, int duration)
    {
        this.player = player;
        this.duration = duration;
    }

    public void run()
    {
        if(duration <= 0)
        {
            JobVar.Zouk_P.remove(player.getUniqueId());
            player.sendMessage("능력이 종료되었습니다");
            cancel();
        }
        else if(duration <= 5) {
            player.sendMessage("능력 종료까지 : " + duration + "초");
        }
        duration--;
    }

    @SuppressWarnings("deprecation")
	public static void ZoukSkill(Player player)
    {
        List<Player> NearList = GetNearSomeThing.GetPlayerNearTeam(player, 8, 8, 8);
        Print_Effect.CircleParticle(JobVar.Zouk_Particle, player.getLocation(), 8, 1, 0, 0, 0, 0);
        for(Player p : NearList)
        {
            p.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 20, 0), true);
            p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 20, 0), true);
            if(JobVar.Zouk_P.containsKey(player.getUniqueId())) {
            	if(JobVar.Zouk_P.get(player.getUniqueId())) {
            		p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 20, 0), true);
                    p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 20, 0), true);
            	}
            }
        }

    }
}
