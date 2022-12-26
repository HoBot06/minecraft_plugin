// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   GetNearSomeThing.java

package com.ho_bot.CNM.Tools;

import com.ho_bot.CNM.Var.TeamVar;
import java.util.*;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class GetNearSomeThing
{
    public static List<Player> GetPlayerNearPlayer(Player player, double x, double y, double z)
    {
        ArrayList<Player> NearPlayerList = new ArrayList<Player>();
        List<Entity> nearEntity = player.getNearbyEntities(x, y, z);
        if(!nearEntity.isEmpty())
        {
            for(Entity e : nearEntity)
            {
                if(e instanceof Player) {
                	NearPlayerList.add((Player) e);
                }
            }

        }
        return NearPlayerList;
    }

    public static List<Player> GetPlayerNearTeam(Player player, double x, double y, double z)
    {
        String PlayerTeam = TeamVar.Player_Team.get(player.getUniqueId());
        ArrayList<Player> NearPlayerList = new ArrayList<Player>();
        List<Entity> nearEntity = player.getNearbyEntities(x, y, z);
        if(!nearEntity.isEmpty())
        {
            for(Entity e : nearEntity)
            {
                if(e instanceof Player) {
                	if(TeamVar.Player_Team.containsKey(e.getUniqueId())) {
                		if(PlayerTeam.equals(TeamVar.Player_Team.get(e.getUniqueId()))) {
                			NearPlayerList.add((Player) e);
                		}
                	}
                }
            }

        }
        return NearPlayerList;
    }

    public static List<Player> GetPlayerNearNotTeam(Player player, double x, double y, double z)
    {
        String PlayerTeam = (String)TeamVar.Player_Team.get(player.getUniqueId());
        ArrayList<Player> NearPlayerList = new ArrayList<Player>();
        List<Entity> nearEntity = player.getNearbyEntities(x, y, z);
        if(!nearEntity.isEmpty())
        {
            for(Entity e : nearEntity)
            {
                if(e instanceof Player) {
                	if(TeamVar.Player_Team.containsKey(e.getUniqueId())) {
                		if(!PlayerTeam.equals(TeamVar.Player_Team.get(e.getUniqueId()))) {
                			NearPlayerList.add((Player) e);
                		}
                	}
                	else {
                		NearPlayerList.add((Player) e);
                	}
                }
            }

        }
        return NearPlayerList;
    }

    public static List<Player> GetArrowNearTeam(Entity arrow, Player player, double x, double y, double z)
    {
        String PlayerTeam = (String)TeamVar.Player_Team.get(player.getUniqueId());
        ArrayList<Player> NearPlayerList = new ArrayList<Player>();
        List<Entity> nearEntity = arrow.getNearbyEntities(x, y, z);
        if(!nearEntity.isEmpty())
        {
            for(Entity e : nearEntity)
            {
                if(e instanceof Player) {
                	if(TeamVar.Player_Team.containsKey(e.getUniqueId())) {
                		if(PlayerTeam.equals(TeamVar.Player_Team.get(e.getUniqueId()))) {
                			NearPlayerList.add((Player) e);
                		}
                	}
                }
            }

        }
        return NearPlayerList;
    }
}
