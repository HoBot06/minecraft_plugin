package septagram.Theomachy.Ability.DLC;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;

import septagram.Theomachy.Theomachy;
import septagram.Theomachy.Ability.Ability;
import septagram.Theomachy.DB.GameData;
import septagram.Theomachy.Handler.CommandModule.AbilitySet;
import septagram.Theomachy.Timer.Skill.EiEiTimer;
import septagram.Theomachy.Utility.CoolTimeChecker;
import septagram.Theomachy.Utility.EventFilter;
import septagram.Theomachy.Utility.PlayerInventory;
import septagram.Theomachy.Utility.Skill;

public class EiEi extends Ability
{
	private final int duration=60;
	private final int coolTime1=90;
	private final Material material1=Material.COBBLESTONE;
	private final int stack1=30;
	private String abilitytarget;
	
	private final static String[] des= {"돚거형 능력입니다.",
			   "능력사용시 지정한 플레이어의 능력을 일정시간동안 복사해옵니다",
			   "목표 지정: /x <대상>"};
	
	public EiEi(String playerName)
	{
		super(playerName,"김티티", 206, true, false, false, des);
		Theomachy.log.info(playerName+abilityName);
		
		this.cool1=coolTime1;
		this.sta1=stack1;
		
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

	private void leftAction(Player player)
	{
		if (CoolTimeChecker.Check(player, 0)&&PlayerInventory.ItemCheck(player, material1, stack1))
		{
			if (abilitytarget != null)
			{
				Player target = GameData.OnlinePlayer.get(abilitytarget);
				if (target != null)
				{
					Skill.Use(player, material1, stack1, 0, 0);
					Ability ability=GameData.PlayerAbility.get(abilitytarget);
					AbilitySet.abiltiyAssignment(ability.abilityCode, player.getName(), player);
					EiEiTimer EET = new EiEiTimer(player, duration, coolTime1);
					EET.runTaskTimer(Theomachy.getPlugin(Theomachy.class), 0, 20L);
					player.sendMessage("능력이 교체되었습니다 [ 남은시간 : "+ duration +"초 ]");
				}
				else
					player.sendMessage("플레이어가 온라인이 아닙니다.");
			}
			else
				player.sendMessage("타겟이 지정되지 않았습니다. (타겟 등록법 : /x <Player>)");
		}
	}
	
	public void targetSet(CommandSender sender, String targetName)
	{
		if (!playerName.equals(targetName))
		{
			this.abilitytarget = targetName;
			sender.sendMessage("타겟을 등록했습니다.   "+ChatColor.GREEN+targetName);
		}
		else
			sender.sendMessage("자기 자신을 타겟으로 등록 할 수 없습니다.");	
	}
}
