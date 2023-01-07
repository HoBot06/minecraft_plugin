package com.ho_bot.CNM.Tools;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import com.ho_bot.CNM.Var.TeamVar;

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
        ArrayList<Player> NearPlayerList = new ArrayList<Player>();
        List<Entity> nearEntity = player.getNearbyEntities(x, y, z);
        if(!nearEntity.isEmpty())
        {
            for(Entity e : nearEntity)
            {
                if(e instanceof Player) {
                	if(TeamVar.Player_Team.containsKey(e.getUniqueId()) && TeamVar.Player_Team.containsKey(player.getUniqueId())) {
                		if(TeamVar.Player_Team.get(player.getUniqueId()).equals(TeamVar.Player_Team.get(e.getUniqueId()))) {
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
