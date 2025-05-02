package com.ho_bot.ApiGame.util;

import com.ho_bot.ApiGame.classes.BoardClass;
import com.ho_bot.ApiGame.classes.board.ApiGameConfig;
import com.ho_bot.ApiGame.classes.board.diaBoard;

public class VarUtil {
	
	public static ApiGameConfig apiGameConfig; 
	public static diaBoard dia_Board;
	
	public static BoardClass nowBoard;
	
	public static boolean turnBoard = false;
	
	public static enum GameType{
		DiaGame("다이아게임");
		
		private final String string;

		GameType(String string) {
	        this.string = string;
	    }

	    public String getString() {
	        return string;
	    }
	    
	    public static GameType fromString(String text) {
	        for (GameType type : GameType.values()) {
	            if (type.string.equals(text)) {
	                return type;
	            }
	        }
	        return null;
	    }
	}
	
	public static enum DiaSubmitType{
		RightClick("우클릭"),
		Drop("버리기");
		
		private final String string;

		DiaSubmitType(String string) {
	        this.string = string;
	    }

	    public String getString() {
	        return string;
	    }
	    
	    public static DiaSubmitType fromString(String text) {
	        for (DiaSubmitType type : DiaSubmitType.values()) {
	            if (type.string.equals(text)) {
	                return type;
	            }
	        }
	        return null;
	    }
	}
}
