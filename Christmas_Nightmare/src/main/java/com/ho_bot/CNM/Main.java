package com.ho_bot.CNM;

import java.util.ArrayList;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarFlag;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import com.ho_bot.CNM.Command.CNM_Command;
import com.ho_bot.CNM.Event.CNM_Event;
import com.ho_bot.CNM.Scheduler.ActionBar_Scheduler;
import com.ho_bot.CNM.Scheduler.Cap_Scheduler;
import com.ho_bot.CNM.Scheduler.CoolTime_Scheduler;
import com.ho_bot.CNM.Scheduler.Point_Scheduler;
import com.ho_bot.CNM.Scheduler.Skill.AllSkillTimer;
import com.ho_bot.CNM.Utility.ToolUtil;
import com.ho_bot.CNM.Var.EtcVar;
import com.ho_bot.CNM.Var.WordVar;

import xyz.haoshoku.nick.api.NickAPI;

public class Main extends JavaPlugin
{
	ToolUtil TU = new ToolUtil();

    public void onEnable()
    {
        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "Christmas_Nightmare v1.0 Online");
        
        CNM_Event.setPlugin(this);
        CNM_Event nswevent = new CNM_Event();
        
        getCommand("CNM").setExecutor(new CNM_Command());
        getCommand("all").setExecutor(new CNM_Command());
        getServer().getPluginManager().registerEvents(nswevent, this);
        getConfig().options().copyDefaults(true);
        saveConfig();
        
        for(Player alpl : Bukkit.getOnlinePlayers())
        {
            NickAPI.resetNick(alpl);
            alpl.setDisplayName(alpl.getName());
            alpl.setPlayerListName(alpl.getName());
        }

        EtcVar.TeamPoint.put("산타", 0);
        EtcVar.TeamPoint.put("크람푸스", 0);
        for(String CapName : EtcVar.CapNameList)
        {
            if(getConfig().get(CapName) != null) {
                EtcVar.Capture.put(CapName, TU.ReturnCapLoc(CapName));
            }
            BossBar bossbar = Bukkit.createBossBar(CapName + "거점", BarColor.WHITE, BarStyle.SOLID, new BarFlag[0]);
            bossbar.setProgress(0);
            EtcVar.CaptureBossbar.put(CapName, bossbar);
            ArrayList<UUID> plist = new ArrayList<UUID>();
            EtcVar.NowInCapture.put(CapName, plist);
            EtcVar.NowCapTeam.put(CapName, WordVar.NoTeam);
        }

        Cap_Scheduler CS = new Cap_Scheduler();
        ActionBar_Scheduler AS = new ActionBar_Scheduler();
        Point_Scheduler PS = new Point_Scheduler();
        CoolTime_Scheduler CTS = new CoolTime_Scheduler();
        AllSkillTimer AST = new AllSkillTimer();
        CS.runTaskTimer(getPlugin(Main.class), 0L, 1L);
        AS.runTaskTimer(getPlugin(Main.class), 0L, 1L);
        PS.runTaskTimer(getPlugin(Main.class), 0L, 20L);
        CTS.runTaskTimer(getPlugin(Main.class), 0L, 20L);
        AST.runTaskTimer(getPlugin(Main.class), 0L, 1L);
    }
}
