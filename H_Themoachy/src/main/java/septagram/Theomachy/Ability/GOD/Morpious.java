package septagram.Theomachy.Ability.GOD;

import java.util.Timer;
import java.util.TimerTask;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import septagram.Theomachy.Ability.Ability;
import septagram.Theomachy.DB.GameData;
import septagram.Theomachy.Utility.CoolTimeChecker;
import septagram.Theomachy.Utility.EventFilter;
import septagram.Theomachy.Utility.PlayerInventory;
import septagram.Theomachy.Utility.Skill;

public class Morpious extends Ability{

	private final static String[] des= {"���� ���Դϴ�.",
			"�Ϲݴɷ����� ��ǥ ������ ���� 1�а� ���� �մϴ�.",
			"��ǥ ����: /x <���>"};
 	
	private final int coolTime1=180;
	private final int stack1=32;

	private String abilitytarget;
	
	public Morpious(String playerName) {
		super(playerName, "���ǿ콺", 15, true, false, false, des);
		
		this.rank=3;
		
		this.cool1=coolTime1;
		this.sta1=stack1;
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

	private void leftAction(Player player){
		if (CoolTimeChecker.Check(player, 1)&&PlayerInventory.ItemCheck(player, Material.COBBLESTONE, stack1))
		{
			String[] team = new String[2];
			team[0]=GameData.PlayerTeam.get(player.getName());
			team[1]=GameData.PlayerTeam.get(abilitytarget);
					
			if(team[0]!=team[1]){
			if(abilitytarget!=null){
				if(player.getName().equals(abilitytarget)){
					player.sendMessage(ChatColor.RED+"��ǥ�� ������ �ƴϾ�� �մϴ�.");
				}
				
				else{
					Player target = GameData.OnlinePlayer.get(abilitytarget);
					Skill.Use(player, Material.COBBLESTONE, stack1, 1, coolTime1);
					player.sendMessage(ChatColor.GRAY+"��ǥ�� ��������ϴ�!");
					target.sendMessage(ChatColor.GRAY+"���� ��̴� ���� �ڰ� ���� �Ͼ�� �ؿ�~");
					target.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 1200,0), true);
					target.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 1200, 3), true);
					Timer t = new Timer();
					t.schedule(new M(player, target), 57000, 1000);
				}
				
			}
			else{
				player.sendMessage("��ǥ�� �������ֽʽÿ�. (��ǥ ������: /x <��ǥ>)");
			}
			}
			else{
				player.sendMessage(ChatColor.GRAY+"������ ���̹Ƿ� ���� ��� �� �����ϴ�!");
			}
		}
	}
	
	public void targetSet(CommandSender sender, String targetName)
	{
			if (!playerName.equals(targetName))
			{
				this.abilitytarget = targetName;
				sender.sendMessage("Ÿ���� ����߽��ϴ�.   "+ChatColor.GREEN+targetName);
			}
			else
				sender.sendMessage("�ڱ� �ڽ��� ��ǥ�� ��� �� �� �����ϴ�.");
	}
}

class M extends TimerTask{

	private int count=3;
	private Player p;
	private Player t;
	
	public M (Player p, Player t){
		this.p=p;
		this.t=t;
	}
	
	@Override
	public void run() {
		if(count==0){
			t.sendMessage("�ῡ�� ������ϴ�!");
			p.sendMessage("������ �ɾ��� ��밡 �ῡ�� ������ϴ�!");
			this.cancel();
		}
		else{
			t.sendMessage(ChatColor.DARK_AQUA+"�ῡ�� ����� ������ "+ChatColor.WHITE+count+ChatColor.DARK_AQUA+"�� ���Դϴ�.");
			p.sendMessage(ChatColor.DARK_AQUA+"��밡 �ῡ�� ����� ������ "+ChatColor.WHITE+count+ChatColor.DARK_AQUA+"�� ���Դϴ�.");
		}
		count--;
	}

}
