// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   EventFilter.java

package com.ho_bot.CNM.Tools;

import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class EventFilter
{

    public EventFilter()
    {
    }

    public static int PlayerInteract(PlayerInteractEvent event)
    {
        Action action = event.getAction();
        if(action.equals(Action.LEFT_CLICK_AIR))
            return 0;
        if(action.equals(Action.LEFT_CLICK_BLOCK))
            return 1;
        if(action.equals(Action.RIGHT_CLICK_AIR))
            return 2;
        return !action.equals(Action.RIGHT_CLICK_BLOCK) ? -1 : 3;
    }
}
