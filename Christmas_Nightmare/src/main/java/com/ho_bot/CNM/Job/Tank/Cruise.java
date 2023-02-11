package com.ho_bot.CNM.Job.Tank;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

import com.ho_bot.CNM.Main;
import com.ho_bot.CNM.Job.Job;
import com.ho_bot.CNM.Scheduler.Skill.CuriseTimer;
import com.ho_bot.CNM.Tools.EventFilter;
import com.ho_bot.CNM.Tools.GetNearSomeThing;
import com.ho_bot.CNM.Tools.P_Inv;
import com.ho_bot.CNM.Tools.Print_Effect;
import com.ho_bot.CNM.Tools.Skill;
import com.ho_bot.CNM.Tools.Sounds;
import com.ho_bot.CNM.Utility.CoolTimeUtil;
import com.ho_bot.CNM.Var.ItemVar;
import com.ho_bot.CNM.Var.JobVar;

public class Cruise extends Job
{
	private final int coolTime = 30;
    private final int dis = 10;
    private final int duration = 200;
    private final int force_power = 3;
    private final int down_power = -4;
    private final int power = 2;
    private boolean onSkill = false;
    private static final String des[] = JobVar.Cruise_Des;

    public Cruise(String playerName)
    {
        super(playerName, "ũ�罺", 5, des, ItemVar.CruiseJobItem(Bukkit.getPlayer(playerName))[0], 
        		ItemVar.CruiseJobItem(Bukkit.getPlayer(playerName))[1], ItemVar.CruiseJobItem(Bukkit.getPlayer(playerName))[2], 
        		ItemVar.CruiseJobItem(Bukkit.getPlayer(playerName))[3], ItemVar.CruiseJobItem(Bukkit.getPlayer(playerName))[4]);
        this.cool=coolTime;
    }

    public void T_Active(PlayerInteractEvent event)
    {
        Player player = event.getPlayer();
        if(P_Inv.InHandItemCheck(player, ItemVar.CruiseJobItem(Bukkit.getPlayer(playerName))[0].getType()))
            switch(EventFilter.PlayerInteract(event))
            {
            case 2: case 3:
                rightAction(player);
                break;
            }
    }

    private void rightAction(Player player)
    {
        if(CoolTimeUtil.Check(player))
        {
            Skill.Use(player, coolTime);
            Vector vec = new Vector();
            vec = player.getLocation().getDirection();
            vec.multiply(force_power);
            vec.setY(3);
            Sounds.SoundAL(player.getLocation(), Sound.ENTITY_ENDER_DRAGON_FLAP, 1.0f, 2.0f);
            player.setVelocity(vec);
            new BukkitRunnable() {
				@Override
				public void run() {
					onSkill=true;
				}
			}.runTaskLater(Main.getPlugin(Main.class), 10L);
            CuriseTimer CT = new CuriseTimer(player, down_power);
            CT.runTaskLater(Main.getPlugin(Main.class), 30L);
        }
    }

    @SuppressWarnings("deprecation")
	public void T_Passive(PlayerMoveEvent event)
    {
        Player p = event.getPlayer();
        if(p.getName().equals(playerName)) {
        	if(onSkill) {
        		if(p.isOnGround()) {
        			Print_Effect.CircleParticle(Particle.EXPLOSION_LARGE, p.getLocation(), dis, 1, 0.0D, 0.0D, 0.0D, 0.0D);
                    List<Player> NearList = GetNearSomeThing.GetPlayerNearNotTeam(p, dis, dis, dis);
                    if(NearList != null)
                    {
                        for(Player enemy : NearList) {
                        	enemy.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, duration, power));
                        }
                    }
                    Sounds.SoundAL(p.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 0.5f, 1.0f);
                    onSkill = false;
        		}
        	}
        }
    }
}
