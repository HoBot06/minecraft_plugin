package com.ho_bot.Siege_Flag.Team;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class TeamVar {
	
	public static List<Team> Teamlist = new ArrayList<Team>();
	public static HashMap<UUID, Boolean> TeamSettingDisplay = new HashMap<UUID, Boolean>();
	public static HashMap<UUID, String> TeamSelect = new HashMap<UUID, String>();
	public static HashMap<UUID, String> PlayerTeam = new HashMap<UUID, String>();
}
