package septagram.Theomachy.Ability.HUMAN;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import septagram.Theomachy.Ability.Ability;
import septagram.Theomachy.Utility.BlockFilter;
import septagram.Theomachy.Utility.CoolTimeChecker;
import septagram.Theomachy.Utility.EventFilter;
import septagram.Theomachy.Utility.PlayerInventory;
import septagram.Theomachy.Utility.Skill;

public class Megumin extends Ability{

	private final static String[] des= { "�� �ɷ��� �ޱ���!",
											   "��ũ ����������, �ְ��� ���� ������",
											   "���� ������ �ٷ�� �ɷ�!",
											   "�׷����ϴ�. ����� �� ��,",
											   "���濡 ���� ������ ���� �� �ֽ��ϴ�.",
											   "������ �ε�� ������ ���� ������ ",
											   "������ ���� �� �ֽ��ϴ�. ��, �������� ��밡�������ϴ�"};
	
	public Megumin(String playerName) {
		super(playerName, "�ޱ���", 128, true, false, false, des);
		
		this.rank=4;
		
		this.sta1=32;
		this.cool1=30;
	}

	private boolean cancel=false;
	
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
		if(PlayerInventory.ItemCheck(player, Material.COBBLESTONE, sta1)&&CoolTimeChecker.Check(player, 0)) {
			if(!cancel) {
				Block block=player.getTargetBlock(null, 25);
				if (BlockFilter.AirToFar(player, block))
				{
					Skill.Use(player, Material.COBBLESTONE, 32, 0, 10);
					Location loc = block.getLocation();
					loc.add(0, 1, 0);
					player.getWorld().createExplosion(loc, 8.0f);
					Bukkit.broadcastMessage(ChatColor.RED + "�ڡ١ڡ��ͽ��÷���!�١ڡ١�");
					
					this.cancel=true;
				}
			}
			else {
				player.sendMessage("�� �̻� �� �� �����ϴ�...");
			}
		}
	}
	
	public void T_Passive(PlayerDeathEvent event)
	{
		Player player = event.getEntity();
		if(player.getName().equalsIgnoreCase(playerName)) {
			conditionSet();
		}
	}
	
	public void conditionSet(){
		this.cancel=false;
	}
	
}
