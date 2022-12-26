// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   CNM_Command.java

package com.ho_bot.CNM.Command;

import com.ho_bot.CNM.Scheduler.CoolTime_Scheduler;
import com.ho_bot.CNM.Utility.*;
import com.ho_bot.CNM.Var.EtcVar;
import java.util.HashMap;
import org.bukkit.Bukkit;
import org.bukkit.command.*;
import org.bukkit.entity.Player;

public class CNM_Command
    implements CommandExecutor
{

    public CNM_Command()
    {
        commandutil = new CommandUtil();
        TU = new TeamUtil();
        RU = new RoleUtil();
        CU = new CapUtil();
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String args[])
    {
        Player player = (Player)sender;
        if(label.equalsIgnoreCase("CNM"))
            if(player.isOp())
                try
                {
                    if(args[0].equalsIgnoreCase("team"))
                        if(args.length == 1)
                        {
                            TU.TeamCommand(player);
                        } else
                        {
                            if(args[1].equalsIgnoreCase("set"))
                                TU.TeamSet(player, Bukkit.getPlayer(args[2]), args[3]);
                            if(args[1].equalsIgnoreCase("check"))
                                TU.TeamCheck(player, args[2]);
                            if(args[1].equalsIgnoreCase("remove"))
                                TU.TeamRemove(player, Bukkit.getPlayer(args[2]));
                            if(args[1].equalsIgnoreCase("name"))
                                TU.TeamCustomName(player, args[2], args[3]);
                        }
                    if(args[0].equalsIgnoreCase("cap"))
                        if(args.length == 1)
                        {
                            CU.CapCommand(player);
                        } else
                        {
                            if(args[1].equalsIgnoreCase("pos1"))
                            {
                                EtcVar.isPos1.put(player.getUniqueId(), Boolean.valueOf(true));
                                player.sendMessage("\uBE14\uB7ED\uC744 \uD074\uB9AD\uD574\uC8FC\uC2ED\uC1FC");
                            }
                            if(args[1].equalsIgnoreCase("pos2"))
                            {
                                EtcVar.isPos2.put(player.getUniqueId(), Boolean.valueOf(true));
                                player.sendMessage("\uBE14\uB7ED\uC744 \uD074\uB9AD\uD574\uC8FC\uC2ED\uC1FC");
                            }
                            if(args[1].equalsIgnoreCase("set"))
                                if(EtcVar.Pos1.containsKey(player.getUniqueId()) && EtcVar.Pos1.containsKey(player.getUniqueId()))
                                    CU.SetCap(player, args[2]);
                                else
                                    player.sendMessage("Pos1, Pos2 \uB97C \uC124\uC815\uD574\uC8FC\uC2ED\uC1FC");
                        }
                    if(args[0].equalsIgnoreCase("clear"))
                    {
                        CoolTime_Scheduler.COOL.remove(player.getName());
                        player.sendMessage("\uCFE8\uD0C0\uC784 \uCD08\uAE30\uD654 \uC644\uB8CC");
                    }
                    if(args[0].equalsIgnoreCase("role"))
                        if(args.length == 1)
                            RU.RoleCommand(player);
                        else
                        if(args[1].equalsIgnoreCase("set"))
                            RU.RoleSet(player, player, args[2]);
                }
                catch(Exception e)
                {
                    commandutil.CNMCommand(player);
                }
            else
                player.sendMessage("\uC624\uD53C\uAC00 \uC5C6\uC2B5\uB2C8\uB2E4");
        if(label.equalsIgnoreCase("all"))
        {
            String msg = " :";
            String as[];
            int j = (as = args).length;
            for(int i = 0; i < j; i++)
            {
                String s = as[i];
                msg = (new StringBuilder(String.valueOf(msg))).append(" ").append(s).toString();
            }

            Bukkit.broadcastMessage((new StringBuilder("[\uC804\uCCB4] ")).append(player.getName()).append(msg).toString());
        }
        return false;
    }

    CommandUtil commandutil;
    TeamUtil TU;
    RoleUtil RU;
    CapUtil CU;
}
