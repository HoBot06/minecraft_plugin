package septagram.Theomachy.Ability.HUMAN;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import septagram.Theomachy.Theomachy;
import septagram.Theomachy.Ability.Ability;
import septagram.Theomachy.DB.GameData;
import septagram.Theomachy.Timer.Skill.SnipingDuration;
import septagram.Theomachy.Utility.CoolTimeChecker;
import septagram.Theomachy.Utility.EventFilter;
import septagram.Theomachy.Utility.PlayerInventory;
import septagram.Theomachy.Utility.Skill;
import septagram.Theomachy.Utility.Sounds;

public class Sniper extends Ability
{
	private final int coolTime0=70;
	private final Material material=Material.COBBLESTONE;
	private final int stack0=1;
	public boolean ready = false;
	public boolean isdrop = false;
	public boolean sniping = false;
	private final static String[] des= {"빠른 화살을 이용해 상대방을 공격하는 능력입니다.",
			   "게임 시작시 활 1개 화살 10개를 지급합니다. " ,
			   "활을 들고 앉은 채(shift) 좌클릭하면 4초뒤 스나이핑 모드가 활성화됩니다." ,
			   "스나이핑 모드일시 쏜 화살이 타겟방향으로 보이지 않는 속도로",
			   "날아가며 맞은 적은 약 100~200의 데미지를 입습니다.",
			   "활은 인벤세이브가 되고 플레이어를 죽일때 마다 화살 1개가 지급됩니다"};
	
	public Sniper(String playerName)
	{
		super(playerName, "저격수", 118, true, false, false, des);
		this.cool1=coolTime0;
		this.sta1=stack0;
		
		this.rank=3;
	}
	
	public void T_Active(PlayerInteractEvent event)
	{
		Player player = event.getPlayer();
		if (PlayerInventory.InHandItemCheck(player, Material.BOW))
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
		if (player.isSneaking() && !ready)
		{
			ready=true;
			BukkitRunnable SnipingD = new SnipingDuration(player, this);
			SnipingD.runTaskTimer(Theomachy.getPlugin(Theomachy.class), 0, 20L);
		}
	}
	
	@Override
	public void T_Passive(ProjectileLaunchEvent event, Player player)
	{
		if (this.sniping && (CoolTimeChecker.Check(player, 0)&&PlayerInventory.ItemCheck(player, material, stack0)))
		{
			Entity entity = event.getEntity();
			if (entity instanceof Arrow)
			{
				Skill.Use(player, material, stack0, 0, coolTime0);
				entity.remove();
				Arrow arrow = player.launchProjectile(Arrow.class);
				arrow.setVelocity(player.getEyeLocation().getDirection().multiply(100));
				for(Player p : Bukkit.getOnlinePlayers()) {
					Sounds.SoundPL(p, player.getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 1.5f, 2.0f);
				}
			}
		}
	}
	
	public void T_Passive(PlayerDeathEvent event)
	{
		if(event.getEntity().getName().equalsIgnoreCase(playerName)) {
			event.getDrops().removeIf(itemStack -> {
				if(itemStack.getType() == Material.BOW) {
					isdrop = true;
					return true;
				}
				return false;
			});
		}
		if(event.getEntity().getKiller() != null) {
			if(event.getEntity().getKiller().getName().equalsIgnoreCase(playerName)) {
				event.getEntity().getKiller().getInventory().addItem(new ItemStack(Material.ARROW, 1));
			}
		}
	}
	
	public void T_Passive(PlayerRespawnEvent event)
	{
		if(event.getPlayer().getName().equalsIgnoreCase(playerName)) {
			if(isdrop) {
				isdrop=false;
				event.getPlayer().getInventory().addItem(new ItemStack(Material.BOW, 1));
			}
		}
	}
	
	@Override
	public void conditionSet()
	{
		Player player = GameData.OnlinePlayer.get(this.playerName);
		player.getInventory().addItem(new ItemStack(Material.BOW, 1));
		player.getInventory().addItem(new ItemStack(Material.ARROW, 10));
	}
}
