package com.ho_bot.Siege_Flag.Area;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import com.ho_bot.Siege_Flag.Team.Team;
import com.ho_bot.Siege_Flag.Team.TeamVar;
import com.ho_bot.Siege_Flag.Util.GuiUtil;

public class AreaGui {
	
	public GuiUtil G = new GuiUtil();
	public AreaFile AreaF = new AreaFile();
	
	public void OpenAreaSettingList(Player player) {
		Inventory inv = Bukkit.createInventory(null, ((AreaF.getAreaFile().size()-1)/9)*9+9, "구역리스트");
		int loc = 0;
		for(Area area : AreaF.getAreaFile()) {
			List<String> lore = new ArrayList<String>();
			lore.add(ChatColor.GRAY+"Pos1 : [" + area.AreaLoc1.getX() + ", " + area.AreaLoc1.getY() + ", " + area.AreaLoc1.getZ() + "]");
			lore.add(ChatColor.GRAY+"Pos2 : [" + area.AreaLoc2.getX() + ", " + area.AreaLoc2.getY() + ", " + area.AreaLoc2.getZ() + "]");
			G.Stack(area.AreaName, area.AreaBlock, 1, lore, loc, inv);
			loc++;
		}
		player.openInventory(inv);
	}
	
	//클릭시 블럭변경, 삭제 o,x만 추가하면 될듯
	public void EventAreaSettingListGui(InventoryClickEvent event) {
		Player player = (Player)event.getWhoClicked();
        if(event.getView().getTitle().equalsIgnoreCase("구역리스트"))
        {
            event.setCancelled(true);
            if(event.getCurrentItem() == null || event.getCurrentItem().getType() == Material.AIR || !event.getCurrentItem().hasItemMeta()) {
            	return;
            }
            if(event.getClickedInventory().getType()==InventoryType.CHEST) {
            	ItemStack item = event.getCurrentItem();
            	if(AreaF.hasArea(ChatColor.stripColor(item.getItemMeta().getDisplayName()))) {
            		Area area = AreaF.getArea(ChatColor.stripColor(item.getItemMeta().getDisplayName()));
            		OpenAreaGui(player, area);
            	}
            }
        }
	}
	
	public void OpenAreaGui(Player player, Area area) {
		Inventory inv = Bukkit.createInventory(null, 27, area.AreaName+" 구역설정");
		G.Stack("점령 블럭", area.AreaBlock, 1, Arrays.asList("블럭을 들고 클릭시 변경됩니다"), 11, inv);
		G.Stack(ChatColor.RED+"삭제하기", Material.BARRIER, 1, Arrays.asList("더블클릭시 구역이 삭제됩니다"), 15, inv);
		player.openInventory(inv);
	}
	
	public void EventAreaGui(InventoryClickEvent event) {
		for(String name : AreaVar.getAreaNameList()) {
			if(event.getView().getTitle().equalsIgnoreCase(name+" 구역설정"))
	        {
	            event.setCancelled(true);
	            if(event.getCurrentItem() == null || event.getCurrentItem().getType() == Material.AIR || !event.getCurrentItem().hasItemMeta()) {
	            	return;
	            }
	            if(event.getClickedInventory().getType()==InventoryType.CHEST) {
	            	if(event.getSlot()==11) {
	            		if(event.getCursor().getType()!=null) {
	            			Area area = AreaF.getArea(name);
	            			AreaF.fixArea(area.AreaName, event.getCursor().getType(), area.AreaLoc1, area.AreaLoc2);
	            		}
	            	}
	            	if(event.getSlot()==15) {
	            		AreaF.removeAreaList(name);
	            	}
	            }
	        }
		}
	}

}
