// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   HitBox.java

package com.ho_bot.CNM.Utility;

import org.bukkit.Location;
import org.bukkit.entity.Entity;

public class HitBox
{

    public HitBox(Entity entity)
    {
        aa = entity.getLocation().subtract(0.29999999999999999D, 0.0D, 0.29999999999999999D);
        ab = entity.getLocation().add(0.29999999999999999D, 1.8D, 0.29999999999999999D);
    }

    public HitBox(Location aa, Location ab)
    {
        this.aa = aa;
        this.ab = ab;
    }

    public boolean intersects(Location l, float Adis)
    {
        return l.getX() >= aa.getX() - (double)Adis && l.getY() >= aa.getY() - (double)Adis && l.getZ() >= aa.getZ() - (double)Adis && l.getX() <= ab.getX() + (double)Adis && l.getY() <= ab.getY() + (double)Adis && l.getZ() <= ab.getZ() + (double)Adis;
    }

    private final Location aa;
    private final Location ab;
}
