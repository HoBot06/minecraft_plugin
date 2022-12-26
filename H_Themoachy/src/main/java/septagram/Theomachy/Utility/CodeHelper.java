package septagram.Theomachy.Utility;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import septagram.Theomachy.Theomachy;
import septagram.Theomachy.DB.AbilityData;

public class CodeHelper
{

	public static void ShowAbilityCodeNumber(CommandSender sender)
	{
		if (sender instanceof Player)
			showCode(sender);
		else
			Theomachy.log.info("�� ��ɾ�� ���ӿ��� ������ �ֽʽÿ�.");
	}
	
	private static void showCode(CommandSender sender)
	{
		
		sender.sendMessage(ChatColor.GOLD+" �� �� �� ");
		
		for(int i=1;i<=AbilityData.GOD_ABILITY_NUMBER;i++) {
			sender.sendMessage(ChatColor.YELLOW + "�� "+i+" ��"+ChatColor.WHITE+ReturnAbilityName.name(i));
		}
		
		sender.sendMessage(ChatColor.AQUA+" �� �ΰ� �� ");
		
		for(int i=101;i<=AbilityData.HUMAN_ABILITY_NUMBER+100;i++) {
			sender.sendMessage(ChatColor.YELLOW + "�� "+i+" ��"+ChatColor.WHITE+ReturnAbilityName.name(i));
		}
		
		sender.sendMessage(ChatColor.AQUA+" �� DLC �� ");
		
		for(int i=201;i<=AbilityData.HOBOT_ABILITY_NUMBER+200;i++) {
			sender.sendMessage(ChatColor.YELLOW + "�� "+i+" ��"+ChatColor.WHITE+ReturnAbilityName.name(i));
		}
		
	}
	
}
