package septagram.Theomachy.Handler.CommandModule;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import septagram.Theomachy.Ability.Ability;
import septagram.Theomachy.DB.GameData;

public class Help {

	public static void Module(CommandSender sender, Command command, String label, String[] data)
	{
		String playerName=sender.getName();
		Ability ability=GameData.PlayerAbility.get(playerName);
		if (ability != null)
		{
			Inventory i=Bukkit.createInventory(null, 18, ChatColor.BLACK+":::::::: �ɷ� ���� ::::::::");
			ItemStack abname=new ItemStack(Material.ITEM_FRAME);
			ItemStack abdes=new ItemStack(Material.BOOK);
			ItemStack abcool1=new ItemStack(Material.CLOCK);
			ItemStack abcool2=new ItemStack(Material.CLOCK);
			ItemStack rank = new ItemStack(Material.AIR);
			
			ItemMeta a=abname.getItemMeta();
			ItemMeta b=abdes.getItemMeta();
			ItemMeta c=abcool1.getItemMeta();
			ItemMeta d=abcool2.getItemMeta();
			ItemMeta e=rank.getItemMeta();
			
			a.setDisplayName(ChatColor.AQUA+"���ɷ� �̸��� "+ChatColor.WHITE+ability.abilityName);
			b.setDisplayName(ChatColor.DARK_AQUA+"���ɷ� ����");
			
			List<String> blore=new ArrayList<String>();
			for(int j=0;j<ability.description.length;j++) {
				blore.add(ChatColor.WHITE+ability.description[j]);
			}
			b.setLore(blore);
			
			abname.setItemMeta(a);
			abdes.setItemMeta(b);
		
			switch(ability.rank) {
			case -1:
				rank=new ItemStack(Material.ROTTEN_FLESH);
				e=rank.getItemMeta();
				e.setDisplayName("��ũ: "+ChatColor.GRAY+"F");
				rank.setItemMeta(e);
				break;
			case 1:
				rank=new ItemStack(Material.IRON_INGOT);
				e=rank.getItemMeta();
				e.setDisplayName("��ũ: "+ChatColor.WHITE+"C");
				rank.setItemMeta(e);
				break;
			case 2:
				rank=new ItemStack(Material.GOLD_INGOT);
				e=rank.getItemMeta();
				e.setDisplayName("��ũ: "+ChatColor.GREEN+"B");
				rank.setItemMeta(e);
				break;
			case 3:
				rank=new ItemStack(Material.EMERALD);
				e=rank.getItemMeta();
				e.setDisplayName("��ũ: "+ChatColor.AQUA+"A");
				rank.setItemMeta(e);
				break;
			case 4:
				rank=new ItemStack(Material.DIAMOND);
				e=rank.getItemMeta();
				e.setDisplayName("��ũ: "+ChatColor.YELLOW+"S");
				rank.setItemMeta(e);
				break;
			}
			
			i.setItem(4, abname);
			i.setItem(0, abdes);
			i.setItem(8, rank);
			
			if(ability.activeType) {
				if(ability.cool2!=-1) {
					abcool1=new ItemStack(Material.CLOCK);
					abcool2=new ItemStack(Material.CLOCK);					
					
					List<String> clore=new ArrayList<String>();
					c.setDisplayName(ChatColor.GREEN+"~ �Ϲ� �ɷ� ~");
					clore.add( ChatColor.WHITE+"��Ÿ��: "+ability.cool1+" �� �ҿ�");
					clore.add(ChatColor.WHITE+"���൹: "+ability.sta1+"�� �Ҹ�");
					
					c.setLore(clore);
					abcool1.setItemMeta(c);
					
					List<String> dlore=new ArrayList<String>();
					d.setLore(null);
					d.setDisplayName(ChatColor.YELLOW+"~ ��� �ɷ� ~");
					dlore.add(ChatColor.WHITE+"��Ÿ��: "+ability.cool2+" �� �ҿ�");
					dlore.add(ChatColor.WHITE+"���൹: "+ability.sta2+"�� �Ҹ�");
					
					d.setLore(dlore);
					abcool2.setItemMeta(d);
					
					i.setItem(9, abcool1);
					i.setItem(17, abcool2);
					
				}else {
					abcool1=new ItemStack(Material.CLOCK);
					
					List<String> clore=new ArrayList<String>();
					c.setDisplayName(ChatColor.GREEN+"~ �Ϲ� �ɷ� ~");
					clore.add(ChatColor.WHITE+"��Ÿ��: "+ability.cool1+" �� �ҿ�");
					clore.add(ChatColor.WHITE+"���൹: "+ability.sta1+"�� �Ҹ�");
					c.setLore(clore);
					
					abcool1.setItemMeta(c);
					
					i.setItem(13, abcool1);
				}
			}if (!ability.activeType && ability.passiveType) {
				abcool1=new ItemStack(Material.CLOCK);
				
				List<String> clore=new ArrayList<String>();
				c.setDisplayName(ChatColor.GREEN+"~ �нú� �ɷ� ~");
				clore.add(ChatColor.WHITE+"�ɷ� ������ Ȯ���ϼ���.");
				c.setLore(clore);
				
				abcool1.setItemMeta(c);
				
				i.setItem(13, abcool1);
			}
			
			Player p=(Player)sender;
			
			p.openInventory(i);
			
		}
		else
			sender.sendMessage("�ɷ��� �����ϴ�.");
	}


}
