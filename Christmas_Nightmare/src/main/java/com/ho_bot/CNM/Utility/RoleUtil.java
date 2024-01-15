package com.ho_bot.CNM.Utility;

import java.util.Map.Entry;
import java.util.UUID;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.ho_bot.CNM.Var.ItemVar;
import com.ho_bot.CNM.Var.TeamVar;
import com.ho_bot.CNM.Var.WordVar;

public class RoleUtil
{
	public void RoleSet(Player sender, Player player, String Role)
    {
        if(Role.equals(WordVar.Krampus_Battle) || Role.equals(WordVar.Krampus_Scientist) ||
        		Role.equals(WordVar.Santa_Battle) || Role.equals(WordVar.Santa_Scientist))
        {
            if(Role.equals(WordVar.Santa_Battle) || Role.equals(WordVar.Krampus_Battle))
            {
                if(RoleCheck(sender, player, Role))
                {
                	if (!TeamVar.Player_Upgrade.containsKey(player.getUniqueId())) {
                		int[] UpInt = {0,0,0};
                		TeamVar.Player_Upgrade.put(player.getUniqueId(), UpInt);
                	}
                    TeamVar.Player_Role.put(player.getUniqueId(), Role);
                    player.getInventory().clear();
                    sender.sendMessage("전투원으로 설정되었습니다");
                } else
                {
                    sender.sendMessage("전투원의 자리가 없습니다");
                }
            } else
            if(Role.equals(WordVar.Santa_Scientist) || Role.equals(WordVar.Krampus_Scientist))
            {
                TeamVar.Player_Role.put(player.getUniqueId(), Role);
                player.getInventory().clear();
                for(ItemStack item : ItemVar.ScienceItem()) {
                	player.getInventory().addItem(item);
                }
                sender.sendMessage("연구원으로 설정되었습니다");
            }
        } else
        {
            sender.sendMessage("역할이 잘못입력되었습니다");
        }
    }

    private boolean RoleCheck(Player sender, Player player, String Role)
    {
        int count = 0;
        for(Entry<UUID, String> entry : TeamVar.Player_Role.entrySet()) {
        	if(entry.getValue().equals(Role)) {
        		count++;
        	}
        }
        if(count < 6) {
        	return true;
        }
		return false;
    }

    public void RoleCommand(Player player)
    {
        player.sendMessage("==========================================");
        player.sendMessage("/CNM Role Set [" + WordVar.Santa_Battle + "/" + WordVar.Santa_Scientist + "/" + WordVar.Krampus_Battle + "/" + WordVar.Krampus_Scientist + "]");
        player.sendMessage("==========================================");
    }
}
