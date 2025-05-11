package com.ho_bot.ApiGame.classes;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.concurrent.ThreadLocalRandom;

import com.ho_bot.ApiGame.classes.roul.RoulChat;
import com.ho_bot.ApiGame.classes.roul.RoulTitle;
import com.ho_bot.ApiGame.classes.roul.RoulList;

public class RoulClass {
	
	public HashMap<Integer, RoulList> roulMap;
	public RoulTitle r_title;
	public RoulChat r_chat;
	
	public int getRandAllNum() {
		int count = 0;
		for(Entry<Integer, RoulList> entry : roulMap.entrySet()) {
			count+=entry.getValue().percent;
		}
		return count;
	}

	public RoulList getRandRoul() {
		int rand = getRandAllNum();
		rand = ThreadLocalRandom.current().nextInt(rand);
		for(Entry<Integer, RoulList> entry : roulMap.entrySet()) {
			if(entry.getValue().percent > rand) {
				return entry.getValue();
			}
			else {
				rand -= entry.getValue().percent;
			}
		}
		return null;
	}
}
