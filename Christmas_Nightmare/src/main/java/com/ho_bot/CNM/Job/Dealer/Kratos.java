package com.ho_bot.CNM.Job.Dealer;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.ho_bot.CNM.Main;
import com.ho_bot.CNM.Job.Job;
import com.ho_bot.CNM.Scheduler.Skill.KratosTimer;
import com.ho_bot.CNM.Tools.EventFilter;
import com.ho_bot.CNM.Tools.P_Inv;
import com.ho_bot.CNM.Tools.Skill;
import com.ho_bot.CNM.Utility.CoolTimeUtil;
import com.ho_bot.CNM.Var.ItemVar;
import com.ho_bot.CNM.Var.JobVar;

public class Kratos extends Job
{
	private final int coolTime = 10;
	private final int duration = 60;
    private static final String des[] = JobVar.Kratos_Des;

    public Kratos(String playerName)
    {
        super(playerName, "크라토스", 9, des, ItemVar.KratosJobItem(Bukkit.getPlayer(playerName))[0],
        		ItemVar.KratosJobItem(Bukkit.getPlayer(playerName))[1], ItemVar.KratosJobItem(Bukkit.getPlayer(playerName))[2],
        		ItemVar.KratosJobItem(Bukkit.getPlayer(playerName))[3], ItemVar.KratosJobItem(Bukkit.getPlayer(playerName))[4]);
    }

    public void T_Active(PlayerInteractEvent event)
    {
        Player player = event.getPlayer();
        if(P_Inv.InHandItemCheck(player, ItemVar.FasterJobItem(Bukkit.getPlayer(playerName))[0].getType()))
            switch(EventFilter.PlayerInteract(event))
            {
            case 2: case 3:
                rightAction(player);
                break;
            }
    }

    @SuppressWarnings("deprecation")
	private void rightAction(Player player)
    {
        if(CoolTimeUtil.Check(player))
        {
            Skill.Use(player, coolTime);
            JobVar.Kratos_P.put(player.getUniqueId(), true);
            player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, duration, 1, false, false), true);
            player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, duration, 1, false, false), true);
            player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, duration, 1, false, false), true);
            KratosTimer KT = new KratosTimer(player, coolTime);
            KT.runTaskTimer(Main.getPlugin(Main.class), 0L, 20L);
        }
    }
}
