package com.ho_bot.CNM.Job.Dealer;

import org.bukkit.Bukkit;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;

import com.ho_bot.CNM.Job.Job;
import com.ho_bot.CNM.Tools.EventFilter;
import com.ho_bot.CNM.Tools.P_Inv;
import com.ho_bot.CNM.Tools.Skill;
import com.ho_bot.CNM.Utility.CoolTimeUtil;
import com.ho_bot.CNM.Utility.ShootUtility;
import com.ho_bot.CNM.Var.ItemVar;
import com.ho_bot.CNM.Var.JobVar;

public class Faster extends Job
{
	private final int Shoot_Delay = 20;
	private final int coolTime = 5;
    private final int power = 5;
    private static final String des[] = JobVar.Faster_Des;

    public Faster(String playerName)
    {
        super(playerName, "�佺Ʈ", 7, des, ItemVar.FasterJobItem(Bukkit.getPlayer(playerName))[0], 
        		ItemVar.FasterJobItem(Bukkit.getPlayer(playerName))[1], ItemVar.FasterJobItem(Bukkit.getPlayer(playerName))[2], 
        		ItemVar.FasterJobItem(Bukkit.getPlayer(playerName))[3], ItemVar.FasterJobItem(Bukkit.getPlayer(playerName))[4]);
        this.cool=coolTime;
    }

    public void T_Active(PlayerInteractEvent event)
    {
        Player player = event.getPlayer();
        if(P_Inv.InHandItemCheck(player, ItemVar.FasterJobItem(Bukkit.getPlayer(playerName))[0].getType()))
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
    	if(CoolTimeUtil.ShootCheck(player)) {
    		Skill.Shoot(player, Shoot_Delay);
    		ShootUtility.ShootGunSpreadShoot(player, Particle.CRIT, 30, 1.0F, 4D, 0.0D, 0.0D, 0.0D, 0.0D, 1, Sound.ENTITY_GENERIC_EXPLODE, 1.0F, 1.0F, 10, 10);
    	}
    }

    private void rightAction(Player player)
    {
        if(CoolTimeUtil.Check(player))
        {
            Skill.Use(player, coolTime);
            Vector vec = player.getLocation().getDirection();
            vec.setY(0);
            player.setVelocity(vec.multiply(power));
        }
    }
}
