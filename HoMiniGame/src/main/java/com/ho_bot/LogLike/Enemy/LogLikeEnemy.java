package com.ho_bot.LogLike.Enemy;

import java.util.HashMap;

import org.bukkit.Material;

import com.ho_bot.LogLike.Enemy.Skill.LogLikeEnemySkill;

public class LogLikeEnemy {
	
	public final String name;
	public final Material mat;
	
	public double health;
	public double attack;
	public HashMap<Integer, LogLikeEnemySkill> skillMap = new HashMap<>();
	
	public LogLikeEnemy(String name, Material mat) {
		this.name = name;
		this.mat = mat;
	}

}
