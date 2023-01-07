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
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import com.ho_bot.CNM.Tools.UpgradeTool;
import com.ho_bot.CNM.Utility.JobListUtil;
import com.ho_bot.CNM.Var.EtcVar;
import com.ho_bot.CNM.Var.ItemVar;
import com.ho_bot.CNM.Var.TeamVar;
import com.ho_bot.CNM.Var.WordVar;

public class Science
{
	
	public static void ChoiceGui(Player player)
    {
        Inventory inv = Bukkit.createInventory(null, 27, WordVar.ChoiceGuiName);
        ItemStack glass = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
        glass.getItemMeta().setDisplayName("");
        for(int i = 0; i < 9; i++) {
            inv.setItem(i, new ItemStack(glass));
        }

        for(int i = 18; i < 27; i++) {
            inv.setItem(i, new ItemStack(glass));
        }
        ItemStack Job = new ItemStack(Material.NETHER_STAR);
        ItemMeta Job_M = Job.getItemMeta();
        Job_M.setDisplayName(ChatColor.WHITE + "능력 업그레이드");
        Job.setItemMeta(Job_M);
        
        ItemStack Armor = new ItemStack(Material.DIAMOND_CHESTPLATE);
        ItemMeta Armor_M = Armor.getItemMeta();
        Armor_M.setDisplayName(ChatColor.WHITE + "갑옷 업그레이드");
        Armor.setItemMeta(Armor_M);
        
        inv.setItem(12, Job);
        inv.setItem(14, Armor);
        
        player.openInventory(inv);
    }
	
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

        inv.setItem(10, ItemVar.BigGuyChoiceGuiItem(player));
        inv.setItem(19, ItemVar.EgisChoiceGuiItem(player));
        inv.setItem(28, ItemVar.PataiChoiceGuiItem(player));
        inv.setItem(37, ItemVar.CruiseChoiceGuiItem(player));
        inv.setItem(13, ItemVar.SaluranChoiceGuiItem(player));
        inv.setItem(22, ItemVar.FasterChoiceGuiItem(player));
        inv.setItem(31, ItemVar.BomberChoiceGuiItem(player));
        inv.setItem(40, ItemVar.KratosChoiceGuiItem(player));
        inv.setItem(16, ItemVar.ZoukChoiceGuiItem(player));
        inv.setItem(25, ItemVar.PaladinChoiceGuiItem(player));
        inv.setItem(34, ItemVar.PemanahChoiceGuiItem(player));
        
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
	
    public static void ChoiceNPCEvent(InventoryClickEvent event)
    {
        Player player = (Player)event.getWhoClicked();
        if(event.getView().getTitle().equalsIgnoreCase(WordVar.ChoiceGuiName))
        {
            event.setCancelled(true);
            if(event.getCurrentItem() == null || event.getCurrentItem().getType() == Material.AIR || !event.getCurrentItem().hasItemMeta()) {
            	return;
            }
            switch(ChatColor.stripColor(event.getCurrentItem().getItemMeta().getDisplayName())) {
            case "능력 업그레이드" :
            	JobScienceGui(player);
            	break;
            case "갑옷 업그레이드" :
            	ScienceGui(player);
            	break;
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
            case JobListUtil.Bomber :
            	UpgradeTool.UpgradeJob(player, JobListUtil.Bomber);
            	break;
            case JobListUtil.Zouk :
            	UpgradeTool.UpgradeJob(player, JobListUtil.Zouk);
            	break;
            case JobListUtil.BigGuy :
            	UpgradeTool.UpgradeJob(player, JobListUtil.BigGuy);
            	break;
            case JobListUtil.Saluran :
            	UpgradeTool.UpgradeJob(player, JobListUtil.Saluran);
            	break;
            case JobListUtil.Egis :
            	UpgradeTool.UpgradeJob(player, JobListUtil.Egis);
            	break;
            case JobListUtil.Cruise :
            	UpgradeTool.UpgradeJob(player, JobListUtil.Cruise);
            	break;
            case JobListUtil.Paladin :
            	UpgradeTool.UpgradeJob(player, JobListUtil.Paladin);
            	break;
            case JobListUtil.Pemanah :
            	UpgradeTool.UpgradeJob(player, JobListUtil.Pemanah);
            	break;
            case JobListUtil.Patai :
            	UpgradeTool.UpgradeJob(player, JobListUtil.Patai);
            	break;
            case JobListUtil.Faster :
            	UpgradeTool.UpgradeJob(player, JobListUtil.Faster);
            	break;
            case JobListUtil.Kratos :
            	UpgradeTool.UpgradeJob(player, JobListUtil.Kratos);
            	break;
            }
            JobScienceGui(player);
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
