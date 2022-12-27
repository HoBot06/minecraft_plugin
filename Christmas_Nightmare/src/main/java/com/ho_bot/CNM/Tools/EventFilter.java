package com.ho_bot.CNM.Tools;

import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class EventFilter
{
	public static int PlayerInteract(PlayerInteractEvent event)
    {
        Action action = event.getAction();
        if(action.equals(Action.LEFT_CLICK_AIR))
            return 0;
        if(action.equals(Action.LEFT_CLICK_BLOCK))
            return 1;
        if(action.equals(Action.RIGHT_CLICK_AIR))
            return 2;
        if(action.equals(Action.RIGHT_CLICK_BLOCK))
        	return 3;
        return -1;
    }
}
