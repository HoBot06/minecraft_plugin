package com.ho_bot.CNM.Scheduler.Skill;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import com.ho_bot.CNM.Main;
import com.ho_bot.CNM.Tools.GetNearSomeThing;
import com.ho_bot.CNM.Tools.Print_Effect;
import com.ho_bot.CNM.Tools.Sounds;
import com.ho_bot.CNM.Var.JobVar;

public class ZoukTimer extends BukkitRunnable
{
	private Player player;
    private int duration;
    private static boolean isPar = true;

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
        Sounds.SoundAL(player.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 0.2f, 1.5f);
        duration--;
    }

    @SuppressWarnings("deprecation")
	public static void ZoukSkill(Player player)
    {
        List<Player> NearList = GetNearSomeThing.GetPlayerNearTeam(player, 8, 8, 8);
        if(isPar) {
        	Print_Effect.CircleParticle(Particle.NOTE, player.getLocation(), 8, 1, 0, 0, 0, 0);
        	isPar = false;
        	Bukkit.getScheduler().runTaskLater(Main.getPlugin(Main.class), () -> {
            	isPar = true;
            	
            }, 20);
        }
        for(Player p : NearList)
        {
            p.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 20, 0), true);
            p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 20, 0), true);
            if(JobVar.Zouk_P.containsKey(player.getUniqueId())) {
            	if(JobVar.Zouk_P.get(player.getUniqueId())) {
            		p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 20, 2), true);
                    p.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 20, 2), true);
            	}
            }
        }

    }
}
