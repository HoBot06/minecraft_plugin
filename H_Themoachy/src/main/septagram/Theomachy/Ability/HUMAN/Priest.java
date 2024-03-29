package septagram.Theomachy.Ability.HUMAN;

import java.util.List;
import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import septagram.Theomachy.Theomachy;
import septagram.Theomachy.Ability.Ability;
import septagram.Theomachy.Utility.CoolTimeChecker;
import septagram.Theomachy.Utility.EventFilter;
import septagram.Theomachy.Utility.GetPlayerList;
import septagram.Theomachy.Utility.PlayerInventory;
import septagram.Theomachy.Utility.Skill;

public class Priest extends Ability
{
	private final int coolTime1=30;
	private final int coolTime2=90;
	private final Material material=Material.COBBLESTONE;
	private final int stack1=5;
	private final int stack2=10;
	private final static String[] des= {
				"버프를 사용 할 수 있는 능력입니다.",
			   "블레이즈 로드를 이용해서 능력을 사용할 수 있습니다." ,
			   "일반능력은 자신에게 랜덤으로 버프를 적용합니다." ,
			   "고급능력은 자신을 포함한 자신의 모든 팀원에게 ",
			   "랜덤으로 버프를 적용합니다."};
	
	public Priest(String playerName)
	{
		super(playerName,"사제", 115, true, false,false, des);
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
			Skill.Use(player, material, stack1, 1, coolTime1);
			Random random = new Random();
			if (random.nextInt(2)==0)
			{
				player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 600,0),true);
				player.sendMessage(ChatColor.LIGHT_PURPLE+"데미지 저항 효과가 적용되었습니다.");
			}
			if (random.nextInt(2)==0)
			{
				player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 600,0),true);
				player.sendMessage(ChatColor.RED+"데미지 증가 효과가 적용되었습니다.");
			}
			if (random.nextInt(2)==0)
			{
				player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 600,0),true);
				player.sendMessage(ChatColor.GOLD+"체력회복속도 증가 효과가 적용되었습니다.");
			}
			if (random.nextInt(2)==0)
			{
				player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 600,0),true);
				player.sendMessage(ChatColor.AQUA+"이동속도 증가 효과가 적용되었습니다.");
			}
			if (random.nextInt(2)==0)
			{
				player.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 600,0),true);
				player.sendMessage(ChatColor.GREEN+"빠른 채광 효과가 적용되었습니다.");
			}
		}
	}
	
	private void rightAction(Player player)
	{
		if (CoolTimeChecker.Check(player, 2)&&PlayerInventory.ItemCheck(player, material, stack2))
		{
			Skill.Use(player, material, stack2, 2, coolTime2);
			List<Player> targetList = GetPlayerList.getTeamMember(player);
			if (targetList != null)
			{
				Random random = new Random();
				for (Player e : targetList)
				{
					if (random.nextInt(2)==0)
					{
						e.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 600,0),true);
						e.sendMessage(ChatColor.LIGHT_PURPLE+"데미지 저항 효과가 적용되었습니다.");
					}
					if (random.nextInt(2)==0)
					{
						e.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 600,0),true);
						e.sendMessage(ChatColor.RED+"데미지 증가 효과가 적용되었습니다.");
					}
					if (random.nextInt(2)==0)
					{
						e.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 600,0),true);
						e.sendMessage(ChatColor.GOLD+"체력회복속도 증가 효과가 적용되었습니다.");
					}
					if (random.nextInt(2)==0)
					{
						e.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 600,0),true);
						e.sendMessage(ChatColor.AQUA+"이동속도 증가 효과가 적용되었습니다.");
					}
					if (random.nextInt(2)==0)
					{
						e.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 600,0),true);
						e.sendMessage(ChatColor.GREEN+"빠른 채광 효과가 적용되었습니다.");
					}
				}
			}
		}
	}
}
