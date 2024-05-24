package com.ho_bot.Siege_Flag.Team;

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

import com.ho_bot.Siege_Flag.Util.ColorUtil;
import com.ho_bot.Siege_Flag.Util.GuiUtil;

public class TeamGui {
	
	public TeamFile TeamF = new TeamFile();
	public ColorUtil ColorU = new ColorUtil();
	public GuiUtil G = new GuiUtil();
	
	public void OpenTeamSettingListGui(Player player) {
		Inventory inv = Bukkit.createInventory(null, ((TeamF.getTeamFile().size()-1)/9)*9+9, "팀리스트");
		int loc = 0;
		for(Team team : TeamF.getTeamFile()) {
			List<String> lore = new ArrayList<String>();
			lore.add("팀색깔 : " + ColorU.returnColorName(team.TeamColor));
			lore.add("팀표시이름 : " + team.DisplayName);
			G.Stack(team.TeamName, team.TeamBlock, 1, lore, loc, inv);
			loc++;
		}
		player.openInventory(inv);
	}
	
	public void EventTeamSettingListGui(InventoryClickEvent event) {
		Player player = (Player)event.getWhoClicked();
        if(event.getView().getTitle().equalsIgnoreCase("팀리스트"))
        {
            event.setCancelled(true);
            if(event.getCurrentItem() == null || event.getCurrentItem().getType() == Material.AIR || !event.getCurrentItem().hasItemMeta()) {
            	return;
            }
            if(event.getClickedInventory().getType()==InventoryType.CHEST) {
            	ItemStack item = event.getCurrentItem();
            	if(TeamF.hasTeam(item.getItemMeta().getDisplayName())) {
            		OpenTeamSettingGui(player, item.getItemMeta().getDisplayName());
            	}
            }
        }
	}
	
	public void OpenTeamSettingGui(Player player, String TeamName) {
		Inventory inv = Bukkit.createInventory(null, 27, TeamName);
		Team team = TeamF.getTeam(TeamName);
		G.Stack(ColorU.returnChatColor(team.TeamColor)+"팀표시이름 : "+team.DisplayName, Material.NETHER_STAR, 1, Arrays.asList("클릭시 팀표시이름을 변경합니다"), 11, inv);
		G.Stack("팀블럭", team.TeamBlock, 1, Arrays.asList("바꿀 블럭을 들고 클릭시 변경됩니다"), 13, inv);
		G.Stack("팀색상", ColorU.returnBlockColor(team.TeamColor), 1, Arrays.asList("클릭시 팀색상을 선택합니다"), 15, inv);
		for(int i = 0; i < 27; i++) {
			if(inv.getItem(i)==null) {
				G.Stack(ChatColor.WHITE+"", Material.LIGHT_GRAY_STAINED_GLASS_PANE, 1, Arrays.asList(""), i, inv);
			}
		}
		player.openInventory(inv);
	}
	
	public void EventTeamSettingGui(InventoryClickEvent event) {
		Player player = (Player)event.getWhoClicked();
		if(TeamF.getTeamNameList().contains(event.getView().getTitle())) {
            if(event.getCurrentItem() == null || event.getCurrentItem().getType() == Material.AIR || !event.getCurrentItem().hasItemMeta()) {
            	return;
            }
            if(event.getClickedInventory().getType()==InventoryType.CHEST) {
            	event.setCancelled(true);
            	String TeamName = event.getView().getTitle();
            	if(event.getSlot()==11) {
            		player.closeInventory();
            		TeamVar.TeamSettingDisplay.put(player.getUniqueId(), true);
            		TeamVar.TeamSelect.put(player.getUniqueId(), TeamName);
            		player.sendMessage(ChatColor.GREEN+"채팅에 입력시 설정이 됩니다");
            		player.sendMessage(ChatColor.GREEN+"(취소시 Cancel 을 입력하시면 됩니다)");
            	}
				if(event.getSlot()==13) {
					if(event.getCursor()!=null) {
						Team team = TeamF.getTeam(TeamName);
						TeamF.addTeamFile(team.TeamName, team.DisplayName, team.TeamColor, event.getCursor().getType());
						event.setCursor(new ItemStack(Material.AIR));
						OpenTeamSettingGui(player, TeamName);
					}
				}
				if(event.getSlot()==15) {
					OpenTeamColor(player, TeamName);
				}
            }
		}
	}
	
	public void OpenTeamColor(Player player, String TeamName) {
		Inventory inv = Bukkit.createInventory(null, 27, TeamName+"-팀색상");
		Team team = TeamF.getTeam(TeamName);
		for(int i = 0; i < 7; i++) {
			String color = ColorU.ColorList().get(i);
			String colorname = ColorU.returnColorName(color);
			String sel = "";
			if(team.TeamColor.equalsIgnoreCase(color)) {
				sel = sel + ChatColor.GREEN + " [선택됨]";
			}
			G.Stack(ColorU.returnChatColor(color)+colorname+sel, ColorU.returnBlockColor(color), 1, Arrays.asList("클릭시 "+colorname+"으로 색상을 변경합니다"), 10+i, inv);
		}
		player.openInventory(inv);
	}
	
	public void EventTeamColorGui(InventoryClickEvent event) {
		Player player = (Player)event.getWhoClicked();
		for(String teamname : TeamF.getTeamNameList()) {
			if(event.getView().getTitle().equalsIgnoreCase(teamname+"-팀색상")) {
				event.setCancelled(true);
	            if(event.getCurrentItem() == null || event.getCurrentItem().getType() == Material.AIR || !event.getCurrentItem().hasItemMeta()) {
	            	return;
	            }
	            if(event.getClickedInventory().getType()==InventoryType.CHEST) {
	            	String color = ColorU.ColorList().get(event.getSlot()-10);
	            	Team team = TeamF.getTeam(teamname);
	            	TeamF.addTeamFile(team.TeamName, team.DisplayName, color, team.TeamBlock);
	            	OpenTeamColor(player, teamname);
	            }
			}
		}
	}
	
	
}
