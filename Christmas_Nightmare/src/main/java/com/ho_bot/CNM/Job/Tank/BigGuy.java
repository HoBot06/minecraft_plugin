package com.ho_bot.CNM.Job.Tank;

import org.bukkit.Bukkit;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import com.ho_bot.CNM.Main;
import com.ho_bot.CNM.Job.Job;
import com.ho_bot.CNM.Scheduler.Skill.BigGuyParticleTimer;
import com.ho_bot.CNM.Scheduler.Skill.BigGuyTimer;
import com.ho_bot.CNM.Tools.EventFilter;
import com.ho_bot.CNM.Tools.P_Inv;
import com.ho_bot.CNM.Tools.Skill;
import com.ho_bot.CNM.Utility.CoolTimeUtil;
import com.ho_bot.CNM.Var.ItemVar;
import com.ho_bot.CNM.Var.JobVar;

public class BigGuy extends Job
{
	private final int coolTime = 10;
    private final int duration = 5;
    private final Particle particle = Particle.CRIT;
    private static final String des[] = JobVar.BigGuy_Des;

    public BigGuy(String playerName)
    {
        super(playerName, "∫Ú∞°¿Ã", 2, des, ItemVar.BigGuyJobItem(Bukkit.getPlayer(playerName))[0], 
        		ItemVar.BigGuyJobItem(Bukkit.getPlayer(playerName))[1], ItemVar.BigGuyJobItem(Bukkit.getPlayer(playerName))[2], 
        		ItemVar.BigGuyJobItem(Bukkit.getPlayer(playerName))[3], ItemVar.BigGuyJobItem(Bukkit.getPlayer(playerName))[4]);
        this.cool=coolTime;
    }

    public void T_Active(PlayerInteractEvent event)
    {
        Player player = event.getPlayer();
        if(P_Inv.InHandItemCheck(player, ItemVar.BigGuyJobItem(Bukkit.getPlayer(playerName))[0].getType()))
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
            JobVar.BigGuy_P.put(player.getUniqueId(), true);
            BigGuyTimer BGT = new BigGuyTimer(player, duration);
            BGT.runTaskTimer(Main.getPlugin(Main.class), 0L, 20L);
            BigGuyParticleTimer BGPT = new BigGuyParticleTimer(player, 20, particle);
            BGPT.runTaskTimer(Main.getPlugin(Main.class), 0L, 5L);
        }
    }

    public void T_Passive(EntityDamageByEntityEvent event)
    {
        if(event.getEntity() instanceof Player)
        {
            Player p = (Player)event.getEntity();
            if(p.getName().equals(playerName)) {
            	if(JobVar.BigGuy_P.containsKey(p.getUniqueId())) {
            		if(JobVar.BigGuy_P.get(p.getUniqueId())) {
            			event.setDamage(event.getDamage() / 2D);
            		}
            	}
            } 
        }
    }
}
