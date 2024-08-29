package com.ho_bot.LogLike.Items.Weapon;

import org.bukkit.Material;

import com.ho_bot.LogLike.Items.LogLikeWeapon;

public class TestStick extends LogLikeWeapon{
	
	private static final int code = 2;
	private static final Material mat = Material.STICK;
	private static final String name = "테스트 막대기";
	private static final double damage = 1;
	private static final int distance = 2;

	public TestStick() {
		super(code, mat, name, damage, distance);
	}

}
