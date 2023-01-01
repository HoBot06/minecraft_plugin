package com.ho_bot.CNM.Job.Support;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import com.ho_bot.CNM.Job.Job;
import com.ho_bot.CNM.Tools.GetNearSomeThing;
import com.ho_bot.CNM.Tools.Print_Effect;
import com.ho_bot.CNM.Var.ItemVar;
import com.ho_bot.CNM.Var.JobVar;

public class Paladin extends Job
{
	private final int coolTime = 30;
    private final int dis = 5;
    private final double heal = 2D;
    private static final String des[] = JobVar.Paladin_Des;

    public Paladin(String playerName)
    {
        super(playerName, "ÆÈ¶óµò", 11, des, ItemVar.PaladinJobItem(Bukkit.getPlayer(playerName))[0], 
        		ItemVar.PaladinJobItem(Bukkit.getPlayer(playerName))[1], ItemVar.PaladinJobItem(Bukkit.getPlayer(playerName))[2], 
        		ItemVar.PaladinJobItem(Bukkit.getPlayer(playerName))[3], ItemVar.PaladinJobItem(Bukkit.getPlayer(playerName))[4]);
        this.cool=coolTime;
    }

    @SuppressWarnings("deprecation")
	public void T_Passive(EntityDamageByEntityEvent event)
    {
        if(event.getDamager() instanceof Player)
        {
            Player atp = (Player)event.getDamager();
            if(atp.getName().equals(playerName))
            {
                List<Player> NearList = GetNearSomeThing.GetPlayerNearTeam(atp, dis, dis, dis);
                Print_Effect.CircleParticle(Particle.HEART, atp.getLocation(), dis, 1, 0.0D, 0.0D, 0.0D, 0.0D);
                for(Player p : NearList) {
                	p.setHealth(Math.min(p.getMaxHealth(), p.getHealth() + heal));
                }
            }
        }
    }
}
