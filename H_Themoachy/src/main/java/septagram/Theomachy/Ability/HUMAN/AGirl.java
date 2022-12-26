package septagram.Theomachy.Ability.HUMAN;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import septagram.Theomachy.Ability.Ability;
import septagram.Theomachy.Utility.CoolTimeChecker;
import septagram.Theomachy.Utility.EventFilter;
import septagram.Theomachy.Utility.GetPlayerList;
import septagram.Theomachy.Utility.PlayerInventory;
import septagram.Theomachy.Utility.Skill;

public class AGirl extends Ability{

	private final static String[] des= {"�Ϳ������� ��븦 �������̴� �ɷ��Դϴ�.",
											  "������ �ε� ��Ŭ�� �� �ֺ� 5ĭ �̳���",
											  "�÷��̾ �ڽ��� ������ ����ɴϴ�.",
											  "���� �� �÷��̾���� ����� ������ 0�� �˴ϴ�."};
	
	public AGirl(String playerName) {
		super(playerName, "�ȶ��ҳ�", 127, true, false, false, des);
		
		this.rank= 3;
		this.cool1=60;
		this.sta1=15;
	}
	
	public void T_Active(PlayerInteractEvent event){
		Player player = event.getPlayer();
		if (PlayerInventory.InHandItemCheck(player, Material.BLAZE_ROD))
		{
			switch(EventFilter.PlayerInteract(event))
			{
			case 0:case 1:
				leftAction(player);
				break;
			}
		}
	}

	private void leftAction(Player player) {
		if(CoolTimeChecker.Check(player, 0)&&PlayerInventory.ItemCheck(player, Material.COBBLESTONE, sta1)) {
			
			Skill.Use(player, Material.COBBLESTONE, sta1, 0, cool1);
			
			for(Player e:GetPlayerList.getNearByNotTeamMembers(player, 5, 0, 5)) {
				e.teleport(player);
				e.setFoodLevel(0);
				e.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 2, 200));
				e.sendMessage(ChatColor.GREEN+"�ȶ��ҳ�"+ChatColor.WHITE+"���� �̲��� ���ϴ�!");
			}
		}
	}

}
