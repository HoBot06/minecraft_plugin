package com.ho_bot.ApiGame.util;

import java.util.HashMap;
import java.util.Map;

import com.ho_bot.ApiGame.classes.BoardClass;
import com.ho_bot.ApiGame.classes.RoulClass;
import com.ho_bot.ApiGame.classes.board.ApiGameConfig;
import com.ho_bot.ApiGame.classes.board.diaBoard;
import com.ho_bot.dlc.DLC_Donation;

public class VarUtil {
	
	public static ApiGameConfig apiGameConfig; 
	public static diaBoard dia_Board;
	
	public static BoardClass nowBoard;
	
	public static boolean turnBoard = false;
	
	public static HashMap<String, RoulClass> roulMap = new HashMap<>();
	
	public static Map<String, DLC_Donation> apidlclist = new HashMap<>();
	
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
	
	public static enum RoulType{
		Diamond("다이아"),
		Monster("몬스터"),
		Buff("버프"),
		Command("커맨드");
		
		private final String string;

		RoulType(String string) {
	        this.string = string;
	    }

	    public String getString() {
	        return string;
	    }
	    
	    public static RoulType fromString(String text) {
	        for (RoulType type : RoulType.values()) {
	            if (type.string.equals(text)) {
	                return type;
	            }
	        }
	        return null;
	    }
	}
}
