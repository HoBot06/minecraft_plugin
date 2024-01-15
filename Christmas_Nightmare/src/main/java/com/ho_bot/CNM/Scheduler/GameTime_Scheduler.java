package com.ho_bot.CNM.Scheduler;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import com.ho_bot.CNM.Tools.Sounds;
import com.ho_bot.CNM.Var.EtcVar;
import com.ho_bot.CNM.Var.WordVar;

public class GameTime_Scheduler extends BukkitRunnable
{
	public static int GameTime = 0;
	
	@SuppressWarnings("deprecation")
	public void run()
    {
        if(EtcVar.GameSet) {
        	if(GameTime > 0) {
        		GameTime--;
        	}
        	else {
        		EtcVar.GameSet=false;
        		for(String CapName : EtcVar.CapNameList)
                {
        			EtcVar.NowCapTeam.put(CapName, WordVar.NoTeam);
                }
        		for(Player p : Bukkit.getOnlinePlayers()) {
        			p.sendTitle("게임이 종료되었습니다!", "");
        			Sounds.SoundP(p, Sound.ENTITY_ENDER_DRAGON_AMBIENT, 1.0f, 1.0f);
        		}
        	}
        	if(GameTime==60) {
        		for(Player p : Bukkit.getOnlinePlayers()) {
        			p.sendTitle("남은시간", "1분");
        		}	
        	}
        	if(GameTime==300) {
        		for(Player p : Bukkit.getOnlinePlayers()) {
        			p.sendTitle("남은시간", "5분");
        		}
        	}
        	if(GameTime==600) {
        		for(Player p : Bukkit.getOnlinePlayers()) {
        			p.sendTitle("남은시간", "10분");
        		}
        	}
        }
    }

}
