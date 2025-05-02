package com.ho_bot.ApiGame.classes.board;

import com.ho_bot.ApiGame.util.VarUtil.GameType;

public class ApiGameConfig {
	
	public final GameType gametype;
	public final boolean able;
	public final long time;
	
	public ApiGameConfig(boolean game, GameType gametype, boolean able, long time) {
		this.gametype = gametype;
		this.able = able;
		this.time = time;
	}

}
