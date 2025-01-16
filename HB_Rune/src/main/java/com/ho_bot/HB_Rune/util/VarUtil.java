package com.ho_bot.HB_Rune.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.ho_bot.HB_Rune.rune.CombineRune;
import com.ho_bot.HB_Rune.rune.Rune;

public class VarUtil {
	
	public static HashMap<UUID, CombineRune> player_rune = new HashMap<>();
	public static HashMap<UUID, Integer> player_cool = new HashMap<>();
	public static List<Rune> runelist = new ArrayList<>();
	
	public enum RuneType{
		Active,
		Passive,
		Power;
	}
	//공격력증가(근접공격)/마력증가(원거리공격)/보스공격력/일반몹 공격력/크리티컬 증가/ 버프시간증가/체력증가.?.
	public enum AbilityType{
		//발화관련
		Timer("타이머"),
		giveDamage("데미지줌"),
		takeDamage("데미지받음"),
		LeftClick("좌클릭"),
		RightClick("우클릭"),
		KillEntity("킬"),
		DeathPlayer("죽을시"),
		//파워관련
		Potion("포션"),
		Exp("경험치"),
		Damage("데미지"),
		Crit("치명타"),
		Heal("회복"),
		
		mythicExp("미몹경험치");
		
		private static final Map<String, AbilityType> abilityMap = 
				Stream.of(values()).collect(Collectors.toMap(AbilityType::toString, Function.identity()));

		private final String string;

		AbilityType(String string) {
	        this.string = string;
	    }

	    public String toString() {
	        return string;
	    }
	    
	    public static AbilityType valueOfName(String name) {
	    	return abilityMap.get(name);
	    }
	}

}
