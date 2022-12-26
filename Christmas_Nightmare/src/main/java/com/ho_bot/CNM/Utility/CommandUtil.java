// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   CommandUtil.java

package com.ho_bot.CNM.Utility;

import org.bukkit.entity.Player;

public class CommandUtil
{

    public CommandUtil()
    {
    }

    public void CNMCommand(Player player)
    {
        player.sendMessage("==========================================");
        player.sendMessage("/CNM Cap");
        player.sendMessage("/CNM Team");
        player.sendMessage("/CNM Clear");
        player.sendMessage("==========================================");
    }
}
