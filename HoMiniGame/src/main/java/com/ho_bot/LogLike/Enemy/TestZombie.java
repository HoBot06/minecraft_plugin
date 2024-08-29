package com.ho_bot.LogLike.Enemy;

import org.bukkit.Material;

import com.ho_bot.LogLike.Enemy.Skill.ZombieAttack;

public class TestZombie extends LogLikeEnemy{
	
	private static final String name = "테스트좀비";
	private static final Material mat = Material.ZOMBIE_HEAD;
	

	public TestZombie() {
		super(name, mat);
		
		this.health = 20;
		this.attack = 3;
		
		this.skillMap.put(1, new ZombieAttack());
	}

}
