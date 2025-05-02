package com.ho_bot.ApiGame.classes;

import java.util.List;

public class BoardClass {
	
	public final String title;
	public List<String> lore;
	
	public int complete_dia;
	public int remain_dia;
	
	public BoardClass(String title, List<String> lore) {
		this.title = title;
		this.lore = lore;
	}

}
