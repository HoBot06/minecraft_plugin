package septagram.Theomachy.Ability.HUMAN;

import java.util.Timer;
import java.util.TimerTask;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Tag;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import septagram.Theomachy.Ability.Ability;
import septagram.Theomachy.DB.GameData;
import septagram.Theomachy.Utility.CoolTimeChecker;
import septagram.Theomachy.Utility.PlayerInventory;
import septagram.Theomachy.Utility.Skill;

public class Voodoo extends Ability
{
	private final int coolTime0=180;
	private final Material material=Material.COBBLESTONE;
	private final int stack0=10;
	private String targetName=null;
	private Block postSign=null;
	private final static String[] des= {"�ָ��� �̿��ؼ� ��븦 Ÿ���� �� �ִ� �ɷ��Դϴ�.",
			   "�ָ��� Ÿ���� ����� �̸��� ������ ",
			   "�� ���̵� ���� �÷��̾�� �ָ��� ����Ǹ�" ,
			   "�ָ��� �ε�� �ӽ� ��� �÷��̾ �������� �Խ��ϴ�." ,
			   "��ġ�� 7�ʵ��� ȿ���� ���ӵǸ� 7�� �Ŀ� �ڵ����� �ָ��� �ν����ϴ�." ,
			   "�������� ������ ������ ���� �ʽ��ϴ�." ,
			   "��Ÿ���� �ָ��� ��ä ��Ŭ���ϸ� �� �� ���� Ȯ�� �� �� �ֽ��ϴ�."};
	
	public Voodoo(String playerName)
	{
		super(playerName, "�εμ���", 119, true, true, false, des);
		this.cool1=coolTime0;
		this.sta1=stack0;
		
		this.rank=3;
	}

	public void T_Passive(BlockPlaceEvent event)
	{
		Material block = event.getBlock().getType();
		if (Tag.STANDING_SIGNS.isTagged(block) || Tag.WALL_SIGNS.isTagged(block))
		{
			Player player = event.getPlayer();

			if (!(CoolTimeChecker.Check(player, 0)&&PlayerInventory.ItemCheck(player, material, stack0)))
				event.setCancelled(true);
		}
	}
	
	public void T_Active(PlayerInteractEvent event)
	{
		if (this.postSign != null)
		{
			if (event.getAction() == Action.LEFT_CLICK_BLOCK)
			{
				Block block = event.getClickedBlock();
				if ((Tag.WALL_SIGNS.isTagged(block.getType())|| Tag.STANDING_SIGNS.isTagged(block.getType()))&& this.postSign.getState().equals(block.getState()))
				{
					Player player = GameData.OnlinePlayer.get(targetName);
					if (player != null)
						player.damage(1, event.getPlayer());

				}
			}
		}
		else if (Tag.SIGNS.isTagged(event.getPlayer().getItemInHand().getType()))
		{
			Action action = event.getAction();
			if (action == Action.LEFT_CLICK_AIR || action == Action.LEFT_CLICK_BLOCK)
			{
				Player player = event.getPlayer();
				if (CoolTimeChecker.Check(player, 0) && PlayerInventory.ItemCheck(player, material, stack0))
					player.sendMessage("��ų�� ��� �� �� �ֽ��ϴ�.");
			}
		}
	}
	
	public void T_Passive(SignChangeEvent event)
	{
		Player player = event.getPlayer();
		String targetName = event.getLine(0);
		Player target = GameData.OnlinePlayer.get(targetName);
		if (target != null)
		{
			Skill.Use(player, material, stack0, 0, coolTime0);
			this.targetName=targetName;
			this.postSign=event.getBlock();
			player.sendMessage(ChatColor.RED+targetName+ChatColor.WHITE+" ��(��) �ָ��� ������׽��ϴ�.");
			target.sendMessage(ChatColor.RED+"�εμ��簡 ����� �����մϴ�.");
			Timer t = new Timer();
			t.schedule(new Duration(), 7000);
		}
		else
			player.sendMessage(ChatColor.RED+targetName+ChatColor.WHITE+" �׷� �÷��̾�� ���µ���...");
	}

	
	private class Duration extends TimerTask
	{
		@Override
		public void run()
		{
			targetName=null;
			postSign.breakNaturally();
			postSign=null;
		}
		
	}
}
