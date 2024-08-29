package com.ho_bot.LogLike.Items;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;

import com.ho_bot.LogLike.Items.Weapon.TestFish;
import com.ho_bot.LogLike.Items.Weapon.TestStick;
import com.ho_bot.LogLike.Items.Weapon.testWeapon;

public class LogLikeWeapon {
	
	public final int code;
	public final Material mat;
	public final String name;
	public final double damage;
	public final int distance;
	
	public LogLikeWeapon(int code, Material mat, String name, double damage, int distance) {
		this.code = code;
		this.mat = mat;
		this.name = name;
		this.damage = damage;
		this.distance = distance;
	}
	
	public List<String> Weaponlore() {
		List<String> lore = new ArrayList<>();
		lore.add("데미지 : " + damage);
		lore.add("사거리 : " + distance);
		return lore;
	}
	
	public static LogLikeWeapon getWeapon(int code) {
		switch (code) {
		case 1: return new TestFish();
		case 2: return new TestStick();
		case 3: return new testWeapon();
		}
		return null;
	}

}
