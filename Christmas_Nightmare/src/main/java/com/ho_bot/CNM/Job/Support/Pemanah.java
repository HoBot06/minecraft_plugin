package com.ho_bot.CNM.Job.Support;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.ProjectileHitEvent;

import com.ho_bot.CNM.Job.Job;
import com.ho_bot.CNM.Tools.GetNearSomeThing;
import com.ho_bot.CNM.Tools.Print_Effect;
import com.ho_bot.CNM.Var.ItemVar;
import com.ho_bot.CNM.Var.JobVar;

public class Pemanah extends Job
{
	private final int coolTime = 30;
    private final int dis = 7;
    private final int heal = 4;
    private final Particle particle = Particle.HEART;
    private static final String des[] = JobVar.Pemanah_Des;

    public Pemanah(String playerName)
    {
        super(playerName, "Æä¸ð³ª", 12, des, ItemVar.PemanahJobItem(Bukkit.getPlayer(playerName))[0], 
        		ItemVar.PemanahJobItem(Bukkit.getPlayer(playerName))[1], ItemVar.PemanahJobItem(Bukkit.getPlayer(playerName))[2], 
        		ItemVar.PemanahJobItem(Bukkit.getPlayer(playerName))[3], ItemVar.PemanahJobItem(Bukkit.getPlayer(playerName))[4]);
        this.cool = coolTime;
    }
    
    @SuppressWarnings("deprecation")
	public void T_Passive(ProjectileHitEvent event)
    {
        if(event.getEntity().getShooter() instanceof Player)
        {
            Player player = (Player)event.getEntity().getShooter();
            if(player.getName().equals(playerName))
            {
                List<Player> NearList = GetNearSomeThing.GetArrowNearTeam(event.getEntity(), player, dis, dis, dis);
                for(Player p : NearList) {
                	p.setHealth(Math.min(p.getMaxHealth(), p.getHealth() + heal));
                    Print_Effect.CircleParticle(particle, event.getEntity().getLocation(), dis, 1, 0.0D, 0.0D, 0.0D, 0.0D);
                }
            }
        }
    }
}
