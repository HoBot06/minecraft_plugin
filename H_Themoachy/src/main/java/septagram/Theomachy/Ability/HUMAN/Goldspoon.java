package septagram.Theomachy.Ability.HUMAN;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;

import septagram.Theomachy.Ability.Ability;

public class Goldspoon extends Ability{

	private final static String[] des= {"�ݼ����� ���� �¾ �ɷ��Դϴ�.",
			"��Ÿ���Ե�, �ݼ����� �� �帮�� �ݷ��뽺�� �帮�ڽ��ϴ�.",
			"�������� ������ �ݷ��뽺�� �޽��ϴ�."};
	
	public Goldspoon(String playerName) {
		super(playerName, "�ݼ���", 123, false, true, false, des);
		
		this.rank=2;
	}
	
	public void T_Passive(PlayerRespawnEvent event){
		Player p=event.getPlayer();
		p.getInventory().addItem(new ItemStack(Material.GOLDEN_LEGGINGS));
	}
	
}
