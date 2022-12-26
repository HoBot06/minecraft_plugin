package septagram.Theomachy.Ability.HUMAN;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

import septagram.Theomachy.Theomachy;
import septagram.Theomachy.Ability.Ability;
import septagram.Theomachy.DB.GameData;
import septagram.Theomachy.Utility.BlockFilter;
import septagram.Theomachy.Utility.CoolTimeChecker;
import septagram.Theomachy.Utility.EventFilter;
import septagram.Theomachy.Utility.PlayerInventory;
import septagram.Theomachy.Utility.Skill;

public class Teleporter extends Ability
{
	private final int coolTime1=30;
	private final int coolTime2=40;
	private final Material material=Material.COBBLESTONE;
	private final int stack1=8;
	private final int stack2=5;
	private String abilitytarget;
	private final static String[] des= {"�����̵��� ���� �������Դϴ�.",
			   "��Ŭ������ �ڽ��� 25�� �̳��� ����Ű�� �ִ� ������ �ڷ���Ʈ�մϴ�." ,
			   "��Ŭ������ Ÿ�ٿ� ����� �� �ڽ��� ������ ��ġ�� ġȯ�մϴ�.",
			   "��ǥ ����: /x <���>"};
	
	public Teleporter(String playerName)
	{
		super(playerName,"�ڷ�����", 104, true, false, false, des);
		Theomachy.log.info(playerName+abilityName);
		
		this.cool1=coolTime1;
		this.cool2=coolTime2;
		this.sta1=stack1;
		this.sta2=stack2;
		
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
			case 2:case 3:
				rightAction(player);
				break;
			}
		}
	}

	private void leftAction(Player player)
	{
		if (CoolTimeChecker.Check(player, 1)&&PlayerInventory.ItemCheck(player, material, stack1))
		{
			Block block = player.getTargetBlock(null, 25);
			if (BlockFilter.AirToFar(player, block))
			{
				Location location0 = block.getLocation();
				Location location1 = block.getLocation();
				location0.setY(location0.getY()+1);
				location1.setY(location1.getY()+2);
				Block block0 = location0.getBlock();
				Block block1 = location1.getBlock();
				if ((block0.getType()==Material.AIR || block1.getType() == Material.SNOW)&&block1.getType()==Material.AIR)
				{
					Skill.Use(player, material, stack1, 1, coolTime1);
					Location plocation = player.getLocation();
					Location tlocation = block.getLocation();
					tlocation.setPitch(plocation.getPitch());
					tlocation.setYaw(plocation.getYaw());
					tlocation.setY(tlocation.getY()+1);
					tlocation.setX(tlocation.getX()+0.5);
					tlocation.setZ(tlocation.getZ()+0.5);
					player.teleport(tlocation);
				}
				else
					player.sendMessage("�ڷ���Ʈ �� �� �ִ� ������ ���� �ڷ���Ʈ�� ���� �߽��ϴ�.");
			}
		}
	}
	
	private void rightAction(Player player)
	{
		if (CoolTimeChecker.Check(player, 2)&&PlayerInventory.ItemCheck(player, material, stack2))
		{
			if (abilitytarget != null)
			{
				Player target = GameData.OnlinePlayer.get(abilitytarget);
				if (target != null)
				{
					Location location = player.getLocation();
					location.setY(location.getY()-1);
					Skill.Use(player, material, stack2, 2, coolTime2);
					Location tloc = target.getLocation();
					Location ploc = player.getLocation();
					target.teleport(ploc);
					player.teleport(tloc);
					target.sendMessage("�ڷ������� �ɷ¿� ���� ��ġ�� �ڷ������� ��ġ�� ����Ǿ����ϴ�.");
				}
				else
					player.sendMessage("�÷��̾ �¶����� �ƴմϴ�.");
			}
			else
				player.sendMessage("Ÿ���� �������� �ʾҽ��ϴ�. (Ÿ�� ��Ϲ� : /x <Player>)");
		}
	}
	
	public void targetSet(CommandSender sender, String targetName)
	{
		String playerTeamName = GameData.PlayerTeam.get(playerName);
		String targetTeamName = GameData.PlayerTeam.get(targetName);
		if (playerTeamName != null &&
			targetTeamName != null &&
			playerTeamName.equals(targetTeamName))
		{
			if (!playerName.equals(targetName))
			{
				this.abilitytarget = targetName;
				sender.sendMessage("Ÿ���� ����߽��ϴ�.   "+ChatColor.GREEN+targetName);
			}
			else
				sender.sendMessage("�ڱ� �ڽ��� Ÿ������ ��� �� �� �����ϴ�.");
		}
		else
			sender.sendMessage("�ڽ��� ���� ����� �ƴմϴ�.");		
	}
}
