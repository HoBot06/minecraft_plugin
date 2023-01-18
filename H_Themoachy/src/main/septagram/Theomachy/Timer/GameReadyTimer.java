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
				setting[6] = ChatColor.GREEN + "��ȭ�ο�";
				difficulty = Difficulty.PEACEFUL;
				break;
			case 1:
				setting[6] = ChatColor.AQUA + "����";
				difficulty = Difficulty.EASY;
				break;
			case 2:
				setting[6] = ChatColor.YELLOW + "����";
				difficulty = Difficulty.NORMAL;
				break;
			case 3:
				setting[6] = ChatColor.GREEN + "�����";
				difficulty = Difficulty.HARD;
				break;
			default:
				setting[6] = ChatColor.GREEN + "����";
				difficulty = Difficulty.EASY;
			}
			List<Player> playerList = new ArrayList<>(Bukkit.getOnlinePlayers());
			switch(count)
			{
			case 4:
				Bukkit.broadcastMessage(ChatColor.RED+"�ŵ��� ���� �÷������� ��ī�̺� �����̸� �߻�,�ϵ��ھ�δ� �������մϴ�");
				Bukkit.broadcastMessage(ChatColor.RED+"������ ���� �Ͻð� ������ ���ñ� �ٶ��ϴ�.");
				break;
			case 8:
				Bukkit.broadcastMessage(ChatColor.AQUA+"�� �÷������� 1.5.2 ���� �÷������� ������� ����������ϴ�");
				Bukkit.broadcastMessage(ChatColor.GREEN+"������ �������Դϴ�");
				break;
			case 12:
				Bukkit.broadcastMessage(ChatColor.GREEN+"****** ���� ���û��� ******");
				Bukkit.broadcastMessage(ChatColor.WHITE+"���� ���� �� �κ��丮 Ŭ���� : "+setting[0]);
				Bukkit.broadcastMessage(ChatColor.WHITE+"���� ���� �� �⺻ ������ ���� : "+setting[1]);
				Bukkit.broadcastMessage(ChatColor.WHITE+"���� ���� �� ��ƼƼ ���� : "+setting[7]);
				Bukkit.broadcastMessage(ChatColor.WHITE+"��Ȱ �� ħ�� ���� : "+setting[2]);
				Bukkit.broadcastMessage(ChatColor.WHITE+"���� �ڵ� ���� : "+setting[3]);
				Bukkit.broadcastMessage(ChatColor.WHITE+"���� ���� : "+setting[4]);
				Bukkit.broadcastMessage(ChatColor.WHITE+"���� ���� : "+setting[5]);
				Bukkit.broadcastMessage(ChatColor.WHITE+"���� ���̵� : "+setting[6]);
				Bukkit.broadcastMessage(ChatColor.GREEN+"***************************");
				break;
			case 16:
				Bukkit.broadcastMessage(ChatColor.DARK_GREEN+"���� �νĵ� �÷��̾� ���");
				for (int i=0; i<playerList.size(); i++)
					Bukkit.broadcastMessage(i+1+".  "+ChatColor.GOLD+playerList.get(i).getName());
				break;
			case 20:
				Bukkit.broadcastMessage(ChatColor.AQUA+"���� �ɷ��� ������� ���� �÷��̾� ���");
				for (int i=0; i<playerList.size(); i++)
				{
					if (!GameData.PlayerAbility.containsKey(playerList.get(i).getName()))
					{
						Bukkit.broadcastMessage(i+1+".  "+ChatColor.GOLD+playerList.get(i).getName());
					}
				}
				break;
			case 24:
				Bukkit.broadcastMessage(ChatColor.BLUE+"���� ���� ������� ���� �÷��̾� ���");
				for (int i=0; i<playerList.size(); i++)
				{
					if (!GameData.PlayerTeam.containsKey(playerList.get(i).getName()))
					{
						Bukkit.broadcastMessage(i+1+".  "+ChatColor.GOLD+playerList.get(i).getName());
					}
				}
				break;
			case 29:
				Bukkit.broadcastMessage("������ : "+ChatColor.AQUA+"Septagram(ĥ����)");
				Bukkit.broadcastMessage("���� �Ű� ������ "+ChatColor.DARK_GREEN+"hobot06@naver.com "+ChatColor.WHITE+"���� �α׸� �����ּ���");
				break;
			case 34:
				Bukkit.broadcastMessage(ChatColor.AQUA+"��� �� �� ������������ �ڷ���Ʈ �˴ϴ�");
				break;
			case 35: 
				Bukkit.broadcastMessage(ChatColor.RED+"5�� ��");
				break;
			case 36:
				Bukkit.broadcastMessage(ChatColor.RED+"4�� ��");
				break;
			case 37:
				Bukkit.broadcastMessage(ChatColor.RED+"3�� ��");
				break;
			case 38:
				Bukkit.broadcastMessage(ChatColor.RED+"2�� ��");
				break;
			case 39:
				Bukkit.broadcastMessage(ChatColor.RED+"1�� ��");
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
				Bukkit.broadcastMessage(ChatColor.AQUA+"���� �������� �ڷ���Ʈ �մϴ�");
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
							e.sendMessage(ChatColor.RED+"���� ���������� �������� �ʾ� �⺻ ������������ �̵��մϴ�.");
							e.teleport(spawnLocation);
						}
					}
					else
					{
						e.sendMessage(ChatColor.RED+"���� �������� �ʾ� �⺻ ������������ �̵��մϴ�.");
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
				Bukkit.broadcastMessage(ChatColor.GOLD+"���� ����!");
				break;
			}
		}
		else
			this.cancel();
		count++;
	}
}
