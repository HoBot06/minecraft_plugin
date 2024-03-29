package septagram.Theomachy.Timer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.TimerTask;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Difficulty;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Animals;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import septagram.Theomachy.Theomachy;
import septagram.Theomachy.Ability.Ability;
import septagram.Theomachy.DB.GameData;
import septagram.Theomachy.Handler.CommandModule.GameHandler;
import septagram.Theomachy.Utility.PlayerInventory;


public class GameReadyTimer extends BukkitRunnable
{
	public int count=1;
	public void run()
	{		
		if (GameHandler.Ready && count<45)
		{
			String[] setting = new String[8];
			Difficulty difficulty;
			World world = Bukkit.getWorld("world");;
			setting[0] = Theomachy.INVENTORY_CLEAR ? ChatColor.AQUA+"ON" : ChatColor.RED+"OFF";
			setting[1] = Theomachy.GIVE_ITEM ? ChatColor.AQUA+"ON" : ChatColor.RED+"OFF";
			setting[2] = Theomachy.IGNORE_BED ? ChatColor.AQUA+"ON" : ChatColor.RED+"OFF";
			setting[3] = Theomachy.AUTO_SAVE ? ChatColor.AQUA+"ON" : ChatColor.RED+"OFF";
			setting[4] = Theomachy.ANIMAL ? ChatColor.AQUA+"ON" : ChatColor.RED+"OFF";
			setting[5] = Theomachy.MONSTER ? ChatColor.AQUA+"ON" : ChatColor.RED+"OFF";
			setting[7] = Theomachy.ENTITIES_REMOVE ? ChatColor.AQUA+"ON" : ChatColor.RED+"OFF";
			difficulty=null;
			switch (Theomachy.DIFFICULTY)
			{
			case 0:
				setting[6] = ChatColor.GREEN + "평화로움";
				difficulty = Difficulty.PEACEFUL;
				break;
			case 1:
				setting[6] = ChatColor.AQUA + "쉬움";
				difficulty = Difficulty.EASY;
				break;
			case 2:
				setting[6] = ChatColor.YELLOW + "보통";
				difficulty = Difficulty.NORMAL;
				break;
			case 3:
				setting[6] = ChatColor.GREEN + "어려움";
				difficulty = Difficulty.HARD;
				break;
			default:
				setting[6] = ChatColor.GREEN + "쉬움";
				difficulty = Difficulty.EASY;
			}
			List<Player> playerList = new ArrayList<>(Bukkit.getOnlinePlayers());
			switch(count)
			{
			case 4:
				Bukkit.broadcastMessage(ChatColor.RED+"신들의 전쟁 플러그인은 스카이블럭 전용이며 야생,하드코어로는 부적합합니다");
				Bukkit.broadcastMessage(ChatColor.RED+"이점을 숙지 하시고 게임을 즐기시길 바랍니다.");
				break;
			case 8:
				Bukkit.broadcastMessage(ChatColor.AQUA+"현 플러그인은 1.5.2 신전 플러그인을 기반으로 만들어졌습니다");
				Bukkit.broadcastMessage(ChatColor.GREEN+"배포는 생각중입니다");
				break;
			case 12:
				Bukkit.broadcastMessage(ChatColor.GREEN+"****** 서버 세팅상태 ******");
				Bukkit.broadcastMessage(ChatColor.WHITE+"게임 시작 시 인벤토리 클리어 : "+setting[0]);
				Bukkit.broadcastMessage(ChatColor.WHITE+"게임 시작 시 기본 아이템 지급 : "+setting[1]);
				Bukkit.broadcastMessage(ChatColor.WHITE+"게임 시작 시 엔티티 삭제 : "+setting[7]);
				Bukkit.broadcastMessage(ChatColor.WHITE+"부활 시 침대 무시 : "+setting[2]);
				Bukkit.broadcastMessage(ChatColor.WHITE+"서버 자동 저장 : "+setting[3]);
				Bukkit.broadcastMessage(ChatColor.WHITE+"동물 스폰 : "+setting[4]);
				Bukkit.broadcastMessage(ChatColor.WHITE+"몬스터 스폰 : "+setting[5]);
				Bukkit.broadcastMessage(ChatColor.WHITE+"서버 난이도 : "+setting[6]);
				Bukkit.broadcastMessage(ChatColor.GREEN+"***************************");
				break;
			case 16:
				Bukkit.broadcastMessage(ChatColor.DARK_GREEN+"현재 인식된 플레이어 목록");
				for (int i=0; i<playerList.size(); i++)
					Bukkit.broadcastMessage(i+1+".  "+ChatColor.GOLD+playerList.get(i).getName());
				break;
			case 20:
				Bukkit.broadcastMessage(ChatColor.AQUA+"현재 능력이 적용되지 않은 플레이어 목록");
				for (int i=0; i<playerList.size(); i++)
				{
					if (!GameData.PlayerAbility.containsKey(playerList.get(i).getName()))
					{
						Bukkit.broadcastMessage(i+1+".  "+ChatColor.GOLD+playerList.get(i).getName());
					}
				}
				break;
			case 24:
				Bukkit.broadcastMessage(ChatColor.BLUE+"현재 팀이 적용되지 않은 플레이어 목록");
				for (int i=0; i<playerList.size(); i++)
				{
					if (!GameData.PlayerTeam.containsKey(playerList.get(i).getName()))
					{
						Bukkit.broadcastMessage(i+1+".  "+ChatColor.GOLD+playerList.get(i).getName());
					}
				}
				break;
			case 29:
				Bukkit.broadcastMessage("원작자 : "+ChatColor.AQUA+"Septagram(칠각별)");
				Bukkit.broadcastMessage("버그 신고 사항은 "+ChatColor.DARK_GREEN+"hobot06@naver.com "+ChatColor.WHITE+"으로 로그를 보내주세요");
				break;
			case 34:
				Bukkit.broadcastMessage(ChatColor.AQUA+"잠시 후 팀 스폰지역으로 텔레포트 됩니다");
				break;
			case 35: 
				Bukkit.broadcastMessage(ChatColor.RED+"5초 전");
				break;
			case 36:
				Bukkit.broadcastMessage(ChatColor.RED+"4초 전");
				break;
			case 37:
				Bukkit.broadcastMessage(ChatColor.RED+"3초 전");
				break;
			case 38:
				Bukkit.broadcastMessage(ChatColor.RED+"2초 전");
				break;
			case 39:
				Bukkit.broadcastMessage(ChatColor.RED+"1초 전");
				break;
			case 40:
				if (Theomachy.ENTITIES_REMOVE)
				{
					try{
						List<Entity> entities = world.getEntities();
						for (Entity e : entities)
						{
							if (e instanceof Item || e instanceof Monster || e instanceof Animals)
								e.remove();
						}
					}catch(NullPointerException e){}
				}
				Location spawnLocation = world.getSpawnLocation();
				Bukkit.broadcastMessage(ChatColor.AQUA+"스폰 지역으로 텔레포트 합니다");
				for (Player e : playerList)
				{
					e.setFoodLevel(20);
					e.setSaturation(10f);
					e.setLevel(0);
					e.setExhaustion(0.0F);
					e.setExp(0.0F);
					e.setHealth(20);
					PlayerInventory.skyBlockBasicItemAdd(e);					
					String teamName = GameData.PlayerTeam.get(e.getName());
					if (teamName !=null)
					{
						Location location = GameData.SpawnArea.get(teamName);
						if (location != null)
							e.teleport(location);
						else
						{
							e.sendMessage(ChatColor.RED+"팀의 스폰지역이 설정되지 않아 기본 스폰지역으로 이동합니다.");
							e.teleport(spawnLocation);
						}
					}
					else
					{
						e.sendMessage(ChatColor.RED+"팀이 지정되지 않아 기본 스폰지역으로 이동합니다.");
						e.teleport(spawnLocation);
					}
				}
				world.setPVP(true);
				world.setAutoSave(Theomachy.AUTO_SAVE);
				world.setSpawnFlags(Theomachy.MONSTER, Theomachy.ANIMAL);
				world.setDifficulty(difficulty);
				world.setTime(6000);
				Collection<Ability> playerAbilityList = GameData.PlayerAbility.values();
				for (Ability e : playerAbilityList)
				{
					e.conditionSet();
					e.buff();
				}
				Bukkit.broadcastMessage(ChatColor.GOLD+"게임 시작!");
				break;
			}
		}
		else
			this.cancel();
		count++;
	}
}
