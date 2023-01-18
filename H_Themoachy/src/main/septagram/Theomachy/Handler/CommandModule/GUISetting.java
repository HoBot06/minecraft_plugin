package septagram.Theomachy.Handler.CommandModule;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import septagram.Theomachy.Theomachy;
import septagram.Theomachy.Utility.PermissionChecker;

public class GUISetting {
	
	public static void Module(CommandSender sender) {
		
		Player p=(Player)sender;
		
		if(PermissionChecker.Sender(sender)) {
			if(!GameHandler.Ready && !GameHandler.Start) {
				
				p.openInventory(gui());
				
			}else {
				sender.sendMessage(ChatColor.RED+"【경고】 "+ChatColor.WHITE+"게임이 준비 중이거나 게임이 시작된 이후에는 설정을 건드릴 수 없습니다.");
			}
		}
	}
	
	private static Inventory gui() {
		
		Inventory gui=Bukkit.createInventory(null, 18, ChatColor.BLACK+":::::: 설정 ::::::");
		
		final int n=8;
		
		ItemStack[] wool=new ItemStack[n];
		ItemMeta[] meta=new ItemMeta[n];

		wool[0]=new ItemStack(Theomachy.INVENTORY_CLEAR ? Material.LIME_WOOL:Material.RED_WOOL);
		wool[1]=new ItemStack(Theomachy.GIVE_ITEM ? Material.LIME_WOOL:Material.RED_WOOL);
		wool[2]=new ItemStack(Theomachy.ENTITIES_REMOVE ? Material.LIME_WOOL:Material.RED_WOOL);
		wool[3]=new ItemStack(Theomachy.IGNORE_BED ? Material.LIME_WOOL:Material.RED_WOOL);
		wool[4]=new ItemStack(Theomachy.FAST_START ? Material.LIME_WOOL:Material.RED_WOOL);
		wool[5]=new ItemStack(Theomachy.AUTO_SAVE ? Material.LIME_WOOL:Material.RED_WOOL);
		wool[6]=new ItemStack(Theomachy.ANIMAL  ? Material.LIME_WOOL:Material.RED_WOOL);
		wool[7]=new ItemStack(Theomachy.MONSTER  ? Material.LIME_WOOL:Material.RED_WOOL);
		
		for(int i=0;i<n;i++) {
			meta[i]=wool[i].getItemMeta();
		}
		
		meta[0].setDisplayName(ChatColor.WHITE+"게임 시작 시 인벤토리 클리어");
		meta[1].setDisplayName(ChatColor.WHITE+"게임 시작 시 스카이블럭 아이텝 지급");
		meta[2].setDisplayName(ChatColor.WHITE+"게임 시작 시 엔티티 제거");
		meta[3].setDisplayName(ChatColor.WHITE+"침대 무시");
		meta[4].setDisplayName(ChatColor.WHITE+"빠른 시작");
		meta[5].setDisplayName(ChatColor.WHITE+"서버 자동 저장");
		meta[6].setDisplayName(ChatColor.WHITE+"동물 스폰");
		meta[7].setDisplayName(ChatColor.WHITE+"몬스터 스폰");
		
		for(int i=0;i<n;i++) {
			wool[i].setItemMeta(meta[i]);
		}
		
		gui.setItem(1, wool[0]);
		gui.setItem(3, wool[1]);
		gui.setItem(5, wool[2]);
		gui.setItem(7, wool[3]);
		gui.setItem(10, wool[4]);
		gui.setItem(12, wool[5]);
		gui.setItem(14, wool[6]);
		gui.setItem(16, wool[7]);
		
		return gui;
	}
	
}
