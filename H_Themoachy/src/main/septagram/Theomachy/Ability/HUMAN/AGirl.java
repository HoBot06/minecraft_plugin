package septagram.Theomachy.Ability.HUMAN;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import septagram.Theomachy.Ability.Ability;
import septagram.Theomachy.Utility.CoolTimeChecker;
import septagram.Theomachy.Utility.EventFilter;
import septagram.Theomachy.Utility.GetPlayerList;
import septagram.Theomachy.Utility.PlayerInventory;
import septagram.Theomachy.Utility.Skill;

public class AGirl extends Ability{

	private final static String[] des= {"귀여움으로 상대를 굶어죽이는 능력입니다.",
											  "블레이즈 로드 좌클릭 시 주변 5칸 이내의",
											  "플레이어를 자신의 앞으로 끌어옵니다.",
											  "끌려 온 플레이어들의 배고픔 지수는 0이 됩니다."};
	
	public AGirl(String playerName) {
		super(playerName, "안락소녀", 127, true, false, false, des);
		
		this.rank= 3;
		this.cool1=60;
		this.sta1=15;
	}
	
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
		if(CoolTimeChecker.Check(player, 0)&&PlayerInventory.ItemCheck(player, Material.COBBLESTONE, sta1)) {
			
			Skill.Use(player, Material.COBBLESTONE, sta1, 0, cool1);
			
			for(Player e:GetPlayerList.getNearByNotTeamMembers(player, 5, 0, 5)) {
				e.teleport(player);
				e.setFoodLevel(0);
				e.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 2, 200));
				e.sendMessage(ChatColor.GREEN+"안락소녀"+ChatColor.WHITE+"에게 이끌려 갑니다!");
			}
		}
	}

}
