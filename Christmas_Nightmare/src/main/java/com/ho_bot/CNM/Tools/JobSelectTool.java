// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   JobSelectTool.java

package com.ho_bot.CNM.Tools;

import com.ho_bot.CNM.Gui.JobSelect;
import com.ho_bot.CNM.Job.Job;
import com.ho_bot.CNM.Var.JobVar;
import com.ho_bot.CNM.Var.TeamVar;
import java.util.HashMap;
import org.bukkit.entity.Player;
import org.bukkit.inventory.PlayerInventory;

public class JobSelectTool
{

    public JobSelectTool()
    {
    }

    public static void JobSelTool(Player player, Job job)
    {
        if(TeamVar.Player_Team.containsKey(player.getUniqueId()))
        {
            HashMap joblist = (HashMap)JobVar.TeamJobList.get(TeamVar.Player_Team.get(player.getUniqueId()));
            if(joblist == null)
            {
                JobVar.Job_Player.put(player.getUniqueId(), job);
                HashMap jlist = new HashMap();
                jlist.put(player.getUniqueId(), job.abilityName);
                JobVar.TeamJobList.put((String)TeamVar.Player_Team.get(player.getUniqueId()), jlist);
                JobArmorTool(player, job);
                player.sendMessage("\uC9C1\uC5C5\uC774 \uBCC0\uACBD\uB418\uC5C8\uC2B5\uB2C8\uB2E4");
            } else
            if(joblist.containsKey(player.getUniqueId()) && joblist.get(player.getUniqueId()) != job.abilityName || !joblist.containsKey(player.getUniqueId()))
            {
                JobVar.Job_Player.put(player.getUniqueId(), job);
                joblist.put(player.getUniqueId(), job.abilityName);
                JobVar.TeamJobList.put((String)TeamVar.Player_Team.get(player.getUniqueId()), joblist);
                JobArmorTool(player, job);
                player.sendMessage("\uC9C1\uC5C5\uC774 \uBCC0\uACBD\uB418\uC5C8\uC2B5\uB2C8\uB2E4");
            } else
            {
                player.sendMessage("\uAC70\uC808\uB418\uC5C8\uC2B5\uB2C8\uB2E4");
            }
            JobSelect.JobSelectGui(player);
        } else
        {
            player.sendMessage("\uD300\uC774 \uC5C6\uC2B5\uB2C8\uB2E4");
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
}
