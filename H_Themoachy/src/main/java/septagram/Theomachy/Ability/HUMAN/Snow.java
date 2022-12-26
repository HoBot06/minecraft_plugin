package septagram.Theomachy.Ability.HUMAN;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;

import septagram.Theomachy.Ability.Ability;
import septagram.Theomachy.DB.GameData;
import septagram.Theomachy.Utility.EventFilter;
import septagram.Theomachy.Utility.PlayerInventory;

public class Snow extends Ability{

	private final static String[] des= {"�ɷ� �̸��� �ñ��Ͻôٸ� ���̹��� �˻��ϼ���.",
			"���� ���߸� 70%�� Ȯ���� ���� ������ŭ�� �������� �ݴϴ�.",
			"���� ������ �ɷ��� ���� ��Ŭ������ Ȯ���� �� �ֽ��ϴ�.",
			"���� ������ ���� ������ �ִ� 7���� ����մϴ�.",
			"������ ��������� ������ �� �������� 2��� �޽��ϴ�.",
			"�����̸� ���絵 ��밡 �з����� ������,",
			"���� ���� �� ������ 64���� �޽��ϴ�. �ش� �����̴� �κ����̺갡 �˴ϴ�"};
	
	public int ammo = 0;
	public Snow(String playerName) {
		super(playerName, "�׿��Ͻ�Ʈ����Ʈ�Ͻ�Ʈ����", 125, true, true, false, des);
		
		this.rank=2;
		
		this.cool1=0;
		this.sta1=0;
	}
	
	private int attack=0;
	
	public void T_Active(PlayerInteractEvent event){
		Player player=event.getPlayer();
		if(PlayerInventory.InHandItemCheck(player, Material.BLAZE_ROD)){
			switch(EventFilter.PlayerInteract(event)){
			case 0:case 1:
				player.sendMessage("���� ��ġ : "+attack);
				break;
			}
		}
	}
	
	public void T_Passive(PlayerDeathEvent event) {
		if(attack<8){
			event.getEntity().sendMessage(ChatColor.RED+"���� ��ġ�� �����ϰ� �ֽ��ϴ�!");
			attack++;
		}
		if(event.getEntity().getName().equalsIgnoreCase(playerName)) {
			event.getDrops().removeIf(itemStack -> {
				if(itemStack.getType() == Material.SNOWBALL) {
					ammo = itemStack.getAmount() + ammo;
					return true;
				}
				return false;
			});
		}
	}
	
	public void T_Passive(PlayerRespawnEvent event)
	{
		if(event.getPlayer().getName().equalsIgnoreCase(playerName)) {
			ammo++;
			event.getPlayer().getInventory().addItem(new ItemStack(Material.SNOWBALL, ammo));
			ammo=0;
		}
	}
	
	public void T_PassiveSnow(EntityDamageByEntityEvent event){
		Player p=(Player)event.getEntity();		
		event.setCancelled(true);
		p.damage(attack);
	}
	
	public void T_Passive(EntityDamageEvent event){
		DamageCause dc=event.getCause();
		if(dc.equals(DamageCause.FIRE_TICK)||dc.equals(DamageCause.LAVA)||dc.equals(DamageCause.FIRE)){
			event.setDamage(event.getDamage()*2);
		}
	}
	
	public void conditionSet(){
		GameData.OnlinePlayer.get(playerName).getInventory().addItem(new ItemStack(Material.SNOWBALL, 64));
	}
	
}
