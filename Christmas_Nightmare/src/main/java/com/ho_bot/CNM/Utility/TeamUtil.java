package com.ho_bot.CNM.Utility;

import java.util.ArrayList;
import java.util.UUID;
import java.util.Map.Entry;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import com.ho_bot.CNM.Main;
import com.ho_bot.CNM.Var.TeamVar;
import com.ho_bot.CNM.Var.WordVar;

import xyz.haoshoku.nick.api.NickAPI;

public class TeamUtil
{
	static Main chmain = Main.getPlugin(Main.class);
	
    public void TeamSet(Player sender, Player player, String Team)
    {
        if(Team.equals(WordVar.Krampus) || Team.equals(WordVar.Santa))
        {
            TeamVar.Player_Team.put(player.getUniqueId(), Team);
            Bukkit.broadcastMessage(player.getName() + "님이 " + Team + " 팀으로 설정되었습니다");
            String TeamCustomName = chmain.getConfig().getString(Team + "." + WordVar.TeamShowName);
            NickAPI.nick(player, TeamCustomName + player.getName());
            NickAPI.refreshPlayer(player);
        } else {
            sender.sendMessage("팀이 잘못 입력되었습니다");
        }
    }

    public void TeamCheck(Player sender, String Team)
    {
        ArrayList<String> teamlist = new ArrayList<String>();
        if(Team.equals(WordVar.Krampus) || Team.equals(WordVar.Santa))
        {
            for(Entry<UUID, String> var : TeamVar.Player_Team.entrySet())
            {
                if(var.getValue().equals(Team)) {
                    teamlist.add(Bukkit.getPlayer(var.getKey()).getName());
                }
            }

            sender.sendMessage("리스트 : " + teamlist);
        } else
        {
            sender.sendMessage("팀이 잘못 입력되었습니다");
        }
    }

    public void TeamRemove(Player sender, Player player)
    {
        TeamVar.Player_Team.remove(player.getUniqueId());
        NickAPI.resetNick(player);
        NickAPI.refreshPlayer(player);
        sender.sendMessage(player.getName() + "님의 팀이 삭제되었습니다");
    }

    public void TeamCustomName(Player sender, String Team, String Name)
    {
    	if(Team.equals(WordVar.Krampus) || Team.equals(WordVar.Santa))
        {
            String TeamCustom = (new StringBuilder(String.valueOf(Name.replace('&', '\247')))).append(" ").toString();
            TeamVar.TeamShowName_Set(Team, TeamCustom);
            sender.sendMessage("\uD300 \uD45C\uC2DC\uC774\uB984\uC774 \uBCC0\uACBD\uB418\uC5C8\uC2B5\uB2C8\uB2E4");
            sender.sendMessage((new StringBuilder("EX) ")).append(TeamCustom).append(sender.getName()).toString());
            for(Entry<UUID, String> TeamPlayer : TeamVar.Player_Team.entrySet())
            {
                if(TeamPlayer.getValue().equals(Team))
                {
                    Player p = Bukkit.getPlayer(TeamPlayer.getKey());
                    NickAPI.nick(p, TeamCustom + TeamPlayer.getKey());
                    NickAPI.refreshPlayer(p);
                }
            }

        } else
        {
            sender.sendMessage("팀이 잘못 입력되었습니다");
        }
    }

    public void TeamCommand(Player player)
    {
        player.sendMessage("==========================================");
        player.sendMessage("/CNM Team Set [playername] [산타/크람푸스]");
        player.sendMessage("/CNM Team Check [산타/크람푸스]");
        player.sendMessage("/CNM Team Remove [playername]");
        player.sendMessage("/CNM Team Name [산타/크람푸스] [표시이름]");
        player.sendMessage("==========================================");
    }
}
