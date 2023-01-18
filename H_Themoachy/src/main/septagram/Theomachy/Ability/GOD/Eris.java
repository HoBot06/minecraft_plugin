package septagram.Theomachy.Ability.GOD;

import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.util.Vector;

import septagram.Theomachy.Ability.Ability;

public class Eris extends Ability{

	private final static String[] des= {"��ȭ�� �����Դϴ�.",
			"�ڽ��� ������ �÷��̾ 20% Ȯ���� ���ĳ��ϴ�."
	};
	
	public Eris(String playerName) {
		super(playerName, "������", 14, false, true, false, des);
		
		this.rank=3;
	}

	public void T_Passive(EntityDamageByEntityEvent event) {
		Player eris = (Player)event.getEntity();
		Player damager = (Player) event.getDamager();
		Random random = new Random();
		int rn = random.nextInt(5);
		if(eris.getName().equals(playerName)){
			if(rn==0){
				Location daloc = damager.getLocation();
				float angle = daloc.getYaw();
				Vector v = daloc.getDirection();
				v.setX(Math.sin(Math.toRadians(angle))*3);
				v.setY(0.5f);
				v.setZ(-Math.cos(Math.toRadians(angle))*3);
				damager.setVelocity(v);
				eris.sendMessage(ChatColor.RED+"��븦 ���ƽ��ϴ�!");
				damager.sendMessage(ChatColor.RED+"�������� ���� ���������ϴ�.");
			}
		}
	}
	
}
