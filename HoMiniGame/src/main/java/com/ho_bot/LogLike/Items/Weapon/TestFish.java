package com.ho_bot.LogLike.Items.Weapon;

import org.bukkit.Material;

import com.ho_bot.LogLike.Items.LogLikeWeapon;

public class TestFish extends LogLikeWeapon{
	
	private static final int code = 1;
	private static final Material mat = Material.FISHING_ROD;
	private static final String name = "테스트 낚시대";
	private static final double damage = 1;
	private static final int distance = 4;

	public TestFish() {
		super(code, mat, name, damage, distance);
	}

}
