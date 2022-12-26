package septagram.Theomachy.Ability.GOD;

import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

import septagram.Theomachy.Theomachy;
import septagram.Theomachy.Ability.Ability;
import septagram.Theomachy.Utility.CoolTimeChecker;
import septagram.Theomachy.Utility.EventFilter;
import septagram.Theomachy.Utility.GetPlayerList;
import septagram.Theomachy.Utility.PlayerInventory;
import septagram.Theomachy.Utility.Skill;

public class Aprodite extends Ability{
	
	private final static String[] des= {"���� ���Դϴ�.",
			   "������ �ִ� ������� ����� �̷� ����� �� �ֽ��ϴ�.",
			   "�Ϲݴɷ����� �ֺ� 20ĭ �̳��� �ٸ� ���� ",
			   "������� �ڽ��� ��ġ�� ����ɴϴ�. ",
			   "��, �ڽ��� ���� �� �־�� �ϰ�, ��ũ���� ",
			   "������ �ߵ����� �ʽ��ϴ�."};
	private final int coolTime0=30;
	private final int stack0=64;
	
	public Aprodite(String playerName)
	{
		super(playerName, "�����ε���", 13, true, false, false, des);
		Theomachy.log.info(playerName+"�����ε���");
		
		this.cool1=coolTime0;
		this.sta1=stack0;
		
		this.rank=4;
	}
	
	public void T_Active(PlayerInteractEvent event)
	{
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
		if (CoolTimeChecker.Check(player, 0)&&PlayerInventory.ItemCheck(player, Material.COBBLESTONE, stack0)) {
			if(!player.isSneaking() && !player.getLocation().add(0, -1, 0).getBlock().getType().equals(Material.AIR)) {
				Skill.Use(player, Material.COBBLESTONE, stack0, 0, coolTime0);
				try {
					List<Player> list=GetPlayerList.getNearByNotTeamMembers(player, 20, 20, 20);
				
					for(Player e:list) {
						e.teleport(player);
						e.sendMessage(ChatColor.YELLOW+"���� ���ſ��� �̲������ϴ�!");
					}
				}catch(Exception e) {}
				
				player.sendMessage("������ ������. ��?");
			}else {
				player.sendMessage(ChatColor.RED+"��ũ���� �ְų� �� ���� ����� ���� �ɷ��� �ߵ����� �ʾҽ��ϴ�.");
			}
		}

	}
	
}
