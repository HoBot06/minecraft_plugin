package com.ho_bot.CNM.Job.Tank;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.ho_bot.CNM.Job.Job;
import com.ho_bot.CNM.Tools.EventFilter;
import com.ho_bot.CNM.Tools.GetNearSomeThing;
import com.ho_bot.CNM.Tools.P_Inv;
import com.ho_bot.CNM.Tools.Skill;
import com.ho_bot.CNM.Utility.CoolTimeUtil;
import com.ho_bot.CNM.Var.ItemVar;
import com.ho_bot.CNM.Var.JobVar;

public class Egis extends Job
{
	private final int coolTime = 30;
    private final int dis = 30;
    private final int duration = 600;
    private final int power = 2;
    private static final String des[] = JobVar.Egis_Des;

    public Egis(String playerName)
    {
        super(playerName, "¿¡±â½º", 3, des, ItemVar.EgisJobItem(Bukkit.getPlayer(playerName))[0], 
        		ItemVar.EgisJobItem(Bukkit.getPlayer(playerName))[1], ItemVar.EgisJobItem(Bukkit.getPlayer(playerName))[2], 
        		ItemVar.EgisJobItem(Bukkit.getPlayer(playerName))[3], ItemVar.EgisJobItem(Bukkit.getPlayer(playerName))[4]);
        this.cool=coolTime;
    }

    public void T_Active(PlayerInteractEvent event)
    {
        Player player = event.getPlayer();
        if(P_Inv.InHandItemCheck(player, ItemVar.EgisJobItem(Bukkit.getPlayer(playerName))[0].getType()))
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
            List<Player> NearList = GetNearSomeThing.GetPlayerNearTeam(player, dis, dis, dis);
            for(Player p : NearList) {
            	p.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, duration, power), true);
            }
            player.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, duration, power), true);
        }
    }
}
