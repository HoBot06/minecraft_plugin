package com.ho_bot.CNM.Var;

import com.ho_bot.CNM.Main;
import java.util.HashMap;
import java.util.UUID;

public class TeamVar
{
	static Main chmain = Main.getPlugin(Main.class);
	 
	public static HashMap<UUID, String> Player_Team = new HashMap<UUID, String>();
	public static HashMap<UUID, String> Player_Role = new HashMap<UUID, String>();
	public static HashMap<UUID, int[]> Player_Upgrade = new HashMap<UUID, int[]>();
	public static HashMap<String, HashMap<String, Integer>> Team_JobUpgrade = new HashMap<String, HashMap<String, Integer>>();
	public static HashMap<String, Integer> Team_JobUpPoint = new HashMap<String, Integer>();
	
	public static void TeamShowName_Set(String Team, String Name)
	{
	    if(Team.equals(WordVar.Santa) || Team.equals(WordVar.Krampus))
	    {
	        chmain.getConfig().set(Team+"."+WordVar.TeamShowName, Name);
	        chmain.saveConfig();
	    }
	}
	
	public static String TeamShowName_Get(String Team)
	{
	    if(Team.equals(WordVar.Santa) || Team.equals(WordVar.Krampus)) {
	    	return chmain.getConfig().getString(Team+"."+WordVar.TeamShowName);
	    }
	    return null;
	}

}
