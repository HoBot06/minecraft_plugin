package septagram.Theomachy.Ability.HUMAN;

import septagram.Theomachy.Theomachy;
import septagram.Theomachy.Ability.Ability;

public class Boxer extends Ability
{
	
	private final static String[] des= {"���� �ָ��� ����ϴ� �ɷ��Դϴ�.",
			   "����� ��Ŭ �Ƿ��� �����ּ���."};
	
	public Boxer(String playerName)
	{
		super(playerName,"����", 114, false, true, false, des);
		Theomachy.log.info(playerName+abilityName);
		
		this.rank=-1;
	}
	
}
