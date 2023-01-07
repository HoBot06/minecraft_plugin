package com.ho_bot.CNM.Utility;

import org.bukkit.entity.Player;

public class CommandUtil
{
    public void CNMCommand(Player player)
    {
        player.sendMessage("==========================================");
        player.sendMessage("/CNM Start");
        player.sendMessage("/CNM Stop");
        player.sendMessage("/CNM Cap");
        player.sendMessage("/CNM Team");
        player.sendMessage("/CNM Role");
        player.sendMessage("/CNM Clear");
        player.sendMessage("==========================================");
    }
    
    public void CheckCommand(Player player)
    {
        player.sendMessage("==========================================");
        player.sendMessage("/Check Team");
        player.sendMessage("/Check Time");
        player.sendMessage("/Check Point");
        player.sendMessage("==========================================");
    }
}
