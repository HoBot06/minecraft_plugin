package com.ho_bot.CNM;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import com.ho_bot.CNM.Command.CNM_Command;
import com.ho_bot.CNM.Event.CNM_Event;
import com.ho_bot.CNM.Utility.ToolUtil;
import com.ho_bot.CNM.Var.EtcVar;

import xyz.haoshoku.nick.api.NickAPI;

public class Main extends JavaPlugin
{

    public Main()
    {
        TU = new ToolUtil();
    }

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
        }

        EtcVar.TeamPoint.put("산타", 0);
        EtcVar.TeamPoint.put("크람푸스", 0);
        String CapName;
        for(Iterator iterator1 = EtcVar.CapNameList.iterator(); iterator1.hasNext(); EtcVar.NowCapTeam.put(CapName, "white"))
        {
            CapName = (String)iterator1.next();
            if(getConfig().get(CapName) != null)
                EtcVar.Capture.put(CapName, TU.ReturnCapLoc(CapName));
            BossBar bossbar = Bukkit.createBossBar((new StringBuilder(String.valueOf(CapName))).append("\uAC70\uC810").toString(), BarColor.WHITE, BarStyle.SOLID, new BarFlag[0]);
            bossbar.setProgress(0.0D);
            EtcVar.CaptureBossbar.put(CapName, bossbar);
            ArrayList plist = new ArrayList();
            EtcVar.NowInCapture.put(CapName, plist);
        }

        Cap_Scheduler CS = new Cap_Scheduler();
        ActionBar_Scheduler AS = new ActionBar_Scheduler();
        Point_Scheduler PS = new Point_Scheduler();
        CoolTime_Scheduler CTS = new CoolTime_Scheduler();
        AllSkillTimer AST = new AllSkillTimer();
        CS.runTaskTimer(getPlugin(com/ho_bot/CNM/Main), 0L, 1L);
        AS.runTaskTimer(getPlugin(com/ho_bot/CNM/Main), 0L, 1L);
        PS.runTaskTimer(getPlugin(com/ho_bot/CNM/Main), 0L, 20L);
        CTS.runTaskTimer(getPlugin(com/ho_bot/CNM/Main), 0L, 20L);
        AST.runTaskTimer(getPlugin(com/ho_bot/CNM/Main), 0L, 1L);
    }

    ToolUtil TU;
}
