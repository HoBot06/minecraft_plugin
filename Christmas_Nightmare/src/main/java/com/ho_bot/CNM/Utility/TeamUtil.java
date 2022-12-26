// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   TeamUtil.java

package com.ho_bot.CNM.Utility;

import com.ho_bot.CNM.Main;
import com.ho_bot.CNM.Var.TeamVar;
import java.util.*;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import xyz.haoshoku.nick.api.NickAPI;

public class TeamUtil
{

    public TeamUtil()
    {
    }

    public void TeamSet(Player sender, Player player, String Team)
    {
        if(Team.equals("\uD06C\uB78C\uD478\uC2A4") || Team.equals("\uC0B0\uD0C0"))
        {
            TeamVar.Player_Team.put(player.getUniqueId(), Team);
            Bukkit.broadcastMessage((new StringBuilder(String.valueOf(player.getName()))).append("\uB2D8\uC774 ").append(Team).append(" \uD300\uC73C\uB85C \uC124\uC815\uB418\uC5C8\uC2B5\uB2C8\uB2E4").toString());
            String TeamCustomName = chmain.getConfig().getString((new StringBuilder(String.valueOf(Team))).append(".").append("\uD300\uD45C\uC2DC\uC774\uB984").toString());
            NickAPI.nick(player, (new StringBuilder(String.valueOf(TeamCustomName))).append(player.getName()).toString());
            NickAPI.refreshPlayer(player);
        } else
        {
            sender.sendMessage("\uD300\uC774 \uC798\uBABB \uC785\uB825\uB418\uC5C8\uC2B5\uB2C8\uB2E4");
        }
    }

    public void TeamCheck(Player sender, String Team)
    {
        ArrayList teamlist = new ArrayList();
        if(Team.equals("\uD06C\uB78C\uD478\uC2A4") || Team.equals("\uC0B0\uD0C0"))
        {
            for(Iterator iterator = TeamVar.Player_Team.entrySet().iterator(); iterator.hasNext();)
            {
                java.util.Map.Entry var = (java.util.Map.Entry)iterator.next();
                if(((String)var.getValue()).equals(Team))
                    teamlist.add(Bukkit.getPlayer((UUID)var.getKey()).getName());
            }

            sender.sendMessage((new StringBuilder("\uB9AC\uC2A4\uD2B8 : ")).append(teamlist).toString());
        } else
        {
            sender.sendMessage("\uD300\uC774 \uC798\uBABB \uC785\uB825\uB418\uC5C8\uC2B5\uB2C8\uB2E4");
        }
    }

    public void TeamRemove(Player sender, Player player)
    {
        TeamVar.Player_Team.remove(player.getUniqueId());
        NickAPI.resetNick(player);
        NickAPI.refreshPlayer(player);
        sender.sendMessage((new StringBuilder(String.valueOf(player.getName()))).append("\uB2D8\uC758 \uD300\uC774 \uC0AD\uC81C\uB418\uC5C8\uC2B5\uB2C8\uB2E4").toString());
    }

    public void TeamCustomName(Player sender, String Team, String Name)
    {
        if(Team.equals("\uD06C\uB78C\uD478\uC2A4") || Team.equals("\uC0B0\uD0C0"))
        {
            String TeamCustom = (new StringBuilder(String.valueOf(Name.replace('&', '\247')))).append(" ").toString();
            TeamVar.TeamShowName_Set(Team, TeamCustom);
            sender.sendMessage("\uD300 \uD45C\uC2DC\uC774\uB984\uC774 \uBCC0\uACBD\uB418\uC5C8\uC2B5\uB2C8\uB2E4");
            sender.sendMessage((new StringBuilder("EX) ")).append(TeamCustom).append(sender.getName()).toString());
            for(Iterator iterator = TeamVar.Player_Team.entrySet().iterator(); iterator.hasNext();)
            {
                java.util.Map.Entry TeamPlayer = (java.util.Map.Entry)iterator.next();
                if(((String)TeamPlayer.getValue()).equals(Team))
                {
                    Player p = Bukkit.getPlayer((UUID)TeamPlayer.getKey());
                    NickAPI.nick(p, (new StringBuilder(String.valueOf(TeamCustom))).append(TeamPlayer.getKey()).toString());
                    NickAPI.refreshPlayer(p);
                }
            }

        } else
        {
            sender.sendMessage("\uD300\uC774 \uC798\uBABB \uC785\uB825\uB418\uC5C8\uC2B5\uB2C8\uB2E4");
        }
    }

    public void TeamCommand(Player player)
    {
        player.sendMessage("==========================================");
        player.sendMessage("/CNM Team Set [playername] [\uC0B0\uD0C0/\uD06C\uB78C\uD478\uC2A4]");
        player.sendMessage("/CNM Team Check [\uC0B0\uD0C0/\uD06C\uB78C\uD478\uC2A4]");
        player.sendMessage("/CNM Team Remove [playername]");
        player.sendMessage("/CNM Team Name [\uC0B0\uD0C0/\uD06C\uB78C\uD478\uC2A4] [\uD45C\uC2DC\uC774\uB984]");
        player.sendMessage("==========================================");
    }

    static Main chmain = (Main)Main.getPlugin(com/ho_bot/CNM/Main);

}
