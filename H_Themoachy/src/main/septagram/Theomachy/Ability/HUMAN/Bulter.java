package septagram.Theomachy.Ability.HUMAN;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.EntityType;
import org.bukkit.event.entity.EntityExplodeEvent;

import septagram.Theomachy.Ability.Ability;

public class Bulter extends Ability{

	private final static String[] des= {"������ ��Ʋ�� �ɷ��Դϴ�.",
			"��� ������ ������ �� �ֽ��ϴ�."};
	
	public Bulter(String playerName) {
		super(playerName, "����", 121, false, true, false, des);
		
		this.rank=-1;
	}
	
	public void T_Passive(EntityExplodeEvent event){
		event.setCancelled(true);
		if(!event.getEntity().getType().equals(EntityType.FIREBALL))
			Bukkit.broadcastMessage(ChatColor.GREEN+"���翡 ���� ������ �����Ǿ����ϴ�.");
	}
	
}