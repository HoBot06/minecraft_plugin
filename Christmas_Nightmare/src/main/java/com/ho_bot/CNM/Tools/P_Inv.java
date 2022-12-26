// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) 
// Source File Name:   P_Inv.java

package com.ho_bot.CNM.Tools;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.*;

public class P_Inv
{

    public P_Inv()
    {
    }

    public static boolean InHandItemCheck(Player player, Material material)
    {
        return player.getInventory().getItemInMainHand().getType() == material;
    }

    public static boolean ItemCheck(Player player, Material material, int stack)
    {
        Inventory inventory = player.getInventory();
        return inventory.contains(material, stack);
    }

    public static void ItemRemove(Player player, Material material, int stack)
    {
        Inventory inventory = player.getInventory();
        inventory.removeItem(new ItemStack[] {
            new ItemStack(material, stack)
        });
    }
}
