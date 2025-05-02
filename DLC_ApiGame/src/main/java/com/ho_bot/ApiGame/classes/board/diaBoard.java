package com.ho_bot.ApiGame.classes.board;

import java.util.List;

import com.ho_bot.ApiGame.classes.BoardClass;
import com.ho_bot.ApiGame.util.VarUtil.DiaSubmitType;

public class diaBoard extends BoardClass{
	
	public boolean isSubmit = false;
	public DiaSubmitType type;
	
	public diaBoard(String title, List<String> lore) {
		super(title, lore);
	}

}
