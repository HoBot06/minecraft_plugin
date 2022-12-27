package com.ho_bot.CNM.Utility;

import org.bukkit.Location;
import org.bukkit.entity.Entity;

public class HitBox
{
	private final Location aa;
    private final Location ab;
	
    public HitBox(Entity entity)
    {
        aa = entity.getLocation().subtract(0.3, 0, 0.3);
        ab = entity.getLocation().add(0.3, 1.8, 0.3);
    }

    public HitBox(Location aa, Location ab)
    {
        this.aa = aa;
        this.ab = ab;
    }

    public boolean intersects(Location l, float Adis)
    {
        return l.getX() >= aa.getX() - (double)Adis && l.getY() >= aa.getY() - (double)Adis && l.getZ() >= aa.getZ() - (double)Adis &&
        		l.getX() <= ab.getX() + (double)Adis && l.getY() <= ab.getY() + (double)Adis && l.getZ() <= ab.getZ() + (double)Adis;
    }
    
}
