// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   MsgUtil.java

package com.ho_bot.CNM.Utility;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class MsgUtil
{

    public MsgUtil()
    {
    }

    public static void CoolMsg(Player p, int Cool)
    {
        p.sendMessage((new StringBuilder("[\uD06C\uB9AC\uC2A4\uB9C8\uC2A4\uC758 \uC545\uBABD] ")).append(Cool).append("\uCD08 \uB0A8\uC558\uC2B5\uB2C8\uB2E4").toString());
    }

    public static void SkillUse(Player p)
    {
        p.sendMessage("[\uD06C\uB9AC\uC2A4\uB9C8\uC2A4\uC758 \uC545\uBABD] \uB2A5\uB825\uC774 \uC0AC\uC6A9\uB418\uC5C8\uC2B5\uB2C8\uB2E4");
    }

    public static List ColorVarMsg(String msg[], ChatColor color)
    {
        List list = new ArrayList();
        String as[];
        int j = (as = msg).length;
        for(int i = 0; i < j; i++)
        {
            String s = as[i];
            list.add((new StringBuilder()).append(color).append(s).toString());
        }

        return list;
    }
}
