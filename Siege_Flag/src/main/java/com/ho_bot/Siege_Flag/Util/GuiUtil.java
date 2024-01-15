package com.ho_bot.Siege_Flag.Util;

import java.util.List;

import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GuiUtil {
	
	public void Stack(String Display, Material material, int STACK, List<String> lore, int loc, Inventory inv) {
		
		ItemStack item = new ItemStack(material, STACK);
		ItemMeta item_Meta = item.getItemMeta();
		item_Meta.setDisplayName(Display);
		item_Meta.setLore(lore);
		item.setItemMeta(item_Meta);
		inv.setItem(loc, item);
	}

}
