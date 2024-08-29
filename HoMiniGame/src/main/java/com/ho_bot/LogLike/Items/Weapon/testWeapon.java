package com.ho_bot.LogLike.Items.Weapon;

import org.bukkit.Material;

import com.ho_bot.LogLike.Items.LogLikeWeapon;

public class testWeapon extends LogLikeWeapon{
	
	private static final int code = 3;
	private static final Material mat = Material.STONE_SWORD;
	private static final String name = "테스트 돌검";
	private static final double damage = 3;
	private static final int distance = 3;

	public testWeapon() {
		super(code, mat, name, damage, distance);
	}

}
