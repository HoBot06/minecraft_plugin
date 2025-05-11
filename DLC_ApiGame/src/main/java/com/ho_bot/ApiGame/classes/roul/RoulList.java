package com.ho_bot.ApiGame.classes.roul;

import java.util.List;

import com.ho_bot.ApiGame.util.VarUtil.RoulType;

public class RoulList {
	
	public final RoulType roultype;
	public final String type;
	public final int amo;
	public final int percent;
	public final int power;
	public final int duration;
	public final List<String> cmdlist;
	
	public RoulList(RoulType roultype, String type, int amo, int percent, int power, int duration, List<String> cmdlist) {
		this.roultype = roultype;
		this.type = type;
		this.amo = amo;
		this.percent = percent;
		this.power = power;
		this.duration = duration;
		this.cmdlist = cmdlist;
	}

}
