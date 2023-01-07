package com.ho_bot.CNM.Job.Support;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

import com.ho_bot.CNM.Main;
import com.ho_bot.CNM.Job.Job;
import com.ho_bot.CNM.Scheduler.Skill.ZoukTimer;
import com.ho_bot.CNM.Tools.EventFilter;
import com.ho_bot.CNM.Tools.P_Inv;
import com.ho_bot.CNM.Tools.Skill;
import com.ho_bot.CNM.Utility.CoolTimeUtil;
import com.ho_bot.CNM.Var.ItemVar;
import com.ho_bot.CNM.Var.JobVar;

public class Zouk extends Job
{
	private final int coolTime = 10;
    private final int duration = 5;
    private static final String des[] = JobVar.Zouk_Des;

    public Zouk(String playerName)
    {
        super(playerName, "аже╘", 10, des, ItemVar.ZoukJobItem(Bukkit.getPlayer(playerName))[0], 
        		ItemVar.ZoukJobItem(Bukkit.getPlayer(playerName))[1], ItemVar.ZoukJobItem(Bukkit.getPlayer(playerName))[2], 
        		ItemVar.ZoukJobItem(Bukkit.getPlayer(playerName))[3], ItemVar.ZoukJobItem(Bukkit.getPlayer(playerName))[4]);
        
        this.cool=coolTime;
    }

    public void T_Active(PlayerInteractEvent event)
    {
        Player player = event.getPlayer();
        if(P_Inv.InHandItemCheck(player, ItemVar.ZoukJobItem(Bukkit.getPlayer(playerName))[0].getType()))
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
            JobVar.Zouk_P.put(player.getUniqueId(), Boolean.valueOf(true));
            ZoukTimer ZT = new ZoukTimer(player, duration);
            ZT.runTaskTimer(Main.getPlugin(Main.class), 0L, 20L);
        }
    }
}
