package septagram.Theomachy.Ability.HUMAN;

import java.util.Random;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

import septagram.Theomachy.Theomachy;
import septagram.Theomachy.Ability.Ability;

public class Miner extends Ability
{
	
	private final static String[] des= {"��̸� �ɼ��ϰ� �ٷ� �� �ֽ��ϴ�.",
			   "�ں����� Ķ �� ���� 10% Ȯ���� �ѹ��� 10���� ���� �� �ֽ��ϴ�.",
			   "�ݰ�̸� ������ ��̵��� �������� 4�� �����˴ϴ�."};
	
	public Miner(String playerName)
	{
		super(playerName,"����", 102, false, true, false, des);
		Theomachy.log.info(playerName+abilityName);
		
		this.rank=2;
	}
	
	public void T_Passive(BlockBreakEvent event)
	{
		Block block = event.getBlock();
		if (block.getType() == Material.COBBLESTONE)
		{
			Random random = new Random();
			if (random.nextInt(10) == 0)
			{
				Player player = event.getPlayer();
				player.sendMessage("�ո��� �������ϴ�!");
				player.getInventory().addItem(new ItemStack(Material.COBBLESTONE, 9));
			}
		}
	}
	
	public void T_Passive(EntityDamageByEntityEvent event){
		Player p=(Player)event.getDamager();
		if(p.getName().equals(playerName)){
			Material m=p.getItemInHand().getType();
			if(m.equals(Material.WOODEN_PICKAXE)||m.equals(Material.STONE_PICKAXE)||m.equals(Material.IRON_PICKAXE)||m.equals(Material.DIAMOND_PICKAXE)){
				event.setDamage(4);
			}
		}
	}
}
