package com.ho_bot.CNM.Gui;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

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
import com.ho_bot.CNM.Tools.UpgradeTool;
import com.ho_bot.CNM.Var.EtcVar;
import com.ho_bot.CNM.Var.ItemVar;
import com.ho_bot.CNM.Var.TeamVar;
import com.ho_bot.CNM.Var.WordVar;

public class Science
{
	@SuppressWarnings("deprecation")
	public static void ScienceGui(Player player)
    {
        Inventory inv = Bukkit.createInventory(null, 45, WordVar.ScienceGuiName);
        ItemStack glass = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
        glass.getItemMeta().setDisplayName("");
        for(int i = 0; i < 9; i++) {
            inv.setItem(i, new ItemStack(glass));
        }

        for(int i = 36; i < 45; i++) {
            inv.setItem(i, new ItemStack(glass));
        }
        
        List<UUID> Plist = RoleCount(player);
        int count=0;
        for(UUID uuid : Plist) {
        	Player uuid_player = Bukkit.getPlayer(uuid);
        	int inv_c = EtcVar.Armor_int[count];
        	ItemStack item = new ItemStack(Material.LEGACY_SKULL_ITEM, 1, (short) 3);
        	SkullMeta skull = (SkullMeta) item.getItemMeta();
        	skull.setDisplayName(ChatColor.WHITE + uuid_player.getName());
        	skull.setOwner(uuid_player.getName());
        	item.setItemMeta(skull);
        	inv.setItem(inv_c, item);
        	PArmor(inv, uuid_player, inv_c);
        	count++;
        }
        
        
        player.openInventory(inv);
    }
	
	public static void JobScienceGui(Player player)
    {
		Inventory inv = Bukkit.createInventory(null, 54, WordVar.JobScienceGuiName);
        ItemStack glass = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
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
        if(event.getView().getTitle().equalsIgnoreCase(WordVar.ScienceGuiName))
        {
            event.setCancelled(true);
            if(event.getCurrentItem() == null || event.getCurrentItem().getType() == Material.AIR || !event.getCurrentItem().hasItemMeta()) {
            	return;
            }
            List<String> lore = event.getCurrentItem().getItemMeta().getLore();
            if(event.getCurrentItem().getType()==Material.DIAMOND_CHESTPLATE || 
            		event.getCurrentItem().getType()==Material.DIAMOND_LEGGINGS || 
            		event.getCurrentItem().getType()==Material.DIAMOND_BOOTS) {
            	UpgradeTool.UpgradeArmor(player, lore.get(0), lore.get(1));
            	ScienceGui(player);
            }
            
        }
    }
    
	public static void JobScienceEvent(InventoryClickEvent event)
    {
        Player player = (Player)event.getWhoClicked();
        if(event.getView().getTitle().equalsIgnoreCase(WordVar.JobScienceGuiName))
        {
            event.setCancelled(true);
            if(event.getCurrentItem() == null || event.getCurrentItem().getType() == Material.AIR || !event.getCurrentItem().hasItemMeta()) {
            	return;
            }
            switch(ChatColor.stripColor(event.getCurrentItem().getItemMeta().getDisplayName())) {
            case "봄버" :
            	JobSelectTool.JobSelTool(player, new Bomber(player.getName()));
            	break;
            case "주크" :
            	JobSelectTool.JobSelTool(player, new Zouk(player.getName()));
            	break;
            case "빅가이" :
            	JobSelectTool.JobSelTool(player, new BigGuy(player.getName()));
            	break;
            case "살루란" :
            	JobSelectTool.JobSelTool(player, new Saluran(player.getName()));
            	break;
            case "에기스" :
            	JobSelectTool.JobSelTool(player, new Egis(player.getName()));
            	break;
            case "크루스" :
            	JobSelectTool.JobSelTool(player, new Cruise(player.getName()));
            	break;
            case "팔라딘" :
            	JobSelectTool.JobSelTool(player, new Paladin(player.getName()));
            	break;
            case "페모나" :
            	JobSelectTool.JobSelTool(player, new Pemanah(player.getName()));
            	break;
            case "파타이" :
            	JobSelectTool.JobSelTool(player, new Patai(player.getName()));
            	break;
            case "페스트" :
            	JobSelectTool.JobSelTool(player, new Faster(player.getName()));
            	break;
            case "크라토스" :
            	JobSelectTool.JobSelTool(player, new Kratos(player.getName()));
            	break;
            }
        }
    }
    
    private static List<UUID> RoleCount(Player player) {
    	List<UUID> Plist = new ArrayList<UUID>();
    	if(TeamVar.Player_Team.get(player.getUniqueId()).equals(WordVar.Santa)) {
    		for(Entry<UUID, String> entry : TeamVar.Player_Role.entrySet()) {
    			if(entry.getValue().equals(WordVar.Santa_Battle)) {
    				Plist.add(entry.getKey());
    			}
    		}
    	}
    	if(TeamVar.Player_Team.get(player.getUniqueId()).equals(WordVar.Krampus)) {
    		for(Entry<UUID, String> entry : TeamVar.Player_Role.entrySet()) {
    			if(entry.getValue().equals(WordVar.Krampus_Battle)) {
    				Plist.add(entry.getKey());
    			}
    		}
    	}
		return Plist;
    }
    
    private static Inventory PArmor(Inventory inv, Player player, int inv_c) {
    	
    	ItemStack[] armor = ItemVar.ScienceGuiItem(player);
		inv.setItem(inv_c+1, armor[0]);
		inv.setItem(inv_c+2, armor[1]);
		inv.setItem(inv_c+3, armor[2]);
    	
		return inv;
    }
	
}
