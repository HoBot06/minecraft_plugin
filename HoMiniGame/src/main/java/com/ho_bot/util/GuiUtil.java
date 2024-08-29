package com.ho_bot.util;

import java.util.List;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.tags.CustomItemTagContainer;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import com.ho_bot.LogLike.Enemy.Skill.LogLikeEnemySkill;
import com.ho_bot.LogLike.Items.LogLikeWeapon;
import com.ho_bot.main.HoMiniGame;

public class GuiUtil {
	
	public void Stack(String Display, Material mat, int STACK, List<String> lore, int loc, Inventory inv) {
		ItemStack item = new ItemStack(mat);
		ItemMeta item_Meta = item.getItemMeta();
		item_Meta.setDisplayName(Display);
		item_Meta.setLore(lore);
		item.setItemMeta(item_Meta);
		inv.setItem(loc, item);
	}
	
	public void Stack(LogLikeWeapon weapon, int loc, Inventory inv) {
		ItemStack item = new ItemStack(weapon.mat);
		NBTUtil.setNBTTag(item, VarUtil.weaponKey, weapon.code);
		ItemMeta item_Meta = item.getItemMeta();
		item_Meta.setDisplayName(weapon.name);
		item_Meta.setLore(weapon.Weaponlore());
		item.setItemMeta(item_Meta);
		inv.setItem(loc, item);
	}
	
	public void Stack(LogLikeEnemySkill skill, int loc, Inventory inv) {
		ItemStack item = new ItemStack(skill.mat);
		ItemMeta item_Meta = item.getItemMeta();
		item_Meta.setDisplayName(skill.name);
		//item_Meta.setLore(skill.Weaponlore());
		//NBTUtil.setNBTTag(item, VarUtil.weaponKey, skill.code);
		item.setItemMeta(item_Meta);
		inv.setItem(loc, item);
	}
	
	public void Stack(ItemStack item, int loc, Inventory inv) {
		inv.setItem(loc, item);
	}
	
	public void Stack(String Display, ItemStack item, List<String> lore, int loc, Inventory inv) {
		ItemMeta item_m = item.getItemMeta();
		item_m.setDisplayName(Display);
		item_m.setLore(lore);
		item.setItemMeta(item_m);
		inv.setItem(loc, item);
	}
	
	public int getPlayerHead(Inventory inv, int min, int max) {
		for(int i = min; i <= max; i++) {
			if(inv.getItem(i)!=null) {
				if(inv.getItem(i).getType()==Material.PLAYER_HEAD) {
					return i;
				}
			}
		}
		return -1;
	}

}
