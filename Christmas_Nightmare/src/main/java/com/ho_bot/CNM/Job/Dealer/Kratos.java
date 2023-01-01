package com.ho_bot.CNM.Job.Dealer;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import com.ho_bot.CNM.Main;
import com.ho_bot.CNM.Job.Job;
import com.ho_bot.CNM.Scheduler.Skill.KratosTimer;
import com.ho_bot.CNM.Scheduler.Skill.KratosTimerTwo;
import com.ho_bot.CNM.Tools.EventFilter;
import com.ho_bot.CNM.Tools.P_Inv;
import com.ho_bot.CNM.Tools.Skill;
import com.ho_bot.CNM.Utility.CoolTimeUtil;
import com.ho_bot.CNM.Var.ItemVar;
import com.ho_bot.CNM.Var.JobVar;

public class Kratos extends Job
{
	private final int coolTime = 30;
    private static final String des[] = JobVar.Kratos_Des;

    public Kratos(String playerName)
    {
        super(playerName, "크라토스", 9, des, ItemVar.KratosJobItem(Bukkit.getPlayer(playerName))[0],
        		ItemVar.KratosJobItem(Bukkit.getPlayer(playerName))[1], ItemVar.KratosJobItem(Bukkit.getPlayer(playerName))[2],
        		ItemVar.KratosJobItem(Bukkit.getPlayer(playerName))[3], ItemVar.KratosJobItem(Bukkit.getPlayer(playerName))[4]);
        this.cool=coolTime;
    }

    public void T_Active(PlayerInteractEvent event)
    {
        Player player = event.getPlayer();
        if(P_Inv.InHandItemCheck(player, Material.BLAZE_ROD))
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
            JobVar.Kratos_P.put(player.getUniqueId(), Boolean.valueOf(true));
            KratosTimerTwo KTT = new KratosTimerTwo(10, player);
            KTT.runTaskTimer(Main.getPlugin(Main.class), 0L, 20L);
        }
    }

    public void T_Passive(EntityDamageByEntityEvent event)
    {
        if(event.getDamager() instanceof Player)
        {
            Player atp = (Player)event.getDamager();
            if(atp.getName().equals(playerName)) {
            	if(JobVar.Kratos_P.containsKey(atp.getUniqueId())) {
            		if(JobVar.Kratos_P.get(atp.getUniqueId())) {
            			KratosTimer KT = new KratosTimer((Player)event.getEntity(), atp, event.getDamage() / 2D);
                        KT.runTaskLater(Main.getPlugin(Main.class), 10L);
                        atp.sendMessage("더블어택!");
            		}
            	}
            }
        }
    }
}
