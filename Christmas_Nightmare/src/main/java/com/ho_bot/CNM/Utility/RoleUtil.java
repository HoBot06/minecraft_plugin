// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   RoleUtil.java

package com.ho_bot.CNM.Utility;

import com.ho_bot.CNM.Var.TeamVar;
import java.util.*;
import org.bukkit.entity.Player;

public class RoleUtil
{

    public RoleUtil()
    {
    }

    public void RoleSet(Player sender, Player player, String Role)
    {
        if(Role.equals("\uD06C\uB78C\uD478\uC2A4\uC804\uD22C") || Role.equals("\uD06C\uB78C\uD478\uC2A4\uACFC\uD559\uC790") || Role.equals("\uC0B0\uD0C0\uC804\uD22C") || Role.equals("\uC0B0\uD0C0\uACFC\uD559\uC790"))
        {
            if(Role.equals("\uC0B0\uD0C0\uC804\uD22C") || Role.equals("\uD06C\uB78C\uD478\uC2A4\uC804\uD22C"))
            {
                if(RoleCheck(sender, player, Role))
                {
                    TeamVar.Player_Role.put(player.getUniqueId(), Role);
                    sender.sendMessage("\uC804\uD22C\uC6D0\uC73C\uB85C \uC124\uC815\uB418\uC5C8\uC2B5\uB2C8\uB2E4");
                } else
                {
                    sender.sendMessage("\uC804\uD22C\uC6D0\uC758 \uC790\uB9AC\uAC00 \uC5C6\uC2B5\uB2C8\uB2E4");
                }
            } else
            if(Role.equals("\uC0B0\uD0C0\uACFC\uD559\uC790") || Role.equals("\uD06C\uB78C\uD478\uC2A4\uACFC\uD559\uC790"))
            {
                TeamVar.Player_Role.put(player.getUniqueId(), Role);
                sender.sendMessage("\uC5F0\uAD6C\uC6D0\uC73C\uB85C \uC124\uC815\uB418\uC5C8\uC2B5\uB2C8\uB2E4");
            }
        } else
        {
            sender.sendMessage("\uC5ED\uD560\uC774 \uC798\uBABB\uC785\uB825\uB418\uC5C8\uC2B5\uB2C8\uB2E4");
        }
    }

    private boolean RoleCheck(Player sender, Player player, String Role)
    {
        int count = 0;
        for(Iterator iterator = TeamVar.Player_Role.entrySet().iterator(); iterator.hasNext();)
        {
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            if(((String)entry.getValue()).equals(Role))
                count++;
        }

        return count < 6;
    }

    public void RoleCommand(Player player)
    {
        player.sendMessage("==========================================");
        player.sendMessage("/CNM Role Set [playername] [\uC0B0\uD0C0\uC804\uD22C/\uC0B0\uD0C0\uACFC\uD559\uC790/\uD06C\uB78C\uD478\uC2A4\uC804\uD22C/\uD06C\uB78C\uD478\uC2A4\uACFC\uD559\uC790]");
        player.sendMessage("==========================================");
    }
}
