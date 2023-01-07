package com.ho_bot.CNM.Utility;

import java.util.ArrayList;
import java.util.List;

public class JobListUtil {
	
	public static final String BigGuy = "빅가이";
	public static final String Egis = "에기스";
	public static final String Patai = "파타이";
	public static final String Cruise = "크루스";
	
	public static final String Saluran = "살루란";
	public static final String Faster = "페스트";
	public static final String Bomber = "봄버";
	public static final String Kratos = "크라토스";
	
	public static final String Zouk = "주크";
	public static final String Paladin = "팔라딘";
	public static final String Pemanah = "페모나";
	
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

}
