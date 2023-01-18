package septagram.Theomachy.Ability.DLC;

import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.Location;
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

public class SunKnight extends Ability
{
	
	private final int coolTime1=60;
	private final Material material1=Material.COBBLESTONE;
	private final int stack1=10;
	
	private final static String[] des= {"�¾��� �ɷ��Դϴ�.",
			   "�ɷ� ���� �ð��� ������ �ٲ�� ������ �Բ� �ϴ��� �Ĵٺ��ϴ�"};
	
	public SunKnight(String playerName)
	{
		super(playerName,"�¾���", 212, true, false, false, des);
		Theomachy.log.info(playerName+abilityName);
		
		this.cool1=coolTime1;
		this.sta1=stack1;
		
		this.rank=2;
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

	private void leftAction(Player player)
	{
		if (CoolTimeChecker.Check(player, 0)&&PlayerInventory.ItemCheck(player, material1, stack1))
		{
			Skill.Use(player, material1, stack1, 0, cool1);
			player.getWorld().setTime(6000);
			List<Player> list=GetPlayerList.getTeamMember(player);
			Location ploc = player.getLocation();
			ploc.setPitch(-90f);
			player.teleport(ploc);
			for(Player allplayer : Bukkit.getOnlinePlayers()) {
				if(!list.contains(allplayer)) {
					Location aploc = allplayer.getLocation();
					aploc.setPitch(-90f);
					allplayer.teleport(aploc);
				}
			}
			Bukkit.broadcastMessage("<"+player.getName()+"> �¾縸��!");
		}
	}

}
