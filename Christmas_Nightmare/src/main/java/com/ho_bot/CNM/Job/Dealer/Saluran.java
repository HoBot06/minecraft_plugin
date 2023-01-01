package com.ho_bot.CNM.Job.Dealer;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

import com.ho_bot.CNM.Job.Job;
import com.ho_bot.CNM.Tools.EventFilter;
import com.ho_bot.CNM.Tools.P_Inv;
import com.ho_bot.CNM.Tools.Skill;
import com.ho_bot.CNM.Utility.CoolTimeUtil;
import com.ho_bot.CNM.Utility.ShootUtility;
import com.ho_bot.CNM.Var.ItemVar;
import com.ho_bot.CNM.Var.JobVar;

public class Saluran extends Job
{
	private int coolTime = 1;
    private static final String des[] = JobVar.Saluran_Des;

    public Saluran(String playerName)
    {
        super(playerName, "»ì·ç¶õ", 6, des, ItemVar.SaluranJobItem(Bukkit.getPlayer(playerName))[0], 
        		ItemVar.SaluranJobItem(Bukkit.getPlayer(playerName))[1], ItemVar.SaluranJobItem(Bukkit.getPlayer(playerName))[2], 
        		ItemVar.SaluranJobItem(Bukkit.getPlayer(playerName))[3], ItemVar.SaluranJobItem(Bukkit.getPlayer(playerName))[4]);
        
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
            }
    }

    private void leftAction(Player player)
    {
        if(CoolTimeUtil.Check(player))
        {
            Skill.Use(player, coolTime);
            ShootUtility.LineShoot(player, Particle.CRIT, 30, 1.0F, 4D, 0.0D, 0.0D, 0.0D, 0.0D, 1, Sound.ITEM_CROSSBOW_SHOOT, 1.0F, 1.0F);
        }
    }
}
