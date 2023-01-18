package septagram.Theomachy.Ability.HUMAN;

import java.util.Random;

import org.bukkit.ChatColor;
import org.bukkit.event.player.PlayerMoveEvent;

import septagram.Theomachy.Ability.Ability;
import septagram.Theomachy.DB.AbilityData;
import septagram.Theomachy.Handler.CommandModule.AbilitySet;
import septagram.Theomachy.Utility.ReturnAbilityName;

public class PokeGo extends Ability{

	private final static String[] des= {"������ �ɾ�ٴϸ� �ɷ��� ���� �� �ֽ��ϴ�.",
											  "10km(10000����)��ŭ ������ �������� �ɷ�",
											  "�� ���� �� �ֽ��ϴ�. (�̴� ������Ʈ�� �����մϴ�.)"};
	
	public PokeGo(String playerName) {
		super(playerName, "���ϸ��", 129, false, true, false, des);
		
		this.rank=3;
	}

	private int coolWalk=0;
	
	public void T_Passive(PlayerMoveEvent event) {
		
		if(coolWalk==10000) {
			
			Random r=new Random();
			
			int rn1=r.nextInt(3);
			
			if(rn1==0) {
				int ar=r.nextInt(AbilityData.GOD_ABILITY_NUMBER);
				AbilitySet.abiltiyAssignment(ar+1, playerName, event.getPlayer());
				event.getPlayer().sendMessage(ChatColor.YELLOW+" �� ��  "+ChatColor.WHITE+"�� �� �ȱ⿡ �����߽��ϴ�!  "+ChatColor.YELLOW+" �� ��");
				event.getPlayer().sendMessage(ChatColor.AQUA+ReturnAbilityName.name(ar)+ChatColor.WHITE+"!! �ʷ� ���ߴ�!!");
				event.getPlayer().sendMessage("�ɷ��� �Ҵ�Ǿ����ϴ�. /t help�� �ɷ��� Ȯ���غ�����.");
			}else if(rn1==1){
				int ar=r.nextInt(AbilityData.HUMAN_ABILITY_NUMBER);
				AbilitySet.abiltiyAssignment(ar+101, playerName, event.getPlayer());
				event.getPlayer().sendMessage(ChatColor.YELLOW+" �� ��  "+ChatColor.WHITE+"�� �� �ȱ⿡ �����߽��ϴ�!  "+ChatColor.YELLOW+" �� ��");
				event.getPlayer().sendMessage(ChatColor.AQUA+ReturnAbilityName.name(ar+101)+ChatColor.WHITE+"!! �ʷ� ���ߴ�!!");
				event.getPlayer().sendMessage("�ɷ��� �Ҵ�Ǿ����ϴ�. /t help�� �ɷ��� Ȯ���غ�����.");
			}else{
				int ar=r.nextInt(AbilityData.HOBOT_ABILITY_NUMBER);
				AbilitySet.abiltiyAssignment(ar+201, playerName, event.getPlayer());
				event.getPlayer().sendMessage(ChatColor.YELLOW+" �� ��  "+ChatColor.WHITE+"�� �� �ȱ⿡ �����߽��ϴ�!  "+ChatColor.YELLOW+" �� ��");
				event.getPlayer().sendMessage(ChatColor.AQUA+ReturnAbilityName.name(ar+201)+ChatColor.WHITE+"!! �ʷ� ���ߴ�!!");
				event.getPlayer().sendMessage("�ɷ��� �Ҵ�Ǿ����ϴ�. /t help�� �ɷ��� Ȯ���غ�����.");
			}
			
		}else {
			
			coolWalk++;
			
		}
		
	}
	
	public void conditionSet(){
		this.coolWalk=0;
	}
	
}
