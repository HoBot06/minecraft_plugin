package septagram.Theomachy.Ability.GOD;

import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.util.Vector;

import septagram.Theomachy.Ability.Ability;

public class Eris extends Ability{

	private final static String[] des= {"불화의 여신입니다.",
			"자신을 공격한 플레이어를 20% 확률로 밀쳐냅니다."
	};
	
	public Eris(String playerName) {
		super(playerName, "에리스", 14, false, true, false, des);
		
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
				eris.sendMessage(ChatColor.RED+"상대를 밀쳤습니다!");
				damager.sendMessage(ChatColor.RED+"에리스에 의해 밀쳐졌습니다.");
			}
		}
	}
	
}
