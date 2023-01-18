package septagram.Theomachy.Ability.DLC;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import septagram.Theomachy.Theomachy;
import septagram.Theomachy.Ability.Ability;
import septagram.Theomachy.Utility.CoolTimeChecker;
import septagram.Theomachy.Utility.EventFilter;
import septagram.Theomachy.Utility.PlayerInventory;
import septagram.Theomachy.Utility.Skill;
import septagram.Theomachy.Utility.Sounds;

public class Evlove extends Ability
{
	private final int coolTime1=0;
	private final int coolTime2=0;
	private final Material material1=Material.COBBLESTONE;
	private final Material material2=Material.COBBLESTONE;
	private final int stack1=0;
	private final int stack2=0;
	private boolean is_sound=false;
	//0=일반 1=레이스 2=그리드 3=베헤모스
	private int Evlove_Type=0;
	private int Evlove_Power=0;
	private int Evlove_Point=0;
	private final int Evlove_Max=40;
	private double D_dis=0;
	private final static String[] des= {"진화형 능력입니다.",
			   "플레이어를 죽일때 죽은 플레이어 위치에 DNA 고기를 남깁니다",
			   "해당 고기를 먹을때마다 진화포인트를 얻습니다.",
			   "일전 진화포인트를 모을때마다 진화합니다.",
			   "일반능력으로 진화 포인트를 확인하가능하고",
			   "고급능력으로 현재 상태를 알 수 있습니다."};
	
	public Evlove(String playerName)
	{
		super(playerName,"이볼브", 211, true, true, false, des);
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
			player.sendMessage("현재 진화레벨 : " + Evlove_Power + ".Lv");
			player.sendMessage("현재 포인트 : " + Evlove_Point + "/" + Evlove_Max);
		}
	}
	
	private void rightAction(Player player)
	{
		if (CoolTimeChecker.Check(player, 2)&&PlayerInventory.ItemCheck(player, material2, stack2))
		{
			Skill.Use(player, material2, stack2, 2, coolTime2);
			switch(Evlove_Type) {
			case 0: 
				player.sendMessage("상태 : 일반");
				player.sendMessage("매우 흉측한 괴물입니다.");
				break;
			case 1: 
				player.sendMessage("상태 : 레이스");
				player.sendMessage("움직이는 도중 웅크릴시 은신상태가 됩니다. 단 약간씩 소리가 들립니다.");
				break;
			case 2: 
				player.sendMessage("상태 : 그리드");
				player.sendMessage("고깃덩어리의 회복량이 증가하고 추가 효과가 붙습니다");
				player.sendMessage("또한 배고픔이 고정되고 드랍이 증가합니다");
				player.sendMessage("현재 증가량 : " + (Evlove_Power + 4));
				break;
			case 3: 
				player.sendMessage("상태 : 베헤모스");
				player.sendMessage("데미지를 감소해서 받습니다");
				player.sendMessage("현재 감소량 : " + (int)D_dis + "%");
				break;
			}
		}
	}
	
	public void T_Passive(PlayerMoveEvent event)
	{
		Player player = event.getPlayer();
		if(player.getName().equalsIgnoreCase(playerName)&&Evlove_Type==1) {
			if(player.isSneaking()) {
				player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 5, 0),true);
				if(!is_sound) {
					for(Player p : Bukkit.getOnlinePlayers()) {
						Sounds.SoundPL(p, player.getLocation(), Sound.ENTITY_GHAST_HURT, 0.1f, 0.1f);
					}
					is_sound=true;
					new BukkitRunnable() {
						@Override
						public void run() {
							is_sound = false;
						}
					}.runTaskLater(Theomachy.getPlugin(Theomachy.class), 40);
				}
			}
		}
	}
	
	public void T_Passive(PlayerDeathEvent event)
	{
		Player player = event.getEntity();
		if(event.getEntity().getKiller().getName().equalsIgnoreCase(playerName)) {
			int am = 1;
			if(Evlove_Type==2) am=3;
			ItemStack DNA = new ItemStack(Material.BEEF, am);
			ItemMeta DNA_M = DNA.getItemMeta();
			DNA_M.setDisplayName(ChatColor.RED + "고깃덩어리");
			DNA.setItemMeta(DNA_M);
			player.getWorld().dropItem(event.getEntity().getLocation(), DNA);
		}
	}
	
	public void T_Passive(FoodLevelChangeEvent event) {
		if(event.getEntity().getName().equalsIgnoreCase(playerName)&&Evlove_Type==2) {
			event.setFoodLevel(16);
		}
	}
	
	public void T_Passive(EntityDamageEvent event)
	{
		if(event.getEntity() instanceof Player) {
			Entity player = event.getEntity();
			if(player.getName().equalsIgnoreCase(playerName)) {
				if(Evlove_Type==3) {
					event.setDamage((double)(event.getDamage() - (event.getDamage()/100d*D_dis)));
				}
			}
		}
	}
	
	public void T_PassiveItem(PlayerItemConsumeEvent event) {
		Player player = (Player) event.getPlayer();
		if(player.getName().equalsIgnoreCase(playerName)) {
			int GetEvlove = 0;
			if(ChatColor.stripColor(event.getItem().getItemMeta().getDisplayName()).equalsIgnoreCase("고깃덩어리") && event.getItem().getType() == Material.BEEF) {
				GetEvlove=20;
			}
			else {
				GetEvlove++;
			}
			if(player instanceof LivingEntity && Evlove_Type!=2) {
				player.sendMessage(ChatColor.RED + "진화 포인트 획득");
				Evlove_Point = Evlove_Point+GetEvlove;
			}
			else if(player instanceof LivingEntity && Evlove_Type==2){
				if(GetEvlove==20) {
					double max_health = ((LivingEntity) player).getMaxHealth();
					double now_health = ((LivingEntity) player).getHealth();
					player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 1200, 0),true);
					player.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 1200, 4),true);
					((LivingEntity) player).setHealth(Math.min(now_health + Evlove_Power + 4, max_health));
				}
				Evlove_Point = Evlove_Point+GetEvlove;
			}
			if(Evlove_Point >= Evlove_Max) {
				Evlove_Power++;
				Evlove_Point=Evlove_Point-Evlove_Max;
				player.sendMessage(ChatColor.WHITE + "진화 완료");
				if(Evlove_Type==0) {
					Random r = new Random();
					int rn = r.nextInt(3) + 1;
					switch(rn) {
					case 1: Evlove_Type=1; Bukkit.broadcastMessage(ChatColor.DARK_BLUE + "으스스한 기운이 느껴진다"); break;
					case 2: Evlove_Type=2; Bukkit.broadcastMessage(ChatColor.GOLD + "끝없는 탐욕의 냄새가 난다"); break;
					case 3: Evlove_Type=3; D_dis=((Evlove_Power/(Evlove_Power+5d))*100d); Bukkit.broadcastMessage(ChatColor.DARK_RED + "뜨거운 숨결이 느껴진다"); break;
					}
				}
				else if(Evlove_Type==3) D_dis=((Evlove_Power/(Evlove_Power+5d))*100d);
			}
		}
	}

}
