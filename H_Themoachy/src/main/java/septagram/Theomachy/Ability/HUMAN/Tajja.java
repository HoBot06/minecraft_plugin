package septagram.Theomachy.Ability.HUMAN;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import septagram.Theomachy.Ability.Ability;
import septagram.Theomachy.Utility.CoolTimeChecker;
import septagram.Theomachy.Utility.EventFilter;
import septagram.Theomachy.Utility.PlayerInventory;
import septagram.Theomachy.Utility.Skill;

public class Tajja extends Ability{

	private final static String[] des= {"�ճ�� ���� �ɷ��Դϴ�.",
			"�ɷ� ��� �� �κ��丮�� ���� ���� �ִ� ���� �Һ�˴ϴ�.",
			"�ɷ� ��� �� �Ǽ����� ���� �� �Һ�� ���� ��������ŭ",
			"�������� �� �� �ֽ��ϴ�.",
			"��, 10�� ���� ���� �� �� �����ϴ�."
	};
	
	private final int coolTime0=60;
	private final int stack0=10;
	
	public Tajja(String playerName) {
		super(playerName, "Ÿ¥", 126, true, false, false, des);
		
		this.rank=4;
		this.cool1=coolTime0;
		this.sta1=10;
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

	private int sword=0;
	private int time=-1;
	
	private void leftAction(Player player) {
		if(CoolTimeChecker.Check(player, 0) && PlayerInventory.ItemCheck(player, Material.COBBLESTONE, stack0)) {
			if(sword==0) {
				for(ItemStack i:player.getInventory().getContents()) {
					try {
						switch(i.getType()) {
						case WOODEN_SWORD:
								sword=4;
								player.getInventory().removeItem(new ItemStack(i.getType(), 1));
							break;
						case STONE_SWORD:
								sword=5;
								player.getInventory().removeItem(new ItemStack(i.getType(), 1));
							break;
						case IRON_SWORD:
								sword=6;
								player.getInventory().removeItem(new ItemStack(i.getType(), 1));
							break;
						case GOLDEN_SWORD:
								sword=4;
								player.getInventory().removeItem(new ItemStack(i.getType(), 1));
							break;
						case DIAMOND_SWORD:
							sword=7;
							player.getInventory().removeItem(new ItemStack(i.getType(), 1));
							break;
						case NETHERITE_SWORD:
							sword=8;
							player.getInventory().removeItem(new ItemStack(i.getType(), 1));
							break;
						default:
							continue;
						}
						break;
					}catch(NullPointerException e) {}
				}player.sendMessage("���� ������ ������.");
				Skill.Use(player, Material.COBBLESTONE, stack0, 0, coolTime0);
				time=10;
			}
		}
	}
	
	
	public void T_Passive(EntityDamageByEntityEvent event) {
		Player p=(Player) event.getDamager();
			if(p.getName().equals(this.playerName)) {
				if(sword!=0) {
					switch(time) {
					case 1:
						event.setDamage(sword);
						p.sendMessage("���۱׸�, ���� �����.");
						sword=0;
						time=-1;
						break;
					default:
						event.setDamage(sword);
						time--;
						break;
					}
				}else {
					p.sendMessage("�Һ�� ���� �����ϴ�.");
				}
			}
	}

}
