// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   DamageUtil.java

package com.ho_bot.CNM.Utility;

import com.ho_bot.CNM.Var.TeamVar;
import java.util.HashMap;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class DamageUtil
{

    public DamageUtil()
    {
    }

    public static void PlayerDamageEntity(EntityDamageByEntityEvent event)
    {
        if((event.getEntity() instanceof Player) && (event.getDamager() instanceof Player))
        {
            Player victim = (Player)event.getEntity();
            Player attacker = (Player)event.getDamager();
            if(TeamVar.Player_Team.containsKey(victim.getUniqueId()) && TeamVar.Player_Team.containsKey(attacker.getUniqueId()) && ((String)TeamVar.Player_Team.get(victim.getUniqueId())).equals(TeamVar.Player_Team.get(attacker.getUniqueId())))
                event.setCancelled(true);
        }
    }
}
