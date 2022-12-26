// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   Vector_Cal.java

package com.ho_bot.CNM.Tools;

import org.bukkit.Location;
import org.bukkit.util.Vector;

public class Vector_Cal
{

    public Vector_Cal()
    {
    }

    public static Vector PlayerGrabVec(Location point, Location victim)
    {
        Vector vec = new Vector();
        vec.setX(point.getX() - victim.getX());
        vec.setZ(point.getZ() - victim.getZ());
        return vec;
    }
}
