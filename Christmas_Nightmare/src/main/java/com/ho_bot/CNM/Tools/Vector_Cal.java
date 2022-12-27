package com.ho_bot.CNM.Tools;

import org.bukkit.Location;
import org.bukkit.util.Vector;

public class Vector_Cal
{
	public static Vector PlayerGrabVec(Location point, Location victim)
    {
        Vector vec = new Vector();
        vec.setX(point.getX() - victim.getX());
        vec.setZ(point.getZ() - victim.getZ());
        return vec;
    }
}
