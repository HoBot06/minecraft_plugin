package com.ho_bot.HoEatAll.util;

import org.bukkit.Bukkit;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.components.FoodComponent;

public class ItemUtil {
	
	public ItemStack setFood(ItemStack item, boolean canAlwaysEat, float saturation, int nutrition, float second) {
		String component = item.getItemMeta().getAsComponentString();
		component = component.substring(1, component.length()-1);
		if(component!="") {
			component = component+",";
		}
		ItemStack consume = 
				Bukkit.getItemFactory().createItemStack(item.getType().name().toLowerCase()+"["+component+
						"consumable={consume_seconds:"+second+",animation:\"eat\"}]");
		ItemMeta item_m = consume.getItemMeta();
		FoodComponent foodComponent = item_m.getFood();
		foodComponent.setCanAlwaysEat(canAlwaysEat);
		foodComponent.setSaturation(saturation);
		foodComponent.setNutrition(nutrition);
		item_m.setFood(foodComponent);
		consume.setItemMeta(item_m);
		consume.setAmount(item.getAmount());
		return consume;
	}

}
