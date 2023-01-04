package com.ho_bot.CNM.Tools;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class P_Inv
{
    public static boolean InHandItemCheck(Player player, Material material)
    {
        if(player.getInventory().getItemInMainHand().getType() == material) {
        	return true;
        }
        return false;
    }

    public static boolean ItemCheck(Player player, Material material, int stack)
    {
        if(player.getInventory().contains(material, stack)) {
        	return true;
        }
        return false;
    }
    
    public static boolean ItemStackCheck(Player player, ItemStack itemstack, int stack)
    {
        if(player.getInventory().contains(itemstack, stack)) {
        	return true;
        }
        return false;
    }

    public static void ItemRemove(Player player, Material material, int stack)
    {
        player.getInventory().removeItem(new ItemStack(material, stack));
    }
    
    public static void ItemStackRemove(Player player, ItemStack itemstack, int stack)
    {
    	itemstack.setAmount(stack);
        player.getInventory().removeItem(itemstack);
    }
}
