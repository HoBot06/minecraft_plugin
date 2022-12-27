package com.ho_bot.CNM.NPC;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEntityEvent;

import com.ho_bot.CNM.Gui.JobSelect;
import com.ho_bot.CNM.Var.TeamVar;
import com.ho_bot.CNM.Var.WordVar;

public class ScienceNPC
{
    public static void ScienceNPC_Click(PlayerInteractEntityEvent event)
    {
        Player player = event.getPlayer();
        if(TeamVar.Player_Role.containsKey(player.getUniqueId()))
        {
            if(TeamVar.Player_Role.get(player.getUniqueId()).equals(WordVar.Santa_Battle) || TeamVar.Player_Role.get(player.getUniqueId()).equals(WordVar.Krampus_Battle)) {
                JobSelect.JobSelectGui(player);
            }
            else {
                player.sendMessage("�������� �ƴմϴ�");
            }
        }
        else {
            player.sendMessage("���ұ��� �������� �ʾҽ��ϴ�");
        }
    }
}
