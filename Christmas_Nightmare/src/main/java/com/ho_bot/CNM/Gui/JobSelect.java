package com.ho_bot.CNM.Gui;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class JobSelect
{
	public static void JobSelectGui(Player player)
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

    public static void JobSelectEvent(InventoryClickEvent event)
    {
        Player player = (Player)event.getWhoClicked();
        if(event.getView().getTitle().equalsIgnoreCase("\uB2A5\uB825\uC120\uD0DD"))
        {
            event.setCancelled(true);
            if(event.getCurrentItem() == null || event.getCurrentItem().getType() == Material.AIR || !event.getCurrentItem().hasItemMeta())
                return;
            String s;
            switch((s = ChatColor.stripColor(event.getCurrentItem().getItemMeta().getDisplayName())).hashCode())
            {
            default:
                break;

            case 1548288: 
                if(s.equals("\uBD04\uBC84"))
                    JobSelectTool.JobSelTool(player, new Bomber(player.getName()));
                break;

            case 1648368: 
                if(s.equals("\uC8FC\uD06C"))
                    JobSelectTool.JobSelTool(player, new Zouk(player.getName()));
                break;

            case 48225401: 
                if(s.equals("\uBE45\uAC00\uC774"))
                    JobSelectTool.JobSelTool(player, new BigGuy(player.getName()));
                break;

            case 48922444: 
                if(s.equals("\uC0B4\uB8E8\uB780"))
                    JobSelectTool.JobSelTool(player, new Saluran(player.getName()));
                break;

            case 50097220: 
                if(s.equals("\uC5D0\uAE30\uC2A4"))
                    JobSelectTool.JobSelTool(player, new Egis(player.getName()));
                break;

            case 52792360: 
                if(s.equals("\uD06C\uB8E8\uC2A4"))
                    JobSelectTool.JobSelTool(player, new Cruise(player.getName()));
                break;

            case 53431088: 
                if(s.equals("\uD314\uB77C\uB518"))
                    JobSelectTool.JobSelTool(player, new Paladin(player.getName()));
                break;

            case 53581960: 
                if(s.equals("\uD398\uBAA8\uB098"))
                    JobSelectTool.JobSelTool(player, new Pemanah(player.getName()));
                break;

            case 53628608: 
                if(s.equals("\uD30C\uD0C0\uC774"))
                    JobSelectTool.JobSelTool(player, new Patai(player.getName()));
                break;

            case 53654060: 
                if(s.equals("\uD398\uC2A4\uD2B8"))
                    JobSelectTool.JobSelTool(player, new Faster(player.getName()));
                break;

            case 1636382100: 
                if(s.equals("\uD06C\uB77C\uD1A0\uC2A4"))
                    JobSelectTool.JobSelTool(player, new Kratos(player.getName()));
                break;
            }
            return;
        } else
        {
            return;
        }
    }
}
