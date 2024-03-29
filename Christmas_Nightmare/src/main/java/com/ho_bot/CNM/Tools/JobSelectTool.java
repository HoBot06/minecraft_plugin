package com.ho_bot.CNM.Tools;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.UUID;

import org.bukkit.Color;
import org.bukkit.entity.Player;

import com.ho_bot.CNM.Gui.JobSelect;
import com.ho_bot.CNM.Job.Job;
import com.ho_bot.CNM.Var.JobVar;
import com.ho_bot.CNM.Var.TeamVar;
import com.ho_bot.CNM.Var.WordVar;

public class JobSelectTool
{
	public static void JobSelTool(Player player, Job job)
    {
        if(TeamVar.Player_Team.containsKey(player.getUniqueId()))
        {
            HashMap<UUID, String> joblist = JobVar.TeamJobList.get(TeamVar.Player_Team.get(player.getUniqueId()));
            if(joblist == null)
            {
                JobVar.Job_Player.put(player.getUniqueId(), job);
                HashMap<UUID, String> jlist = new HashMap<UUID, String>();
                jlist.put(player.getUniqueId(), job.abilityName);
                JobVar.TeamJobList.put(TeamVar.Player_Team.get(player.getUniqueId()), jlist);
                JobArmorTool(player, job);
                player.sendMessage("직업이 변경되었습니다");
            }
            else if((joblist.containsKey(player.getUniqueId()) && joblist.get(player.getUniqueId()) != job.abilityName) || !joblist.containsKey(player.getUniqueId()))
            {
            	for(Entry<UUID, String> entry : joblist.entrySet()) {
            		if(entry.getValue().equals(job.abilityName)) {
            			player.sendMessage("이미 다른 플레이어가 선택중입니다");
            			return;
            		}
            	}
                JobVar.Job_Player.put(player.getUniqueId(), job);
                joblist.put(player.getUniqueId(), job.abilityName);
                JobVar.TeamJobList.put(TeamVar.Player_Team.get(player.getUniqueId()), joblist);
                JobArmorTool(player, job);
                player.sendMessage("직업이 변경되었습니다");
            }
            else
            {
                player.sendMessage("거절되었습니다");
            }
            JobSelect.JobSelectGui(player);
        } else
        {
            player.sendMessage("팀이 없습니다");
        }
    }

    private static void JobArmorTool(Player player, Job job)
    {
        player.getInventory().clear();
        player.getInventory().setItem(0, job.weapon);
        player.getInventory().setHelmet(job.helmet);
        player.getInventory().setChestplate(job.chestplate);
        player.getInventory().setLeggings(job.leggings);
        player.getInventory().setBoots(job.boots);
    }
    
    public static Color JobArmorColor(Player player) {
    	if(TeamVar.Player_Team.get(player.getUniqueId()).equals(WordVar.Santa)) {
    		return Color.RED;
    	}
    	if(TeamVar.Player_Team.get(player.getUniqueId()).equals(WordVar.Krampus)) {
    		return Color.BLUE;
    	}
		return Color.WHITE;
    }
}
