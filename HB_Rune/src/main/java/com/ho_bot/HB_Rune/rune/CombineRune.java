package com.ho_bot.HB_Rune.rune;

import java.util.ArrayList;
import java.util.List;

public class CombineRune extends Rune{

	public List<Rune> runelist = new ArrayList<>();

	public CombineRune() {};
	
	public void addRune(Rune rune) {
		runelist.add(rune);
	}
}
