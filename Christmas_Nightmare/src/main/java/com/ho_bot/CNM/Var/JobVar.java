package com.ho_bot.CNM.Var;

import com.ho_bot.CNM.Job.Job;
import java.util.HashMap;
import java.util.UUID;
import org.bukkit.Particle;

public class JobVar {
	
	public static HashMap<UUID, Job> Job_Player = new HashMap<UUID, Job>();
	public static HashMap<UUID, Boolean> BigGuy_P = new HashMap<UUID, Boolean>();
	public static final double BigGuy_distance = 12D;
	public static HashMap<UUID, Boolean> Bomber_P = new HashMap<UUID, Boolean>();
	public static HashMap<UUID, Boolean> Kratos_P = new HashMap<UUID, Boolean>();
	public static HashMap<UUID, Boolean> Zouk_P = new HashMap<UUID, Boolean>();
	public static final int Zouk_Dis = 8;
	public static final Particle Zouk_Particle = Particle.FLAME;
	public static HashMap<String, HashMap<UUID, String>> TeamJobList = new HashMap<String, HashMap<UUID, String>>();
	  
	public static String[] BigGuy_Des = new String[] { "능력 사용시", "받는 데미지가 감소하고 주변 아군의 데미지를 대신 입습니다" };
	 
	public static String[] Cruise_Des = new String[] { "능력 사용시", "도약 후 내려찍으면서 주변 적들에게 디버프를 부여합니다"};
	
	public static String[] Egis_Des = new String[] { "능력 사용시", "자신과 주변 아군에게 쉴드를 부여합니다"};
	 
	public static String[] Patai_Des = new String[] { "능력 사용시", "주변 적을 끌어당기고 그 수만큼의 쉴드를 얻습니다"};
	  
	public static String[] Bomber_Des = new String[] { "능력 사용시", "일정시간동안 유탄발사기로 교체됩니다"};
	  
	public static String[] Faster_Des = new String[] { "능력 사용시", "바라보고있는 방향으로 돌진합니다"};
	  
	public static String[] Kratos_Des = new String[] { "능력 사용시", "일정시간동안 2타 공격으로 변경된다. 2타 데미지는 50%이다"};
	  
	public static String[] Saluran_Des = new String[] { "능력 사용시", "매 8번째 화살은 화살비로 변경되어 발사된다"};
	  
	public static String[] Paladin_Des = new String[] { "타격시", "주변 아군에게 힐을 부여합니다" };
	  
	public static String[] Pemanah_Des = new String[] { "능력 사용시", "화살 주변의 아군에게 힐을 준다" };
	  
	public static String[] Zouk_Des = new String[] { "능력 사용시", "기본적으로 주변 아군에게 버프를 부여하고, 능력사용시 일정시간동안 추가 버프가 주어집니다." };
	
}

