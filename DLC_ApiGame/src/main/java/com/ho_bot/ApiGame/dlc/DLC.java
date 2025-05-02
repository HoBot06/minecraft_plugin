package com.ho_bot.ApiGame.dlc;

import java.util.UUID;

import com.ho_bot.dlc.DLC_Donation;

public class DLC extends DLC_Donation{

	public DLC(String key) {
		super(key);
	}

	@Override
	public void active(UUID uuid, String playername, String sender, String platform, int cash, String cmd) {
		
	}
	
	

}
