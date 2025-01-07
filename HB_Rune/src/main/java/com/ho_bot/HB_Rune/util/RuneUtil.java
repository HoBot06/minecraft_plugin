package com.ho_bot.HB_Rune.util;

import java.util.UUID;

import com.ho_bot.HB_Rune.rune.CombineRune;
import com.ho_bot.HB_Rune.rune.Rune;

public class RuneUtil {
	
	public Rune getRune(String id) {
		for(Rune rune : VarUtil.runelist) {
			if(rune.id.equalsIgnoreCase(id)) return rune;
		}
		return null;
	}
	
	public CombineRune getPlayerRune(UUID playeruuid) {
		return VarUtil.player_rune.get(playeruuid);
	}
	
}
