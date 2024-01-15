package com.ho_bot.CNM.Job.Tank;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

import com.ho_bot.CNM.Job.Job;
import com.ho_bot.CNM.Tools.EventFilter;
import com.ho_bot.CNM.Tools.GetNearSomeThing;
import com.ho_bot.CNM.Tools.P_Inv;
import com.ho_bot.CNM.Tools.Skill;
import com.ho_bot.CNM.Tools.Vector_Cal;
import com.ho_bot.CNM.Utility.CoolTimeUtil;
import com.ho_bot.CNM.Var.ItemVar;
import com.ho_bot.CNM.Var.JobVar;

public class Patai extends Job
{
	private final int coolTime = 40;
    private final int dis = 15;
    private final int duration = 600;
    private final int grab_power = 3;
    private final int power = 2;
    private static final String des[] = JobVar.Patai_Des;

    public Patai(String playerName)
    {
        super(playerName, "ÆÄÅ¸ÀÌ", 4, des, ItemVar.PataiJobItem(Bukkit.getPlayer(playerName))[0], 
        		ItemVar.PataiJobItem(Bukkit.getPlayer(playerName))[1], ItemVar.PataiJobItem(Bukkit.getPlayer(playerName))[2], 
        		ItemVar.PataiJobItem(Bukkit.getPlayer(playerName))[3], ItemVar.PataiJobItem(Bukkit.getPlayer(playerName))[4]);
        this.cool=coolTime;
    }

    public void T_Active(PlayerInteractEvent event)
    {
        Player player = event.getPlayer();
        if(P_Inv.InHandItemCheck(player, ItemVar.PataiJobItem(Bukkit.getPlayer(playerName))[0].getType()))
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
            List<Player> NearNotTeamList = GetNearSomeThing.GetPlayerNearNotTeam(player, dis, dis, dis);
            for(Player p : NearNotTeamList) {
            	Vector vec = new Vector();
            	vec = Vector_Cal.PlayerGrabVec(player.getLocation(), p.getLocation());
            	vec.setY(2);
            	vec.multiply(grab_power);
            }
            if(NearNotTeamList != null) {
                player.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, duration, power * NearNotTeamList.size(), false, false), true);
            }
        }
    }
}
