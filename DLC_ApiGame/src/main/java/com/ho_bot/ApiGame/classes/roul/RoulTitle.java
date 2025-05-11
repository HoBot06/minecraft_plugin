package com.ho_bot.ApiGame.classes.roul;

public class RoulTitle {
	
	public final boolean isEnable;
	public final String mainmsg;
	public final String submsg;
	public final int fadeIn;
	public final int fadeStay;
	public final int fadeOut;
	
	public RoulTitle(boolean isEnable, String mainmsg, String submsg, int fadeIn, int fadeStay, int fadeOut) {
		this.isEnable = isEnable;
		this.mainmsg = mainmsg;
		this.submsg = submsg;
		this.fadeIn = fadeIn;
		this.fadeStay = fadeStay;
		this.fadeOut = fadeOut;
	}

}
