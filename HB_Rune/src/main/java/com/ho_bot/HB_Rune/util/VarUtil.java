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
	public static List<Rune> runelist = new ArrayList<>();
	
	public enum RuneType{
		Active,
		Passive,
		Power;
	}
	
	public enum AbilityType{
		//발화관련
		giveDamage("데미지줌"),
		takeDamage("데미지받음"),
		LeftClick("좌클릭"),
		RightClick("우클릭"),
		//파워관련
		Potion("포션");
		
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
