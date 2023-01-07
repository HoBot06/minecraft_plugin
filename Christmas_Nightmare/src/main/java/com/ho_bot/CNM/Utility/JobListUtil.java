package com.ho_bot.CNM.Utility;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.entity.Player;

import com.ho_bot.CNM.Var.TeamVar;

public class JobListUtil {
	
	public static final String BigGuy = "����";
	public static final String Egis = "���⽺";
	public static final String Patai = "��Ÿ��";
	public static final String Cruise = "ũ�罺";
	
	public static final String Saluran = "����";
	public static final String Faster = "�佺Ʈ";
	public static final String Bomber = "����";
	public static final String Kratos = "ũ���佺";
	
	public static final String Zouk = "��ũ";
	public static final String Paladin = "�ȶ��";
	public static final String Pemanah = "���";
	
	public static List<String> GetJobList() {
		List<String> JobList = new ArrayList<String>();
		JobList.add(BigGuy);
		JobList.add(Egis);
		JobList.add(Patai);
		JobList.add(Cruise);
		
		JobList.add(Saluran);
		JobList.add(Faster);
		JobList.add(Bomber);
		JobList.add(Kratos);
		
		JobList.add(Zouk);
		JobList.add(Paladin);
		JobList.add(Pemanah);
		
		return JobList;
	}
	
	public static int GetJobUpint(Player player, String Job) {
		HashMap<String, Integer> JobUp = TeamVar.Team_JobUpgrade.get(TeamVar.Player_Team.get(player.getUniqueId()));
		return JobUp.get(Job);
	}

}
