package septagram.Theomachy.Ability.HUMAN;

import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import septagram.Theomachy.Ability.Ability;
import septagram.Theomachy.DB.GameData;
import septagram.Theomachy.Utility.CoolTimeChecker;
import septagram.Theomachy.Utility.EventFilter;
import septagram.Theomachy.Utility.PlayerInventory;
import septagram.Theomachy.Utility.Skill;

public class Bee extends Ability{

	public final static String[] des= {"������ �����Դϴ�.",
			"�ڽ��� ������ �� ������ 75%�� Ȯ���� ���� �Ȱ��ݴϴ�.",
			"������ �̿��ؼ� ��븦 ��Ȥ�� ���� �ֽ��ϴ�.",
			"�ɷ� ��� �� ��ǥ�� ������ �� ��븦 �ڽ��� ��ġ�� ����ɴϴ�.",
			"��ǥ ����: /x <���>"};
	
	public final int coolTime0=180;
	public final int stack0=32;

	private String abilitytarget;
	
	public Bee(String playerName) {
		super(playerName, "���չ�", 124, true, true, false, des);
		
		this.rank=3;
		
		this.cool1=coolTime0;
		this.sta1=stack0;
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
		if (CoolTimeChecker.Check(player, 0)&&PlayerInventory.ItemCheck(player, Material.COBBLESTONE, stack0))
		{
			if(abilitytarget!=null){
				if(player.getName().equals(abilitytarget)){
					player.sendMessage(ChatColor.RED+"��ǥ�� ������ �ƴϾ�� �մϴ�.");
				}
				
				else{
					Player target = GameData.OnlinePlayer.get(abilitytarget);
					Skill.Use(player, Material.COBBLESTONE, stack0, 0, coolTime0);
					
					player.sendMessage(ChatColor.YELLOW+" ���� "+ChatColor.WHITE+"�� �̿��Ͽ� ��ǥ�� ��Ȥ�߽��ϴ�!");
					target.sendMessage(ChatColor.YELLOW+" ���� "+ChatColor.WHITE+"�� ��Ȥ���߽��ϴ�!");
					
					target.teleport(player);
				}
				
			}
			else{
				player.sendMessage("��ǥ�� �������ֽʽÿ�. (��ǥ ������: /x <��ǥ>)");
			}
		}
	}
	
	public void targetSet(CommandSender sender, String targetName)
	{
			if (!playerName.equals(targetName))
			{
				this.abilitytarget = targetName;
				sender.sendMessage("Ÿ���� ����߽��ϴ�.   "+ChatColor.GREEN+targetName);
			}
			else
				sender.sendMessage("�ڱ� �ڽ��� ��ǥ�� ��� �� �� �����ϴ�.");
	}
	
	public void T_Passive(EntityDamageByEntityEvent event) {
		Player p=(Player) event.getEntity();
		Player e=(Player) event.getDamager();
		
		if(p.getName().equals(this.playerName)) {
			Random r=new Random();
			
			if(r.nextInt(4)<=2) {
				e.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 100, 0));
				e.sendMessage(ChatColor.GOLD+"������ ����ϴ�! �ڳ����� ������.");
			}
			
		}
		
	}
	
}
