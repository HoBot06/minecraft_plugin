package com.ho_bot.util;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.persistence.PersistentDataType;

import com.ho_bot.LogLike.Items.LogLikeWeapon;

public class ItemUtil {
	
	public LogLikeWeapon getWeapon(ItemStack item) {
		return LogLikeWeapon.getWeapon((int) NBTUtil.getNBTTag(item, VarUtil.weaponKey, PersistentDataType.INTEGER));
	}
	
	public ItemStack getPlayerSkull(Player player) {
		ItemStack skull = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta skullMeta = (SkullMeta) skull.getItemMeta();
        skullMeta.setOwnerProfile(player.getPlayerProfile());
        skull.setItemMeta(skullMeta);
        return skull;
	}

}
