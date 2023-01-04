package com.ho_bot.CNM.Utility;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class MsgUtil
{
	public static void CoolMsg(Player p, int Cool)
    {
        p.sendMessage("[크리스마스의 악몽] " + Cool + "초 남았습니다");
    }

    public static void SkillUse(Player p)
    {
        p.sendMessage("[크리스마스의 악몽] 능력이 사용되었습니다");
    }

    public static List<String> ColorVarMsg(String msg[], ChatColor color)
    {
        List<String> list = new ArrayList<String>();
        for(int i = 0; i < msg.length; i++)
        {
            String s = msg[i];
            list.add(color + s);
        }

        return list;
    }
}
