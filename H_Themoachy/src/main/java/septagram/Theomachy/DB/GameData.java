package septagram.Theomachy.DB;

import java.util.HashMap;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import septagram.Theomachy.Ability.Ability;

public class GameData
{
	public static HashMap<String,Player> OnlinePlayer = new HashMap<String,Player>(); //�¶����÷��̾�
	public static HashMap<String,Ability> PlayerAbility = new HashMap<String,Ability>(); //�÷��̾� ���� �ɷ�
	public static HashMap<String,String> PlayerTeam = new HashMap<String,String>(); //�÷��̾�, ���̸�
	public static HashMap<String,Location> SpawnArea = new HashMap<String,Location>(); //�� ���� ����
}
