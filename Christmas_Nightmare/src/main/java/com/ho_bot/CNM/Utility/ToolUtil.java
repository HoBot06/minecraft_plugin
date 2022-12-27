package com.ho_bot.CNM.Utility;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;

import com.ho_bot.CNM.Main;
import com.ho_bot.CNM.Var.WordVar;

public class ToolUtil
{

	public boolean CheckInLocation(Location PlayerLoc, Location Loc1, Location Loc2)
    {
        Boolean IsIn = false;
        if(Math.max(Loc1.getX(), Loc2.getX()) >= PlayerLoc.getX() && PlayerLoc.getX() >= Math.min(Loc1.getX(), Loc2.getX()) && 
        		Math.max(Loc1.getY(), Loc2.getY()) >= PlayerLoc.getY() && PlayerLoc.getY() >= Math.min(Loc1.getY(), Loc2.getY()) && 
        		Math.max(Loc1.getZ(), Loc2.getZ()) >= PlayerLoc.getZ() && PlayerLoc.getZ() >= Math.min(Loc1.getZ(), Loc2.getZ())) {
        	IsIn = true;
        }
        return IsIn;
    }

    public Location[] ReturnCapLoc(String CapName)
    {
        Location LocList[] = new Location[2];
        Location loc1 = new Location(Bukkit.getWorld(Main.getPlugin(Main.class).getConfig().getString(CapName+".W1")),
        		Main.getPlugin(Main.class).getConfig().getDouble(CapName + ".X1"),
        		Main.getPlugin(Main.class).getConfig().getDouble(CapName + ".Y1"),
        		Main.getPlugin(Main.class).getConfig().getDouble(CapName + ".Z1"));
        Location loc2 = new Location(Bukkit.getWorld(Main.getPlugin(Main.class).getConfig().getString(CapName+".W2")),
        		Main.getPlugin(Main.class).getConfig().getDouble(CapName + ".X2"),
        		Main.getPlugin(Main.class).getConfig().getDouble(CapName + ".Y2"),
        		Main.getPlugin(Main.class).getConfig().getDouble(CapName + ".Z2"));
        LocList[0] = loc1;
        LocList[1] = loc2;
        return LocList;
    }

    public ChatColor CapTeamChatColor(String team)
    {
        if(team.equals(WordVar.Santa))
            return ChatColor.RED;
        if(team.equals(WordVar.Krampus))
            return ChatColor.BLUE;
        else
            return ChatColor.WHITE;
    }
}
