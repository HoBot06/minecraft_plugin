package septagram.Theomachy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class UpdateChecker {
	
	public static void check(String thisVersion){
		try{
			URL u=new URL("https://raw.githubusercontent.com/plo-delta/PLODELTA/master/README.md");
			InputStreamReader isr=new InputStreamReader(u.openStream());
			BufferedReader br=new BufferedReader(isr);
			
			String Line;
			
			while((Line=br.readLine())!=null){
				if(Line.startsWith("Theomachy:")){
					Bukkit.getServer().getConsoleSender().sendMessage("[�ŵ��� ����] "+ChatColor.AQUA+"�ֽ� ������ "+Line.replace("Theomachy:", "")+"�Դϴ�.");
					if(Line.replace("Theomachy:", "").equals(thisVersion)){
						Bukkit.getServer().getConsoleSender().sendMessage("[�ŵ��� ����] "+ChatColor.AQUA+"�ֽ� �����Դϴ�!");
					}else{
						Bukkit.getServer().getConsoleSender().sendMessage("[�ŵ��� ����] "+ChatColor.RED+"�� �����Դϴ�. ������ ��α׿��� �ֽ� ������ �ٿ� ��������.");
						Bukkit.getConsoleSender().sendMessage("[�ŵ��� ����] ������ ��α�: http://blog.naver.com/humint2003");
					}
				}
			}
		}catch(Exception e){
			Bukkit.getServer().getConsoleSender().sendMessage("[�ŵ��� ����] "+ChatColor.RED+"������Ʈ üũ�� �����߽��ϴ�...");
		}
	}	
}