package com.ho_bot.AntWar.File;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import com.ho_bot.AntWar.AntWar;
import com.ho_bot.AntWar.Team.Team;
import com.ho_bot.AntWar.Util.ColorUtil;
import com.ho_bot.AntWar.Util.YmlUtil;
import com.ho_bot.AntWar.Var.GameVar;

public class TeamFile {
	
public YmlUtil YU = new YmlUtil();
	
	public File getTeamDir(String TeamName) {
		return new File(AntWar.getPlugin(AntWar.class).getDataFolder( ) + File.separator + "Team//"+TeamName+".yml");
	}
	
	public List<String> getTeamFileList() {
		File folder = new File(AntWar.getPlugin(AntWar.class).getDataFolder( ) + File.separator + "Team");
		List<String> filelist = new ArrayList<String>();
		for(File f : folder.listFiles()) {
			int pos = f.getName().lastIndexOf(".");
			filelist.add(f.getName().substring(0, pos));
		}
		return filelist;
	}
	
	public void reloadTeamFile() {
		Logger log = Bukkit.getLogger();
		GameVar.teamlist.clear();
		if(getTeamFile() != null) {
			GameVar.teamlist = getTeamFile();
		}
		log.info("[AntWar] 총 " + GameVar.teamlist.size() + " 개의 팀 확인");
	}
	
	public void addTeamFile(String TeamName, String TeamDisplay, List<Player> playerlist, ColorUtil.AntColor Color, long Resource) {
		YamlConfiguration yml = YamlConfiguration.loadConfiguration(getTeamDir(TeamName));
		yml.set("TeamDisplay", TeamDisplay);
		yml.set("Player", playerlist);
		yml.set("Color", Color);
		yml.set("Resource", Resource);
		YU.SetYml(getTeamDir(TeamName), yml);
	}
	
	public void setTeamFile(List<Team> teamlist) {
		for(Team team : teamlist) {
			addTeamFile(team.TeamName, team.TeamDisplay, team.TeamPlayer, team.Color, team.TeamResource);
		}
	}
	
	public List<Team> getTeamFile() {
		List<Team> t_list = new ArrayList<Team>();
		for(String teamname : getTeamFileList()) {
			YamlConfiguration yml = YamlConfiguration.loadConfiguration(getTeamDir(teamname));
			
			t_list.add(new Team(teamname, yml.getString("TeamDisplay"), (List<Player>) yml.getList("Player"), ColorUtil.returnColor(yml.getString("Color")), yml.getLong("Resource")));
		}
		return t_list;
	}
	
	public void removeTeamFile(String TeamName) {
		List<Team> teamlist = getTeamFile();
		List<Team> fix_teamlist = new ArrayList<Team>();
		for(Team team : teamlist) {
			if(!team.TeamName.equalsIgnoreCase(TeamName)) {
				fix_teamlist.add(team);
			}
		}
		setTeamFile(fix_teamlist);
	}
	

}
