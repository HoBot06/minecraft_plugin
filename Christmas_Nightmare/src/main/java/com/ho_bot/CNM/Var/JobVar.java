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
	  
	public static String[] BigGuy_Des = new String[] { "�ɷ� ����", "�޴� �������� �����ϰ� �ֺ� �Ʊ��� �������� ��� �Խ��ϴ�" };
	 
	public static String[] Cruise_Des = new String[] { "�ɷ� ����", "���� �� ���������鼭 �ֺ� ���鿡�� ������� �ο��մϴ�"};
	
	public static String[] Egis_Des = new String[] { "�ɷ� ����", "�ڽŰ� �ֺ� �Ʊ����� ���带 �ο��մϴ�"};
	 
	public static String[] Patai_Des = new String[] { "�ɷ� ����", "�ֺ� ���� ������� �� ����ŭ�� ���带 ����ϴ�"};
	  
	public static String[] Bomber_Des = new String[] { "�ɷ� ����", "�����ð����� ��ź�߻��� ��ü�˴ϴ�"};
	  
	public static String[] Faster_Des = new String[] { "�ɷ� ����", "�ٶ󺸰��ִ� �������� �����մϴ�"};
	  
	public static String[] Kratos_Des = new String[] { "�ɷ� ����", "�����ð����� 2Ÿ �������� ����ȴ�. 2Ÿ �������� 50%�̴�"};
	  
	public static String[] Saluran_Des = new String[] { "�ɷ� ����", "�� 8��° ȭ���� ȭ���� ����Ǿ� �߻�ȴ�"};
	  
	public static String[] Paladin_Des = new String[] { "Ÿ�ݽ�", "�ֺ� �Ʊ����� ���� �ο��մϴ�" };
	  
	public static String[] Pemanah_Des = new String[] { "�ɷ� ����", "ȭ�� �ֺ��� �Ʊ����� ���� �ش�" };
	  
	public static String[] Zouk_Des = new String[] { "�ɷ� ����", "�⺻������ �ֺ� �Ʊ����� ������ �ο��ϰ�, �ɷ»��� �����ð����� �߰� ������ �־����ϴ�." };
	
}

