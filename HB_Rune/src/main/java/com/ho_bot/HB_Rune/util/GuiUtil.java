package com.ho_bot.HB_Rune.util;

import java.util.List;

import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GuiUtil {
	
	public void Stack(String Display, Material material, int STACK, List<String> lore, int loc, Inventory inv) {
		
		ItemStack item = new ItemStack(material);
		item.setAmount(STACK);
		ItemMeta item_Meta = item.getItemMeta();
		item_Meta.setDisplayName(Display);
		item_Meta.setLore(lore);
		item.setItemMeta(item_Meta);
		inv.setItem(loc, item);
	}
	
	public void Stack(String Display, Material material, boolean unbreakable, int STACK, List<String> lore, int loc, Inventory inv) {
		
		ItemStack item = new ItemStack(material);
		item.setAmount(STACK);
		ItemMeta item_Meta = item.getItemMeta();
		item_Meta.setDisplayName(Display);
		item_Meta.setLore(lore);
		item_Meta.setUnbreakable(unbreakable);
		item.setItemMeta(item_Meta);
		inv.setItem(loc, item);
	}
	
	public void Stack(ItemStack item, int loc, Inventory inv) {
		inv.setItem(loc, item);
	}
	
	public int getPages(String invName) {
		String[] s = invName.split(" ");
		return Integer.parseInt(s[1]);
	}

}
