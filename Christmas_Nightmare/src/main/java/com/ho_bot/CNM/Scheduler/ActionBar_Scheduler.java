package com.ho_bot.CNM.Scheduler;

import java.util.Map.Entry;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import com.ho_bot.CNM.Utility.ToolUtil;
import com.ho_bot.CNM.Var.EtcVar;
import com.ho_bot.CNM.Var.WordVar;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;

public class ActionBar_Scheduler extends BukkitRunnable
{
	ToolUtil TU;

    public ActionBar_Scheduler()
    {
        TU = new ToolUtil();
    }

    public void run()
    {
        String CapMsg = "";
        for(Entry<String, String> Cap : EtcVar.NowCapTeam.entrySet()) {
            CapMsg = CapMsg + ChatColor.WHITE + "| " + TU.CapTeamChatColor(Cap.getValue()) + Cap.getKey() + ChatColor.WHITE + " |";
        }
        CapMsg = ChatColor.RED + "" +ChatColor.BOLD + "산타 : " + ChatColor.RED + EtcVar.TeamPoint.get(WordVar.Santa) + "   " + CapMsg + "   " + ChatColor.BLUE + EtcVar.TeamPoint.get(WordVar.Krampus) + ChatColor.BLUE + ChatColor.BOLD + " : 크람";
        for(Player p : Bukkit.getOnlinePlayers()) {
        	p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(CapMsg));
        }
    }
}
