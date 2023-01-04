package com.ho_bot.CNM.Command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.ho_bot.CNM.Scheduler.CoolTime_Scheduler;
import com.ho_bot.CNM.Utility.CapUtil;
import com.ho_bot.CNM.Utility.CommandUtil;
import com.ho_bot.CNM.Utility.RoleUtil;
import com.ho_bot.CNM.Utility.TeamUtil;
import com.ho_bot.CNM.Var.EtcVar;

public class CNM_Command implements CommandExecutor
{
	CommandUtil commandutil = new CommandUtil();
    TeamUtil TU = new TeamUtil();
    RoleUtil RU = new RoleUtil();
    CapUtil CU = new CapUtil();

    public boolean onCommand(CommandSender sender, Command command, String label, String args[])
    {
        Player player = (Player)sender;
        if(label.equalsIgnoreCase("CNM")) {
            if(player.isOp()) {
                try
                {
                    if(args[0].equalsIgnoreCase("team")) {
                        if(args.length == 1)
                        {
                            TU.TeamCommand(player);
                        } else
                        {
                            if(args[1].equalsIgnoreCase("set")) {
                                TU.TeamSet(player, Bukkit.getPlayer(args[2]), args[3]);
                            }
                            if(args[1].equalsIgnoreCase("check")) {
                                TU.TeamCheck(player, args[2]);
                            }
                            if(args[1].equalsIgnoreCase("remove")) {
                                TU.TeamRemove(player, Bukkit.getPlayer(args[2]));
                            }
                            if(args[1].equalsIgnoreCase("name")) {
                                TU.TeamCustomName(player, args[2], args[3]);
                            }
                        }
                    }
                    if(args[0].equalsIgnoreCase("cap")) {
                        if(args.length == 1)
                        {
                            CU.CapCommand(player);
                        }
                        else
                        {
                            if(args[1].equalsIgnoreCase("pos1"))
                            {
                                EtcVar.isPos1.put(player.getUniqueId(), true);
                                player.sendMessage("블럭을 클릭해주십쇼");
                            }
                            if(args[1].equalsIgnoreCase("pos2"))
                            {
                                EtcVar.isPos2.put(player.getUniqueId(), true);
                                player.sendMessage("블럭을 클릭해주십쇼");
                            }
                            if(args[1].equalsIgnoreCase("set")) {
                                if(EtcVar.Pos1.containsKey(player.getUniqueId()))
                                	if(EtcVar.Pos2.containsKey(player.getUniqueId())) {
                                		CU.SetCap(player, args[2]);
                                }
                                else {
                                    player.sendMessage("Pos1, Pos2 를 설정해주십쇼");
                                }
                            }
                        }
                    }
                    if(args[0].equalsIgnoreCase("clear"))
                    {
                        CoolTime_Scheduler.COOL.remove(player.getName());
                        player.sendMessage("쿨타임 초기화 완료");
                    }
                    if(args[0].equalsIgnoreCase("role")) {
                        if(args.length == 1) {
                            RU.RoleCommand(player);
                        }
                        else if(args[1].equalsIgnoreCase("set")) {
                            RU.RoleSet(player, player, args[2]);
                        }
                    }
                    if(args[0].equalsIgnoreCase("test")) {
                    	player.sendMessage(player.getHealth() + " : " + player.getMaxHealth() + " : " + player.getHealthScale());
                    	for(int count=0; count < 6; count++) {
                    		player.sendMessage(EtcVar.Armor_int[count] + "");
                    	}
                    }
                }
                catch(Exception e)
                {
                    commandutil.CNMCommand(player);
                }
            }
            else {
                player.sendMessage("오피가 없습니다");
            }
        }
        if(label.equalsIgnoreCase("all"))
        {
            String msg = " :";
            for(int i = 0; i < args.length; i++)
            {
                String s = args[i];
                msg = msg + " " + s;
            }
            Bukkit.broadcastMessage("[전체] " + player.getName() + msg);
        }
        return false;
    }
}
