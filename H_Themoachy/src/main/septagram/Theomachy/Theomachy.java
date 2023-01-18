package septagram.Theomachy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;

import septagram.Theomachy.DB.AbilityData;
import septagram.Theomachy.DB.GameData;
import septagram.Theomachy.DB.PluginData;
import septagram.Theomachy.Handler.CommandModule.Blacklist;
import septagram.Theomachy.Manager.CommandManager;
import septagram.Theomachy.Manager.EventManager;
import septagram.Theomachy.Timer.CoolTime;

public class Theomachy extends JavaPlugin
{
	public static boolean INVENTORY_CLEAR = true;
	public static boolean GIVE_ITEM = true;
	public static boolean IGNORE_BED = true;
	public static boolean ENTITIES_REMOVE = true;
	public static boolean AUTO_SAVE = false;
	public static boolean ANIMAL = true;
	public static boolean MONSTER = true;
	public static boolean FAST_START = false;
	public static int DIFFICULTY = 1;
	
	public CommandManager cm;
	public static Logger log=Bukkit.getLogger();
	
	public File file=new File(getDataFolder(), "blacklist.yml");
	
	public void onEnable()
	{
		
		UpdateChecker.check(this.getDescription().getVersion());
		
		log.info("[�ŵ��� ����] �÷������� Ȱ��ȭ�Ǿ����ϴ�.   "+PluginData.buildnumber+"  "+PluginData.version);
		log.info("[�ŵ��� ����] �÷������� �⺻ ������ ���� ���Դϴ�.");
		
		saveResource("blacklist.yml", true);
		
		cm=new CommandManager(this);
		ShapedRecipe recipe = new ShapedRecipe(new ItemStack(Material.BLAZE_ROD)).shape(new String[]{" A "," A "," A "}).setIngredient('A', Material.STICK);
		getServer().addRecipe(recipe);
		getServer().getPluginManager().registerEvents(new EventManager(), this);
		FileInputStream fis;
		InputStreamReader isr;
		BufferedReader br;
		try {
			fis = new FileInputStream(file);
			isr=new InputStreamReader(fis);
			br=new BufferedReader(isr);
			String line;
			while((line=br.readLine())!=null){
				Blacklist.Blacklist.add(Integer.parseInt(line));
			}
		}catch(FileNotFoundException e) {} catch (IOException e) {}
		
		for(int i=1;i<=AbilityData.GOD_ABILITY_NUMBER;i++) {
			if(!Blacklist.Blacklist.contains(i)) Blacklist.GodCanlist.add(i);
		}for(int i=101;i<=AbilityData.HUMAN_ABILITY_NUMBER+100;i++) {
			if(!Blacklist.Blacklist.contains(i)) Blacklist.HumanCanlist.add(i);
		}for(int i=201;i<=AbilityData.HOBOT_ABILITY_NUMBER+200;i++) {
			if(!Blacklist.Blacklist.contains(i)) Blacklist.DLCCanlist.add(i);
		}
		
		log.info("[�ŵ��� ����] ��ϵ� �ɷ�");
		log.info("[�ŵ��� ����] ��: "+Blacklist.GodCanlist.size()+", �ΰ�: "+Blacklist.HumanCanlist.size()+", DLC: "+Blacklist.DLCCanlist.size());
		log.info("[�ŵ��� ����] ����: "+String.valueOf(Blacklist.GodCanlist.size()+Blacklist.HumanCanlist.size()+Blacklist.DLCCanlist.size()));
		
		log.info("[�ŵ��� ����] ������ ���� �ҷ����� ���Դϴ�.");
		getConfig().options().copyDefaults(true);
		saveConfig();
		INVENTORY_CLEAR = getConfig().getBoolean("Inventory Clear");
		GIVE_ITEM = getConfig().getBoolean("Give Skyblock Item");
		ENTITIES_REMOVE = getConfig().getBoolean("Remove Entity");
		IGNORE_BED = getConfig().getBoolean("Ignore Bed");
		AUTO_SAVE = getConfig().getBoolean("Server Auto Save");
		ANIMAL = getConfig().getBoolean("Spawn Animal");
		MONSTER = getConfig().getBoolean("Spawn Monster");
		DIFFICULTY = getConfig().getInt("Difficulty");
		FAST_START=getConfig().getBoolean("Fast Start");
		
		log.info("[�ŵ��� ����] ========================================");
		log.info("[�ŵ��� ����] ���� ���� �� �κ��丮 Ŭ���� : "+String.valueOf(INVENTORY_CLEAR));
		log.info("[�ŵ��� ����] ���� ���� �� ��ī�̺� �⺻ ������ ���� : "+String.valueOf(GIVE_ITEM));
		log.info("[�ŵ��� ����] ���� ���� �� ����,����,�����ۻ��� : "+String.valueOf(ENTITIES_REMOVE));
		log.info("[�ŵ��� ����] ������ �� ħ�� ���� : "+String.valueOf(IGNORE_BED));
		log.info("[�ŵ��� ����] ���� ����: "+String.valueOf(FAST_START));
		log.info("[�ŵ��� ����] ���� �ڵ����� : "+String.valueOf(AUTO_SAVE));
		log.info("[�ŵ��� ����] ���� ���� : "+String.valueOf(ANIMAL));
		log.info("[�ŵ��� ����] ���� ���� : "+String.valueOf(MONSTER));
		log.info("[�ŵ��� ����] ���̵� : "+String.valueOf(DIFFICULTY));
		log.info("[�ŵ��� ����] ========================================");
	
		Bukkit.getConsoleSender().sendMessage("������: "+ChatColor.WHITE+"ĥ����(septagram) "+ChatColor.GRAY+"�������: "+ChatColor.AQUA+"�÷θ���(humint2003)");
		CoolTime ct = new CoolTime();
		ct.runTaskTimer(this, 0, 20L);
		try {
			for(Player p:Bukkit.getOnlinePlayers()) {
				GameData.OnlinePlayer.put(p.getName(), p);
			}
		}catch(NullPointerException e) {}
		
	}
	
	public void onDisable() {
		BufferedWriter bw;
		try {
			bw=new BufferedWriter(new FileWriter(file));
			
			for(int i:Blacklist.Blacklist) {
				bw.write(String.valueOf(i)); bw.newLine();
			}
			
			bw.close();
		}catch(FileNotFoundException e) { e.printStackTrace(); } catch (IOException e) { e.printStackTrace(); }
		
		
		log.info("[�ŵ��� ����] ������Ʈ�� ���Ϸ� ����Ǿ����ϴ�. ����� �÷����� ���� ���� blacklist.yml�� �ǵ��� ���ʽÿ�.");
		
	}
	
}
