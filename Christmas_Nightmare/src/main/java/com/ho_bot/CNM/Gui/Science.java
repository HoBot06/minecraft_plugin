package com.ho_bot.CNM.Gui;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import com.ho_bot.CNM.Job.Dealer.Bomber;
import com.ho_bot.CNM.Job.Dealer.Faster;
import com.ho_bot.CNM.Job.Dealer.Kratos;
import com.ho_bot.CNM.Job.Dealer.Saluran;
import com.ho_bot.CNM.Job.Support.Paladin;
import com.ho_bot.CNM.Job.Support.Pemanah;
import com.ho_bot.CNM.Job.Support.Zouk;
import com.ho_bot.CNM.Job.Tank.BigGuy;
import com.ho_bot.CNM.Job.Tank.Cruise;
import com.ho_bot.CNM.Job.Tank.Egis;
import com.ho_bot.CNM.Job.Tank.Patai;
import com.ho_bot.CNM.Tools.JobSelectTool;
import com.ho_bot.CNM.Var.ItemVar;
import com.ho_bot.CNM.Var.WordVar;

public class Science
{
	public static void ScienceGui(Player player)
    {
        Inventory inv = Bukkit.createInventory(null, 54, WordVar.JobSelectGuiName);
        ItemStack glass = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
        glass.getItemMeta().setDisplayName("");
        for(int i = 0; i < 9; i++) {
            inv.setItem(i, new ItemStack(glass));
        }

        for(int i = 45; i < 54; i++) {
            inv.setItem(i, new ItemStack(glass));
        }

        inv.setItem(10, ItemVar.BigGuyGuiItem(player));
        inv.setItem(19, ItemVar.EgisGuiItem(player));
        inv.setItem(28, ItemVar.PataiGuiItem(player));
        inv.setItem(37, ItemVar.CruiseGuiItem(player));
        inv.setItem(13, ItemVar.SaluranGuiItem(player));
        inv.setItem(22, ItemVar.FasterGuiItem(player));
        inv.setItem(31, ItemVar.BomberGuiItem(player));
        inv.setItem(40, ItemVar.KratosGuiItem(player));
        inv.setItem(16, ItemVar.ZoukGuiItem(player));
        inv.setItem(25, ItemVar.PaladinGuiItem(player));
        inv.setItem(34, ItemVar.PemanahGuiItem(player));
        player.openInventory(inv);
    }

    public static void ScienceNPCEvent(InventoryClickEvent event)
    {
        Player player = (Player)event.getWhoClicked();
        if(event.getView().getTitle().equalsIgnoreCase(WordVar.JobSelectGuiName))
        {
            event.setCancelled(true);
            if(event.getCurrentItem() == null || event.getCurrentItem().getType() == Material.AIR || !event.getCurrentItem().hasItemMeta()) {
            	return;
            }
            switch(ChatColor.stripColor(event.getCurrentItem().getItemMeta().getDisplayName())) {
            case "����" :
            	JobSelectTool.JobSelTool(player, new Bomber(player.getName()));
            	break;
            case "��ũ" :
            	JobSelectTool.JobSelTool(player, new Zouk(player.getName()));
            	break;
            case "����" :
            	JobSelectTool.JobSelTool(player, new BigGuy(player.getName()));
            	break;
            case "����" :
            	JobSelectTool.JobSelTool(player, new Saluran(player.getName()));
            	break;
            case "���⽺" :
            	JobSelectTool.JobSelTool(player, new Egis(player.getName()));
            	break;
            case "ũ�罺" :
            	JobSelectTool.JobSelTool(player, new Cruise(player.getName()));
            	break;
            case "�ȶ��" :
            	JobSelectTool.JobSelTool(player, new Paladin(player.getName()));
            	break;
            case "���" :
            	JobSelectTool.JobSelTool(player, new Pemanah(player.getName()));
            	break;
            case "��Ÿ��" :
            	JobSelectTool.JobSelTool(player, new Patai(player.getName()));
            	break;
            case "�佺Ʈ" :
            	JobSelectTool.JobSelTool(player, new Faster(player.getName()));
            	break;
            case "ũ���佺" :
            	JobSelectTool.JobSelTool(player, new Kratos(player.getName()));
            	break;
            }
        }
    }
	
}
