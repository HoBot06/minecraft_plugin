// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   JobSelectNPC.java

package com.ho_bot.CNM.NPC;

import com.ho_bot.CNM.Gui.JobSelect;
import com.ho_bot.CNM.Var.TeamVar;
import java.util.HashMap;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class JobSelectNPC
{

    public JobSelectNPC()
    {
    }

    public static void JobSelectNPC_Click(PlayerInteractEntityEvent event)
    {
        Player player = event.getPlayer();
        if(TeamVar.Player_Role.containsKey(player.getUniqueId()))
        {
            if(((String)TeamVar.Player_Role.get(player.getUniqueId())).equals("\uC0B0\uD0C0\uC804\uD22C") || ((String)TeamVar.Player_Role.get(player.getUniqueId())).equals("\uD06C\uB78C\uD478\uC2A4\uC804\uD22C"))
                JobSelect.JobSelectGui(player);
            else
                player.sendMessage("\uC804\uD22C\uC6D0\uC774 \uC544\uB2D9\uB2C8\uB2E4");
        } else
        {
            player.sendMessage("\uC5ED\uD560\uAD70\uC774 \uC815\uD574\uC9C0\uC9C0 \uC54A\uC558\uC2B5\uB2C8\uB2E4");
        }
    }
}
