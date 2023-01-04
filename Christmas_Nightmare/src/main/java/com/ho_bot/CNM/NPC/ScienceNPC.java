package com.ho_bot.CNM.NPC;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEntityEvent;

import com.ho_bot.CNM.Gui.Science;
import com.ho_bot.CNM.Var.TeamVar;
import com.ho_bot.CNM.Var.WordVar;

public class ScienceNPC
{
    public static void ScienceNPC_Click(PlayerInteractEntityEvent event)
    {
        Player player = event.getPlayer();
        if(TeamVar.Player_Role.containsKey(player.getUniqueId()))
        {
            if(TeamVar.Player_Role.get(player.getUniqueId()).equals(WordVar.Santa_Scientist) || TeamVar.Player_Role.get(player.getUniqueId()).equals(WordVar.Krampus_Scientist)) {
                Science.ScienceGui(player);
            }
            else {
                player.sendMessage("연구원이 아닙니다");
            }
        }
        else {
            player.sendMessage("역할군이 정해지지 않았습니다");
        }
    }
}
