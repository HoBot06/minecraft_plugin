package septagram.Theomachy.Message;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import septagram.Theomachy.DB.GameData;


public class T_Message
{
	public static void CoolTimeTeller(Player player, int abilityCase, int cool)
	{
		switch(abilityCase)
		{
		case 0:
			player.sendMessage("���� ���ð� : "+cool+"��");
			break;
		case 1:
			player.sendMessage(ChatColor.AQUA+"[�Ϲ�]  "+ChatColor.WHITE+"���� ���ð� : "+cool+"��");
			break;
		case 2:
			player.sendMessage(ChatColor.RED+"[���]  "+ChatColor.WHITE+"���� ���ð� : "+cool+"��");
			break;
		}
	}

	
	public static void CoolTimeCountTeller(int switcher ,String playerName, int cool)
	{
		Player player = GameData.OnlinePlayer.get(playerName);
		if (player != null)
		{
			switch(switcher)
			{
			case 0:
				player.sendMessage(cool+"�� ��");
				break;
			case 1:
				player.sendMessage(ChatColor.AQUA+"[�Ϲ�]  "+ChatColor.WHITE+cool+"�� ��");
				break;
			case 2:
				player.sendMessage(ChatColor.RED+"[���]  "+ChatColor.WHITE+cool+"�� ��");
				break;
			}
		}
	}
	
	public static void AbilityReset(int switcher ,String playerName)
	{
		Player player = GameData.OnlinePlayer.get(playerName);
		if (player != null)
		{
			switch(switcher)
			{
			case 0:
				player.sendMessage(ChatColor.GOLD+"�ɷ��� �ٽ� ����� �� �ֽ��ϴ�.");
				break;
			case 1:
				player.sendMessage(ChatColor.AQUA+"[�Ϲ�]  "+ChatColor.GOLD+"�ɷ��� �ٽ� ����� �� �ֽ��ϴ�.");
				break;
			case 2:
				player.sendMessage(ChatColor.RED+"[���]  "+ChatColor.GOLD+"�ɷ��� �ٽ� ����� �� �ֽ��ϴ�.");
				break;
			}
		}
	}

	public static void Skill_Used(Player player, int abilityCase)
	{
		switch(abilityCase)
		{
		case 0:
			player.sendMessage(ChatColor.YELLOW+"�ɷ��� ����Ͽ����ϴ�!");
			break;
		case 1:
			player.sendMessage(ChatColor.AQUA+"[�Ϲ�]  "+ChatColor.YELLOW+"�ɷ��� ����Ͽ����ϴ�!");
			break;
		case 2:
			player.sendMessage(ChatColor.RED+"[���]  "+ChatColor.YELLOW+"�ɷ��� ����Ͽ����ϴ�!");
			break;
		}
	}
	
	public static void LackItemError(Player player, Material material, int stack)
	{
		switch(material)
		{
		case COBBLESTONE:
			player.sendMessage("�ں����� �����մϴ�.");
			player.sendMessage("�ʿ䰹�� : "+ChatColor.RED+stack);
			break;
		case ACACIA_PLANKS:
			player.sendMessage("������ ������ �����մϴ�.");
			player.sendMessage("�ʿ䰹�� : "+ChatColor.RED+stack);
			break;
		case BIRCH_PLANKS:
			player.sendMessage("������ ������ �����մϴ�.");
			player.sendMessage("�ʿ䰹�� : "+ChatColor.RED+stack);
			break;
		case CRIMSON_PLANKS:
			player.sendMessage("������ ������ �����մϴ�.");
			player.sendMessage("�ʿ䰹�� : "+ChatColor.RED+stack);
			break;
		case DARK_OAK_PLANKS:
			player.sendMessage("������ ������ �����մϴ�.");
			player.sendMessage("�ʿ䰹�� : "+ChatColor.RED+stack);
			break;
		case JUNGLE_PLANKS:
			player.sendMessage("������ ������ �����մϴ�.");
			player.sendMessage("�ʿ䰹�� : "+ChatColor.RED+stack);
			break;
		case MANGROVE_PLANKS:
			player.sendMessage("������ ������ �����մϴ�.");
			player.sendMessage("�ʿ䰹�� : "+ChatColor.RED+stack);
			break;
		case OAK_PLANKS:
			player.sendMessage("������ ������ �����մϴ�.");
			player.sendMessage("�ʿ䰹�� : "+ChatColor.RED+stack);
			break;
		case SPRUCE_PLANKS:
			player.sendMessage("������ ������ �����մϴ�.");
			player.sendMessage("�ʿ䰹�� : "+ChatColor.RED+stack);
			break;
		case WARPED_PLANKS:
			player.sendMessage("������ ������ �����մϴ�.");
			player.sendMessage("�ʿ䰹�� : "+ChatColor.RED+stack);
			break;
		case IRON_INGOT:
			player.sendMessage("ö���� �����մϴ�.");
			player.sendMessage("�ʿ䰹�� : "+ChatColor.RED+stack);
			break;
		default:
			player.sendMessage("test");
			break;
		}
	}
	
	public static void TooFarError(Player player, int targetType)
	{
		switch(targetType)
		{
		case 0:
			player.sendMessage(ChatColor.RED+"������ �Ÿ��� �ʹ� �ٴϴ�.");
			break;
		case 1:
			player.sendMessage(ChatColor.RED+"Ÿ�ٰ� �Ÿ��� �ʹ� �ٴϴ�.");
			break;
		}
		
	}


	public static void PassiveEnable(Player player, int passiveCase)
	{
		switch(passiveCase)
		{
		case 0:
			player.sendMessage(ChatColor.YELLOW+"�ɷ��� Ȱ��ȭ �Ǿ����ϴ�.");
			break;
		}
		
	}
}
