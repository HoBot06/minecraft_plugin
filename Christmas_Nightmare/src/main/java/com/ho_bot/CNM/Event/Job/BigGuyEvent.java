package com.ho_bot.CNM.Event.Job;

import java.util.List;
import java.util.Map.Entry;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import com.ho_bot.CNM.Tools.GetNearSomeThing;
import com.ho_bot.CNM.Var.JobVar;

public class BigGuyEvent
{
    public static void onDamage(EntityDamageByEntityEvent event)
    {
        if(event.getEntity() instanceof Player)
        {
            Player player = (Player)event.getEntity();
            List<Player> NearList = GetNearSomeThing.GetPlayerNearTeam(player, 12D, 12D, 12D);
            for(Entry<UUID, Boolean> p : JobVar.BigGuy_P.entrySet())
            {
                Player bigp = Bukkit.getPlayer(p.getKey());
                if(NearList.contains(bigp) && p.getValue())
                {
                    event.setDamage((event.getDamage() / 10D) * 8D);
                    bigp.damage(event.getDamage() / 10D);
                }
            }

        }
    }
}
