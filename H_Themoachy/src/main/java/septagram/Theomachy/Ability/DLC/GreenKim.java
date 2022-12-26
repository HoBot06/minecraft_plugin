package septagram.Theomachy.Ability.DLC;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import septagram.Theomachy.Theomachy;
import septagram.Theomachy.Ability.Ability;
import septagram.Theomachy.Utility.CoolTimeChecker;
import septagram.Theomachy.Utility.EventFilter;
import septagram.Theomachy.Utility.PlayerInventory;
import septagram.Theomachy.Utility.Skill;
import septagram.Theomachy.Utility.Sounds;

public class GreenKim extends Ability
{
	private final int coolTime1=40;
	private final int coolTime2=120;
	private final Material material1=Material.COBBLESTONE;
	private final Material material2=Material.COBBLESTONE;
	private final int stack1=3;
	private final int stack2=64;
	
	private final static String[] des= {"��Ʈ������ �ɷ��Դϴ�.",
			   "�Ϲݴɷ����� ��� ������Լ� ���൹�� �Ŀ��޽��ϴ�." ,
			   "��޴ɷ����� ���൹�� ȯ���Ͽ� ������ ������ ����ϴ�"};
	
	public GreenKim(String playerName)
	{
		super(playerName,"��׸�", 201, true, false, false, des);
		Theomachy.log.info(playerName+abilityName);
		
		this.cool1=coolTime1;
		this.cool2=coolTime2;
		this.sta1=stack1;
		this.sta2=stack2;
		
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
			case 2:case 3:
				rightAction(player);
				break;
			}
		}
	}

	private void leftAction(Player player)
	{
		if (CoolTimeChecker.Check(player, 1)&&PlayerInventory.ItemCheck(player, material1, stack1))
		{
			Skill.Use(player, material1, stack1, 1, coolTime1);
			int money = 0;
			for(Player p : Bukkit.getOnlinePlayers()) {
				if(p.getInventory().contains(Material.COBBLESTONE, 1) && p != player) {
					money++;
					p.getInventory().removeItem(new ItemStack(material1, 1));
					p.sendMessage("��Ʈ������ ��Ȥ�� ������ ���ҽ��ϴ�.");
				}
				else if(p != player){
					p.sendMessage("��Ʈ������ ��Ȥ�� ������ �ʾҽ��ϴ�!");
				}
			}
			if(money <= 0) {
				player.sendMessage("�� ������ �Ŀ����� �ʾҽ��ϴ�...");
			}
			else {
				Sounds.SoundP(player, Sound.ENTITY_ENDER_EYE_DEATH, 1.0f, 2.0f);
				player.sendMessage("�� " + money + "���� ���൹ �Ŀ��� ���Խ��ϴ�!");
				player.getInventory().addItem(new ItemStack(Material.COBBLESTONE, money));
			}
		}
	}
	
	private void rightAction(Player player)
	{
		if (CoolTimeChecker.Check(player, 2)&&PlayerInventory.ItemCheck(player, material2, stack2))
		{
			Skill.Use(player, material2, stack2, 2, coolTime2);
			Material trans_stone = Material.COBBLESTONE;
			Random r = new Random();
			int rn = r.nextInt(6);
			switch(rn) {
			case 0: trans_stone = Material.COBBLESTONE; break;
			case 1: trans_stone = Material.IRON_INGOT; break;
			case 2: trans_stone = Material.GOLD_INGOT; break;
			case 3: trans_stone = Material.DIAMOND; break;
			case 4: trans_stone = Material.NETHERITE_INGOT; break;
			case 5: trans_stone = Material.COPPER_INGOT; break;
			}
			int at = (r.nextInt(r.nextInt(10))) + 1;
			for(Player p : Bukkit.getOnlinePlayers()) {
				Sounds.SoundPL(p, player.getLocation(), Sound.BLOCK_ANVIL_USE, 1.0f, 1.2f);
			}
			player.getInventory().addItem(new ItemStack(trans_stone, at));
		}
	}

}
