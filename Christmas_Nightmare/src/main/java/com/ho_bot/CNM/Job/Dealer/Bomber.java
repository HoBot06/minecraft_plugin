package com.ho_bot.CNM.Job.Dealer;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import com.ho_bot.CNM.Main;
import com.ho_bot.CNM.Job.Job;
import com.ho_bot.CNM.Scheduler.Skill.BomberTimer;
import com.ho_bot.CNM.Tools.EventFilter;
import com.ho_bot.CNM.Tools.P_Inv;
import com.ho_bot.CNM.Tools.Skill;
import com.ho_bot.CNM.Utility.CoolTimeUtil;
import com.ho_bot.CNM.Utility.ShootUtility;
import com.ho_bot.CNM.Var.ItemVar;
import com.ho_bot.CNM.Var.JobVar;

public class Bomber extends Job
{
	private final int coolTime = 30;
    private final int duration = 20;
    private final int power = 2;
    private static final String des[] = JobVar.Bomber_Des;

    public Bomber(String playerName)
    {
        super(playerName, "º½¹ö", 8, des, ItemVar.BomberJobItem(Bukkit.getPlayer(playerName))[0], 
        		ItemVar.BomberJobItem(Bukkit.getPlayer(playerName))[1], ItemVar.BomberJobItem(Bukkit.getPlayer(playerName))[2],
        		ItemVar.BomberJobItem(Bukkit.getPlayer(playerName))[3], ItemVar.BomberJobItem(Bukkit.getPlayer(playerName))[4]);
        this.cool=coolTime;
    }

    public void T_Active(PlayerInteractEvent event)
    {
        Player player = event.getPlayer();
        if(P_Inv.InHandItemCheck(player, Material.BLAZE_ROD))
            switch(EventFilter.PlayerInteract(event))
            {
            case 0: case 1:
                leftAction(player);
                break;

            case 2: case 3:
                rightAction(player);
                break;
            }
    }

    private void leftAction(Player player)
    {
        if(JobVar.Bomber_P.containsKey(player.getUniqueId()))
        {
            if(JobVar.Bomber_P.get(player.getUniqueId())) {
                ShootUtility.SnowShoot(player, player.getLocation().getDirection(), 1.2f);
            }
        } else
        {
            ShootUtility.LineShoot(player, Particle.END_ROD, 30, 1.0F, 2D, 0.0D, 0.0D, 0.0D, 0.0D, 1, Sound.BLOCK_PISTON_CONTRACT, 1.0F, 1.0F);
        }
    }

    private void rightAction(Player player)
    {
        if(CoolTimeUtil.Check(player))
        {
            Skill.Use(player, coolTime);
            JobVar.Bomber_P.put(player.getUniqueId(), true);
            BomberTimer BT = new BomberTimer(player, duration);
            BT.runTaskTimer(Main.getPlugin(Main.class), 0L, 20L);
        }
    }

    public void T_Passive(ProjectileHitEvent event)
    {
        if(event.getEntity().getShooter() instanceof Player)
        {
            Player player = (Player)event.getEntity().getShooter();
            if(player.getName().equals(playerName)) {
            	if(JobVar.Bomber_P.containsKey(player.getUniqueId())) {
            		if(JobVar.Bomber_P.get(player.getUniqueId())) {
            			event.getEntity().getWorld().createExplosion(event.getEntity().getLocation(), power, false, false, player);
            		}
            	}
            }
        }
    }
}
