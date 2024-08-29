package com.ho_bot.LogLike.Enemy.Skill;

import org.bukkit.Material;

public class ZombieAttack extends LogLikeEnemySkill{
	
	private static final Material mat = Material.WOODEN_SWORD;
	private static final String name = "좀비어택";
	
	public ZombieAttack() {
		super(mat, name);
	}

}
