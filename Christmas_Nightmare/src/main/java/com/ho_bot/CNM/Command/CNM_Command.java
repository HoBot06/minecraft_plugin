package com.ho_bot.CNM.Command;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import com.ho_bot.CNM.Scheduler.CoolTime_Scheduler;
import com.ho_bot.CNM.Scheduler.GameTime_Scheduler;
import com.ho_bot.CNM.Tools.TeamGreen;
import com.ho_bot.CNM.Utility.CapUtil;
import com.ho_bot.CNM.Utility.CommandUtil;
import com.ho_bot.CNM.Utility.RoleUtil;
import com.ho_bot.CNM.Utility.StartUtil;
import com.ho_bot.CNM.Utility.TeamUtil;
import com.ho_bot.CNM.Var.EtcVar;
import com.ho_bot.CNM.Var.TeamVar;

import net.md_5.bungee.api.ChatColor;

public class CNM_Command implements CommandExecutor
{
	CommandUtil commandutil = new CommandUtil();
    TeamUtil TU = new TeamUtil();
    RoleUtil RU = new RoleUtil();
    CapUtil CU = new CapUtil();

    @SuppressWarnings("deprecation")
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
                            if(args[1].equalsIgnoreCase("random")) {
                            	TeamGreen.Module(sender);
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
                    if(args[0].equalsIgnoreCase("start")) {
                    	if(args[1]!=null) {
                    		EtcVar.GameSet=true;
                    		GameTime_Scheduler.GameTime=Integer.parseInt(args[1]);
                    		Bukkit.broadcastMessage("게임이 시작되었습니다!");
                    		for(Player user : Bukkit.getOnlinePlayers()) {
                    			StartUtil.SetTeamSpawn(user);
                    			StartUtil.SetTeamTel(user);
                    			user.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 1000000, 1, false, false), true);
                    		}
                    	}
                    	else {
                    		player.sendMessage("시간을 입력해주세요");
                    	}
                    }
                    if(args[0].equalsIgnoreCase("stop")) {
                    	GameTime_Scheduler.GameTime=0;
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
        if(label.equalsIgnoreCase("check")) {
        	if(!args[0].isEmpty()) {
	        	if(args[0].equalsIgnoreCase("team")) {
	        		if(TeamVar.Player_Team.containsKey(player.getUniqueId())) {
		        		List<String> teamlist = new ArrayList<String>();
		        		for(Player p : Bukkit.getOnlinePlayers()) {
		        			if(TeamVar.Player_Team.containsKey(p.getUniqueId())) {
		        				if(TeamVar.Player_Team.get(player.getUniqueId()).equals(TeamVar.Player_Team.get(p.getUniqueId()))) {
		        					if(TeamVar.Player_Role.containsKey(player.getUniqueId())) {
		        	        			teamlist.add(ChatColor.WHITE + p.getName() + " : " + TeamVar.Player_Role.get(player.getUniqueId()));
		        	        		}
		        	        		else {
		        	        			teamlist.add(ChatColor.WHITE + p.getName() + " : 역할이 없습니다");
		        	        		}
		        				}
		        			}
		        		}
		        		for(String s : teamlist) {
		        			player.sendMessage(s);
		        		}
	        		}
	        		else {
	            		player.sendMessage("팀이 존재하지 않습니다");
	            	}
	        	}
	        	if(args[0].equalsIgnoreCase("time")) {
	        		player.sendMessage(GameTime_Scheduler.GameTime+"초 남았습니다");
	        	}
	        	if(args[0].equalsIgnoreCase("point")) {
	        		if(TeamVar.Player_Team.containsKey(player.getUniqueId())) {
	        			player.sendMessage("현재 연구포인트 : " + TeamVar.Team_JobUpPoint.get(TeamVar.Player_Team.get(player.getUniqueId())));
	        		}
	        		else {
	        			player.sendMessage("팀이 없습니다");
	        		}
	        	}
        	}
        	else {
        		commandutil.CheckCommand(player);
        	}
        }
        return false;
    }
}
