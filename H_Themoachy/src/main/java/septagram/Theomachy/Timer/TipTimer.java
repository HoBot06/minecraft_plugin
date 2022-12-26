package septagram.Theomachy.Timer;

import java.util.TimerTask;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.scheduler.BukkitRunnable;

import septagram.Theomachy.Theomachy;
import septagram.Theomachy.DB.AbilityData;
import septagram.Theomachy.DB.PluginData;
import septagram.Theomachy.Handler.CommandModule.GameHandler;

public class TipTimer extends BukkitRunnable
{
	int count=1;
	
	public void run()
	{
		if (!GameHandler.Ready)
			this.cancel();
		if (count%75 == 0)
		{
			if (Theomachy.AUTO_SAVE)
			{
				Bukkit.getServer().savePlayers();
				Theomachy.log.info("[�ŵ�������] ���似�̺� �Ϸ�");
			}
			switch(count)
			{
			case 75:
				Bukkit.broadcastMessage(ChatColor.YELLOW+"[ Tip ]");
				Bukkit.broadcastMessage("�ɷ��� ũ�� ��Ƽ��,�нú�(����) �ɷ����� �����ϴ�");
				Bukkit.broadcastMessage("�нú� �ɷ��� �׻� Ȥ�� Ư�� ���ǽ� Ȱ��ȭ �Ǹ� ��Ƽ��ɷ��� ������ε� �Ǵ� �ɷ¼��� ���� ���������� ��� �� �� �ֽ��ϴ�.");
				Bukkit.broadcastMessage("�ɷ� �ߵ� ������ ���� �ɷ��� ������ �ε带 �̿��ؼ� ��� �� �� �ֽ��ϴ�.");
				Bukkit.broadcastMessage("������ �ε�� ��������� 3���� ũ������ �ڽ��� ���� �Ϸķ� �����ø� ������ �� �ֽ��ϴ�.");
				break;
			case 150:
				Bukkit.broadcastMessage(ChatColor.YELLOW+"[ Tip ]");
				Bukkit.broadcastMessage("�ŵ��� ���� �÷������� ��ī�̺� �������� ������� �÷������Դϴ�.");
				Bukkit.broadcastMessage("�߻�, �ϵ��ھ�(�ѹ������� ��) ���� �������մϴ�.");
				break;
			case 225:
				Bukkit.broadcastMessage(ChatColor.YELLOW+"[ Tip ]");
				Bukkit.broadcastMessage("�ɷ��� ũ�� Active, Passive�� ������ Active���� "+
										ChatColor.AQUA+"[�Ϲ�]"+ChatColor.WHITE+"�ɷ°� "+ChatColor.RED+"[���]"+ChatColor.WHITE+"�ɷ��� �ֽ��ϴ�.\n"+
										"��κ� "+ChatColor.AQUA+"[�Ϲ�]"+ChatColor.WHITE+"�ɷ��� ��Ŭ���̸� "+ChatColor.RED+"[���]"+ChatColor.WHITE+"�ɷ��� ��Ŭ���Դϴ�.");
				break;
			case 300:
				Bukkit.broadcastMessage(ChatColor.YELLOW+"[ Tip ]");
				Bukkit.broadcastMessage("�ο��� ���� ���� �дٸ� ���� �޸𸮸� ����(2G �̻�) ����ּ���.");
				Bukkit.broadcastMessage("�޸𸮻���� ������ ������ �ñ�����ֽ��ϴ�.");
				break;
			case 375:
				Bukkit.broadcastMessage(ChatColor.YELLOW+"[ Tip ]");
				Bukkit.broadcastMessage("���� ���� ������ ���� �ɷ��� ������ �ν��Ͽ� �����ϴ� ��찡 �ֽ��ϴ�.");
				Bukkit.broadcastMessage("��Ȱ�� ���� �÷��̸� ���� ��Ŷ �ֽŹ����� ������ּ���");
				Bukkit.broadcastMessage("�������� ��Ŷ�� �ɷ��� ������ ������ ű�� �� ���� �ֽ��ϴ�.");
				break;
			case 450:
				Bukkit.broadcastMessage(ChatColor.YELLOW+"[ Tip ]");
				Bukkit.broadcastMessage("��? �������� ��� �ɷ��� ����ߴµ� �ں��游 ������� �������� ���ݾ�? �̷� ������ X");
				Bukkit.broadcastMessage("���� ���ð� ������ �غ�����.. ��Ŷ ��ü �����Դϴ�. ��");
				Bukkit.broadcastMessage("��� �ɷ��� �ڽ��� ��ġ�� �������� �������� �����Դϴ�. �����ϼ���.");
				break;
			case 525:
				Bukkit.broadcastMessage(ChatColor.YELLOW+"[ Tip ]");
				Bukkit.broadcastMessage("�÷��̾� �̸��� ������� ���� [Tab] Ű�� �����ø� �̸��� ��ü�� �����ϴ�.");
				Bukkit.broadcastMessage("��) sept > [Tab] > Septagram");
				break;
			case 600:
				Bukkit.broadcastMessage(ChatColor.YELLOW+"[ Tip ]");
				Bukkit.broadcastMessage(ChatColor.RED+"�ŵ��� ���� (Theomachy)");
				Bukkit.broadcastMessage("����  : "+PluginData.version);
				Bukkit.broadcastMessage("����  : "+PluginData.buildnumber);
				Bukkit.broadcastMessage("������  : ĥ����(septagram)");
				Bukkit.broadcastMessage(ChatColor.GREEN+"http://blog.naver.com/septagram/");
				break;
			case 675:
				Bukkit.broadcastMessage(ChatColor.YELLOW+"[ Tip ]");
				Bukkit.broadcastMessage("���� ��ϵ� �ɷ��� "+AbilityData.ABILITY_NUMBER+" �� �Դϴ�.");
				Bukkit.broadcastMessage("���� ���� �ɷ��� "+AbilityData.GOD_ABILITY_NUMBER+" �� �̸�");
				Bukkit.broadcastMessage("�ΰ��� �ɷ��� "+AbilityData.HUMAN_ABILITY_NUMBER+" �� �Դϴ�.");
				Bukkit.broadcastMessage("DLC �ɷ��� "+AbilityData.HOBOT_ABILITY_NUMBER+" �� �Դϴ�.");
				break;
			case 750:
				Bukkit.broadcastMessage(ChatColor.YELLOW+"[ Tip ]");
				Bukkit.broadcastMessage("�� ���������� ������� �����ϴ�.");
				Bukkit.broadcastMessage("���� �ν��� ��� ���߿��� �����Ǿ� ��Ȱ���ڸ��� ������ �״� ��Ȳ�� �߻� �� �� �ֽ��ϴ�.");
				break;
			case 825:
				Bukkit.broadcastMessage(ChatColor.YELLOW+"[ Tip ]");
				Bukkit.broadcastMessage("��ī�� �������� â�� ������ �ں��� �����⸦ �� ����°� ���Դϴ�.");
				Bukkit.broadcastMessage("�ں��� ������� ���(1�ο�) ����(2�ο�), �ѹ��� 8���� Ķ �� �ִ� ��Ÿ�� �ֽ��ϴ�.");
				break;
			case 900:
				Bukkit.broadcastMessage(ChatColor.YELLOW+"[ Tip ]");
				Bukkit.broadcastMessage("�������� â�� ������ �ֿ켱������ �սô�.");
				Bukkit.broadcastMessage("â�� �׷��� ���ϸ� �ƹ��� ��޴ɷ��̶� �¸��ϱⰡ ���� �ʽ��ϴ�.");
				Bukkit.broadcastMessage("�ɷ��������� ��ź������ ���ϴ� ��Ȳ�� ���� �˴ϴ�");
				break;
			case 975:
				Bukkit.broadcastMessage(ChatColor.YELLOW+"[ Tip ]");
				Bukkit.broadcastMessage("��κ��� �нú� �ɷ��� ���� ������� �󼺰��谡 �ֽ��ϴ�.");
				Bukkit.broadcastMessage("����ϼҽ� > ���� > ���Ľ�");
				break;
			case 1050:
				Bukkit.broadcastMessage(ChatColor.YELLOW+"[ Tip ]");
				Bukkit.broadcastMessage("��Ʈ���� ������ �ظ��� S��ũ ȿ���� �Ѵ� �ɷµ����ֽ��ϴ�. ��ũ�� ���ٰ� �Ǹ�����������.");
				break;
			case 1125:
				Bukkit.broadcastMessage(ChatColor.YELLOW+"[ Tip ]");
				Bukkit.broadcastMessage("�÷������� �̿��� ������ �������� ����� ������ �䱸�մϴ�.");
				Bukkit.broadcastMessage("�÷��� �ϴ� �ο����� ���ٸ� ������ �������� �ο����� �����ÿ��� ����� ��ǻ�Ϳ��� ������ �����°��� ��õ���� �ʽ��ϴ�.");
				break;
			case 1200:
				Bukkit.broadcastMessage(ChatColor.YELLOW+"[ Tip ]");
				Bukkit.broadcastMessage("�÷����� ���ۿ� ������ �ֽ� �е�");
				Bukkit.broadcastMessage("�ҽ� ���� �� ���� : ���� (���� ��� �����մϴ�.)");
				Bukkit.broadcastMessage("�׽��� : Headings, Patrasue, raito_, ������, ������, �ط��� �׿�...");
				break;
			case 1275:
				Bukkit.broadcastMessage(ChatColor.YELLOW+"[ Tip ]");
				Bukkit.broadcastMessage("�Ű� �ΰ� �ɷ��� ���̴�");
				Bukkit.broadcastMessage("�̸� ��.");
				Bukkit.broadcastMessage("������ �ΰ��� ���� �ɷ��� ���� ��쵵 �ֽ��ϴ�. ���� �ƴ϶�� �ؼ� �Ǹ�����������.");
				break;
			case 1350:
				Bukkit.broadcastMessage(ChatColor.YELLOW+"[ Tip ]");
				Bukkit.broadcastMessage("���Դϴ� �����մϴ�");
				break;
			case 1425:
				Bukkit.broadcastMessage(ChatColor.YELLOW+"[ Tip ]");
				Bukkit.broadcastMessage("(�ɷ�) ũ���ۿ��� ���� ��� �� �����ϼ��� ");
				Bukkit.broadcastMessage("���߷��� �ι�� �þ�ϴ�.");
				break;
			case 1500:
				Bukkit.broadcastMessage(ChatColor.YELLOW+"[ Tip ]");
				Bukkit.broadcastMessage("������ ���� �� �ֽ��ϴ�.");
				break;
			case 1575:
				Bukkit.broadcastMessage(ChatColor.YELLOW+"[ Tip ]");
				Bukkit.broadcastMessage("����� �ð��Դϴ�.");
				break;
			case 1650:
				Bukkit.broadcastMessage(ChatColor.YELLOW+"[ Tip ]");
				Bukkit.broadcastMessage("������ �ٿ�Ǹ� �ɷµ� �ٿ�˴ϴ�. �����ϼ���");
				break;
			case 1725:
				Bukkit.broadcastMessage(ChatColor.YELLOW+"[ Tip ]");
				Bukkit.broadcastMessage("������ : ĥ����");
				Bukkit.broadcastMessage("���� �ҽ� : �÷θ���");
				Bukkit.broadcastMessage("�� ������ : ȣ��");
				break;
			case 1800:
				Bukkit.broadcastMessage(ChatColor.YELLOW+"[ Tip ]");
				Bukkit.broadcastMessage("�÷������� ���� ������ ������ ������ �ö󰩴ϴ�. ����");
				break;
			case 1875:
				Bukkit.broadcastMessage(ChatColor.YELLOW+"[ Tip ]");
				Bukkit.broadcastMessage("���̾� ���� �� ��̷� ĳ�� �ӵ��� ������ ĳ�¼ӵ��� �����մϴ�.");
				break;
			case 1950:
				Bukkit.broadcastMessage(ChatColor.YELLOW+"[ Tip ]");
				Bukkit.broadcastMessage("�÷��� �Ͻô� ��� �е鿡�� ���� �����帳�ϴ�.");
				Bukkit.broadcastMessage("��հ� �÷��� �� �ּ���.");				
				count=1;
				break;
			}
		}
		if (count%180 == 0)
		{
			long max = (int) (Runtime.getRuntime().maxMemory() / 1048576);
			long free = (int) (Runtime.getRuntime().freeMemory() / 1048576);
			long use = max - free;
			Bukkit.broadcastMessage(ChatColor.WHITE+"�޸�(MB)   "+ChatColor.AQUA+String.valueOf(use)+ChatColor.WHITE+" / "+ChatColor.YELLOW+String.valueOf(max));
			
			if (free < 375)
			{
				System.out.println("�޸� ����, �޸� û����...");
				System.gc();
				long free2 = (Runtime.getRuntime().freeMemory() / 1048576);
				System.out.println("���� ��� ���� �޸� : "+free2+"MB");
			}
		}
		count++;
	}
}
